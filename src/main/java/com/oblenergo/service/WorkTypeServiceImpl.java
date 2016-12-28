package com.oblenergo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.DAO.WorkTypeDao;
import com.oblenergo.DTO.WorkTypeDTO;
import com.oblenergo.model.WorkType;

@Service
public class WorkTypeServiceImpl implements WorkTypeService {

  private static final Logger LOGGER = Logger.getLogger(WorkTypeServiceImpl.class);
  @Autowired
  WorkTypeDao dao;
  @Autowired
  private SapService sapServiceImpl;

  /** This method return list of all workType which are in DB
   * 
   * @throws DataAccessException
   * @return List<WorkType> */
  @Transactional
  @Override
  public List<WorkType> findAll() {

    try {
      return dao.findAllWorkType();
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to load workTypes from DB", dae);
      throw dae;
    }
  }

  /** Save to DB
   * 
   * @param WorkType which have to be save
   * @throws DataAccessException */
  @Transactional
  @Override
  public void save(WorkType workType) {

    try {
      dao.save(workType);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to save workType to DB", dae);
      throw dae;
    }
  }

  /** Find by id from DB
   * 
   * @param String id for search WorkType in DB
   * @throws DataAccessException */
  @Transactional
  @Override
  public WorkType findWorkTypeById(String id) {

    try {
      return dao.findById(id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find workType with surch id : " + id, dae);
      throw dae;
    }

  }

  /** Find by name from DB
   * 
   * @param String name for search WorkType in DB
   * @throws DataAccessException */
  @Transactional
  @Override
  public WorkType findWorkTypeByName(String name) {

    try {
      return dao.findByName(name);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find name with this name : " + name, dae);
      throw dae;
    }
  }

  /** Update in DB
   * 
   * @param String id of WorkType which have to be update
   * @throws DataAccessException */
  @Transactional
  @Override
  public void update(String idWorkType) {
    WorkType entity = null;

    try {
      entity = dao.findById(idWorkType);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to get workType with id : " + idWorkType, dae);
      throw dae;
    }
    if (entity.getEnabled()) {
      entity.setEnabled(false);
    } else {
      entity.setEnabled(true);
    }
  }

  /** Delete from DB
   * 
   * @param String id of WorkType which have to be remove
   * @throws DataAccessException */

  @Transactional
  @Override
  public void delete(String id) {

    try {
      dao.delete(id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to  delete workType with id :" + id, dae);
      throw dae;
    }
  }

  /** Checking that this workType is unique in DB
   * 
   * @param String id of WorkType which is in DB
   * @throws DataAccessException */
  @Transactional
  @Override
  public boolean isWorkTypeUnique(String id) {

    try {
      WorkType wt = findWorkTypeById(id);
      return (wt == null);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find workTyepe with id : " + id, dae);
      throw dae;
    }

  }

  /** Search for available workTye, its get workType from SAP and also gets workType from
   * DB then create list with available workType
   * 
   * @param List<WorkTypeDTO> from SAP
   * @throws DataAccessException */
  @Transactional
  @Override
  public List<WorkTypeDTO> findAvailableWorkType(List<WorkTypeDTO> listWorkTypeDTO) {
    List<WorkType> listWorkType = dao.findAllAvailableWorkType();
    List<WorkTypeDTO> listAvailableWorkTypeDTO = null;

    listAvailableWorkTypeDTO = listWorkTypeDTO.stream()
        .filter(wtDTO -> (listWorkType.stream().filter(wt -> wt.getId().equals(wtDTO.getId())).count()) >= 1)
        .collect(Collectors.toList());
    return listAvailableWorkTypeDTO;
  }

  /** Get WorkType by id from SAP
   * 
   * @param String id
   * @throws DataAccessException */
  @Override
  public WorkTypeDTO getWorkTypeDTOByIdFromSAP(String id) {
    List<WorkTypeDTO> allWorkTypes = sapServiceImpl.getAllWorkTypes();
    WorkTypeDTO wkDTO = null;
    for (WorkTypeDTO wt : allWorkTypes) {
      if (wt.getId().equals(id)) {
        wkDTO = wt;
        break;
      }
    }

    // this code is written in Java8, but it do not work!
    // wkDTO = allWorkTypes.stream().filter(x ->
    // x.getId().equals(id)).findFirst().get();
    return wkDTO;
  }
}
