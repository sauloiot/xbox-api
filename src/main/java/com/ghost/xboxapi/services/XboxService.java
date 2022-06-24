package com.ghost.xboxapi.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ghost.xboxapi.feignclients.XboxFeignClient;
import com.ghost.xboxapi.models.*;
import com.ghost.xboxapi.models.dtos.JogoResumoDTO;
import com.ghost.xboxapi.models.fromXbox.Product;
import com.ghost.xboxapi.models.fromXbox.Root;
import com.ghost.xboxapi.repository.*;
import com.ghost.xboxapi.utils.RetryUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class XboxService {
    @Autowired
    private XboxFeignClient xboxFeignClient;
    @Autowired
    private JogoRepository jogoRepository;
    @Autowired
    private HistoricoPrecoRepository historicoPrecoRepository;
    @Autowired
    private HistoricoPrecoBaseRepository historicoPrecoBaseRepository;
    @Autowired
    private AlertaRepository alertaRepository;
    @Autowired
    private ExecucoesRepository execucoesRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private FileService fileService;

    private static String COUNT_UPDATED_JOGOS = "count_updated_jogos";

//    21600000 ms = 6 horas
    private static final Integer TEMPO_EXECUCAO_ANALISE_LOJA = 21600000;

    private static final Integer NUMERO_TENTATIVAS = 10;

    private static final Long TEMPO_DE_ESPERA = 2000L;

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(XboxService.class);

    public Root getGames(String bigIds) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            AtomicReference<Object> object = new AtomicReference<>();
            RetryUtils.retry(() -> {
                object.set(xboxFeignClient.getGames(bigIds));
            }, "Erro ao consultas ProductIds: " + bigIds, NUMERO_TENTATIVAS, TEMPO_DE_ESPERA);
            String rootJsonString = mapper.writeValueAsString(object);
            Root rootClassInstance = mapper.readValue(rootJsonString, Root.class);
            return rootClassInstance;
        } catch (JsonProcessingException e) {
            System.out.println("getGames ERRO:" + e);
        }
        return null;
    }

    public Product getJogoUnico(String bigIds) {
        return getGames(bigIds).products.get(0);
    }

    public void verificarJogosPreco() {
        Page<Jogo> jogosPaginados = jogoRepository.findAll(PageRequest.of(0, 20, Sort.by("id").ascending()));
        verificarJogos(jogosPaginados.getContent());
        LOGGER.info("Pagina: " + 0 + "/" + jogosPaginados.getTotalPages() + " verificada");
        int qntPages = jogosPaginados.getTotalPages();
        int i = 0;
        while(i <= qntPages){
            jogosPaginados = jogoRepository.findAll(jogosPaginados.nextOrLastPageable());
            verificarJogos(jogosPaginados.getContent());
            LOGGER.info("Pagina: " + i + "/" + jogosPaginados.getTotalPages() + " verificada");
            i = i + 1;
        }
    }

    private void verificarJogos(List<Jogo> jogosFromDatabase) {
        List<String> productsIds = jogosFromDatabase.stream().map(Jogo::getProductId).toList();
        if (productsIds.isEmpty()) {
            CacheService.putIntegerCache(COUNT_UPDATED_JOGOS, 0);
            return;
        }
        Root jogosFromXboxApi = getGames(getStringBuilder(productsIds));
        List<Product> products = jogosFromXboxApi.products;

        List<Alerta> alertas = updateGames(jogosFromDatabase, products);
        if (!alertas.isEmpty()) {
            try {
                emailService.sendEmailListaJogos(alertas);
            } catch (Exception e) {
                System.out.println("verificarJogos ERRO:" + e);
            }
        }
    }

    private List<Alerta> updateGames(List<Jogo> jogosFromDatabase, List<Product> products) {
        List<Alerta> alertas = new ArrayList<>();
        for (Product product: products) {
            for (Jogo jogo: jogosFromDatabase) {
                if (jogo.getProductId().toLowerCase(Locale.ROOT).equals(product.productId.toLowerCase(Locale.ROOT))) {
                    Alerta check = checkPreco(product, jogo);
                    if (check != null && check.getId() != null) {
                        alertas.add(check);
                    }
                }
            }
        }
        Integer contagem = alertas.isEmpty() ? 0 : alertas.size();
        CacheService.putIntegerCache(COUNT_UPDATED_JOGOS, contagem);
        return alertas;
    }

    private Alerta checkPreco(Product product, Jogo jogo) {
        Alerta alertaRetorno = null;
        double precoAlvoJogoDb = jogo.getPrecoAlvo();
        double porcentagemDesconto = jogo.getPorcentagemDesconto();
        double precoBaseJogo = jogo.getPrecoBase();
        double precoAtualJogo = jogo.getPrecoAtual();

        double precoAtualLojaXbox = product.displaySkuAvailabilities.get(0).availabilities.get(0).orderManagementData.price.listPrice;
        double precoBaseAtualLojaXbox = product.displaySkuAvailabilities.get(0).availabilities.get(0).orderManagementData.price.mSRP;

        boolean precoAlvoAtingido = precoAlvoJogoDb >= precoAtualLojaXbox;
        double precoComPorcentagem = ((100 - porcentagemDesconto) * 0.01) * precoBaseAtualLojaXbox;
        boolean descontoAtingido = precoComPorcentagem >= precoAlvoJogoDb;

        boolean precoModificado = false;

        if (precoBaseJogo != precoBaseAtualLojaXbox) {
            HistoricoPrecoBase historicoPrecoBase = new HistoricoPrecoBase();
            historicoPrecoBase.setJogo(jogo);
            historicoPrecoBase.setData(new Date());
            historicoPrecoBase.setPreco(precoBaseAtualLojaXbox);
            historicoPrecoBaseRepository.save(historicoPrecoBase);
            jogo.setPrecoBase(precoBaseAtualLojaXbox);
            precoModificado = true;
        }
        if (precoAtualJogo != precoAtualLojaXbox) {
            HistoricoPreco historicoPreco = new HistoricoPreco();
            historicoPreco.setJogo(jogo);
            historicoPreco.setData(new Date());
            historicoPreco.setPreco(precoAtualLojaXbox);
            historicoPrecoRepository.save(historicoPreco);
            jogo.setPrecoAtual(precoAtualLojaXbox);
            precoModificado = true;

            if (descontoAtingido) {
                Alerta alerta = new Alerta();
                alerta.setJogo(jogo);
                alerta.setDataAlerta(new Date());
                alerta.setPrecoAtual(precoAtualLojaXbox);
                alerta.setPrecoAntigo(precoAtualJogo);
                alerta.setProductId(jogo.getProductId());
                alerta.setProductTitle(jogo.getProductTitle());
                alerta.setTipoAlerta(TipoAlerta.PRECO_ALVO);
                alertaRetorno = alertaRepository.save(alerta);
            }
            if (precoAlvoAtingido && Objects.isNull(alertaRetorno)) {
                Alerta alerta = new Alerta();
                alerta.setJogo(jogo);
                alerta.setDataAlerta(new Date());
                alerta.setPrecoAtual(precoAtualLojaXbox);
                alerta.setPrecoAntigo(precoAtualJogo);
                alerta.setProductId(jogo.getProductId());
                alerta.setProductTitle(jogo.getProductTitle());
                alerta.setTipoAlerta(TipoAlerta.PRECO_PORCENTAGEM);
                alertaRetorno = alertaRepository.save(alerta);
            }
        }

        if (precoModificado) {
            jogo.setUpdatedAt(new Date());
            jogoRepository.save(jogo);
        }

        return alertaRetorno;
    }

    private void setJogoFromProduct(Product product, Jogo jogo) {
        jogo.setDeveloperName(product.localizedProperties.get(0).developerName);
        jogo.setPublisherName(product.localizedProperties.get(0).publisherName);
        jogo.setPublisherWebsiteUri(product.localizedProperties.get(0).publisherWebsiteUri);
        jogo.setSupportUri(product.localizedProperties.get(0).supportUri);
        jogo.setImage("https:" + product.localizedProperties.get(0).images.get(0).uri);
        jogo.setProductTitle(product.localizedProperties.get(0).productTitle);
        jogo.setShortDescription(product.localizedProperties.get(0).shortDescription);
        jogo.setCurrencyCode(product.displaySkuAvailabilities.get(0).availabilities.get(0).orderManagementData.price.currencyCode);
        jogo.setPrecoAtual(product.displaySkuAvailabilities.get(0).availabilities.get(0).orderManagementData.price.listPrice);
        jogo.setPrecoBase(product.displaySkuAvailabilities.get(0).availabilities.get(0).orderManagementData.price.mSRP);
        jogo.setPrecoAlvo(10.00);
        jogo.setPorcentagemDesconto(90.0);
    }

    private String getStringBuilder(List<String> productIds) {
        int size = productIds.size();
        String ultimoId = productIds.get(size -1);
        StringBuilder productIdsBuild = new StringBuilder();
        for (String product: productIds) {
            productIdsBuild.append(product);
            if (!Objects.equals(product, ultimoId)) {
                productIdsBuild.append(",");
            }
        }
        return productIdsBuild.toString();
    }

    public List<JogoResumoDTO> saveJogosPorIdsProduto(String file) {
//        List<String> ids = Arrays.asList(productIds.split("\\s*,\\s*"));
//        List<String> idsSemDuplicados = new ArrayList<>(new HashSet<>(ids));
        List<String> idsFromArquivo = fileService.csvReader(file);
        List<String> idsSemDuplicados = new ArrayList<>(new HashSet<>(idsFromArquivo));

        List<Jogo> jogosToSave = new ArrayList<>();
        Integer i = 0;

        for (String id:idsSemDuplicados) {
            Jogo jogoDb = jogoRepository.findByProductId(id);
            if (ObjectUtils.isEmpty(jogoDb)) {
                Jogo jogo = new Jogo();
                jogo.setCreatedAt(new Date());
                jogo.setProductId(id);
                jogo.setFavorito(false);
                setJogoFromProduct(getJogoUnico(id), jogo);
                jogosToSave.add(jogo);
                i = i + 1;
                System.out.println("n°: " + i + " " + jogo.getProductTitle());
            }
        }
        System.out.println("processo finalizado");

        return resumirJogo(jogoRepository.saveAll(jogosToSave));
    }

    private List<JogoResumoDTO> resumirJogo(List<Jogo> jogos) {
        List<JogoResumoDTO> jogoResumoDTOS = new ArrayList<>();
        for (Jogo jogo: jogos) {
            JogoResumoDTO jogoResumoDTO = new JogoResumoDTO();
            jogoResumoDTO.setId(jogo.getId());
            jogoResumoDTO.setProductId(jogo.getProductId());
            jogoResumoDTO.setProductTitle(jogo.getProductTitle());
            jogoResumoDTOS.add(jogoResumoDTO);
        }
        return jogoResumoDTOS;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void executarAnaliseDaLoja() {
        boolean isRunning = true;
        try {
            while (isRunning) {
                Date inicioExecucao = new Date();
                LOGGER.info("==== Execução iniciada as " + inicioExecucao);
                verificarJogosPreco();
                Date fimExecucao = new Date();

                Integer jogosAtualizados = CacheService.getIntegerCache(COUNT_UPDATED_JOGOS);
                Execucao execucao = new Execucao();
                execucao.setInicioExecucao(inicioExecucao);
                execucao.setData(new Date());
                execucao.setJogosAtualizados(jogosAtualizados);
                execucao.setFimExecucao(fimExecucao);
                execucoesRepository.save(execucao);
                LOGGER.info("==== Execução finalizada as " + fimExecucao + " Jogos atualizados: " + jogosAtualizados);
                Thread.sleep(TEMPO_EXECUCAO_ANALISE_LOJA);
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

}
