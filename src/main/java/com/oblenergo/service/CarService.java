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
import java.util.List;

import com.oblenergo.model.Car;

public interface CarService {
    
    public List<Car> findAll();

    void save(Car car);

    void update(Car car);

    Car findCarById(int id);

    void delete(int id);
}
