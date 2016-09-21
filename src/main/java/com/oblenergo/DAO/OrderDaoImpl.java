package com.oblenergo.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.oblenergo.model.Orders;

@Repository
public class OrderDaoImpl extends AbstractDao<Integer, Orders> implements OrderDao{
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Orders> findAllItems(){
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.desc("id"));
        return (List<Orders>) crit.list();
    }
    
    @Override
    public void save(Orders order) {
        persist(order);
    }
    
    @Override
    public Orders findById(int id){
        return getById(id);
    }
    
    @Override
    public void delete(int id){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Orders order = (Orders) crit.uniqueResult();
        delete(order);
    }
    
}
