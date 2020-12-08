package com.esprit.badmanager.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name, title;
	
//	@ManyToMany
//	private List<User> subscribedMembers = new ArrayList<User>();
	@ManyToMany
	private List<Team> subscribedTeams ; 
	
	public Subject() {
		super();
	}
	public Subject(String name, String title) {
		super();
		this.name = name;
		this.title = title;
	}
	public Subject(String name, String title, List<User> members) {
		super();
		this.name = name;
		this.title = title;
//		this.subscribedMembers = members;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public List<User> getMembers() {
//		return subscribedMembers;
//	}
//	public void setMembers(List<User> members) {
//		this.subscribedMembers = members;
//	}
	public List<Team> getSubscribedGroups() {
		return subscribedTeams;
	}
	public void setSubscribedGroups(List<Team> subscribedGroups) {
		this.subscribedTeams = subscribedGroups;
	}
	
	
	
	
}
