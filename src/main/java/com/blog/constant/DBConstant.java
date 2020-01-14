package com.blog.constant;

public class DBConstant {

    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "root";
    public static final String DB_NAME = "blog";
    public static final String URL = "jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/blog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";



    public static final String CREATE_DB = "create database if not exists " + DB_NAME + ";";
    public static final String USE_DB = "use " + DB_NAME + ";";

    public static final String CREATE_TABLE_ROLES = "create table roles(\n" +
            "id int unique not null auto_increment,\n" +
            "name varchar(25) not null,\n" +
            "primary key(id)\n" +
            ");";

    public static final String CREATE_TABLE_USERS = "create table users (\n" +
            "id int not null unique auto_increment,\n" +
            "username varchar(50) not null unique,\n" +
            "password varchar(256) not null,\n" +
            "firstName varchar(50) not null,\n" +
            "lastName varchar(50) not null,\n" +
            "role_id int not null,\n" +
            "primary key(id),\n" +
            "foreign key (role_id) references roles(id)\n" +
            ");\n";

    public static final String CREATE_TABLE_CATEGORIES = "create table categories (\n" +
            "id int not null unique auto_increment,\n" +
            "name varchar(25) not null unique,\n" +
            "primary key(id)\n" +
            ");";

    public static final String CREATE_TABLE_POSTS = "create table posts (\n" +
            "id int not null unique auto_increment,\n" +
            "title varchar(256),\n" +
            "content text,\n" +
            "imgPath varchar(256),\n" +
            "created_date datetime,\n" +
            "updated_date datetime,\n" +
            "user_id int,\n" +
            "category_id int,\n" +
            "primary key(id),\n" +
            "foreign key (user_id) references users(id),\n" +
            "foreign key (category_id) references categories(id)\n" +
            ");";

    public static final String INSERT_ROLES = "insert into roles(name) values('ADMIN'), ('USER');";

    public static final String INSERT_ADMIN = "insert into users (username, password, firstName, lastName, role_id) \n" +
            "values('admin', 'admin', 'Admin', 'Admin', 1);";

    public static final String INSERT_CATEGORIES = "insert into categories (name) \n" +
            "values('Travel'), ('Food'), ('Sports'), ('Cars'), ('Other');";



}
