package com.esprit.badmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/name")
	public Team getTeamByName(@RequestParam("name")String name) {
		return teamService.getTeamByName(name);
	}
	
	@GetMapping("/id")
	public Team getTeamById(@RequestParam("id")long id) {
		return teamService.getTeamById(id);
	}
	
	@PostMapping("/")
	public void createTeam(@RequestBody Team team) {
		teamService.saveOrUpdate(team);
	}
	
	@DeleteMapping("/id")
	public void deleteTeamById(@RequestParam("id")long id) {
		teamService.deleteById(id);
	}
}
