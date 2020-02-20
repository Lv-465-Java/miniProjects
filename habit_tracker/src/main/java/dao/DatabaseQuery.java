package dao;

import util.JdbcUtils;

import java.sql.Connection;

public class DatabaseQuery  {
    private final Connection connection;
    private static final String create_db="create database habit_tracker";
    private static final String create_table_user="create table user(\n" +
            "id integer auto_increment primary key,\n" +
            "name varchar(20) not null,\n" +
            "login varchar(40) unique not null,\n" +
            "password varchar(255) not null);";
    private static final String create_table_habit="create table habit(\n" +
            "id integer auto_increment primary key,\n" +
            "name varchar(40) not null);";
    private static final String create_table_users_habit="create table users_habit(\n" +
            "id integer auto_increment primary key,\n" +
            "user_id integer,\n" +
            "habit_id integer,\n" +
            "description varchar(255),\n" +
            "foreign key (user_id) references user(id) on delete cascade,\n" +
            "foreign key (habit_id) references habit(id));";
    private static final String create_table_habit_strike="create table habit_strike(\n" +
            "id integer auto_increment primary key,\n" +
            "users_habit_id integer,\n" +
            "do_date date,\n" +
            "foreign key (users_habit_id) references users_habit(id) on delete cascade);";

    public DatabaseQuery(Connection connection) {
        this.connection = connection;
    }

    public int create_db(){
        try {
            return JdbcUtils.update(connection, create_db);
        }
        catch (Exception a){return 0;}
     }
    public int create_table_user(){
        try{
        return JdbcUtils.update(connection,create_table_user);
    }
        catch (Exception a){return 0;}
    }
    public int create_table_habit(){
        try{
        return JdbcUtils.update(connection,create_table_habit);
    }
        catch (Exception a){return 0;}
    }
    public int create_table_users_habit(){
        try{
        return JdbcUtils.update(connection,create_table_users_habit);
        }
        catch (Exception a){return 0;}
    }
    public boolean create_everything(){
        if(create_db()!=0 && create_table_user()!=0 && create_table_habit()!=0
        && create_table_users_habit()!=0){
            return true;
        }else return false;
    }

}
