package com.softserve.onlineshop.dao;

import com.softserve.onlineshop.dao.mapper.RowMapper;

import java.util.List;
import java.util.Optional;

public interface ReadDao<T> {

    Optional<T> getById(RowMapper<T> mapper, Long id);

    List<T> getByFieldName(RowMapper<T> mapper, String... parameters);
//    List<TEntity> getByFieldName(String fieldName, String fieldValue);

    List<T> getAll(RowMapper<T> mapper);
}
