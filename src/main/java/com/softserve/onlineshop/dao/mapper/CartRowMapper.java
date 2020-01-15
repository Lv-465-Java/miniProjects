package com.softserve.onlineshop.dao.mapper;

import com.softserve.onlineshop.entity.Cart;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRowMapper implements RowMapper<Cart> {
    @Override
    public Cart mapRow(ResultSet resultSet) {
        Cart cart = new Cart();
        try {
            cart.setPhoneId(resultSet.getLong("phoneId"));
            cart.setUserId(resultSet.getLong("userId"));
            if (resultSet.getTimestamp("dateOfBuying") != null) {
                cart.setDateOfBuying(resultSet.getTimestamp("dateOfBuying").toLocalDateTime());
            }
            return cart;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
