package com.esprit.badmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.badmanager.entities.Classroom;
import com.esprit.badmanager.entities.Task;
import com.esprit.badmanager.repositories.ClassroomRepository;

@Service
public class ClassroomService {

	@Autowired
	private ClassroomRepository classRepo;
	
	public List<Classroom> getClasses(){
		return 	(List<Classroom>)classRepo.findAll();
	}
	
	public Classroom getClassById(long id) {
		return classRepo.findById(id).orElse(null);
	}
	
	public Classroom  getClassByName(String name) {
		return classRepo.findClassByName(name).orElse(null);
	}
	

	public void saveOrUpdate(Classroom classroom) {
		classRepo.save(classroom);
	}
	
	public void delete(Classroom classroom) {
		classRepo.delete(classroom);
	}
	
	public void deleteById(long id) {
		classRepo.deleteById(id);
	}
}
