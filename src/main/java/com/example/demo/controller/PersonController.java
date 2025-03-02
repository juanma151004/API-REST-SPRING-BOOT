package com.example.demo.controller;

import com.example.demo.models.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing Person entities.
 */
@RestController
@RequestMapping("/demo/person")
public class PersonController {
    
    private final PersonService personService;

    /**
     * Constructor with dependency injection.
     * 
     * @param personService the service managing persons
     */
    @Autowired  
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
    public List<Person> getAllPeople() {
        return personService.getPeople();
    }

    /**
     * Creates a new person.
     * 
     * @param name the name of the person to create
     * @return the created Person object
     */
    @PostMapping
    public Person createPerson(@RequestBody String name) {
        return personService.createPerson(name);
    }

    /**
     * Deletes a person by their ID.
     *
     * @param id the ID of the person to delete
     * @return the deleted Person object if found, otherwise null
     */
    @DeleteMapping("/{id}")
    public Person deletePersonById(@PathVariable Long id) {
        return personService.deletePersonById(id);
    }
}
