package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Represents a person entity in the system.
 * This entity is mapped to the "people" table in the database.
 */
@Entity
@Table(name = "people")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Person {

    /**
     * The unique identifier for a person.
     * It is auto-generated using an identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the person.
     * This field is required (non-null) and has a maximum length of 255 characters.
     */
    @Column(nullable = false, length = 255)
    private String name;

    /**
     * A list of books associated with this person.
     * This relationship is managed through the "person" field in the Book entity.
     * Cascade operations are enabled, and orphan removal is set to true.
     * The @ToString.Exclude annotation prevents infinite recursion in toString() calls.
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Book> books;
}
