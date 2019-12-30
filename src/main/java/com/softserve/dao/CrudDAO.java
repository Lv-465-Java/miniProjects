package com.softserve.dao;

import java.util.Optional;

public interface CrudDAO<T> {
    int save(T object);

    Optional<T> getById(Long id);

    int update(Long id, T object);

    int delete(Long id);
}