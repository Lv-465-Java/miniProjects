package com.auto.dao.impl;

import com.auto.dao.CrudDao;
import com.auto.dao.ReadDao;
import com.auto.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class ReadDaoImpl<T> implements ReadDao<T> {
    protected final static String QUERY_NOT_FOUND = "Query not found %s";
    protected final static String EMPTY_RESULTSET = "Empty ResultSet by Query %s";
    protected final static String DATABASE_READING_ERROR = "Database Reading Error";

    protected abstract T createInstance(String[] strings);
    protected abstract String getAllQuery();
    protected abstract String getByIdQuery();
    protected abstract String getIdQuery();
    protected abstract String getByFieldQuery(String field);
    protected  String getByBrandQuery(String field){
        return  "Select * from checks inner join cars on cars.id = checks.car_id where brand like '%" + field + "%'";
    }

    protected List<T> getQueryResult(String query) {
        List<T> all = new ArrayList<T>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String[] queryResult;
        if (query == null) {
            throw new RuntimeException(String.format(QUERY_NOT_FOUND));
        }
        try {
            statement = ConnectionManager.getInstance().getConnection().prepareStatement(query);
            resultSet = statement.executeQuery();
            queryResult = new String[resultSet.getMetaData().getColumnCount()];
            while (resultSet.next()) {
                for (int i = 0; i < queryResult.length; i++) {
                    queryResult[i] = resultSet.getString(i + 1);
                }
                all.add(createInstance(queryResult));
            }
        } catch (SQLException e) {
            System.out.println("501 problem");
            throw new RuntimeException(DATABASE_READING_ERROR, e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                    System.out.println("500 problem");
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    System.out.println("502 problem");
                }
            }
        }
        if (all.isEmpty()) {
            throw new RuntimeException(String.format(EMPTY_RESULTSET, query));
        }
        return all;
    }

    public List<T>getByField(String field){
        return  getQueryResult(getByFieldQuery(field));
    }
    public List<T> getByBrand(String field){
        return getQueryResult(getByBrandQuery(field));
    }

    public Integer getId() throws SQLException {
        Integer key = null;
        Connection connection = ConnectionManager.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(getIdQuery());
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            key = (int) resultSet.getLong(1);
        }
        return key;
    }

    public List<T> getAll() {

        return getQueryResult(
                getAllQuery());
    }

    @Override
    public T findById(Integer id) {

        return  getQueryResult(String.format(getByIdQuery(),id)).get(0);
    }
}
