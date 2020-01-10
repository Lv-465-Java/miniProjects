package com.softserve.onlineshop.dao;


import com.softserve.onlineshop.dao.mapper.RowMapper;
import com.softserve.onlineshop.database.ConnectionManager;
import com.softserve.onlineshop.entity.SqlQueries;
import com.softserve.onlineshop.util.JdbcUtil;

import java.sql.*;
import java.util.*;

public abstract class ReadDaoImpl<T> implements ReadDao<T> {

    protected final static String QUERY_NOT_FOUND = "Query not found %s";
    private final static String EMPTY_RESULTSET = "Empty ResultSet by Query %s";
    private final static String DATABASE_READING_ERROR = "Database Reading Error";

    protected final Map<Enum<?>, Enum<?>> sqlQueries;

    ReadDaoImpl() {
        this.sqlQueries = new HashMap<>();
    }

    protected abstract void init();

    public Optional<T> getById(RowMapper<T> mapper, Long id) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        return JdbcUtil.getEntity(connection, sqlQueries.get(SqlQueries.GET_BY_ID).toString(),
                mapper, id);
    }

    public List<T> getByFieldName(RowMapper<T> mapper, String... parameters) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        return JdbcUtil.getEntityList(connection, String.format(sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(),
                (Object[]) parameters), mapper);
    }

    public List<T> getAll(RowMapper<T> mapper) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        return JdbcUtil.getEntityList(connection, sqlQueries.get(SqlQueries.GET_ALL).toString(), mapper);
    }
}
