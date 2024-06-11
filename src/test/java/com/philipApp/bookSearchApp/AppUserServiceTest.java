package com.philipApp.bookSearchApp;

import com.philipApp.bookSearchApp.dtos.requests.LoginRequest;
import com.philipApp.bookSearchApp.dtos.requests.RegisterUserRequest;
import com.philipApp.bookSearchApp.dtos.requests.SearchBookRequest;
import com.philipApp.bookSearchApp.dtos.responses.RegisterResponse;
import com.philipApp.bookSearchApp.exceptions.InvalidDetailsException;
import com.philipApp.bookSearchApp.exceptions.InvalidLoginException;
import com.philipApp.bookSearchApp.exceptions.UserExistException;
import com.philipApp.bookSearchApp.model.GutendexBook;
import com.philipApp.bookSearchApp.model.User;
import com.philipApp.bookSearchApp.repositories.UserRepository;
import com.philipApp.bookSearchApp.services.AppUserService;
import com.philipApp.bookSearchApp.services.BookSearchService;
import com.philipApp.bookSearchApp.services.GutendexBookSearchService;
import com.philipApp.bookSearchApp.services.ReadingListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AppUserServiceTest {

    @Autowired
    private AppUserService appUserService;


    @Autowired
    public GutendexBookSearchService gutendexBookSearchService;
    @Autowired
    public ReadingListService readingListService;
    RegisterUserRequest request = new RegisterUserRequest();

    @BeforeEach
    public void doThisTestFirst() throws UserExistException, InvalidDetailsException {
        request.setUsername("phzboy91234");
        request.setEmail("phzboyd1234@gmail.com");
        request.setPassword("Phzboy@1234");
        appUserService.registerUser(request);
    }

    @Autowired
    private UserRepository userRepository;
    @Test
    public void registerUserFindUserByEmailTest() throws UserExistException, InvalidDetailsException {
        assertEquals(userRepository.count(), 1);
    }

    @Test
    public void  registerUserLoginUserTest() throws InvalidLoginException {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(request.getEmail());
        loginRequest.setPassword(request.getPassword());
        appUserService.login(loginRequest);
        Optional<User> user = appUserService.findByEmail(loginRequest.getEmail());
        assertTrue(user.get().isLoginStatus());

    }

    @Test
    public void LoginUserLogoutUserTest() throws InvalidLoginException {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(request.getEmail());
        loginRequest.setPassword(request.getPassword());
        appUserService.login(loginRequest);
        Optional<User> user = appUserService.findByEmail(loginRequest.getEmail());
        assertTrue(user.get().isLoginStatus());
        Optional<User> user1 = appUserService.findByEmail(loginRequest.getEmail());
        assertTrue(user1.get().isLoginStatus());
//       appUserService.
    }

    @Test
    public void LoginUserSearchForABookTest() throws InvalidLoginException, InvalidDetailsException {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(request.getEmail());
        loginRequest.setPassword(request.getPassword());
        appUserService.login(loginRequest);
        SearchBookRequest searchBookRequest = new SearchBookRequest();
        searchBookRequest.setTitle("oliver");
        searchBookRequest.setEmail(loginRequest.getEmail());
        appUserService.addBookToReadingList(searchBookRequest);
        assertEquals(appUserService.count(), 1);
        assertEquals(appUserService.findByEmail(request.getEmail()).get().getReadingList().getBookList().size(), 1);
    }
}
