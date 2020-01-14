create database if not exists to_do_list;
use to_do_list;

create table if not exists users (
	UserID int Not Null auto_increment,
    Name varchar(255) not null unique,
    Password varchar(255) not null unique,
    Primary Key(UserID)
);

create table if not exists statuses(
	StatusID TINYINT Not Null auto_increment,
    Name varchar(60) Not Null unique,
    Primary Key(StatusID)
);

create table if not exists tasks (
	TaskID int Not Null auto_increment ,
    Assignee int Not null,
    Owner int Not Null,
    Description varchar(255) not null,
    CreationDate date not null,
    Deadline Date,
    StatusID TINYINT Not Null,
    Primary Key(TaskID),
    foreign key(Assignee) references users(UserID),
    foreign key(Owner) references users(UserID),
    foreign key(StatusID) references statuses(StatusID),
    CONSTRAINT unique_row UNIQUE (Assignee, Owner, Description, CreationDate)
);

create table if not exists history(
	ID int Not Null auto_increment,
    TaskDescription  varchar(255) not null,
    ModifiedDate date Not Null,
    StatusID TINYINT Not Null,
    UserID int not null,
    Primary Key(ID),
    foreign key(StatusID) references statuses(StatusID),
    foreign key(UserID) references users(UserID),
    CONSTRAINT unique_row UNIQUE (TaskDescription, ModifiedDate, StatusID)
);
