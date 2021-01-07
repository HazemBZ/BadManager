package com.esprit.badmanager.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name, title; // NAME: simple name, TITLE: name + class
	private long tutor_id ;
	
//	@ManyToMany
//	private List<User> subscribedMembers = new ArrayList<User>();
	@ManyToMany
	private List<Team> subscribedTeams = new ArrayList<Team>();
	
	@OneToMany//(fetch=FetchType.LAZY, mappedBy="subject")
	private List<Task> tasks = new ArrayList<Task>();
	
	@ManyToOne
	private Classroom classroom;
	
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
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public long getTutor_id() {
		return tutor_id;
	}
	public void setTutor_id(long tutor_id) {
		this.tutor_id = tutor_id;
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
	
	
	public long getTutor() {
		return tutor_id;
	}
	public void setTutor(long tutor) {
		this.tutor_id = tutor;
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
	public List<Team> getSubscribedTeams() {
		return subscribedTeams;
	}
	public void setSubscribedTeams(List<Team> subscribedTeams) {
		this.subscribedTeams = subscribedTeams;
	}
//	public List<Task> getTasks() {
//		return tasks;
//	}
//	public void setTasks(List<Task> tasks) {
//		this.tasks = tasks;
//	}
//	
//	public void addTask(Task t) {
//		this.tasks.add(t);
//	}
//	
	
}
