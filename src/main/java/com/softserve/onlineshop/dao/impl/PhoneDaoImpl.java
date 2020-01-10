package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
import com.softserve.onlineshop.dao.mapper.PhoneRowMapper;
import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.entity.Phone.PhoneEntityQueries;


import java.util.List;


public class PhoneDaoImpl extends CrudDaoImpl<Phone> {
    private final static String ID_MODEL_FIELDNAME = "modelId";

    public PhoneDaoImpl() {
        super();
        init();
    }

    // TODO Create abstract method in ADao
    protected void init() {
        for (PhoneEntityQueries phoneEntityQueries : PhoneEntityQueries.values()) {
            sqlQueries.put(phoneEntityQueries.getSqlQuery(), phoneEntityQueries);
        }
    }

    protected String[] getFields(Phone phone) {
        String[] fields = new String[7];
//        fields[0] = phone.getId().toString();
        fields[0] = phone.getYear().toString();
        fields[1] = phone.getPrice().toString();
        fields[2] = phone.getPhoto();
        fields[3] = phone.getColor();
        fields[4] = phone.getScreenDiagonal().toString();
        fields[5] = phone.getInternalMemory().toString();
        fields[6] = phone.getModelId().toString();
        return fields;
    }

    public List<Phone> getPhonesByModelId(PhoneRowMapper mapper, Long modelId) {
        return getByFieldName(mapper, ID_MODEL_FIELDNAME, modelId.toString());
    }

    //    public List<Phone> getPhonesByFilter(String query) {
//        return getQueryResult(String.format(sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(),
//                query), SqlQueries.GET_BY_FIELD);
//    }
//
}
