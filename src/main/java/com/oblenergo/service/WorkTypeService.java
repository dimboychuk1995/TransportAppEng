package com.oblenergo.service;

import java.util.List;

import com.oblenergo.model.WorkType;

public interface WorkTypeService {

	public List<WorkType> findAll();

	void save(WorkType workType);

	void update(WorkType workType);

	WorkType findWorkTypeById(int id);

	WorkType findWorkTypeByName(String name);

	void delete(int id);

	boolean isWorkTypeUnique(String name, Integer id);

}
