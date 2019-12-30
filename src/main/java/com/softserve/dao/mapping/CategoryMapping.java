package com.softserve.dao.mapping;

import com.softserve.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapping implements Mapping<Category> {
    @Override
    public Category mapDataBaseRow(ResultSet resultSet) {
        Category category = new Category();

        try {
            category.setId(resultSet.getLong("id"));
            category.setTitle(resultSet.getString("title"));
            category.setColor(resultSet.getString("color"));
            category.setDescription(resultSet.getString("description"));
            category.setUserId(resultSet.getLong("user_id"));
            category.setFinancialTypeId(resultSet.getLong("financial_type_id"));
            return category;
        } catch (SQLException e) {
            e.getStackTrace();
            throw new RuntimeException();
        }
    }
}
