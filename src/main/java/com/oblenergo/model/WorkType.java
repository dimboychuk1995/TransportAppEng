/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

  private int id;
  private String name;
  private double count_hours;
  private double salary;
  private double social_insurance;
  private double production_costs;
  private double all_costs;
  private double profit;
  private double sum;
  private double cost_of_materials;
  private double selling_price;
  private double vat;
  private double price_including_vat;

  // getters
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  @NotBlank
  @Column(name = "name")
  public String getName() {
    return name;
  }

  @Column(name = "count_hours")
  public double getCount_hours() {
    return count_hours;
  }

  @Column(name = "salary")
  public double getSalary() {
    return salary;
  }

  @Column(name = "social_insurance")
  public double getSocial_insurance() {
    return social_insurance;
  }

  @Column(name = "production_costs")
  public double getProduction_costs() {
    return production_costs;
  }

  @Column(name = "all_costs")
  public double getAll_costs() {
    return all_costs;
  }

  @Column(name = "profit")
  public double getProfit() {
    return profit;
  }

  @Column(name = "sum")
  public double getSum() {
    return sum;
  }

  @Column(name = "cost_of_materials")
  public double getCost_of_materials() {
    return cost_of_materials;
  }

  @Column(name = "selling_price")
  public double getSelling_price() {
    return selling_price;
  }

  @Column(name = "vat")
  public double getVat() {
    return vat;
  }

  @Column(name = "price_including_vat")
  public double getPrice_including_vat() {
    return price_including_vat;
  }

  // setters

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCount_hours(double count_hours) {
    this.count_hours = count_hours;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public void setSocial_insurance(double social_insurance) {
    this.social_insurance = social_insurance;
  }

  public void setProduction_costs(double production_costs) {
    this.production_costs = production_costs;
  }

  public void setAll_costs(double all_costs) {
    this.all_costs = all_costs;
  }

  public void setProfit(double profit) {
    this.profit = profit;
  }

  public void setSum(double sum) {
    this.sum = sum;
  }

  public void setCost_of_materials(double cost_of_materials) {
    this.cost_of_materials = cost_of_materials;
  }

  public void setSelling_price(double selling_price) {
    this.selling_price = selling_price;
  }

  public void setVat(double vat) {
    this.vat = vat;
  }

  public void setPrice_including_vat(double price_including_vat) {
    this.price_including_vat = price_including_vat;
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
