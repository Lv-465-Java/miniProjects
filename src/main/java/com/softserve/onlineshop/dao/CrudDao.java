package com.softserve.onlineshop.dao;

/**
 * Interface, that contains methods for
 * creating, updating , deleting objects from database.
 */
public interface CrudDao<T> extends ReadDao<T> {

    /**
     * Method for inserting objects in database.
     *
     * @param entity object, that must be saved.
     * @return true if object save to database.
     */
    boolean insert(T entity);

    /**
     * Method, that updates given object in database.
     *
     * @param entity object, that must be update
     * @return changed rows count in database.
     */
    boolean updateById(T entity);

    /**
     * Method for deleting object from database by id.
     *
     * @param id id of object, that must be deleted.
     * @return true if object deleted from database
     */
    boolean deleteById(Long id);
}
