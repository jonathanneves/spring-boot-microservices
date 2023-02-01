create schema if not exists microservices;

create table if not exists microservices.product
(
    id          int auto_increment primary key,
    name        varchar(255) null,
    description varchar(255) null,
    price decimal(10,2) null
) AUTO_INCREMENT = 1;
