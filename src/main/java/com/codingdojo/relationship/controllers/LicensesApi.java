package com.codingdojo.relationship.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.relationship.models.License;
import com.codingdojo.relationship.models.Person;
import com.codingdojo.relationship.repositories.PersonRepository;
import com.codingdojo.relationship.services.LicenseService;
import com.codingdojo.relationship.services.PersonService;

@RestController
public class LicensesApi {
	private final LicenseService licenseService;
	private final PersonService personService;
    public LicensesApi(LicenseService licenseService, PersonService personService){
        this.licenseService = licenseService;
        this.personService = personService;
    }
    @RequestMapping("/api/licenses")
    public List<License> index() {
        return licenseService.allLicenses();
    }
    
    @RequestMapping(value="/api/licenses", method=RequestMethod.POST)
    public License create(@RequestParam(value="expirationDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date expire, @RequestParam(value="state") String state, @RequestParam(value="id") Long id) {
        
    	Person person = personService.findPerson(id);
    	int currentNumber = licenseService.allLicenses().size()+1;
    	String[] num = {"0","0","0","0","0"};
    	String stringCurrent = String.valueOf(currentNumber);
    	String[] cur = stringCurrent.split("");
    	for (int i = 0; i < cur.length;i++) {
    		num[num.length-1-i]=cur[cur.length-1-i];
    	}
    	
    	String number = String.join("", cur);
    	
    	License license = new License(number, expire, state, person);
        return licenseService.createLicense(license);
    }
    
    @RequestMapping("/api/licenses/{id}")
    public License show(@PathVariable("id") Long id) {
        License License = licenseService.findLicense(id);
        return License;
    }
}
