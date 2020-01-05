package com.softserve.onlineshop.dao;

import java.util.List;
import java.util.Optional;

public interface ReadDao<TEntity>  {

    Optional<TEntity> getById(Long id);

    List<TEntity> getByFieldName(String fieldName, String fieldValue);

    List<TEntity> getAll();
}
