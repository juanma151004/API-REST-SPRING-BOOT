package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Represents a person entity in the system.
 * This entity is mapped to the "people" table in the database.
 */
@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Ensures JPA compatibility
@AllArgsConstructor
@SuperBuilder // Supports inheritance for future extensions
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
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
     * - If a person is deleted, all their books are also deleted (`CascadeType.ALL`).
     * - `orphanRemoval = true` ensures that if a book is removed from the list, it is deleted from the database.
     * - `@ToString.Exclude` prevents infinite recursion in `toString()` calls.
     * - `@EqualsAndHashCode.Exclude` prevents infinite loops in object comparisons.
     * - `@Singular` allows safe building of the list using Lombok.
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Singular
    @JsonManagedReference
    private List<Book> books;
}
