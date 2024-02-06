package org.example.converter;

import org.example.dto.BookDto;
import org.example.dto.BookStatusDto;
import org.example.model.Book;
import org.example.model.BookStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class BookConverter extends Converter<BookDto, Book>{
    public BookConverter() {
        super(BookConverter::convertToEntity, BookConverter::convertToDto);
    }

    private static BookDto convertToDto(Book book){
        return new BookDto(book.getTitle(), book.getAuthor(), BookStatusDto.valueOf(book.getBookStatus().toString()));
    }

    private static Book convertToEntity(BookDto dto){
        return new Book(UUID.randomUUID(), dto.getTitle(), dto.getAuthor(), BookStatus.valueOf(dto.getBookStatus().toString()));
    }
}