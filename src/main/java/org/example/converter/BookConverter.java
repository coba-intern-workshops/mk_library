package org.example.converter;

import org.example.dto.BookDto;
import org.example.dto.BookStatusDto;
import org.example.model.Book;
import org.example.model.BookStatus;


public class BookConverter extends Converter<BookDto, Book> {

    public BookConverter() {
        super(BookConverter::convertToEntity, BookConverter::convertToDto);
    }

    private static BookDto convertToDto(Book book) {
        return BookDto.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .bookStatus(BookStatusDto.valueOf(book.getBookStatus().toString()))
                .build();
    }

    private static Book convertToEntity(BookDto bookDto) {
        return Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .bookStatus(BookStatus.valueOf(bookDto.getBookStatus().toString()))
                .build();
    }
}