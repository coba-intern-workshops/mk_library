package org.example.repository;
import org.example.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<Person> findById(UUID id) {
        return Optional.empty();
    }
}