package com.philipApp.bookSearchApp.services;

//import com.philipApp.bookSearchApp.model.Book;


import com.philipApp.bookSearchApp.model.Book;

public interface BookSearchService {
    Book findByTitle(String title) ;

    void save(Book book);

}
