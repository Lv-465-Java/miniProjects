package com.itacademy.softserve.dao;

import com.itacademy.softserve.entity.History;

public class HistoryDao extends DaoCrudA<History> {

    /**
     * Method initializes required resources.
     */
    @Override
    protected void init() {
        for (History.HistoryEntityQueries historyEntityQueries : History.HistoryEntityQueries.values()) {
            sqlQueries.put(historyEntityQueries.getQuery(), historyEntityQueries);
        }
    }

    /**
     * Method gets field values and put
     * them in array.
     *
     * @param object History object
     * @return array of object field values
     */
    @Override
    protected Object[] getFields(History object) {
        Object[] fields = new Object[5];
        fields[0] = object.getId();
        fields[1] = object.getTaskDescription();
        fields[2] = object.getModifiedDate();
        fields[3] = object.getStatusID();
        fields[4] = object.getUserID();
        return fields;
    }
}
