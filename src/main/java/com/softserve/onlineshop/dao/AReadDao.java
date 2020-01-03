package com.softserve.onlineshop.dao;

import com.softserve.onlineshop.database.ConnectionManager;
import com.softserve.onlineshop.entity.SqlQueries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AReadDao<TEntity> implements ReadDao<TEntity> {

    protected final static String QUERY_NOT_FOUND = "Query not found %s";
    private final static String EMPTY_RESULTSET = "Empty ResultSet by Query %s";
    private final static String DATABASE_READING_ERROR = "Database Reading Error";
    //
    final Map<Enum<?>, Enum<?>> sqlQueries;

    AReadDao() {
        this.sqlQueries = new HashMap<>();
        // TODO Call init();
    }

    // TODO Use Builder
    // TODO Use List<String>
    protected abstract TEntity createInstance(String[] args);

    // TODO Create abstract method init
    protected abstract void init();

    // Read
    protected List<TEntity> getQueryResult(String query, SqlQueries sqlQueries) {
        List<TEntity> all = new ArrayList<>();
        String[] queryResult;
        if (query == null) {
            throw new RuntimeException(String.format(QUERY_NOT_FOUND, sqlQueries.name()));
        }
        try (PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            queryResult = new String[resultSet.getMetaData().getColumnCount()];
            while (resultSet.next()) {
                for (int i = 0; i < queryResult.length; i++) {
                    queryResult[i] = resultSet.getString(i + 1);
                }
                all.add(createInstance(queryResult));
            }
        } catch (SQLException e) {
            throw new RuntimeException(DATABASE_READING_ERROR, e);
        }
        // TODO Warning
        // TODO Warning
        if (all.isEmpty()) {
            throw new RuntimeException(String.format(EMPTY_RESULTSET, query));
        }
        return all;
    }

    public TEntity getById(Long id) {
        return getQueryResult(String.format(
                sqlQueries.get(SqlQueries.GET_BY_ID).toString(), id),
                SqlQueries.GET_BY_ID).get(0);
    }

    public List<TEntity> getByFieldName(String fieldName, String text) {
        return getQueryResult(String.format(
                sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(), fieldName, text),
                SqlQueries.GET_BY_FIELD);
    }

    public List<TEntity> getAll() {
        return getQueryResult(
                sqlQueries.get(SqlQueries.GET_ALL).toString(),
                SqlQueries.GET_ALL);
    }
}
