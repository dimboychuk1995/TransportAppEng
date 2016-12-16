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

  void delete(String id);

  boolean isWorkTypeUnique(String id);

  List<WorkTypeDTO> findAvailableWorkType(List<WorkTypeDTO> listWorkTypeDTO);

  WorkTypeDTO getWorkTypeDTOByIdFromSAP(String id);

}
