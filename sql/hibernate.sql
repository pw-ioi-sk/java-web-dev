CREATE DATABASE hibernate_db;

USE hibernate_db;

CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    branch VARCHAR(50)
);

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

select * from student;