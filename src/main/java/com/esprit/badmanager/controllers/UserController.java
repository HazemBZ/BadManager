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

import com.esprit.badmanager.entities.User;
import com.esprit.badmanager.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@GetMapping("/id")
	public User getUserById(@RequestParam("id")/*@RequestParam("id")*/long id) {
		System.out.println("HIT /id?id="+id);
		return userService.getUserById(id);
	}
	
	@GetMapping("/name")
	public User getUserByName(@RequestParam("name")String name) {
		System.out.println("HIT /name"+name);
		return userService.getUserByName(name);
	}
	
	@DeleteMapping("/id")
	public String deleteuserById(@RequestParam("id")long id) {
		  userService.deleteById(id);
		  return "DELETED";
	}
	
	@DeleteMapping("/")
	public void deleteuser(@RequestBody User user) {
		userService.delete(user);
	}
	
	@PostMapping
	public User createuser(@RequestBody User user) {
		System.out.println("hit POST user/ req");
		userService.saveOrUpdate(user);	
		return userService.getUserById(user.getId());
	}
	
	@PutMapping
	public User updateuser(@RequestBody User user) {
		System.out.println("hit PUT user/ req");
		System.out.println("Trying to save user:");
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(user));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userService.saveOrUpdate(user);
//		 userService.getuserById(user.getId());
	}
	
}
