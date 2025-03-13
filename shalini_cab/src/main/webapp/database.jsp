 CREATE DATABASE project;

USE project;

USE project;
CREATE TABLE booked_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    pickup_location VARCHAR(100) NOT NULL,
    drop_location VARCHAR(100) NOT NULL,
    cab VARCHAR(20) NOT NULL,
    distance INT NOT NULL
);


USE project;
select * from Customer;

USE project;
select * from booked_details;

CREATE TABLE Customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    mail_id VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    address TEXT NOT NULL,
    nic_number VARCHAR(20) NOT NULL
);

USE project;
select * from drivers;

USE project;
CREATE TABLE admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

INSERT INTO admin (username, password) VALUES ('theadmin', 'adminadmin');

USE project;
select * from admin;
