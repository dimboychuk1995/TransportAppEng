package com.oblenergo.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDTO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1571396833688379596L;

  private String orderNum;
  private BigDecimal orderPrice;
  private String orderTime;

  public String getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(String orderTime) {
    this.orderTime = orderTime;
  }

  public String getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(String orderNum) {
    this.orderNum = orderNum;
  }

  public BigDecimal getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(BigDecimal orderPrice) {
    this.orderPrice = orderPrice;
  }

  @Override
  public String toString() {
    return "OrderDTO [orderNum=" + orderNum + ", orderPrice=" + orderPrice + ", orderTime=" + orderTime + "]";
  }
  
  

}
