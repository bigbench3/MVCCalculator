package edu.elon.math;

import java.util.Observable;
import java.util.Observer;

public class CalcController implements Observer{
	private CalcModel model;
	private CalcView view;
	
	public CalcController(CalcModel model, CalcView view){
		this.model = model;
		this.view = view;
		view.create();
	}
	
	public void run(){
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
