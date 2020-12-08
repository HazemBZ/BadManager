package com.esprit.badmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.badmanager.entities.User;
import com.esprit.badmanager.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User getUserById(long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public User getUserByName(String name) {
		return userRepo.findUserByName(name).orElse(null);
	}
	
	public List<User> getUsers(){
		return (List<User>)userRepo.findAll();
	}
}
