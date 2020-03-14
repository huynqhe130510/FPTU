USE [master]
GO

/****** Object:  Database [Muahang]    Script Date: 06/21/2019 21:49:07 ******/
IF  EXISTS (SELECT name FROM sys.databases WHERE name = N'Muahang')
DROP DATABASE [Muahang]
GO

USE [master]
GO

/****** Object:  Database [Muahang]    Script Date: 06/21/2019 21:49:07 ******/
CREATE DATABASE [Muahang] ON  PRIMARY 
( NAME = N'Muahang', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.MSSQLSERVER\MSSQL\DATA\Muahang.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Muahang_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.MSSQLSERVER\MSSQL\DATA\Muahang_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

ALTER DATABASE [Muahang] SET COMPATIBILITY_LEVEL = 100
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Muahang].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

CREATE TABLE [dbo].[tblUser](
	[account] [nchar](10) NOT NULL,
	[pass] [nchar](10) NULL,
	[name] [nvarchar](50) NULL,
	[gender] [bit] NULL,
	[address] [nvarchar](50) NULL,
	[dateofbirth] [date] NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[account] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

INSERT INTO [Muahang].[dbo].[tblUser]
           ([account]
           ,[pass]
           ,[name]
           ,[gender]
           ,[address]
           ,[dateofbirth])
     VALUES
           ('admin'
           ,'123'
           ,'Admin'
           ,'true'
           ,'Ha Noi'
           ,'12/12/2019')
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblMatHang]') AND type in (N'U'))
DROP TABLE [dbo].[tblMatHang]
GO

USE [Muahang]
GO

/****** Object:  Table [dbo].[tblMatHang]    Script Date: 06/21/2019 21:52:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[tblMatHang](
	[MaHang] [varchar](10) NOT NULL,
	[Tenhang] [nvarchar](50) NOT NULL,
	[DVT] [varchar](50) NOT NULL,
	[Gia] [real] NULL,
 CONSTRAINT [PK_tblMatHang] PRIMARY KEY CLUSTERED 
(
	[MaHang] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblKhachHang]') AND type in (N'U'))
DROP TABLE [dbo].[tblKhachHang]
GO

USE [Muahang]
GO

/****** Object:  Table [dbo].[tblKhachHang]    Script Date: 06/21/2019 21:53:48 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[tblKhachHang](
	[MaKH] [varchar](10) NOT NULL,
	[TenKH] [nvarchar](50) NOT NULL,
	[GT] [bit] NOT NULL,
	[Diachi] [nvarchar](50) NULL,
	[NgaySinh] [datetime] NULL,
 CONSTRAINT [PK_tblKhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[tblHoadon]    Script Date: 06/21/2019 21:54:15 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblHoadon]') AND type in (N'U'))
DROP TABLE [dbo].[tblHoadon]
GO

USE [Muahang]
GO

/****** Object:  Table [dbo].[tblHoadon]    Script Date: 06/21/2019 21:54:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[tblHoadon](
	[MaHD] [numeric](18, 0) NOT NULL,
	[MaKH] [varchar](10) NOT NULL,
	[NgayHD] [datetime] NOT NULL,
 CONSTRAINT [PK_tblHoadon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblChitietHD]') AND type in (N'U'))
DROP TABLE [dbo].[tblChitietHD]
GO

USE [Muahang]
GO

/****** Object:  Table [dbo].[tblChitietHD]    Script Date: 06/21/2019 21:54:48 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[tblChitietHD](
	[MaChiTietHD] [numeric](18, 0) NOT NULL,
	[MaHD] [numeric](18, 0) NOT NULL,
	[MaHang] [varchar](10) NOT NULL,
	[Soluong] [int] NOT NULL,
 CONSTRAINT [PK_tblChitietHD] PRIMARY KEY CLUSTERED 
(
	[MaChiTietHD] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER DATABASE [Muahang] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [Muahang] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [Muahang] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [Muahang] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [Muahang] SET ARITHABORT OFF 
GO

ALTER DATABASE [Muahang] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [Muahang] SET AUTO_CREATE_STATISTICS ON 
GO

ALTER DATABASE [Muahang] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [Muahang] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [Muahang] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [Muahang] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [Muahang] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [Muahang] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [Muahang] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [Muahang] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [Muahang] SET  DISABLE_BROKER 
GO

ALTER DATABASE [Muahang] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [Muahang] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [Muahang] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [Muahang] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [Muahang] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [Muahang] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [Muahang] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [Muahang] SET  READ_WRITE 
GO

ALTER DATABASE [Muahang] SET RECOVERY FULL 
GO

ALTER DATABASE [Muahang] SET  MULTI_USER 
GO

ALTER DATABASE [Muahang] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [Muahang] SET DB_CHAINING OFF 
GO


