package com.blog.db;

import com.blog.constant.DBConstant;

import java.sql.*;

public final class DataSourceRepository {

    private final static String FAILED_JDBC_DRIVER = "Failed to Create JDBC Driver";

    private DataSourceRepository() {
    }

    public static DataSource getDefault() {
        return getMySqlLocalHost();
    }

    public static DataSource getMySqlLocalHost() {
        Driver sqlDriver;
        try {
            sqlDriver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {
            throw new RuntimeException(FAILED_JDBC_DRIVER);
        }
        return new DataSource(sqlDriver,
                DBConstant.DB_URL, DBConstant.DB_USERNAME, DBConstant.DB_PASSWORD);
    }

    public static boolean checkDBExist(){
        boolean exist = false;
        try{
            Connection conn= DriverManager.getConnection(DBConstant.URL, DBConstant.DB_USERNAME, DBConstant.DB_PASSWORD);
            ResultSet resultSet = conn.getMetaData().getCatalogs();
            //iterate each catalog in the ResultSet
            while (resultSet.next()) {
                // Get the database name, which is at position 1
                String databaseName = resultSet.getString(1);
                if(DBConstant.DB_NAME.equalsIgnoreCase(databaseName)){
                    exist = true;
                }
            }
            resultSet.close();

        }
        catch(SQLException e){
            System.out.print(FAILED_JDBC_DRIVER +e);
        }
        return exist;
    }

    public static void createTables(){
        try {
            Connection conn=DriverManager.getConnection(DBConstant.URL, DBConstant.DB_USERNAME, DBConstant.DB_PASSWORD);
            Statement st=conn.createStatement();
            st.executeUpdate(DBConstant.CREATE_DB);
            st.executeUpdate(DBConstant.USE_DB);
            st.executeUpdate(DBConstant.CREATE_TABLE_ROLES);
            st.executeUpdate(DBConstant.CREATE_TABLE_USERS);
            st.executeUpdate(DBConstant.CREATE_TABLE_CATEGORIES);
            st.executeUpdate(DBConstant.CREATE_TABLE_POSTS);
            st.executeUpdate(DBConstant.INSERT_ROLES);
            st.executeUpdate(DBConstant.INSERT_ADMIN);
            st.executeUpdate(DBConstant.INSERT_CATEGORIES);
            st.close();


        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
