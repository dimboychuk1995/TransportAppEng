package com.oblenergo.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.oblenergo.model.WorkType;

@Repository
public class WorkTypeDaoImpl extends AbstractDao<Integer, WorkType> implements WorkTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkType> findAllItems() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.desc("id"));
		return (List<WorkType>) crit.list();
	}

}
