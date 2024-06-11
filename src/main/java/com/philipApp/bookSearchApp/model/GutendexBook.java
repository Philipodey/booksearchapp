package com.philipApp.bookSearchApp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
@Getter
@Setter
public class GutendexBook {
    private String title;
    private List<Author> authors;
    private String copyright;
    private List<String> languages;
    private Map<String, String> formats   ;
}
