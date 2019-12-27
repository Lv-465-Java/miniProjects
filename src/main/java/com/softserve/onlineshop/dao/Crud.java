package com.softserve.onlineshop.dao;

import java.util.List;
import java.util.Optional;

public interface Crud<T> {
    long save(T objectToSave);

    int update(T newObject);

    void deleteById(long id);

    Optional<T> findById(long id);

    List<T> getAll();


}
