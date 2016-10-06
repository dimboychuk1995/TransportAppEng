/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.DAO;

import com.oblenergo.model.Car;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author us9522
 */

@Repository
public class CarDaoImpl extends AbstractDao<Integer, Car> implements CarDao{
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Car> findAllItems(){
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.desc("id"));
        return (List<Car>) crit.list();
    }
    
    @Override
    public void save(Car car) {
        persist(car);
    }
    
    @Override
    public Car findById(int id){
        return getById(id);
    }
    
    @Override
    public void delete(int id){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Car car = (Car) crit.uniqueResult();
        delete(car);
    }
}
