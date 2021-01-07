package com.esprit.badmanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.badmanager.entities.Classroom;

public interface ClassroomRepository extends CrudRepository<Classroom,Long>{

	@Query("SELECT c from Classroom c where c.name = :name")
	Optional<Classroom> findClassByName(@Param("name")String name);
	// classroom members by classroom_name
//	@Query("SELECT u FROM Classroom c, User u, ")
	
	// classroom members by classromm_id
}
