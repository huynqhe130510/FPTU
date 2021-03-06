USE [master]
GO
/****** Object:  Database [ProjectPRN292]    Script Date: 04/04/2020 16:28:40 ******/
CREATE DATABASE [ProjectPRN292] ON  PRIMARY 
( NAME = N'ProjectPRN292', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\ProjectPRN292.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ProjectPRN292_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\ProjectPRN292_log.LDF' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ProjectPRN292] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProjectPRN292].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProjectPRN292] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [ProjectPRN292] SET ANSI_NULLS OFF
GO
ALTER DATABASE [ProjectPRN292] SET ANSI_PADDING OFF
GO
ALTER DATABASE [ProjectPRN292] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [ProjectPRN292] SET ARITHABORT OFF
GO
ALTER DATABASE [ProjectPRN292] SET AUTO_CLOSE ON
GO
ALTER DATABASE [ProjectPRN292] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [ProjectPRN292] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [ProjectPRN292] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [ProjectPRN292] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [ProjectPRN292] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [ProjectPRN292] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [ProjectPRN292] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [ProjectPRN292] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [ProjectPRN292] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [ProjectPRN292] SET  ENABLE_BROKER
GO
ALTER DATABASE [ProjectPRN292] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [ProjectPRN292] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [ProjectPRN292] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [ProjectPRN292] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [ProjectPRN292] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [ProjectPRN292] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [ProjectPRN292] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [ProjectPRN292] SET  READ_WRITE
GO
ALTER DATABASE [ProjectPRN292] SET RECOVERY SIMPLE
GO
ALTER DATABASE [ProjectPRN292] SET  MULTI_USER
GO
ALTER DATABASE [ProjectPRN292] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [ProjectPRN292] SET DB_CHAINING OFF
GO
USE [ProjectPRN292]
GO
/****** Object:  Table [dbo].[Staff]    Script Date: 04/04/2020 16:28:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Staff](
	[Id] [int] NOT NULL,
	[Name] [varchar](255) NOT NULL,
	[Gender] [varchar](255) NOT NULL,
	[DoB] [date] NOT NULL,
	[Address] [varchar](255) NOT NULL,
	[PhoneNumber] [varchar](255) NOT NULL,
	[Date_of_join] [date] NOT NULL,
	[Salary] [float] NOT NULL,
	[Image] [varchar](255) NOT NULL,
 CONSTRAINT [PK_STAFF] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Staff] ([Id], [Name], [Gender], [DoB], [Address], [PhoneNumber], [Date_of_join], [Salary], [Image]) VALUES (1, N'Nguyen Quang Huy', N'Male', CAST(0xFF230B00 AS Date), N'Bac Ninh', N'0368020200', CAST(0xAE3D0B00 AS Date), 3000000, N'image\huyImage.jpg')
INSERT [dbo].[Staff] ([Id], [Name], [Gender], [DoB], [Address], [PhoneNumber], [Date_of_join], [Salary], [Image]) VALUES (2, N'Nguyen Quoc Hieu', N'Male', CAST(0x91230B00 AS Date), N'Hai Duong', N'0967382221', CAST(0x91230B00 AS Date), 3000000, N'image\hieuImage.jpg')
INSERT [dbo].[Staff] ([Id], [Name], [Gender], [DoB], [Address], [PhoneNumber], [Date_of_join], [Salary], [Image]) VALUES (3, N'Le Nguyen Duc Anh', N'Male', CAST(0xF7220B00 AS Date), N'Ha Noi', N'0365783324', CAST(0xAE3D0B00 AS Date), 3000000, N'image\anhImage.jpg')
INSERT [dbo].[Staff] ([Id], [Name], [Gender], [DoB], [Address], [PhoneNumber], [Date_of_join], [Salary], [Image]) VALUES (4, N'Khuat Dinh Quoc An ', N'Female', CAST(0x75230B00 AS Date), N'Ha noi', N'0267445887', CAST(0x75230B00 AS Date), 3000000, N'image\anImage.jpg')
INSERT [dbo].[Staff] ([Id], [Name], [Gender], [DoB], [Address], [PhoneNumber], [Date_of_join], [Salary], [Image]) VALUES (5, N'Bui Thi Thu Hang', N'Female', CAST(0xDA230B00 AS Date), N'Ha Noi', N'0954328853', CAST(0xDA230B00 AS Date), 3000000, N'image\hangImage.jpg')
/****** Object:  Table [dbo].[Role]    Script Date: 04/04/2020 16:28:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Role](
	[Id] [int] NOT NULL,
	[Name] [varchar](255) NOT NULL,
 CONSTRAINT [PK_ROLE] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Role] ([Id], [Name]) VALUES (1, N'Manager')
INSERT [dbo].[Role] ([Id], [Name]) VALUES (2, N'Staff')
/****** Object:  Table [dbo].[Category]    Script Date: 04/04/2020 16:28:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Category](
	[Id] [int] NOT NULL,
	[Name] [varchar](255) NOT NULL,
 CONSTRAINT [PK_CATEGORY] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Category] ([Id], [Name]) VALUES (1, N'Tra chanh')
INSERT [dbo].[Category] ([Id], [Name]) VALUES (2, N'Topping')
INSERT [dbo].[Category] ([Id], [Name]) VALUES (3, N'Do an vat')
/****** Object:  Table [dbo].[User]    Script Date: 04/04/2020 16:28:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[User](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](255) NOT NULL,
	[Password] [varchar](255) NOT NULL,
	[RoleId] [int] NOT NULL,
	[StaffId] [int] NOT NULL,
 CONSTRAINT [PK_USER] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON
INSERT [dbo].[User] ([Id], [Username], [Password], [RoleId], [StaffId]) VALUES (1, N'huynq', N'123', 1, 1)
INSERT [dbo].[User] ([Id], [Username], [Password], [RoleId], [StaffId]) VALUES (2, N'hieunq', N'123', 2, 2)
INSERT [dbo].[User] ([Id], [Username], [Password], [RoleId], [StaffId]) VALUES (3, N'anhlnd', N'123', 2, 3)
INSERT [dbo].[User] ([Id], [Username], [Password], [RoleId], [StaffId]) VALUES (4, N'ankdq', N'123', 2, 4)
INSERT [dbo].[User] ([Id], [Username], [Password], [RoleId], [StaffId]) VALUES (10, N'hangbtt', N'123', 2, 5)
SET IDENTITY_INSERT [dbo].[User] OFF
/****** Object:  Table [dbo].[Order]    Script Date: 04/04/2020 16:28:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[StaffId] [int] NOT NULL,
	[Date] [date] NOT NULL,
 CONSTRAINT [PK_ORDER] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Order] ON
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (2, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (3, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (4, 2, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (5, 2, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (6, 2, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (7, 2, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (8, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (9, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (10, 2, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (11, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (12, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (13, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (14, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (15, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (16, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (17, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (18, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (19, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (20, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (21, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (22, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (23, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (24, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (25, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (26, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (27, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (28, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (29, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (30, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (31, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (32, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (33, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (34, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (35, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (36, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (37, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (38, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (39, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (40, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (41, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (42, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (43, 1, CAST(0xDF400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (44, 1, CAST(0xE0400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (45, 1, CAST(0xE0400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (46, 4, CAST(0xE0400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (47, 1, CAST(0xE0400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (48, 5, CAST(0xE0400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (49, 1, CAST(0xE0400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (50, 1, CAST(0xE1400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (52, 1, CAST(0xE2400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (53, 1, CAST(0xE2400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (54, 1, CAST(0xE3400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (55, 1, CAST(0xE4400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (56, 1, CAST(0xE9400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (57, 1, CAST(0xEA400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (58, 1, CAST(0xEA400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (59, 1, CAST(0xEA400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (60, 1, CAST(0xEA400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (61, 1, CAST(0xED400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (62, 2, CAST(0xED400B00 AS Date))
INSERT [dbo].[Order] ([Id], [StaffId], [Date]) VALUES (63, 1, CAST(0xEE400B00 AS Date))
SET IDENTITY_INSERT [dbo].[Order] OFF
/****** Object:  Table [dbo].[Product]    Script Date: 04/04/2020 16:28:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Product](
	[Id] [int] NOT NULL,
	[Name] [varchar](255) NOT NULL,
	[CategoryId] [int] NOT NULL,
	[Size] [varchar](255) NOT NULL,
	[Price] [float] NOT NULL,
	[Image] [varchar](255) NOT NULL,
 CONSTRAINT [PK_PRODUCT] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (1, N'Tra chanh nhiet doi', 1, N'L', 10000, N'image\tra_chanh_nhiet_doi.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (2, N'Tra chanh nhiet doi', 1, N'XL', 20000, N'image\tra_chanh_nhiet_doi.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (3, N'Tra tac nha dam', 1, N'L', 10000, N'image\tra_tac_nha_dam.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (4, N'Tra tac nha dam', 1, N'XL', 20000, N'image\tra_tac_nha_dam.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (5, N'Tra chanh sa', 1, N'L', 10000, N'image\tra_chanh_sa.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (6, N'Tra chanh sa', 1, N'XL', 20000, N'image\tra_chanh_sa.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (7, N'Tra tac sa', 1, N'L', 10000, N'image\tra_tac_sa.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (8, N'Tra tac sa', 1, N'XL', 20000, N'image\tra_tac_sa.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (9, N'Tra chanh dac biet', 1, N'L', 15000, N'image\tra_chanh_dac_biet.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (10, N'Tra chanh dac biet', 1, N'XL', 30000, N'image\tra_chanh_dac_biet.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (11, N'Tra dao', 1, N'L', 15000, N'image\tra_dao.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (12, N'Tra dao', 1, N'XL', 30000, N'image\tra_dao.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (13, N'Tra chanh leo', 1, N'L', 15000, N'image\tra_chanh_leo.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (14, N'Tra chanh leo', 1, N'XL', 30000, N'image\tra_chanh_leo.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (17, N'Tra cam gung', 1, N'L', 20000, N'image\tra_cam_gung.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (18, N'Tra cam gung', 1, N'XL', 40000, N'image\tra_cam_gung.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (19, N'Tra o mai gung', 1, N'L', 20000, N'image\tra_o_mai_gung.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (20, N'Tra o mai gung', 1, N'XL', 40000, N'image\tra_o_mai_gung.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (21, N'Tra cam chanh mat ong ', 1, N'L', 20000, N'image\tra_cam_chanh_mat_ong.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (23, N'Tra trai cay', 1, N'L', 20000, N'image\tra_trai_cay.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (25, N'Tra dao nhai', 1, N'L', 25000, N'image\tra_dao_nhai.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (27, N'Chanh leo lac sua', 1, N'L', 25000, N'image\chanh_leo_lac_sua.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (29, N'Quat lac bac ha', 1, N'L', 30000, N'image\quat_lac_bac_ha.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (31, N'Quat lac sua', 1, N'L', 30000, N'image\quat_lac_sua.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (33, N'Bia up nguoc', 1, N'L', 35000, N'image\bia_up_nguoc.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (34, N'Topping tran chau trang', 2, N'None', 5000, N'image\topping_tran_chau_trang.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (35, N'Topping tran chau den', 2, N'None', 5000, N'image\topping_tran_chau_den.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (36, N'Topping tran chau xoai', 2, N'None', 5000, N'image\topping_tran_chau_xoai.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (37, N'Nha dam', 2, N'None', 5000, N'image\topping_nha_dam.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (38, N'Khoai chien', 3, N'None', 30000, N'image\khoai_tay_chien.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (39, N'Nem chua ran', 3, N'None', 35000, N'image\nem_chua_ran.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (40, N'Hat huong duong', 3, N'None', 7000, N'image\hat_huong_duong.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (41, N'Thit bo kho', 3, N'None', 35000, N'image\bo_kho.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (42, N'Heo chay toi', 3, N'None', 30000, N'image\heo_chay_toi.jpg')
INSERT [dbo].[Product] ([Id], [Name], [CategoryId], [Size], [Price], [Image]) VALUES (43, N'Kho ga la chanh', 3, N'None', 25000, N'image\kho_ga_la_chanh.jpg')
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 04/04/2020 16:28:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[OrderId] [int] NOT NULL,
	[ProductId] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
 CONSTRAINT [PK_ORDERDETAIL] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[OrderDetail] ON
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (1, 2, 42, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (2, 3, 1, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (3, 3, 4, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (4, 7, 25, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (5, 12, 1, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (6, 12, 2, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (7, 12, 40, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (8, 13, 1, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (9, 13, 2, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (10, 13, 5, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (11, 13, 42, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (12, 13, 35, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (13, 13, 40, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (14, 14, 1, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (15, 14, 33, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (16, 14, 31, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (17, 14, 37, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (18, 14, 35, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (19, 14, 40, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (20, 14, 42, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (21, 14, 43, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (22, 15, 1, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (23, 16, 3, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (24, 16, 1, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (25, 17, 1, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (26, 17, 42, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (27, 18, 39, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (28, 19, 42, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (29, 20, 7, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (30, 21, 37, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (31, 21, 36, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (32, 22, 34, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (33, 22, 36, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (34, 23, 40, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (35, 24, 27, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (36, 24, 34, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (37, 25, 33, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (38, 26, 36, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (39, 26, 34, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (40, 27, 35, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (41, 27, 29, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (42, 28, 31, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (43, 29, 25, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (44, 30, 40, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (45, 30, 38, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (46, 31, 1, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (47, 32, 31, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (48, 32, 29, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (49, 32, 33, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (50, 33, 42, 4)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (51, 34, 6, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (52, 35, 3, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (53, 35, 4, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (54, 36, 2, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (55, 36, 1, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (56, 36, 3, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (57, 36, 4, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (58, 36, 6, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (59, 36, 5, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (60, 36, 7, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (61, 36, 8, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (62, 36, 12, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (63, 36, 11, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (64, 36, 13, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (65, 36, 14, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (66, 36, 18, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (67, 36, 17, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (68, 36, 19, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (69, 36, 20, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (70, 37, 5, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (71, 37, 3, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (72, 38, 36, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (73, 38, 34, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (74, 39, 1, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (75, 39, 2, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (76, 39, 4, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (77, 39, 3, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (78, 39, 5, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (79, 39, 6, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (80, 39, 8, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (81, 39, 7, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (82, 39, 9, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (83, 39, 10, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (84, 39, 12, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (85, 39, 11, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (86, 40, 5, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (87, 40, 7, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (88, 40, 3, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (89, 40, 4, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (90, 41, 35, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (91, 41, 33, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (92, 42, 8, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (93, 43, 19, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (94, 43, 17, 2)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (101, 50, 38, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (106, 54, 1, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (107, 55, 4, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (108, 55, 36, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (110, 57, 5, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (111, 57, 3, 1)
GO
print 'Processed 100 total records'
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (112, 57, 1, 3)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (113, 59, 1, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (114, 59, 4, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (115, 59, 5, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (116, 60, 1, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (117, 60, 4, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (118, 60, 5, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (119, 60, 8, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (120, 60, 7, 1)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (122, 62, 40, 5)
INSERT [dbo].[OrderDetail] ([Id], [OrderId], [ProductId], [Quantity]) VALUES (123, 63, 3, 3)
SET IDENTITY_INSERT [dbo].[OrderDetail] OFF
/****** Object:  ForeignKey [User_fk0]    Script Date: 04/04/2020 16:28:41 ******/
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [User_fk0] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Role] ([Id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [User_fk0]
GO
/****** Object:  ForeignKey [User_fk1]    Script Date: 04/04/2020 16:28:41 ******/
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [User_fk1] FOREIGN KEY([StaffId])
REFERENCES [dbo].[Staff] ([Id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [User_fk1]
GO
/****** Object:  ForeignKey [Order_fk0]    Script Date: 04/04/2020 16:28:41 ******/
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [Order_fk0] FOREIGN KEY([StaffId])
REFERENCES [dbo].[Staff] ([Id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [Order_fk0]
GO
/****** Object:  ForeignKey [Product_fk0]    Script Date: 04/04/2020 16:28:41 ******/
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [Product_fk0] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Category] ([Id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [Product_fk0]
GO
/****** Object:  ForeignKey [OrderDetail_fk0]    Script Date: 04/04/2020 16:28:41 ******/
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [OrderDetail_fk0] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Order] ([Id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [OrderDetail_fk0]
GO
/****** Object:  ForeignKey [OrderDetail_fk1]    Script Date: 04/04/2020 16:28:41 ******/
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [OrderDetail_fk1] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([Id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [OrderDetail_fk1]
GO
