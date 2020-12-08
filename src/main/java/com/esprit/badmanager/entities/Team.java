package com.esprit.badmanager.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name ;
	@ManyToMany
	@JoinTable(
			name="team_join",
			joinColumns= @JoinColumn(name="team_id"),
			inverseJoinColumns= @JoinColumn(name="users_id"))
	@JsonBackReference
	private List<User> members = new ArrayList<User>();
	@ManyToMany()
	@JoinTable(
			name="team_subscription",
			joinColumns= @JoinColumn(name="team_id"),
			inverseJoinColumns= @JoinColumn(name="subject_id"))
	private List<Subject> subjectSubscriptions = new ArrayList<Subject>();
	
	public Team() {
		super();
	}
	public Team(String name) {
		super();
		this.name = name;
	}
	public Team(String name, List<User> members) {
		super();
		this.name = name;
		this.members = members;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getMembers() {
		return members;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	
	@Override
	public String toString() {
		return "Group{id="+this.id+" ,name="+this.name+" ,members"+User.toString(this.members);
	}
}
