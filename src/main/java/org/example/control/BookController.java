package org.example.control;

import lombok.RequiredArgsConstructor;
import org.example.dto.BookCreateDto;
import org.example.dto.BookDeleteDto;
import org.example.dto.BookDto;
import org.example.exception.RequestValidationException;
import org.example.model.BookStatus;
import org.example.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> findAllBooks(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookDto> saveBook(@RequestBody BookCreateDto bookCreateDto){
        return ResponseEntity.ok(bookService.saveBook(bookCreateDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookDto> deleteBook(@PathVariable String id,
                                              @RequestBody BookDeleteDto bookDeleteDto) {
        return ResponseEntity.ok(bookService.deleteBook(id, bookDeleteDto));
    }
}