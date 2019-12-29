package com.softserve.dao.mapping;

import com.softserve.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapping implements Mapping<User>{
    public User mapDataBaseRow(ResultSet resultSet) {
        User user = new User();

        try {
            user.setId(resultSet.getLong("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}