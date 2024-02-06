package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.converter.RentalConverter;
import org.example.dto.RentalDto;
import org.example.model.Rental;
import org.example.repository.RentalRepositoryImpl;
import org.example.repository.RepositoryIfc;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepositoryImpl rentalRepository;
    private final RentalConverter rentalConverter;

    public List<RentalDto> findAllRentals(){
        return rentalRepository.findAll().stream()
                .map(rentalConverter::convertFromEntity)
                .collect(Collectors.toList());
    }
    public List<RentalDto> findRentals(RentalSearchCriteria searchCriteria){
        return rentalRepository.findAll().stream()
                .filter(rental -> rental.getPerson().getFirstName().equals(searchCriteria.getFirstName()) &&
                        rental.getPerson().getLastName().equals((searchCriteria.getLastName())))
                .map(rentalConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

}