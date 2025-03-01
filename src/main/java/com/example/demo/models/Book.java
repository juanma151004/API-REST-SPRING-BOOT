package com.example.demo.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.*;

import jakarta.persistence.*;

/**
 * Represents a book entity in the system.
 * This entity is mapped to the "books" table in the database.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") 
@Table(name = "books")
public class Book {
    
    /**
     * The unique identifier for a book.
     * It is auto-generated using an identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title of the book.
     * This field is required (non-null) and has a maximum length of 255 characters.
     */
    @Column(nullable = false, length = 255)
    private String title;

    /**
     * The person who owns or is associated with this book.
     * This is a many-to-one relationship, linking books to a person entity.
     * If the associated person is deleted, the "person_id" in this table is set to NULL.
     * A foreign key constraint is applied to ensure referential integrity.
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", 
                foreignKey = @ForeignKey(name = "fk_books_people"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Person person;
}
