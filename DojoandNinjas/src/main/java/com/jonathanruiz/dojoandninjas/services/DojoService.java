package com.jonathanruiz.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanruiz.dojoandninjas.models.Dojo;
import com.jonathanruiz.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	public DojoRepository dRepo;
	
	// Get all dojos in the database
	public List<Dojo> all() {
		return dRepo.findAll();
	}
	
	// Create new Dojo
	public Dojo create(Dojo d) {
		return dRepo.save(d);
	}
	
	// Get one Dojo out of database
	public Dojo find(Long id) {
		return dRepo.findById(id).orElse(null);
	}
}
