package com.itacademy.softserve.util;

import com.itacademy.softserve.constant.ErrorMessage;
import com.itacademy.softserve.dao.builder.InstanceBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrudUtils {

    /**
     * Method gets object of type TEntity
     * from database.
     *
     * @param connection Connection object
     * @param query      SQL query
     * @param mapper     map from resultSet
     * @param args       varargs with values
     * @return optional object
     */
    public static <TEntity> Optional<TEntity> getEntity(Connection connection, String query, InstanceBuilder<TEntity> mapper, Object... args) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setArgsToStatement(preparedStatement, args);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapper.createInstance(resultSet));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Method gets list of TEntity objects
     * from database.
     *
     * @param connection Connection object
     * @param query      SQL query
     * @param mapper     map from resultSet
     * @param args       varargs with values
     * @return list of TEntity objects
     */
    public static <TEntity> List<TEntity> getEntityList(Connection connection, String query, InstanceBuilder<TEntity> mapper, Object... args) {
        List<TEntity> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setArgsToStatement(preparedStatement, args);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    entityList.add(mapper.createInstance(resultSet));
                }
                return entityList;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Method updates object in database.
     *
     * @param connection Connection object
     * @param query      SQL query
     * @param args       varargs with values
     * @return true if object is updated
     */
    public static int update(Connection connection, String query, Object... args) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setArgsToStatement(preparedStatement, args);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(ErrorMessage.SORRY_MESSAGE.toString());
        }
    }

    /**
     * Method sets values in preparedStatement.
     *
     * @param preparedStatement PreparedStatement object
     * @param args              varargs with values
     */
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
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}


