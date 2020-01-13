package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
import com.softserve.onlineshop.dao.mapper.CartRowMapper;
import com.softserve.onlineshop.database.ConnectionManager;
import com.softserve.onlineshop.entity.Cart;
import com.softserve.onlineshop.entity.Cart.CartEntityQueries;
import com.softserve.onlineshop.entity.SqlQueries;
import com.softserve.onlineshop.util.JdbcUtil;

import java.sql.Connection;
import java.util.List;

public class CartDaoImpl extends CrudDaoImpl<Cart> {

    public CartDaoImpl() {
        super();
        init();
    }

    @Override
    protected String[] getFields(Cart cart) {
        String[] fields = new String[2];
        fields[0] = cart.getPhoneId().toString();
        fields[1] = cart.getUserId().toString();
        return fields;
    }

    @Override
    protected String[] getUpdatedFields(Cart entity) {
        return new String[0];
    }

    @Override
    protected void init() {
        for (CartEntityQueries cartEntityQueries : CartEntityQueries.values()) {
            sqlQueries.put(cartEntityQueries.getSqlQuery(), cartEntityQueries);
        }
    }

    public List<Cart> getByUserId(CartRowMapper mapper, Long userId) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        return JdbcUtil.getEntityList(connection, sqlQueries.get(SqlQueries.GET_BY_USER_ID).toString(), mapper, userId);
    }

    public boolean updateStateByPhoneId(Object... args) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        int executeQuery = JdbcUtil.update(connection, sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(), args);
        return executeQuery > 0;
    }

}
