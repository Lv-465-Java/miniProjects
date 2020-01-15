package com.itacademy.softserve.dao;

import com.itacademy.softserve.dao.builder.InstanceBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.entity.User;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.List;

public class UserDao extends DaoCrudA<User> {

    /**
     * Method initializes required resources.
     */
    @Override
    protected void init() {
        for (User.UserEntityQueries userEntityQueries : User.UserEntityQueries.values()) {
            sqlQueries.put(userEntityQueries.getQuery(), userEntityQueries);
        }
    }

    /**
     * Method gets field values and put
     * them in array.
     *
     * @param entity User object
     * @return array of entity field values
     */
    @Override
    protected Object[] getFields(User entity) {
        Object[] fields = new Object[3];
        fields[0] = entity.getId();
        fields[1] = entity.getName();
        fields[2] = entity.getPassword();
        return fields;
    }

    /**
     * Method gets all User objects from database.
     *
     * @param instanceBuilder map resultSet to entity
     * @return
     */
    public List<User> getAllUsers(InstanceBuilder<User> instanceBuilder) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, sqlQueries.get(SqlQueries.GET_ALL).toString(), instanceBuilder);
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
        String query = String.format(sqlQueries.get(SqlQueries.UPDATE_BY_FIELD).toString(),
                fieldsValues[0], fieldsValues[1], fieldsValues[2]);
        return CrudUtils.update(connection, query) == 1;
    }
}
