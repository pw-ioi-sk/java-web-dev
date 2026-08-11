DELIMITER $$
create procedure showAll()
begin
	select * from product;
    select * from product;
end$$
DELIMITER ;

DELIMITER $$
create procedure showAll2()
begin
	select * from product;
    select * from product;
end$$
DELIMITER ;

call showAll2();

DELIMITER $$
create procedure showAll1()
begin
	select * from product;
end$$
DELIMITER ;

call showAll1();

DELIMITER //
create procedure getByName(IN p_name varchar(255))
begin
	select *
    from product
    where name = p_name;
end//
DELIMITER ;

call getByName('Laptop');

DELIMITER $$
create procedure showAll2()
begin
	select * from product;
    select * from product;
end$$
DELIMITER ;
call showAll2();

drop procedure if exists showAll;
drop procedure if exists showAll2;
drop procedure if exists getById;
SHOW CREATE PROCEDURE showAll;

DELIMITER $$
create procedure getById(IN p_id INT)
begin
	select *
    from product
    where product.id = p_id;
end$$
DELIMITER ;

call getById(1);

DELIMITER $$

CREATE PROCEDURE CountProducts(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total
    FROM product;
END $$

DELIMITER ;

CALL CountProducts(@total);
select @total

DELIMITER //

CREATE PROCEDURE getPrice(IN p_id INT, OUT p_price DECIMAL(10,2))
BEGIN
    SELECT price
    INTO p_price
    FROM product
    WHERE id = p_id;
END//

DELIMITER ;

DELIMITER //

call getPrice(1, @price);
select @price;

CREATE PROCEDURE increaseValue(INOUT p_price DECIMAL(10,2))
BEGIN
    SET p_price = p_price * 2;
END//

DELIMITER ;

drop procedure if exists increasevalue;

SET @price = 100;
call increasevalue(@price);
select @price