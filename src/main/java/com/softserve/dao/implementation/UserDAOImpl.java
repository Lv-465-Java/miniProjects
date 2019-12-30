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
    public Long save(User user) {
        JDBCQueries.update(connection, User.UserEntityQueries.INSERT.getQuery(),
                user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return 1L;
    }

    @Override
    public Optional<User> getById(Long id) {
        return JDBCQueries.getObject(connection, User.UserEntityQueries.GET_BY_ID.getQuery(),
                new UserMapping(), id);
    }

    @Override
    public void update(Long id, User user) {
        JDBCQueries.update(connection, User.UserEntityQueries.UPDATE.getQuery(),
                id, user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword(), user.getPhoto());
    }

    @Override
    public void delete(Long id) {
        JDBCQueries.update(connection, User.UserEntityQueries.DELETE.getQuery(), id);
    }
}