package com.exemple.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;
import static jakarta.persistence.TemporalType.DATE;

//@Entity
//@Table(name = "users")
@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id ;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Past
    @Temporal(DATE)
    @Column(name = "date_birth")
    Date dateOfBirth;
    String bio;
    @Transient
    int age;
}
