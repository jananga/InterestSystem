/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdg.interestsystem.controller;

import com.wdg.interestsystem.db.DBConnection;
import com.wdg.interestsystem.model.Customer;
import com.wdg.interestsystem.model.Interest;
import java.sql.Connection;
import java.sql.Date;
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
public class InterestDAOImp implements InterestDAO {

    @Override
    public boolean insertInterest(Interest interest) {
        //for check how many rows updated
        boolean ok = false;

        //Creating the query
        String query = "INSERT INTO `interest` (`interestID`, `cusID`, `date`, `amount`, `interest`, `installment`, `description`) VALUES (NULL, ?, ?, ?, ?, ?, ?);";
        try {
            //Creating the Connection
            Connection con = DBConnection.getConnection();

            //Create the prepared statement
            PreparedStatement ps = con.prepareStatement(query);

            //Setting the sequestial values
            ps.setInt(1, interest.getCustomer().getId());
            ps.setDate(2, (Date) interest.getDate());
            ps.setDouble(3, interest.getAmount());
            ps.setDouble(4, interest.getInterest());
            ps.setDouble(5, interest.getInstallment());
            ps.setString(6, interest.getDescription());
            //Executing the prepared statement
            int res = ps.executeUpdate();

            //Check Insert Status
            if (res == 1) {
                ok = true;
            } else {
                ok = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Data Entering : " + ex.getMessage());
        } finally {
            return ok;
        }

    }

    @Override
    public boolean updateInterest(Interest interest) {
        //for check how many rows updated
        boolean ok = false;

        //Creating the query
        String query = "UPDATE `interest` SET `cusID` = ?, `date` = ?, `amount` = ?, `interest` = ?, `installment` = ?, `description` = ? WHERE `interest`.`interestID` = ?;";
        try {
            //Creating the Connection
            Connection con = DBConnection.getConnection();

            //Create the prepared statement
            PreparedStatement ps = con.prepareStatement(query);

            //Setting the sequestial values
            //ps.setInt(1, category.getId());
            ps.setInt(1, interest.getCustomer().getId());
            ps.setDate(2, interest.getDate());
            ps.setDouble(3, interest.getAmount());
            ps.setDouble(4, interest.getInterest());
            ps.setDouble(5, interest.getInstallment());
            ps.setString(6, interest.getDescription());
            ps.setInt(7, interest.getId());

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
    public Interest searchInterest(int id) {
//Create Interest Object to load a particular data row
        Interest interest = new Interest();
        try {

            //Creating the query
            String query = "SELECT * FROM `interest` WHERE `interestID` =?";

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
//`interestID`, `cusID`, `date`, `amount`, `interest`, `installment`, `description`
                //setting values
                interest.setId(res.getInt("interestID"));
                interest.setCustomer(new CustomerDAOImp().searchCustomer(res.getInt("cusID")));
                interest.setDate(res.getDate("date"));
                interest.setAmount(res.getDouble("amount"));
                interest.setInterest(res.getFloat("interest"));
                interest.setInstallment(res.getDouble("installment"));
                interest.setDescription(res.getString("description"));

            } else {
                interest = null;
                JOptionPane.showMessageDialog(null, "No data found for Interest Id: " + id);

            }

        } catch (Exception ex) {
            Logger.getLogger(CustomerDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            return interest;
        }
    }

    @Override
    public boolean deleteInterest(int id) {
        //for check how many rows updated
        boolean ok = false;

        //Creating the query
        String query = "DELETE FROM `interest` WHERE `interest`.`interestID` = ?;";
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
                //JOptionPane.showMessageDialog(null, " Rows Deleted...!!");
                ok = true;
            } else {
                ok = false;
            }
            JOptionPane.showMessageDialog(null, res + " Rows Deleted...!!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            return ok;
        }
    }

    @Override
    public List<Interest> listAll() {
        //Create Customer Object List to load data 
        List<Interest> list = new ArrayList<>();

        try {

            //Creating the query
            String query = "SELECT * FROM  `interest`";

            //Creating the Connection
            Connection con = DBConnection.getConnection();

            //Create the prepared statement
            PreparedStatement ps = con.prepareStatement(query);

            //Executing the prepared statement
            ResultSet res = ps.executeQuery();

            //Fetching the records
            while (res.next()) {
                //Create Customer Objects
                Interest interest = new Interest();

                //setting values
                interest.setId(res.getInt("interestID"));
                interest.setCustomer(new CustomerDAOImp().searchCustomer(res.getInt("cusID")));
                interest.setDate(res.getDate("date"));
                interest.setAmount(res.getDouble("amount"));
                interest.setInterest(res.getFloat("interest"));
                interest.setInstallment(res.getDouble("installment"));
                interest.setDescription(res.getString("description"));

                list.add(interest);
            }

        } catch (Exception ex) {
            Logger.getLogger(InterestDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            return list;
        }
    }

    @Override
    public List fillCustomer() {
        List<Customer> list = new ArrayList<Customer>();

        try {

            String sql = "SELECT * FROM  `customer`";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            //Fetching the Catagory results
            while (res.next()) {

                //Create the customer object
               Customer customer = new Customer();
                customer.setId(res.getInt("cusID"));
                customer.setName(res.getString("name"));
                customer.setTelNoOne(res.getString("telNoOne"));
                customer.setTelNoTwo(res.getString("telNoTwo"));
            
                //Add category to List
                list.add(customer);
              //  list.add(new Customer(res.getInt("cusID"), res.getString("name"), res.getString("telNoOne"), res.getString("telNoTwo")));

            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        } finally {
            return list;
        }
    }

}
