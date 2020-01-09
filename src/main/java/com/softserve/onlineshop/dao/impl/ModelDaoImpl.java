package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
import com.softserve.onlineshop.entity.Model;
import com.softserve.onlineshop.entity.Model.ModelEntityQueries;

public class ModelDaoImpl extends CrudDaoImpl<Model> {

    public ModelDaoImpl() {
        super();
        init();
    }

    @Override
    protected void init() {
        for (ModelEntityQueries modelEntityQueries : ModelEntityQueries.values()) {
            sqlQueries.put(modelEntityQueries.getSqlQuery(), modelEntityQueries);
        }
    }

    @Override
    protected String[] getFields(Model entity) {
        String[] fields = new String[2];
        fields[0] = entity.getName();
        fields[1] = entity.getProducerId().toString();
        return fields;
    }
}
