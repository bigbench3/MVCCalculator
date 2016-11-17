package edu.elon.math;

public class Calculator {
	public static void main(String args[]){
		CalcModel model = new CalcModel();
		CalcController controller = new CalcController(model);
	}
}
