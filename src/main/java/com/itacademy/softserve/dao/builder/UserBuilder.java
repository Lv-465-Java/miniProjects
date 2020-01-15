package com.itacademy.softserve.dao.builder;

import com.itacademy.softserve.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements InstanceBuilder<User> {

    /**
     * Build User instance from resultSet.
     *
     * @param resultSet
     * @return User object
     */
    @Override
    public User createInstance(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getLong("UserID"));
            user.setName(resultSet.getString("Name"));
            user.setPassword(resultSet.getString("Password"));
            return user;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
