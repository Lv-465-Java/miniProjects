package com.itacademy.softserve.dao;

import com.itacademy.softserve.dao.builder.InstanceBuilder;

import java.util.List;

/**
 * Interface that contains READ methods.
 */
public interface DaoReadI<TEntity> {

    /**
     * Method gets object of type TEntity
     * from database.
     *
     * @param builder map resultSet to entity
     * @param id
     * @return TEntity object
     */
    TEntity getByID(InstanceBuilder<TEntity> builder, Long id);

    /**
     * Method gets list of TEntity object
     * from database.
     *
     * @param builder map resultSet to entity
     * @param fields varargs with values
     * @return list of TEntity object
     */
    List<TEntity> getByFields(InstanceBuilder<TEntity> builder, Object... fields);

    /**
     * Method gets all TEntity objects
     * with certain params from database.
     *
     * @param builder map resultSet to entity
     * @param params varargs with values
     * @return
     */
    List<TEntity> getAll(InstanceBuilder<TEntity> builder, Object... params);
}
