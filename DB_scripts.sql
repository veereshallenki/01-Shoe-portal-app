--Admin table script
create table admins (id int UNSIGNED NOT NULL AUTO_INCREMENT, primary key(id), user_name  varchar(30), pass_word varchar(30));

create table users(id int UNSIGNED NOT NULL AUTO_INCREMENT, primary key(id), 
fname varchar(30),
lname varchar(30),
address varchar(100),
age int,
email_id varchar(30),
pass_word varchar(30), 
date_added DATE 
 ); 
 
create table item_categories(id int UNSIGNED NOT NULL AUTO_INCREMENT, primary key(id), 
name varchar(30)); 
 
create table products(id int UNSIGNED NOT NULL AUTO_INCREMENT, primary key(id), 
name varchar(30),
price int,
date_added DATE,
category_id int 
); 