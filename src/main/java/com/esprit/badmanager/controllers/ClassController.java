package com.esprit.badmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.badmanager.entities.Classroom;
import com.esprit.badmanager.services.ClassService;

@RestController
@RequestMapping("/class")
public class ClassController {

	@Autowired
	private ClassService classService;
	
	@GetMapping("/all")
	public List<Classroom> getClasses(){
		return classService.getClasses();
	}
	
	@GetMapping("/id/{id}")
	public Classroom getClassById(@PathVariable("id")Long id) {
		return classService.getClassById(id);
	}
	
	@GetMapping("/name/{name}")
	public Classroom getClassByName(@PathVariable("name")String name) {
		return classService.getClassByName(name);
	}
	
	
	
}
