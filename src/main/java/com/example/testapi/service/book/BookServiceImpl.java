package com.example.testapi.service.book;

import com.example.testapi.dto.request.BookRequest;
import com.example.testapi.dto.response.BookResponse;
import com.example.testapi.exception.RuleException;
import com.example.testapi.model.Book;
import com.example.testapi.repository.BookRep;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookServiceImpl implements BookService{

    private final BookRep bookRep;

    public BookServiceImpl(BookRep bookRep) {
        this.bookRep = bookRep;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        Optional<Book> byName = bookRep.findByname(bookRequest.getName());
        if(byName.isPresent())
            throw new RuleException("book.is.exist");
        Book save = bookRep.save(createBook(bookRequest));
        return createBookResponse(save);
    }

    private Book createBook(BookRequest bookRequest){
        return Book.builder()
                .name(bookRequest.getName())
                .price(bookRequest.getPrice())
                .build();
    }

    private BookResponse createBookResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }
}
