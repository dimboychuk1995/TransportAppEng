/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.service;

/**
 *
 * @author us9522
 */

import com.oblenergo.model.Orders;

import java.util.List;

public interface OrderServise {

	public List<Orders> findAll();

	void save(Orders order);

	void update(Orders order);

	Orders findOrderById(int id);

	void delete(int id);

	public List<Orders> findDateOfOrders(String date);

	public List<String> findFreeTime(String[] arrTimeOrders, String date);

	public List<String> findFreeTimeForAdmin(String[] arrTimeOrders, String date, Orders order);

	public List<Orders> findAllConfirm();

}
