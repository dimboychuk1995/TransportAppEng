package com.oblenergo.service;

import com.oblenergo.DTO.OrderDTO;
import com.oblenergo.model.Orders;

public interface MailService {

  void sendMail(OrderDTO orderDTO, Orders order, String email, String text);

  void sendMailOnlyPermit(Orders orders, String email, String text);

  void sendMailWithoutPDF(String email, String text);

}
