package com.example.testapi.service.book;

import com.example.testapi.dto.request.BookRequest;
import com.example.testapi.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<BookResponse> findAll(Pageable pageable);


    BookResponse save(BookRequest bookRequest);
}
