package edu.elon.math;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;


public class CalcModel extends Observable implements ModelInterface{
	private String input;
	private ScriptEngineManager manager;
	private ScriptEngine engine;
	private ArrayList<Observer> observers;
	
	public CalcModel(){
		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("JavaScript");
		input = "";
		observers = new ArrayList<Observer>();
	}

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

	@Override
	public void addAppendInput(String input) {
		this.input = this.input + input;
		notifyObservers(this.input);
	}

	@Override
	public String getFullInput() {
		return input;
	}

	@Override
	public void clear() {
		input = "";
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		observers.add(o);
		System.out.println("Observer added");
	}

	@Override
	public void notifyObservers(Object args) {
		for(Observer o : observers){
			o.update(this, args);
		}
	}

	@Override
	public synchronized void deleteObservers() {
		// TODO Auto-generated method stub
		super.deleteObservers();
	}

	@Override
	protected synchronized void setChanged() {
		// TODO Auto-generated method stub
		super.setChanged();
	}

	@Override
	public synchronized boolean hasChanged() {
		// TODO Auto-generated method stub
		return super.hasChanged();
	}

	@Override
	protected synchronized void clearChanged() {
		// TODO Auto-generated method stub
		super.clearChanged();
	}

	@Override
	public void addObserverI(Object o) {
		addObserver((Observer)o);
	}

	@Override
	public synchronized int countObservers() {
		// TODO Auto-generated method stub
		return super.countObservers();
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		super.notifyObservers();
	}
	
	
}
