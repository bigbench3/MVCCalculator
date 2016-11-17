package edu.elon.math;

import java.util.Observable;
import java.util.Observer;

public class CalcModel extends Observable implements ModelInterface{
	private String input;
	
	public CalcModel(){
		input = "";
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addAppendInput(String input) {
		this.input = this.input + input;
	}

	@Override
	public String getFullInput() {
		return input;
	}
	
}
