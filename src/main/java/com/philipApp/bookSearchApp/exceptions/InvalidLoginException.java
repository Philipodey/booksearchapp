package com.philipApp.bookSearchApp.exceptions;

public class InvalidLoginException extends BookSearchAppException {
    public InvalidLoginException(String invalidLoginDetails) {
        super(invalidLoginDetails);
    }
}
