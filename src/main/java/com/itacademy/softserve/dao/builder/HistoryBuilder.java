package com.itacademy.softserve.dao.builder;

import com.itacademy.softserve.entity.History;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryBuilder implements InstanceBuilder<History> {

    /**
     * Build history instance from resultSet.
     *
     * @param resultSet
     * @return History object
     */
    @Override
    public History createInstance(ResultSet resultSet) {
        History history = new History();
        try {
            history.setId(resultSet.getLong("ID"));
            history.setTaskDescription(resultSet.getString("TaskDescription"));
            history.setModifiedDate(resultSet.getDate("ModifiedDate"));
            history.setStatusID(resultSet.getInt("StatusID"));
            history.setUserID(resultSet.getLong("UserID"));
            return history;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
