package com.jonathanruiz.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanruiz.dojoandninjas.models.Ninja;
import com.jonathanruiz.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	public NinjaRepository nRepo;
	
	// Get all Ninjas in the database
	public List<Ninja> all() {
		return nRepo.findAll();
	}
	
	// Create new Ninja
	public Ninja create(Ninja n) {
		return nRepo.save(n);
	}
	
	// Get one Ninja out of database
	public Ninja find(Long id) {
		return nRepo.findById(id).orElse(null);
	}
}
