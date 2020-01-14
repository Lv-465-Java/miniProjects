CREATE TABLE users(
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      first_name VARCHAR(50) NOT NULL,
                      last_name VARCHAR(50) NOT NULL,
                      username VARCHAR(50) NOT NULL,
                      email VARCHAR(50) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      role VARCHAR(10),
                      PRIMARY KEY (id)
);

CREATE TABLE places(
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       country VARCHAR(50) NOT NULL,
                       town VARCHAR(50) NOT NULL,
                       name VARCHAR(255) NOT NULL,
                       description TEXT NOT NULL,
                       photo VARCHAR(255),
                       price INT NOT NULL default 200,
                       PRIMARY KEY (id)
);


CREATE TABLE comments(
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         text_of_comment VARCHAR(255) NOT NULL,
                         date_of_comment TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
                         user_id BIGINT NOT NULL,
                         place_id BIGINT NOT NULL,
                         PRIMARY KEY (id),
                         FOREIGN KEY (user_id) REFERENCES users (id) on delete cascade ,
                         FOREIGN KEY (place_id) REFERENCES places (id)
);


CREATE TABLE trips(
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      departure_day DATE,
                      day_of_arrival DATE,
                      count_of_people INT NOT NULL,
                      access BOOLEAN,
                      transport_id BIGINT NOT NULL,
                      user_id BIGINT NOT NULL,
                      PRIMARY KEY (id),
                      FOREIGN KEY (user_id) REFERENCES users (id) on delete cascade ,
                      FOREIGN KEY (transport_id) REFERENCES transports (id)
);


CREATE TABLE rates(
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      value TINYINT ,
                      user_id BIGINT NOT NULL,
                      place_id BIGINT NOT NULL,
                      PRIMARY KEY (id),
                      FOREIGN KEY (user_id) REFERENCES users (id) on delete cascade ,
                      FOREIGN KEY (place_id) REFERENCES places (id)
);



CREATE TABLE transports(
                           id BIGINT NOT NULL AUTO_INCREMENT,
                           name VARCHAR(45) NOT NULL,
                           PRIMARY KEY (id)
);

CREATE TABLE trips_has_places(
                                 trip_id BIGINT NOT NULL,
                                 place_id BIGINT NOT NULL,
                                 PRIMARY KEY (trip_id, place_id),
                                 FOREIGN KEY (trip_id) REFERENCES trips (id) on delete cascade ,
                                 FOREIGN KEY (place_id) REFERENCES places (id)
);

CREATE TABLE posters(
    user_id BIGINT NOT NULL,
    path VARCHAR(255) NULL ,
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES users (id) on delete cascade
);
