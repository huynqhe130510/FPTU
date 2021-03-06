USE [Quizz]
GO
/****** Object:  Table [dbo].[usertype]    Script Date: 03/05/2020 15:24:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usertype](
	[id] [int] NOT NULL,
	[name] [nvarchar](150) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[usertype] ([id], [name]) VALUES (1, N'teacher')
INSERT [dbo].[usertype] ([id], [name]) VALUES (2, N'normal user')
/****** Object:  Table [dbo].[user]    Script Date: 03/05/2020 15:24:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](150) NULL,
	[password] [nvarchar](150) NULL,
	[typeid] [int] NULL,
	[email] [nvarchar](150) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[user] ON
INSERT [dbo].[user] ([id], [username], [password], [typeid], [email]) VALUES (1, N'admin', N'123', 1, NULL)
INSERT [dbo].[user] ([id], [username], [password], [typeid], [email]) VALUES (2, N'hieunq', N'123', 2, N'hieunqhe130518@fpt.edu.vn')
INSERT [dbo].[user] ([id], [username], [password], [typeid], [email]) VALUES (3, N'huynq', N'123', 2, N'huynqhe130510@fpt.edu.vn')
INSERT [dbo].[user] ([id], [username], [password], [typeid], [email]) VALUES (4, N'abc', N'123', 1, N'abc123@gmail.com')
INSERT [dbo].[user] ([id], [username], [password], [typeid], [email]) VALUES (5, N'thuhang', N'123', 1, N'quanghuy24121999@gmail.com')
SET IDENTITY_INSERT [dbo].[user] OFF
/****** Object:  Table [dbo].[questions]    Script Date: 03/05/2020 15:24:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[questions](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [nvarchar](max) NULL,
	[option_1] [nvarchar](max) NULL,
	[option_2] [nvarchar](max) NULL,
	[option_3] [nvarchar](max) NULL,
	[option_4] [nvarchar](max) NULL,
	[answer] [nvarchar](50) NULL,
	[created_date] [date] NULL,
	[teacher_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[questions] ON
INSERT [dbo].[questions] ([id], [question], [option_1], [option_2], [option_3], [option_4], [answer], [created_date], [teacher_id]) VALUES (1, N'What''s your name?', N'a', N'b', N'c', N'd', N'3', CAST(0xD0400B00 AS Date), 1)
INSERT [dbo].[questions] ([id], [question], [option_1], [option_2], [option_3], [option_4], [answer], [created_date], [teacher_id]) VALUES (7, N'1+2=?', N'1', N'2', N'3', N'4', N'3', CAST(0xCE400B00 AS Date), 1)
INSERT [dbo].[questions] ([id], [question], [option_1], [option_2], [option_3], [option_4], [answer], [created_date], [teacher_id]) VALUES (10, N'1+1=?', N'1', N'2', N'3', N'4', N'2', CAST(0xD0400B00 AS Date), 4)
INSERT [dbo].[questions] ([id], [question], [option_1], [option_2], [option_3], [option_4], [answer], [created_date], [teacher_id]) VALUES (11, N'How old are you ?', N'1', N'7', N'20', N'9', N'3', CAST(0xCE400B00 AS Date), 4)
INSERT [dbo].[questions] ([id], [question], [option_1], [option_2], [option_3], [option_4], [answer], [created_date], [teacher_id]) VALUES (13, N'Where are you from ?', N'HN', N'BN', N'abc', N'xxx', N'2', CAST(0xD0400B00 AS Date), 1)
INSERT [dbo].[questions] ([id], [question], [option_1], [option_2], [option_3], [option_4], [answer], [created_date], [teacher_id]) VALUES (14, N'2*4 = ?', N'?', N'6', N'8', N'3', N'1,3', CAST(0xCF400B00 AS Date), 1)
INSERT [dbo].[questions] ([id], [question], [option_1], [option_2], [option_3], [option_4], [answer], [created_date], [teacher_id]) VALUES (15, N'2:1 = ?', N'1', N'2', N'3', N'4', N'2', CAST(0xCF400B00 AS Date), 1)
INSERT [dbo].[questions] ([id], [question], [option_1], [option_2], [option_3], [option_4], [answer], [created_date], [teacher_id]) VALUES (16, N'3+3=?', N'?', N'1', N'2', N'6', N'1,4', CAST(0xCF400B00 AS Date), 1)
SET IDENTITY_INSERT [dbo].[questions] OFF
/****** Object:  ForeignKey [FK__questions__teach__0F975522]    Script Date: 03/05/2020 15:24:09 ******/
ALTER TABLE [dbo].[questions]  WITH CHECK ADD FOREIGN KEY([teacher_id])
REFERENCES [dbo].[user] ([id])
GO
/****** Object:  ForeignKey [FK__user__typeid__108B795B]    Script Date: 03/05/2020 15:24:09 ******/
ALTER TABLE [dbo].[user]  WITH CHECK ADD FOREIGN KEY([typeid])
REFERENCES [dbo].[usertype] ([id])
GO
