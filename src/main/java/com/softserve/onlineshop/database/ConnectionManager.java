package com.softserve.onlineshop.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public final class ConnectionManager {
    private static volatile ConnectionManager instance;
    private final Map<Long, Connection> connections;

    private ConnectionManager() {
        this.connections = new HashMap<>();
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            synchronized (ConnectionManager.class) {
                instance = new ConnectionManager();
            }
        }
        return instance;
    }

    private Map<Long, Connection> getAllConnections() {
        return this.connections;
    }

    private void addConnection(Connection connection) {
        getAllConnections().put(Thread.currentThread().getId(), connection);
    }

    private Connection getConnection() {
        Connection connection = getAllConnections().get(Thread.currentThread().getId());
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lv465", "lv465", "andrii5");
            } catch (SQLException ex) {
                throw new RuntimeException("Failed to create the database connection.");
            }
            addConnection(connection);
        }
        return connection;
    }

    public void beginTransaction() {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException("Connection Failed", e);
        }
    }

    public void commitTransaction() {
        try {
            getConnection().commit();
        } catch (SQLException e) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException("Connection Failed", e);
        }
    }

    public void rollbackTransaction() {
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException("Connection Failed", e);
        }
    }

    public static void closeAllConnections() {
        if (instance != null) {
            for (Long key : instance.getAllConnections().keySet()) {
                if (instance.getAllConnections().get(key) != null) {
                    try {
                        instance.getAllConnections().get(key).close();
                    } catch (SQLException e) {
                        throw new RuntimeException("Failed to Close Connection", e);
                    }
                    instance.getAllConnections().put(key, null);
                }
            }
        }
    }
}
