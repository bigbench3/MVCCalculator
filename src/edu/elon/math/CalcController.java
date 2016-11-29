package edu.elon.math;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CalcController implements ControllerInterface{
	private ModelInterface model;
	private CalcView view;
	private List<String> operators = Arrays.asList("+", "-", "/", "*");
	Double output;
	
	public CalcController(ModelInterface model){
		this.model = model;
		view = new CalcView(this, this.model);
		view.create();
		model.addObserverI(view);
		output = null;
		
	}

	@Override
	public void addInput(String input) {
		System.out.println(input);
		if (input.equals("=")){
			output = model.evaluate();
//			view.setText(output.toString());
			model.clear();
		} else if (operators.contains(input)){	
			
			if(output != null){
				String newInput = output.toString();
				newInput = newInput + input;
				model.addAppendInput(newInput);
			} else {
				model.addAppendInput(input);
			}
			
//			view.clearText();
		} else {
			model.addAppendInput(input);
//			view.setText(model.getFullInput());
			output = null;
		}
	}
}
