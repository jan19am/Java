package com.jonathanruiz.dojoandninjas.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jonathanruiz.dojoandninjas.models.Dojo;
import com.jonathanruiz.dojoandninjas.services.DojoService;
import com.jonathanruiz.dojoandninjas.services.NinjaService;



@Controller
public class DojoController {
	
	@Autowired
	public DojoService dService;
	
	@Autowired
	public NinjaService nService;
	
	@GetMapping("/dojo")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo, Model model){
		ArrayList<Dojo> dojos = new ArrayList<Dojo>();
		dojos = (ArrayList<Dojo>) dService.all();
		model.addAttribute("dojos", dojos);
		
		return "dojos.jsp";
	}
	
	@PostMapping("/dojo/new")
	public String createDojo(
			@Valid @ModelAttribute("dojo")Dojo dojo,
			BindingResult result) 
	{
		if(result.hasErrors()) {
			return "dojos.jsp";
		}
		dService.create(dojo);
		return "redirect:/ninja";
	}
	
	@GetMapping("/dojos/{dojo_id}")
	public String showDojo(@PathVariable Long dojo_id, Model model) {
	    
	    Dojo displayDojo = dService.find(dojo_id);
	    model.addAttribute("dojo", displayDojo);
	    
	    
	    return "showDojo.jsp";
	}
}
