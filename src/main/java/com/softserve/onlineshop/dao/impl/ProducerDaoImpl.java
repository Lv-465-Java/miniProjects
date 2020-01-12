package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
import com.softserve.onlineshop.dao.mapper.ProducerRowMapper;
import com.softserve.onlineshop.entity.Producer;

public class ProducerDaoImpl extends CrudDaoImpl<Producer> {

    public ProducerDaoImpl() {
        super();
        init();
    }

    @Override
    protected String[] getFields(Producer producer) {
        String[] fields = new String[1];
        fields[0] = producer.getName();
        return fields;
    }

    @Override
    protected void init() {
        for (Producer.ProducerEntityQueries producerEntityQueries : Producer.ProducerEntityQueries.values()) {
            sqlQueries.put(producerEntityQueries.getSqlQuery(), producerEntityQueries);
        }
    }

//    public static void main(String[] args) {
//        ProducerDaoImpl producerDao = new ProducerDaoImpl();
//        System.out.println(producerDao.updateById("UpdatedName", 4L));
////        System.out.println(producerDao.updateById(producerDao.getById(new ProducerRowMapper(),1L).get()));
//    }
}
