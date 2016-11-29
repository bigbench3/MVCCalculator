/**
 * CalcView.java 1.0 November 25, 2016
 * 
 * Copyright (c) Haris Cesko and Ben Hay 2016 Elon University
 * Elon, North Carolina, 27244 U.S.A.
 * All Rights Reserved
 */

package edu.elon.math;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**
 * @author hcesko
 *
 */
public class CalcView extends JFrame implements Observer{
	private ControllerInterface controller;
	private ModelInterface model;
	
	private JTextField inputOutput;
	private String[] buttons = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	private JPanel calc;
	
	/**
	 * Constructor method for the view of the calculator app. Creates the layout of the calculator
	 * and initializes the variables.
	 * 
	 * @param controller
	 * @param model
	 */
	public CalcView(ControllerInterface controller, ModelInterface model){
		this.controller = controller;
		this.model = model;
		
		setLayout(new BorderLayout());
		inputOutput = new JTextField();
		calc = new JPanel();
		calc.setLayout(new GridLayout(4, 4));
		
		for(int i = 0; i < buttons.length; i++){
			calc.add(new JButton(buttons[i]));
			JButton jb = (JButton) calc.getComponent(i);
			jb.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Event");
					JButton button = (JButton) e.getSource();
					controller.addInput(button.getText());
				}
			});
		}
		
		add(inputOutput, BorderLayout.NORTH);
		add(calc, BorderLayout.CENTER);
	}

	/**
	 * Sets the properties of the JFrame and makes it displayable
	 */
	public void create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
		setTitle("Calculator");
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		inputOutput.setText(arg.toString());
	}

	/**
	 * Sets calculator display to the passed string
	 * 
	 * @param string
	 */
	public void setText(String string) {
		inputOutput.setText(string);
	}

	/**
	 *  Clears the claculator display
	 */
	public void clearText() {
		inputOutput.setText("");
	}

	/**
	 * Disables the decimal
	 */
	public void disableDec() {
		calc.getComponent(13).setEnabled(false);
	}

	/**
	 * Sets the decimal active
	 */
	public void enableDec() {
		calc.getComponent(13).setEnabled(true);
	}

}
