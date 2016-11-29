/**
 * CalcController.java 1.0 November 25, 2016
 * 
 * Copyright (c) Haris Cesko and Ben Hay 2016 Elon University
 * Elon, North Carolina, 27244 U.S.A.
 * All Rights Reserved
 */

package edu.elon.math;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Haris Cesko and Ben Hay
 *
 */
public class CalcController implements ControllerInterface {
	private ModelInterface model;
	private CalcView view;
	private List<String> operators = Arrays.asList("+", "-", "/", "*");
	Double output;

	/**
	 * Constructor for the CalcController class that creates the model and the views
	 * upon instantiation
	 * 
	 * @param model
	 */
	public CalcController(ModelInterface model) {
		this.model = model;
		view = new CalcView(this, this.model);
		view.create();
		model.addObserverI(view);
		output = null;

	}

	/* (non-Javadoc)
	 * @see edu.elon.math.ControllerInterface#addInput(java.lang.String)
	 */
	@Override
	public void addInput(String input) {
		System.out.println(input);
		if (input.equals("=")) {
			output = model.evaluate();
			model.clear();
			view.enableDec();
		} else if (input.equals(".")){
			view.disableDec();
			model.addAppendInput(input);
		} else if (operators.contains(input)) {

			if (output != null) {
				String newInput = output.toString();
				newInput = newInput + input;
				model.addAppendInput(newInput);
			} else {
				model.addAppendInput(input);
			}
			
			view.enableDec();
		} else {
			model.addAppendInput(input);
			output = null;
		}
	}
}
