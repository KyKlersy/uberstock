/*comment*/
DROP TABLE MembershipType IF EXISTS;
DROP TABLE PayPal IF EXISTS;
DROP TABLE PurchaseHistory IF EXISTS;
DROP TABLE InventoryItems IF EXISTS;
DROP TABLE ProductType IF EXISTS;
DROP TABLE Users IF EXISTS;

CREATE TABLE Users(
UserID IDENTITY,
Username varchar(50),
Password varchar(50),  
Membership int,
AllowAdmin bit,
UclubReward float,
PRIMARY KEY(UserID)
);

INSERT INTO Users(UserID, Username, Password, Membership, AllowAdmin, UclubReward)
VALUES(NULL,'user','user', 1, 0, 0.0),(NULL,'admin','admin',2,1, 100.0);

CREATE TABLE MembershipType(
MembershipID int NOT NULL,
MembershipName varchar(10),
PRIMARY KEY(MembershipID)
);

INSERT INTO MembershipType(MembershipID, MembershipName)
VALUES(1,'Standard'),(2,'UClub');

CREATE TABLE PayPal(
PayPalID IDENTITY,
PayPalUserID int NOT NULL,
FirstName varchar(30),
MiddleInitial char(1),
LastName varchar(50),
EmailAddress varchar(50),
PRIMARY KEY(PayPalID),
FOREIGN KEY(PayPalUserID) REFERENCES Users(UserID)
);

CREATE TABLE PurchaseHistory(
PurchaseNumber IDENTITY,
PurchaseUserID int,
ItemID int,
ItemAmount int,
PRIMARY KEY(PurchaseNumber),
FOREIGN KEY(PurchaseUserID) REFERENCES Users(UserID)
);

CREATE TABLE ProductType(
ProductCatagory IDENTITY,
ProductGroupName varchar(80),
PRIMARY KEY(ProductCatagory)
);

INSERT INTO ProductType(ProductCatagory, ProductGroupName)
VALUES(NULL,'Tables'),(NULL,'Chairs');


CREATE TABLE InventoryItems(
ItemID IDENTITY,
ItemName varchar(150),
ItemCatagory int,
ItemPrice float,
ItemStock int,
ItemImageURI varchar(80),
PRIMARY KEY(ItemID),
FOREIGN KEY(ItemCatagory) REFERENCES ProductType(ProductCatagory)
);

INSERT INTO InventoryItems(ItemID, ItemName, ItemCatagory, ItemPrice, ItemStock, ItemImageURI)
VALUES(NULL, 'Short Bar Chair', 1, 19.25, 5, '200.jpg'),
(NULL, 'Round End Table', 0, 15.99, 3, '200.jpg'),
(NULL, 'Square End Table', 0, 15.99, 3, '200.jpg'),
(NULL, 'Circle End Table', 0, 15.99, 3, '200.jpg'),
(NULL, 'Octogon End Table', 0, 15.99, 3, '200.jpg'),
(NULL, 'Trapizode End Table', 0, 15.99, 3, '200.jpg'),
(NULL, 'Stone End Table', 0, 15.99, 3, '200.jpg'),
(NULL, 'Wood End Table', 0, 15.99, 3, '200.jpg'),
(NULL, 'Clay End Table', 0, 15.99, 3, '200.jpg'),
(NULL, 'Granite End Table', 0, 15.99, 3, '200.jpg'),
(NULL, 'Marbel End Table', 0, 15.99, 3, '200.jpg'),
(NULL, 'Maple End Table', 0, 15.99, 3, '200.jpg');
