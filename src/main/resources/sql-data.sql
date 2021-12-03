INSERT INTO CUSTOMERS (first_name, surname) VALUES ( "Bruno", "Zorima");
INSERT INTO CUSTOMERS (first_name, surname) VALUES ( "Saqlain", "Chowdhury");
INSERT INTO CUSTOMERS (first_name, surname) VALUES ( "Yusuf", "Pholby");
INSERT INTO CUSTOMERS (first_name, surname) VALUES ( "Jamie", "Joule");
INSERT INTO CUSTOMERS (first_name, surname) VALUES ( "Raymond", "Wang");

INSERT INTO ITEMS (ItemName, StockAmount, PRICE) VALUES ("willtolive", 1, 1.0);
INSERT INTO ITEMS (ItemName, StockAmount, PRICE) VALUES ("Christmas tree", 2, 27.99);
INSERT INTO ITEMS (ItemName, StockAmount, PRICE) VALUES ("Pixel Pro 6", 100, 899.99);
INSERT INTO ITEMS (ItemName, StockAmount, PRICE) VALUES ("IPHONE 13 pro", 100, 1100);
INSERT INTO ITEMS (ItemName, StockAmount, PRICE) VALUES ("PS5", 0, 899.99);

INSERT INTO ORDERS (CustomerID) VALUES (1);
INSERT INTO ORDERS (CustomerID) VALUES (1);
INSERT INTO ORDERS (CustomerID) VALUES (3);
INSERT INTO ORDERS (CustomerID) VALUES (2);
INSERT INTO ORDERS (CustomerID) VALUES (4);
INSERT INTO ORDERS (CustomerID) VALUES (5);

INSERT INTO ITEMORDERS (OrderID, ItemID) VALUES (1, 1);
INSERT INTO ITEMORDERS (OrderID, ItemID,Amount) VALUES (2, 2, 2);
INSERT INTO ITEMORDERS (OrderID, ItemID,Amount) VALUES (3, 3, 2);
INSERT INTO ITEMORDERS (OrderID, ItemID,Amount) VALUES (4, 3, 2);
INSERT INTO ITEMORDERS (OrderID, ItemID,Amount) VALUES (5, 3, 2);
