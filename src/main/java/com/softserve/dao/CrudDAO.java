package com.softserve.dao;

import java.util.Optional;

public interface CrudDAO<T> {
    Long save(T object);

    Optional<T> getById(Long id);

    void update(T object, Long id);

    void delete(Long id);
}