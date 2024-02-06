package org.example.control;

import lombok.RequiredArgsConstructor;
import org.example.dto.BookDto;
import org.example.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> findAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookDto> saveBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.saveBook(bookDto));
    }
}