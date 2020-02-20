package com.auto.dao.impl;

import com.auto.model.Check;
import com.auto.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckDaoImpl extends CrudDaoImpl<Check> {

    @Override
    protected String[] getFields(Check entity) {
        String [] fields = new String[3];
        fields[0] = entity.getIdCar().toString();
        fields[1] = entity.getIdClient().toString();
        fields[2] = entity.getDate();
        return fields;
    }

    @Override
    protected String[] getUpdateFields(Check entity) {
        String[] result = new String[2];
        result[0] = entity.getDate();
        result[1] = entity.getId().toString();
        return result;
    }

    @Override
    protected Check createInstance(String[] strings) {
        return new Check(
                Integer.parseInt(strings[0] == null ? "0" : strings[0]),
                Integer.parseInt(strings[1] == null ? "0" : strings[1]),
                Integer.parseInt(strings[2] == null ? "0" : strings[2]),
                strings[3] == null ? new String() : strings[3]
        );
    }

    @Override
    protected String createQuery() {
        return "insert into checks ( car_id , client_id, date_of_beginning) values ( ? , ? , ?);";
    }

    @Override
    protected String getAllQuery() {
        return "SELECT * FROM checks;";
    }

    @Override
    protected String deleteQuery() {
        return "delete from checks where id = ?;";
    }

    @Override
    protected String updateQuery(Check entity) {
        return "UPDATE checks SET  date_of_beginning=? WHERE id=?;";
    }

    @Override
    protected String getByIdQuery() {
        return "Select id ,car_id , client_id, date_of_beginning from checks where id = %s;";
    }

    @Override
    protected String getIdQuery() {
        return "Select id from checks where id = %s;";
    }
    public String getCarId(){
        return "Select car_id from checks where id = %s;";
    }
    public String getClientId(){
        return "Select client_id from checks where id = %s";
    }

    @Override
    public String getByFieldQuery(String field){
        return "Select * from checks where date_of_beginning like '%" + field + "%';";
    }


    public Integer getId(Integer id,String query) throws SQLException {
        Integer key = null;
        ResultSet resultSet ;
        PreparedStatement statement = null;
        Connection connection = ConnectionManager.getInstance().getConnection();
        if(query == getCarId()) {
             statement = connection.prepareStatement(String.format(getClientId(), id));
        }
        else {
            statement = connection.prepareStatement(String.format(getCarId(),id));
        }
         resultSet = statement.executeQuery();
        if (resultSet.next()) {
            key = (int) resultSet.getLong(1);
        }
        return key;
    }
}
