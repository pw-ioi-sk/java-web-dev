CREATE DATABASE IF NOT EXISTS company;
USE company;

CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    joining_date DATE,
    joining_time TIME,
    created_at DATETIME
);

INSERT INTO employee
(name, joining_date, joining_time, created_at)
VALUES
('Rahul', '2023-01-15', '09:30:00', '2023-01-15 09:30:00'),
('Priya', '2023-04-20', '10:15:00', '2023-04-20 10:15:00'),
('Amit', '2024-02-10', '09:45:00', '2024-02-10 09:45:00'),
('Sneha', '2024-06-25', '11:00:00', '2024-06-25 11:00:00'),
('Rohan', '2025-01-05', '08:30:00', '2025-01-05 08:30:00'),
('Ananya', '2025-05-18', '10:30:00', '2025-05-18 10:30:00'),
('Vikram', '2026-01-12', '09:00:00', '2026-01-12 09:00:00'),
('Neha', '2026-07-20', '10:45:00', '2026-07-20 10:45:00');

ALTER TABLE employee
ADD COLUMN last_updated TIMESTAMP;

SELECT * FROM employee;

SELECT name, joining_date
FROM employee;

SELECT name, joining_time
FROM employee;

SELECT name, created_at
FROM employee;

SELECT *
FROM employee
WHERE joining_date > '2024-01-01';

SELECT *
FROM employee
WHERE joining_date
BETWEEN '2024-01-01' AND '2025-12-31';

SELECT name, joining_date,
       DATE_ADD(joining_date, INTERVAL 30 DAY) AS after_30_days
FROM employee;

SELECT name, joining_date,
       DATE_SUB(joining_date, INTERVAL 30 DAY) AS before_30_days
FROM employee;

SELECT name,
       joining_date,
       DATEDIFF(CURRENT_DATE(), joining_date) AS days_since_joining
FROM employee;

SELECT CURRENT_DATE();

SELECT NOW();