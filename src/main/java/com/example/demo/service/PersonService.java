package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.PersonRepository;
import lombok.*;

@Service
@Getter
@Setter
public class PersonService {
    private PersonRepository personRepository;

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

}
