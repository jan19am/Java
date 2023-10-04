package com.jonathanruiz.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jonathanruiz.relationships.models.Person;
import com.jonathanruiz.relationships.repositories.PersonRepository;


@Service
public class PersonService {
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;  
	}
	public Person createPerson(Person b) {
        return personRepository.save(b);
    }
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
	public Person find(Long id) {
		return personRepository.findById(id).orElse(null);
    }

}
