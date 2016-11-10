package com.oblenergo.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.oblenergo.model.Orders;

@Service
public class MailServiceImpl implements MailService {

  private static final Logger LOGGER = Logger.getLogger(MailServiceImpl.class);

  @Autowired
  ItextServiceImpl itextServiceImpl;

  @Autowired
  ApplicationContext appContext;

  @Autowired
  private MimeMessage mimeMessage;

  @Autowired
  private Environment environment;

  @Autowired
  private JavaMailSenderImpl senderImpl;

  @Override
  public void sendMail(Orders order, String email, String text) {

    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
      messageHelper.setFrom(environment.getRequiredProperty("mail.sender.address"));
      messageHelper.setTo(email);
      messageHelper.setText(text);
      messageHelper.addAttachment("rahunok.pdf", new ByteArrayResource(itextServiceImpl.writeCheck(order)));
      senderImpl.send(mimeMessage);
    } catch (MailException e) {
      LOGGER.error("Failure when sending the message", e);
    } catch (MessagingException e1) {
      LOGGER.error("There was a problem setting the sender address", e1);
    }
  }

}
