package com.esprit.badmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.badmanager.entities.Classroom;

public interface ClassroomRepository extends CrudRepository<Classroom,Long>{

	@Query("SELECT c from Classroom c where c.name = :name")
	Optional<Classroom> findClassByName(@Param("name")String name);
	// classroom by subject_id
//	@Query("SELECT u FROM Classroom c WHERE subjecr_id = :subject_id ")
//	Optional<List<Classroom>> findClassroomsBySubjectID(@Param("subject_id") long id);
	// classroom members by classromm_id
}
