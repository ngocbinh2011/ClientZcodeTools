package com.java.GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.DatabaseConnections.RequestActivity;
import com.java.Zcode.Problem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTextField codeField;
	private JTextField nameField;
	private JButton buttonSubmit, buttonExit;
	private JTextArea textAreaCode, textAreaResult;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		MainFrame frameExit = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Zcode Tools");
		setBounds(100, 100, 1341, 784);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel codeLabel = new JLabel("M\u00E3 b\u00E0i");
		codeLabel.setBackground(Color.BLUE);
		codeLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		codeLabel.setBounds(12, 85, 100, 32);
		contentPanel.add(codeLabel);
		
		JLabel nameLabel = new JLabel("T\u00EAn B\u00E0i");
		nameLabel.setBackground(Color.RED);
		nameLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		nameLabel.setBounds(12, 138, 90, 32);
		contentPanel.add(nameLabel);
		
		codeField = new JTextField();
		codeField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		codeField.setBounds(108, 76, 255, 44);
		contentPanel.add(codeField);
		codeField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameField.setBounds(108, 133, 255, 42);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setForeground(Color.RED);
		buttonSubmit.setBackground(Color.LIGHT_GRAY);
		buttonSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonSubmit.setBounds(118, 200, 118, 42);
		buttonSubmit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String proId = codeField.getText();
				String proName = nameField.getText();
				List<Problem> list;
				try {
					list = (new RequestActivity()).getProblem(proId, proName);
					if(list.isEmpty()) return;
					Problem problem = list.get(0);
					textAreaResult.append(problem.getId() + " " + problem.getName());;
					File file = problem.getFile();
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					String str;
					while((str = bufferedReader.readLine()) != null) {
						textAreaCode.append(str + "\n");
					}
					System.out.println(file.exists());
					file.delete();
					System.out.println(file.exists());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPanel.add(buttonSubmit);
		
		JLabel lblNewLabel_2 = new JLabel("Download Code");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Poor Richard", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(484, 13, 169, 44);
		contentPanel.add(lblNewLabel_2);
		
		textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 25));
		textAreaResult.setBounds(12, 343, 442, 290);
		contentPanel.add(textAreaResult);
		
		JLabel lblNewLabel_3 = new JLabel("K\u1EBFt Qu\u1EA3");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(190, 646, 70, 16);
		contentPanel.add(lblNewLabel_3);
		
		textAreaCode = new JTextArea();
		textAreaCode.setForeground(Color.BLUE);
		textAreaCode.setBackground(Color.WHITE);
		textAreaCode.setFont(new Font("Consolas", Font.PLAIN, 17));
		JScrollPane scrollPane = new JScrollPane(textAreaCode);
		scrollPane.setBounds(600, 75, 700, 565);
		contentPanel.add(scrollPane);
		
		buttonExit = new JButton("Exit");
		buttonExit.setBounds(1200, 692, 100, 32);
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frameExit.setVisible(false);
			}
		});	
		contentPanel.add(buttonExit);
		
	}
	
	public static void main(String[] args) {
		(new MainFrame()).setVisible(true);
	}
}
