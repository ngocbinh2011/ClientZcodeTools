package com.java.GUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrameApplication extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Font font = new Font("PLAIN", 3, 20);
	private static final Font font_text_field = new Font("PLAIN", 2, 16);
	
	protected JLabel createLable(String labelName, int x, int y, int width, int height) {
		JLabel label = new JLabel(labelName);
		label.setFont(font);
		label.setBounds(x, y, width, height);
		return label;
	}
	
	protected JTextField createTextField(int x, int y, int width, int height) {
		JTextField textField = new JTextField();
		textField.setFont(font_text_field);
		textField.setBounds(x, y, width, height);
		return textField;
	}
	
	protected JButton createButton(String text, int x, int y, int width, int height) {
		JButton button = new JButton(text);
		button.setFont(font_text_field);
		button.setBounds(x, y, width, height);
		return button;
	}
	
	protected JPasswordField creJPasswordField(int x, int y, int width, int height) {
		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(font_text_field);
		passwordField.setBounds(x, y, width, height);
		return passwordField;
	}
	
}
