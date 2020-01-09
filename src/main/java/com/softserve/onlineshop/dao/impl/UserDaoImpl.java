package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
import com.softserve.onlineshop.dao.mapper.UserRowMapper;
import com.softserve.onlineshop.database.ConnectionManager;
import com.softserve.onlineshop.entity.SqlQueries;
import com.softserve.onlineshop.entity.User;
import com.softserve.onlineshop.entity.User.UserEntityQueries;
import com.softserve.onlineshop.util.JdbcUtil;

import java.sql.Connection;

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
//        fields[4] = user.getCartId().toString();
        return fields;
    }

    @Override
    protected void init() {
        for (UserEntityQueries userEntityQueries : UserEntityQueries.values()) {
            sqlQueries.put(userEntityQueries.getSqlQuery(), userEntityQueries);
        }
    }

    public boolean existsByNickname(UserRowMapper mapper, String nickname) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        return JdbcUtil.getEntity(connection, String.format(sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(),
                nickname), mapper).isPresent();
    }

//}


    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
//        User user = userDao.getById(new UserRowMapper(), )
//        System.out.println(userDao.insert(new User("amper", "aa", "v@", "212", 3L)));
//        System.out.println(userDao.getByFieldName(new UserRowMapper(), "omen"));
    }
}
