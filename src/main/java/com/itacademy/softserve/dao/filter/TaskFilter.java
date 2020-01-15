package com.itacademy.softserve.dao.filter;

import com.itacademy.softserve.dao.builder.InstanceBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.List;

/**
 * Class, that implements special methods for
 * getting filtered tasks from database.
 */
public class TaskFilter {
    /**
     * Enum that contains SQL queries.
     */
    public static enum Filters {
        FILTER_BY_OWNER("SELECT TaskID, Assignee, Owner, Description, CreationDate," +
                " Deadline, StatusID FROM tasks WHERE Assignee = ? AND Owner = ?;"),
        FILTER_BY_DATE("SELECT TaskID, Assignee, Owner, Description, CreationDate," +
                " Deadline, StatusID FROM tasks WHERE (Assignee = ? OR Owner = ?) AND CreationDate BETWEEN ? AND ?;"),
        FILTER_BY_STATUS("SELECT TaskID, Assignee, Owner, Description," +
                " CreationDate, Deadline, StatusID FROM tasks WHERE (Assignee = ? OR Owner = ?) AND StatusID = ?;");

        private String query;

        private Filters(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }
    }

    /**
     * Method get filtered tasks by owner.
     *
     * @param builder map resultSet to entity
     * @param assigneeId
     * @param ownerId
     * @return list of tasks
     */
    public List<Task> filterByOwner(InstanceBuilder<Task> builder, Long assigneeId, Long ownerId) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, Filters.FILTER_BY_OWNER.getQuery(), builder, assigneeId, ownerId);
    }

    /**
     * Method get filtered tasks by date.
     *
     * @param builder map resultSet to entity
     * @param dates   begin and end date
     * @return list of tasks
     */
    public List<Task> filterByDate(InstanceBuilder<Task> builder, Object... dates) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, Filters.FILTER_BY_DATE.getQuery(), builder, dates);
    }

    /**
     * Method get filtered tasks by status.
     *
     * @param builder  map resultSet to entity
     * @param userId   can be assignee or owner
     * @param statusId
     * @return list of tasks
     */
    public List<Task> filterByStatus(InstanceBuilder<Task> builder, Long userId, Integer statusId) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, Filters.FILTER_BY_STATUS.getQuery(), builder, userId, userId, statusId);
    }

}

