package com.esprit.badmanager.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name, description;
	private float duration; 
	@ManyToOne()
	private Subject subject;
	
	@ManyToMany
	@JsonManagedReference
	private List<Team> teams;

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(String name, String description, Subject subject, List<Team> teams) {
		super();
		this.name = name;
		this.description = description;
		this.subject = subject;
		this.teams = teams;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	
	
}
