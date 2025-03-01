package com.example.demo.controller;

import com.example.demo.models.Person;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo/person")
public class PersonController {
    
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Retrieves a person by their ID.
     * 
     * @param id the ID of the person to retrieve
     * @return the Person object if found
     */
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    /**
     * Retrieves all persons.
     * 
     * @return list of persons
     */
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getPersons();
    }

    /**
     * Creates a new person.
     * 
     * @param person the person object to create
     * @return the created Person object
     */
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person.getName());
    }

}
