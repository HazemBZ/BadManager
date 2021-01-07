package com.esprit.badmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.badmanager.entities.Subject;
import com.esprit.badmanager.entities.Task;
import com.esprit.badmanager.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;
	
	public List<Task> getTasks(){
		return (List<Task>)taskRepo.findAll();
	}
	
	public Task getTaskById(long id) {
		return taskRepo.findById(id).orElse(null);
	}
	
	public Task getTaskByName(String name) {
		return taskRepo.findTaskByName(name).orElse(null);
	}
	
	public List<Task> getTasksBySubjectId(Long id) {
		return taskRepo.findTasksBySubjectId(id);
	}
	
	public Task saveOrUpdate(Task task) {
		return taskRepo.save(task);
	}
	
	public void delete(Task task) {
		taskRepo.delete(task);
	}
	
	public void deleteById(long id) {
		taskRepo.deleteById(id);
	}
	
	
}
