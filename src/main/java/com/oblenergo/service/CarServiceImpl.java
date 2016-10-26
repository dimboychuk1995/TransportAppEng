/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.DAO.CarDao;
import com.oblenergo.model.Car;

/**
 *
 * @author us9522
 */
@Service
public class CarServiceImpl implements CarService {
  Logger LOGGER = Logger.getLogger(CarServiceImpl.class);

  @Autowired
  CarDao dao;

  @Transactional
  @Override
  public List<Car> findAll() {
    try {
      return dao.findAllItems();
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find all cars from DB ", dae);
      throw dae;
    }

  }

  @Transactional
  @Override
  public void save(Car car) {
    try {
      dao.save(car);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to save car to DB ", dae);
      throw dae;
    }
  }

  @Transactional
  @Override
  public void update(Car car) {
    try {
      Car entity = dao.findById(car.getId());
      entity.setName(car.getName());
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find car with id" + car.getId(), dae);
      throw dae;
    }
  }

  @Transactional
  @Override
  public Car findCarById(int id) {
    try {
      return dao.findById(id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find car with id" + id, dae);
      throw dae;
    }
  }

  @Transactional
  @Override
  public void delete(int id) {
    try {
      dao.delete(id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to delete car from DB with id : " + id, dae);
      throw dae;
    }
  }

}
