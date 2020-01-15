package com.itacademy.softserve.dao.builder;

import java.sql.ResultSet;

public interface InstanceBuilder<TEntity> {

    /**
     * Build instance from resultSet.
     *
     * @param resultSet
     * @return New object
     */
    TEntity createInstance(ResultSet resultSet);
}
