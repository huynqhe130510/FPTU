 create database PMSDB
go
use PMSDB
go
create table Project 
(
id int identity(1,1) primary key,
name nvarchar(max) not null
)
go
create table ProjectMember
(
Projectid int references Project(id) not null,
Employeeid nvarchar(20) not null,
IsFullTime bit not null,
[Hours] int not null,
primary key(projectid,employeeid)
)
go
insert into Project values('Sale System Management')
insert into Project values('Hotel System ')
insert into Project values('E-Learning')
insert into Project values('Data Migration')
go
insert into ProjectMember values(1,'anhttv',1,50)
insert into ProjectMember values(1,'duyt',1,90)
insert into ProjectMember values(2,'caupd',0,140)
insert into ProjectMember values(3,'hapt',0,30)