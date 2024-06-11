package com.philipApp.bookSearchApp.services;

import com.philipApp.bookSearchApp.model.BookSearchResponse;
import com.philipApp.bookSearchApp.model.GutendexBook;
import com.philipApp.bookSearchApp.model.ReadingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;


@Service
public class GutendexBookSearchServiceImpl implements GutendexBookSearchService{



    @Override
    public GutendexBook findBook(String title) {
        String url = "https://gutendex.com/books/?search="+title;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BookSearchResponse> response = restTemplate.getForEntity(URI.create(url), BookSearchResponse.class);
        BookSearchResponse response1 = response.getBody();
        GutendexBook book = response1.getResults().get(0);
        return book;
    }

}
