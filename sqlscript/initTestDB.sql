create schema placesdb;
use placesdb;

CREATE TABLE IF NOT EXISTS `OPINIONS` (
  `id` INT NOT NULL,
  `comment` VARCHAR(255) NULL DEFAULT NULL,
  `rate` DOUBLE NULL DEFAULT NULL,
  `places_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `PLACES` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `localisation` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  `openinghours` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
DELETE from placesdb.places where id = 3;

INSERT INTO placesdb.places values(1,'Zoo', 'ul.zoo, Cracow', '535091636', '10-18');
INSERT INTO placesdb.places values(2,'Burger Restaurant', 'ul.fajna, Poznan', '666999000', '12-20');
INSERT INTO placesdb.places values(3,'Hotdog Foodtruck', 'Wyspa Slodowa, Wroclaw', '123987456', '12-20');