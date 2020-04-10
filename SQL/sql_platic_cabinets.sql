-- create database
CREATE SCHEMA `platiccabinets` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
use platiccabinets;

-- create table user
create table users(
	id int(6) unsigned primary key not null AUTO_INCREMENT,
    name nvarchar(100) not null,
    account nvarchar(100) not null,
    password varchar(100) not null,
    account_bank varchar(150) null,
    address nvarchar(255) not null,
	user_face varchar(200) null,
    email varchar(100) null,
    sex boolean not null,
    birthday date null,
    phone int(12) null,
    role_id int(6) unsigned not null,
    created_date datetime not null,
    modifieddate datetime not null,
    createby int(6) unsigned not null
);

-- create table product
create table love_product(
	id int(6) unsigned primary key not null AUTO_INCREMENT,
    user_id int(6) unsigned not null,
	product_id int(6) unsigned not null,
    id_img int(6) unsigned null,
    created_date datetime null,
    modified_date datetime null,
    create_by int(6) unsigned not null
);

-- create table product
create table cast_product(
	id int(6) unsigned primary key not null AUTO_INCREMENT,
	user_id int(6) unsigned not null,
    status int(6) not null,
    description text null,
	product_id int(6) unsigned not null,
    id_img int(6) unsigned null,
    created_date datetime null,
    modified_date datetime null,
    create_by int(6) unsigned not null
);

-- create table product
create table products(
	id int(6) unsigned primary key not null AUTO_INCREMENT,
    name nvarchar(250) not null,
	description text null,
    img_product varchar(200) not null,
    new_price varchar(100) not null,
    old_price varchar(100) null,
    promotion int(3) null,
    star int(1) null,
    user_id int(6) not null,
    category_id int(6) not null,
    id_img int(6) null,
    created_date datetime null,
    modified_date datetime null,
    create_by int(6) unsigned not null
);




-- create table product
create table categorys(
	id int(6) unsigned primary key not null AUTO_INCREMENT,
    name nvarchar(250) not null,
    created_date datetime null,
    modified_date datetime null,
    create_by int(6) unsigned not null
);

-- create table image_product
create table image_product(
	id int(6) unsigned primary key not null AUTO_INCREMENT,
    img_product_1 varchar(200) not null,
    img_product_2 varchar(200) not null,
    img_product_3 varchar(200) not null,
    img_product_4 varchar(200) not null,
    img_product_5 varchar(200) not null,
    created_date datetime not null,
    modifieddate datetime not null,
    createby int(6) unsigned not null
);

-- create table role
create table roles(
	id int(6)  unsigned primary key not null AUTO_INCREMENT,
    role_name varchar(200) not null,
    created_date datetime not null,
    modifieddate datetime not null,
    createby int(6) unsigned not null
);

-- create table role_function
create table role_function(
	id int(6)  unsigned primary key not null AUTO_INCREMENT,
    function_id int(6) unsigned not null,
    role_id int(6) unsigned not null,
    created_date datetime not null,
    modifieddate datetime not null,
    createby int(6) unsigned not null
);

-- create table function
create table functions(
	function_code int(6)  unsigned primary key not null AUTO_INCREMENT,
    function_name varchar(200) not null,
    created_date datetime not null,
    modifieddate datetime not null,
    createby int(6) unsigned not null
);

-- create table comments
create table comments(
	id int(6) unsigned primary key not null AUTO_INCREMENT,
    title nvarchar(200) not null,
    comment text not null,
    user_id int(6) not null,
    status long null,
    created_date datetime not null,
    modifieddate datetime not null,
    createby int(6) unsigned not null
);