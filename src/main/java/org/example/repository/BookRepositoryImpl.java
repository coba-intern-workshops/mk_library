package org.example.repository;

import org.example.model.Book;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
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
    public long count() {
        return books.size();
    }

    @Override
    public void delete(Book entity) {
        books.removeIf(book -> book.getId().equals(entity.getId()));
    }

    @Override
    public void deleteAll(List<Book> entities) {
        for (Book book : entities) {
            books.removeIf(b -> b.getId().equals(book.getId()));
        }
    }

    @Override
    public void deleteAllByUUID(List<UUID> ids) {
        books.removeIf(book -> ids.contains(book.getId()));
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        books.removeIf(book -> book.getId().equals(uuid));
    }

    @Override
    public boolean existsByUUID(UUID uuid) {
        return books.stream()
                .anyMatch(book -> book.getId().equals(uuid));
    }
    @Override
    public List<Book> findAllByUUID(List<UUID> uuids) {
        return books.stream()
                .filter(book -> uuids.contains(book.getId()))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<Book> findByUUID(UUID uuid) {
        return books.stream()
                .filter(book -> book.getId().equals(uuid))
                .findFirst();
    }
    @Override
    public List<Book> saveAll(List<Book> entities) {
        books.addAll(entities);
        return entities;
    }
}