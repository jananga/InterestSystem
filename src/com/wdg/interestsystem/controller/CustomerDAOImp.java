/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdg.interestsystem.controller;

import com.wdg.interestsystem.db.DBConnection;
import com.wdg.interestsystem.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class CustomerDAOImp implements CustomerDAO {

    @Override
    public boolean insertCustomer(Customer customer) {
        //for check how many rows updated
        boolean ok = false;

        //Creating the query
        String query = "INSERT INTO `customer` (`cusID`, `name`, `telNoOne`, `telNoTwo`) VALUES (NULL, ?, ?, ?);";
        try {
            //Creating the Connection
            Connection con = DBConnection.getConnection();

            //Create the prepared statement
            PreparedStatement ps = con.prepareStatement(query);

            //Setting the sequestial values
            //ps.setInt(1, category.getId());
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getTelNoOne());
            ps.setString(3, customer.getTelNoTwo());
            //Executing the prepared statement
            int res = ps.executeUpdate();

            //Check Insert Status
            if (res == 1) {
                ok = true;
            } else {
                ok = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            return ok;
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        //for check how many rows updated
        boolean ok = false;

        //Creating the query
        String query = "UPDATE `customer` SET `name` = ?, `telNoOne` = ?, `telNoTwo` = ? WHERE `customer`.`cusID` = ?;";
        try {
            //Creating the Connection
            Connection con = DBConnection.getConnection();

            //Create the prepared statement
            PreparedStatement ps = con.prepareStatement(query);

            //Setting the sequestial values
            //ps.setInt(1, category.getId());
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getTelNoOne());
            ps.setString(3, customer.getTelNoTwo());
            ps.setInt(4, customer.getId());

            //Executing the prepared statement
            int res = ps.executeUpdate();

            //Check Insert Status
            if (res == 1) {
                ok = true;
            } else {
                ok = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            return ok;
        }
    }

    @Override
    public Customer searchCustomer(int id) {

//Create Customer Object to load a particular data row
        Customer customer = new Customer();
        try {

            //Creating the query
            String query = "SELECT * FROM `customer` WHERE  `cusID` =?";

            //Creating the Connection
            Connection con = DBConnection.getConnection();

            //Create the prepared statement
            PreparedStatement ps = con.prepareStatement(query);

            //Setting the sequestial values
            ps.setInt(1, id);

            //Executing the prepared statement
            ResultSet res = ps.executeQuery();

            //Fetching the records
            if (res.next()) {
                //setting values
                customer.setId(res.getInt("cusID"));
                customer.setName(res.getString("name"));
                customer.setTelNoOne(res.getString("telNoOne"));
                customer.setTelNoTwo(res.getString("telNoTwo"));

            } else {
                customer = null;
                JOptionPane.showMessageDialog(null, "No data found for Customer Id: " + id);
                
            }

        } catch (Exception ex) {
            Logger.getLogger(CustomerDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            return customer;
        }

    }

    @Override
    public boolean deleteCustomer(int id) {
        //for check how many rows updated
        boolean ok = false;

        //Creating the query
        String query = "DELETE FROM `customer` WHERE `cusID` = ?;";
        try {
            //Creating the Connection
            Connection con = DBConnection.getConnection();

            //Create the prepared statement
            PreparedStatement ps = con.prepareStatement(query);

            //Setting the sequestial values
            ps.setInt(1, id);

            //Executing the prepared statement
            int res = ps.executeUpdate();

            //Check Insert Status
            if (res == 1) {
                ok = true;
            } else {
                ok = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            return ok;
        }
    }

    @Override
    public List<Customer> listAll() {

        //Create Customer Object List to load data 
        List<Customer> list = new ArrayList<>();

        try {

            //Creating the query
            String query = "SELECT * FROM  `customer`";

            //Creating the Connection
            Connection con = DBConnection.getConnection();

            //Create the prepared statement
            PreparedStatement ps = con.prepareStatement(query);

            //Executing the prepared statement
            ResultSet res = ps.executeQuery();

            //Fetching the records
            while (res.next()) {
                //Create Customer Objects
                Customer cus = new Customer();

                //setting values
                cus.setId(res.getInt("cusID"));
                cus.setName(res.getString("name"));
                cus.setTelNoOne(res.getString("telNoOne"));
                cus.setTelNoTwo(res.getString("telNoTwo"));
                list.add(cus);
            }

        } catch (Exception ex) {
            Logger.getLogger(CustomerDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            return list;
        }

    }

}
