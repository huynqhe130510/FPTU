USE [StupidDB]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 9/25/2019 5:13:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Department](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 9/25/2019 5:13:39 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Employee](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
	[dob] [date] NOT NULL,
	[gender] [bit] NOT NULL,
	[did] [int] NOT NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Department] ([id], [name]) VALUES (1, N'Information System')
INSERT [dbo].[Department] ([id], [name]) VALUES (2, N'Computer Science')
INSERT [dbo].[Department] ([id], [name]) VALUES (3, N'Information Assurance')
INSERT [dbo].[Employee] ([id], [name], [dob], [gender], [did]) VALUES (1, N'A', CAST(0x37220B00 AS Date), 1, 1)
INSERT [dbo].[Employee] ([id], [name], [dob], [gender], [did]) VALUES (2, N'B', CAST(0x37220B00 AS Date), 0, 1)
INSERT [dbo].[Employee] ([id], [name], [dob], [gender], [did]) VALUES (3, N'C', CAST(0x37220B00 AS Date), 1, 2)
INSERT [dbo].[Employee] ([id], [name], [dob], [gender], [did]) VALUES (4, N'D', CAST(0x37220B00 AS Date), 0, 2)
INSERT [dbo].[Employee] ([id], [name], [dob], [gender], [did]) VALUES (5, N'E', CAST(0x37220B00 AS Date), 1, 3)
INSERT [dbo].[Employee] ([id], [name], [dob], [gender], [did]) VALUES (6, N'F', CAST(0x37220B00 AS Date), 1, 3)
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Department] FOREIGN KEY([did])
REFERENCES [dbo].[Department] ([id])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Department]
GO
