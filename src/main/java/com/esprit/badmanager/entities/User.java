package com.esprit.badmanager.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
public class User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	@ManyToMany
//	@JsonManagedReference
	private List<Team> joinedTeams;
	
	public User() {
		super();
	}
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User{"+"id="+this.id+", name="+this.name+" ,email="+this.email+"}";
	}
	
	
	public List<Team> getGroups() {
		return joinedTeams;
	}
	public void setGroups(List<Team> teams) {
		this.joinedTeams = teams;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Team> getJoinedTeams() {
		return joinedTeams;
	}
	public void setJoinedTeams(List<Team> joinedTeams) {
		this.joinedTeams = joinedTeams;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static String toString(List<User> users) {
		String base ="\n";
		for (User user : users) {
			base+=user.toString()+"\n";
		}
		return base;
	}
}
