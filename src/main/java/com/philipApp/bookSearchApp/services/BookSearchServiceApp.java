package com.philipApp.bookSearchApp.services;

//import com.philipApp.bookSearchApp.model.Book;
import com.philipApp.bookSearchApp.model.Book;
import com.philipApp.bookSearchApp.repositories.BookSearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookSearchServiceApp implements BookSearchService{
    private final BookSearchRepository bookSearchRepository;


//    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public Book findByTitle(String title) {
          bookSearchRepository.findByTitle(title);
//          bookSearchRepository.save()
        return null;

    }

    @Override
    public void save(Book book) {
        bookSearchRepository.save(book);
    }


}

