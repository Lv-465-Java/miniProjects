package com.softserve.dao.implementation;

import com.softserve.dao.CrudDAO;
import com.softserve.dao.mapping.UserMapping;
import com.softserve.database.DataBaseConnection;
import com.softserve.database.JDBCQueries;
import com.softserve.entity.User;

import java.sql.Connection;
import java.util.Optional;

public class UserDAOImpl implements CrudDAO<User> {
    private Connection connection;

    public UserDAOImpl() {
        this.connection = DataBaseConnection.getInstance().getConnection();
    }

    @Override
    public boolean save(User user) {
        return JDBCQueries.update(connection, User.UserEntityQueries.INSERT.getQuery(),
                user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }

    @Override
    public Optional<User> getById(Long id) {
        return JDBCQueries.getObject(connection, User.UserEntityQueries.GET_BY_ID.getQuery(),
                new UserMapping(), id);
    }

    @Override
    public boolean update(Long id, User user) {
        return JDBCQueries.update(connection, User.UserEntityQueries.UPDATE.getQuery(),
                user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword(), user.getPhoto(), id);
    }

    @Override
    public boolean delete(Long id) {
        return JDBCQueries.update(connection, User.UserEntityQueries.DELETE.getQuery(), id);
    }

    public Optional<User> getByEmail(String email) {
        return JDBCQueries.getObject(connection, User.UserEntityQueries.GET_USER_BY_EMAIL.getQuery(),
                new UserMapping(), email);
    }


}