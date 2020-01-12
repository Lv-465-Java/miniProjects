package service.impl;


import db.ConnectionManager;
import db.DataSource;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBInitializerService {

    private static boolean first=false;//////////////=true;

    private DBInitializerService() {
    }

    public static boolean isFirst() {
        return first;
    }

    public static void setFirst(boolean first) {
        DBInitializerService.first = first;
    }

    public static void getInstance() {
       try {
        Driver sqlDr= new com.mysql.cj.jdbc.Driver();
        String mySqlUrl="jdbc:mysql://localhost:3306/";
           Connection con=ConnectionManager
                   .getInstance(new DataSource(sqlDr,mySqlUrl,"maryana", "Maryana1234!"))
                   .getConnection();

//            Connection con = DriverManager.getConnection(mySqlUrl, "maryana", "Maryana1234!");

        ScriptRunner sr=new ScriptRunner(con);
        Reader reader=new BufferedReader(new FileReader("/resources/sql/create_db.sql"));
        Reader reader2=new BufferedReader(new FileReader("/resources/sql/create_tables.sql"));
        Reader reader3=new BufferedReader(new FileReader("/resources/sql/insert_table.sql"));
        sr.runScript(reader);
        sr.runScript(reader2);
        sr.runScript(reader3);
       }catch (SQLException | FileNotFoundException e){
           e.printStackTrace();
       }

        setFirst(false);
    }
}
