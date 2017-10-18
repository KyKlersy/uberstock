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
VALUES(NULL,'Rugs'),(NULL,'Outdoor'),(NULL,'Kitchen'),(NULL,'Home Improvement'),(NULL,'Decor'),(NULL,'Bed & Bath'), (NULL,'Furniture');


CREATE TABLE InventoryItems(
ItemID IDENTITY,
ItemName varchar(150),
ItemCatagory int,
ItemPrice float,
ItemStock int,
ItemImageURI varchar(150),
PRIMARY KEY(ItemID),
FOREIGN KEY(ItemCatagory) REFERENCES ProductType(ProductCatagory)
);

INSERT INTO InventoryItems(ItemID, ItemName, ItemCatagory, ItemPrice, ItemStock, ItemImageURI)
VALUES(NULL, 'Hand-tufted Wool Area Rug (8'' x 11'')', 0, 688.87, 15, 'Hand-tufted Wool Area Rug (8'' x 11'').jpg'),
(NULL, 'Chatham Dark Blue Ivory Wool Rug', 0, 56.99, 3, 'Chatham Dark Blue Ivory Wool Rug.jpg'),
(NULL, 'nuLOOM Contemporary Ombre Waves Grey Rug (8''6 x 11''6)', 0, 164.99, 7, 'nuLOOM Contemporary Ombre Waves Grey Rug (8''6 x 11''6).jpg'),
(NULL, 'Williamsburg Seigel Granite Mist Shades Grey Rug (4'' x 6'')', 0, 50.99, 4, 'Williamsburg Seigel Granite Mist Shades Grey Rug (4'' x 6'').jpg'),
(NULL, 'Squared Worcester Beige Rug (8'' x 10''6)', 0, 595.99, 1, 'Squared Worcester Beige Rug (8'' x 10''6).jpg'),
(NULL, 'Green Garden Kneeling Pad', 1, 9.89, 26, 'Green Garden Kneeling Pad.jpg'),
(NULL, 'Expandable Garden Hose Set', 1, 31.49, 11, 'Expandable Garden Hose Set.jpg'),
(NULL, '2 Speed Electric Blower', 1, 53.49, 8, '2 Speed Electric Blower.jpg'),
(NULL, 'Natural Bamboo Garden Edging', 1, 39.99, 3, 'Natural Bamboo Garden Edging.jpg'),
(NULL, 'Cast Aluminum Rectangular 9-piece Dining Set', 1, 1646.99, 2, 'Cast Aluminum Rectangular 9-piece Dining Set.jpg'),
(NULL, 'Black Oval Serving Bowl', 2, 18.74, 5, 'Black Oval Serving Bowl.jpg'),
(NULL, 'Handheld 3-in-1 Mixer', 2, 26.62, 14, 'Handheld 3-in-1 Mixer.jpg'),
(NULL, 'Stainless Steel 10-pound Rotisserie', 2, 97.48, 6, 'Stainless Steel 10-pound Rotisserie.jpg'),
(NULL, 'Stainless Steel Garlic Press', 2, 12.64, 8, 'Stainless Steel Garlic Press.jpg'),
(NULL, 'Expresso capuchino maker', 2, 1299.95, 5, 'expresso capuchino maker.jpg'),
(NULL, 'Switch wall plate', 3, 12.50, 35, 'switch wall plate.jpg'),
(NULL, 'Doorknob', 3, 36.50, 22, 'doorknob.jpg'),
(NULL, 'Mailbox', 3, 182.99, 5, 'mailbox.jpg'),
(NULL, 'Krud cutter', 3, 29.93, 15, 'krud cutter.jpg'),
(NULL, 'Undermount kitchen prep bar sink', 3, 115.99, 3, 'undermount kitchen prep bar sink.jpg'),
(NULL, 'Therapy Reading Floor Lamp', 4, 36.54, 5, 'Therapy Reading Floor Lamp.jpg'),
(NULL, '54-inch Electric Fireplace with Remote', 4, 249.78, 1, '54-inch Electric Fireplace with Remote.jpg'),
(NULL, '3D DIY Butterfly Flower Wall Clock', 4, 20.24, 5, '3D DIY Butterfly Flower Wall Clock.jpg'),
(NULL, 'Wood and metal chandelier', 4, 254.86, 3, 'wood and metal chandelier.jpg'),
(NULL, 'Black-out-curtain', 4, 35.05, 5, 'black-out-curtain.jpg'),
(NULL, 'Down-pillow', 5, 79.99, 20, 'down-pillow.jpg'),
(NULL, 'Down-blanket', 5, 134.99, 10, 'down-blanket.jpg'),
(NULL, 'Shower rings', 5, 16.19, 45, 'shower rings.jpg'),
(NULL, 'Shower curtain rings', 5, 16.99, 26, 'shower curtain rings.jpg'),
(NULL, '12 Piece Bath Towel set', 5, 48.37, 17, '12 Piece Bath Towel set.jpg'),
(NULL, 'Distressed Leather Couch ', 6, 455.99, 4, 'distressed-leather-couch.jpg'),
(NULL, 'Cherry Dresser', 6, 367.09, 9, 'cherryDresser.jpg'),
(NULL, 'Memory foam King Set', 6, 265.77, 5, 'memoryfoam-king-set.jpg'),
(NULL, 'Short Bar Chair ', 6, 35.99, 5, 'shortBarChair .jpg'),
(NULL, 'Octagon End Table ', 6, 109.99, 5, 'octagonEndTable.jpg');