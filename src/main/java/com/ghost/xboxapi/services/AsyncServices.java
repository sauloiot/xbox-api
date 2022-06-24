package com.ghost.xboxapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
@EnableAsync
public class AsyncServices {
    @Autowired
    private JavaMailSender emailSender;

    @Async
    public void asyncEmailSender(MimeMessage mimeMessage) {
        emailSender.send(mimeMessage);
    }

}
