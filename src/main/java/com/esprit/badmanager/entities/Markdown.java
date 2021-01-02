package com.esprit.badmanager.entities;

public class Markdown {
	private String data;

	// important to add empty constructor
	public Markdown() {
		super();
	}
	
	public Markdown(String data) {
		super();
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
