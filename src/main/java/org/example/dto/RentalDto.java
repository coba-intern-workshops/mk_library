package org.example.dto;


import java.time.LocalDate;
import java.util.Objects;

public class RentalDto {
    private BookDto BookDto;
    private PersonDto PersonDto;
    private LocalDate rentedOn;
    private LocalDate rentedUntil;
    private LocalDate returnedOn;
    private boolean returned;

    public RentalDto(BookDto BookDto, PersonDto PersonDto, LocalDate rentedOn, LocalDate rentedUntil) {
        this.BookDto = BookDto;
        this.PersonDto = PersonDto;
        this.rentedOn = rentedOn;
        this.rentedUntil = rentedUntil;
        this.returned = false;
    }
    public RentalDto(BookDto BookDto, PersonDto PersonDto, LocalDate rentedOn, LocalDate rentedUntil, LocalDate returnedOn, boolean returned) {
        this.BookDto = BookDto;
        this.PersonDto = PersonDto;
        this.rentedOn = rentedOn;
        this.rentedUntil = rentedUntil;
        this.returnedOn = returnedOn;
        this.returned = returned;
    }

    public BookDto getBookDto() {
        return BookDto;
    }

    public void setBookDto(BookDto BookDto) {
        this.BookDto = BookDto;
    }

    public PersonDto getPersonDto() {
        return PersonDto;
    }

    public void setPersonDto(PersonDto PersonDto) {
        this.PersonDto = PersonDto;
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
        RentalDto rental = (RentalDto) o;
        return returned == rental.returned && Objects.equals(BookDto, rental.BookDto) && Objects.equals(PersonDto, rental.PersonDto) && Objects.equals(rentedOn, rental.rentedOn) && Objects.equals(rentedUntil, rental.rentedUntil) && Objects.equals(returnedOn, rental.returnedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash( BookDto, PersonDto, rentedOn, rentedUntil, returnedOn, returned);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "BookDto=" + BookDto +
                ", PersonDto=" + PersonDto +
                ", rentedOn=" + rentedOn +
                ", rentedUntil=" + rentedUntil +
                ", returnedOn=" + returnedOn +
                ", returned=" + returned +
                '}';
    }
}