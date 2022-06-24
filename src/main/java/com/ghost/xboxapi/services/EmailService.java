package com.ghost.xboxapi.services;

import com.ghost.xboxapi.models.Alerta;
import com.ghost.xboxapi.models.Email;
import com.ghost.xboxapi.models.dtos.EmailAlertasDto;
import com.ghost.xboxapi.models.enums.StatusEmailEnum;
import com.ghost.xboxapi.models.enums.TemplateHtmlEnum;
import com.ghost.xboxapi.repository.EmailRepository;
import com.ghost.xboxapi.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableAsync
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private AsyncServices asyncServices;
    @Value("${spring.mail.username}")
    private String defaultEmail;

    public void sendEmailListaJogos(List<Alerta> alertas) {
        EmailAlertasDto emailAlertasDto = new EmailAlertasDto();
        emailAlertasDto.setAlertas(alertas);
        emailAlertasDto.setEmailTo("saulo.11@hotmail.com");
        emailAlertasDto.setOwnerRef("Saulo");
        emailAlertasDto.setData(alertas.stream().findFirst().get().getDataAlerta());
        sendEmailListaJogos(emailAlertasDto);

    }

    public Email sendEmailListaJogos(EmailAlertasDto emailAlertasDto) {
        Email email = new Email();
        email.getProps().put("nome", emailAlertasDto.getOwnerRef());
        email.getProps().put("alertas", emailAlertasDto.getAlertas());
        email.getProps().put("data", Utils.getDataConvertida(emailAlertasDto.getData()));
        email.setSubject("Olá " + emailAlertasDto.getOwnerRef() + ", Esta é sua lista de jogos de: " + Utils.getDataConvertida(emailAlertasDto.getData()));
        email.setEmailFrom(defaultEmail);
        email.setEmailTo(emailAlertasDto.getEmailTo());
        email.setOwnerRef(emailAlertasDto.getOwnerRef());
        email.setTemplateHtml(TemplateHtmlEnum.LISTA_JOGOS.getArquivo());

        addToQueueEMailHtml(email);

        return email;
    }

    public void addToQueueEMailHtml(Email email) {
        email.setCreatedAt(LocalDateTime.now());
        // Prepare the evaluation context
        Context context = new Context();
        context.setVariables(email.getProps());
        final String htmlContent = this.templateEngine.process(email.getTemplateHtml(), context);

        email.setText(htmlContent);
        email.setStatusEmail(StatusEmailEnum.WAITING);

        emailSendAssembler(emailRepository.save(email));
    }

    public void emailSendAssembler(Email email) {
        try {
            // Prepare message using a Spring helper
            final MimeMessage mimeMessage = this.emailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
            message.setSubject(email.getSubject());
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());

            // Create the HTML body using Thymeleaf
            message.setText(email.getText(), true /* isHtml */);
            // Send email
            asyncServices.asyncEmailSender(mimeMessage);

        } catch (MessagingException e) {
            e.getMessage();
        } finally {
            email.setSendDateEmail(LocalDateTime.now());
            email.setStatusEmail(StatusEmailEnum.SENT);
            emailRepository.save(email);
        }
    }
}
