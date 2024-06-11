package com.philipApp.bookSearchApp.services;

import com.philipApp.bookSearchApp.dtos.requests.LoginRequest;
import com.philipApp.bookSearchApp.dtos.requests.RegisterUserRequest;
import com.philipApp.bookSearchApp.dtos.requests.SearchBookRequest;
import com.philipApp.bookSearchApp.dtos.responses.RegisterResponse;
import com.philipApp.bookSearchApp.exceptions.AuthorRepository;
import com.philipApp.bookSearchApp.exceptions.InvalidDetailsException;
import com.philipApp.bookSearchApp.exceptions.InvalidLoginException;
import com.philipApp.bookSearchApp.exceptions.UserExistException;
import com.philipApp.bookSearchApp.model.Author;
import com.philipApp.bookSearchApp.model.Book;
import com.philipApp.bookSearchApp.model.GutendexBook;
import com.philipApp.bookSearchApp.model.User;
import com.philipApp.bookSearchApp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.philipApp.bookSearchApp.utils.verification.VerifyCustomerDetails.*;

@Service
public class AppServiceUserImpl implements AppUserService{

    @Autowired
    private UserRepository  userRepository;
    @Autowired
    private GutendexBookSearchService gutendexBookSearchService;

    @Autowired
    private ReadingListService readingListService;
    @Autowired
    private AuthorService authorService;
    ModelMapper modelMapper = new ModelMapper();


    @Override
    public RegisterResponse registerUser(RegisterUserRequest request) throws UserExistException, InvalidDetailsException {
        User user = new User();
        if(userExist(request.getEmail())) throw new UserExistException();
        if(!verifyEmail(request.getEmail())) throw new InvalidDetailsException("Invalid email format input email with the right format");
        if (!verifyPassword(request.getPassword())) throw new InvalidDetailsException("Invalid password format\nInput password with character letters and numbers");
//        if(!verifyUsername(request.getUsername())) throw new InvalidDetailsException("Invalid password format input password with numbers ,\nalphabets and special characters");
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
//        User newUser = modelMapper.map(user, User.class);
        userRepository.save(user);
        user.setReadingList(readingListService.create());
        RegisterResponse response = new RegisterResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        return response;
    }

    @Override
    public Long count() {
        return userRepository.count();
    }

    @Override
    public void login(LoginRequest loginRequest) throws InvalidLoginException {
        Optional<User> foundUser = userRepository.findUserByEmail(loginRequest.getEmail());
        if (foundUser.isEmpty()) throw new InvalidLoginException("Invalid login details");
        verifyLoginPassword(loginRequest.getPassword(),loginRequest.getEmail());
        foundUser.get().setLoginStatus(true);
        userRepository.save(foundUser.get());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void logout(String email) {
        Optional<User> foundUser = userRepository.findUserByEmail(email);
        foundUser.get().setLoginStatus(false);
        userRepository.save(foundUser.get());
    }

    @Override
    public void addBookToReadingList(SearchBookRequest request) throws InvalidDetailsException {
        if (!userExist(request.getEmail())) throw new InvalidDetailsException("User does not exist");
        User user = findByEmail(request.getEmail()).get();
        GutendexBook book = gutendexBookSearchService.findBook(request.getTitle());
        List<Author> authors = book.getAuthors();
        Author author = authors.get(0);
        authorService.save(author);
        Book  book1 = modelMapper.map(book, Book.class);
        book1.setImage(book.getFormats().get("image/jpeg"));
        book1.setText(book.getFormats().get("text/html"));
        readingListService.addBookToList(book1, user);
    }


    private boolean userExist(String email){
        Optional<User> client = userRepository.findUserByEmail(email);
        return client.isPresent();
    }

    private void verifyLoginPassword(String password,String email) throws InvalidLoginException {
        Optional<User> user = userRepository.findUserByEmail(email);
        if(!user.get().getPassword().equals(password))throw new InvalidLoginException("Invalid login details");

    }
}
