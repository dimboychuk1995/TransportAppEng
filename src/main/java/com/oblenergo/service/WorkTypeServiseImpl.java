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

}
