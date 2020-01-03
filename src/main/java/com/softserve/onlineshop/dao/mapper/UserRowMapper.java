package com.softserve.onlineshop.dao.mapper;

import com.softserve.onlineshop.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet) {
        User user = new User();
        try {
            user.setNickname(resultSet.getString("nickname"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setPhone(resultSet.getString("phone"));
            user.setCartId(resultSet.getLong("cardId"));
            user.setCartId(resultSet.getLong("id"));
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
