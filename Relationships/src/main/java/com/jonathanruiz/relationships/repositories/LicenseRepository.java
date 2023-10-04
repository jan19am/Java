package com.jonathanruiz.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonathanruiz.relationships.models.License;


@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	// this method retrieves all the expenses from the database
	List<License> findAll();

}
