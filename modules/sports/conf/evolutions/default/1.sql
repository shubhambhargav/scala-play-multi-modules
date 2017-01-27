# First evolution

# --- !Ups

CREATE TABLE sports_sport (
    id INT(11) AUTO_INCREMENT NOT NULL,
    name VARCHAR(32) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,

    primary key (id)
);

CREATE TABLE sports_sportskill (
    id INT(11) AUTO_INCREMENT NOT NULL,
    name VARCHAR(32) NOT NULL,
    sport_id INT(11) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,

    primary key (id),
    foreign key (sport_id) references sports_sport(id)
);

CREATE TABLE sports_sportweightcategory (
    id INT(11) AUTO_INCREMENT NOT NULL,
    name VARCHAR(32) NOT NULL,
    sport_id INT(11) NOT NULL,
    weight_min INT(11) NOT NULL,
    weight_max INT(11) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,

    primary key (id),
    foreign key (sport_id) references sports_sport(id)
);


# --- !Downs

DROP TABLE IF EXISTS sports_sport;

DROP TABLE IF EXISTS sports_sportskill;

DROP TABLE IF EXISTS sports_sportweightcategory;