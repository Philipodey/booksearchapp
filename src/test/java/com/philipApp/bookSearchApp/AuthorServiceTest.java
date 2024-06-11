package com.philipApp.bookSearchApp;

import com.philipApp.bookSearchApp.dtos.requests.RegisterUserRequest;
import com.philipApp.bookSearchApp.exceptions.AuthorRepository;
import com.philipApp.bookSearchApp.exceptions.InvalidDetailsException;
import com.philipApp.bookSearchApp.exceptions.UserExistException;
import com.philipApp.bookSearchApp.model.Author;
import com.philipApp.bookSearchApp.model.GutendexBook;
import com.philipApp.bookSearchApp.services.AppUserService;
import com.philipApp.bookSearchApp.services.AuthorService;
import com.philipApp.bookSearchApp.services.GutendexBookSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuthorServiceTest {
    @Autowired
    private AuthorService authorService;
    @Autowired
    GutendexBookSearchService gutendexBookSearchService;
    @Autowired
    AuthorRepository repository;


    @Test
    public void saveAuthorTest() {
//        List<Author> authorList = new ArrayList<>();

        Author author = new Author("user", "13-03-2001", "15-04-2020");
        Author author1 = new Author("user1", "13-03-1981", "15-04-2022");
        authorService.save(author);
        assertEquals(1, repository.count());
    }
}
