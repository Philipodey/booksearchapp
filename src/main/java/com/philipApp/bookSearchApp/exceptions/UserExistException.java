package com.philipApp.bookSearchApp.exceptions;

public class UserExistException extends BookSearchAppException {


    public UserExistException() {
        super("User already exist");

    }
}
