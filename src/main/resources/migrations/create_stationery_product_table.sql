--liquibase formatted sql

--changeset diegosc:1
CREATE TABLE StationeryProduct (
    id INT NOT NULL auto_increment PRIMARY KEY,
    barcode VARCHAR(30),
    name VARCHAR(30),
    description VARCHAR(80),
    quantity INT,
    category VARCHAR(30)
);
