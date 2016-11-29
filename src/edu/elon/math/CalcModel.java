/**
 * CalcModel.java 1.0 November 25, 2016
 * 
 * Copyright (c) Haris Cesko and Ben Hay 2016 Elon University
 * Elon, North Carolina, 27244 U.S.A.
 * All Rights Reserved
 */

package edu.elon.math;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;


/**
 * The model class that will handle all computational responsibilities of
 * the Calculator application
 * 
 * @author Haris Cesko and Ben Hay
 */
public class CalcModel extends Observable implements ModelInterface{
	private String input;
	private ScriptEngineManager manager;
	private ScriptEngine engine;
	private ArrayList<Observer> observers;
	
	/**
	 * Constructor for the CalcModel that creates the list of observers
	 */
	public CalcModel(){
		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("JavaScript");
		input = "";
		observers = new ArrayList<Observer>();
	}

	/* (non-Javadoc)
	 * @see edu.elon.math.ModelInterface#evaluate()
	 */
	@Override
	public double evaluate() {
		Object ans = 0;
		
		try {
			ans = engine.eval(input);
			System.out.println(ans.toString());
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
		notifyObservers(Double.parseDouble(ans.toString()));
		return Double.parseDouble(ans.toString());
	}

	/* (non-Javadoc)
	 * @see edu.elon.math.ModelInterface#addAppendInput(java.lang.String)
	 */
	@Override
	public void addAppendInput(String input) {
		this.input = this.input + input;
		notifyObservers(this.input);
	}

	/* (non-Javadoc)
	 * @see edu.elon.math.ModelInterface#getFullInput()
	 */
	@Override
	public String getFullInput() {
		return input;
	}

	/* (non-Javadoc)
	 * @see edu.elon.math.ModelInterface#clear()
	 */
	@Override
	public void clear() {
		input = "";
	}

	/* (non-Javadoc)
	 * @see java.util.Observable#addObserver(java.util.Observer)
	 */
	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		observers.add(o);
		System.out.println("Observer added");
	}

	/* (non-Javadoc)
	 * @see java.util.Observable#notifyObservers(java.lang.Object)
	 */
	@Override
	public void notifyObservers(Object args) {
		for(Observer o : observers){
			o.update(this, args);
		}
	}

	/* (non-Javadoc)
	 * @see java.util.Observable#deleteObservers()
	 */
	@Override
	public synchronized void deleteObservers() {
		// TODO Auto-generated method stub
		super.deleteObservers();
	}

	/* (non-Javadoc)
	 * @see java.util.Observable#setChanged()
	 */
	@Override
	protected synchronized void setChanged() {
		// TODO Auto-generated method stub
		super.setChanged();
	}

	/* (non-Javadoc)
	 * @see java.util.Observable#hasChanged()
	 */
	@Override
	public synchronized boolean hasChanged() {
		// TODO Auto-generated method stub
		return super.hasChanged();
	}

	/* (non-Javadoc)
	 * @see java.util.Observable#clearChanged()
	 */
	@Override
	protected synchronized void clearChanged() {
		// TODO Auto-generated method stub
		super.clearChanged();
	}

	/* (non-Javadoc)
	 * @see edu.elon.math.ModelInterface#addObserverI(java.lang.Object)
	 */
	@Override
	public void addObserverI(Object o) {
		addObserver((Observer)o);
	}

	/* (non-Javadoc)
	 * @see java.util.Observable#countObservers()
	 */
	@Override
	public synchronized int countObservers() {
		// TODO Auto-generated method stub
		return super.countObservers();
	}

	/* (non-Javadoc)
	 * @see java.util.Observable#notifyObservers()
	 */
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		super.notifyObservers();
	}
	
	
}
