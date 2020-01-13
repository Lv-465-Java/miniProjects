package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
import com.softserve.onlineshop.dao.mapper.PhoneRowMapper;
import com.softserve.onlineshop.database.ConnectionManager;
import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.entity.Phone.PhoneEntityQueries;
import com.softserve.onlineshop.entity.SqlQueries;
import com.softserve.onlineshop.util.JdbcUtil;


import java.sql.Connection;
import java.util.List;


public class PhoneDaoImpl extends CrudDaoImpl<Phone> {
    private final static String ID_MODEL_FIELDNAME = "modelId";

    public PhoneDaoImpl() {
        super();
        init();
    }

    protected void init() {
        for (PhoneEntityQueries phoneEntityQueries : PhoneEntityQueries.values()) {
            sqlQueries.put(phoneEntityQueries.getSqlQuery(), phoneEntityQueries);
        }
    }

    protected String[] getFields(Phone phone) {
        String[] fields = new String[7];
        fields[0] = phone.getYear().toString();
        fields[1] = phone.getPrice().toString();
        fields[2] = phone.getPhoto();
        fields[3] = phone.getColor();
        fields[4] = phone.getScreenDiagonal().toString();
        fields[5] = phone.getInternalMemory().toString();
        fields[6] = phone.getModelId().toString();
        return fields;
    }

    @Override
    protected String[] getUpdatedFields(Phone phone) {
        String[] result = new String[8];
        String[] allFields = getFields(phone);
        result[0] = allFields[0];
        result[1] = allFields[1];
        result[2] = allFields[2];
        result[3] = allFields[3];
        result[4] = allFields[4];
        result[5] = allFields[5];
        result[6] = allFields[6];
        result[7] = phone.getId().toString();
        return result;
    }

    public List<Phone> getPhonesByModelId(PhoneRowMapper mapper, Long modelId) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        return JdbcUtil.getEntityList(connection, sqlQueries.get(SqlQueries.GET_BY_MODEL_ID).toString(),
                mapper, modelId);
    }

    //    public List<Phone> getPhonesByFilter(String query) {
//        return getQueryResult(String.format(sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(),
//                query), SqlQueries.GET_BY_FIELD);
//    }
//
    public static void main(String[] args) {
        PhoneDaoImpl phoneDao = new PhoneDaoImpl();
        System.out.println(phoneDao.getPhonesByModelId(new PhoneRowMapper(), 1L));
    }
}
