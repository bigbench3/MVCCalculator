package edu.elon.math;

public class Calculator {
	public static void main(String args[]){
		CalcView view = new CalcView();
		CalcModel model = new CalcModel();
		CalcController controller = new CalcController(model, view);
		
		controller.run();
	}
}
