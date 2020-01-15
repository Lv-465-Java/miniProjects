package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
import com.softserve.onlineshop.entity.User;
import com.softserve.onlineshop.entity.User.UserEntityQueries;

public class UserDaoImpl extends CrudDaoImpl<User> {

    public UserDaoImpl() {
        super();
        init();
    }

    @Override
    protected String[] getFields(User user) {
        String[] fields = new String[4];
//        fields[0] = user.getId().toString();
        fields[0] = user.getNickname();
        fields[1] = user.getPassword();
        fields[2] = user.getEmail();
        fields[3] = user.getPhone();
        return fields;
    }

    @Override
    protected String[] getUpdatedFields(User user) {
        String[] fields = new String[5];
        fields[0] = user.getNickname();
        fields[1] = user.getPassword();
        fields[2] = user.getEmail();
        fields[3] = user.getPhone();
        fields[4] = user.getId().toString();
        return fields;
    }

    @Override
    protected void init() {
        for (UserEntityQueries userEntityQueries : UserEntityQueries.values()) {
            sqlQueries.put(userEntityQueries.getSqlQuery(), userEntityQueries);
        }
    }
}
