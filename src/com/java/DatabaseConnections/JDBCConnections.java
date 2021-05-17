package com.java.DatabaseConnections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnections {
	
	private static final String url_jdbc = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String user = "root";
	private static final String password = "20112001";
	private static final String database_name = "Zcode";

	public static Connection getConnection() {
			
		try {
			Class.forName(url_jdbc);
			return DriverManager.getConnection(url + database_name, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return null;
		
	}
}
