/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.service;

import java.util.List;

/**
 *
 * @author us9522
 */

import com.oblenergo.model.Orders;

public interface OrderService {

  public List<Orders> findAll();

  void save(Orders order);

  void update(Orders order);

  Orders findOrderById(int id);

  void delete(int id);

  List<Orders> findDateOfOrders(String date);

  List<String> findFreeTimeForAdmin(String[][] arrTimeOrders, String date, Orders order, String execution);

  List<Orders> findAllConfirm();

  String[][] getAllTimeOfOrders(List<Orders> orders);

}
