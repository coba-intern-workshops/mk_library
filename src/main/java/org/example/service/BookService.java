package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.converter.BookConverter;
import org.example.dto.BookDto;
import org.example.model.Book;
import org.example.repository.BookRepositoryImpl;
import org.example.repository.RepositoryIfc;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepositoryImpl bookRepository;
    private final BookConverter bookConverter;

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

    public BookDto saveBook(BookDto bookDto){
        var result = bookRepository.save(bookConverter.convertFromDto(bookDto));
        return bookConverter.convertFromEntity(result);
    }

}