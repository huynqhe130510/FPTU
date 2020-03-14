USE [master]
GO

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'StudentGradeDB')
	DROP DATABASE StudentGradeDB
GO

-- Create the StudentGradeDB database.
CREATE DATABASE StudentGradeDB
GO

USE StudentGradeDB;
GO

-- Create table Student
CREATE TABLE Student
(RollNo varchar (8) NOT NULL,
 Name varchar(20),
 Address varchar(30),
 BirthDate DATE,
 avgMark float,PRIMARY KEY (RollNo)
)
GO
-- Create table Course
CREATE TABLE Course
 (CRS_Id varchar (8) PRIMARY KEY,
  CRS_Name varchar(20),
 )
GO

-- Create table Grade
CREATE TABLE Grade
 (RollNo varchar (8),
  CRS_Id varchar (8),
  Mark float,
  PRIMARY KEY (RollNo, CRS_Id) 
 )
GO

ALTER TABLE Grade ADD FOREIGN KEY (RollNo) REFERENCES Student(RollNo)
GO
ALTER TABLE Grade ADD FOREIGN KEY (CRS_Id) REFERENCES Course(CRS_Id)
GO

-- Insert data into the Student table.
INSERT INTO Student (RollNo, Name, Address, BirthDate) VALUES ('A02', 'Tran Xuan', '2 Hang Bai', '1997-03-17')
INSERT INTO Student (RollNo, Name, Address, BirthDate) VALUES ('A04', 'Nguyen Ha', '5 Lo Duc', '1996-05-30')
INSERT INTO Student (RollNo, Name, Address, BirthDate) VALUES ('A01', 'Le Thu', '3 Doi Can', '1996-07-31')
INSERT INTO Student (RollNo, Name, Address, BirthDate) VALUES ('A03', 'Ha Dong', '1 Hang Bac', '1995-04-19')
INSERT INTO Student (RollNo, Name, Address, BirthDate) VALUES ('C02', 'Tran Hoa', '12 Kham Thien', '1992-07-14')
INSERT INTO Student (RollNo, Name, Address, BirthDate) VALUES ('C04', 'Pham La', '7 Giang Vo', '1994-06-29')
INSERT INTO Student (RollNo, Name, Address, BirthDate) VALUES ('C01', 'Hoang Canh', '4 Van Bao', '1991-07-11')
INSERT INTO Student (RollNo, Name, Address, BirthDate) VALUES ('C03', 'Vu Van Cay', '11 Hang Bai', '1993-04-20')
INSERT INTO Student (RollNo, Name, Address, BirthDate) VALUES ('B02', 'Bui Lan', '9 Thuy Khue', '1998-11-30')
INSERT INTO Student (RollNo, Name, Address, BirthDate) VALUES ('B01', 'Do Thi Dao', '6 Trang Thi', '1995-07-18')
GO

-- Insert data into the Course table.
INSERT INTO Course (CRS_Id, CRS_Name) VALUES ('JAVA', 'Java Language')
INSERT INTO Course (CRS_Id, CRS_Name) VALUES ('ENGL', 'English')
INSERT INTO Course (CRS_Id, CRS_Name) VALUES ('MATH', 'Mathematics')
INSERT INTO Course (CRS_Id, CRS_Name) VALUES ('CHIN', 'Chinese')
GO

-- Insert data into the Grade table.
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A02', 'JAVA', 7)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A04', 'JAVA', 9)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A01', 'JAVA', 4)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A03', 'JAVA', 6)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C02', 'JAVA', 7)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C04', 'JAVA', 5.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C01', 'JAVA', 8.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C03', 'JAVA', 6)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('B02', 'JAVA', 9.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('B01', 'JAVA', 4.5)

INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A02', 'ENGL', 9)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A04', 'ENGL', 7.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A01', 'ENGL', 4)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A03', 'ENGL', 8)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C02', 'ENGL', 5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C04', 'ENGL', 6.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C01', 'ENGL', 3.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C03', 'ENGL', 7)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('B02', 'ENGL', 6.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('B01', 'ENGL', 9.5)

INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A02', 'MATH', 8)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A04', 'MATH', 6)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A01', 'MATH', 9)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A03', 'MATH', 5.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C02', 'MATH', 7)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C04', 'MATH', 6.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C01', 'MATH', 7.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C03', 'MATH', 8)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('B02', 'MATH', 4)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('B01', 'MATH', 8.5)

INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A02', 'CHIN', 9.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A04', 'CHIN', 8)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A01', 'CHIN', 4.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('A03', 'CHIN', 6)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C02', 'CHIN', 8.8)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C04', 'CHIN', 6.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C01', 'CHIN', 3.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('C03', 'CHIN', 7)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('B02', 'CHIN', 6.5)
INSERT INTO Grade (RollNo, CRS_Id, Mark) VALUES ('B01', 'CHIN', 8.5)
GO

Select * from Course
GO

Select * from Student
GO

Select * from Grade
GO
