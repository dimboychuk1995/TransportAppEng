package com.oblenergo.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class WorkTypeDTO implements Serializable {

  private static final long serialVersionUID = 7277613558645074422L;

  private String id;
  private String name;
  private String price;
  private BigDecimal time;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public BigDecimal getTime() {
    return time;
  }

  public void setTime(BigDecimal time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return "WorkTypeDTO [id=" + id + ", name=" + name + ", price=" + price + ", time=" + time + "]";
  }
  
  

}
