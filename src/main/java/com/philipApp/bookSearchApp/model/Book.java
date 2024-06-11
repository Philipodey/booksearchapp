package com.philipApp.bookSearchApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;


@Setter
@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    @OneToOne
    private Author author;
    private String copyright;
    private String languages;
    private String image;
    private String text;


}
