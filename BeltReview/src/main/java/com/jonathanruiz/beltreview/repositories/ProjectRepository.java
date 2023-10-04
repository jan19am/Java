package com.jonathanruiz.beltreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonathanruiz.beltreview.models.Project;
import com.jonathanruiz.beltreview.models.User;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Long> {
	List<Project> findAll();
	
	List<Project> findByUsersNotContains(User u);
	
	List<Project> findByUsersContains(User u);
}
