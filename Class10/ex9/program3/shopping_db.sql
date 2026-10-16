CREATE DATABASE IF NOT EXISTS shopping_db;
USE shopping_db;

CREATE TABLE IF NOT EXISTS products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    customer_email VARCHAR(100) NOT NULL,
    total_amount DOUBLE NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO products (name, price) VALUES 
('Laptop', 850.00),
('Smartphone', 450.00),
('Headphones', 50.00),
('Keyboard', 30.00),
('Wireless Mouse', 25.00),
('Gaming Monitor', 220.00),
('Smartwatch', 180.00),
('USB-C Hub', 35.00),
('External SSD 1TB', 110.00),
('Bluetooth Speaker', 65.00),
('Web Camera', 45.00),
('Gaming Chair', 150.00);