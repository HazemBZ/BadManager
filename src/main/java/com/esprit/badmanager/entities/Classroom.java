package com.esprit.badmanager.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Classroom {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	@ManyToMany
	private List<User> members = new ArrayList<User>();
	
	@OneToMany
	private List<Subject> subjects = new ArrayList<Subject>();
	
	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classroom(String name, List<User> members, List<Subject> subjects) {
		super();
		this.name = name;
		this.members = members;
		this.subjects = subjects;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	// Not Prod ready !!
	public void addMember(User user) {
		this.members.add(user);
	}
	
	// Not Prod ready !!
	public User removeMember(int index) {
		return this.members.remove(index);
	}
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void addSubject(Subject s) {
		subjects.add(s);
	}
	
	
}
