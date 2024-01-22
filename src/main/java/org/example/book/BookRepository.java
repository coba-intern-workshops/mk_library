package org.example.book;

import org.example.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAll();
}