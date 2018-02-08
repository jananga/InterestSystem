/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdg.interestsystem.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author acer
 */
public class DateFunctions {

    public static Date getTodayDate() {
        return new Date();
    }

    public static Date converToDate(String string) throws ParseException {
        //= "January 2, 2010";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date = format.parse(string);
        System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
        return date;
    }
    
    

    public static boolean isDate(Date date) {
        boolean ret = true;
        try {
            date.getTime();
        } catch (Exception e) {
            System.out.println("Invalid date");
            ret = false;
        }
        return ret;

    }
    
    public static java.sql.Date createSQLDate(Date date)
    {
            return new java.sql.Date(date.getTime());

    }
}
