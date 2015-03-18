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
	typee int
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

create table INVOICE (
	id int identity(1,1) primary key (id),
	name varchar(20),
	invoiceNR varchar(20),
	paymentDate varchar(20),
	amount float,
	saleID int foreign key (saleID) references SALES_ORDER(id) on delete cascade on update cascade

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
	iID int foreign key (iID) references INVOICE(id) on delete cascade on update cascade,
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