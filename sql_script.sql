
DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;
USE human_friends;

DROP TABLE IF EXISTS `human_friends`.`pets`;
CREATE TABLE `human_friends`.`pets` (
  `id` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
 DROP TABLE IF EXISTS `human_friends`.`pack_animals`;
  CREATE TABLE `human_friends`.`pack_animals` (
  `id` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
  
  
  INSERT INTO pets VALUES(1, 'dog'),(2,'cat'),(3,'hamster' ), 
(4, 'dog'),(5,'cat'),(6,'hamster' ),(7, 'dog'),(8,'cat');

SELECT * FROM pets;

INSERT INTO pack_animals VALUES(1, 'horse'),(2,'camel'),(3,'donkey' ), 
(4, 'horse'),(5,'camel'),(6,'donkey' ), (7, 'horse'),(8,'camel');

SELECT * FROM pack_animals;

 DROP TABLE IF EXISTS `human_friends`.`dogs`;
CREATE TABLE `human_friends`.`dogs`(
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `BirthDate` DATE NOT NULL,
  `Commands` VARCHAR(200) NULL,
  FOREIGN KEY (id) REFERENCES pets(id));
  
  DROP TABLE IF EXISTS `human_friends`.`cats`;
  CREATE TABLE `human_friends`.`cats`(
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `BirthDate` DATE NOT NULL,
  `Commands` VARCHAR(200) NULL,
  FOREIGN KEY (id) REFERENCES pets(id));
  
   DROP TABLE IF EXISTS `human_friends`.`hamsters`;
  CREATE TABLE `human_friends`.`hamsters`(
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `BirthDate` DATE NOT NULL,
  `Commands` VARCHAR(200) NULL,
  FOREIGN KEY (id) REFERENCES pets(id));
  
  DROP TABLE IF EXISTS `human_friends`.`horses`;
   CREATE TABLE `human_friends`.`horses`(
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `BirthDate` DATE NOT NULL,
  `Commands` VARCHAR(200) NULL,
  FOREIGN KEY (id) REFERENCES pack_animals(id));
  
  DROP TABLE IF EXISTS `human_friends`.`camels`;
  CREATE TABLE `human_friends`.`camels`(
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `BirthDate` DATE NOT NULL,
  `Commands` VARCHAR(200) NULL,
  FOREIGN KEY (id) REFERENCES pack_animals(id));
  
  DROP TABLE IF EXISTS `human_friends`.`donkeys`;
  CREATE TABLE `human_friends`.`donkeys`(
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `BirthDate` DATE NOT NULL,
  `Commands` VARCHAR(200) NULL,
  FOREIGN KEY (id) REFERENCES pack_animals(id));
  
  INSERT INTO dogs VALUES(1,'Fido', '2020-01-01', 'Sit, Stay, Fetch'),
(4,'Buddy', '2018-12-10', 'Sit, Paw, Bark'),
(7,'Bella', '2023-11-11', 'Sit, Stay Roll');
  
 INSERT INTO cats VALUES(2,'Whiskers','2022-05-15', 'Sit, Pounce'), 
 (5,'Smudge','2021-02-20', 'Sit, Pounce, Scratch'),
 (8,'Oliver','2021-06-30', 'Meow, Scratch, Jump');
  
  INSERT INTO hamsters VALUES(3,'Hammy', '2021-03-10', 'Roll, Hide'),
  (6,'Peanut','2021-08-01', 'Roll, Spin');
  
  INSERT INTO horses VALUES(1,'Thunder','2015-07-21','Trot, Canter, Gallop'),
  (4,'Storm', '2014-05-05', 'Trot, Canter'),
  (7,'Blaze', '2016-02-29', 'Trot, Jump, Gallop');
  
  INSERT INTO camels VALUES(2,'Sandy','2016-11-03',' Walk, Carry, Load'),
  (5,'Dune', '2018-12-12',' Walk, Sit'),
  (8,'Sahara','2015-08-14', 'Walk, Run');
  
  INSERT INTO donkeys VALUES(3,'Eeyore', '2017-09-18', 'Walk, Carry, Bray'),
  (6,'Burro', '2019-01-23', 'Walk, Bray, Kick');
  
  DROP TABLE camels;  
  DELETE FROM pack_animals WHERE type = 'camel';
  
  DROP TABLE IF EXISTS `human_friends`.`horses_donkeys`;
 CREATE TABLE `human_friends`.`horses_donkeys` 
(SELECT *
FROM horses
UNION SELECT *
FROM donkeys);

SELECT * FROM horses_donkeys;

DROP TABLE IF EXISTS `human_friends`.`young_animals`;
CREATE TABLE `human_friends`.`young_animals`
(SELECT id, Name, 
BirthDate, 
Commands, 
TRUNCATE(((DATEDIFF( DATE(NOW()),
BirthDate))/365), 1) AS age 
FROM  dogs 
WHERE (DATEDIFF( DATE(NOW()),BirthDate))/365 < 3 AND  (DATEDIFF(DATE(NOW()),BirthDate))/365 >1
UNION 
SELECT id, Name, BirthDate, 
Commands, 
TRUNCATE(((DATEDIFF( DATE(NOW()),BirthDate))/365), 1) AS age 
FROM  donkeys 
WHERE (DATEDIFF(DATE(NOW()),BirthDate))/365 < 3 AND  (DATEDIFF( DATE(NOW()),BirthDate))/365 >1
UNION 
SELECT id, Name, BirthDate, 
Commands, 
TRUNCATE(((DATEDIFF( date(NOW()),BirthDate))/365), 1) AS age 
FROM  horses 
WHERE (DATEDIFF( DATE(NOW()),BirthDate))/365 < 3 AND (DATEDIFF( DATE(NOW()),BirthDate))/365 >1
UNION 
SELECT id, Name, BirthDate, Commands, TRUNCATE(((DATEDIFF( DATE(NOW()),BirthDate))/365), 1) AS age 
FROM  cats 
WHERE (DATEDIFF( DATE(NOW()),BirthDate))/365 < 3 AND  (DATEDIFF(DATE(NOW()),BirthDate))/365 >1
UNION 
SELECT id, Name, BirthDate, 
Commands, 
TRUNCATE(((DATEDIFF( DATE(NOW()),BirthDate))/365), 1) AS age 
FROM  hamsters 
WHERE (DATEDIFF(DATE(NOW()),BirthDate))/365 < 3 AND  (DATEDIFF(DATE(NOW()),BirthDate))/365 >1)
ORDER BY age; 

SELECT * FROM young_animals;

-- первый вариант

ALTER TABLE horses ADD table_source NVARCHAR(50) NOT NULL DEFAULT 'horses';
ALTER TABLE donkeys ADD table_source NVARCHAR(50) NOT NULL DEFAULT 'donkeys';
ALTER TABLE cats ADD table_source NVARCHAR(50) NOT NULL DEFAULT 'cats';
ALTER TABLE dogs ADD table_source NVARCHAR(50) NOT NULL DEFAULT 'dogs';
ALTER TABLE hamsters ADD table_source NVARCHAR(50) NOT NULL DEFAULT 'hamsters';
ALTER TABLE young_animals ADD table_source NVARCHAR(50) NOT NULL DEFAULT 'young_animals';
ALTER TABLE young_animals DROP COLUMN age;

DROP TABLE IF EXISTS `human_friends`.'all_human_friends';
CREATE TABLE `human_friends`.'all_human_friends';
(SELECT * FROM horses 
UNION 
SELECT * FROM donkeys
UNION
SELECT * FROM dogs
UNION
SELECT * FROM cats
UNION
SELECT * FROM hamsters
UNION
SELECT * FROM young_animals) ORDER BY id;

SELECT * FROM all_human_friends;

-- второй вариант объединения, на всякий случай, потому что непонятно, 
-- что нужно было сделать 

ALTER TABLE pets ADD table_source_1 NVARCHAR(50) NOT NULL DEFAULT 'pets';
ALTER TABLE pack_animals ADD table_source_1 NVARCHAR(50) NOT NULL DEFAULT 'pack_animals';

DROP TABLE IF EXISTS `human_friends`.'human_friends_all';

CREATE TABLE human_friends.human_friends_all
(SELECT c.ID, p.type, p.table_source_1, c.Name, c.BirthDate, 
TRUNCATE(((DATEDIFF(DATE(NOW()),BirthDate))/365), 1) AS age,  
c.Commands,c.table_source FROM
pets p
JOIN human_friends.cats c ON p.ID = c.id
UNION
SELECT h.ID, p.type, p.table_source_1, h.Name, h.BirthDate, 
TRUNCATE(((DATEDIFF(DATE(NOW()),BirthDate))/365), 1) AS age , 
h.Commands, h.table_source FROM
pets p
JOIN hamsters h  ON p.ID = h.id
UNION
SELECT d.ID, p.type, p.table_source_1,d.Name, d.BirthDate, 
TRUNCATE(((DATEDIFF(DATE(NOW()),BirthDate))/365), 1) AS age ,
d.Commands, d.table_source FROM
pets p
JOIN dogs d  ON p.ID = d.id
UNION
SELECT hor.ID, pac.type, pac.table_source_1, hor.Name, hor.BirthDate, 
TRUNCATE(((DATEDIFF(DATE(NOW()),BirthDate))/365), 1) AS age ,
 hor.Commands, hor.table_source FROM
pack_animals pac
JOIN horses hor  ON pac.ID = hor.id
UNION
SELECT don.ID, pac.type, pac.table_source_1, don.Name, don.BirthDate, 
TRUNCATE(((DATEDIFF(DATE(NOW()),BirthDate))/365), 1) AS age ,
don.Commands, don.table_source FROM
pack_animals pac
JOIN donkeys don ON pac.ID = don.id)
ORDER BY id;

SELECT * FROM human_friends_all;
 

 
 
 
 
 
 
 
 
