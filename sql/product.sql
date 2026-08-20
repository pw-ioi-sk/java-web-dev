CREATE DATABASE product_db;

USE product_db;

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

INSERT INTO product (name, price) VALUES
('Laptop', 65000.00),
('Smartphone', 25000.00),
('Keyboard', 1200.00),
('Mouse', 800.00),
('Monitor', 15000.00),
('Printer', 8500.00),
('Headphones', 2200.00),
('Webcam', 3200.00),
('USB Flash Drive', 750.00),
('External Hard Drive', 5500.00),
('Gaming Chair', 12500.00),
('Bluetooth Speaker', 3500.00);

SELECT * FROM product;

SELECT COUNT(*) FROM product;

call showAll();

delete from product_image where id > 4;

select * from product_image;

drop table student;

select * from student;

INSERT INTO student (name, branch) VALUES
('Rahul', 'CSE'),
('Amit', 'CSE'),
('Priya', 'IT'),
('Sneha', 'IT'),
('Rohan', 'ECE'),
('Ananya', 'ECE'),
('Vikas', 'CSE-AI'),
('Neha', 'CSE-AI'),
('Arjun', 'ME'),
('Kavya', 'CSE'),
('Ravi', 'IT'),
('Pooja', 'ECE'),
('Karan', 'CSE-AI'),
('Simran', 'CSE'),
('Aditya', 'ME'),
('Isha', 'IT'),
('Manish', 'ECE'),
('Nisha', 'CSE-AI'),
('Varun', 'CSE'),
('Shreya', 'IT');
