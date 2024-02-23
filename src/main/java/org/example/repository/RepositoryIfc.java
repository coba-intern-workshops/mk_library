package org.example.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryIfc<T> {
    List<T> findAll();
    T save(T object);
    Optional<T> findById(UUID id);
}