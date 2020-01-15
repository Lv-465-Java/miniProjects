package com.itacademy.softserve.dao;

import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.Entity;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.Arrays;

/**
 * Abstract class that contains CRUD methods.
 */
public abstract class DaoCrudA<TEntity extends Entity> extends DaoReadA<TEntity> implements DaoCrudI<TEntity> {

    /**
     * Default constructor.
     */
    protected DaoCrudA() {
        super();
    }

    /**
     * Method gets field values and put
     * them in array.
     *
     * @param entity TEntity object
     * @return array of entity field values
     */
    protected abstract Object[] getFields(TEntity entity);

    /**
     * Method saves object in database.
     *
     * @param createdObject object created during registration
     *                      or task creation
     * @return true if object is saved
     */
    @Override
    public boolean insert(TEntity createdObject) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.INSERT).toString(),
                (Object[]) Arrays.copyOfRange(getFields(createdObject), 1, getFields(createdObject).length));
        return status == 1;
    }

    /**
     * Method updates object by id in database.
     *
     * @param args varargs with values
     * @return true if object is updated
     */
    @Override
    public boolean updateByID(Object... args) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(), args);
        return status > 0;
    }

    /**
     * Method updates object by field in database.
     *
     * @param fieldsValues varargs with values
     * @return
     */
    @Override
    public boolean updateByField(Object... fieldsValues) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.UPDATE_BY_FIELD).toString(), fieldsValues);
        return status > 0;
    }

    /**
     * Method deletes object by id in database.
     *
     * @param id object's id.
     * @return true if object is deleted
     */
    @Override
    public boolean deleteByID(long id) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.DELETE_BY_ID).toString(), id);
        return status > 0;
    }

    /**
     * Method deletes object by field in database.
     *
     * @param fieldsValues varargs with values
     * @return true if object is deleted
     */
    @Override
    public boolean deleteByField(Object... fieldsValues) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        int status = CrudUtils.update(connection, sqlQueries.get(SqlQueries.DELETE_BY_FIELD).toString(), fieldsValues);
        return status > 0;
    }
}
