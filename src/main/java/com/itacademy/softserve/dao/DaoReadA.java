package com.itacademy.softserve.dao;

import com.itacademy.softserve.dao.builder.InstanceBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class that contains READ methods.
 */
public abstract class DaoReadA<TEntity> implements DaoReadI<TEntity> {
    protected final Map<Enum<?>, Enum<?>> sqlQueries;

    /**
     * Default constructor.
     */
    protected DaoReadA() {
        sqlQueries = new HashMap<>();
        init();
    }

    /**
     * Method initializes required resources.
     */
    protected abstract void init();

    /**
     * Method gets object of type TEntity
     * from database.
     *
     * @param builder map resultSet to entity
     * @param id
     * @return TEntity object
     */
    @Override
    public TEntity getByID(InstanceBuilder<TEntity> builder, Long id) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntity(connection, sqlQueries.get(SqlQueries.GET_BY_ID).toString(), builder, id).get();
    }

    /**
     * Method gets list of TEntity object
     * from database.
     *
     * @param builder map resultSet to entity
     * @param fields  varargs with values
     * @return list of TEntity object
     */
    @Override
    public List<TEntity> getByFields(InstanceBuilder<TEntity> builder, Object... fields) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(), builder, fields);
    }

    /**
     * Method gets all TEntity objects
     * with certain params from database.
     *
     * @param builder map resultSet to entity
     * @param params  varargs with values
     * @return
     */
    @Override
    public List<TEntity> getAll(InstanceBuilder<TEntity> builder, Object... params) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, sqlQueries.get(SqlQueries.GET_ALL).toString(), builder, params);
    }
}
