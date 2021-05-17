package com.java.GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.NetworkConnection.Client;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;

public class AddressFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ipTextField;
	private JTextField portTextField;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AddressFrame(Client client) {
		AddressFrame addressFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel ipLabel = new JLabel("IP Address");
		ipLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		ipLabel.setBounds(207, 77, 119, 26);
		contentPane.add(ipLabel);
		
		JLabel portLabel = new JLabel("Port Server");
		portLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		portLabel.setBounds(207, 129, 105, 25);
		contentPane.add(portLabel);
		
		ipTextField = new JTextField();
		ipTextField.setBounds(338, 70, 203, 34);
		contentPane.add(ipTextField);
		ipTextField.setColumns(10);
		
		portTextField = new JTextField();
		portTextField.setBounds(338, 120, 203, 34);
		contentPane.add(portTextField);
		portTextField.setColumns(10);
		
		JButton buttonSubmit = new JButton("Connect");
		buttonSubmit.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		buttonSubmit.setBounds(310, 181, 110, 34);
		buttonSubmit.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ip = ipTextField.getText();
				int port = Integer.parseInt(portTextField.getText());
				client.setIp(ip);
				client.setPort(port);
				Socket socketConnectServer = client.getConnectWithIP();
				if(socketConnectServer == null) {
					(new Notification("IP or Port is incorrect")).setVisible(true);
					return;
				}
				client.setSocketConnectToServer(socketConnectServer);
				client.setAccessAddress(true);
				addressFrame.setVisible(false);
				(new loginFrame(client)).setVisible(true);
			}
		});
		contentPane.add(buttonSubmit);
	}
	
	public static void main(String[] args) {
		(new AddressFrame(new Client())).setVisible(true);
	}
	
	
}
