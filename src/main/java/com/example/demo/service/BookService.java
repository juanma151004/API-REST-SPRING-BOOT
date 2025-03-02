package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing book-related operations.
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Retrieves a list of all books from the repository.
     *
     * @return A list of all available books.
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Retrieves a book by its ID from the repository.
     *
     * @param id The ID of the book to retrieve.
     * @return The book if found.
     * @throws RuntimeException if the book is not found.
     */
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }

    /**
     * Saves a book in the repository.
     *
     * @param book The book object to be saved.
     * @return A confirmation message indicating success.
     * @throws IllegalArgumentException if the book is null.
     */
    public String saveBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        bookRepository.save(book);
        return "Book saved successfully";
    }
}
