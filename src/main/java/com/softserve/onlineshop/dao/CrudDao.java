package com.softserve.onlineshop.dao;

public interface CrudDao<TEntity> extends ReadDao<TEntity> {

    // Create
    boolean insert(TEntity entity);

    // Update
    boolean updateByEntity(TEntity entity);

    boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);

    // Delete
    boolean deleteById(Long id);

    boolean deleteByFieldName(String fieldCondition, String textCondition);

    boolean delete(TEntity entity);
}
