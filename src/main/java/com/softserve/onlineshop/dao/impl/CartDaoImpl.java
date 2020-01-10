package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
import com.softserve.onlineshop.entity.Cart;

public class CartDaoImpl extends CrudDaoImpl<Cart> {
    @Override
    protected String[] getFields(Cart entity) {
        return new String[0];
    }

    @Override
    protected void init() {

    }
}
