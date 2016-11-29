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

public class CalcView extends JFrame implements Observer{
	private ControllerInterface controller;
	private ModelInterface model;
	
	private JTextField inputOutput;
	private String[] buttons = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	private JPanel calc;
	
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

	public void create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
		setTitle("Calculator");
	}

	@Override
	public void update(Observable o, Object arg) {
		inputOutput.setText(arg.toString());
	}

	public void setText(String string) {
		inputOutput.setText(string);
	}

	public void clearText() {
		inputOutput.setText("");
	}

}
