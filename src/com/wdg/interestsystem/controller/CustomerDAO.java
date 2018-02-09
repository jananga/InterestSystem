/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdg.interestsystem.controller;

import com.wdg.interestsystem.model.Customer;
import java.util.List;

/**
 *
 * @author acer
 */
public interface CustomerDAO {
    
    
    //All the crud operations of customer management
    public boolean insertCustomer(Customer customer);
    public boolean updateCustomer(Customer customer);
    public Customer searchCustomer(int id);
    public boolean deleteCustomer(int id);
    
    public List<Customer> listAll();
    
}
