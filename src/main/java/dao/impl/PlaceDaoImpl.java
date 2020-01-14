package dao.impl;

import db.ConnectionManager;
import entity.Place;
import entity.Place.PlaceQueries;
import entity.TripPlace;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceDaoImpl extends DaoCRUDAbsImpl<Place> {

    public PlaceDaoImpl() {
        super();
        init();
    }

    protected void init() {
        for (PlaceQueries placeQueries : PlaceQueries.values()) {
            sqlQueries.put(placeQueries.getSqlQuery(), placeQueries);
        }
    }

    protected Place createInstance(String[] args) {
        return new Place(
                Long.parseLong(args[0] == null ? "0" : args[0]),
                args[1] == null ? "" : args[1],
                args[2] == null ? "" : args[2],
                args[3] == null ? "" : args[3],
                args[4] == null ? "" : args[4],
                args[6]==null ? "" : args[6]
        );
    }

    protected String[] getUpdateFields(Place place) {
        String[] result = new String[6];
        String[] allFields = getFields(place);

        result[0] = allFields[0]; // country
        result[1] = allFields[1]; // town
        result[2] = allFields[2]; // name
        result[3] = allFields[3]; // desc
        result[4] = allFields[4]; // photo
        result[5] = place.getId().toString(); // id
        return result;
    }

    protected String[] getFields(Place place) {

        String[] fields = new String[5];

        fields[0] = place.getCountry();
        fields[1] = place.getTown();
        fields[2] = place.getName();
        fields[3] = place.getDescription();
        fields[4] = place.getPhoto();

        return fields;
    }

    public List<Place> getByTemplate(String template) {
       String query= "SELECT id, country, town, name, description, photo, price FROM places WHERE name LIKE ?  ;";
        List<Place> placeList=new ArrayList<>();
        try {
            PreparedStatement statement = ConnectionManager.getInstance().getConnection().prepareStatement(query);

            statement.setString(1,  '%' +template + '%');

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id= resultSet.getLong("id");
                String country = resultSet.getString("country");
                String town = resultSet.getString("town");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String photo = resultSet.getString("photo");
                Integer price = resultSet.getInt("price");

                Place place = new Place(id,country,town,name,description,photo);
                placeList.add(place);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return placeList;
    }
}
