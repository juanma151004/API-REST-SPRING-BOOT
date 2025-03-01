package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/demo/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Endpoint para retornar un mensaje de prueba
    @GetMapping
    public String helloWorld() {
        return "Hello world";
    }

    // Endpoint para listar todos los libros
    @GetMapping("/listBooks")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    // Endpoint para guardar un libro
    @PostMapping("/save")
    public String save(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
}

