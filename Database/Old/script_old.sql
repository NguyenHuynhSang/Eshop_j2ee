USE [master]
GO
/****** Object:  Database [Bt2]    Script Date: 6/30/2020 7:31:18 PM ******/
CREATE DATABASE [Bt2]
 CONTAINMENT = NONE
GO
ALTER DATABASE [Bt2] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Bt2].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Bt2] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Bt2] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Bt2] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Bt2] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Bt2] SET ARITHABORT OFF 
GO
ALTER DATABASE [Bt2] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Bt2] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Bt2] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Bt2] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Bt2] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Bt2] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Bt2] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Bt2] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Bt2] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Bt2] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Bt2] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Bt2] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Bt2] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Bt2] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Bt2] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Bt2] SET READ_COMMITTED_SNAPSHOT ON 
GO
ALTER DATABASE [Bt2] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Bt2] SET RECOVERY FULL 
GO
ALTER DATABASE [Bt2] SET  MULTI_USER 
GO
ALTER DATABASE [Bt2] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Bt2] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Bt2] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Bt2] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Bt2] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Bt2', N'ON'
GO
ALTER DATABASE [Bt2] SET QUERY_STORE = OFF
GO
USE [Bt2]
GO
/****** Object:  Table [dbo].[__EFMigrationsHistory]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[__EFMigrationsHistory](
	[MigrationId] [nvarchar](150) NOT NULL,
	[ProductVersion] [nvarchar](32) NOT NULL,
 CONSTRAINT [PK___EFMigrationsHistory] PRIMARY KEY CLUSTERED 
(
	[MigrationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Attribute]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Attribute](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NULL,
 CONSTRAINT [PK_Attribute] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AttributeValue]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AttributeValue](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[AttributeID] [int] NOT NULL,
	[Name] [nvarchar](500) NULL,
 CONSTRAINT [PK_AttributeValue] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BlogCategories]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BlogCategories](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NULL,
 CONSTRAINT [PK_BlogCategories] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Catalog]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Catalog](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ParentID] [int] NULL,
	[Name] [nvarchar](500) NULL,
	[SEOTitle] [nvarchar](500) NULL,
	[SEOUrl] [nvarchar](500) NULL,
	[SEODescription] [nvarchar](500) NULL,
	[CreatedDate] [datetime2](7) NULL,
	[CreatedBy] [nvarchar](50) NULL,
	[ModifiedDate] [datetime2](7) NULL,
	[ModifiedBy] [nvarchar](50) NULL,
 CONSTRAINT [PK_Catalog] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Content]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Content](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](250) NOT NULL,
	[MetaTitle] [nvarchar](250) NULL,
	[Description] [nvarchar](500) NULL,
	[Image] [nvarchar](250) NULL,
	[CategoryID] [bigint] NOT NULL,
	[Detail] [ntext] NULL,
	[Warranty] [int] NOT NULL,
	[CreatedDate] [datetime2](7) NULL,
	[CreatedBy] [nvarchar](50) NULL,
	[ModifiedDate] [datetime2](7) NULL,
	[ModifiedBy] [nvarchar](50) NULL,
	[MetaKeywords] [nvarchar](250) NULL,
	[MetaDescriptions] [nvarchar](250) NULL,
	[Status] [bit] NOT NULL,
	[TopHot] [datetime2](7) NOT NULL,
	[ViewCount] [int] NOT NULL,
	[Tags] [nvarchar](500) NULL,
	[Language] [nvarchar](2) NULL,
	[SEODescription] [nvarchar](500) NULL,
	[SEOTitle] [nvarchar](500) NULL,
	[SEOUrl] [nvarchar](500) NULL,
 CONSTRAINT [PK_Content] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ContentCategory]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContentCategory](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](250) NULL,
	[MetaTitle] [nvarchar](250) NULL,
	[ParentID] [bigint] NOT NULL,
	[DisplayOrder] [int] NOT NULL,
	[SEOTitle] [nvarchar](500) NULL,
	[CreatedDate] [datetime2](7) NULL,
	[CreatedBy] [nvarchar](50) NULL,
	[ModifiedDate] [datetime2](7) NULL,
	[ModifiedBy] [nvarchar](50) NULL,
	[MetaKeywords] [nvarchar](250) NULL,
	[MetaDescriptions] [nvarchar](250) NULL,
	[Status] [bit] NOT NULL,
	[ShowOnHome] [bit] NOT NULL,
	[Language] [nvarchar](2) NULL,
	[SEODescription] [nvarchar](500) NULL,
	[SEOUrl] [nvarchar](500) NULL,
 CONSTRAINT [PK_ContentCategory] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ContentTag]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContentTag](
	[ContentID] [bigint] NOT NULL,
	[TagID] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ContentTag] PRIMARY KEY CLUSTERED 
(
	[TagID] ASC,
	[ContentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Error]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Error](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Message] [nvarchar](max) NULL,
	[StackTrace] [nvarchar](max) NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_Error] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Footer]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Footer](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Content] [ntext] NULL,
	[IsShow] [bit] NULL,
 CONSTRAINT [PK_Footer] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Image]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Image](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Url] [nvarchar](500) NULL,
 CONSTRAINT [PK_Image] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[News]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[News](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Content] [nvarchar](max) NULL,
	[categoryID] [int] NOT NULL,
 CONSTRAINT [PK_News] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CatalogID] [bigint] NOT NULL,
	[Url] [nvarchar](250) NULL,
	[Name] [nvarchar](500) NOT NULL,
	[Description] [nvarchar](500) NULL,
	[Content] [nvarchar](max) NULL,
	[CreatedDate] [datetime2](7) NULL,
	[CreatedBy] [nvarchar](50) NULL,
	[ModifiedDate] [datetime2](7) NULL,
	[ModifiedBy] [nvarchar](50) NULL,
	[Weight] [int] NOT NULL,
	[OriginalPrice] [decimal](18, 0) NULL,
	[Deliver] [bit] NOT NULL,
	[SEOTitle] [nvarchar](500) NULL,
	[SEOUrl] [nvarchar](500) NULL,
	[SEODescription] [nvarchar](500) NULL,
	[ApplyPromotion] [bit] NOT NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductAttribute]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductAttribute](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[AttributeValueID] [int] NOT NULL,
	[ProductVersionID] [int] NOT NULL,
 CONSTRAINT [PK_ProductAttribute] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductVersionImage]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductVersionImage](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ProductVersionID] [int] NOT NULL,
	[IsMain] [bit] NOT NULL,
	[Url] [nvarchar](max) NULL,
 CONSTRAINT [PK_ProductVersionImage] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductVersions]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductVersions](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ProductID] [int] NOT NULL,
	[WareHouseID] [int] NOT NULL,
	[Description] [nvarchar](500) NULL,
	[Price] [decimal](18, 0) NOT NULL,
	[Quantum] [int] NOT NULL,
	[RemainingAmount] [int] NOT NULL,
	[SKU] [nvarchar](250) NULL,
	[Barcode] [nvarchar](250) NULL,
	[PromotionPrice] [decimal](18, 0) NULL,
 CONSTRAINT [PK_ProductVersions] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Photos]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Photos](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Url] [nvarchar](max) NULL,
	[Description] [nvarchar](max) NULL,
	[DateAdded] [datetime2](7) NOT NULL,
	[IsMain] [bit] NOT NULL,
	[PublicId] [nvarchar](max) NULL,
	[UserId] [int] NOT NULL,
 CONSTRAINT [PK_Photos] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Slide]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Slide](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Image] [nvarchar](500) NULL,
	[Url] [nvarchar](500) NULL,
	[IsShow] [bit] NULL,
	[ModifiedBy] [nvarchar](50) NULL,
	[CreatedDate] [datetime2](7) NULL,
	[CreatedBy] [nvarchar](50) NULL,
	[ModifiedDate] [datetime2](7) NULL,
 CONSTRAINT [PK_Slide] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tag]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tag](
	[ID] [nvarchar](50) NOT NULL,
	[TagtName] [nvarchar](50) NULL,
 CONSTRAINT [PK_Tag] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 6/30/2020 7:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](max) NULL,
	[PasswordHash] [varbinary](max) NULL,
	[PasswordSalt] [varbinary](max) NULL,
	[Gender] [nvarchar](max) NULL,
	[DateOfBirth] [datetime2](7) NOT NULL,
	[KnownAs] [nvarchar](max) NULL,
	[Created] [datetime2](7) NOT NULL,
	[LastActive] [datetime2](7) NOT NULL,
	[Introduction] [nvarchar](max) NULL,
	[LookingFor] [nvarchar](max) NULL,
	[Interests] [nvarchar](max) NULL,
	[City] [nvarchar](max) NULL,
	[Country] [nvarchar](max) NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[__EFMigrationsHistory] ([MigrationId], [ProductVersion]) VALUES (N'20200603042802_InitialModel', N'3.1.3')
INSERT [dbo].[__EFMigrationsHistory] ([MigrationId], [ProductVersion]) VALUES (N'20200608161715_add_table_users_and_photos', N'3.1.3')
INSERT [dbo].[__EFMigrationsHistory] ([MigrationId], [ProductVersion]) VALUES (N'20200611111140_seed_productVersion', N'3.1.3')
INSERT [dbo].[__EFMigrationsHistory] ([MigrationId], [ProductVersion]) VALUES (N'20200611140840_change_table_ProductVersionImage', N'3.1.3')
INSERT [dbo].[__EFMigrationsHistory] ([MigrationId], [ProductVersion]) VALUES (N'20200611141835_add_table_ProductAttributeValues', N'3.1.3')
INSERT [dbo].[__EFMigrationsHistory] ([MigrationId], [ProductVersion]) VALUES (N'20200612125529_fix_audit_table_content', N'3.1.3')
INSERT [dbo].[__EFMigrationsHistory] ([MigrationId], [ProductVersion]) VALUES (N'20200612125807_fix_col_creactedDate_default_value', N'3.1.3')
INSERT [dbo].[__EFMigrationsHistory] ([MigrationId], [ProductVersion]) VALUES (N'20200612125853_fix_col_creactedDate_default_value2', N'3.1.3')
INSERT [dbo].[__EFMigrationsHistory] ([MigrationId], [ProductVersion]) VALUES (N'20200614103908_rename_table_category_toBlogCategory_catalog_toProductCatalog', N'3.1.3')
SET IDENTITY_INSERT [dbo].[Attribute] ON 

INSERT [dbo].[Attribute] ([ID], [Name]) VALUES (1, N'Màu sắc')
INSERT [dbo].[Attribute] ([ID], [Name]) VALUES (2, N'Dung lượng')
SET IDENTITY_INSERT [dbo].[Attribute] OFF
SET IDENTITY_INSERT [dbo].[AttributeValue] ON 

INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (1, 1, N'Đỏ')
INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (2, 1, N'Xanh')
INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (3, 1, N'Tím')
INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (4, 2, N'16gb')
INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (5, 2, N'32gb')
INSERT [dbo].[AttributeValue] ([ID], [AttributeID], [Name]) VALUES (6, 2, N'64gb')
SET IDENTITY_INSERT [dbo].[AttributeValue] OFF
SET IDENTITY_INSERT [dbo].[Catalog] ON 

INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (1, NULL, N'Điện thoại', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (2, NULL, N'Laptop', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (3, 1, N'Samsung', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (4, 1, N'Apple', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (5, 2, N'Macbook', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (10, 0, N'Nokia', NULL, NULL, NULL, CAST(N'2020-06-12T16:16:51.0000000' AS DateTime2), NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (11, 1, N'Nokia', NULL, NULL, NULL, CAST(N'2020-06-12T16:26:03.0000000' AS DateTime2), NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (12, 1, N'Ha', NULL, NULL, NULL, CAST(N'2020-06-12T16:27:04.0000000' AS DateTime2), NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (13, 1, N'Nokiaa', NULL, NULL, NULL, CAST(N'2020-06-12T16:28:06.0000000' AS DateTime2), NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (14, 1, N'Nokiaasds', NULL, NULL, NULL, CAST(N'2020-06-12T16:29:24.0000000' AS DateTime2), NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (15, 1, N'Nokiaa', NULL, NULL, NULL, CAST(N'2020-06-12T16:29:24.0000000' AS DateTime2), NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (16, 0, N'cvcv', NULL, NULL, NULL, CAST(N'2020-06-12T16:31:14.0000000' AS DateTime2), NULL, NULL, NULL)
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (17, 1, N'Nokiaadsds', NULL, NULL, NULL, CAST(N'2020-06-12T16:31:25.0000000' AS DateTime2), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Catalog] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (1, 1, NULL, N'Iphone test', N'no discrip', N'This is an iphone', NULL, NULL, NULL, NULL, 0, CAST(16000000 AS Decimal(18, 0)), 1, NULL, NULL, NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (2, 1, NULL, N'samsung galaxy test', N'no discrip', N'This is a samsung', NULL, NULL, NULL, NULL, 0, CAST(14000000 AS Decimal(18, 0)), 1, NULL, NULL, NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (4, 2, N'string', N'Macbook Pro 2019', N'Bản nâng cấp mới', N'Bài giới thiệu', CAST(N'2020-06-11T21:23:03.9923668' AS DateTime2), N'string', CAST(N'2020-06-11T14:20:16.9940000' AS DateTime2), N'string', 110, CAST(40000000 AS Decimal(18, 0)), 1, N'string', N'string', N'string', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (5, 0, N'string', N'string', N'string', N'string', CAST(N'2020-06-11T22:27:01.0403248' AS DateTime2), N'string', CAST(N'2020-06-11T15:26:58.3800000' AS DateTime2), N'string', 0, CAST(0 AS Decimal(18, 0)), 1, N'string', N'string', N'string', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (6, 0, N'string', N'string', N'string', N'string', CAST(N'2020-06-22T15:17:12.8534766' AS DateTime2), N'string', CAST(N'2020-06-22T08:17:10.1170000' AS DateTime2), N'string', 0, CAST(0 AS Decimal(18, 0)), 1, N'string', N'string', N'string', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (7, 14, NULL, N'Samsumg lA', N'', NULL, CAST(N'2020-06-30T17:11:14.0000000' AS DateTime2), NULL, NULL, NULL, 123, CAST(12312311 AS Decimal(18, 0)), 1, N'123', N'samsumg-la', N'ewqe', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (8, 14, NULL, N'Samsumg A80', N'<p>sản phẩm</p>
', N'<p>giới thiệu</p>
', CAST(N'2020-06-30T17:18:51.0000000' AS DateTime2), NULL, NULL, NULL, 10000, CAST(12 AS Decimal(18, 0)), 1, N'seo title', N'samsumg-a80', N'des', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (9, 14, NULL, N'Samsumg A100', N'<p>sản phẩm</p>
', N'<p>giới thiệu</p>
', CAST(N'2020-06-30T17:27:40.0000000' AS DateTime2), NULL, NULL, NULL, 10000, CAST(12 AS Decimal(18, 0)), 1, N'seo title', N'samsumg-a100', N'des', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (11, 0, NULL, N'ty45', N'', NULL, CAST(N'2020-06-30T17:37:27.0000000' AS DateTime2), NULL, NULL, NULL, 0, CAST(123 AS Decimal(18, 0)), 1, NULL, N'ty45', NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (12, 0, NULL, N'ádsadsafegwretwer', N'', NULL, CAST(N'2020-06-30T17:40:22.0000000' AS DateTime2), NULL, NULL, NULL, 0, CAST(0 AS Decimal(18, 0)), 1, NULL, N'adsadsafegwretwer', NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (13, 0, NULL, N'sdasd', N'<p>qưeq</p>
', N'<p>1231</p>
', CAST(N'2020-06-30T17:42:10.0000000' AS DateTime2), NULL, NULL, NULL, 0, CAST(0 AS Decimal(18, 0)), 1, NULL, N'sdasd', NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (15, 0, NULL, N'asdsds', N'<p>sdsd</p>
', N'<p>sdsd</p>
', CAST(N'2020-06-30T17:45:54.0000000' AS DateTime2), NULL, NULL, NULL, 878, CAST(0 AS Decimal(18, 0)), 1, NULL, N'asdsds', N'sds', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (16, 0, NULL, N'asdsds9890', N'<p>sdsd</p>
', N'<p>sdsd</p>
', CAST(N'2020-06-30T17:49:58.0000000' AS DateTime2), NULL, NULL, NULL, 878, CAST(0 AS Decimal(18, 0)), 1, NULL, N'asdsds9890', N'sds', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (17, 0, NULL, N'asdsds989098089', N'<p>sdsd</p>
', N'<p>sdsd</p>
', CAST(N'2020-06-30T17:52:02.0000000' AS DateTime2), NULL, NULL, NULL, 878, CAST(0 AS Decimal(18, 0)), 1, NULL, N'asdsds989098089', N'sds', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (18, 0, NULL, N'asdsds989098089yut', N'<p>sdsd</p>
', N'<p>sdsd</p>
', CAST(N'2020-06-30T17:53:05.0000000' AS DateTime2), NULL, NULL, NULL, 878, CAST(0 AS Decimal(18, 0)), 1, NULL, N'asdsds989098089yut', N'sds', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (19, 0, NULL, N'ádsadsadfdgfd', N'<p>qưeq</p>
', N'<p>sad</p>
', CAST(N'2020-06-30T18:08:45.0000000' AS DateTime2), NULL, NULL, NULL, 0, CAST(322321 AS Decimal(18, 0)), 1, NULL, N'adsadsadfdgfd', NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (20, 0, NULL, N'ádsadsadfdgfdgfgf', N'<p>qưeq</p>
', N'<p>sad</p>
', CAST(N'2020-06-30T18:11:48.0000000' AS DateTime2), NULL, NULL, NULL, 0, CAST(322321 AS Decimal(18, 0)), 1, NULL, N'adsadsadfdgfdgfgf', NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (21, 0, NULL, N'ádsadsadfdgfdgfgfưeqeqw', N'<p>qưeq</p>
', N'<p>sad</p>
', CAST(N'2020-06-30T18:14:40.0000000' AS DateTime2), NULL, NULL, NULL, 0, CAST(322321 AS Decimal(18, 0)), 1, NULL, N'adsadsadfdgfdgfgfueqeqw', NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (22, 0, NULL, N'ádsaqưewqewq', N'', NULL, CAST(N'2020-06-30T18:19:41.0000000' AS DateTime2), NULL, NULL, NULL, 11227, CAST(0 AS Decimal(18, 0)), 1, NULL, N'adsaquewqewq', NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (23, 0, NULL, N'ádsaqưewqewqewqewq', N'', NULL, CAST(N'2020-06-30T18:22:09.0000000' AS DateTime2), NULL, NULL, NULL, 11227, CAST(0 AS Decimal(18, 0)), 1, NULL, N'adsaquewqewqewqewq', NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (24, 0, NULL, N'qưewqe', N'', NULL, CAST(N'2020-06-30T18:22:27.0000000' AS DateTime2), NULL, NULL, NULL, 21314, CAST(2321 AS Decimal(18, 0)), 1, NULL, N'quewqe', NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (25, 0, NULL, N'qưewqeqưqw', N'', NULL, CAST(N'2020-06-30T18:23:41.0000000' AS DateTime2), NULL, NULL, NULL, 21314, CAST(2321 AS Decimal(18, 0)), 1, NULL, N'quewqequqw', NULL, 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (26, 0, NULL, N'qưewqeqưqwqưewq', N'', NULL, CAST(N'2020-06-30T18:26:30.0000000' AS DateTime2), NULL, NULL, NULL, 21314, CAST(2321 AS Decimal(18, 0)), 1, NULL, N'quewqequqwquewq', NULL, 1)
SET IDENTITY_INSERT [dbo].[Product] OFF
SET IDENTITY_INSERT [dbo].[ProductAttribute] ON 

INSERT [dbo].[ProductAttribute] ([ID], [AttributeValueID], [ProductVersionID]) VALUES (1, 2, 4)
INSERT [dbo].[ProductAttribute] ([ID], [AttributeValueID], [ProductVersionID]) VALUES (2, 0, 5)
INSERT [dbo].[ProductAttribute] ([ID], [AttributeValueID], [ProductVersionID]) VALUES (3, 0, 6)
SET IDENTITY_INSERT [dbo].[ProductAttribute] OFF
SET IDENTITY_INSERT [dbo].[ProductVersionImage] ON 

INSERT [dbo].[ProductVersionImage] ([ID], [ProductVersionID], [IsMain], [Url]) VALUES (1, 4, 1, N'https://cdn.tgdd.vn/Products/Images/44/106875/apple-macbook-air-mqd32sa-a-i5-5350u-400x400.jpg')
INSERT [dbo].[ProductVersionImage] ([ID], [ProductVersionID], [IsMain], [Url]) VALUES (2, 5, 1, N'string')
INSERT [dbo].[ProductVersionImage] ([ID], [ProductVersionID], [IsMain], [Url]) VALUES (3, 6, 1, N'string')
SET IDENTITY_INSERT [dbo].[ProductVersionImage] OFF
SET IDENTITY_INSERT [dbo].[ProductVersions] ON 

INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice]) VALUES (1, 1, 0, N'Màu đỏ dl 250', CAST(19000000 AS Decimal(18, 0)), 100, 100, N'Iphone test', N'COC', NULL)
INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice]) VALUES (2, 1, 0, N'Màu xanh dl 250', CAST(18000000 AS Decimal(18, 0)), 100, 100, N'Iphone test', N'COC', NULL)
INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice]) VALUES (3, 2, 0, N'Màu xanh dl 250', CAST(16000000 AS Decimal(18, 0)), 100, 100, N'Iphone test', N'COC', NULL)
INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice]) VALUES (4, 4, 0, N'Bản cao cấp', CAST(50000000 AS Decimal(18, 0)), 100, 200, N'MBB', N'BAR', NULL)
INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice]) VALUES (5, 5, 0, N'string', CAST(0 AS Decimal(18, 0)), 0, 0, N'string', N'string', NULL)
INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice]) VALUES (6, 6, 0, N'string', CAST(0 AS Decimal(18, 0)), 0, 0, N'string', N'string', NULL)
SET IDENTITY_INSERT [dbo].[ProductVersions] OFF
/****** Object:  Index [IX_Photos_UserId]    Script Date: 6/30/2020 7:31:18 PM ******/
CREATE NONCLUSTERED INDEX [IX_Photos_UserId] ON [dbo].[Photos]
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ProductVersionImage] ADD  DEFAULT (CONVERT([bit],(0))) FOR [IsMain]
GO
ALTER TABLE [dbo].[Photos]  WITH CHECK ADD  CONSTRAINT [FK_Photos_Users_UserId] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Photos] CHECK CONSTRAINT [FK_Photos_Users_UserId]
GO
USE [master]
GO
ALTER DATABASE [Bt2] SET  READ_WRITE 
GO
