package dao.impl;

import entity.Transport;
import entity.Transport.TransportQueries;
import entity.TransportName;

public class TransportDaoImpl extends DaoCRUDAbsImpl<Transport> {

    public TransportDaoImpl() {
        super();
        init();
    }

    protected void init() {
        for (TransportQueries transportQueries : TransportQueries.values()) {
            sqlQueries.put(transportQueries.getSqlQuery(), transportQueries);
        }
    }

    protected Transport createInstance(String[] args) {
        return new Transport(
                Long.parseLong(args[0] == null ? "0" : args[0]),
                args[1] == null ? TransportName.BUS : TransportName.valueOf(args[1])
        );
    }

    protected String[] getUpdateFields(Transport transport) {
        String[] result = new String[2];
        String[] allFields = getFields(transport);
        result[0] = allFields[0]; // transportName
        result[1] = transport.getId().toString();

        return result;
    }

    protected String[] getFields(Transport transport) {

        String[] fields = new String[1];
        fields[0] = transport.getTransportName().toString();

        return fields;
    }
}
