package com.philipApp.bookSearchApp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.philipApp.bookSearchApp.model.*;
import com.philipApp.bookSearchApp.repositories.BookSearchRepository;
import com.philipApp.bookSearchApp.repositories.ReadingListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingListServiceImpl implements ReadingListService{
    @Autowired
    public BookSearchService bookSearchService;
    @Autowired
    public ReadingListRepository repository;





    private final ModelMapper modelMapper = new ModelMapper();
//    @Override
//    public void AddBookToList(String title) {
//        GutendexBook book = gutendexBookSearchService.findBook(title);
//        Book book1 = modelMapper.map(book, Book.class);
//
//        bookSearchService.save(book1);
//    }

    @Override
    public void addBookToList(Book book, User user) {
        ReadingList readingList ;
        readingList = user.getReadingList();
        bookSearchService.save(book);
        readingList.getBookList().add(book);
        repository.save(readingList);
    }

    @Override
    public ReadingList create() {
        ReadingList readingList = new ReadingList();
        return repository.save(readingList);
    }
}
