package com.esprit.badmanager.entities;

import java.util.List;

public class Mail {
	
	private List<String> recipientsList;
	private String subject; 
	private String content;
	public List<String> getRecipientsList() {
		return recipientsList;
	}
	public void setRecipientsList(List<String> recipientsList) {
		this.recipientsList = recipientsList;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
