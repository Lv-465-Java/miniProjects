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

    protected abstract String[] getUpdatedFields(T entity);


    public boolean insert(T entity) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        int executeQuery = JdbcUtil.update(connection, sqlQueries.get(SqlQueries.INSERT).toString(),
                (Object[]) getFields(entity));
        return executeQuery > 0;
    }

    public boolean updateById(T entity) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        int executeQuery = JdbcUtil.update(connection, sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(),
                (Object[]) getUpdatedFields(entity));
        return executeQuery > 0;
    }

    public boolean deleteById(Long id) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        int executeQuery = JdbcUtil.update(connection, sqlQueries.get(SqlQueries.DELETE_BY_ID).toString(), id);
        return executeQuery > 0;
    }
}
