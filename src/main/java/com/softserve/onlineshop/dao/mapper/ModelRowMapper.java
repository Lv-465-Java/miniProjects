package com.softserve.onlineshop.dao.mapper;

import com.softserve.onlineshop.entity.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelRowMapper implements RowMapper<Model> {
    @Override
    public Model mapRow(ResultSet resultSet) {
        Model model = new Model();
        try {
            model.setName(resultSet.getString("name"));
            model.setProducerId(resultSet.getLong("producerId"));
            model.setId(resultSet.getLong("id"));
            return model;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
