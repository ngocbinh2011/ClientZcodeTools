package com.java.Zcode;

import java.io.File;

public class Problem {
	private String id;
	private String name;
	private String topic;
	private File file;
	
	public Problem() {
		
	}
	
	public Problem(String id, String name, File file) {
		super();
		this.id = id;
		this.name = name;
		this.file = file;
	}
	
	public Problem(String id, String name, String topic, File file) {
		super();
		this.id = id;
		this.name = name;
		this.topic = topic;
		this.file = file;
	}
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTopic() {
		return topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public File getFile() {
		return file;
	}
	

	public void setFile(File file) {
		this.file = file;
	}
	
	
}
