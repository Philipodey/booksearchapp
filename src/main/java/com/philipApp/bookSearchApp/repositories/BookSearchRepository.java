package com.philipApp.bookSearchApp.repositories;

import com.philipApp.bookSearchApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookSearchRepository extends JpaRepository<Book, Long> {
    void findByTitle(String title);
}
