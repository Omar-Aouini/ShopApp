CREATE DATABASE shop;

USE shop;


CREATE TABLE category
(
	category_name varchar(100) primary key not null,
    category_description varchar(5000)
);


CREATE TABLE product
(
	productid int primary key auto_increment not null,
    product_name varchar(100) not null,
    product_description varchar(5000),
    product_rate int(1),
    product_price double not null,
    product_quantity int not null,
    product_category_name varchar(100),
    product_image varchar(5000),
    foreign key (product_category_name) references category(category_name)
);


create table userRoles
(
	user_role_id int(11) primary key not null auto_increment,
    userid int(11),
    authority varchar(100) not null
);


create table user
(
	user_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_name varchar(45) NOT NULL,
	user_phone_number int NOT NULL,
	user_email varchar(45) NOT NULL,
	user_password varchar(45) NOT NULL,
	user_address varchar(45) NOT NULL,
	user_city varchar(45) NOT NULL,
	user_country varchar(45) NOT NULL,
	user_postalcode int NOT NULL,
	roleid int(11),
	enabled boolean NOT NULL,
	foreign key (roleid) references userRoles(user_role_id)

);


CREATE TABLE review
(
  review_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  review_content varchar(5000) DEFAULT NULL,
  userid int,
  productid int,
  foreign key (userid) references user(user_id),
  foreign key (productid) references product(productid)
);


CREATE TABLE payment
(
  Payment_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  payment_details varchar(100) NOT NULL,
  userid int,
  payment_method varchar(100) NOT NULL,
  card_type varchar(100) DEFAULT NULL,
  foreign key(userid) references user(user_id)
);


