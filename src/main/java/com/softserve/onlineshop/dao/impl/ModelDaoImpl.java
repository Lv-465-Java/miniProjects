package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
import com.softserve.onlineshop.dao.mapper.ModelRowMapper;
import com.softserve.onlineshop.database.ConnectionManager;
import com.softserve.onlineshop.dto.UserDto;
import com.softserve.onlineshop.entity.Model;
import com.softserve.onlineshop.entity.Model.ModelEntityQueries;
import com.softserve.onlineshop.entity.SqlQueries;
import com.softserve.onlineshop.util.JdbcUtil;

import java.sql.Connection;
import java.util.List;

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

    public List<Model> getAllByProducerId(ModelRowMapper mapper, Long producerId) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        return JdbcUtil.getEntityList(connection, sqlQueries.get(SqlQueries.GET_BY_PRODUCER_ID).toString(),
                mapper, producerId);
    }
}
