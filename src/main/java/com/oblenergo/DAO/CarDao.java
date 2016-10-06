/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.DAO;

import com.oblenergo.model.Car;

import java.util.List;

/**
 *
 * @author us9522
 */
public interface CarDao {
    
    Car findById(int id);
    
    List<Car> findAllItems();
    
    void save(Car car);
    
    void delete(int id);
}
