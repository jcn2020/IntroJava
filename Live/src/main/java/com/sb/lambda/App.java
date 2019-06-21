package com.sb.lambda;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class App {

	public static void main(String[] args) {
		App app = new App();
		app.go();
	}

	private String currentName = "xyz";
	private JTextField query; 

	public void go() {
		JFrame jFrame = new JFrame("Our App");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("OK");
		jFrame.add(button, BorderLayout.CENTER);

		query = new JTextField(10);
		jFrame.add(query, BorderLayout.NORTH);

		jFrame.setSize(new Dimension(300, 300));
		jFrame.setVisible(true);

		ActionListener myListener = new MyActionListener();

		ActionListener myListener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Current Name is " + query.getText() + ", " + e.getActionCommand());

			}
		};

		ActionListener myListener3 = (ActionEvent e) -> {
				System.out.println("Current Name is " + query.getText() + ", " + e.getActionCommand());
			};

		ActionListener myListener4 = (e) -> {
				System.out.println("Current Name is " + query.getText() + ", " + e.getActionCommand());
			};

		ActionListener myListener5 = (e) -> 
						System.out.println("Current Name is " + query.getText() + ", " + e.getActionCommand());

		ActionListener myListener6 = e -> 
						System.out.println("Current Name is " + query.getText() + ", " + e.getActionCommand());
		

		button.addActionListener(myListener2);

	}
	

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Current Name is " + query.getText());

		}
	}
}
