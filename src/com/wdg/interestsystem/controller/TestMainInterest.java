/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdg.interestsystem.controller;

import com.wdg.interestsystem.model.Customer;
import com.wdg.interestsystem.model.Interest;
import com.wdg.interestsystem.util.DateFunctions;
import java.sql.Date;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author acer
 */
public class TestMainInterest {
    
    public static void main(String[] args) throws ParseException {
        
        Interest interest = new Interest();  
        Customer customer = new Customer();
        customer.setId(5);
        customer.setName("Kasun Boy");
        
        interest.setCustomer(customer);
        interest.setAmount(4550000.00);
        //interest.setId(1);
        
       // System.out.println("Date is : "+DateFunctions.getTodayDate().toString());
        
       String strDate = "January 2, 2017";
        Date sqlDate = new Date(DateFunctions.getTodayDate().getTime());
        Date customDate = new Date(DateFunctions.converToDate(strDate).getTime());
        interest.setDate(customDate);
        interest.setInstallment(5000);
        interest.setDescription("My test installment update");
        interest.setInterest((float) 10);
        
        new InterestDAOImp().insertInterest(interest);
        //new InterestDAOImp().updateInterest(interest);
       // interest = new InterestDAOImp().searchInterest(1);
        
       /*
        if(interest != null){
            System.out.println("Int Id : "+interest.getId()+" Cus Name :" +interest.getCustomer().getName()+" Amount : "+interest.getAmount()+" Installment"+interest.getInstallment());
        } */
       
     //  new InterestDAOImp().deleteInterest(5);
     
       List <Interest> interestList = new InterestDAOImp().listAll();

        Iterator<Interest> it = interestList.iterator(); 
        while(it.hasNext())
        {
            interest = it.next();
            System.out.println("Int Id : "+interest.getId()+" Cus Name :" +interest.getCustomer()+" Tel No : "+interest.getCustomer().getTelNoOne()+" Amount : "+interest.getAmount()+" Installment"+interest.getInstallment());

        }
     
    }
}
