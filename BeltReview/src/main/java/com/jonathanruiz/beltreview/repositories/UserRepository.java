package com.jonathanruiz.beltreview.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonathanruiz.beltreview.models.Project;
import com.jonathanruiz.beltreview.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	
	List<User> findAll();
	
	List<User> findByProjectsNotContains(Project p);

}