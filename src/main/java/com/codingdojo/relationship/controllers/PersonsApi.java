package com.codingdojo.relationship.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.relationship.models.Person;
import com.codingdojo.relationship.services.PersonService;

@RestController
public class PersonsApi {

	private final PersonService personService;

	public PersonsApi(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping("/api/persons")
	public List<Person> index() {
		return personService.allPersons();
	}

	@RequestMapping(value = "/api/persons", method = RequestMethod.POST)
	public Person create(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName) {
		Person person = new Person(firstName, lastName);
		return personService.createPerson(person);
	}

	@RequestMapping("/api/persons/{id}")
	public Person show(@PathVariable("id") Long id) {
		Person person = personService.findPerson(id);
		return person;
	}

}
