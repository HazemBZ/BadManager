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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.badmanager.entities.Classroom;
import com.esprit.badmanager.services.ClassroomService;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;
	
	@GetMapping("/all")
	public List<Classroom> getClassroomes(){
		return classroomService.getAllClassrooms();
	}
	
	@GetMapping("/id")
	public Classroom getClassroomById(@RequestParam("id")long id) {
		return classroomService.getClassroomById(id);
	}
	
	@GetMapping("/name")
	public Classroom getClassroomByName(@RequestParam("name")String name) {
		return classroomService.getClassroomByName(name);
	}
	
	@PostMapping("/")
	public void createCalssroom(@RequestBody Classroom classroom) {
		classroomService.saveOrUpdate(classroom);
	}
	
	@PutMapping("/")
	public void updateCalssroom(@RequestBody Classroom classroom) {
		classroomService.saveOrUpdate(classroom);
	}
	
	@DeleteMapping("/id")
	public void deleteById(@RequestParam("id")long id) {
		classroomService.deleteById(id);
	}
	
}
