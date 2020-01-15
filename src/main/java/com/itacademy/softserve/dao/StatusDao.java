package com.itacademy.softserve.dao;

import com.itacademy.softserve.entity.Status;

public class StatusDao extends DaoCrudA<Status> {

    /**
     * Method initializes required resources.
     */
    @Override
    protected void init() {
        for (Status.StatusEntityQueries statusEntityQueries : Status.StatusEntityQueries.values()) {
            sqlQueries.put(statusEntityQueries.getQuery(), statusEntityQueries);
        }
    }

    /**
     * Method gets field values and put
     * them in array.
     *
     * @param entity Status object
     * @return array of entity field values
     */
    @Override
    protected Object[] getFields(Status entity) {
        Object[] fields = new Object[2];
        fields[0] = entity.getId();
        fields[1] = entity.getName();
        return fields;
    }

}
