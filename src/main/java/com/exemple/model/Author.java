package com.exemple.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author extends User {


    @Column(name = "prefered_language")
    @Enumerated(STRING)
    Language preferdLanguage;



    @Transient
    @OneToMany(mappedBy = "author_id")
    List<Book> bookList;



    @Override
    public String toString() {
        return "Author{" +
                "preferdLanguage=" + preferdLanguage +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", bio='" + bio + '\'' +
                ", age=" + age +
                '}';
    }
}
