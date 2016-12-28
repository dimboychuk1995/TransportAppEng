package com.oblenergo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oblenergo.DTO.OrderDTO;
import com.oblenergo.DTO.WorkTypeDTO;
import com.oblenergo.wsClient.SapClient;

@Service
public class SapServiceImpl implements SapService {

  private static final Logger LOGGER = Logger.getLogger(SapServiceImpl.class);

  @Autowired
  SapClient sapClient;

  @Override
  public String getUserEmailFromSap(String tabNamber) {

    return sapClient.getUserEmail(tabNamber);
  }

  @Override
  public String getFullNameFromSap(String tabNamber) {
    String nameFromSAP = null;
    try {
      nameFromSAP = sapClient.getFullName(tabNamber);
    } catch (Exception ex) {
      LOGGER.error("Tab number of user wasn`t found in SAP");
    }
    return nameFromSAP;
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
  public byte[] getBillPDF(String billNumber) {

    return sapClient.getPDFBill(billNumber);
  }

  @Override
  public String getBillNumber(String orderNum) {

    return sapClient.getBillNumber(orderNum);
  }

}
