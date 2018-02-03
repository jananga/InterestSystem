/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdg.interestsystem.controller;

import com.wdg.interestsystem.model.Customer;

/**
 *
 * @author acer
 */
public class TestMain {

    public static void main(String[] args) {
        Customer cus = new Customer();
        cus.setId(3);
        cus.setName("Wasana Akka");
        cus.setTelNoOne("1111111111");
        cus.setTelNoTwo("45421580");

        
        
        //new CustomerDAOImp().insertCustomer(cus);
        //new CustomerDAOImp().updateCustomer(cus);
        //new CustomerDAOImp().deleteCustomer(4);
        Customer cs = new CustomerDAOImp().searchCustomer(1);
        if(cs != null){
        System.out.println("ID : "+cs.getId()+" Name : "+cs.getName()+" Tel 1 : "+cs.getTelNoOne()+" Tel 2 : "+cs.getTelNoTwo());
        }
        /*
        List <Customer> cusList = new CustomerDAOImp().listAll();

        Iterator<Customer> it = cusList.iterator(); 
        while(it.hasNext())
        {
            Customer cs = it.next();
            System.out.println("ID : "+cs.getId()+" Name : "+cs.getName()+" Tel 1 : "+cs.getTelNoOne()+" Tel 2 : "+cs.getTelNoTwo());
        }

         */
    }
}
