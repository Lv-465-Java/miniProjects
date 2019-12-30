package com.softserve.database;

import com.softserve.dao.mapping.Mapping;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCQueries {

    public static <T> Optional<T> getObject(Connection connection, String query, Mapping<T> mapper, Object... parameters) {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            insertParameters(statement, parameters);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapper.mapDataBaseRow(resultSet));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> getListOfObjects(Connection connection, String query, Mapping<T> mapper, Object... parameters) {
        List<T> list = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            insertParameters(statement, parameters);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(mapper.mapDataBaseRow(resultSet));
                }

                return list;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int update(Connection connection, String query, Object... parameters) {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            insertParameters(statement, parameters);

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void insertParameters(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                if (parameters[i] == null) {
                    statement.setNull(i + 1, Types.NULL);
                } else if (parameters[i] instanceof Integer) {
                    statement.setInt(i + 1, (Integer) parameters[i]);
                } else if (parameters[i] instanceof Long) {
                    statement.setLong(i + 1, (Long) parameters[i]);
                } else if (parameters[i] instanceof Double) {
                    statement.setDouble(i + 1, (Double) parameters[i]);
                } else if (parameters[i] instanceof String) {
                    statement.setString(i + 1, (String) parameters[i]);
                } else if (parameters[i] instanceof LocalDate) {

                    statement.setTimestamp(i + 1, new Timestamp(((LocalDate) parameters[i]).toEpochDay()));
                } else {
                    throw new RuntimeException("There are no mapping for " + parameters[i].getClass());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}