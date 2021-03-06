USE [master]
GO
/****** Object:  Database [EShop]    Script Date: 5/17/2020 4:24:30 PM ******/
CREATE DATABASE [EShop]
 CONTAINMENT = NONE
GO
ALTER DATABASE [EShop] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [EShop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [EShop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [EShop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [EShop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [EShop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [EShop] SET ARITHABORT OFF 
GO
ALTER DATABASE [EShop] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [EShop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [EShop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [EShop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [EShop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [EShop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [EShop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [EShop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [EShop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [EShop] SET  DISABLE_BROKER 
GO
ALTER DATABASE [EShop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [EShop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [EShop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [EShop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [EShop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [EShop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [EShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [EShop] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [EShop] SET  MULTI_USER 
GO
ALTER DATABASE [EShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [EShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [EShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [EShop] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [EShop] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'EShop', N'ON'
GO
ALTER DATABASE [EShop] SET QUERY_STORE = OFF
GO
USE [EShop]
GO
/****** Object:  Table [dbo].[Attribute]    Script Date: 5/17/2020 4:24:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Attribute](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AttributeValue]    Script Date: 5/17/2020 4:24:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AttributeValue](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[AttributeID] [int] NOT NULL,
	[Name] [nvarchar](500) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Catalog]    Script Date: 5/17/2020 4:24:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Catalog](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ParentID] [int] NULL,
	[SEOTitle] [nvarchar](500) NULL,
	[SEOUrl] [nvarchar](500) NULL,
	[SEODescription] [nvarchar](500) NULL,
	[CreatedDate] [datetime2](7) NULL,
	[CreatedBy] [nvarchar](50) NULL,
	[ModifiedDate] [datetime2](7) NULL,
	[ModifiedBy] [nvarchar](50) NULL,
	[Name] [nvarchar](250) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Content]    Script Date: 5/17/2020 4:24:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
/****** Object:  Table [dbo].[ContentCategory]    Script Date: 5/17/2020 4:24:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[ContentTag]    Script Date: 5/17/2020 4:24:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContentTag](
	[ContentID] [bigint] NULL,
	[TagID] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Image]    Script Date: 5/17/2020 4:24:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Image](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Url] [nvarchar](500) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 5/17/2020 4:24:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ApplyPromotion] [bit] NOT NULL,
	[CatalogID] [bigint] NOT NULL,
	[Content] [nvarchar](max) NULL,
	[CreatedBy] [nvarchar](50) NULL,
	[CreatedDate] [datetime2](7) NULL,
	[Deliver] [bit] NOT NULL,
	[Description] [nvarchar](500) NULL,
	[ModifiedBy] [nvarchar](50) NULL,
	[ModifiedDate] [datetime2](7) NULL,
	[Name] [nvarchar](500) NOT NULL,
	[OriginalPrice] [decimal](18, 0) NULL,
	[SEODescription] [nvarchar](500) NULL,
	[SEOTitle] [nvarchar](500) NULL,
	[SEOUrl] [nvarchar](500) NULL,
	[Url] [nvarchar](250) NULL,
	[Weight] [int] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductVersionImage]    Script Date: 5/17/2020 4:24:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductVersionImage](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ImageID] [int] NOT NULL,
	[ProductVersionID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductVersions]    Script Date: 5/17/2020 4:24:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductVersions](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ProductID] [int] NOT NULL,
	[Description] [nvarchar](500) NULL,
	[Price] [decimal](18, 0) NOT NULL,
	[Quantum] [int] NOT NULL,
	[RemainingAmount] [int] NOT NULL,
	[SKU] [nvarchar](250) NULL,
	[Barcode] [nvarchar](250) NULL,
	[WareHouseID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tag]    Script Date: 5/17/2020 4:24:30 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Attribute] ON 

INSERT [dbo].[Attribute] ([ID], [Name]) VALUES (1, N'Màu sắc')
INSERT [dbo].[Attribute] ([ID], [Name]) VALUES (2, N'Dung lượng')
SET IDENTITY_INSERT [dbo].[Attribute] OFF
SET IDENTITY_INSERT [dbo].[AttributeValue] ON 

INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (1, 1, N'Đỏ')
INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (2, 1, N'Cam')
INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (3, 1, N'Vàng')
INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (4, 2, N'8gb')
INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (5, 2, N'16gb')
INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (6, 2, N'32gb')
INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (7, 2, N'128gb')
SET IDENTITY_INSERT [dbo].[AttributeValue] OFF
SET IDENTITY_INSERT [dbo].[Catalog] ON 

INSERT [dbo].[Catalog] ([ID], [ParentID], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Name]) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Điện thoại')
INSERT [dbo].[Catalog] ([ID], [ParentID], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Name]) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Laptop')
INSERT [dbo].[Catalog] ([ID], [ParentID], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Name]) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Phụ kiện')
INSERT [dbo].[Catalog] ([ID], [ParentID], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Name]) VALUES (4, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Samsung')
INSERT [dbo].[Catalog] ([ID], [ParentID], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Name]) VALUES (5, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Iphone')
INSERT [dbo].[Catalog] ([ID], [ParentID], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Name]) VALUES (6, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Macbook')
SET IDENTITY_INSERT [dbo].[Catalog] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ID], [ApplyPromotion], [CatalogID], [Content], [CreatedBy], [CreatedDate], [Deliver], [Description], [ModifiedBy], [ModifiedDate], [Name], [OriginalPrice], [SEODescription], [SEOTitle], [SEOUrl], [Url], [Weight]) VALUES (1, 1, 0, N'This is an iphone', NULL, NULL, 1, N'no discrip', NULL, NULL, N'Iphone test', NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Product] ([ID], [ApplyPromotion], [CatalogID], [Content], [CreatedBy], [CreatedDate], [Deliver], [Description], [ModifiedBy], [ModifiedDate], [Name], [OriginalPrice], [SEODescription], [SEOTitle], [SEOUrl], [Url], [Weight]) VALUES (2, 1, 0, N'This is a samsung', NULL, NULL, 1, N'no discrip', NULL, NULL, N'samsung galaxy test', NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Product] ([ID], [ApplyPromotion], [CatalogID], [Content], [CreatedBy], [CreatedDate], [Deliver], [Description], [ModifiedBy], [ModifiedDate], [Name], [OriginalPrice], [SEODescription], [SEOTitle], [SEOUrl], [Url], [Weight]) VALUES (25, 0, 0, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'', NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Product] ([ID], [ApplyPromotion], [CatalogID], [Content], [CreatedBy], [CreatedDate], [Deliver], [Description], [ModifiedBy], [ModifiedDate], [Name], [OriginalPrice], [SEODescription], [SEOTitle], [SEOUrl], [Url], [Weight]) VALUES (26, 0, 0, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'', NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Product] ([ID], [ApplyPromotion], [CatalogID], [Content], [CreatedBy], [CreatedDate], [Deliver], [Description], [ModifiedBy], [ModifiedDate], [Name], [OriginalPrice], [SEODescription], [SEOTitle], [SEOUrl], [Url], [Weight]) VALUES (27, 0, 0, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'', NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Product] ([ID], [ApplyPromotion], [CatalogID], [Content], [CreatedBy], [CreatedDate], [Deliver], [Description], [ModifiedBy], [ModifiedDate], [Name], [OriginalPrice], [SEODescription], [SEOTitle], [SEOUrl], [Url], [Weight]) VALUES (28, 0, 0, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'', NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Product] ([ID], [ApplyPromotion], [CatalogID], [Content], [CreatedBy], [CreatedDate], [Deliver], [Description], [ModifiedBy], [ModifiedDate], [Name], [OriginalPrice], [SEODescription], [SEOTitle], [SEOUrl], [Url], [Weight]) VALUES (29, 0, 0, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'', NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Product] ([ID], [ApplyPromotion], [CatalogID], [Content], [CreatedBy], [CreatedDate], [Deliver], [Description], [ModifiedBy], [ModifiedDate], [Name], [OriginalPrice], [SEODescription], [SEOTitle], [SEOUrl], [Url], [Weight]) VALUES (30, 0, 0, N'content', NULL, NULL, 1, N'discrip', NULL, NULL, N'no name', CAST(100000 AS Decimal(18, 0)), NULL, NULL, NULL, NULL, 100)
SET IDENTITY_INSERT [dbo].[Product] OFF
USE [master]
GO
ALTER DATABASE [EShop] SET  READ_WRITE 
GO
