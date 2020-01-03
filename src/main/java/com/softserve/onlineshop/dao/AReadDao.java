package com.softserve.onlineshop.dao;


import com.softserve.onlineshop.dao.mapper.RowMapper;
import com.softserve.onlineshop.database.ConnectionManager;
import com.softserve.onlineshop.entity.SqlQueries;
import com.softserve.onlineshop.util.JdbcUtil;

import java.sql.*;
import java.util.*;

public abstract class AReadDao<TEntity> implements ReadDao<TEntity> {

    protected final static String QUERY_NOT_FOUND = "Query not found %s";
    private final static String EMPTY_RESULTSET = "Empty ResultSet by Query %s";
    private final static String DATABASE_READING_ERROR = "Database Reading Error";

    protected final Map<Enum<?>, Enum<?>> sqlQueries;

    AReadDao() {
        this.sqlQueries = new HashMap<>();
    }

    protected abstract void init();

    protected abstract RowMapper<TEntity> getRowMapper();

    public Optional<TEntity> getById(Long id) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        return JdbcUtil.getEntity(connection, sqlQueries.get(SqlQueries.GET_BY_ID).toString(),
                getRowMapper(), id);
    }

    public List<TEntity> getByFieldName(String fieldName, String text) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        return JdbcUtil.getEntityList(connection, String.format(sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(),
                fieldName, text), getRowMapper());
    }

    public List<TEntity> getAll() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        return JdbcUtil.getEntityList(connection, sqlQueries.get(SqlQueries.GET_ALL).toString(), getRowMapper());
    }
}
