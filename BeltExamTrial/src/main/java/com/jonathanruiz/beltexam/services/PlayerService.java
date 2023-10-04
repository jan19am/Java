package com.jonathanruiz.beltexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanruiz.beltexam.models.Player;
import com.jonathanruiz.beltexam.repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository pRepo;
	
	public Player find(Long id) {
		return pRepo.findById(id).orElse(null);
	}
	
	public List<Player> all() {
		return pRepo.findAll();
	}
	
	public Player create(Player p) {
		return pRepo.save(p);
	}
	
}
