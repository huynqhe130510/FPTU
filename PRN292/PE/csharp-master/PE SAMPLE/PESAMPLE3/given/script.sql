Create database EmployeeDB
go
USE [EmployeeDB]
GO
/****** Object:  Table [dbo].[Project]    Script Date: 04/17/2017 22:37:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Project](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Project] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Project] ([id], [name]) VALUES (1, N'Sale System Management')
INSERT [dbo].[Project] ([id], [name]) VALUES (2, N'Hotel System ')
INSERT [dbo].[Project] ([id], [name]) VALUES (3, N'E-Learning')
INSERT [dbo].[Project] ([id], [name]) VALUES (4, N'Data Migration')
/****** Object:  Table [dbo].[Employee]    Script Date: 04/17/2017 22:37:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Employee](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Employee] ([id], [name]) VALUES (1, N'sonnt')
INSERT [dbo].[Employee] ([id], [name]) VALUES (2, N'duydt')
INSERT [dbo].[Employee] ([id], [name]) VALUES (3, N'caupd')
INSERT [dbo].[Employee] ([id], [name]) VALUES (4, N'chilp')
INSERT [dbo].[Employee] ([id], [name]) VALUES (5, N'hieuld')
INSERT [dbo].[Employee] ([id], [name]) VALUES (6, N'bangbh')
/****** Object:  Table [dbo].[ProjectMember]    Script Date: 04/17/2017 22:37:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ProjectMember](
	[employeeID] [int] NOT NULL,
	[projectID] [int] NOT NULL,
	[position] [varchar](150) NOT NULL,
	[isFulltime] [bit] NOT NULL,
	[date] [datetime] NOT NULL,
 CONSTRAINT [PK_ProjectMember] PRIMARY KEY CLUSTERED 
(
	[employeeID] ASC,
	[projectID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  ForeignKey [FK_ProjectMember_Employee]    Script Date: 04/17/2017 22:37:31 ******/
ALTER TABLE [dbo].[ProjectMember]  WITH CHECK ADD  CONSTRAINT [FK_ProjectMember_Employee] FOREIGN KEY([employeeID])
REFERENCES [dbo].[Employee] ([id])
GO
ALTER TABLE [dbo].[ProjectMember] CHECK CONSTRAINT [FK_ProjectMember_Employee]
GO
/****** Object:  ForeignKey [FK_ProjectMember_Project]    Script Date: 04/17/2017 22:37:31 ******/
ALTER TABLE [dbo].[ProjectMember]  WITH CHECK ADD  CONSTRAINT [FK_ProjectMember_Project] FOREIGN KEY([projectID])
REFERENCES [dbo].[Project] ([id])
GO
ALTER TABLE [dbo].[ProjectMember] CHECK CONSTRAINT [FK_ProjectMember_Project]
GO