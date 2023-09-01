Create database Ws2

use Ws2

create table registration (
ID nvarchar(5) primary key,
name nvarchar(20),
role nvarchar(10),
className nvarchar(10) references className(className)
)

drop table registration

create table className(
className nvarchar(10)primary key
)
select * from registration
select * from className
insert into className values('SE1745')
insert into className values('SE1746')
insert into className values('SE1747')


insert into registration 
values('se123','tuan','student','SE1745')
insert into registration 
values('se222','truongle','student','SE1745')
insert into registration 
values('GV111','thu','teacher','SE1745')

drop table class

create table inventory(
ID nvarchar(5) primary key,
name nvarchar(30),
quantity int
)
insert into inventory 
values('11111','xa phong','100')
insert into inventory 
values('22222','Ly thuy tinh','50')
insert into inventory 
values('33333','Sua tiet trung','500')
insert into inventory 
values('44444','Kem','80')
insert into inventory 
values('55555','Banhs Gao','20')

select * from inventory

create table airplane(
ID int primary key,
flightNumber nvarchar(6),
destination nvarchar(20),
departureAttributesTime nvarchar(20),
status nvarchar(10)
)

select  * from airplane

