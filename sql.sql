USE [master]
GO
/****** Object:  Database [EShop]    Script Date: 5/6/2020 2:20:34 PM ******/
CREATE DATABASE [EShop]
CREATE TABLE [dbo].[Content](
	[ID] [bigint] NOT NULL,
	[Name] [nvarchar](250) NOT NULL,
	[MetaTitle] [nvarchar](250) NULL,
	[Description] [nvarchar](500) NULL,
	[Image] [nvarchar](250) NULL,
	[CategoryID] [bigint] NULL,
	[Detail] [ntext] NULL,
	[Warranty] [int] NULL,
	[CreateDate] [datetime] NULL,
	[CreateBy] [nvarchar](50) NULL,
	[ModifiedDate] [datetime] NULL,
	[ModifiedBy] [nvarchar](50) NULL,
	[MetaKeywords] [nchar](250) NULL,
	[MetaDescriptions] [nchar](250) NULL,
	[Status] [bit] NULL,
	[TopHot] [datetime] NULL,
	[ViewCount] [int] NULL,
	[Tags] [nvarchar](500) NULL,
	[Language] [varchar](2) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ContentCategory]    Script Date: 5/6/2020 2:20:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ContentCategory](
	[ID] [bigint] NULL,
	[Name] [nvarchar](250) NULL,
	[ParentID] [bigint] NULL,
	[MetaTitle] [varchar](250) NULL,
	[SeoTitle] [nvarchar](250) NULL,
	[DisplayOrder] [int] NULL,
	[CreateDate] [datetime] NULL,
	[CreateBy] [nvarchar](50) NULL,
	[ModifiedDate] [datetime] NULL,
	[ModifiedBy] [nvarchar](50) NULL,
	[MetaKeyWords] [nvarchar](250) NULL,
	[MetaDescriptions] [nchar](250) NULL,
	[Status] [bit] NULL,
	[ShowOnHome] [bit] NULL,
	[Language] [varchar](2) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ContentTag]    Script Date: 5/6/2020 2:20:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContentTag](
	[ContentID] [bigint] NULL,
	[TagID] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tag]    Script Date: 5/6/2020 2:20:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tag](
	[TagID] [nvarchar](50) NOT NULL,
	[TagName] [nvarchar](30) NOT NULL,
 CONSTRAINT [PK_Tag] PRIMARY KEY CLUSTERED 
(
	[TagID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
USE [master]
GO
ALTER DATABASE [EShop] SET  READ_WRITE 
GO
