package com.softserve.onlineshop.dao;

import com.softserve.onlineshop.entity.Phone;
import com.softserve.onlineshop.entity.Phone.PhoneEntityQueries;
import com.softserve.onlineshop.entity.SqlQueries;

import java.util.List;


public class PhoneDaoImpl extends ACrudDao<Phone> {
    private final static String URL = "jdbc:mysql://localhost:3306/phoneshop";
    private final static String USER = "lv465";
    private final static String PASS = "andrii5";

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

    protected Phone createInstance(String[] args) {
        return new Phone(
                Long.parseLong(args[0] == null ? "0" : args[0]),
                Integer.parseInt(args[1] == null ? "0" : args[1]),
                Integer.parseInt(args[2] == null ? "0" : args[2]),
                args[3] == null ? "" : args[3],
                args[4] == null ? "" : args[4],
                Double.parseDouble(args[5] == null ? "0" : args[5]),
                Integer.parseInt(args[6] == null ? "0" : args[6]),
                Long.parseLong(args[7] == null ? "0" : args[7]));
    }

    protected String[] getUpdateFields(Phone phone) {
        String[] result = new String[8];
        String[] allFields = getFields(phone);
        result[0] = allFields[1]; // year
        result[1] = allFields[2]; // price
        result[2] = allFields[3]; // photo
        result[3] = allFields[4]; // color
        result[4] = allFields[5]; // screenDiagonal
        result[5] = allFields[6]; // internalMemory
        result[6] = allFields[7]; // modelId
        result[7] = allFields[0]; // Id
        return result;
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

    public List<Phone> getPhonesByModelId(Long modelId) {
        return getByFieldName(ID_MODEL_FIELDNAME, modelId.toString());
    }
}
