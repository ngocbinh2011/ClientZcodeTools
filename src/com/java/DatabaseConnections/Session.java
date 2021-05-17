package com.java.DatabaseConnections;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.java.Zcode.Account;
import com.java.Zcode.Problem;

public interface Session {
	
	Account getAccount(String userId);

	List<Problem> getProblem(String id, String name) throws SQLException, IOException;
	
	boolean isLoginSuccess(String user, String password);
	
	void updateAccount(Account account);

}
