package edu.elon.math;

import java.util.Observable;
import java.util.Observer;

public class CalcController implements ControllerInterface{
	private CalcModel model;
	private CalcView view;
	
	public CalcController(CalcModel model, CalcView view){
		this.model = model;
		this.view = view;
	}
	
	public void run(){
		view.create();
	}
}
