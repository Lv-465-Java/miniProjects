package com.softserve.onlineshop.dao.mapper;

import com.softserve.onlineshop.entity.Producer;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProducerRowMapper implements RowMapper<Producer> {
    @Override
    public Producer mapRow(ResultSet resultSet) {
        Producer producer = new Producer();
        try {
            producer.setName(resultSet.getString("name"));
            producer.setId(resultSet.getLong("id"));
            return producer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
