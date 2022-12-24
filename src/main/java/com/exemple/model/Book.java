package com.exemple.model;

import io.swagger.annotations.ApiModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static jakarta.persistence.TemporalType.DATE;

@Entity
@Table(name = "books")
@Getter
@Setter
@ApiModel("Book ressource representation")
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id ;
    @NotNull(message = "the title couldn't be null")
    private String title;
    private String description;
    @Column(name = "unit_cost")
    private Double unitCost;
    private String isbn;
    @Basic(optional = false)
    @Column(name = "publication_date")
    @Past(message = "the date should be in the past")
    @Temporal(DATE)
    private Date publicationDate;
    @Column(name = "num_of_pages")
    private int numberOfPages;
    @Column(name = "image_url")
    private String imageURL;
    @Enumerated(STRING)
    private Language language;

}
