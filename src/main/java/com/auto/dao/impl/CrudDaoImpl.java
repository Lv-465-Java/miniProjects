package com.auto.dao.impl;

import com.auto.dao.CrudDao;

import com.auto.utils.ConnectionManager;


import java.sql.*;



public abstract class CrudDaoImpl<T> extends ReadDaoImpl<T> implements CrudDao<T> {

    protected CrudDaoImpl() {
    }

    protected abstract String[] getFields(T entity);
    protected abstract String[] getUpdateFields(T entity);
    protected abstract String createQuery();
    protected abstract String deleteQuery();
    protected abstract String updateQuery(T entity);

    @Override
    public int create(T entity) throws SQLException {
        int result;
        Connection connection = ConnectionManager.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(createQuery());
        setArgsToStatement(statement, getFields(entity));
        result = statement.executeUpdate();
        return result;
    }

    @Override
    public int update(T entity) throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        int result;
        try (PreparedStatement statement = connection.prepareStatement(updateQuery(entity))) {
            setArgsToStatement(statement, getUpdateFields(entity));
            result = statement.executeUpdate();
            return result;
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        int result;
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery())) {
            statement.setInt(1, id);
            result = statement.executeUpdate();
        }
        return result;
    }

    private static void setArgsToStatement(PreparedStatement preparedStatement, Object... args) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    preparedStatement.setNull(i + 1, Types.NULL);
                } else if (String.class.equals(args[i].getClass())) {
                    preparedStatement.setString(i + 1, (String) args[i]);
                } else if (Long.class.equals(args[i].getClass())) {
                    preparedStatement.setLong(i + 1, (Long) args[i]);
                } else if (Integer.class.equals(args[i].getClass())) {
                    preparedStatement.setInt(i + 1, (Integer) args[i]);
                } else if (Date.class.equals(args[i].getClass())) {
                    preparedStatement.setDate(i + 1, (Date) args[i]);
                } else {

                }
            }
        } catch (SQLException e) {

        }
    }
}
