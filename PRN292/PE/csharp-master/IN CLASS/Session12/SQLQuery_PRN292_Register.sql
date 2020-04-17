USE [PRN292]
GO

/****** Object:  Table [dbo].[Register]    Script Date: 2/15/2019 8:07:38 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Register](
	[MemberCode] [nchar](20) NULL,
	[Name] [nchar](200) NULL,
	[Sex] [nchar](10) NULL,
	[Address] [nchar](200) NULL,
	[Telephone] [nchar](20) NULL,
	[Email] [nchar](100) NULL
) ON [PRIMARY]

GO

