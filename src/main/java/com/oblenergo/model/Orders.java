
package com.oblenergo.model;

import com.oblenergo.enums.StatusOrderEnum;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 7191453677142422700L;

    private Integer id;
    private WorkType workType;
    private String customer;
    private Car car;
    private String car_model;
    private Double sum_vithput_pdv;
    private Double pdv;
    private Double all_sum;
    private Integer performer_id;
    private String date;
    private String time;
    private Integer user_tab;
    private String car_number;
    private String status_order = StatusOrderEnum.NEW.getStatusOrder();

    @Column(name = "user_tab")
    public Integer getUser_tab() {
        return user_tab;
    }

    public void setUser_tab(Integer user_tab) {
        this.user_tab = user_tab;
    }

    @Column(name = "car_number")
    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    @Column(name = "status_order")
    public String getStatus_order() {
        return status_order;
    }

    public void setStatus_order(String status_order) {
        this.status_order = status_order;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "customer")
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Column(name = "car_model")
    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    @Column(name = "sum_vithput_pdv")
    public Double getSum_vithput_pdv() {
        return sum_vithput_pdv;
    }

    public void setSum_vithput_pdv(Double sum_vithput_pdv) {
        this.sum_vithput_pdv = sum_vithput_pdv;
    }

    @Column(name = "pdv")
    public Double getPdv() {
        return pdv;
    }

    public void setPdv(Double pdv) {
        this.pdv = pdv;
    }

    @Column(name = "all_sum")
    public Double getAll_sum() {
        return all_sum;
    }

    public void setAll_sum(Double all_sum) {
        this.all_sum = all_sum;
    }

    @Column(name = "performer_id")
    public Integer getPerformer_id() {
        return performer_id;
    }

    public void setPerformer_id(Integer performer_id) {
        this.performer_id = performer_id;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "name_servise_id", referencedColumnName="id")
    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "car_name_id", referencedColumnName="id")
        public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
