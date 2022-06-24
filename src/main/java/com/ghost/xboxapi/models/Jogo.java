package com.ghost.xboxapi.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "jogo")
public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private Date createdAt;
    private Date updatedAt;
    private String developerName;
    private String publisherName;
    private String publisherWebsiteUri;
    private String supportUri;
    private String image;
    private String productTitle;
    @Column(length = 2000)
    private String shortDescription;
    private String currencyCode;
    private double precoAtual;
    private double precoBase;
    private double precoAlvo;
    private double porcentagemDesconto;
    private Boolean favorito;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jogo")
    private List<HistoricoPreco> historicoPrecos = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jogo")
    private List<HistoricoPrecoBase> historicosPrecoBase = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "jogo")
    private List<Alerta> alertas = new ArrayList<>();

}
