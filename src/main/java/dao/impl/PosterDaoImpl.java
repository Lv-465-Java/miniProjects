package dao.impl;

import entity.Poster;

public class PosterDaoImpl extends DaoCRUDAbsImpl<Poster>  {

    public PosterDaoImpl() {
        super();
        init();
    }

    protected void init() {
        for (Poster.PosterQueries posterQueries : Poster.PosterQueries.values()) {
            sqlQueries.put(posterQueries.getSqlQuery(), posterQueries);
        }
    }

    protected Poster createInstance(String[] args) {
        return new Poster(
                Long.parseLong(args[0] == null ? "0" : args[0]),
                args[1] == null ? "" : args[1]
        );

    }
        @Override
    protected String[] getFields(Poster poster) {
            String[] fields = new String[2];

            fields[0] = poster.getUserId().toString();
            fields[1] = poster.getPath();

            return fields;
    }

    @Override
    protected String[] getUpdateFields(Poster poster) {
        String[] result = new String[1];
        String[] allFields = getFields(poster);
        result[0] = allFields[1];
        result[1] = poster.getUserId().toString();

        return result;
    }
}
