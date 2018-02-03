/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdg.interestsystem.util;

/**
 *
 * @author acer
 */
public class NumericFunctions {
    
   public static boolean numberOrNot(String input)
	{
		try
		{
			Integer.parseInt(input);
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
		return true;
	}
}
