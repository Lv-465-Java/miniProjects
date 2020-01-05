package com.softserve.onlineshop.dao;

public interface CrudDao<TEntity> extends ReadDao<TEntity> {

    // Create
    boolean insert(TEntity entity);

    // Update
    boolean updateById(String... args);

    boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);

    // Delete
    boolean deleteById(Long id);

}
