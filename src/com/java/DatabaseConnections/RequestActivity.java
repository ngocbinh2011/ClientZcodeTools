package com.java.DatabaseConnections;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Zcode.Account;
import com.java.Zcode.Problem;

public class RequestActivity implements Session {

	@Override
	public Account getAccount(String userId) {
		// TODO Auto-generated method stub
		Connection connection = JDBCConnections.getConnection();
		if(connection == null) {
			return null;
		}
		String sql = "SELECT * FROM USER WHERE USERID = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
//				Blob blob = resultSet.getBlob(3);
				return new Account(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isLoginSuccess(String userId, String password) {
		// TODO Auto-generated method stub
		Account account = getAccount(userId);
		if(account == null) {
			return false;
		}
		return account.getPassword().equals(password);
	}
	
	public boolean checkLogin(String userId, String password) {
		return isLoginSuccess(userId, password);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Problem> getProblem(String id, String name) throws SQLException, IOException {
		List<Problem> list = new ArrayList<>();
		Connection connection = JDBCConnections.getConnection();
		if((name == null && id == null) || connection == null) {
			return list;
		}
		String sqlName = "SELECT * FROM DSA WHERE NAME = ?";
		String sqlID = "SELECT * FROM DSA WHERE ID = ?";
		if(name != null) {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlName);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String proCode = resultSet.getString(1);
				String proName = resultSet.getString(2);
				String topic = resultSet.getString(3);
				Blob blob = resultSet.getBlob(4);
				File file = new File(proCode + ".txt");
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				byte[] arr = blob.getBytes(1L, (int) blob.length());
				fileOutputStream.write(arr);
				fileOutputStream.close();

				list.add(new Problem(proCode, proName, topic, file));
			}
		}
		else {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlID);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String proCode = resultSet.getString(1);
				String proName = resultSet.getString(2);
				String topic = resultSet.getString(3);
				Blob blob = resultSet.getBlob(4);
				File file = new File(proCode + ".txt");
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				byte[] arr = blob.getBytes(1L, (int) blob.length());
				fileOutputStream.write(arr);
				fileOutputStream.close();
				list.add(new Problem(proCode, proName, topic, file));
				file.delete();
			}
			
		}
		return list;
	}



}

