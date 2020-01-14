package com.auto.service;

import java.sql.SQLException;
import java.util.List;

public interface BaseService<T,D> {

    List<T> findAll() throws SQLException;

    T findById (Integer id) throws SQLException;

    void create(D entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(Integer id) throws SQLException;


}