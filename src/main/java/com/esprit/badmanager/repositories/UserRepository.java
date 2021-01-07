package com.esprit.badmanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.badmanager.entities.User;


public interface UserRepository extends CrudRepository<User,Long>{
	
	@Query("SELECT u from User u where u.name = :name")
	Optional<User> findUserByName(@Param("name")String name);
}
