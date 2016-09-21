package com.oblenergo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.DAO.WorkTypeDao;
import com.oblenergo.model.WorkType;

@Service
public class WorkTypeServiseImpl implements WorkTypeService {

	@Autowired
	WorkTypeDao dao;

	@Transactional
	@Override
	public List<WorkType> findAll() {

		return dao.findAllItems();
	}

	@Transactional
	@Override
	public void save(WorkType workType) {

		dao.save(workType);
	}

	@Transactional
	@Override
	public WorkType findWorkTypeById(int id) {
		return dao.findById(id);
	}

	@Transactional
	@Override
	public void update(WorkType workType) {
		WorkType entity = dao.findById(workType.getId());
		entity.setName(workType.getName());
		entity.setCount_hours(workType.getCount_hours());
		entity.setSalary(workType.getSalary());
		entity.setSocial_insurance(workType.getSocial_insurance());
		entity.setProduction_costs(workType.getProduction_costs());
		entity.setAll_costs(workType.getAll_costs());
		entity.setProfit(workType.getProfit());
		entity.setSum(workType.getSum());
		entity.setCost_of_materials(workType.getCost_of_materials());
		entity.setSelling_price(workType.getSelling_price());
		entity.setVat(workType.getVat());
		entity.setPrice_including_vat(workType.getPrice_including_vat());
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);
	}

}
