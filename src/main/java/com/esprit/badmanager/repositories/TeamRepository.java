package com.esprit.badmanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.badmanager.entities.Team;

public interface TeamRepository extends CrudRepository<Team, Long>{

	@Query("SELECT t FROM Team t where t.name = :name")
	Optional<Team> findByName(@Param("name")String name);
	
}
