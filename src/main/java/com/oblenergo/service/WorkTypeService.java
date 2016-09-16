package com.oblenergo.service;

import java.util.List;

import com.oblenergo.model.WorkType;

public interface WorkTypeService {

	public List<WorkType> findAll();

	void save(WorkType workType);

}
