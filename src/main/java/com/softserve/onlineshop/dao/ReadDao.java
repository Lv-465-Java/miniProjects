package com.softserve.onlineshop.dao;

import java.util.List;

public interface ReadDao<TEntity>  {

    TEntity getById(Long id);

    List<TEntity> getByFieldName(String fieldName, String text);

    List<TEntity> getAll();
}
