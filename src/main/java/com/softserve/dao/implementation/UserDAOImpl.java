package com.softserve.dao.implementation;

import com.softserve.dao.CrudDAO;
import com.softserve.database.DataBaseConnection;
import com.softserve.database.JDBCQueries;
import com.softserve.entity.User;

import java.sql.Connection;
import java.util.Optional;

public class UserDAOImpl implements CrudDAO<User> {
    private Connection connection;
    private DataBaseConnection dataBaseConnection = DataBaseConnection.getInstance();

    public UserDAOImpl() {
        this.connection = dataBaseConnection.createConnection();
    }

    @Override
    public Long save(User user) {
        JDBCQueries.update(connection, User.UserEntityQueries.INSERT.getQuery(),
                user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return 1L;
    }

    @Override
    public Optional<User> getById(Long id) {
        JDBCQueries.

        return
    }

    @Override
    public void update(User object, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}