/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdg.interestsystem.model;

import java.sql.Date;


/**
 *
 * @author acer
 */
public class Interest {
    
   private Customer customer;
   private int id;
   private Date date;
   private double amount;
   private float interest;
   private double installment;
   private String description;

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the interest
     */
    public float getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(float interest) {
        this.interest = interest;
    }

    /**
     * @return the installment
     */
    public double getInstallment() {
        return installment;
    }

    /**
     * @param installment the installment to set
     */
    public void setInstallment(double installment) {
        this.installment = installment;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
