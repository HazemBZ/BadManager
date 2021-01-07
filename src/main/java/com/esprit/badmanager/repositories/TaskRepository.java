package com.esprit.badmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.badmanager.entities.Subject;
import com.esprit.badmanager.entities.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long>{
	
	@Query("SELECT t FROM Task t where t.name = :name")
	Optional<Task> findTaskByName(@Param("name")String name);
	
	@Query("SELECT t FROM Task t where t.subject_id = :id")
	List<Task> findTasksBySubjectId(@Param("id")Long id);
	
}
