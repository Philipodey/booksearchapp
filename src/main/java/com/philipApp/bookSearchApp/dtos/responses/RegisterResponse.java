package com.philipApp.bookSearchApp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterResponse {
    private Long id;
    private String username;
    private String email;
}
