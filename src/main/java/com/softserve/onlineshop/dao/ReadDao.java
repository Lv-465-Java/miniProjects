package com.softserve.onlineshop.dao;

import com.softserve.onlineshop.dao.mapper.RowMapper;

import java.util.List;
import java.util.Optional;


/**
 * Interface, that contains methods for
 * getting objects from database.
 */
public interface ReadDao<T> {


    Optional<T> getById(RowMapper<T> mapper, Long id);

    List<T> getByFieldName(RowMapper<T> mapper, String... parameters);

    List<T> getAll(RowMapper<T> mapper);
}
