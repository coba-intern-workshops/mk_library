package org.example.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.Book;
import org.example.model.BookStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryImplTest {

    private Repository<Book> repository;

    @BeforeEach
    void setUp() {
        repository = new BookRepositoryImpl();
    }
    @Test
    void shouldReturnEmptyListForNoElementsOnList() {
        assertNotNull(repository.findAll());

        int EMPTY_LIST_SIZE = 0;
        assertEquals(EMPTY_LIST_SIZE, repository.findAll().size());
    }

    @Test
    void shouldAddBookToList() {
        Book book = new Book(UUID.randomUUID(), "testTitle", "testAuthor", BookStatus.AVAILABLE);

        repository.save(book);

        assertNotNull(repository.findAll());
        int EXPECTED_LIST_SIZE_WHEN_ADD = 1;
        assertEquals(EXPECTED_LIST_SIZE_WHEN_ADD, repository.findAll().size());
    }

    @Test
    void shouldCreatedObjectBeSameAsSend() {
        Book book = new Book(UUID.randomUUID(), "testTitle", "testAuthor", BookStatus.AVAILABLE);

        Book bookFromRepository = repository.save(book);

        assertEquals(book, bookFromRepository);
    }

    @Test
    void shouldThrowIAEWhenNullPassed() {
        assertThrowsExactly(IllegalArgumentException.class, () -> repository.save(null));
    }

}