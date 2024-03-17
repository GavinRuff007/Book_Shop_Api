package com.example.testapi.service.book;

import com.example.testapi.dto.request.BookRequest;
import com.example.testapi.dto.response.BookResponse;

public interface BookService {
    BookResponse save(BookRequest bookRequest);
}
