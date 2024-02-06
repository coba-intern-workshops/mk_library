package org.example.repository;

import org.example.model.Rental;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Optional;

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
    public long count() {
        return rentals.size();
    }

    @Override
    public void delete(Rental entity) {
        rentals.removeIf(rental -> rental.getId().equals(entity.getId()));
    }

    @Override
    public void deleteAll(List<Rental> entities) {
        for (Rental rental : entities) {
            rentals.removeIf(r -> r.getId().equals(rental.getId()));
        }
    }

    @Override
    public void deleteAllByUUID(List<UUID> ids) {
        rentals.removeIf(rental -> ids.contains(rental.getId()));
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        rentals.removeIf(rental -> rental.getId().equals(uuid));
    }

    @Override
    public boolean existsByUUID(UUID uuid) {
        return rentals.stream()
                .anyMatch(rental -> rental.getId().equals(uuid));
    }

    @Override
    public List<Rental> findAllByUUID(List<UUID> uuids) {
        return rentals.stream()
                .filter(rental -> uuids.contains(rental.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Rental> findByUUID(UUID uuid) {
        return rentals.stream()
                .filter(rental -> rental.getId().equals(uuid))
                .findFirst();
    }

    @Override
    public List<Rental> saveAll(List<Rental> entities) {
        rentals.addAll(entities);
        return entities;
    }
}