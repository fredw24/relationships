package com.codingdojo.relationship.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.relationship.models.License;
import com.codingdojo.relationship.repositories.LicenseRepository;

public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicenses() {
        return licenseRepository.findAll();
    }
	
	public License createLicense(License p) {
		return licenseRepository.save(p);
		
	}
	
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		}
		else {
			return null;
		}
	}
}
