package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.converter.RentalConverter;
import org.example.dto.RentalDto;
import org.example.model.Rental;
import org.example.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RentalService {

    private final Repository<Rental> rentalRepository;
    private final RentalConverter rentalConverter;
    public List<RentalDto> findRentals (RentalSearchCriteria searchCriteria){
        return rentalRepository.findAll().stream()
                .filter(rental -> rental.getPerson().getFirstName().equals(searchCriteria.getFirstName()) &&
                        rental.getPerson().getLastName().equals((searchCriteria.getLastName())) )
                .map(rentalConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

}