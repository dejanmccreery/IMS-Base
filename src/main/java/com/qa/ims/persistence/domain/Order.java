package com.qa.ims.persistence.domain;

import jdk.vm.ci.meta.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private Long customerID;
    private LocalDate date;
    private Double value;
    private ArrayList<Long> items;

    public Order(Long customerID, LocalDate date) {
        this.customerID = customerID;
        this.date = date;
    }

    public Order(Long id, Long customerID, LocalDate date) {
        this.id = id;
        this.customerID = customerID;
        this.value = value;
        this.date = date;
    }

    public Order(Long id, Long customerID, Double value, LocalDate date) {
        this.id = id;
        this.customerID = customerID;
        this.value = value;
        this.date = date;
    }

    public void calculateValue(){

    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Order ID: " + this.id + " Customer ID: " + this.customerID
                + " Value:" + this.value + " Order Date: " + this.date;
    }

    public String repr() { return "Order ID: " + this.id +
            "| Customer ID: " + this.customerID + "| Value: " + this.value +
            "| Order Date: " + this.date; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (getCustomerID() == null) {
            if (other.getCustomerID() != null)
                return false;
        } else if (!getCustomerID().equals(other.getCustomerID()))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (getDate() == null) {
            if (other.getDate() != null)
                return false;
        } else if (!getDate().equals(other.getDate()))
            return false;
        return true;
    }

}


