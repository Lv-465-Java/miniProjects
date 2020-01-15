package com.itacademy.softserve.dao;

/**
 * Interface that contains CRUD methods.
 */
public interface DaoCrudI<TEntity> extends DaoReadI<TEntity> {

    /**
     * Method saves object in database.
     *
     * @param createdObject object created during registration
     *                      or task creation
     * @return true if object is saved
     */
    boolean insert(TEntity createdObject);

    /**
     * Method updates object by id in database.
     *
     * @param args varargs with values
     * @return true if object is updated
     */
    boolean updateByID(Object... args);

    /**
     * Method updates object by field in database.
     *
     * @param fieldsValues varargs with values
     * @return
     */
    boolean updateByField(Object... fieldsValues);

    /**
     * Method deletes object by id in database.
     *
     * @param id object's id.
     * @return true if object is deleted
     */
    boolean deleteByID(long id);

    /**
     * Method deletes object by field in database.
     *
     * @param fieldsValues varargs with values
     * @return true if object is deleted
     */
    boolean deleteByField(Object... fieldsValues);

}
