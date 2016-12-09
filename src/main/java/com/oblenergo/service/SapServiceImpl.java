package com.oblenergo.service;

import com.oblenergo.DTO.OrderDTO;
import com.oblenergo.DTO.WorkTypeDTO;
import com.oblenergo.wsClient.SapClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SapServiceImpl implements SapService {

  private static final Logger LOGGER = Logger.getLogger(SapServiceImpl.class);

  @Autowired
  SapClient sapClient;

  @Override
  public String getFullNameFromSap(String tabNamber) {

    return sapClient.getFullName(tabNamber);
  }

  @Override
  public List<WorkTypeDTO> getAllWorkTypes() {

    return sapClient.getAllWorktypes();
  }

  @Override
  public OrderDTO createNewOrder(String carNum, String itemNum, String itemCount) {

    return sapClient.getOrder(carNum, itemNum, itemCount);
  }

  @Override
  public byte[] getBillPDF(String orderNum) {

    return sapClient.getPDFBill(orderNum);
  }

}
