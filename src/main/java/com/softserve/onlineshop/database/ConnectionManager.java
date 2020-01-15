package com.softserve.onlineshop.database;


import com.softserve.onlineshop.constant.Parameters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static com.softserve.onlineshop.constant.Parameters.*;

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

    public Connection getConnection() {
        Connection connection = getAllConnections().get(Thread.currentThread().getId());
        if (connection == null) {
            try {
                Class.forName(Parameters.MYSQL_DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException("Failed to create the database connection.");
            }
            addConnection(connection);
        }
        return connection;
    }
}
