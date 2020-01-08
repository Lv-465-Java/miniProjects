package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.ACrudDao;
import com.softserve.onlineshop.dao.mapper.PhoneRowMapper;
import com.softserve.onlineshop.dao.mapper.RowMapper;
import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.entity.Phone.PhoneEntityQueries;


import java.util.LinkedList;
import java.util.List;


public class PhoneDaoImpl extends ACrudDao<Phone> {
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

    @Override
    protected RowMapper<Phone> getRowMapper() {
        return new PhoneRowMapper();
    }

    protected String[] getFields(Phone phone) {
        String[] fields = new String[8];
        fields[0] = phone.getId().toString();
        fields[1] = phone.getYear().toString();
        fields[2] = phone.getPrice().toString();
        fields[3] = phone.getPhoto();
        fields[4] = phone.getColor();
        fields[5] = phone.getScreenDiagonal().toString();
        fields[6] = phone.getInternalMemory().toString();
        fields[7] = phone.getModelId().toString();
        return fields;
    }

//    public List<Phone> getPhonesByModelId(Long modelId) {
//        return getByFieldName(ID_MODEL_FIELDNAME, modelId.toString());
////        return new LinkedList<>();
//    }

    //    public List<Phone> getPhonesByFilter(String query) {
//        return getQueryResult(String.format(sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(),
//                query), SqlQueries.GET_BY_FIELD);
//    }
//
}
