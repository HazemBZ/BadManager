package com.esprit.badmanager.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name, description;
	private float duration;
//	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Subject.class)
//	@JsonManagedReference
	@JoinColumn(name="subject_id", referencedColumnName="id")
	private long subject_id;
	
	@ManyToMany
//	@JsonManagedReference(value="task_submissions")
	private List<Team> teams;

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Task(String name, String description, long subject) {
		super();
		this.name = name;
		this.description = description;
		this.subject_id = subject;
	}
	
	public Task(String name, String description, long subject, List<Team> teams) {
		super();
		this.name = name;
		this.description = description;
		this.subject_id = subject;
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

	public long getSubject() {
		return subject_id;
	}

	public void setSubject(long subject) {
		this.subject_id = subject;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	
	
}
