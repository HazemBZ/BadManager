package com.esprit.badmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.badmanager.entities.Team;
import com.esprit.badmanager.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepo;
	
	public Team getGroupById(long id) {
		return teamRepo.findById(id).orElse(null);
	}
	
	public Team getGroupByName(String name) {
		return teamRepo.findByName(name).orElse(null);
	}
}
