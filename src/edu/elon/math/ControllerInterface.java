/**
 * ControllerInterface.java 1.0 November 25, 2016
 * 
 * Copyright (c) Haris Cesko and Ben Hay 2016 Elon University
 * Elon, North Carolina, 27244 U.S.A.
 * All Rights Reserved
 */

package edu.elon.math;

/**
 * @author Haris Cesko and Ben Hay
 * 
 * Interface for the CalcContrller that allows for abstraction 
 *
 */
public interface ControllerInterface {
	
	/**
	 * method that takes a string and concatenates it to the end of 
	 * the current input string for evaluation.
	 * 
	 * @param input
	 */
	public void addInput(String input);
}
