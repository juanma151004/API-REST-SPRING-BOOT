package com.example.demo.repository;

// Importing the JpaRepository interface from Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

// Importing the Book model class
import com.example.demo.models.Book;

// Defining a repository interface for the Book entity
// This interface extends JpaRepository to provide CRUD operations for Book entities
public interface BookRepository extends JpaRepository<Book, Long> {
    // No additional methods are defined here, JpaRepository provides basic CRUD operations
}
