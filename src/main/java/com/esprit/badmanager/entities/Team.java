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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name ;
	@ManyToMany
	@JoinTable(
			name="team_membership",
			joinColumns= @JoinColumn(name="team_id"),
			inverseJoinColumns= @JoinColumn(name="users_id"))
	@JsonBackReference(value="membership") // does not try to serialize members attribute
//	@JsonManagedReference
	private List<User> members = new ArrayList<User>();
	@ManyToMany()
	@JoinTable(
			name="team_subscription",
			joinColumns= @JoinColumn(name="team_id"),
			inverseJoinColumns= @JoinColumn(name="subject_id"))
	private List<Subject> subjectSubscriptions = new ArrayList<Subject>();
	
	@ManyToMany
	@JoinTable(
			name="task_submissions",
			joinColumns= @JoinColumn(name="task_id"),
			inverseJoinColumns = @JoinColumn(name="team_id"))
	@JsonBackReference(value="task_submissions")
	private List<Task> taskSubmissions = new ArrayList<Task>();
	
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
	
	
	
	public List<Subject> getSubjectSubscriptions() {
		return subjectSubscriptions;
	}
	public void setSubjectSubscriptions(List<Subject> subjectSubscriptions) {
		this.subjectSubscriptions = subjectSubscriptions;
	}
	public List<Task> getTaskSubmissions() {
		return taskSubmissions;
	}
	public void setTaskSubmissions(List<Task> taskSubmissions) {
		this.taskSubmissions = taskSubmissions;
	}
	@Override
	public String toString() {
		return "Group{id="+this.id+" ,name="+this.name+" ,members"+User.toString(this.members);
	}
}
