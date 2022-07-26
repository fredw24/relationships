package com.codingdojo.relationship.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationship.models.License;
import com.codingdojo.relationship.models.Person;
import com.codingdojo.relationship.services.LicenseService;
import com.codingdojo.relationship.services.PersonService;

@Controller
public class LicensesController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicensesController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
		
	}
	
	@RequestMapping("/licenses")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> nullPeople = personService.allPersonsNull();
		model.addAttribute("people", nullPeople);
		
		return "/licenses/new.jsp";
	}
	
	@RequestMapping(value="/licenses", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		System.out.print(license.getPerson().getFirstName());
		if (result.hasErrors()) {
			List<Person> nullPeople = personService.allPersonsNull();
			model.addAttribute("people", nullPeople);
            return "/licenses/new.jsp";
        } else {
        	Long count = licenseService.countLicense();
        	System.out.println(count);
        	
            
            return "redirect:/persons";
        }
		
	}
	
	

}
