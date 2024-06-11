package com.philipApp.bookSearchApp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class BookSearchResponse {
    private int count;
    private String next;
    private String previous;
    private List<GutendexBook> results;
}
