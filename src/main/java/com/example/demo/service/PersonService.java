package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Person;
import com.example.demo.repository.PersonRepository;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Service class for managing Person entities.
 */
@Service
public class PersonService {

    private PersonRepository personRepository;

    /**
     * Constructs a PersonService with the specified PersonRepository.
     * 
     * @param personRepository the repository for Person entities
     */
    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

     /**
     * Creates and saves a new Person with the given name.
     *
     * @param name the name of the person to be created
     * @return the created Person object
     * @throws IllegalArgumentException if the name is null or empty
     */
    @Transactional
    public Person createPerson(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name cannot be null or empty");
        }

        Person person = Person.builder()
            .name(name)
            .build();

        return personRepository.save(person);
    }

    /**
     * Retrieves all persons from the repository.
     * 
     * @return a list of all people
     */
    public List<Person> getPeople(){
        List<Person> persons = personRepository.findAll();
        if (persons.isEmpty()) {
            throw new NoSuchElementException("No persons found");
        }
        return persons;
    }
    

    /**
     * Retrieves a person by their ID.
     * 
     * @param id the ID of the person to retrieve
     * @return the Person object if found
     * @throws NoSuchElementException if the person with the given ID is not found
     */
    public Person getPersonById(Long id){
        return personRepository.findById(id)
        .orElseThrow(
            () -> new NoSuchElementException("Person with id: " + id + " was not found")
        );
    }

    /**
     * Deletes a person by their ID.
     *
     * @param id the ID of the person to delete
     * @return the deleted Person object if found, otherwise null
     */
    public Person deletePersonById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            personRepository.delete(person);
            return person;
        }
        return null;
    }
}
