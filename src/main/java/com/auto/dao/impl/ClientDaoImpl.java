package com.auto.dao.impl;

import com.auto.model.Client;

public class ClientDaoImpl extends CrudDaoImpl<Client> {
    @Override
    protected String[] getFields(Client entity) {
        String[] fields = new String[2];
        fields[0] = entity.getName();
        fields[1] = entity.getTel().toString();
        return fields;
    }

    @Override
    protected String[] getUpdateFields(Client entity) {
        String[] result = new String[3];
        result[0] = entity.getName();
        result[1] = entity.getTel().toString();
        result[2] = entity.getId().toString();
        return result;
    }

    @Override
    protected Client createInstance(String[] strings) {
        return new Client(
                Integer.parseInt(strings[0] == null ? "0" : strings[0]),
                strings[1] == null ? new String() : strings[1],
                Integer.parseInt(strings[2] == null ? "0" : strings[2])
        );
    }

    @Override
    protected String createQuery() {
        return "insert into clients ( name , tel) values ( ? , ?);";
    }

    @Override
    protected String getAllQuery() {
        return "Select * from clients";
    }

    @Override
    protected String deleteQuery() {
        return "delete from clients where id = ?;";
    }

    @Override
    protected String updateQuery(Client entity) {
        return null;
    }

    @Override
    protected String getByIdQuery() {
        return "select * from clients where id = ?";
    }

    @Override
    protected String getIdQuery() {
        return "Select id from clients order by id desc limit 1;";
    }

    @Override
    protected String getByFieldQuery(String field) {
        return null;
    }
}
