package com.softserve.onlineshop.dao.mapper;

import com.softserve.onlineshop.entity.Model;
import com.softserve.onlineshop.entity.Phone;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneRowMapper implements RowMapper<Phone> {

    @Override
    public Phone mapRow(ResultSet resultSet) {
        Phone phone = new Phone();
        try {
            phone.setYear(resultSet.getInt("year"));
            phone.setPrice(resultSet.getInt("price"));
            phone.setPhoto(resultSet.getString("photo"));
            phone.setColor(resultSet.getString("color"));
            phone.setScreenDiagonal(resultSet.getDouble("screenDiagonal"));
            phone.setInternalMemory(resultSet.getInt("internalMemory"));
            phone.setModelId(resultSet.getLong("modelId"));
            phone.setId(resultSet.getLong("id"));
            return phone;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
