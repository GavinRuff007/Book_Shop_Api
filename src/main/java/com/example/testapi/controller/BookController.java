package com.example.testapi.controller;

import com.example.testapi.dto.request.BookRequest;
import com.example.testapi.dto.response.BookResponse;
import com.example.testapi.service.book.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    public ResponseEntity<BookResponse> save(@RequestBody @Valid BookRequest book){
      return ResponseEntity.ok(bookService.save(book));
    }
}
