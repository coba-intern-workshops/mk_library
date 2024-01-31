package org.example.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.WithAssertions;
import org.example.model.Person;
import org.example.model.Book;
import org.example.model.BookStatus;
import org.example.model.Rental;
import org.example.model.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RentalRepositoryImplTest implements WithAssertions {

    private Repository<Rental> repository;

    @BeforeEach
    void setUp() {
        repository = new RentalRepositoryImpl();
    }
    @Test
    void shouldReturnEmptyListForNoElementsOnList() {
        assertThat(repository).isNotNull();
        assertThat(repository.findAll()).isNotNull().isEmpty();
    }

    @Test
    void shouldAddRentalToList() {
        Rental rental = getTestRental();
        repository.save(rental);
        assertThat(repository.findAll()).isNotNull();

        int EXPECTED_LIST_SIZE_WHEN_ADD = 1;
        assertThat(repository.findAll().size()).isEqualTo(EXPECTED_LIST_SIZE_WHEN_ADD);
    }

    @Test
    void shouldCreatedObjectBeSameAsSend() {
        Rental rental= getTestRental();
        Rental rentalFromRepository= repository.save(rental);

       assertThat(rental).isEqualTo(rentalFromRepository);
       assertThat(rentalFromRepository.getBook())
               .matches(book -> book.getTitle().equals("testTitle"))
               .matches(book -> book.getAuthor().equals("testAuthor"));
       assertThat(rentalFromRepository.getPerson().getFirstName())
               .startsWith("Jo")
               .contains("e")
               .doesNotContain("Doe");
       assertThat(rentalFromRepository.getRentedOn())
               .as("Checking rental date for user %s %s", rentalFromRepository.getPerson().getFirstName(), rentalFromRepository.getPerson().getLastName())
               .withFailMessage("Should be "+ LocalDate.now())
               .isEqualTo(LocalDate.now());
    }

    private Rental getTestRental() {
        Book book= new Book(UUID.randomUUID(), "testTitle", "testAuthor", BookStatus.AVAILABLE);
        Person person = new Person(UUID.randomUUID(), "Joe", "Doe", UserType.USER);
        return new Rental(book, person, LocalDate.now(), LocalDate.now().plusWeeks(4));
    }

    @Test
    void shouldThrowIAEWhenNullPassed() {
        assertThrowsExactly(IllegalArgumentException.class, () -> repository.save(null));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()-> repository.save(null))
                .withMessage("Cannot save null object");

    }

}