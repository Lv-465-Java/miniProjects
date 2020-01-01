package com.softserve.service;

import java.util.Optional;

public interface CrudService<T> {
    boolean create(T object);

    Optional<T> getById(Long id);

    boolean update(Long id, T object);

    boolean delete(Long id);
}