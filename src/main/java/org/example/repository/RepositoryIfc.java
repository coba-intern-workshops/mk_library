package org.example.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryIfc<T> {
    List<T> findAll();
    T save(T object);
    long count();
    void delete(T entity);
    void deleteAll(List<T> entities);
    void deleteAllByUUID(List<UUID> ids);
    void deleteByUUID(UUID uuid);
    boolean existsByUUID(UUID uuid);
    List<T> findAllByUUID(List<UUID> uuids);
    Optional<T> findByUUID(UUID uuid);
    List<T> saveAll(List<T> entities);
}
