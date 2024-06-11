package com.philipApp.bookSearchApp.services;

import com.philipApp.bookSearchApp.dtos.requests.LoginRequest;
import com.philipApp.bookSearchApp.dtos.requests.RegisterUserRequest;
import com.philipApp.bookSearchApp.dtos.requests.SearchBookRequest;
import com.philipApp.bookSearchApp.dtos.responses.RegisterResponse;
import com.philipApp.bookSearchApp.exceptions.InvalidDetailsException;
import com.philipApp.bookSearchApp.exceptions.InvalidLoginException;
import com.philipApp.bookSearchApp.exceptions.UserExistException;
import com.philipApp.bookSearchApp.model.User;

import java.util.Optional;

public interface AppUserService {
    RegisterResponse registerUser(RegisterUserRequest request) throws UserExistException, InvalidDetailsException;

    Long count();

    void login(LoginRequest loginRequest) throws InvalidLoginException;
    Optional<User> findByEmail(String email);

    void logout(String email);

    void addBookToReadingList(SearchBookRequest searchBookRequest) throws InvalidDetailsException;
}
