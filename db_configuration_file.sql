/*Creating a database*/
CREATE DATABASE IF NOT EXISTS CRM;
USE CRM;

/*Creating a database user*/
CREATE USER IF NOT EXISTS 'ClubRickyMartin'@'localhost' IDENTIFIED BY 'ClubRickyMartin123';
GRANT ALL PRIVILEGES ON *.* TO 'ClubRickyMartin'@'localhost';
FLUSH PRIVILEGES;

