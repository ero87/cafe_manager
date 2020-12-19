drop database cafe_manager;

create database cafe_manager;

use cafe_manager;

create table role(
    role_id integer primary key auto_increment,
    name varchar(50) not null
);

create table user (
    user_id integer primary key auto_increment,
    name varchar(50) not null,
    role_id integer not null,
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

create table product(
    product_id integer primary key auto_increment,
    name varchar(50) not null,
    price decimal(6,3) not null
);

create table status(
    status_id integer primary key auto_increment,
    name varchar(50) not null
);

create table tab
(
    tab_id integer primary key auto_increment,
    user_id integer not null,
    status_id integer not null,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (status_id) REFERENCES status(status_id)
);

create table order_ (
    order_id integer primary key auto_increment,
    tab_id integer not null,
    status_id integer not null,
    FOREIGN KEY (tab_id) REFERENCES tab(tab_id),
    FOREIGN KEY (status_id) REFERENCES status(status_id)
);

create table productInOrder(
    productInOrder_id integer primary key auto_increment,
    order_id integer not null,
    product_id integer not null,
    status_id integer not null,
    count integer not null,
    FOREIGN KEY (order_id) REFERENCES order_(order_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id),
    FOREIGN KEY (status_id) REFERENCES status(status_id)
);

select tab.user_id, count(*)from tab
where  tab.status_id = 1 group by tab.user_id;
