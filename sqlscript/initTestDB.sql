create schema placesdb;
use placesdb;

CREATE TABLE IF NOT EXISTS `OPINIONS` (
  `id` INT NOT NULL,
  `comment` VARCHAR(45) NULL DEFAULT NULL,
  `rate` DOUBLE NULL DEFAULT NULL,
  `places_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `PLACES` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `localisation` VARCHAR(45) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `openinghours` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
DELETE from placesdb.places where id = 3;

INSERT INTO placesdb.places values(0,'zoo', 'krakow ulica fajna', '535091636', '10-18');
INSERT INTO placesdb.places values(1,'burger restaurant', 'poznan ulica gowniana', '666999000', '12-20');
INSERT INTO placesdb.places values(3,'hotdog restaurant', 'wroclaw wyspa slodowa', '123987456', '12-20');