package com.jonathanruiz.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jonathanruiz.relationships.models.License;
import com.jonathanruiz.relationships.repositories.LicenseRepository;



@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;

	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;  
	}
	public License createLicense(License b) {
        return licenseRepository.save(b);
    }
	public List<License> findAll() {
		return licenseRepository.findAll();
	}
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
	}
	public License findLicense(Long id) {
		return licenseRepository.findById(id).orElse(null);
    }
}
