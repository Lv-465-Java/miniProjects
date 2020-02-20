package dao.impl;

import dao.DaoRead;
import db.ConnectionManager;
import entity.SqlQueries;
import entity.User;

import java.sql.*;
import java.util.*;


public abstract class DaoReadAbsImpl<TEntity> implements DaoRead<TEntity> {
    protected final static String QUERY_NOT_FOUND = "Query not found %s";
    protected final static String EMPTY_RESULTSET = "Empty ResultSet by Query %s";
    protected final static String DATABASE_READING_ERROR = "Database Reading Error";

    protected final Map<Enum<?>, Enum<?>> sqlQueries;

    protected DaoReadAbsImpl() {
        this.sqlQueries = new HashMap<>();
    }

    protected abstract TEntity createInstance(String[] args);

    protected abstract void init();

    private List<TEntity> getQueryResult(String query, SqlQueries sqlQueries, Object ... args) {
        List<TEntity> all = new ArrayList<TEntity>();
        String[] queryResult;
        if (query == null) {
            throw new RuntimeException(String.format(QUERY_NOT_FOUND, sqlQueries.name()));
        }

        try {PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(query);

            for (int i=1; i<= args.length; i++) {
                statement.setObject(i, args[i-1]);
            }
             ResultSet resultSet = statement.executeQuery();
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
        try {///////////////
            if (all.isEmpty()) {
                throw new RuntimeException(String.format(EMPTY_RESULTSET, query));
            }
        }catch (RuntimeException e){ /////////////
            System.out.println("Empty result set");//////////////
        }//////////////
        return all;
    }

    public Optional<TEntity> getById(Long id) {
        return Optional.of(getQueryResult(sqlQueries.get(SqlQueries.GET_BY_ID).toString(),SqlQueries.GET_BY_ID, id).get(0));
    }

    public Optional<TEntity> getByField(String text) {
        return Optional.of(getQueryResult(sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(), SqlQueries.GET_BY_FIELD, text).get(0));
    }

    public List<TEntity> getAll() {
        return getQueryResult(
                sqlQueries.get(SqlQueries.GET_ALL).toString(),
                SqlQueries.GET_ALL);
    }

    public List<TEntity> getAllLimit(){
        return getQueryResult(
                sqlQueries.get(SqlQueries.GET_ALL_LIMIT).toString(),
                SqlQueries.GET_ALL_LIMIT);
    }

    public List<TEntity> getByUserId(Long userId) {
        return getQueryResult(
                sqlQueries.get(SqlQueries.GET_BY_USER_ID).toString(),
                SqlQueries.GET_BY_USER_ID, userId);
    }

    public List<TEntity> getByFieldName(Long id) {
        return getQueryResult(
                sqlQueries.get(SqlQueries.GET_BY_FIELD_NAME).toString(),
                SqlQueries.GET_BY_FIELD_NAME,id);
    }
}

