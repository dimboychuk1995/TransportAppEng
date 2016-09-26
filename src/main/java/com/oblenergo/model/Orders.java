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
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 7191453677142422700L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    
    @Column(name = "name_servise_id")
    private Integer name_servise_id;

    
    @Column(name = "customer")
    private String customer;

    
    @Column(name = "car_name_id")
    private Integer car_name_id;

    
    @Column(name = "car_model")
    private String car_model;

    
    @Column(name = "sum_vithput_pdv")
    private Double sum_vithput_pdv;

    
    @Column(name = "pdv")
    private Double pdv;

    
    @Column(name = "all_sum")
    private Double all_sum;

    
    @Column(name = "performer_id")
    private Integer performer_id;

   
    @Column(name = "date")
    private String date;

    
    @Column(name = "time")
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName_servise_id() {
        return name_servise_id;
    }

    public void setName_servise_id(Integer name_servise_id) {
        this.name_servise_id = name_servise_id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getCar_name_id() {
        return car_name_id;
    }

    public void setCar_name_id(Integer car_name_id) {
        this.car_name_id = car_name_id;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public Double getSum_vithput_pdv() {
        return sum_vithput_pdv;
    }

    public void setSum_vithput_pdv(Double sum_vithput_pdv) {
        this.sum_vithput_pdv = sum_vithput_pdv;
    }

    public Double getPdv() {
        return pdv;
    }

    public void setPdv(Double pdv) {
        this.pdv = pdv;
    }

    public Double getAll_sum() {
        return all_sum;
    }

    public void setAll_sum(Double all_sum) {
        this.all_sum = all_sum;
    }

    public Integer getPerformer_id() {
        return performer_id;
    }

    public void setPerformer_id(Integer performer_id) {
        this.performer_id = performer_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
