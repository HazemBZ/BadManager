package com.esprit.badmanager.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="users")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private String type;
	@ManyToMany
//	@JsonManagedReference(value="membership")
	private List<Team> joinedTeams;
	@ManyToMany
	private List<Classroom> classrooms = new ArrayList<Classroom>(); 
	
	public User() {
		super();
	}
	public User(String name, String email, String type) {
		super();
		this.name = name;
		this.email = email;
		this.type = type;
	}
	
	
	
	
	public List<Classroom> getClassrooms() {
		return classrooms;
	}
	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}
	
	// Not production ready !!
	public Classroom getClassroom(int id) {
		return this.classrooms.get(id);
	}
	// Not production ready !!
	public void addClassroom(Classroom clr) {
		this.addClassroom(clr);
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
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static String toString(List<User> users) {
		String base ="\n";
		for (User user : users) {
			base+=user.toString()+"\n";
		}
		return base;
	}
}
