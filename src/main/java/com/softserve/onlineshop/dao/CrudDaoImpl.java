package com.softserve.onlineshop.dao;

import com.softserve.onlineshop.database.ConnectionManager;
import com.softserve.onlineshop.entity.SqlQueries;
import com.softserve.onlineshop.util.JdbcUtil;

import java.sql.Connection;

public abstract class CrudDaoImpl<T> extends ReadDaoImpl<T> implements CrudDao<T> {

    protected CrudDaoImpl() {
        super();
    }

    protected abstract String[] getFields(T entity);


    // Create
    public boolean insert(T entity) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        int executeQuery = JdbcUtil.update(connection, sqlQueries.get(SqlQueries.INSERT).toString(),
                (Object[]) getFields(entity));
        return executeQuery > 0;
    }

    public boolean updateById(Object... args) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        int executeQuery = JdbcUtil.update(connection, sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(), args);
        return executeQuery > 0;
    }

    public boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        int executeQuery = JdbcUtil.update(connection, String.format(sqlQueries.get(SqlQueries.UPDATE_BY_FIELD).toString(),
                fieldName, text, fieldCondition, textCondition));
        return executeQuery > 0;
    }

    // Delete
    public boolean deleteById(Long id) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        int executeQuery = JdbcUtil.update(connection, sqlQueries.get(SqlQueries.DELETE_BY_ID).toString(), id);
        return executeQuery > 0;
    }

}
