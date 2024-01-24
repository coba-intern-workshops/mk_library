package org.example.repository;

import org.example.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements Repository<Book> {
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
}