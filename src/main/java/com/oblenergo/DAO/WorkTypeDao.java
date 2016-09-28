package com.oblenergo.DAO;

import java.util.List;

import com.oblenergo.model.WorkType;

public interface WorkTypeDao {

	WorkType findById(int id);

	WorkType findByName(String name);

	List<WorkType> findAllItems();

	void save(WorkType wt);

	void delete(int id);

}
