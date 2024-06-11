package com.philipApp.bookSearchApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchBookRequest {
    private String email;
    private String title;
}
