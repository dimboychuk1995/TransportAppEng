package com.oblenergo.service;

import com.oblenergo.model.Orders;

public interface MailService {

  void sendMail(Orders order, String email, String text);

}
