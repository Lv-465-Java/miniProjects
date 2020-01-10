package com.softserve.onlineshop.dao;

public interface CrudDao<T> extends ReadDao<T> {

    // Create
    boolean insert(T entity);

    // Update
    boolean updateById(Object... args);

    boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);

    // Delete
    boolean deleteById(Long id);

}
