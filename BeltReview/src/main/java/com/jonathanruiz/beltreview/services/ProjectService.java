package com.jonathanruiz.beltreview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanruiz.beltreview.models.Project;
import com.jonathanruiz.beltreview.models.User;
import com.jonathanruiz.beltreview.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired 
	private UserService uServ;
	
	public Project findById(Long id) {
		
		Optional<Project> result = projectRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		
		return null;
	}
	

	public List<Project> all() {
		return projectRepo.findAll();
	}
	
	public Project addToUsers(Long projectId, Long userId) {
		Project p = findById(projectId);
		User u = uServ.findById(userId);
		
		p.getUsers().add(u);
//		projectRepo.save(p);
		
		return projectRepo.save(p);
	}
	
	public List<Project> uncollected(User u) {
		return projectRepo.findByUsersNotContains(u);
	}
	
	public List<Project> joinedProjects(User u) {
		return projectRepo.findByUsersContains(u);
	}
	
	public Project update(Project project) {
		return projectRepo.save(project);
	}
	
	public Project create(Project project) {
		return projectRepo.save(project);
	}
	
	public void delete(Project project) {
		projectRepo.delete(project);
	}
}
