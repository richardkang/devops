package com.devopsbuddy.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractEmailService{

	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Autowired
    private MailSender mailSender;


    public void sendGenericEmailMessage(SimpleMailMessage message) {
        LOG.debug("Smtp an email service...");
        LOG.info(message.toString());
        mailSender.send(message);
        LOG.debug("Email sent.");
    }

}
