package com.jonathanruiz.relationships.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jonathanruiz.relationships.models.License;
import com.jonathanruiz.relationships.services.LicenseService;
import com.jonathanruiz.relationships.services.PersonService;

@Controller
public class LicenseController {
private final LicenseService licenseService;
	
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@Autowired
	public PersonService personService;
	
	@GetMapping("/license")
	public String newLicense(@ModelAttribute("license")License license, Model model){
		ArrayList<License> licenses = new ArrayList<License>();
		licenses = (ArrayList<License>) licenseService.findAll();
		model.addAttribute("licenses", licenses);
		model.addAttribute("persons", personService.findAll());
		
		return "license.jsp";
	}
	
	@PostMapping("/license/new")
	public String create(
			@Valid @ModelAttribute("license")License license,
			BindingResult result)
	{
		if(result.hasErrors()) {
			return "license.jsp";
		}
		licenseService.createLicense(license);
		return "redirect:/person";
	}
}
