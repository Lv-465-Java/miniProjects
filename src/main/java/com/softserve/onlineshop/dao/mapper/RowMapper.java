package com.softserve.onlineshop.dao.mapper;

import java.sql.ResultSet;

public interface RowMapper<TEntity> {
    TEntity mapRow(ResultSet resultSet);
}
