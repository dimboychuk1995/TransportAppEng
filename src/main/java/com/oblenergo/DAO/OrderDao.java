/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.DAO;

/**
 *
 * @author us9522
 */

import java.util.List;

import com.oblenergo.model.Orders;


public interface OrderDao {
    
    Orders findById(int id);

    List<Orders> findAllItems();

    void save(Orders order);

    void delete(int id);
    
}
