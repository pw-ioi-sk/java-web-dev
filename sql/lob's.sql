CREATE TABLE product_image (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    image LONGBLOB
);

CREATE TABLE article (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200),
    content LONGTEXT
);

USE product_db;
SELECT * FROM product_image;
delete from product_image where id >= 1 ;

USE company;
SELECT * FROM article;
delete from article where id >= 1;