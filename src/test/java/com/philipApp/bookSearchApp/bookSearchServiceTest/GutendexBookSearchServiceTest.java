package com.philipApp.bookSearchApp.bookSearchServiceTest;

//import com.philipApp.bookSearchApp.model.Book;
import com.philipApp.bookSearchApp.model.BookSearchResponse;
import com.philipApp.bookSearchApp.model.GutendexBook;
import com.philipApp.bookSearchApp.repositories.BookSearchRepository;
import com.philipApp.bookSearchApp.services.BookSearchService;
import com.philipApp.bookSearchApp.services.GutendexBookSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GutendexBookSearchServiceTest {
    @Autowired
    public BookSearchService bookSearchService;
    @Autowired
    public BookSearchRepository bookSearchRepository;

    @Autowired
    public GutendexBookSearchService gutendexBookSearchService;


    @Test
//    public void searchBookByTitleTest() {
//        assertNotNull( bookSearchService.findByTitle("great"));
//    }
    public void fetchFromApiTest(){
        GutendexBook book =  gutendexBookSearchService.findBook("oliver");
        System.out.println(book.getFormats().get("image/jpeg"));
        System.out.println(book.getFormats().get("text/html"));
        assertNotNull(book);
    }

//    @Test
//    public void fetchBookAddBookToUserReadingList(){
//        GutendexBook book =  gutendexBookSearchService.findBook("oliver");
//        gutendexBookSearchService.addGookToReadingList(book);
//    }
}
