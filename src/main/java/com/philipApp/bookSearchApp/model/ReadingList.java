package com.philipApp.bookSearchApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
public class ReadingList {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Book> bookList = new ArrayList<>();

}
