/*Creating a database user*/
CREATE USER 'ClubRickyMartin'@'localhost' IDENTIFIED BY 'ClubRickyMartin123';
GRANT ALL PRIVILEGES ON *.* TO 'ClubRickyMartin'@'localhost';
FLUSH PRIVILEGES;

/*Creating a database*/
CREATE DATABASE CRM;
USE CRM;

