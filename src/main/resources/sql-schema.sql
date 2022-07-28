drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `customer`(
	`customer_id` INT AUTO_INCREMENT NOT NULL,
    `firstname` VARCHAR(25) NOT NULL,
    `lastname` VARCHAR(25) NOT NULL,
    -- address VARCHAR(100)
    PRIMARY KEY(`customer_id`)
);

CREATE TABLE IF NOT EXISTS `orders`(
	`order_id` INT AUTO_INCREMENT NOT NULL,
    `customer_id` INT NOT NULL,
    `order_date` DATE NOT NULL,
    `order_value` DECIMAL(6,2) NOT NULL,
    PRIMARY KEY(`order_id`)
);

CREATE TABLE IF NOT EXISTS `item`(
	`item_id` INT AUTO_INCREMENT NOT NULL,
    `item_name` VARCHAR(50) NOT NULL,
    `item_value` DECIMAL(5,2) NOT NULL,
    PRIMARY KEY(`item_id`)
);

CREATE TABLE IF NOT EXISTS `order_item`(
	`order_id` INT NOT NULL,
    `item_id` INT NOT NULL,
    `quantity` INT NOT NULL,
    PRIMARY KEY(`order_id`, `item_id`),
    FOREIGN KEY(`order_id`) REFERENCES orders(`order_id`),
    FOREIGN KEY(`item_id`) REFERENCES item(`item_id`)
);

SHOW tables IN `ims`; --show tables if developer prefers to query rather than use sidebar
