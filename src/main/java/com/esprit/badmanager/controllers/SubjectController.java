package com.esprit.badmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.badmanager.entities.Subject;
import com.esprit.badmanager.services.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	@GetMapping("/all")
	public List<Subject> getSubjects(){
		System.out.println("ROUTE /subject/all");
		return subjectService.getSubjects();
	}
	
	@GetMapping("/all/join/users")
	public List<Subject> getSubjectsJoinUsers(){
		System.out.println("ROUTE /subject/all");
		return subjectService.getSubjectsJoinUsers();
	}

	@GetMapping("/id")
	public Subject getSubjectById(@RequestParam(name="id", required=false, defaultValue="1")long id) {
		System.out.println("ROUTE /subject/id/{id}  => name: "+id);
		return subjectService.getById(id);
	}
	
	@GetMapping("/name")
	public Subject getSubjectByName(@RequestParam(name="name")String name) {
		System.out.println("ROUTE /subject/name/{name}  => name: "+name);
		return subjectService.getByName(name);
	}
	
	@GetMapping("/title")
	public Subject getSubjectByTitle(@RequestParam(name="title")String title) {
		return subjectService.getByTitle(title);
	}
}
