package com.oblenergo.service;

import java.util.List;

import com.oblenergo.DTO.WorkTypeDTO;
import com.oblenergo.model.WorkType;

public interface WorkTypeService {

  public List<WorkType> findAll();

  void save(WorkType workType);

  void update(String idWorkType);

  WorkType findWorkTypeById(String id);

  WorkType findWorkTypeByName(String name);

  void delete(int id);

  boolean isWorkTypeUnique(String name, String id);

  List<WorkTypeDTO> findAvailableWorkType(List<WorkTypeDTO> listWorkTypeDTO);

}
