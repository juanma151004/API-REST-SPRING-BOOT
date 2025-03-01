package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for managing books.
 */
@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    /**
     * Retrieves all books from the repository.
     *
     * @return a list of all books
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Saves a book to the repository.
     * If the book's person attribute is null, it sets it to null before saving.
     *
     * @param book the book to be saved
     * @return a string indicating the save status
     */
    public String saveBook(Book book) {
        if (book.getPerson() == null) {
            book.setPerson(null); 
        }
        bookRepository.save(book);
        return "saved";
    }
}
