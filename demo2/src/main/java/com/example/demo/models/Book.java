package com.example.demo.models;

import jakarta.persistence.*;

// Define the Book entity
@Entity
@Table(name = "books")
public class Book {
    // Define the primary key with auto-increment strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define the title column with constraints
    @Column(nullable = false, length = 100)
    private String title;

    // Define the many-to-one relationship with Person entity
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = true)
    private Person person;

    // Getter and Setters
    public Long getId() {
        return id;
    }

   
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
