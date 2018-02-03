/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdg.interestsystem.model;

/**
 *
 * @author acer
 */
public class Customer {

    private int id;
    private String name;
    private String telNoOne;
    private String telNoTwo;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the telNoOne
     */
    public String getTelNoOne() {
        return telNoOne;
    }

    /**
     * @param telNoOne the telNoOne to set
     */
    public void setTelNoOne(String telNoOne) {
        this.telNoOne = telNoOne;
    }

    /**
     * @return the telNoTwo
     */
    public String getTelNoTwo() {
        return telNoTwo;
    }

    /**
     * @param telNoTwo the telNoTwo to set
     */
    public void setTelNoTwo(String telNoTwo) {
        this.telNoTwo = telNoTwo;
        
    }

    @Override
    public String toString() {
        return getName();
    }
}
