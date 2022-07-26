package com.codingdojo.relationship.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationship.models.Person;
import com.codingdojo.relationship.services.PersonService;



@Controller
public class PersonsController {
	private final PersonService personService;
	
	public PersonsController(PersonService personService) {
		this.personService = personService;
		
	}
	@RequestMapping("/persons")
	public String Index(Model model) {
		List<Person> allPerson = personService.allPersons();
		model.addAttribute("people", allPerson);
		
		
		return "/persons/Index.jsp";
	}
	
	
	
	@RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        
        return "/persons/new.jsp";
    }
	
	@RequestMapping("/persons/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		System.out.println(person.getLicense() != null);
		return "/persons/detail.jsp";
	}
	
	@RequestMapping(value="/persons", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
            return "/persons/new.jsp";
        } else {
            personService.createPerson(person);
            return "redirect:/persons";
        }
		
	}
}
