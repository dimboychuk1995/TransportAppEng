package com.oblenergo.service;

/**
 *
 * @author us9522
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.DAO.OrderDao;
import com.oblenergo.model.Orders;


@Service
public class OrderServiseImpl implements OrderServise{
    
    @Autowired
    OrderDao dao;
    
    @Transactional
    @Override
    public List<Orders> findAll(){
        return dao.findAllItems();
    }
    
    @Transactional
    @Override
    public void save(Orders order){
        dao.save(order);
    }
    
    @Transactional
    @Override
    public Orders findOrderById(int id){
        return dao.findById(id);
    }

    @Transactional
    @Override
    public void update(Orders order) {
        Orders entity = dao.findById(order.getId());
        entity.setName_servise_id(order.getName_servise_id());
        entity.setCustomer(order.getCustomer());
        entity.setCar_name_id(order.getCar_name_id());
        entity.setCar_model(order.getCar_model());
        entity.setSum_vithput_pdv(order.getSum_vithput_pdv());
        entity.setPdv(order.getPdv());
        entity.setAll_sum(order.getAll_sum());
        entity.setPerformer_id(order.getPerformer_id());
        entity.setDate(order.getDate());
        entity.setTime(order.getTime());
    }

    @Transactional
    @Override
    public void delete(int id) {
        dao.delete(id);
    }
    
}