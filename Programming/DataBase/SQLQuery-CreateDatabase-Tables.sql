create database WesternCompany
go
use WesternCompany;

create table SUPPLIER(
	id int identity(1,1) primary key(id),
	name varchar(20),
	sAddress varchar (20),
	country varchar (20),
	phoneNr varchar (20),
	email varchar (30)
);

create table PRODUCT (
	id int identity(1,1) primary key(id),
	name varchar(20),
	purchasePrice float,
	salesPrice float,
	rentPrice float,
	countryofOrigin varchar(30), 
	minStock int ,
	inStock int,
	typee varchar(20)
);

create table GUN_REPLICAS(
	id int primary key (id)
	foreign key (id) references PRODUCT(id) on delete cascade on update cascade,
	fabric varchar (20),
	calibre float
);

create table EQUIPMENT(
	id int primary key (id)
	foreign key (id) references PRODUCT(id) on delete cascade on update cascade,
	eType varchar(20),
	eDescription varchar(60)
);

create table CLOTHING (
	id int primary key (id)
	foreign key (id) references PRODUCT(id) on delete cascade on update cascade,
	size varchar(5),
	color varchar (30)
);

create table PRODUCT_SUPPLIER_ID(
	pID int primary key(pID) foreign key (pID) references PRODUCT(id) on delete cascade on update cascade,
	suID int foreign key (suID) references SUPPLIER(id) on delete cascade on update cascade

);

create table COUNTRY(
	id int identity(1,1) primary key (id),
	zipCode varchar (50),
	city varchar (30),
	country varchar (20)
);

create table CUSTOMER(
	id int identity(1,1) primary key (id),
	name varchar(20),
	cAddress varchar (50),	
	email, varchar(20),
	zipcodeID int foreign key (zipcodeID) references COUNTRY (id) on delete cascade on update cascade,
	phoneNR varchar (20),
	isCompany bit
);

create table SALES_ORDER(
	id int identity(1,1) primary key (id),
	sDate varchar(20),
	deliveryStatus varchar(20),
	deliveryDate varchar(20),
	totalPrice float,
	cID int foreign key (cID) references CUSTOMER(id) on delete cascade on update cascade,
	discount float,
	deliveryFee float 
);

create table SALE_ORDER_LINE (
	id int identity(1,1) primary key (id),
	quantity int,
	pID int
	foreign key (pID) references PRODUCT(id) on delete cascade on update cascade,
	soID int foreign key (soID) references SALES_ORDER(id) on delete cascade on update cascade
);

create table INVOICE (
	id int identity(1,1) primary key (id),
	name varchar(20),
	invoiceNR varchar(20),
	paymentDate varchar(20),
	amount float,
	saleID int foreign key (saleID) references SALES_ORDER(id) on delete cascade on update cascade

);

insert into SUPPLIER(name, sAddress, country, phoneNr, email ) values ('Clothing Inc' , 'Hollywood Street', 'USA' , '01555243', 'clothing@inc.com')
insert into SUPPLIER(name, sAddress, country, phoneNr, email ) values ('Wool Inc' , 'Alabama Street', 'USA' , '01555876', 'wool@inc.com')
insert into PRODUCT(name, purchasePrice, salesPrice, rentPrice, countryofOrigin, minStock, inStock, typee) values ('Trausers', 15, 20, 18, 'USA' , 10, 20, 1)
insert into CLOTHING(id, size, color) values (1,'M', 'blue')
insert into PRODUCT(name, purchasePrice, salesPrice, rentPrice, countryofOrigin, minStock, inStock, typee) values ('Pistol', 25, 30, 28, 'USA' , 5, 22, 3)
insert into GUN_REPLICAS(id, fabric, calibre) values (2, 'Desert Eagle' , 0.50)
insert into PRODUCT(name, purchasePrice, salesPrice, rentPrice, countryofOrigin, minStock, inStock, typee) values ('Belt', 12, 18, 14, 'USA' , 12, 28, 2)
insert into EQUIPMENT(id, eType, eDescription) values (3, 'Type1', 'Black Leather with nice texture')
insert into PRODUCT_SUPPLIER_ID (pID, suID) values (1, 1)
insert into PRODUCT_SUPPLIER_ID (pID, suID) values (3, 1)
insert into PRODUCT_SUPPLIER_ID (pID, suID) values (2, 2)
insert into COUNTRY(zipCode, city, country) values ('900', 'Los Angeles', 'USA')
insert into COUNTRY(zipCode, city, country) values ('8000', 'Aarhus', 'Denmark')
insert into CUSTOMER(name, cAddress, zipcodeID, phoneNR, isCompany) values ('Cowboy Fans CO' , 'Beverly Hills NR.23', 1, '01555952', 1)
insert into CUSTOMER(name, cAddress, zipcodeID, phoneNR, isCompany) values ('Anne Karble' , 'Kastetvej 21', 2, '71456982', 0)

SELECT * FROM SUPPLIER
SELECT * FROM PRODUCT
SELECT * FROM CUSTOMER