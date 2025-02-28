package com.example.demo.models;

import jakarta.persistence.*;
import java.util.List;

@Entity // Specifies that the class is an entity and is mapped to a database table
@Table(name = "people") // Specifies the name of the database table to be used for mapping
public class Person {
    @Id // Specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Provides the specification of generation strategies for the values of primary keys
    private Long id;

    @Column(nullable = false, length = 100) // Specifies the mapped column for a persistent property or field
    private String name;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true) // Specifies a one-to-many relationship with another entity
    private List<Book> lendedBooks;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getLendedBooks() {
        return lendedBooks;
    }

    public void setLendedBooks(List<Book> lendedBooks) {
        this.lendedBooks = lendedBooks;
    }
}
