# First evolution

# --- !Ups

CREATE TABLE players_player (
    id INT(11) AUTO_INCREMENT NOT NULL,
    name VARCHAR(32) NOT NULL,
    club_id INT(11) NOT NULL,
    height DECIMAL(10, 3) NOT NULL,
    weight DECIMAL(10, 3) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    primary key(id),
    foreign key (club_id) references clubs_club(id)
);

CREATE TABLE players_playersport (
    id INT(11) AUTO_INCREMENT NOT NULL,
    player_id INT(11) NOT NULL,
    sport_id INT(11) NOT NULL,
    weight_class_id INT(11) NOT NULL,
    sport_skill_id INT(11) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    primary key (id),
    foreign key (player_id) references players_player(id),
    foreign key (sport_id) references sports_sport(id),
    foreign key (weight_class_id) references sports_sportweightcategory(id),
    foreign key (sport_skill_id) references sports_sportskill(id)
);

# --- !Downs

DROP TABLE IF EXISTS players_playersport;

DROP TABLE IF EXISTS players_player;