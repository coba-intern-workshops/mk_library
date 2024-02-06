package org.example.repository;

import org.example.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PersonRepositoryImpl implements RepositoryIfc<Person>{

    private List<Person> persons = new ArrayList<>();

    @Override
    public List<Person> findAll() {
        return persons;
    }

    @Override
    public Person save(Person object) {
        if (object == null){
            throw new IllegalArgumentException("Cannot save null object");
        }
        persons.add(object);
        return object;
    }
    //new
    @Override
    public long count() {
        return persons.size();
    }

    @Override
    public void delete(Person entity) {
        persons.removeIf(rental -> rental.getId().equals(entity.getId()));
    }

    @Override
    public void deleteAll(List<Person> entities) {
        for (Person rental : entities) {
            persons.removeIf(r -> r.getId().equals(rental.getId()));
        }
    }

    @Override
    public void deleteAllByUUID(List<UUID> ids) {
        persons.removeIf(rental -> ids.contains(rental.getId()));
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        persons.removeIf(rental -> rental.getId().equals(uuid));
    }

    @Override
    public boolean existsByUUID(UUID uuid) {
        return persons.stream()
                .anyMatch(rental -> rental.getId().equals(uuid));
    }

    @Override
    public List<Person> findAllByUUID(List<UUID> uuids) {
        return persons.stream()
                .filter(rental -> uuids.contains(rental.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Person> findByUUID(UUID uuid) {
        return persons.stream()
                .filter(rental -> rental.getId().equals(uuid))
                .findFirst();
    }

    @Override
    public List<Person> saveAll(List<Person> entities) {
        persons.addAll(entities);
        return entities;
    }
}