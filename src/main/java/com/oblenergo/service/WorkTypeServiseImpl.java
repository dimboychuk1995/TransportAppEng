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
public class WorkTypeServiseImpl implements WorkTypeService {

  private static final Logger LOGGER = Logger.getLogger(WorkTypeServiseImpl.class);
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

  @Transactional
  @Override
  public WorkType findWorkTypeById(int id) {
    try {
      return dao.findById(id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find workType with surch id : " + id, dae);
      throw dae;
    }

  }

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

  @Transactional
  @Override
  public void update(WorkType workType) {
    try {
      WorkType entity = dao.findById(workType.getId());
      entity.setName(workType.getName());
      entity.setCount_hours(workType.getCount_hours());
      entity.setSalary(workType.getSalary());
      entity.setSocial_insurance(workType.getSocial_insurance());
      entity.setProduction_costs(workType.getProduction_costs());
      entity.setAll_costs(workType.getAll_costs());
      entity.setProfit(workType.getProfit());
      entity.setSum(workType.getSum());
      entity.setCost_of_materials(workType.getCost_of_materials());
      entity.setSelling_price(workType.getSelling_price());
      entity.setVat(workType.getVat());
      entity.setPrice_including_vat(workType.getPrice_including_vat());
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to get workType with id : " + workType.getId(), dae);
      throw dae;
    }
  }

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
  public boolean isWorkTypeUnique(String name, int id) {
    try {

      WorkType wt = findWorkTypeByName(name);
      return !(wt == null || wt.getId() == id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find workTyepe with name" + name, dae);
      throw dae;
    }

  }

}
