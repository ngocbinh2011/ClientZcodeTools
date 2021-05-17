package com.java.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.DatabaseConnections.RequestActivity;
import com.java.NetworkConnection.Client;

public class loginFrame extends FrameApplication {

	/**
	 * 
	 */
	private JFrame frame;
	private JLabel labelUser, labelPassword;
	private JTextField textUser;
	private JPasswordField textPassword;
	private JButton buttonSignIn;
	private static final long serialVersionUID = 1L;
	
	public loginFrame(Client client) {
		frame = this;
		// TODO Auto-generated constructor stub
		this.setTitle("Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 1000);
		// label login
		labelUser = createLable("user", 500, 200, 150, 20);
		labelPassword = createLable("password", 500, 250, 150, 20);		
		labelUser.setVisible(true);
		labelPassword.setVisible(true);
		// text field login	
		textUser = createTextField(650, 200, 250, 30);
		textUser.setVisible(true);
		textPassword = creJPasswordField(650, 250, 250, 30);
		textPassword.setVisible(true);
		//button
		buttonSignIn = createButton("Sign in", 675, 350, 100, 40);
		buttonSignIn.setVisible(true);	
		clickButtonSignIn(client);
		// add
		this.add(buttonSignIn);
		this.add(textPassword);
		this.add(textUser);
		this.add(labelUser);
		this.add(labelPassword);
		this.setLayout(null);;
	}	
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void clickButtonSignIn(Client client) {
		loginFrame frame = this;
		buttonSignIn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userId = textUser.getText();
				@SuppressWarnings("deprecation")
				String password = textPassword.getText();
				Socket loginSocket;
				try {
					Socket connectServer = client.getSocketConnectToServer();
					DataOutputStream loginOutputStream = new DataOutputStream(connectServer.getOutputStream());
					loginOutputStream.writeUTF("login");
					loginOutputStream.writeUTF(userId);
					DataInputStream dataInputStream = new DataInputStream(connectServer.getInputStream());
					String passwordReal = dataInputStream.readUTF();
					if(passwordReal.equals("null")) {
						(new Notification("userId or password is incorrect")).setVisible(true);;
						return;
					}
					if(!passwordReal.equals(password)) {
						(new Notification("userId or password is incorrect")).setVisible(true);;
						return;
					}
					client.setAccessLogin(true);
					frame.setVisible(false);
					(new MainFrame()).setVisible(true);
					
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}				
				
			}
		});
	}
	

	
}
