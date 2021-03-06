USE [master]
GO
/****** Object:  Database [EShop]    Script Date: 7/22/2020 10:59:01 AM ******/
CREATE DATABASE [EShop]
 CONTAINMENT = NONE

GO
ALTER DATABASE [EShop] SET COMPATIBILITY_LEVEL = 150
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
ALTER DATABASE [EShop] SET  ENABLE_BROKER 
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
ALTER DATABASE [EShop] SET READ_COMMITTED_SNAPSHOT ON 
GO
ALTER DATABASE [EShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [EShop] SET RECOVERY FULL 
GO
ALTER DATABASE [EShop] SET  MULTI_USER 
GO
ALTER DATABASE [EShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [EShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [EShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [EShop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [EShop] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'EShop', N'ON'
GO
ALTER DATABASE [EShop] SET QUERY_STORE = OFF
GO
USE [EShop]
GO
/****** Object:  Table [dbo].[__EFMigrationsHistory]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[Attribute]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[AttributeValue]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[BlogCategories]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[Catalog]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[Content]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[ContentCategory]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[ContentTag]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[Error]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[Footer]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[Image]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[Menu]    Script Date: 7/22/2020 10:59:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Menu](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Link] [nvarchar](250) NULL,
	[Text] [nvarchar](250) NULL,
	[DisplayOrder] [int] NULL,
	[Target] [nvarchar](50) NULL,
	[MenuGroupID] [int] NULL,
	[IsShow] [bit] NULL,
 CONSTRAINT [PK_Menu] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MenuGroup]    Script Date: 7/22/2020 10:59:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MenuGroup](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](250) NULL,
 CONSTRAINT [PK_MenuGroup] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[News]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[Order]    Script Date: 7/22/2020 10:59:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[ID] [int] NULL,
	[Note] [nvarchar](250) NULL,
	[CreatedDate] [datetime] NULL,
	[CustomerID] [bigint] NULL,
	[ShipName] [nvarchar](50) NULL,
	[ShipMobile] [varchar](50) NULL,
	[ShipAddress] [nvarchar](50) NULL,
	[ShipEmail] [nvarchar](50) NULL,
	[Status] [int] NULL,
	[OrderStatusID] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 7/22/2020 10:59:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[ProductVersionID] [bigint] NOT NULL,
	[OrderID] [bigint] NOT NULL,
	[Quantity] [int] NULL,
	[Price] [decimal](18, 0) NULL,
	[ID] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[ProductAttribute]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[ProductVersionImage]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[ProductVersions]    Script Date: 7/22/2020 10:59:01 AM ******/
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
	[Image] [nvarchar](max) NULL,
	[SEODescription] [nvarchar](500) NULL,
	[SEOTitle] [nvarchar](500) NULL,
	[SEOUrl] [nvarchar](500) NULL,
 CONSTRAINT [PK_ProductVersions] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Photos]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[Slide]    Script Date: 7/22/2020 10:59:01 AM ******/
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
	[Title] [nvarchar](500) NULL,
	[Content] [ntext] NULL,
 CONSTRAINT [PK_Slide] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tag]    Script Date: 7/22/2020 10:59:01 AM ******/
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
/****** Object:  Table [dbo].[Users]    Script Date: 7/22/2020 10:59:01 AM ******/
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
INSERT [dbo].[Catalog] ([ID], [ParentID], [Name], [SEOTitle], [SEOUrl], [SEODescription], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy]) VALUES (18, 1, N'Đồng hồ thông minh', NULL, NULL, NULL, CAST(N'2020-07-06T16:27:33.0000000' AS DateTime2), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Catalog] OFF
SET IDENTITY_INSERT [dbo].[Footer] ON 

INSERT [dbo].[Footer] ([ID], [Content], [IsShow]) VALUES (1, N'Footer', 1)
SET IDENTITY_INSERT [dbo].[Footer] OFF
SET IDENTITY_INSERT [dbo].[Menu] ON 

INSERT [dbo].[Menu] ([ID], [Link], [Text], [DisplayOrder], [Target], [MenuGroupID], [IsShow]) VALUES (1, N'home', N'Trang chủ', 1, N'_self', 2, 1)
INSERT [dbo].[Menu] ([ID], [Link], [Text], [DisplayOrder], [Target], [MenuGroupID], [IsShow]) VALUES (2, N'blog', N'Tin tức', 2, N'_self', 2, 1)
INSERT [dbo].[Menu] ([ID], [Link], [Text], [DisplayOrder], [Target], [MenuGroupID], [IsShow]) VALUES (3, N'product', N'Sản phẩm', 3, N'_self', 2, 1)
INSERT [dbo].[Menu] ([ID], [Link], [Text], [DisplayOrder], [Target], [MenuGroupID], [IsShow]) VALUES (4, N'contact', N'Liên hệ', 4, N'_self', 2, 1)
SET IDENTITY_INSERT [dbo].[Menu] OFF
SET IDENTITY_INSERT [dbo].[MenuGroup] ON 

INSERT [dbo].[MenuGroup] ([ID], [Name]) VALUES (1, N'ADMIN')
INSERT [dbo].[MenuGroup] ([ID], [Name]) VALUES (2, N'CLIENT')
SET IDENTITY_INSERT [dbo].[MenuGroup] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (44, 4, NULL, N'Samsumg lAa', N'<p>ưqewq</p>
', N'<p>sdsa</p>
', CAST(N'2020-07-02T15:24:11.0000000' AS DateTime2), NULL, NULL, NULL, 12321, CAST(211 AS Decimal(18, 0)), 1, N'seo', N'samsumg-laa', N'sd', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (46, 10, NULL, N'Điện thoại iPhone 11', N'<h2>Trong năm 2019 th&igrave; chiếc&nbsp;<a href="https://www.thegioididong.com/dtdd" target="_blank">smartphone</a>&nbsp;được nhiều người mong muốn sở hữu tr&ecirc;n tay</h2>
', N'<h3>Camera được cải tiến mạnh mẽ</h3>

<p>Chắc chắn l&yacute; do lớn nhất m&agrave; bạn muốn n&acirc;ng cấp l&ecirc;n iPhone 11 Pro Max ch&iacute;nh l&agrave; cụm camera mới được Apple n&acirc;ng cấp rất nhiều.</p>
', CAST(N'2020-07-02T15:33:44.0000000' AS DateTime2), NULL, NULL, NULL, 22321319, CAST(1000000000 AS Decimal(18, 0)), 1, N'đ', N'dien-thoai-iphone-11', N'a', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (47, 0, NULL, N'Máy tính bảng iPad Pro 11', N'<p>Cấu h&igrave;nh khủng vượt giới hạn của một chiếc tablet</p>
', N'<h3>Cấu h&igrave;nh khủng vượt giới hạn của một chiếc tablet</h3>

<p>Được Apple trang bị vi xử l&yacute; A12Z Bionic mới nhất, iPad Pro 11 inch c&oacute; một tốc độ vượt trội, c&oacute; thể so s&aacute;nh được với c&aacute;c mẫu&nbsp;<a href="https://www.thegioididong.com/laptop" target="_blank">m&aacute;y t&iacute;nh x&aacute;ch tay</a>&nbsp;hiện tại.</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>Mọi ứng dụng hoạt động tr&ecirc;n iPad trước vốn đ&atilde; mượt, nay c&ograve;n nhanh v&agrave; tr&ocirc;i chảy hơn, từ&nbsp;c&aacute;c t&aacute;c vụ đơn giản h&agrave;ng ng&agrave;y cho đến c&aacute;c c&ocirc;ng việc chuy&ecirc;n s&acirc;u về đồ họa đều được xử l&yacute; nhanh ch&oacute;ng.</p>

<p>Apple cũng đ&atilde; tăng cường đến 8 l&otilde;i&nbsp;xử l&yacute; đồ họa, gi&uacute;p cho iPad Pro 2020 trở th&agrave;nh một chiếc&nbsp;<a href="https://www.thegioididong.com/may-tinh-bang" target="_blank">m&aacute;y t&iacute;nh bảng</a>&nbsp;đ&aacute;p ứng tuyệt vời cho nhu cầu đồ họa, giải tr&iacute; v&agrave; chơi game.&nbsp;</p>
', CAST(N'2020-07-06T16:12:43.0000000' AS DateTime2), NULL, NULL, NULL, 2997, CAST(29999998 AS Decimal(18, 0)), 1, N'gg', N'may-tinh-bang-ipad-pro-11', N'ss', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (48, 4, NULL, N'Apple Watch S5', N'<p>ngon</p>
', N'<p>ngon</p>
', CAST(N'2020-07-06T16:22:18.0000000' AS DateTime2), NULL, NULL, NULL, 2000, CAST(15000000 AS Decimal(18, 0)), 1, N'seo', N'apple-watch-s5', N'tit', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (49, 4, NULL, N'Apple Watch S3 GPS', N'<p>200000000</p>
', N'<p>200000000</p>
', CAST(N'2020-07-06T16:24:49.0000000' AS DateTime2), NULL, NULL, NULL, 2000, CAST(200000000 AS Decimal(18, 0)), 1, N'200000000', N'apple-watch-s3-gps', N'200000000', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (50, 18, NULL, N'Samsung Galaxy Watch Active 2', N'<p>ngon</p>
', N'<p>ngon</p>
', CAST(N'2020-07-06T16:30:13.0000000' AS DateTime2), NULL, NULL, NULL, 2000, CAST(8000000 AS Decimal(18, 0)), 1, N'seo', N'samsung-galaxy-watch-active-2', N'tit', 1)
SET IDENTITY_INSERT [dbo].[Product] OFF
SET IDENTITY_INSERT [dbo].[ProductAttribute] ON 

INSERT [dbo].[ProductAttribute] ([ID], [AttributeValueID], [ProductVersionID]) VALUES (4, 2, 20)
INSERT [dbo].[ProductAttribute] ([ID], [AttributeValueID], [ProductVersionID]) VALUES (5, 2, 22)
INSERT [dbo].[ProductAttribute] ([ID], [AttributeValueID], [ProductVersionID]) VALUES (6, 3, 23)
SET IDENTITY_INSERT [dbo].[ProductAttribute] OFF
SET IDENTITY_INSERT [dbo].[ProductVersionImage] ON 

INSERT [dbo].[ProductVersionImage] ([ID], [ProductVersionID], [IsMain], [Url]) VALUES (1, 4, 1, N'https://cdn.tgdd.vn/Products/Images/44/106875/apple-macbook-air-mqd32sa-a-i5-5350u-400x400.jpg')
INSERT [dbo].[ProductVersionImage] ([ID], [ProductVersionID], [IsMain], [Url]) VALUES (2, 5, 1, N'string')
INSERT [dbo].[ProductVersionImage] ([ID], [ProductVersionID], [IsMain], [Url]) VALUES (3, 6, 1, N'string')
SET IDENTITY_INSERT [dbo].[ProductVersionImage] OFF
SET IDENTITY_INSERT [dbo].[ProductVersions] ON 

INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice], [Image], [SEODescription], [SEOTitle], [SEOUrl]) VALUES (18, 44, 0, N'<p>ưqewq</p>
', CAST(123121421 AS Decimal(18, 0)), 12321, 0, N'1123', N'12321', CAST(12321 AS Decimal(18, 0)), N'/ImageUpdate/files/samsung-galaxy-s10-lite-blue-chi-tiet-400x460.png', NULL, NULL, NULL)
INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice], [Image], [SEODescription], [SEOTitle], [SEOUrl]) VALUES (20, 46, 0, N'<p>phi&ecirc;n bản</p>
', CAST(1000000 AS Decimal(18, 0)), 1000, 0, N'sky', N'bar', CAST(1000 AS Decimal(18, 0)), N'/ImageUpdate/files/samsung-galaxy-s10-lite-blue-chi-tiet-400x460.png', NULL, NULL, NULL)
INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice], [Image], [SEODescription], [SEOTitle], [SEOUrl]) VALUES (21, 47, 0, N'<p>gng</p>
', CAST(20000000 AS Decimal(18, 0)), 997, 0, N'skl', N'tyt', CAST(19000000 AS Decimal(18, 0)), N'/ImageUpdate/files/ipad-pro-11-inch-2020-xam-400x460-fix-400x460.png', NULL, NULL, NULL)
INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice], [Image], [SEODescription], [SEOTitle], [SEOUrl]) VALUES (22, 48, 0, N'<p>tốt</p>
', CAST(14000000 AS Decimal(18, 0)), 2000, 0, N'SKU', N'bar', CAST(12000000 AS Decimal(18, 0)), N'/ImageUpdate/files/apple-watch-s5-40mm-vien-nhom-day-cao-su10-2-1-600x600.jpg', NULL, NULL, NULL)
INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice], [Image], [SEODescription], [SEOTitle], [SEOUrl]) VALUES (23, 49, 0, N'<p>ngon</p>
', CAST(20000000 AS Decimal(18, 0)), 20000, 0, N'KU', N'Br', CAST(2000000 AS Decimal(18, 0)), N'/ImageUpdate/files/apple-watch-s5-40mm-vien-nhom-day-cao-su10-2-1-600x600.jpg', NULL, NULL, NULL)
INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice], [Image], [SEODescription], [SEOTitle], [SEOUrl]) VALUES (24, 50, 0, N'<p>r</p>
', CAST(7000000 AS Decimal(18, 0)), 2000, 0, N'SKU', N'BAR', CAST(6000000 AS Decimal(18, 0)), N'/ImageUpdate/files/samsung-galaxy-watch-active-2-44-mm-sillicon-thumm-600x600.jpg', NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[ProductVersions] OFF
SET IDENTITY_INSERT [dbo].[Slide] ON 

INSERT [dbo].[Slide] ([ID], [Image], [Url], [IsShow], [ModifiedBy], [CreatedDate], [CreatedBy], [ModifiedDate], [Title], [Content]) VALUES (1, N'https://cdn.tgdd.vn/2020/06/banner/S20-800-300-800x300-5.png', N'san-pham/iphone11-1', 1, NULL, NULL, NULL, NULL, N'Iphone mới', N'iphone')
INSERT [dbo].[Slide] ([ID], [Image], [Url], [IsShow], [ModifiedBy], [CreatedDate], [CreatedBy], [ModifiedDate], [Title], [Content]) VALUES (2, N'https://cdn.tgdd.vn/2020/07/banner/sinh-nhat-800-300-800x300.png', N'/san-pham', 1, NULL, NULL, NULL, NULL, N'mùa hè mới ', N'mua ngay')
INSERT [dbo].[Slide] ([ID], [Image], [Url], [IsShow], [ModifiedBy], [CreatedDate], [CreatedBy], [ModifiedDate], [Title], [Content]) VALUES (3, N'https://cdn.tgdd.vn/2020/06/banner/800-300-800x300-38.png', N'/san-pham', 0, NULL, NULL, NULL, NULL, N'real me', N'mua ngay')
SET IDENTITY_INSERT [dbo].[Slide] OFF
/****** Object:  Index [IX_Photos_UserId]    Script Date: 7/22/2020 10:59:01 AM ******/
CREATE NONCLUSTERED INDEX [IX_Photos_UserId] ON [dbo].[Photos]
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[OrderDetail] ADD  CONSTRAINT [DF_OrderDetail_Quantity_1]  DEFAULT ((1)) FOR [Quantity]
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
ALTER DATABASE [EShop] SET  READ_WRITE 
GO
