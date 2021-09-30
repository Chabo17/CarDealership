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
    message VARCHAR(500) NOT NULL
);




CREATE TABLE sales_information_record(
	id INT PRIMARY KEY AUTO_INCREMENT,
    s_i_names VARCHAR(50),
    s_i_phone VARCHAR(20),
    s_i_email VARCHAR(50),
    s_i_street_1 VARCHAR(50),
    s_i_street_2 VARCHAR(50),
    s_i_city VARCHAR(20),
    s_i_state VARCHAR(2),
    s_i_zipcode  VARCHAR(10),
    s_r_purchase_price DOUBLE,
    s_r_purchase_type VARCHAR(30),
    user_id INT,
    car_id INT,
	FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (car_id) REFERENCES cars(id)
);


CREATE TABLE model(
	id INT PRIMARY KEY AUTO_INCREMENT,
	model VARCHAR(30)
);


CREATE TABLE make(
	id INT PRIMARY KEY AUTO_INCREMENT,
	make VARCHAR(30)
    );