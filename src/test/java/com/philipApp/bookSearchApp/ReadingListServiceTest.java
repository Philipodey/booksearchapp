package com.philipApp.bookSearchApp;

import com.philipApp.bookSearchApp.dtos.requests.LoginRequest;
import com.philipApp.bookSearchApp.model.GutendexBook;
import com.philipApp.bookSearchApp.model.User;
import com.philipApp.bookSearchApp.repositories.BookSearchRepository;
import com.philipApp.bookSearchApp.services.GutendexBookSearchService;
import com.philipApp.bookSearchApp.services.ReadingListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ReadingListServiceTest {
    @Autowired
    private ReadingListService readingListService;
    @Autowired
    private BookSearchRepository bookSearchRepository;
    @Autowired
    private GutendexBookSearchService bookSearchService;


    @Test
    public void addBookToListTest(){
        GutendexBook book =  bookSearchService.findBook("oliver");

//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setEmail(request.getEmail());
//        loginRequest.setPassword(request.getPassword());
//        appUserService.login(loginRequest);
//        Optional<User> user = appUserService.findByEmail(loginRequest.getEmail());
//        readingListService.addBookToList(book, );
        assertEquals(bookSearchRepository.count(), 1);
    }
}
