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

import com.esprit.badmanager.entities.Task;
import com.esprit.badmanager.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;	
	
	@GetMapping("/all")
	public List<Task> getTasks(){
		return taskService.getTasks();
	}
	
	@GetMapping("/id/{id}")
	public Task getClassById(@PathVariable("id")Long id) {
		return taskService.getTaskById(id);
	}
	
	@GetMapping("/name/{name}")
	public Task getClassByName(@PathVariable("name")String name) {
		return taskService.getTaskByName(name);
	}
	
	@PostMapping("/")
	public Task createTask(@RequestBody Task task) {
		 taskService.saveOrUpdate(task);
		 return taskService.getTaskById(task.getId());
	}
	
	@PutMapping("/")
	public Task updateTask(@RequestBody Task task) {
		taskService.saveOrUpdate(task);
		return taskService.getTaskById(task.getId());
	}
	
	@DeleteMapping("/id/{id}")
	public void deleteTaskById(@PathVariable("id")long id) {
		taskService.deleteById(id);
	}
	
	@DeleteMapping("/")
	public void deleteTask(@RequestBody Task task) {
		taskService.delete(task);
	}
}
