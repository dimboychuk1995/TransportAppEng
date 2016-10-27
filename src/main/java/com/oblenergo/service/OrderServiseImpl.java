package com.oblenergo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author us9522
 */

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.DAO.OrderDao;
import com.oblenergo.model.Orders;

@Service
public class OrderServiseImpl implements OrderServise {

  Logger LOGGER = Logger.getLogger(OrderServiseImpl.class);

  @Autowired
  OrderDao dao;

  private final static String[] fullTimeRange = { "08:00:00", "08:30:00", "09:00:00", "09:30:00", "10:00:00",
      "10:30:00", "11:00:00", "11:30:00", "12:00:00", "12:30:00", "13:00:00", "13:30:00", "14:00:00", "14:30:00",
      "15:00:00", "15:30:00", "16:00:00" };

  private final static String[] shortTimeRange = { "08:00:00", "08:30:00", "09:00:00", "09:30:00", "10:00:00",
      "10:30:00", "11:00:00", "11:30:00", "12:00:00", "12:30:00", "13:00:00", "13:30:00", "14:00:00", "14:30:00",
      "15:00:00" };

  private final static int shortDay = 5;

  private final static int stepOfTime = 1;

  @Transactional
  @Override
  public List<Orders> findAll() {
    try {
      return dao.findAllItems();
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to get all workTypes", dae);
      throw dae;
    }
  }

  @Transactional
  @Override
  public void save(Orders order) {
    try {
      dao.save(order);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to write data to DB for save order", dae);
      throw dae;
    }
  }

  @Transactional
  @Override
  public Orders findOrderById(int id) {
    try {
      return dao.findById(id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find order with id : " + id, dae);
      throw dae;
    }
  }

  @Transactional
  @Override
  public void update(Orders order) {

    Orders entity = null;
    try {

      entity = dao.findById(order.getId());

    } catch (DataAccessException dae) {
      LOGGER.error("Unable to get order with id : " + order.getId(), dae);
      throw dae;
    }

    entity.setCar(order.getCar());
    entity.setCar_model(order.getCar_model());
    entity.setPerformer_id(order.getPerformer_id());
    entity.setDate(order.getDate());
    entity.setTime(order.getTime());
    entity.setCar_number(order.getCar_number());
    entity.setStatus_order(order.getStatus_order());
  }

  @Transactional
  @Override
  public void delete(int id) {
    try {
      dao.delete(id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to delete order with id : " + id, dae);
      throw dae;
    }

  }

  @Transactional
  @Override
  public List<Orders> findDateOfOrders(String date) {
    try {
      return dao.dateOfOrders(date);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find order with date" + date);
      throw dae;
    }
  }

  @Override
  public List<String> findFreeTime(String[] arrTimeOrders, String date) {
    String[] time;

    if (shortDay == getDayOfWeek(date)) {
      time = shortTimeRange;
    } else {
      time = fullTimeRange;
    }

    return getFreeTime(time, getBusyTime(time, arrTimeOrders));
  }

  @Override
  public List<String> findFreeTimeForAdmin(String[] arrTimeOrders, String date, Orders order) {
    String[] timeAdmin;

    if (shortDay == getDayOfWeek(date)) {
      timeAdmin = shortTimeRange;
    } else {
      timeAdmin = fullTimeRange;
    }

    return getFreeTime(timeAdmin, getBusyTimeForAdmin(timeAdmin, arrTimeOrders, date, order));
  }

  public int getDayOfWeek(String date) {
    Calendar c = Calendar.getInstance();

    try {
      c.setTime(new SimpleDateFormat("yyyy-mm-dd").parse(date));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

    return dayOfWeek;
  }

  public ArrayList<String> getBusyTime(String[] time, String[] arrTimeOrders) {

    ArrayList<String> busyTime = new ArrayList<String>();
    int iter = 0;
    for (int i = 0; i < time.length; i++) {
      for (int j = 0; j < arrTimeOrders.length; j++) {

        if (time[i].equals(arrTimeOrders[j])) {

          if (i > 0 && i < (time.length - 2)) {
            busyTime.add(iter, time[i - stepOfTime]);
            iter++;
            busyTime.add(iter, time[i]);
            iter++;
            busyTime.add(iter, time[i + stepOfTime]);
            iter++;
          }

          if (i == 0) {
            busyTime.add(iter, time[i]);
            iter++;
            busyTime.add(iter, time[i + stepOfTime]);
            iter++;
          }

          if (i == (time.length - 1)) {
            busyTime.add(iter, time[i]);
            iter++;
            busyTime.add(iter, time[i - stepOfTime]);
            iter++;
          }

        }
      }
    }

    return busyTime;
  }

  public ArrayList<String> getBusyTimeForAdmin(String[] time, String[] arrTimeOrders, String date, Orders order) {

    ArrayList<String> busyTime = new ArrayList<String>();
    int iter = 0;
    for (int i = 0; i < time.length; i++) {
      for (int j = 0; j < arrTimeOrders.length; j++) {

        if (time[i].equals(arrTimeOrders[j])) {

          if (i > 0 && i < (time.length - 2)) {

            if (date.equals(order.getDate()) && arrTimeOrders[j].equals(order.getTime())) {

              if ((time.length - 3) < i && (arrTimeOrders.length - 2) < j) {

                if (time[i + 2].equals(arrTimeOrders[j + 1])) {
                  busyTime.add(iter, time[i + stepOfTime]);
                  iter++;
                }
                if (time[i - 2].equals(arrTimeOrders[j - 1])) {
                  busyTime.add(iter, time[i - stepOfTime]);
                  iter++;
                }
              }
            } else {

              busyTime.add(iter, time[i - stepOfTime]);
              iter++;
              busyTime.add(iter, time[i]);
              iter++;
              busyTime.add(iter, time[i + stepOfTime]);
              iter++;

            }
          }

          if (i == 0) {

            if (date.equals(order.getDate()) && arrTimeOrders[j].equals(order.getTime())) {

              if ((time.length - 3) < i && (arrTimeOrders.length - 2) < j) {

                if (time[i + 2].equals(arrTimeOrders[i + 1])) {
                  busyTime.add(iter, time[i + stepOfTime]);
                  iter++;
                }
              }

            } else {

              busyTime.add(iter, time[i + stepOfTime]);
              iter++;
              busyTime.add(iter, time[i]);
              iter++;
            }

          }

          if (i == (time.length - 1)) {

            if (date.equals(order.getDate()) && arrTimeOrders[j].equals(order.getTime())) {

              if ((arrTimeOrders.length - 1) >= 2) {
                if (time[i - 2].equals(arrTimeOrders[j - 1])) {
                  busyTime.add(iter, time[i - stepOfTime]);
                }
              }

            } else {

              busyTime.add(iter, time[i - stepOfTime]);
              iter++;
              busyTime.add(iter, time[i]);
              iter++;
            }

          }

        }
      }
    }

    return busyTime;
  }

  public List<String> getFreeTime(String[] time, ArrayList<String> busyTime) {

    List<String> list = new ArrayList<>(Arrays.asList(time));
    List<String> freeTime = list.stream().filter(x -> !busyTime.contains(x)).collect(Collectors.toList());

    return freeTime;
  }

  @Transactional
  @Override
  public List<Orders> findAllNew() {
    try {
      return dao.findAllNewOrders();
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find new orders");
      throw dae;
    }

  }

}
