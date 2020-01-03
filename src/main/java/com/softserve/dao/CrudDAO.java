package com.softserve.dao;

import java.util.Optional;

public interface CrudDAO<T> {
    boolean save(T object);

    Optional<T> getById(Long id);

    boolean update(Long id, T object);

    boolean delete(Long id);
}