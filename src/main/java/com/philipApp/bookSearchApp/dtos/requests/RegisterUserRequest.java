package com.philipApp.bookSearchApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequest {
    private String email;
    private String username;
    private String password;
}
