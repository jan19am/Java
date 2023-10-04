package com.jonathanruiz.relationships.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jonathanruiz.relationships.models.Person;
import com.jonathanruiz.relationships.services.PersonService;

@Controller
public class PersonController {
private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	
	@GetMapping("/person")
	public String newPerson(@ModelAttribute("person")Person person, Model model){
		ArrayList<Person> persons = new ArrayList<Person>();
		persons = (ArrayList<Person>) personService.findAll();
		model.addAttribute("persons", persons);
		return "person.jsp";
	}
	
	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id, Model model) {
	    
	    Person someAwesomePerson = personService.find(person_id);
	    model.addAttribute("person", someAwesomePerson);
	    
	    return "showPerson.jsp";
	}
	
	@PostMapping("/person/new")
	public String create(
			@Valid @ModelAttribute("person")Person person,
			BindingResult result)
	{
		if(result.hasErrors()) {
			return "person.jsp";
		}
		personService.createPerson(person);
		return "redirect:/license";
	}
}
