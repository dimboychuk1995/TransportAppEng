package com.oblenergo.DAO;

import java.util.List;

import com.oblenergo.model.WorkType;

public interface WorkTypeDao {

  WorkType findById(String id);

  WorkType findByName(String name);

  List<WorkType> findAllWorkType();

  List<WorkType> findAllAvailableWorkType();

  void save(WorkType wt);

  void delete(String id);

}
