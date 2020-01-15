package com.itacademy.softserve.dao;

import com.itacademy.softserve.dao.builder.InstanceBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.List;

public class TaskDao extends DaoCrudA<Task> {

    /**
     * Method initializes required resources.
     */
    @Override
    protected void init() {
        for (Task.TaskEntityQueries taskEntityQueries : Task.TaskEntityQueries.values()) {
            sqlQueries.put(taskEntityQueries.getQuery(), taskEntityQueries);
        }
    }

    /**
     * Method gets field values and put
     * them in array.
     *
     * @param entity Task object
     * @return array of entity field values
     */
    @Override
    protected Object[] getFields(Task entity) {
        Object[] fields = new Object[7];
        fields[0] = entity.getId();
        fields[1] = entity.getAssigneeID();
        fields[2] = entity.getOwnerID();
        fields[3] = entity.getDescription();
        fields[4] = entity.getCreationDate();
        fields[5] = entity.getDeadline();
        fields[6] = entity.getStatusID();
        return fields;
    }

    /**
     * Method gets list of tasks by regex.
     *
     * @param builder map resultSet to entity
     * @param userId  user`s id
     * @param regex   part of input text
     * @return list of task
     */
    public List<Task> getByRegex(InstanceBuilder<Task> builder, Long userId, String regex) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        StringBuilder query = new StringBuilder(sqlQueries.get(SqlQueries.GET_BY_REGEX).toString())
                .append("'%")
                .append(regex)
                .append("%';");

        return CrudUtils.getEntityList(connection, query.toString(), builder, userId, userId);
    }
}
