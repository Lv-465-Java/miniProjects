package com.auto.dao.impl;

import com.auto.model.Car;

public class CarDaoImpl extends CrudDaoImpl<Car> {

    @Override
    protected Car createInstance(String [] strings) {
        return new Car(
                Integer.parseInt(strings[0] == null ? "0" : strings[0]),
                strings[1] == null ? new String() : strings[1],
                strings[2] == null ? new String() : strings[2],
                strings[3] == null ? new String() : strings[3],
                strings[4] == null ? new String() : strings[4],
                Integer.parseInt(strings[5] == null ? "0" : strings[5])
        );
    }

    @Override
    public String[] getFields(Car car) {
    String[] fields =new String [5];
        fields[0] = car.getBrand();
        fields[1] = car.getModel();
        fields[2] = car.getNumber();
        fields[3] = car.getVinCode();
        fields[4] = car.getYear().toString();
        return fields;
    }
    @Override
    protected String[] getUpdateFields(Car entity) {
        String []  result = new String[6];
        result[0] = entity.getBrand();
        result[1] = entity.getModel();
        result[2] = entity.getNumber();
        result[3] = entity.getVinCode();
        result[4] = entity.getYear().toString();
        result[5] = entity.getId().toString();
        return result;
    }

    @Override
    protected String createQuery() {
        return "insert into cars (brand, model, auto_number, vin_code, made_year) values (? , ? , ? , ? , ?);";
    }

    @Override
    protected String getAllQuery() {
        return "SELECT * FROM cars;";
    }

    @Override
    protected String deleteQuery() {
        return "DELETE FROM cars WHERE id=?;";
    }

    @Override
    protected String updateQuery(Car entity) {
        return "UPDATE cars SET brand=?, model=?, auto_number=?, vin_code=?, made_year=? WHERE id=?;";
    }

    @Override
    protected String getByIdQuery() {
        return "SELECT * FROM cars where id = %s;";
    }

    public String getIdQuery(){
        return "Select id from cars order by id desc limit 1;";
    }

    @Override
    public String getByFieldQuery(String field){
        return "Select * from checks inner join cars on cars.id = checks.car_id where brand like '%"+field+"%'";
    }


}

