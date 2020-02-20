package com.auto.dao;

import java.sql.SQLException;
import java.util.List;

public interface ReadDao<T> {
    List<T> getAll() throws SQLException;

    T findById(Integer id) throws SQLException;
}
