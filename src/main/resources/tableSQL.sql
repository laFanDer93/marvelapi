CREATE TABLE marvelapi.characters (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(35),
  description varchar(300),
  thumbnail varchar(100),
  PRIMARY KEY (id)
);

CREATE TABLE marvelapi.comics (
  id int NOT NULL AUTO_INCREMENT,
  title varchar(35),
  description varchar(300),
  thumbnail varchar(100),
  PRIMARY KEY (id)
);

CREATE TABLE marvelapi.characters_comics (
  character_id int NOT NULL,
  comic_id int NOT NULL,
  PRIMARY KEY (character_id, comic_id),
  FOREIGN KEY (character_id) REFERENCES marvelapi.characters(id),
  FOREIGN KEY (comic_id) REFERENCES marvelapi.comics(id));