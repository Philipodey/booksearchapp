package com.philipApp.bookSearchApp.services;

import com.philipApp.bookSearchApp.model.Book;
import com.philipApp.bookSearchApp.model.ReadingList;
import com.philipApp.bookSearchApp.model.User;

public interface ReadingListService {
    void addBookToList(Book book, User user);

    ReadingList create();
}
