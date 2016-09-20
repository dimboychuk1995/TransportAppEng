package com.oblenergo.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public void save(WorkType wt) {
		persist(wt);
	}

	@Override
	public WorkType findById(int id) {
		return getById(id);
	}

	@Override
	public void delete(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		WorkType wt = (WorkType) crit.uniqueResult();
		delete(wt);
	}

}
