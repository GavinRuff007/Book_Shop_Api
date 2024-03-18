package com.example.testapi.service.book;

import com.example.testapi.dto.request.BookRequest;
import com.example.testapi.dto.response.BookResponse;
import com.example.testapi.exception.RuleException;
import com.example.testapi.model.Book;
import com.example.testapi.repository.BookRep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    private final BookRep bookRep;

    public BookServiceImpl(BookRep bookRep) {
        this.bookRep = bookRep;
    }

    @Override
    public Page<BookResponse> findAll(Pageable pageable) {
        return bookRep.findAll(pageable)
                .map((book) -> BookResponse.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .price(book.getPrice())
                        .build()
                );
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        Optional<Book> byName = bookRep.findByname(bookRequest.getName());
        if(byName.isPresent())
            throw new RuleException("book.is.exist");
        Book save = bookRep.save(createBook(bookRequest));
        return createBookResponse(save);
    }

    @Override
    public List<BookResponse> findByname(String name) {
       return bookRep.findBookByName("%"+name+"%")
                .stream().map((book) -> BookResponse.builder()
                        .name(book.getName())
                        .id(book.getId())
                        .price(book.getPrice())
                        .build())
                        .collect((Collectors.toList()));
    }

    @Override
    public BookResponse findById(Long id) {
        return createBookResponse(findByIdReturnBook(id));

    }

    @Override
    @Transactional
    public void deleted(Long id) {
        Book byId = findByIdReturnBook(id);
        byId.setDeleted(LocalDateTime.now());
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
    private Book findByIdReturnBook(Long id){
        return bookRep.findById(id)
                .orElseThrow(() -> new RuleException("book.not.found"));
    }
}
