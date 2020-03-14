/* DROP DATABASE StudentDB
   GO
*/

CREATE DATABASE StudentDB
GO
use StudentDB
GO
Create Table Student (RollNo varchar(10),Name varchar(30),mark int, PRIMARY KEY (RollNo))
GO
INSERT INTO Student (RollNo,Name,Mark) VALUES ('A02','Tran Hoa', 7)
INSERT INTO Student (RollNo,Name,Mark) VALUES ('A03','Nguyen La', 9)
INSERT INTO Student (RollNo,Name,Mark) VALUES ('A01','Quoc Canh', 6)
INSERT INTO Student (RollNo,Name,Mark) VALUES ('A04','Hoang Cay', 8)
INSERT INTO Student (RollNo,Name,Mark) VALUES ('A07','Nguyen Man', 5)
INSERT INTO Student (RollNo,Name,Mark) VALUES ('A08','Tran Dao', 9)
INSERT INTO Student (RollNo,Name,Mark) VALUES ('A09','Le Thi Thu', 8)
INSERT INTO Student (RollNo,Name,Mark) VALUES ('A06','Hoang Cuc', 7)
INSERT INTO Student (RollNo,Name,Mark) VALUES ('A05','Nguyen Lan', 7)
GO
select * from student

