package com.java.NetworkConnection;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.java.GUI.AddressFrame;
import com.java.GUI.MainFrame;
import com.java.GUI.loginFrame;

public class Client {
	
	private String ip;
	private String hostName;
	private int port;
	private boolean isAccessAddress;
	private boolean isAccessLogin;
	private Socket socketConnectToServer;

	public Client() {
		
//		clientAddressApplication = new AddressFrame(this);
//		clientAddressApplication.setVisible(true);
		
	}
	
	public boolean isAccessAddress() {
		return isAccessAddress;
	}

	public void setAccessAddress(boolean isAccessAddress) {
		this.isAccessAddress = isAccessAddress;
	}

	public boolean isAccessLogin() {
		return isAccessLogin;
	}

	public void setAccessLogin(boolean isAccessLogin) {
		this.isAccessLogin = isAccessLogin;
	}

	public Client(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public Client(String ip, String hostName, int port) {
		super();
		this.ip = ip;
		this.hostName = hostName;
		this.port = port;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Socket getSocketConnectToServer() {
		return socketConnectToServer;
	}
	
	public Socket getConnectWithIP() {
		try {
			return new Socket(ip, port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setSocketConnectToServer(Socket socketConnectToServer) {
		this.socketConnectToServer = socketConnectToServer;
	}

}
