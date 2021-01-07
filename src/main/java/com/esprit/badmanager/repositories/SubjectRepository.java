package com.esprit.badmanager.repositories;

import java.util.List;
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
	
	@Query("SELECT s.id as subject_id, s.title as subject_title, u.id as user_id, u.name as user_name, u.email as user_email, s.classroom FROM Subject s LEFT JOIN User u ON s.tutor_id = u.id")
	Optional<List<Subject>> findSubjectsJoinUsers();
}
