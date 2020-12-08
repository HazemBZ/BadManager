package com.esprit.badmanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.badmanager.entities.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long>{
	
	@Query("SELECT s FROM Subject s where s.name = :name")
	Optional<Subject> findSubjectByName(@Param("name")String name);
	
	@Query("SELECT s FROM Subject s where s.title = :title")
	Optional<Subject> findSubjectByTitle(@Param("title")String title);
}
