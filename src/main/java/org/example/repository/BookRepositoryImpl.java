package org.example.repository;

import org.example.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class BookRepositoryImpl implements RepositoryIfc<Book> {
    private final List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book save(Book book) {
        if (book == null) {
            throw new IllegalArgumentException();
        }
        Book bookToSave = new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getBookStatus());
        books.add(bookToSave);
        return bookToSave;
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }


}