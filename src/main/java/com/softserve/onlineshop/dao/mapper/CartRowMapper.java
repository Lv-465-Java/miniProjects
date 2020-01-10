package com.softserve.onlineshop.dao.mapper;

import com.softserve.onlineshop.entity.Cart;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CartRowMapper implements RowMapper<Cart> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd HH-MM-SS");
    @Override
    public Cart mapRow(ResultSet resultSet) {
        Cart cart = new Cart();
        try {
            cart.setPhoneId(resultSet.getLong("phoneId"));
            cart.setUserId(resultSet.getLong("userId"));
            LocalDateTime localDateTime = (resultSet.getTimestamp("dateOfBuying").toLocalDateTime());
//            cart.setDateOfBuying(new Date(resultSet.getTimestamp("dayOfBuying").getTime()));
            cart.setDateOfBuying(localDateTime);
//            cart.setDateOfBuying();
//            cart.setDateOfBuying(LocalDateTime.parse(resultSet.getString("dateOfBuying"), formatter));
            return cart;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
