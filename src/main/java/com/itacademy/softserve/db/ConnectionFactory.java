package com.itacademy.softserve.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ConnectionFactory {
    private final String URL = "jdbc:mysql://localhost:3306/to_do_list?autoReconnect=true&useSSL=false";
    private final String USER_NAME = "arch";
    private final String PASSWORD = "arch006";

    private static volatile ConnectionFactory connectionFactory;
    private final Map<Long, Connection> connections;

    /**
     * Default constructor.
     */
    private ConnectionFactory() {
        this.connections = new HashMap<>();
    }

    /**
     * Method for getting ConnectionFactory object.
     *
     * @return ConnectionFactory object
     */
    public static ConnectionFactory getConnectionFactory() {
        if (connectionFactory == null) {
            synchronized (ConnectionFactory.class) {
                if (connectionFactory == null) {
                    connectionFactory = new ConnectionFactory();
                }
            }
        }
        return connectionFactory;
    }

    /**
     * Method add new connection.
     *
     * @param connection new Connection object
     */
    private void addConnection(Connection connection) {
        connections.put(Thread.currentThread().getId(), connection);
    }

    /**
     * Method for getting all connections.
     *
     * @return map of connections
     */
    private Map<Long, Connection> getAllConnections() {
        return this.connections;
    }

    /**
     * Method for getting new connection.
     *
     * @return Connection object
     */
    public Connection getConnection() {
        Connection connection = connections.get(Thread.currentThread().getId());
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            addConnection(connection);
        }
        return connection;
    }

    /**
     * Method close all connections.
     */
    public static void closeAllConnection() {
        if (connectionFactory != null) {
            for (Long key : connectionFactory.getAllConnections().keySet()) {
                if (connectionFactory.getAllConnections().get(key) != null) {
                    try {
                        connectionFactory.getAllConnections().get(key).close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    connectionFactory.getAllConnections().put(key, null);
                }
            }
        }
    }
}
