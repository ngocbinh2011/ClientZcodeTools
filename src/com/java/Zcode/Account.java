package com.java.Zcode;

import java.io.File;
import java.sql.Date;

public class Account {
	
	private String userId;
	private String password;
	private Date closest;
	private File history;
	
	public Account() {
		
	}
	
	public Account(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	public Account(String userId, String password, Date closest) {
		this.userId = userId;
		this.password = password;
		this.closest = closest;
	}
	
	public Account(String userId, String password, Date closest, File history) {
		this.userId = userId;
		this.password = password;
		this.closest = closest;
		this.history = history;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getClosest() {
		return closest;
	}
	public void setClosest(Date closest) {
		this.closest = closest;
	}
	public File getHistory() {
		return history;
	}
	public void setHistory(File history) {
		this.history = history;
	}
	
	
}
