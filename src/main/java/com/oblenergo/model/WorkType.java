/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "work_type")
public class WorkType implements Serializable {

  private static final long serialVersionUID = -4180639762560575780L;

  private String id;
  private String name;
  private boolean enabled;

  // getters
  @Id
  @NotBlank
  @Column(name = "id")
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  public String getId() {
    return id;
  }

  @NotBlank
  @Column(name = "name")
  public String getName() {
    return name;
  }

  @Column(name = "enabled")
  public boolean getEnabled() {
    return enabled;
  }

  // setters
  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this, true);

  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj, true);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
