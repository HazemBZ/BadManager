package com.esprit.badmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return subjectService.getSubjects();
	}

	@GetMapping("/id/{id}")
	public Subject getSubjectById(@PathVariable("id")long id) {
		return subjectService.getById(id);
	}
	
	@GetMapping("/name/{name)")
	public Subject getSubjectByName(@PathVariable("name")String name) {
		return subjectService.getByName(name);
	}
	
	@GetMapping("/title/{title}")
	public Subject getSubjectByTitle(@PathVariable("title")String title) {
		return subjectService.getByTitle(title);
	}
}
