package com.blog.dao;

import com.blog.db.ConnectionManager;
import com.blog.entity.SqlQueries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class ADaoRead<TEntity> implements IDaoRead<TEntity> {

    protected final static String QUERY_NOT_FOUND = "Query not found %s";
    protected final static String EMPTY_RESULTSET = "Empty ResultSet by Query %s";
    protected final static String DATABASE_READING_ERROR = "Database Reading Error";

    protected final Map<Enum<?>, Enum<?>> sqlQueries;

    protected ADaoRead() {
        this.sqlQueries = new HashMap<Enum<?>, Enum<?>>();
    }


    protected abstract TEntity createInstance(String[] args);

    protected abstract void init();

    private List<TEntity> getQueryResult(String query, String field, SqlQueries sqlQueries) {
        List<TEntity> all = new ArrayList<TEntity>();
        String[] queryResult;

        if (query == null) {
            throw new RuntimeException(String.format(QUERY_NOT_FOUND, sqlQueries.name()));
        }
        try(PreparedStatement preparedStatement = ConnectionManager.getInstance().getConnection().prepareStatement(query)) {
            if (!field.equals("0")) {
                preparedStatement.setString(1, field);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
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
        if (all.isEmpty()) {
            throw new RuntimeException(String.format(EMPTY_RESULTSET, query));
        }
        return all;
    }

    public TEntity getById(Long id) {
        return getQueryResult(String.format(
                sqlQueries.get(SqlQueries.GET_BY_ID).toString()), id.toString(),
                SqlQueries.GET_BY_ID).get(0);
    }

    public List<TEntity> getByFieldName(String fieldName, String text) {
        return getQueryResult(String.format(
                sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(), fieldName), text,
                SqlQueries.GET_BY_FIELD);
    }

    public List<TEntity> getAll() {
        return getQueryResult(
                sqlQueries.get(SqlQueries.GET_ALL).toString(), "0",
                SqlQueries.GET_ALL);
    }

    public List<TEntity> getByFieldNameLike(String fieldName, String text) {
        return getQueryResult(String.format(sqlQueries.get(SqlQueries.GET_BY_FIELD_LIKE).toString(), fieldName), text,
                SqlQueries.GET_BY_FIELD_LIKE);
    }
}
