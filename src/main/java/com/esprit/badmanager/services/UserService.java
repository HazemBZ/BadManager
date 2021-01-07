package com.esprit.badmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.badmanager.entities.User;
import com.esprit.badmanager.entities.User;
import com.esprit.badmanager.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> getUsers(){
		return (List<User>)userRepo.findAll();
	}
	
	public User getUserById(long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public User getUserByName(String name) {
		return userRepo.findUserByName(name).orElse(null);
	}
	
	
	public User saveOrUpdate(User user) {
		return userRepo.save(user);
	}
	
	public void delete(User user) {
		userRepo.delete(user);
	}
	
	public void deleteById(long id) {
		userRepo.deleteById(id);
	}

}
