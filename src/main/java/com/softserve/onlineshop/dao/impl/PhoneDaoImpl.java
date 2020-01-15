package com.softserve.onlineshop.dao.impl;

import com.softserve.onlineshop.dao.CrudDaoImpl;
import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.entity.Phone.PhoneEntityQueries;


public class PhoneDaoImpl extends CrudDaoImpl<Phone> {

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
}
