package com.oblenergo.DAO;

import java.util.List;

import com.oblenergo.model.Orders;

public interface OrderDao {

	Orders findById(int id);

	List<Orders> findAllItems();

	void save(Orders order);

	void delete(int id);

	List<Orders> dateOfOrders(String date);
	
	List<Orders> findAllNewOrders();

}
