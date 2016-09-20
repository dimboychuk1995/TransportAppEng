package com.oblenergo.DAO;

import java.util.List;

import com.oblenergo.model.WorkType;

public interface WorkTypeDao {

	WorkType findById(int id);

	List<WorkType> findAllItems();

	void save(WorkType wt);

}
