package com.softserve.onlineshop.dao;

public interface CrudDao<T> extends ReadDao<T> {

    // Create
    boolean insert(T entity);

    // Update
    boolean updateById(T entity);

    // Delete
    boolean deleteById(Long id);
}
