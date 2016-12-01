package com.oblenergo.service;

import java.util.List;

import com.oblenergo.DTO.OrderDTO;
import com.oblenergo.DTO.WorkTypeDTO;

public interface SapService {

  String getFullNameFromSap(String tabNamber);

  List<WorkTypeDTO> getAllWorkTypes();

  OrderDTO createNewOrder(String carNum, String itemNum, String itemCount);

  byte[] getBillPDF(String orderNum);

}
