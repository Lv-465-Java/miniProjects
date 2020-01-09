package com.softserve.onlineshop.util;

import com.softserve.onlineshop.dao.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class JdbcUtil {
    public static <TEntity> Optional<TEntity> getEntity(Connection connection, String query, RowMapper<TEntity> mapper, Object... parameters) {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            insertParameters(statement, parameters);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapper.mapRow(resultSet));
                }

                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <TEntity> List<TEntity> getEntityList(Connection connection, String query, RowMapper<TEntity> mapper, Object... parameters) {
        List<TEntity> result = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            insertParameters(statement, parameters);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(mapper.mapRow(resultSet));
                }

                return result;
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
                } else if (parameters[i] instanceof String) {
                    statement.setString(i + 1, (String) parameters[i]);
                } else if (parameters[i] instanceof Date) {
                    statement.setTimestamp(i + 1, new Timestamp(((Date) parameters[i]).getTime()));
                } else {
                    throw new RuntimeException("There are no mapping for " + parameters[i].getClass());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
