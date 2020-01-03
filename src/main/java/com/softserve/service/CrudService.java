package com.softserve.service;

public interface CrudService<T> {
    boolean create(T object);

    T getById(Long id);

    boolean update(Long id, T object);

    boolean delete(Long id);
}