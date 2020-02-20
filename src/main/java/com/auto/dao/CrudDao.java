package com.auto.dao;
import java.sql.SQLException;

public interface CrudDao<T> extends ReadDao<T>{


    int create(T entity) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(Integer id) throws SQLException;

}
