CREATE DATABASE Y19S2B1
GO
USE [Y19S2B1]
GO
CREATE TABLE [Publishers](
	[pub_id] [char](4) PRIMARY KEY,
	[pub_name] [varchar](40) NULL,
	[city] [varchar](20) NULL,
	[country] [varchar](30) NULL,
	[isActivated] bit not null
)  
GO
INSERT [dbo].[Publishers] ([pub_id], [pub_name], [city], [country],[isActivated]) VALUES (N'0736', N'New Moon Books', N'Boston', N'USA',1)
INSERT [dbo].[Publishers] ([pub_id], [pub_name], [city], [country],[isActivated]) VALUES (N'0877', N'Binnet & Hardley', N'Washington', N'USA',1)
INSERT [dbo].[Publishers] ([pub_id], [pub_name], [city], [country],[isActivated]) VALUES (N'1389', N'Algodata Infosystems', N'Berkeley', N'USA',1)
INSERT [dbo].[Publishers] ([pub_id], [pub_name], [city], [country],[isActivated]) VALUES (N'1622', N'Five Lakes Publishing', N'Chicago', N'USA',0)
INSERT [dbo].[Publishers] ([pub_id], [pub_name], [city], [country],[isActivated]) VALUES (N'1756', N'Ramona Publishers', N'Dallas', N'USA',1)

CREATE TABLE [Employee](
	[emp_id] [char](9) primary key,
	[FullName] [varchar](51) NOT NULL,
	[pub_id] [char](4) NOT NULL references Publishers(pub_id),
	[Salary] money not null,
	[Type] varchar(25) not null
)  
GO
INSERT [dbo].[Employee] ([emp_id], [FullName], [pub_id],[salary],[Type]) VALUES (N'PMA42628M', N'Paolo Accorti', N'0877',780,'Full time')
INSERT [dbo].[Employee] ([emp_id], [FullName], [pub_id],[salary],[Type]) VALUES (N'PSA89086M', N'Pedro Afonso', N'1389',520,'Part time')
INSERT [dbo].[Employee] ([emp_id], [FullName], [pub_id],[salary],[Type]) VALUES (N'VPA30890F', N'Victoria Ashworth', N'0877',410,'Full time')
INSERT [dbo].[Employee] ([emp_id], [FullName], [pub_id],[salary],[Type]) VALUES (N'PDI47470M', N'Palle Ibsen', N'0736',736,'Full time')
INSERT [dbo].[Employee] ([emp_id], [FullName], [pub_id],[salary],[Type]) VALUES (N'M-L67958F', N'Maria Larsson', N'1389',676,'Full time')
INSERT [dbo].[Employee] ([emp_id], [FullName], [pub_id],[salary],[Type]) VALUES (N'Y-L77953M', N'Yoshi Latimer', N'1622',779,'Full time')
INSERT [dbo].[Employee] ([emp_id], [FullName], [pub_id],[salary],[Type]) VALUES (N'LAL21447M', N'Laurence Lebihan', N'1756',214,'Part time')
 