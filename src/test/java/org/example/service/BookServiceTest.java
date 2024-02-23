package org.example.service;

import org.assertj.core.api.WithAssertions;
import org.example.converter.BookConverter;
import org.example.converter.BookCreateConverter;
import org.example.dto.BookCreateDto;
import org.example.dto.BookDeleteDto;
import org.example.dto.BookDto;
import org.example.dto.BookStatusDto;
import org.example.model.BookStatus;
import org.example.repository.BookRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class BookServiceTest implements WithAssertions {

    private BookService service;

    @BeforeEach
    protected void setUp() {
        service = new BookService(new BookRepositoryImpl(), new BookConverter(), new BookCreateConverter());
    }

    @Test
    void shouldDeleteBook() {
        BookDto book = service.saveBook(BookCreateDto.builder().build());

        BookDto deletedBook = service.deleteBook(book.getId().toString(), BookDeleteDto.builder().status(BookStatus.DELETED).build());

        assertThat(deletedBook).isNotNull();
        assertThat(deletedBook.getBookStatus()).isEqualTo(BookStatusDto.DELETED);
    }

    @Test
    void shouldThrowExceptionWhenBookNotExist() {
        //TODO
    }

    @Test
    void shouldThrowExceptionWhenStatusDifferentThanDeleted() {
        //TODO
    }
}