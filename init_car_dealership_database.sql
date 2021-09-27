DROP DATABASE IF EXISTS carDealer;
CREATE DATABASE carDealer;

USE carDealer;

CREATE TABLE cars(
    id INT PRIMARY KEY AUTO_INCREMENT,
    newCar int(1) NOT NULL,
    carName VARCHAR(30) NOT NULL,
    make VARCHAR(30) NOT NULL,
    model VARCHAR(30) NOT NULL,
    carType VARCHAR(30) NOT NULL,
    bodyStyle VARCHAR(50) NOT NULL,
    makeYear int(4) NOT NULL,
    trans VARCHAR(10) NOT NULL,
    color VARCHAR(20) NOT NULL,
    interiorColor VARCHAR(20) NOT NULL,
    mileage int NOT NULL,
    vinNumber VARCHAR(20) NOT NULL,
    salesPrice double NOT NULL,
    msrp double NOT NULL,
    carDescription VARCHAR(200),
    pictureURL VARCHAR(200)
);


CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    email VARCHAR(60) NOT NULL,
    userPassword VARCHAR(20) NOT NULL,
    userRole VARCHAR(20) NOT NULL
);


CREATE TABLE inquire(
    id INT PRIMARY KEY AUTO_INCREMENT,
    inquireName VARCHAR(60) NOT NULL,
    email VARCHAR(30) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    message VARCHAR(200) NOT NULL
);

CREATE TABLE specials(
	id INT PRIMARY KEY AUTO_INCREMENT,
	carId INT NOT NULL,
    message VARCHAR(500) NOT NULL,
    FOREIGN KEY (carId) REFERENCES cars(id)
    
);