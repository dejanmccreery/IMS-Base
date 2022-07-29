USE ims;

SHOW tables IN ims;

CREATE TABLE customer(
	customer_id INT AUTO_INCREMENT NOT NULL,
    firstname VARCHAR(25) NOT NULL,
    lastname VARCHAR(25) NOT NULL,
    address VARCHAR(100),
    PRIMARY KEY(customer_id)
);

CREATE TABLE orders(
	order_id INT AUTO_INCREMENT NOT NULL,
    customer_id INT NOT NULL,
    order_date DATE NOT NULL,
    PRIMARY KEY(order_id)
);

CREATE TABLE item(
	item_id INT AUTO_INCREMENT NOT NULL,
    item_name VARCHAR(50) NOT NULL,
    item_value DECIMAL(5,2) NOT NULL,
    PRIMARY KEY(item_id)
);

CREATE TABLE order_item(
	order_id INT NOT NULL,
    item_id INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY(order_id, item_id),
    FOREIGN KEY(order_id) REFERENCES orders(order_id),
    FOREIGN KEY(item_id) REFERENCES item(item_id)
);

