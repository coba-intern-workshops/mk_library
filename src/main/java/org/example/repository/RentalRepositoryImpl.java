package org.example.repository;

import org.example.model.Rental;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class RentalRepositoryImpl implements RepositoryIfc<Rental> {

    private List<Rental> rentals = new ArrayList<>();

    @Override
    public List<Rental> findAll() {
        return rentals;
    }

    @Override
    public Rental save(Rental object) {
        if (object == null){
            throw new IllegalArgumentException("Cannot save null object");
        }
        rentals.add(object);
        return object;
    }

    @Override
    public Optional<Rental> findById(UUID id) {
        return Optional.empty();
    }
}