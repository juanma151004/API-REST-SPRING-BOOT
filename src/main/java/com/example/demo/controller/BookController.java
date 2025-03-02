package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Book;
import com.example.demo.service.BookService;

/**
 * REST Controller for managing books.
 */
@RestController
@RequestMapping("/demo/books")
public class BookController {


    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    /**
     * Endpoint to return a test message.
     *
     * @return A simple "Hello world" message.
     */
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }

    /**
     * Endpoint to list all books.
     *
     * @return A list of all available books.
     */
    @GetMapping("/listBooks")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    /**
     * Endpoint to get a book by its ID.
     *
     * @param id The ID of the book.
     * @return The requested book.
     */
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    /**
     * Endpoint to save a book.
     *
     * @param book The book object to be saved.
     * @return A confirmation message after saving the book.
     */
    @PostMapping
    public String save(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
}
