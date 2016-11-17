package edu.elon.math;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CalcController implements ControllerInterface{
	private ModelInterface model;
	private CalcView view;
	private List<String> operators = Arrays.asList("+", "-", "/", "*");
	
	public CalcController(ModelInterface model){
		this.model = model;
		view = new CalcView(this, this.model);
		view.create();
	}

	@Override
	public void addInput(String input) {
		System.out.println(input);
		if (input.equals("=")){
			Double output = model.evaluate();
			view.setText(output.toString());
		} else if (operators.contains(input)){
			view.clearText();
		} else {
			String dog = "dog";
			model.addAppendInput(input);
			view.setText(model.getFullInput());
		}
	}
}
