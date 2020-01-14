package com.blog.db;

import java.sql.Driver;

public final class DataSource {

    private Driver jdbcDriver;
    private String connectionUrl;
    private String username;
    private String password;

    public DataSource(Driver jdbcDriver, String connectionUrl, String username, String password) {
        this.jdbcDriver = jdbcDriver;
        this.connectionUrl = connectionUrl;
        this.username = username;
        this.password = password;
    }

    public Driver getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(Driver jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object dataSource) {
        boolean result = false;
        if (dataSource instanceof DataSource) {
            result = getJdbcDriver().getClass().getName()
                    .equals(((DataSource) dataSource).getJdbcDriver().getClass().getName())
                    && getConnectionUrl().equals(((DataSource) dataSource).getConnectionUrl())
                    && getUsername().equals(((DataSource) dataSource).getUsername())
                    && getPassword().equals(((DataSource) dataSource).getPassword());
        }
        return result;
    }
}
