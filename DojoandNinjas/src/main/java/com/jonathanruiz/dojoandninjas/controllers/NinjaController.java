package com.jonathanruiz.dojoandninjas.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.jonathanruiz.dojoandninjas.models.Ninja;
import com.jonathanruiz.dojoandninjas.services.DojoService;
import com.jonathanruiz.dojoandninjas.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	public NinjaService nService;
	
	@Autowired
	public DojoService dService;
	
	@GetMapping("/ninja")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
		ArrayList<Ninja> ninjas = new ArrayList<Ninja>();
		ninjas = (ArrayList<Ninja>) nService.all();
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojos", dService.all());
		
		return "ninjas.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String createNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result)
	{
		if(result.hasErrors()) {
			return "ninjas.jsp";
		}
		nService.create(ninja);
		return "redirect:/dojo";
	}
}
