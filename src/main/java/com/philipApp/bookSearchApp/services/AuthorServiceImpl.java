package com.philipApp.bookSearchApp.services;

import com.philipApp.bookSearchApp.exceptions.AuthorRepository;
import com.philipApp.bookSearchApp.model.Author;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }
}
