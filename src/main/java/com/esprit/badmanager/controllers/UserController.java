package com.esprit.badmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.badmanager.entities.User;
import com.esprit.badmanager.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<User> getUsers(){
		System.out.println("HIT /all");
		return userService.getUsers();
	}
	
	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable("id")/*@RequestParam("id")*/long id) {
		System.out.println("HIT /id/"+id);
		return userService.getUserById(id);
	}
	
	@GetMapping("/name/{name}")
	public User getUserByName(@PathVariable("name")String name) {
		System.out.println("HIT /name"+name);
		return userService.getUserByName(name);
	}
}
