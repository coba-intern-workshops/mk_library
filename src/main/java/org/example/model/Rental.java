package org.example.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Rental {
    private UUID id;
    private Book book;
    private Person person;
    private LocalDate rentedOn;
    private LocalDate rentedUntil;
    private LocalDate returnedOn;
    private boolean returned;

    public Rental(Book book, Person person, LocalDate rentedOn, LocalDate rentedUntil, LocalDate returnedOn, boolean returned) {
        this.id = UUID.randomUUID();
        this.book = book;
        this.person = person;
        this.rentedOn = rentedOn;
        this.rentedUntil = rentedUntil;
        this.returnedOn = returnedOn;
        this.returned = returned;
    }

    public Rental(UUID id, Book book, Person person, LocalDate rentedOn, LocalDate rentedUntil, LocalDate returnedOn, boolean returned) {
        this.id = id;
        this.book = book;
        this.person = person;
        this.rentedOn = rentedOn;
        this.rentedUntil = rentedUntil;
        this.returnedOn = returnedOn;
        this.returned = returned;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getRentedOn() {
        return rentedOn;
    }

    public void setRentedOn(LocalDate rentedOn) {
        this.rentedOn = rentedOn;
    }

    public LocalDate getRentedUntil() {
        return rentedUntil;
    }

    public void setRentedUntil(LocalDate rentedUntil) {
        this.rentedUntil = rentedUntil;
    }

    public LocalDate getReturnedOn() {
        return returnedOn;
    }

    public void setReturnedOn(LocalDate returnedOn) {
        this.returnedOn = returnedOn;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return returned == rental.returned && Objects.equals(id, rental.id) && Objects.equals(book, rental.book) && Objects.equals(person, rental.person) && Objects.equals(rentedOn, rental.rentedOn) && Objects.equals(rentedUntil, rental.rentedUntil) && Objects.equals(returnedOn, rental.returnedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, person, rentedOn, rentedUntil, returnedOn, returned);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", book=" + book +
                ", person=" + person +
                ", rentedOn=" + rentedOn +
                ", rentedUntil=" + rentedUntil +
                ", returnedOn=" + returnedOn +
                ", returned=" + returned +
                '}';
    }
}