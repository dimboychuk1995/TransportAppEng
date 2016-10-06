/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.service;

import com.oblenergo.DAO.CarDao;
import com.oblenergo.model.Car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author us9522
 */
@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarDao dao;

    @Transactional
    @Override
    public List<Car> findAll() {
        return dao.findAllItems();
    }

    @Transactional
    @Override
    public void save(Car car) {
        dao.save(car);
    }

    @Transactional
    @Override
    public void update(Car car) {
        Car entity = dao.findById(car.getId());
        entity.setName(car.getName());
    }

    @Transactional
    @Override
    public Car findCarById(int id) {
        return dao.findById(id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        dao.delete(id);
    }
    
}
