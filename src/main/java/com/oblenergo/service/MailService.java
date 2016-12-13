package com.oblenergo.service;

import com.oblenergo.DTO.OrderDTO;

public interface MailService {

  void sendMail(OrderDTO order, String email, String text);

  void sendMailWithoutPDF(String email, String text);

}
