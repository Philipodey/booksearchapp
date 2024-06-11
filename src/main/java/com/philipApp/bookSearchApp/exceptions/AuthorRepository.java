package com.philipApp.bookSearchApp.exceptions;

import com.philipApp.bookSearchApp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
//    void saveAuthors(List<Author> authorList);
}
