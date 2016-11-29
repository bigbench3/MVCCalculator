/**
 * Calculator.java 1.0 November 25, 2016
 * 
 * Copyright (c) Haris Cesko and Ben Hay 2016 Elon University
 * Elon, North Carolina, 27244 U.S.A.
 * All Rights Reserved
 */

package edu.elon.math;

/**
 * Driving class for the Application
 * 
 * @author Haris Cesko and Ben Hay
 */
public class Calculator {
	/**
	 * Driver method that creates the model and controller
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		CalcModel model = new CalcModel();
		CalcController controller = new CalcController(model);
	}
}
