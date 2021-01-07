package com.esprit.badmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.badmanager.entities.User;


public interface UserRepository extends CrudRepository<User,Long>{
	
	@Query("SELECT u from User u where u.name = :name")
	Optional<User> findUserByName(@Param("name")String name);
	// classroom members by subject_id
//	@Query(
//	"SELECT c.members FROM Classroom c, Subject s, Task t WHERE t.subject_id = s.id"
//	+ " AND s.id "
//	)
//	Optional<List<User>> findClassRoomMembersBySubjectId(@Param("subject_id")String subject_id);
}
