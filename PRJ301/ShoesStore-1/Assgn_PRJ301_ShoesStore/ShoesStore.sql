create database ShoesStore
use ShoesStore
create table Account(
    Username nvarchar(20) primary key not null,
	Password nvarchar(30) not null,
	Fullname nvarchar(30) not null,
    IsAdmin bit,
    Active bit
)

CREATE TABLE Category (
   CategoryId INT PRIMARY KEY IDENTITY(1,1),
   CategoryName NVARCHAR(50) NOT NULL
);

CREATE TABLE Product (
   ProductId INT PRIMARY KEY IDENTITY(1,1),
   ProductName NVARCHAR(50) NOT NULL,
   Price float NOT NULL,
   Description NVARCHAR(200) NOT NULL,
   img nvarchar(1000) NOT NULL,
   CategoryId INT NOT NULL FOREIGN KEY REFERENCES Category(CategoryId)
);
CREATE TABLE [Order] (
   OrderId INT PRIMARY KEY IDENTITY(1,1),
   Username nvarchar(20) NOT NULL FOREIGN KEY REFERENCES Account(Username),
   OrderDate DATE NOT NULL,
   Total float NOT NULL
);

create TABLE OrderDetail (
   OrderDetailId INT PRIMARY KEY IDENTITY(1,1),
   OrderId INT FOREIGN KEY REFERENCES [Order](OrderId),
   ProductId INT NOT NULL FOREIGN KEY REFERENCES Product(ProductId),
   Quantity INT NOT NULL,
   Price float NOT NULL
);
SELECT * FROM Account where IsAdmin != 1
INSERT INTO Account(Username , Password, Fullname, IsAdmin, Active)
VALUES('admin', 'admin', 'I am Admin', 1, 1)
