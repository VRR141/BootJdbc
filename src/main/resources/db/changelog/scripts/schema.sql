CREATE TABLE IF NOT EXISTS CUSTOMERS
(
    id           bigserial primary key,
    name         varchar,
    surname      varchar,
    age          int,
    phone_number varchar
);

CREATE TABLE IF NOT EXISTS ORDERS
(
    id           bigserial primary key,
    date         date,
    customer_id  bigint references CUSTOMERS (id),
    product_name varchar,
    amount       int
);

INSERT INTO CUSTOMERS(name, surname, age, phone_number)
VALUES ('name 1', 'surname 1', 25, '03'),
       ('name 2', 'surname 2', 24, '02');


INSERT INTO ORDERS(date, customer_id, product_name, amount)
VALUES (now(), 1, 'prod 1', 3),
       ('1991-01-08', 2, 'prod 2', 2);