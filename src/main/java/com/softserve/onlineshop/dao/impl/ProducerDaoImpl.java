package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
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

    protected String[] getUpdatedFields(Producer producer) {
        String[] fields = new String[2];
        fields[0] = producer.getName();
        fields[1] = producer.getId().toString();
        return fields;
    }

    @Override
    protected void init() {
        for (Producer.ProducerEntityQueries producerEntityQueries : Producer.ProducerEntityQueries.values()) {
            sqlQueries.put(producerEntityQueries.getSqlQuery(), producerEntityQueries);
        }
    }
}
