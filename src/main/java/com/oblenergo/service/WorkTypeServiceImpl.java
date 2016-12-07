package com.oblenergo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.DAO.WorkTypeDao;
import com.oblenergo.model.WorkType;

@Service
public class WorkTypeServiceImpl implements WorkTypeService {

  private static final Logger LOGGER = Logger.getLogger(WorkTypeServiceImpl.class);
  @Autowired
  WorkTypeDao dao;

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

//  @Transactional
//  @Override
//  public WorkType findWorkTypeById(String id) {
//
//    try {
//      return dao.findByName(id);
//    } catch (DataAccessException dae) {
//      LOGGER.error("Unable to find workType with surch id : " + id, dae);
//      throw dae;
//    }
//
//  }

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

//  @Transactional
//  @Override
//  public void update(WorkType workType) {
//    WorkType entity = null;
//
//    try {
//      entity = dao.findById(workType.getId());
//    } catch (DataAccessException dae) {
//      LOGGER.error("Unable to get workType with id : " + workType.getId(), dae);
//      throw dae;
//    }
//
//    entity.setName(workType.getName());
//    
//
//  }

  @Transactional
  @Override
  public void delete(int id) {

    try {
      dao.delete(id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to  delete workType with id :" + id, dae);
      throw dae;
    }
  }

  @Transactional
  @Override
  public boolean isWorkTypeUnique(String name, String id) {

    try {

      WorkType wt = findWorkTypeByName(name);
      return !(wt == null || wt.getId() == id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find workTyepe with name" + name, dae);
      throw dae;
    }

  }

@Override
public void update(WorkType workType) {
	// TODO Auto-generated method stub
	
}

@Override
public WorkType findWorkTypeById(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public WorkType findWorkTypeById(String id) {
	// TODO Auto-generated method stub
	return null;
}

}
