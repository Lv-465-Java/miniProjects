package com.itacademy.softserve.dao;

import com.itacademy.softserve.dao.builder.InstanceBuilder;
import com.itacademy.softserve.db.ConnectionFactory;
import com.itacademy.softserve.entity.SqlQueries;
import com.itacademy.softserve.entity.User;
import com.itacademy.softserve.util.CrudUtils;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao extends DaoCrudA<User> {

    @Override
    protected void init() {
        for(User.UserEntityQueries userEntityQueries : User.UserEntityQueries.values()) {
            sqlQueries.put(userEntityQueries.getQuery(), userEntityQueries);
        }
    }

    @Override
    protected Object[] getFields(User entity) {
        Object[] fields = new Object[3];
        fields[0] = entity.getId();
        fields[1] = entity.getName();
        fields[2] = entity.getPassword();
        return fields;
    }

    public List<User>  getAllUsers(InstanceBuilder<User> instanceBuilder) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        return CrudUtils.getEntityList(connection, sqlQueries.get(SqlQueries.GET_ALL).toString(), instanceBuilder);
    }

    @Override
    public boolean updateByField(Object... fieldsValues) {
        Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
        String query = String.format(sqlQueries.get(SqlQueries.UPDATE_BY_FIELD).toString(),
                fieldsValues[0], fieldsValues[1], fieldsValues[2]);
        return CrudUtils.update(connection, query) == 1;
    }
}
