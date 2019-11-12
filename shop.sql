
 create database shop;
 
 use shop;
 
 
create table product
(
    id int primary key auto_increment,
    name varchar(100),
    type varchar(100),
    price int,
    quantity int,
    img varchar(5000)
);
