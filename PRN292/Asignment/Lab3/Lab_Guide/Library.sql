USE [Library]
GO
/****** Object:  Table [dbo].[Borrower]    Script Date: 10/14/2013 11:45:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Borrower](
	[borrowerNumber] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
	[sex] [char](1) NULL,
	[address] [nvarchar](50) NULL,
	[telephone] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_Borrower] PRIMARY KEY CLUSTERED 
(
	[borrowerNumber] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (1, N'Huong', N'F', N'', N'', N'')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (2, N'Kien', N'M', N'a2', N't2', N'e2')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (3, N'', N'F', N'', N'', N'')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (4, N' ', N'F', N' ', N' ', N' ')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (6, N'', N'A', N'', N'', N'')
/****** Object:  Table [dbo].[Book]    Script Date: 10/14/2013 11:45:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[bookNumber] [int] NOT NULL,
	[title] [nvarchar](50) NULL,
	[authors] [nvarchar](50) NULL,
	[publisher] [nvarchar](50) NULL,
 CONSTRAINT [PK_Book] PRIMARY KEY CLUSTERED 
(
	[bookNumber] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (1, N't1', N'a1', N'p1')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (2, N't2', N'a2', N'p2')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (3, N't3', N'a3', N'p3')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (6, N't6', N'a6', N'p6')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (7, N't7', N'a7', N'p7')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (8, N't8', N'a8', N'p8')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (9, N't9', N'', N'')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (10, N'Test', N'Andrew', N'Pub')
/****** Object:  Table [dbo].[Reservation]    Script Date: 10/14/2013 11:45:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Reservation](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[borrowerNumber] [int] NOT NULL,
	[bookNumber] [int] NOT NULL,
	[date] [datetime] NOT NULL,
	[status] [char](1) NULL,
 CONSTRAINT [PK_Reservation] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Reservation] ON
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (10, 2, 1, CAST(0x0000A24C00000000 AS DateTime), N'R')
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (11, 3, 1, CAST(0x0000A24C00000000 AS DateTime), N'R')
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (12, 1, 1, CAST(0x0000A24C00000000 AS DateTime), N'R')
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (16, 4, 9, CAST(0x0000A25300000000 AS DateTime), N'A')
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (17, 4, 9, CAST(0x0000A25300000000 AS DateTime), N'R')
SET IDENTITY_INSERT [dbo].[Reservation] OFF
/****** Object:  Table [dbo].[Copy]    Script Date: 10/14/2013 11:45:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Copy](
	[copyNumber] [int] NOT NULL,
	[bookNumber] [int] NOT NULL,
	[sequenceNumber] [int] NOT NULL,
	[type] [char](1) NULL,
	[price] [float] NULL,
 CONSTRAINT [PK_Copy] PRIMARY KEY CLUSTERED 
(
	[copyNumber] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (1, 2, 1, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (2, 2, 2, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (3, 2, 3, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (4, 1, 1, N'B', 100)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (5, 1, 2, N'A', 100)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (7, 2, 5, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (8, 2, 6, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (9, 2, 7, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (10, 2, 8, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (11, 1, 3, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (12, 6, 1, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (13, 6, 2, N'A', 100)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (14, 3, 1, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (15, 3, 2, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (17, 2, 9, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (18, 2, 1, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (19, 2, 2, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (20, 2, 2, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (23, 3, 1, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (24, 1, 4, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (25, 1, 5, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (26, 9, 1, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (27, 9, 2, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (28, 7, 1, N'A', 0)
/****** Object:  Table [dbo].[CirculatedCopy]    Script Date: 10/14/2013 11:45:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CirculatedCopy](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[copyNumber] [int] NOT NULL,
	[borrowerNumber] [int] NOT NULL,
	[borrowedDate] [datetime] NOT NULL,
	[dueDate] [datetime] NULL,
	[returnedDate] [datetime] NULL,
	[fineAmount] [float] NULL,
 CONSTRAINT [PK_CirculatedCopy] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[CirculatedCopy] ON
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (8, 1, 1, CAST(0x0000A24B00000000 AS DateTime), CAST(0x0000A25900000000 AS DateTime), CAST(0x0000A25F00000000 AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (9, 1, 1, CAST(0x0000A24B00000000 AS DateTime), CAST(0x0000A25900000000 AS DateTime), CAST(0x0000A26000000000 AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (10, 2, 1, CAST(0x0000A24B00000000 AS DateTime), CAST(0x0000A25900000000 AS DateTime), CAST(0x0000A25F00000000 AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (11, 2, 3, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (12, 4, 1, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), CAST(0x0000A26000000000 AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (13, 5, 1, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), CAST(0x0000A26000000000 AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (14, 4, 2, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (15, 1, 1, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), CAST(0x0000A26000000000 AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (16, 1, 1, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), CAST(0x0000A26000000000 AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (17, 7, 1, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (18, 9, 1, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (19, 10, 1, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (20, 12, 1, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (21, 13, 1, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), CAST(0x0000A26000000000 AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (22, 1, 1, CAST(0x0000A24C00000000 AS DateTime), CAST(0x0000A25A00000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (23, 3, 1, CAST(0x0000A24D00000000 AS DateTime), CAST(0x0000A25B00000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (24, 1, 1, CAST(0x0000A24E00000000 AS DateTime), CAST(0x0000A25C00000000 AS DateTime), CAST(0x0000A26200000000 AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (25, 3, 1, CAST(0x0000A24E00000000 AS DateTime), CAST(0x0000A25C00000000 AS DateTime), CAST(0x0000A26200000000 AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (26, 7, 1, CAST(0x0000A24E00000000 AS DateTime), CAST(0x0000A25C00000000 AS DateTime), CAST(0x0000A25D00000000 AS DateTime), 0)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (27, 8, 1, CAST(0x0000A24E00000000 AS DateTime), CAST(0x0000A25C00000000 AS DateTime), CAST(0x0000A25300000000 AS DateTime), 0)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (28, 9, 1, CAST(0x0000A24E00000000 AS DateTime), CAST(0x0000A25C00000000 AS DateTime), CAST(0x0000A26200000000 AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (29, 9, 1, CAST(0x0000A24E00000000 AS DateTime), CAST(0x0000A25C00000000 AS DateTime), CAST(0x0000A25300000000 AS DateTime), 0)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (30, 10, 1, CAST(0x0000A25300000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), CAST(0x0000A25300000000 AS DateTime), 0)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (31, 13, 1, CAST(0x0000A25300000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), CAST(0x0000A25300000000 AS DateTime), 0)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (32, 15, 2, CAST(0x0000A25300000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (33, 17, 2, CAST(0x0000A25300000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (34, 19, 2, CAST(0x0000A25300000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (35, 3, 3, CAST(0x0000A25D00000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (36, 12, 3, CAST(0x0000A25D00000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (37, 13, 3, CAST(0x0000A25D00000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (38, 18, 3, CAST(0x0000A25D00000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (39, 20, 1, CAST(0x0000A25300000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (40, 26, 1, CAST(0x0000A25D00000000 AS DateTime), CAST(0x0000A26B00000000 AS DateTime), CAST(0x0000A25300000000 AS DateTime), 0)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (41, 27, 1, CAST(0x0000A25D00000000 AS DateTime), CAST(0x0000A26B00000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (42, 26, 4, CAST(0x0000A25300000000 AS DateTime), CAST(0x0000A26100000000 AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (43, 9, 1, CAST(0x0000A25D00000000 AS DateTime), CAST(0x0000A26B00000000 AS DateTime), NULL, NULL)
SET IDENTITY_INSERT [dbo].[CirculatedCopy] OFF
/****** Object:  ForeignKey [FK_Reservation_Book]    Script Date: 10/14/2013 11:45:56 ******/
ALTER TABLE [dbo].[Reservation]  WITH CHECK ADD  CONSTRAINT [FK_Reservation_Book] FOREIGN KEY([bookNumber])
REFERENCES [dbo].[Book] ([bookNumber])
GO
ALTER TABLE [dbo].[Reservation] CHECK CONSTRAINT [FK_Reservation_Book]
GO
/****** Object:  ForeignKey [FK_Reservation_Borrower]    Script Date: 10/14/2013 11:45:56 ******/
ALTER TABLE [dbo].[Reservation]  WITH CHECK ADD  CONSTRAINT [FK_Reservation_Borrower] FOREIGN KEY([borrowerNumber])
REFERENCES [dbo].[Borrower] ([borrowerNumber])
GO
ALTER TABLE [dbo].[Reservation] CHECK CONSTRAINT [FK_Reservation_Borrower]
GO
/****** Object:  ForeignKey [FK_Copy_Book]    Script Date: 10/14/2013 11:45:56 ******/
ALTER TABLE [dbo].[Copy]  WITH CHECK ADD  CONSTRAINT [FK_Copy_Book] FOREIGN KEY([bookNumber])
REFERENCES [dbo].[Book] ([bookNumber])
GO
ALTER TABLE [dbo].[Copy] CHECK CONSTRAINT [FK_Copy_Book]
GO
/****** Object:  ForeignKey [FK_CirculatedCopy_Borrower]    Script Date: 10/14/2013 11:45:56 ******/
ALTER TABLE [dbo].[CirculatedCopy]  WITH CHECK ADD  CONSTRAINT [FK_CirculatedCopy_Borrower] FOREIGN KEY([borrowerNumber])
REFERENCES [dbo].[Borrower] ([borrowerNumber])
GO
ALTER TABLE [dbo].[CirculatedCopy] CHECK CONSTRAINT [FK_CirculatedCopy_Borrower]
GO
/****** Object:  ForeignKey [FK_CirculatedCopy_Copy]    Script Date: 10/14/2013 11:45:56 ******/
ALTER TABLE [dbo].[CirculatedCopy]  WITH CHECK ADD  CONSTRAINT [FK_CirculatedCopy_Copy] FOREIGN KEY([copyNumber])
REFERENCES [dbo].[Copy] ([copyNumber])
GO
ALTER TABLE [dbo].[CirculatedCopy] CHECK CONSTRAINT [FK_CirculatedCopy_Copy]
GO
