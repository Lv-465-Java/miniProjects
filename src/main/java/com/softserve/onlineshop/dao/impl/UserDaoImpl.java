package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.ACrudDao;
import com.softserve.onlineshop.dao.mapper.RowMapper;
import com.softserve.onlineshop.dao.mapper.UserRowMapper;
import com.softserve.onlineshop.entity.User;
import com.softserve.onlineshop.entity.User.UserEntityQueries;

public class UserDaoImpl extends ACrudDao<User> {

    public UserDaoImpl() {
        super();
        init();
    }

    @Override
    protected String[] getFields(User user) {
        String[] fields = new String[6];
        fields[0] = user.getId().toString();
        fields[1] = user.getNickname();
        fields[2] = user.getPassword();
        fields[3] = user.getEmail();
        fields[4] = user.getPhone();
        fields[5] = user.getCartId().toString();
        return fields;
    }

    @Override
    protected void init() {
        for (UserEntityQueries userEntityQueries : UserEntityQueries.values()) {
            sqlQueries.put(userEntityQueries.getSqlQuery(), userEntityQueries);
        }
    }

    @Override
    protected RowMapper<User> getRowMapper() {
        return new UserRowMapper();
    }

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User(3L,"omen","e44","mi@ua","091",3L);
        System.out.println(userDao.updateById(user.getNickname(),user.getPassword(), user.getEmail(), user.getPhone(),user.getCartId().toString(),user.getId().toString()));
    }
}
