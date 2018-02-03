/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdg.interestsystem.controller;

import com.wdg.interestsystem.model.Interest;
import java.util.List;

/**
 *
 * @author acer
 */
public interface InterestDAO {
    
      //All the crud operations of Interest management
    public boolean insertInterest(Interest interest);
    public boolean updateInterest(Interest interest);
    public Interest searchInterest(int id);
    public boolean deleteInterest(int id);
    
    public List<Interest> listAll();
}
