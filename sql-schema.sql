drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
`CustomerID` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(40),
`surname` VARCHAR(40),
);

CREATE TABLE IF NOT EXISTS `ims`.`orders`(
 `OrderID` INT AUTO_INCREMENT PRIMARY KEY,
 `CustomerID` INT NOT NULL, 
 FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

CREATE TABLE IF NOT EXISTS `ims`.`item`(
`ItemID` INT AUTO_INCREMENT PRIMARY KEY, 
`ItemName` VARCHAR(40), 
`StockAmount` INT NOT NULL, 
`Price` DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS ItemOrders(
ItemOrderID INT AUTO_INCREMENT PRIMARY KEY, 
OrderID INT NOT NULL, 
ItemID INT NOT NULL, 
Amount INT DEFAULT 1,
FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
FOREIGN KEY (ItemID) REFERENCES Item(ItemID)
);