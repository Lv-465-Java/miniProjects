package dao.impl;

import entity.Rate;
import entity.Rate.RateQueries;

public class RateDaoImpl extends DaoCRUDAbsImpl<Rate> {

    public RateDaoImpl() {
        super();
        init();
    }

    protected void init() {
        for (RateQueries rateQueries : RateQueries.values()) {
            sqlQueries.put(rateQueries.getSqlQuery(), rateQueries);
        }
    }

    protected Rate createInstance(String[] args) {
        return new Rate(
                Long.parseLong(args[0] == null ? "0" : args[0]),
                Integer.parseInt(args[1]==null ? "0" : args[1]),
                Long.parseLong(args[2]==null ? "0" : args[2]),
                Long.parseLong(args[3]==null ? "0" : args[3])
        );
    }

    protected String[] getUpdateFields(Rate rate) {
        String[] result = new String[3];
        String[] allFields = getFields(rate);

        result[0] = allFields[0]; // value
        result[1] = allFields[1]; // placeId
        result[2] = rate.getId().toString(); // Id

        return result;
    }

    protected String[] getFields(Rate rate) {

        String[] fields = new String[3];

        fields[0] = String.valueOf(rate.getValue());
        fields[1] = String.valueOf(rate.getPlaceId());
        fields[2] = String.valueOf(rate.getUserId());

        return fields;
    }
}
