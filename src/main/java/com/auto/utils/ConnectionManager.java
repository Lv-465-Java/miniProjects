package com.auto.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static ConnectionManager dbIsntance;
    private static Connection connection;
    private final String host;
    private final String username;
    private final String password;

    private ConnectionManager() {

        host =
                "jdbc:mysql://localhost:3306/autoservice?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";
        username = "root";
        password = "ass123ass";
    }

    public static ConnectionManager getInstance() {
        if (dbIsntance == null) {
            dbIsntance = new ConnectionManager();
        }
        return dbIsntance;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(host, username, password);
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return connection;
    }

    public void shutDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
