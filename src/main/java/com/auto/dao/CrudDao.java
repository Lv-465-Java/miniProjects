package com.auto.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> {
    List<T> getAll() throws SQLException;

    T findById(Integer id) throws SQLException;

    int create(T entity) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(Integer id) throws SQLException;

}
