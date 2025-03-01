package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/demo/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository repo;

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
    public String save(@RequestBody Book book){
        if (book.getPerson() == null) {
            book.setPerson(null); // Ensure it does not attempt to save an empty person
        }
        repo.save(book);
        return "saved";
    }
}

