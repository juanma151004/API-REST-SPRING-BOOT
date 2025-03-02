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
     * 
     * - If a person is deleted, all their books are also deleted (`CascadeType.REMOVE`).
     * - `orphanRemoval = true` ensures that if a book is removed from the list, it is deleted from the database.
     * - `@ToString.Exclude` prevents infinite recursion in `toString()` calls.
     * - `@EqualsAndHashCode.Exclude` prevents infinite loops in object comparisons.
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Book> books;
}
