package com.jonathanruiz.beltexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanruiz.beltexam.models.Team;
import com.jonathanruiz.beltexam.repositories.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository tRepo;
	
	public Team find(Long id) {
		return tRepo.findById(id).orElse(null);
	}
	
	public List<Team> all() {
		return tRepo.findAll();
	}
	
	public Team update(Team t) {
		return tRepo.save(t);
	}
	
	public Team create(Team t) {
		return tRepo.save(t);
	}
	
	public void destroy(Long id) {
		tRepo.deleteById(id);
	}
}
