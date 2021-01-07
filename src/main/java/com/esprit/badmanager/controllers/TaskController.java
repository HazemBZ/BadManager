package com.esprit.badmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.badmanager.entities.Task;
import com.esprit.badmanager.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public Task createTask(@RequestBody Task task) {
		System.out.println("hit POST task/ req");
		return taskService.saveOrUpdate(task);	
		// Send emails here 
		// Need session management to keep track of sender
		
	}
	
	@PutMapping
	public Task updateTask(@RequestBody Task task) {
		System.out.println("hit PUT task/ req");
		System.out.println("Trying to save Task:");
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			System.out.println(mapper.writeValueAsString(task));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return taskService.saveOrUpdate(task);
//		 taskService.getTaskById(task.getId());
	}
	
	@GetMapping("/all")
	public List<Task> getTasks(){
		return taskService.getTasks();
	}
	
	@GetMapping("/id")
	public Task getTaskById(@RequestParam("id")Long id) {
		return taskService.getTaskById(id);
	}
	
	@GetMapping("/name")
	public Task getTaskByName(@RequestParam("name")String name) {
		return taskService.getTaskByName(name);
	}
	
	@GetMapping("/subjectId")
	public List<Task> getTaskBySubjectID(@RequestParam("id")Long id) {
		return taskService.getTasksBySubjectId(id);
	}
	
	
	
	@DeleteMapping("/id")
	public void deleteTaskById(@RequestParam("id")long id) {
		taskService.deleteById(id);
	}
	
	@DeleteMapping("/")
	public void deleteTask(@RequestBody Task task) {
		taskService.delete(task);
	}
}
