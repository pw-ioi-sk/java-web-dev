CREATE DATABASE bank_db;

USE bank_db;

CREATE TABLE account (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    balance DECIMAL(10,2)
);

INSERT INTO account VALUES
(1, 'Alice', 5000),
(2, 'Bob', 3000);

select * from account;