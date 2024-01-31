package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Book;
import org.example.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BookService {
    private final Repository<Book> bookRepository;

    public List<Book> findBooks(BookSearchCriteria searchCriteria) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getAuthor().contains(searchCriteria.getAuthor()))
                .collect(Collectors.toList());
    }

}