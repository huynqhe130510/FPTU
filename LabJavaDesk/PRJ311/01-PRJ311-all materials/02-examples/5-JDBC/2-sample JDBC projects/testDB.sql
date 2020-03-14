/* 
USE master  
GO  
DROP DATABASE testDB
GO
*/
CREATE DATABASE testDB
GO
use testDB
GO
Create Table Emp (code varchar(10),Name varchar(30),age int, income float PRIMARY KEY (code))
GO
INSERT INTO Emp (code,Name,age,income) VALUES ('A02','Tran Hoa',27,500)
INSERT INTO Emp (code,Name,age,income) VALUES ('A03','Nguyen La',19,700)
INSERT INTO Emp (code,Name,age,income) VALUES ('A01','Quoc Canh',26,450)
INSERT INTO Emp (code,Name,age,income) VALUES ('A04','Hoang Cay',18,600)
INSERT INTO Emp (code,Name,age,income) VALUES ('A07','Nguyen Goc',25,500)
INSERT INTO Emp (code,Name,age,income) VALUES ('A08','Tran Re',29,650)
GO
select * from Emp
