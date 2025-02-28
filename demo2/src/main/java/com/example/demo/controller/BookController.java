package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Book;
import com.example.demo.repository.Repository;

@RestController
@RequestMapping("/demo/books")
public class BookController {

    @Autowired
    private Repository repo;

    // Endpoint to return a simple "Hello world" message
    @GetMapping
    public String helloWorld(){
        return "Hello world";
    }

    // Endpoint to list all books
    @GetMapping("/listBooks")
    public List<Book> getLibros(){
        return repo.findAll();
    }

    // Endpoint to save a book
    @PostMapping("/save")
    public String save(@RequestBody Book libro){
        if (libro.getPerson() == null) {
            libro.setPerson(null); // Ensure it does not attempt to save an empty person
        }
        repo.save(libro);
        return "saved";
    }
}

