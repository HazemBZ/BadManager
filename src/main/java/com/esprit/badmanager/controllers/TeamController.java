package com.esprit.badmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.badmanager.entities.Team;
import com.esprit.badmanager.services.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@GetMapping("/all")
	public List<Team> getTeams(){
		return teamService.getTeams();
	}
	
	@GetMapping("/name/{name}")
	public Team getTeamByName(@PathVariable("name")String name) {
		return teamService.getTeamByName(name);
	}
	
	@GetMapping("/id/{id}")
	public Team getTeamById(@PathVariable("id")long id) {
		return teamService.getTeamById(id);
	}
	
	
}
