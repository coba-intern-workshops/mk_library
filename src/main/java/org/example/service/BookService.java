package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.converter.BookConverter;
import org.example.converter.BookCreateConverter;
import org.example.dto.BookCreateDto;
import org.example.dto.BookDeleteDto;
import org.example.dto.BookDto;
import org.example.exception.RecordNotFoundException;
import org.example.exception.RequestValidationException;
import org.example.model.Book;
import org.example.model.BookStatus;
import org.example.repository.BookRepositoryImpl;
import org.example.repository.RepositoryIfc;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepositoryImpl bookRepository;
    private final BookConverter bookConverter;
    private final BookCreateConverter bookCreateConverter;

    public List<BookDto> findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

    public List<BookDto> findBooks(BookSearchCriteria searchCriteria) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getAuthor().contains(searchCriteria.getAuthor()))
                .map(bookConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

    public BookDto saveBook(BookCreateDto bookCreateDto){
        var result = bookRepository.save(bookCreateConverter.convertFromDto(bookCreateDto));
        return bookConverter.convertFromEntity(result);
    }

    public BookDto deleteBook(String id, BookDeleteDto bookDeleteDto) {
        //TODO: walidacja DTO dla request body przed wywołaniem metody
        if (bookDeleteDto.getStatus() != BookStatus.DELETED) {
            throw new RequestValidationException("Status DELETED required");
        }
        Optional<Book> book = bookRepository.findById(UUID.fromString(id));
        book.orElseThrow(() -> new RecordNotFoundException("Book with id" + id + "not exist"));
        book.ifPresent(update -> update.setBookStatus(bookDeleteDto.getStatus()));

        return bookConverter.convertFromEntity(book.get());
    }
}