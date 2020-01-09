package com.softserve.onlineshop.dao;

import com.softserve.onlineshop.database.ConnectionManager;
import com.softserve.onlineshop.entity.Entity;
import com.softserve.onlineshop.entity.SqlQueries;
import com.softserve.onlineshop.util.JdbcUtil;

import java.sql.Connection;
import java.util.Arrays;

public abstract class CrudDaoImpl<TEntity extends Entity> extends ReadDaoImpl<TEntity> implements CrudDao<TEntity> {

    protected CrudDaoImpl() {
        super();
    }

    protected abstract String[] getFields(TEntity entity);


    // Create
    public boolean insert(TEntity entity) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        int executeQuery = JdbcUtil.update(connection, sqlQueries.get(SqlQueries.INSERT).toString(),
                (Object[]) Arrays.copyOfRange(getFields(entity), 0, getFields(entity).length));
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
