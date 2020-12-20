package com.esprit.badmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.badmanager.entities.Classroom;
import com.esprit.badmanager.services.ClassroomService;

@RestController
@RequestMapping("/class")
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;
	
	@GetMapping("/all")
	public List<Classroom> getClasses(){
		return classroomService.getClasses();
	}
	
	@GetMapping("/id/{id}")
	public Classroom getClassById(@PathVariable("id")Long id) {
		return classroomService.getClassById(id);
	}
	
	@GetMapping("/name/{name}")
	public Classroom getClassByName(@PathVariable("name")String name) {
		return classroomService.getClassByName(name);
	}
	
	@PostMapping("/")
	public void createCalssroom(@RequestBody Classroom classroom) {
		classroomService.saveOrUpdate(classroom);
	}
	
	@PutMapping("/")
	public void updateCalssroom(@RequestBody Classroom classroom) {
		classroomService.saveOrUpdate(classroom);
	}
	
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable("id")Long id) {
		classroomService.deleteById(id);
	}
	
}
