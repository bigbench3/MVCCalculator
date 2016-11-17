package edu.elon.math;

import java.util.Observer;

public interface ModelInterface {
	
	public double evaluate();

	public void addAppendInput(String input);

	public String getFullInput();
	
}
