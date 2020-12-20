package com.esprit.badmanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.badmanager.entities.Task;

public interface TaskRepository extends CrudRepository<Task,Long>{
	
	@Query("SELECT t FROM Task t where t.name = :name")
	Optional<Task> findTaskByName(@Param("name")String name);
}
