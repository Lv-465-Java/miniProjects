package com.blog.dao;

import com.blog.entity.User;
import com.blog.entity.User.UserEntityQueries;


public class UserDao extends ADaoCRUD<User> {


    public UserDao(){
        super();
        init();
    }

    @Override
    protected void init() {
        for (UserEntityQueries userEntityQueries: UserEntityQueries.values()){
            sqlQueries.put(userEntityQueries.getSqlQuery(), userEntityQueries);
        }
    }

    @Override
    protected String[] getFields(User entity) {
        String[] fields = new String[5];
        fields[0] = entity.getUsername();
        fields[1] = entity.getPassword();
        fields[2] = entity.getFirstName();
        fields[3] = entity.getLastName();
        fields[4] = entity.getRoleId().toString();
        return fields;
    }

    @Override
    protected String[] getUpdateFields(User entity) {
        String[] result = new String[6];
        result[0] = entity.getUsername();
        result[1] = entity.getPassword();
        result[2] = entity.getFirstName();
        result[3] = entity.getLastName();
        result[4] = entity.getRoleId().toString();
        result[5] = entity.getId().toString();
        return result;
    }

    @Override
    protected User createInstance(String[] args) {
        return new User(
                Long.parseLong(args[0] == null ? "0" : args[0]),
                args[1] == null ? new String() : args[1],
                args[2] == null ? new String() : args[2],
                args[3] == null ? new String() : args[3],
                args[4] == null ? new String() : args[4],
                Long.parseLong(args[5] == null ? "0" : args[5]));
    }


}
