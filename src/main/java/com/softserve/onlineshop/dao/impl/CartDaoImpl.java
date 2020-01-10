package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
import com.softserve.onlineshop.dao.mapper.CartRowMapper;
import com.softserve.onlineshop.database.ConnectionManager;
import com.softserve.onlineshop.entity.Cart;
import com.softserve.onlineshop.entity.Cart.CartEntityQueries;
import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.entity.SqlQueries;
import com.softserve.onlineshop.entity.User;
import com.softserve.onlineshop.util.JdbcUtil;

import javax.ejb.Local;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class CartDaoImpl extends CrudDaoImpl<Cart> {

    public CartDaoImpl() {
        super();
        init();
    }

    @Override
    protected String[] getFields(Cart cart) {
        String[] fields = new String[3];
        fields[0] = cart.getPhoneId().toString();
        fields[1] = cart.getUserId().toString();
        fields[2] = cart.getDateOfBuying().toString();
        return fields;
    }

    @Override
    protected void init() {
        for (CartEntityQueries cartEntityQueries : CartEntityQueries.values()) {
            sqlQueries.put(cartEntityQueries.getSqlQuery(), cartEntityQueries);
        }
    }

    public List<Cart> getByUserId(CartRowMapper mapper, Long userId) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        return JdbcUtil.getEntityList(connection, CartEntityQueries.GET_BY_USER_ID.toString(), mapper, userId);
    }

    public static void main(String[] args) {
        CartDaoImpl cartDao = new CartDaoImpl();
        PhoneDaoImpl phoneDao = new PhoneDaoImpl();
//        System.out.println(CartEntityQueries.GET_BY_USER_ID.toString());

//        System.out.println(cartDao.getByUserId(new CartRowMapper(), 1L));
//        LocalDateTime localDateTime = LocalDateTime.now();
//        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
//


//        System.out.println(date);
//        cartDao.insert(new Cart(1L, 2L, LocalDateTime.now()));

//        cartDao.insert(new Cart(4L, 1L, LocalDateTime.now()));
//        cartDao.insert(new Cart(5L, 1L, LocalDateTime.now()));
//        cartDao.insert(new Cart(3L, 2L, LocalDateTime.now()));
//        cartDao.insert(new Cart(1L, 2L, LocalDateTime.now()));
        System.out.println(cartDao.getByUserId(new CartRowMapper(), 1L));

//        phoneDao.insert(new Phone(2019, 15000, "photo", "blue", 4.6, 64, 1L));
//        phoneDao.insert(new Phone(2015, 35500, "photo", "blue", 4.6, 128, 3L));
//        phoneDao.insert(new Phone(2012, 43200, "photo", "blue", 5.6, 256, 2L));
//        phoneDao.insert(new Phone(2011, 13500, "photo", "blue", 1.6, 512, 2L));
//        phoneDao.insert(new Phone(2010, 2100, "photo", "blue", 6.6, 512, 1L));
//        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.insert(new User("student", "111", "student@ua","2321"));
//        userDao.insert(new User("teacher", "111", "teacher@ua","231421"));
//        userDao.insert(new User("mongol", "32111", "mongol@ua","2332"));
//        userDao.insert(new User("sheva", "151", "sheva@ua","12321"));
//        userDao.insert(new User("bilka", "112", "bilka@ua","908321"));
//        cartDao.insert(new Cart())
//        cartDao.getByUserId(new CartRowMapper(), )
//        cartDao.insert(new Cart(1L,1L, LocalDateTime.now()));
    }
}
