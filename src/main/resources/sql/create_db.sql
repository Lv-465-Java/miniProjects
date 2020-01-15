create table producers
(
    id   bigint auto_increment
        primary key,
    name varchar(255) not null,
    constraint name
        unique (name)
);

create table models
(
    id         bigint auto_increment
        primary key,
    name       varchar(255) not null,
    producerId bigint       null,
    constraint models_ibfk_1
        foreign key (producerId) references producers (id)
            on delete cascade
);

create index producerId
    on models (producerId);

create table phones
(
    id             bigint auto_increment
        primary key,
    year           int(4)       not null,
    price          int(4)       not null,
    photo          varchar(255) null,
    color          varchar(255) null,
    screenDiagonal double       null,
    internalMemory int(4)       null,
    modelId        bigint       null,
    constraint phones_ibfk_1
        foreign key (modelId) references models (id)
            on delete cascade
);

create index modelId
    on phones (modelId);

create table users
(
    id       bigint auto_increment
        primary key,
    nickname varchar(255)               not null,
    password varchar(255)               not null,
    email    varchar(255)               null,
    phone    varchar(255)               null,
    role     varchar(30) default 'user' null,
    constraint email
        unique (email),
    constraint nickname
        unique (nickname)
);

create table carts
(
    dateOfBuying timestamp null,
    phoneId      bigint    not null,
    userId       bigint    not null,
    primary key (phoneId, userId),
    constraint carts_ibfk_1
        foreign key (phoneId) references phones (id),
    constraint carts_ibfk_2
        foreign key (userId) references users (id)
);

create index userId
    on carts (userId);

