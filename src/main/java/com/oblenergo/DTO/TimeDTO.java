package com.oblenergo.DTO;

import java.io.Serializable;

public class TimeDTO implements Serializable {

  private static final long serialVersionUID = 8464422734342794021L;
  
  private String date;
  private String id;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
