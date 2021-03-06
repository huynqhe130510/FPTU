create database Student
USE [Student]
GO
CREATE TABLE [dbo].[Dummy](
	[DummyID] [int] NOT NULL,
	[DummyName] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Dummy] PRIMARY KEY CLUSTERED 
(
	[DummyID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Features]    Script Date: 7/9/2019 4:05:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Features](
	[featureid] [int] NOT NULL,
	[url] [varchar](250) NOT NULL,
 CONSTRAINT [PK_Features] PRIMARY KEY CLUSTERED 
(
	[featureid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Information]    Script Date: 7/9/2019 4:05:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Information](
	[ID] [nvarchar](50) NULL,
	[Name] [nvarchar](50) NULL,
	[Age] [int] NULL,
	[Class] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role_Feature]    Script Date: 7/9/2019 4:05:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_Feature](
	[roleid] [int] NOT NULL,
	[featureid] [int] NOT NULL,
 CONSTRAINT [PK_RoleFeatureDetail] PRIMARY KEY CLUSTERED 
(
	[roleid] ASC,
	[featureid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role_User]    Script Date: 7/9/2019 4:05:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Role_User](
	[roleid] [int] NOT NULL,
	[username] [varchar](150) NOT NULL,
 CONSTRAINT [PK_RoleDetail] PRIMARY KEY CLUSTERED 
(
	[roleid] ASC,
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 7/9/2019 4:05:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Roles](
	[roleid] [int] NOT NULL,
	[rolename] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[roleid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Users]    Script Date: 7/9/2019 4:05:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[username] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Dummy] ([DummyID], [DummyName]) VALUES (1, N'A')
INSERT [dbo].[Dummy] ([DummyID], [DummyName]) VALUES (2, N'B')
INSERT [dbo].[Dummy] ([DummyID], [DummyName]) VALUES (3, N'C')
INSERT [dbo].[Dummy] ([DummyID], [DummyName]) VALUES (4, N'D')
INSERT [dbo].[Dummy] ([DummyID], [DummyName]) VALUES (5, N'E')
INSERT [dbo].[Dummy] ([DummyID], [DummyName]) VALUES (6, N'F')
INSERT [dbo].[Features] ([featureid], [url]) VALUES (2, N'/insert')
INSERT [dbo].[Features] ([featureid], [url]) VALUES (3, N'/edit')
INSERT [dbo].[Features] ([featureid], [url]) VALUES (4, N'/detail')
INSERT [dbo].[Information] ([ID], [Name], [Age], [Class]) VALUES (N'3', N'hoangg', 5566, N'SE1211')
INSERT [dbo].[Information] ([ID], [Name], [Age], [Class]) VALUES (N'3', N'hoangg', 5566, N'SE1211')
INSERT [dbo].[Information] ([ID], [Name], [Age], [Class]) VALUES (N'3', N'hoangg', 5566, N'SE1211')
INSERT [dbo].[Information] ([ID], [Name], [Age], [Class]) VALUES (N'4', N'Long', 13, N'SE1215')
INSERT [dbo].[Information] ([ID], [Name], [Age], [Class]) VALUES (N'1', N'hoan', 55, N'SE1211')
INSERT [dbo].[Information] ([ID], [Name], [Age], [Class]) VALUES (N'2', N'hoan', 55, N'SE1211')
INSERT [dbo].[Information] ([ID], [Name], [Age], [Class]) VALUES (N'6', N'hoangg', 55, N'SE1211')
INSERT [dbo].[Information] ([ID], [Name], [Age], [Class]) VALUES (N'3', N'hoangg', 5566, N'SE1211')
INSERT [dbo].[Information] ([ID], [Name], [Age], [Class]) VALUES (N'9', N'hoangg', 5566, N'SE1211')
INSERT [dbo].[Role_Feature] ([roleid], [featureid]) VALUES (1, 2)
INSERT [dbo].[Role_Feature] ([roleid], [featureid]) VALUES (1, 3)
INSERT [dbo].[Role_Feature] ([roleid], [featureid]) VALUES (1, 4)
INSERT [dbo].[Role_Feature] ([roleid], [featureid]) VALUES (2, 2)
INSERT [dbo].[Role_Feature] ([roleid], [featureid]) VALUES (3, 3)
INSERT [dbo].[Role_Feature] ([roleid], [featureid]) VALUES (3, 4)
INSERT [dbo].[Role_Feature] ([roleid], [featureid]) VALUES (4, 4)
INSERT [dbo].[Role_User] ([roleid], [username]) VALUES (1, N'mra')
INSERT [dbo].[Role_User] ([roleid], [username]) VALUES (2, N'mrb')
INSERT [dbo].[Role_User] ([roleid], [username]) VALUES (2, N'mrc')
INSERT [dbo].[Role_User] ([roleid], [username]) VALUES (3, N'mrc')
INSERT [dbo].[Role_User] ([roleid], [username]) VALUES (4, N'mrd')
INSERT [dbo].[Roles] ([roleid], [rolename]) VALUES (1, N'admin')
INSERT [dbo].[Roles] ([roleid], [rolename]) VALUES (2, N'supermod')
INSERT [dbo].[Roles] ([roleid], [rolename]) VALUES (3, N'mod')
INSERT [dbo].[Roles] ([roleid], [rolename]) VALUES (4, N'member')
INSERT [dbo].[Users] ([username], [password]) VALUES (N'mra', N'mra')
INSERT [dbo].[Users] ([username], [password]) VALUES (N'mrb', N'mrb')
INSERT [dbo].[Users] ([username], [password]) VALUES (N'mrc', N'mrc')
INSERT [dbo].[Users] ([username], [password]) VALUES (N'mrd', N'mrd')
ALTER TABLE [dbo].[Role_Feature]  WITH CHECK ADD  CONSTRAINT [FK_Role_Feature_Features] FOREIGN KEY([featureid])
REFERENCES [dbo].[Features] ([featureid])
GO
ALTER TABLE [dbo].[Role_Feature] CHECK CONSTRAINT [FK_Role_Feature_Features]
GO
ALTER TABLE [dbo].[Role_Feature]  WITH CHECK ADD  CONSTRAINT [FK_Role_Feature_Role] FOREIGN KEY([roleid])
REFERENCES [dbo].[Roles] ([roleid])
GO
ALTER TABLE [dbo].[Role_Feature] CHECK CONSTRAINT [FK_Role_Feature_Role]
GO
ALTER TABLE [dbo].[Role_User]  WITH CHECK ADD  CONSTRAINT [FK_Role_User_Role] FOREIGN KEY([roleid])
REFERENCES [dbo].[Roles] ([roleid])
GO
ALTER TABLE [dbo].[Role_User] CHECK CONSTRAINT [FK_Role_User_Role]
GO
ALTER TABLE [dbo].[Role_User]  WITH CHECK ADD  CONSTRAINT [FK_Role_User_Users] FOREIGN KEY([username])
REFERENCES [dbo].[Users] ([username])
GO
ALTER TABLE [dbo].[Role_User] CHECK CONSTRAINT [FK_Role_User_Users]
GO
