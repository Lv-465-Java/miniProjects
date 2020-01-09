package com.softserve.onlineshop.dao;

import com.softserve.onlineshop.dao.mapper.RowMapper;

import java.util.List;
import java.util.Optional;

public interface ReadDao<TEntity> {

    Optional<TEntity> getById(RowMapper<TEntity> mapper, Long id);

    List<TEntity> getByFieldName(RowMapper<TEntity> mapper, String... parameters);
//    List<TEntity> getByFieldName(String fieldName, String fieldValue);

    List<TEntity> getAll(RowMapper<TEntity> mapper);
}
