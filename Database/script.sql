USE [master]
GO
/****** Object:  Database [EShop]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[__EFMigrationsHistory]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Attribute]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[AttributeValue]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[BlogCategories]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Catalog]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Content]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[ContentCategory]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[ContentTag]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Error]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Footer]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Image]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Menu]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[MenuGroup]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[News]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Order]    Script Date: 7/27/2020 4:29:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Note] [nvarchar](250) NULL,
	[CreatedDate] [datetime] NULL,
	[CustomerID] [bigint] NULL,
	[ShipName] [nvarchar](50) NULL,
	[ShipMobile] [varchar](50) NULL,
	[ShipAddress] [nvarchar](50) NULL,
	[ShipEmail] [nvarchar](50) NULL,
	[Status] [int] NULL,
	[OrderStatusID] [nchar](10) NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Product]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[ProductAttribute]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[ProductVersionImage]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[ProductVersions]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Photos]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Slide]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[Tag]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  Table [dbo].[User]    Script Date: 7/27/2020 4:29:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](250) NOT NULL,
	[Password] [varchar](250) NOT NULL,
	[Name] [nvarchar](250) NULL,
	[Sex] [nvarchar](10) NULL,
	[Address] [nvarchar](500) NULL,
	[Email] [nvarchar](250) NULL,
	[Phone] [varchar](50) NULL,
	[UserGroupID] [int] NULL,
	[IsLock] [bit] NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserGroup]    Script Date: 7/27/2020 4:29:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserGroup](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[GroupName] [nvarchar](250) NOT NULL,
	[Note] [nvarchar](500) NULL,
 CONSTRAINT [PK_UserGroup] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 7/27/2020 4:29:15 AM ******/
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

INSERT [dbo].[Footer] ([ID], [Content], [IsShow]) VALUES (5, N'
            <footer id="colophon" class="site-footer">
            	<div class="footer-widgets">
            		<div class="container">
            			<div class="row">
            				<div class="col-lg-4 col-md-4 col-xs-12">
            					<aside class="widget clearfix">
            						<div class="body">
            							<h4 class="widget-title">Featured Products</h4>
            							<ul class="product_list_widget">
            								<li>
            									<a href="single-product.html" title="Tablet Thin EliteBook  Revolve 810 G6">
            										<img class="wp-post-image" data-echo="assets/images/footer/1.jpg" src="assets/images/blank.gif" alt="">
            										<span class="product-title">Tablet Thin EliteBook  Revolve 810 G6</span>
            									</a>
            									<span class="electro-price"><span class="amount">&#36;1,300.00</span></span>
            								</li>

            								<li>
            									<a href="single-product.html" title="Smartphone 6S 128GB LTE">
            										<img class="wp-post-image" data-echo="assets/images/footer/2.jpg" src="assets/images/blank.gif" alt=""><span class="product-title">Smartphone 6S 128GB LTE</span>
            									</a>
            									<span class="electro-price"><span class="amount">&#36;780.00</span></span>
            								</li>

            								<li>
            									<a href="single-product.html" title="Smartphone 6S 64GB LTE">
            										<img class="wp-post-image" data-echo="assets/images/footer/3.jpg" src="assets/images/blank.gif" alt="">
            										<span class="product-title">Smartphone 6S 64GB LTE</span>
            									</a>
            									<span class="electro-price"><span class="amount">&#36;1,215.00</span></span>
            								</li>
            							</ul>
            						</div>
            					</aside>
            				</div>
            				<div class="col-lg-4 col-md-4 col-xs-12">
            					<aside class="widget clearfix">
            						<div class="body"><h4 class="widget-title">Onsale Products</h4>
            							<ul class="product_list_widget">
            								<li>
            									<a href="single-product.html" title="Notebook Black Spire V Nitro  VN7-591G">
            										<img class="wp-post-image" data-echo="assets/images/footer/3.jpg" src="assets/images/blank.gif" alt="">
            										<span class="product-title">Notebook Black Spire V Nitro  VN7-591G</span>
            									</a>
            									<span class="electro-price"><ins><span class="amount">&#36;1,999.00</span></ins> <del><span class="amount">&#36;2,299.00</span></del></span>
            								</li>

            								<li>
            									<a href="single-product.html" title="Tablet Red EliteBook  Revolve 810 G2">
            										<img class="wp-post-image" data-echo="assets/images/footer/4.jpg" src="assets/images/blank.gif" alt="">
            										<span class="product-title">Tablet Red EliteBook  Revolve 810 G2</span>
            									</a>
            									<span class="electro-price"><ins><span class="amount">&#36;1,999.00</span></ins> <del><span class="amount">&#36;2,299.00</span></del></span>
            								</li>

            								<li>
            									<a href="single-product.html" title="Widescreen 4K SUHD TV">
            										<img class="wp-post-image" data-echo="assets/images/footer/5.jpg" src="assets/images/blank.gif" alt="">
            										<span class="product-title">Widescreen 4K SUHD TV</span>
            									</a>
            									<span class="electro-price"><ins><span class="amount">&#36;2,999.00</span></ins> <del><span class="amount">&#36;3,299.00</span></del></span>
            								</li>
            							</ul>
            						</div>
            					</aside>
            				</div>
            				<div class="col-lg-4 col-md-4 col-xs-12">
            					<aside class="widget clearfix">
            						<div class="body">
            							<h4 class="widget-title">Top Rated Products</h4>
            							<ul class="product_list_widget">
            								<li>
            									<a href="single-product.html" title="Notebook Black Spire V Nitro  VN7-591G">
            										<img class="wp-post-image" data-echo="assets/images/footer/6.jpg" src="assets/images/blank.gif" alt="">
            										<span class="product-title">Notebook Black Spire V Nitro  VN7-591G</span>
            									</a>
            									<div class="star-rating" title="Rated 5 out of 5"><span style="width:100%"><strong class="rating">5</strong> out of 5</span></div>		<span class="electro-price"><ins><span class="amount">&#36;1,999.00</span></ins> <del><span class="amount">&#36;2,299.00</span></del></span>
            								</li>

            								<li>
            									<a href="single-product.html" title="Apple MacBook Pro MF841HN/A 13-inch Laptop">
            										<img class="wp-post-image" data-echo="assets/images/footer/7.jpg" src="assets/images/blank.gif" alt="">
            										<span class="product-title">Apple MacBook Pro MF841HN/A 13-inch Laptop</span>
            									</a>
            									<div class="star-rating" title="Rated 5 out of 5"><span style="width:100%"><strong class="rating">5</strong> out of 5</span></div>		<span class="electro-price"><span class="amount">&#36;1,800.00</span></span>
            								</li>

            								<li>
            									<a href="single-product.html" title="Tablet White EliteBook Revolve  810 G2">
            										<img class="wp-post-image" data-echo="assets/images/footer/2.jpg" src="assets/images/blank.gif" alt="">
            										<span class="product-title">Tablet White EliteBook Revolve  810 G2</span>
            									</a>
            									<div class="star-rating" title="Rated 5 out of 5"><span style="width:100%"><strong class="rating">5</strong> out of 5</span></div>		<span class="electro-price"><span class="amount">&#36;1,999.00</span></span>
            								</li>
            							</ul>
            						</div>
            					</aside>
            				</div>
            			</div>
            		</div>
            	</div>

            	<div class="footer-newsletter">
            		<div class="container">
            			<div class="row">
            				<div class="col-xs-12 col-sm-7">
            					<h5 class="newsletter-title">Sign up to Newsletter</h5>
            					<span class="newsletter-marketing-text">...and receive <strong>$20 coupon for first shopping</strong></span>
            				</div>
            				<div class="col-xs-12 col-sm-5">
            					<form>
            						<div class="input-group">
            							<input type="text" class="form-control" placeholder="Enter your email address">
            							<span class="input-group-btn">
            								<button class="btn btn-secondary" type="button">Sign Up</button>
            							</span>
            						</div>
            					</form>
            				</div>
            			</div>
            		</div>
            	</div>

            	<div class="footer-bottom-widgets">
            		<div class="container">
            			<div class="row">
            				<div class="col-xs-12 col-sm-12 col-md-7 col-md-push-5">
            					<div class="columns">
            						<aside id="nav_menu-2" class="widget clearfix widget_nav_menu">
            							<div class="body">
            								<h4 class="widget-title">Find It Fast</h4>
            								<div class="menu-footer-menu-1-container">
            									<ul id="menu-footer-menu-1" class="menu">
            										<li class="menu-item"><a href="single-product.html">Laptops &#038; Computers</a></li>
            										<li class="menu-item"><a href="single-product.html">Cameras &#038; Photography</a></li>
            										<li class="menu-item"><a href="single-product.html">Smart Phones &#038; Tablets</a></li>
            										<li class="menu-item"><a href="single-product.html">Video Games &#038; Consoles</a></li>
            										<li class="menu-item"><a href="single-product.html">TV &#038; Audio</a></li>
            										<li class="menu-item"><a href="single-product.html">Gadgets</a></li>
            										<li class="menu-item "><a href="single-product.html">Car Electronic &#038; GPS</a></li>
            									</ul>
            								</div>
            							</div>
            						</aside>
            					</div><!-- /.columns -->

            					<div class="columns">
            						<aside id="nav_menu-3" class="widget clearfix widget_nav_menu">
            							<div class="body">
            								<h4 class="widget-title">&nbsp;</h4>
            								<div class="menu-footer-menu-2-container">
            									<ul id="menu-footer-menu-2" class="menu">
            										<li class="menu-item"><a href="single-product.html">Printers &#038; Ink</a></li>
            										<li class="menu-item "><a href="single-product.html">Software</a></li>
            										<li  class="menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-2742"><a href="single-product.html">Office Supplies</a></li>
            										<li  class="menu-item "><a href="single-product.html">Computer Components</a></li>
            									</ul>
            								</div>
            							</div>
            						</aside>
            					</div><!-- /.columns -->

            					<div class="columns">
            						<aside id="nav_menu-4" class="widget clearfix widget_nav_menu">
            							<div class="body">
            								<h4 class="widget-title">Customer Care</h4>
            								<div class="menu-footer-menu-3-container">
            									<ul id="menu-footer-menu-3" class="menu">
            										<li class="menu-item"><a href="single-product.html">My Account</a></li>
            										<li class="menu-item"><a href="single-product.html">Track your Order</a></li>
            										<li class="menu-item"><a href="single-product.html">Wishlist</a></li>
            										<li class="menu-item"><a href="single-product.html">Customer Service</a></li>
            										<li class="menu-item"><a href="single-product.html">Returns/Exchange</a></li>
            										<li class="menu-item"><a href="single-product.html">FAQs</a></li>
            										<li class="menu-item"><a href="hsingle-product.html">Product Support</a></li>
            									</ul>
            								</div>
            							</div>
            						</aside>
            					</div><!-- /.columns -->

            				</div><!-- /.col -->

            				<div class="footer-contact col-xs-12 col-sm-12 col-md-5 col-md-pull-7">
            					<div class="footer-logo">
            						<svg version="1.1" x="0px" y="0px" width="156px"
            						height="37px" viewBox="0 0 175.748 42.52" enable-background="new 0 0 175.748 42.52">
            						<ellipse fill-rule="evenodd" clip-rule="evenodd" fill="#FDD700" cx="170.05" cy="36.341" rx="5.32" ry="5.367"/>
            						<path fill-rule="evenodd" clip-rule="evenodd" fill="#333E48" d="M30.514,0.71c-0.034,0.003-0.066,0.008-0.056,0.056
            						C30.263,0.995,29.876,1.181,29.79,1.5c-0.148,0.548,0,1.568,0,2.427v36.459c0.265,0.221,0.506,0.465,0.725,0.734h6.187
            						c0.2-0.25,0.423-0.477,0.669-0.678V1.387C37.124,1.185,36.9,0.959,36.701,0.71H30.514z M117.517,12.731
            						c-0.232-0.189-0.439-0.64-0.781-0.734c-0.754-0.209-2.039,0-3.121,0h-3.176V4.435c-0.232-0.189-0.439-0.639-0.781-0.733
            						c-0.719-0.2-1.969,0-3.01,0h-3.01c-0.238,0.273-0.625,0.431-0.725,0.847c-0.203,0.852,0,2.399,0,3.725
            						c0,1.393,0.045,2.748-0.055,3.725h-6.41c-0.184,0.237-0.629,0.434-0.725,0.791c-0.178,0.654,0,1.813,0,2.765v2.766
            						c0.232,0.188,0.439,0.64,0.779,0.733c0.777,0.216,2.109,0,3.234,0c1.154,0,2.291-0.045,3.176,0.057v21.277
            						c0.232,0.189,0.439,0.639,0.781,0.734c0.719,0.199,1.969,0,3.01,0h3.01c1.008-0.451,0.725-1.889,0.725-3.443
            						c-0.002-6.164-0.047-12.867,0.055-18.625h6.299c0.182-0.236,0.627-0.434,0.725-0.79c0.176-0.653,0-1.813,0-2.765V12.731z
            						M135.851,18.262c0.201-0.746,0-2.029,0-3.104v-3.104c-0.287-0.245-0.434-0.637-0.781-0.733c-0.824-0.229-1.992-0.044-2.898,0
            						c-2.158,0.104-4.506,0.675-5.74,1.411c-0.146-0.362-0.451-0.853-0.893-0.96c-0.693-0.169-1.859,0-2.842,0h-2.842
            						c-0.258,0.319-0.625,0.42-0.725,0.79c-0.223,0.82,0,2.338,0,3.443c0,8.109-0.002,16.635,0,24.381
            						c0.232,0.189,0.439,0.639,0.779,0.734c0.707,0.195,1.93,0,2.955,0h3.01c0.918-0.463,0.725-1.352,0.725-2.822V36.21
            						c-0.002-3.902-0.242-9.117,0-12.473c0.297-4.142,3.836-4.877,8.527-4.686C135.312,18.816,135.757,18.606,135.851,18.262z
            						M14.796,11.376c-5.472,0.262-9.443,3.178-11.76,7.056c-2.435,4.075-2.789,10.62-0.501,15.126c2.043,4.023,5.91,7.115,10.701,7.9
            						c6.051,0.992,10.992-1.219,14.324-3.838c-0.687-1.1-1.419-2.664-2.118-3.951c-0.398-0.734-0.652-1.486-1.616-1.467
            						c-1.942,0.787-4.272,2.262-7.134,2.145c-3.791-0.154-6.659-1.842-7.524-4.91h19.452c0.146-2.793,0.22-5.338-0.279-7.563
            						C26.961,15.728,22.503,11.008,14.796,11.376z M9,23.284c0.921-2.508,3.033-4.514,6.298-4.627c3.083-0.107,4.994,1.976,5.685,4.627
            						C17.119,23.38,12.865,23.38,9,23.284z M52.418,11.376c-5.551,0.266-9.395,3.142-11.76,7.056
            						c-2.476,4.097-2.829,10.493-0.557,15.069c1.997,4.021,5.895,7.156,10.646,7.957c6.068,1.023,11-1.227,14.379-3.781
            						c-0.479-0.896-0.875-1.742-1.393-2.709c-0.312-0.582-1.024-2.234-1.561-2.539c-0.912-0.52-1.428,0.135-2.23,0.508
            						c-0.564,0.262-1.223,0.523-1.672,0.676c-4.768,1.621-10.372,0.268-11.537-4.176h19.451c0.668-5.443-0.419-9.953-2.73-13.037
            						C61.197,13.388,57.774,11.12,52.418,11.376z M46.622,23.343c0.708-2.553,3.161-4.578,6.242-4.686
            						c3.08-0.107,5.08,1.953,5.686,4.686H46.622z M160.371,15.497c-2.455-2.453-6.143-4.291-10.869-4.064
            						c-2.268,0.109-4.297,0.65-6.02,1.524c-1.719,0.873-3.092,1.957-4.234,3.217c-2.287,2.519-4.164,6.004-3.902,11.007
            						c0.248,4.736,1.979,7.813,4.627,10.326c2.568,2.439,6.148,4.254,10.867,4.064c4.457-0.18,7.889-2.115,10.199-4.684
            						c2.469-2.746,4.012-5.971,3.959-11.063C164.949,21.134,162.732,17.854,160.371,15.497z M149.558,33.952
            						c-3.246-0.221-5.701-2.615-6.41-5.418c-0.174-0.689-0.26-1.25-0.4-2.166c-0.035-0.234,0.072-0.523-0.045-0.77
            						c0.682-3.698,2.912-6.257,6.799-6.547c2.543-0.189,4.258,0.735,5.52,1.863c1.322,1.182,2.303,2.715,2.451,4.967
            						C157.789,30.669,154.185,34.267,149.558,33.952z M88.812,29.55c-1.232,2.363-2.9,4.307-6.13,4.402
            						c-4.729,0.141-8.038-3.16-8.025-7.563c0.004-1.412,0.324-2.65,0.947-3.726c1.197-2.061,3.507-3.688,6.633-3.612
            						c3.222,0.079,4.966,1.708,6.632,3.668c1.328-1.059,2.529-1.948,3.9-2.99c0.416-0.315,1.076-0.688,1.227-1.072
            						c0.404-1.031-0.365-1.502-0.891-2.088c-2.543-2.835-6.66-5.377-11.704-5.137c-6.02,0.288-10.218,3.697-12.484,7.846
            						c-1.293,2.365-1.951,5.158-1.729,8.408c0.209,3.053,1.191,5.496,2.619,7.508c2.842,4.004,7.385,6.973,13.656,6.377
            						c5.976-0.568,9.574-3.936,11.816-8.354c-0.141-0.271-0.221-0.604-0.336-0.902C92.929,31.364,90.843,30.485,88.812,29.55z"/>
            						</svg>
            					</div><!-- /.footer-contact -->

            					<div class="footer-call-us">
            						<div class="media">
            							<span class="media-left call-us-icon media-middle"><i class="ec ec-support"></i></span>
            							<div class="media-body">
            								<span class="call-us-text">Got Questions ? Call us 24/7!</span>
            								<span class="call-us-number">(800) 8001-8588, (0600) 874 548</span>
            							</div>
            						</div>
            					</div><!-- /.footer-call-us -->


            					<div class="footer-address">
            						<strong class="footer-address-title">Contact Info</strong>
            						<address>17 Princess Road, London, Greater London NW1 8JR, UK</address>
            					</div><!-- /.footer-address -->

            					<div class="footer-social-icons">
            						<ul class="social-icons list-unstyled">
            							<li><a class="fa fa-facebook" href="http://themeforest.net/user/shaikrilwan/portfolio"></a></li>
            							<li><a class="fa fa-twitter" href="http://themeforest.net/user/shaikrilwan/portfolio"></a></li>
            							<li><a class="fa fa-pinterest" href="http://themeforest.net/user/shaikrilwan/portfolio"></a></li>
            							<li><a class="fa fa-linkedin" href="http://themeforest.net/user/shaikrilwan/portfolio"></a></li>
            							<li><a class="fa fa-google-plus" href="http://themeforest.net/user/shaikrilwan/portfolio"></a></li>
            							<li><a class="fa fa-tumblr" href="http://themeforest.net/user/shaikrilwan/portfolio"></a></li>
            							<li><a class="fa fa-instagram" href="http://themeforest.net/user/shaikrilwan/portfolio"></a></li>
            							<li><a class="fa fa-youtube" href="http://themeforest.net/user/shaikrilwan/portfolio"></a></li>
            							<li><a class="fa fa-rss" href="#"></a></li>
            							</ul>
            					</div>
            				</div>

            			</div>
            		</div>
            	</div>

            	<div class="copyright-bar">
            		<div class="container">
            			<div class="pull-left flip copyright">&copy; <a href="http://demo2.transvelo.in/html/electro/">Electro</a> - All Rights Reserved</div>
            			<div class="pull-right flip payment">
            				<div class="footer-payment-logo">
            					<ul class="cash-card card-inline">
            						<li class="card-item"><img src="assets/images/footer/payment-icon/1.png" alt="" width="52"></li>
            						<li class="card-item"><img src="assets/images/footer/payment-icon/2.png" alt="" width="52"></li>
            						<li class="card-item"><img src="assets/images/footer/payment-icon/3.png" alt="" width="52"></li>
            						<li class="card-item"><img src="assets/images/footer/payment-icon/4.png" alt="" width="52"></li>
            						<li class="card-item"><img src="assets/images/footer/payment-icon/5.png" alt="" width="52"></li>
            					</ul>
            				</div><!-- /.payment-methods -->
            			</div>
            		</div><!-- /.container -->
            	</div><!-- /.copyright-bar -->
            </footer><!-- #colophon -->
', 1)
SET IDENTITY_INSERT [dbo].[Footer] OFF
SET IDENTITY_INSERT [dbo].[Menu] ON 

INSERT [dbo].[Menu] ([ID], [Link], [Text], [DisplayOrder], [Target], [MenuGroupID], [IsShow]) VALUES (1, N'home', N'Trang chủ', 1, N'_self', 2, 1)
INSERT [dbo].[Menu] ([ID], [Link], [Text], [DisplayOrder], [Target], [MenuGroupID], [IsShow]) VALUES (2, N'content-list', N'Tin tức', 2, N'_self', 2, 1)
INSERT [dbo].[Menu] ([ID], [Link], [Text], [DisplayOrder], [Target], [MenuGroupID], [IsShow]) VALUES (3, N'product-list', N'Sản phẩm', 3, N'_self', 2, 1)
INSERT [dbo].[Menu] ([ID], [Link], [Text], [DisplayOrder], [Target], [MenuGroupID], [IsShow]) VALUES (4, N'contact', N'Liên hệ', 4, N'_self', 2, 1)
SET IDENTITY_INSERT [dbo].[Menu] OFF
SET IDENTITY_INSERT [dbo].[MenuGroup] ON 

INSERT [dbo].[MenuGroup] ([ID], [Name]) VALUES (1, N'ADMIN')
INSERT [dbo].[MenuGroup] ([ID], [Name]) VALUES (2, N'CLIENT')
SET IDENTITY_INSERT [dbo].[MenuGroup] OFF
SET IDENTITY_INSERT [dbo].[Order] ON 

INSERT [dbo].[Order] ([ID], [Note], [CreatedDate], [CustomerID], [ShipName], [ShipMobile], [ShipAddress], [ShipEmail], [Status], [OrderStatusID]) VALUES (7, N'ghi chú', CAST(N'2020-07-27T03:50:29.000' AS DateTime), NULL, N'Sang', N'0123456', N'g', N'sa@gmail.com', 1, NULL)
INSERT [dbo].[Order] ([ID], [Note], [CreatedDate], [CustomerID], [ShipName], [ShipMobile], [ShipAddress], [ShipEmail], [Status], [OrderStatusID]) VALUES (8, N'd', CAST(N'2020-05-27T04:00:48.000' AS DateTime), NULL, N'Heo', N'099888', N's', N's@gmail.com', 1, NULL)
SET IDENTITY_INSERT [dbo].[Order] OFF
SET IDENTITY_INSERT [dbo].[OrderDetail] ON 

INSERT [dbo].[OrderDetail] ([ProductVersionID], [OrderID], [Quantity], [Price], [ID]) VALUES (25, 7, 18, CAST(14900000 AS Decimal(18, 0)), 9)
INSERT [dbo].[OrderDetail] ([ProductVersionID], [OrderID], [Quantity], [Price], [ID]) VALUES (21, 7, 10, CAST(19000000 AS Decimal(18, 0)), 10)
INSERT [dbo].[OrderDetail] ([ProductVersionID], [OrderID], [Quantity], [Price], [ID]) VALUES (21, 8, 3, CAST(19000000 AS Decimal(18, 0)), 11)
SET IDENTITY_INSERT [dbo].[OrderDetail] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (44, 4, NULL, N'Samsumg lAa', N'<p>ưqewq</p>
', N'<p>sdsa</p>
', CAST(N'2020-07-02T15:24:11.0000000' AS DateTime2), NULL, NULL, NULL, 12321, CAST(211 AS Decimal(18, 0)), 1, N'seo', N'samsumg-laa', N'sd', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (46, 10, NULL, N'Điện thoại iPhone 11', N'<h2>Trong năm 2019 th&igrave; chiếc&nbsp;<a href="https://www.thegioididong.com/dtdd" target="_blank">smartphone</a>&nbsp;được nhiều người mong muốn sở hữu tr&ecirc;n tay</h2>
', N'<h3>Camera được cải tiến mạnh mẽ</h3>

<p>Chắc chắn l&yacute; do lớn nhất m&agrave; bạn muốn n&acirc;ng cấp l&ecirc;n iPhone 11 Pro Max ch&iacute;nh l&agrave; cụm camera mới được Apple n&acirc;ng cấp rất nhiều.</p>
', CAST(N'2020-07-02T15:33:44.0000000' AS DateTime2), NULL, NULL, NULL, 22321319, CAST(10000000 AS Decimal(18, 0)), 1, N'đ', N'dien-thoai-iphone-11', N'a', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (47, 4, NULL, N'Máy tính bảng iPad Pro 11', N'<p>Cấu h&igrave;nh khủng vượt giới hạn của một chiếc tablet</p>
', N'<h3>Cấu h&igrave;nh khủng vượt giới hạn của một chiếc tablet</h3>

<p>Được Apple trang bị vi xử l&yacute; A12Z Bionic mới nhất, iPad Pro 11 inch c&oacute; một tốc độ vượt trội, c&oacute; thể so s&aacute;nh được với c&aacute;c mẫu&nbsp;<a href="https://www.thegioididong.com/laptop" target="_blank">m&aacute;y t&iacute;nh x&aacute;ch tay</a>&nbsp;hiện tại.</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>Mọi ứng dụng hoạt động tr&ecirc;n iPad trước vốn đ&atilde; mượt, nay c&ograve;n nhanh v&agrave; tr&ocirc;i chảy hơn, từ&nbsp;c&aacute;c t&aacute;c vụ đơn giản h&agrave;ng ng&agrave;y cho đến c&aacute;c c&ocirc;ng việc chuy&ecirc;n s&acirc;u về đồ họa đều được xử l&yacute; nhanh ch&oacute;ng.</p>

<p>Apple cũng đ&atilde; tăng cường đến 8 l&otilde;i&nbsp;xử l&yacute; đồ họa, gi&uacute;p cho iPad Pro 2020 trở th&agrave;nh một chiếc&nbsp;<a href="https://www.thegioididong.com/may-tinh-bang" target="_blank">m&aacute;y t&iacute;nh bảng</a>&nbsp;đ&aacute;p ứng tuyệt vời cho nhu cầu đồ họa, giải tr&iacute; v&agrave; chơi game.&nbsp;</p>
', CAST(N'2020-07-06T16:12:43.0000000' AS DateTime2), NULL, NULL, NULL, 2997, CAST(10000000 AS Decimal(18, 0)), 1, N'gg', N'may-tinh-bang-ipad-pro-11', N'ss', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (48, 4, NULL, N'Apple Watch S5', N'<p>ngon</p>
', N'<p>ngon</p>
', CAST(N'2020-07-06T16:22:18.0000000' AS DateTime2), NULL, NULL, NULL, 2000, CAST(10000000 AS Decimal(18, 0)), 1, N'seo', N'apple-watch-s5', N'tit', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (49, 4, NULL, N'Apple Watch S3 GPS', N'<p>200000000</p>
', N'<p>200000000</p>
', CAST(N'2020-07-06T16:24:49.0000000' AS DateTime2), NULL, NULL, NULL, 2000, CAST(10000000 AS Decimal(18, 0)), 1, N'200000000', N'apple-watch-s3-gps', N'200000000', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (50, 18, NULL, N'Samsung Galaxy Watch Active 2', N'<p>ngon</p>
', N'<p>ngon</p>
', CAST(N'2020-07-06T16:30:13.0000000' AS DateTime2), NULL, NULL, NULL, 2000, CAST(10000000 AS Decimal(18, 0)), 1, N'seo', N'samsung-galaxy-watch-active-2', N'tit', 1)
INSERT [dbo].[Product] ([ID], [CatalogID], [Url], [Name], [Description], [Content], [CreatedDate], [CreatedBy], [ModifiedDate], [ModifiedBy], [Weight], [OriginalPrice], [Deliver], [SEOTitle], [SEOUrl], [SEODescription], [ApplyPromotion]) VALUES (51, 4, NULL, N'Điện thoại Samsung Galaxy Note 10 Lite', N'<h2>Sau bao đồn đo&aacute;n v&agrave; tr&ocirc;ng ng&oacute;ng th&igrave; cuối c&ugrave;ng &quot;người em &uacute;t&quot; trong series Note 10 cũng đ&atilde; ch&iacute;nh thức tr&igrave;nh l&agrave;ng với t&ecirc;n gọi&nbsp;<a href="https://www.thegioididong.com/dtdd/samsung-galaxy-note-10-lite" target="_blank">Samsung Galaxy Note 10 Lite</a>&nbsp;với những thay đổi nhất định về ngoại h&igrave;nh.</h2>
', N'<h2>Sau bao đồn đo&aacute;n v&agrave; tr&ocirc;ng ng&oacute;ng th&igrave; cuối c&ugrave;ng &quot;người em &uacute;t&quot; trong series Note 10 cũng đ&atilde; ch&iacute;nh thức tr&igrave;nh l&agrave;ng với t&ecirc;n gọi&nbsp;<a href="https://www.thegioididong.com/dtdd/samsung-galaxy-note-10-lite" target="_blank">Samsung Galaxy Note 10 Lite</a>&nbsp;với những thay đổi nhất định về ngoại h&igrave;nh.</h2>

<h3>Ngoại h&igrave;nh mới mẻ theo xu thế</h3>

<p>Samsung&nbsp;Galaxy Note 10 Lite nh&igrave;n chung vẫn sở hữu thiết kế quen thuộc của d&ograve;ng Note 10 series ở mặt trước&nbsp;với rất &iacute;t viền xung quanh, c&aacute;c g&oacute;c được bo tr&ograve;n, một camera selfie nằm trong lỗ đục ch&iacute;nh giữa.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd3-3.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Thiết kế hiện đại, sang trọng" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd3-3.jpg" /></a></p>

<p>Tuy nhi&ecirc;n điểm kh&aacute;c biệt sẽ tới từ mặt lưng thay v&igrave; cụm camera đặt dọc như những phi&ecirc;n bản trước th&igrave;&nbsp;<a href="https://www.thegioididong.com/dtdd-samsung" target="_blank">Samsung</a>&nbsp;đ&atilde; l&agrave;m&nbsp;h&igrave;nh chữ nhật tr&ocirc;ng thu h&uacute;t v&agrave; hầm hố hơn.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd2-3.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Thiết kế mặt lưng sang trọng" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd2-3.jpg" /></a></p>

<p>M&aacute;y cũng sẽ kh&ocirc;ng c&ograve;n kiểu thiết kế cong ở 2 cạnh của m&agrave;n h&igrave;nh m&agrave; thay v&agrave;o đ&oacute; l&agrave; thiết kế phẳng tương tự như c&aacute;c sản phẩm cận cao cấp kh&aacute;c.&nbsp;Nhưng kh&ocirc;ng v&igrave; đ&oacute; m&agrave; k&eacute;m phần sang trọng nhờ mặt k&iacute;nh b&oacute;ng bẩy v&agrave; m&agrave;u sắc h&uacute;t mắt người nh&igrave;n.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd-7.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Trải nghiệm cầm nắm" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd-7.jpg" /></a></p>

<p>Một chi tiết kh&aacute;c cũng rất đ&aacute;ng ch&uacute; &yacute; l&agrave;&nbsp;<a href="https://www.thegioididong.com/hoi-dap/hoi-dap-tong-hop-cac-loai-man-hinh-vo-cuc-moi-t-1150900#infinity-o" target="_blank">m&agrave;n h&igrave;nh Infinity-O</a>&nbsp;tr&ecirc;n chiếc smartphone Samsung n&agrave;y&nbsp;lớn hơn nhiều so với&nbsp;<a href="https://www.thegioididong.com/dtdd/samsung-galaxy-note-10" target="_blank">Samsung Galaxy Note 10</a>&nbsp;ti&ecirc;u chuẩn (6.3 inch) v&agrave; chỉ nhỏ hơn một ch&uacute;t so với phi&ecirc;n bản Plus (6.8 inch). Điều n&agrave;y gi&uacute;p bạn vẫn c&oacute; một kh&ocirc;ng gian thoải m&aacute;i để l&agrave;m việc v&agrave; giải tr&iacute; cả ng&agrave;y.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd9-1.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Màn hình Infinity-O thời thượng" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd9-1.jpg" /></a></p>

<p>M&aacute;y cũng được trang bị cảm biến v&acirc;n tay b&ecirc;n dưới m&agrave;n h&igrave;nh gi&uacute;p người d&ugrave;ng mở kh&oacute;a rất nhanh ch&oacute;ng v&agrave; thuận tiện.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd12-1.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Cảm biến vân tay" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd12-1.jpg" /></a></p>

<p>Một điểm chắc chắn sẽ khiến c&aacute;c SamFan h&agrave;i l&ograve;ng khi&nbsp;Note 10 Lite đ&atilde; mang jack cắm tai nghe quay trở lại khi gia đ&igrave;nh Note 10 series trước đ&oacute; đ&atilde; bị loại bỏ chi tiết đ&oacute;.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd8-2.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Khay sim" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd8-2.jpg" /></a></p>

<p>Xem th&ecirc;m:&nbsp;<a href="https://www.thegioididong.com/tin-tuc/tren-tay-galaxy-note-10-lite-tai-viet-nam-1232173" target="_blank">Tr&ecirc;n tay Galaxy Note 10 Lite tại Việt Nam: Vẫn l&agrave; Note của ng&agrave;y h&ocirc;m qua?</a></p>

<h3>Camera chất lượng h&agrave;ng đầu</h3>

<p>Camera lu&ocirc;n l&agrave; một trong những điểm người d&ugrave;ng Galaxy Note rất h&agrave;i l&ograve;ng v&agrave; tr&ecirc;n chiếc smartphone mới n&agrave;y cũng kh&ocirc;ng phải l&agrave; một ngoại lệ.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd4-3.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Camera sau" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd4-3.jpg" /></a></p>

<p>Ch&uacute;ng ta sẽ c&oacute;&nbsp;cảm biến ch&iacute;nh 12 MP được Samsung &quot;b&ecirc;&quot; nguy&ecirc;n từ chiếc Note 8 l&ecirc;n đảm bảo cho bạn chất lượng ảnh sắc n&eacute;t.</p>

<p>&nbsp;</p>

<p><img src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd2-1.jpg" />Ảnh chụp bằng camera sau tr&ecirc;n Samsung Galaxy Note 10 Lite</p>

<p><img src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd3-1.jpg" />Ảnh chụp ban đ&ecirc;m bằng camera sau tr&ecirc;n Samsung Galaxy Note 10 Lite</p>

<p><img src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd5-1.jpg" />Ảnh chụp bằng camera sau tr&ecirc;n Samsung Galaxy Note 10 Lite</p>

<p><img src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd6-1.jpg" />Ảnh chụp bằng camera sau tr&ecirc;n Samsung Galaxy Note 10 Lite</p>

<p><img src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd7-1.jpg" />Ảnh chụp bằng camera sau tr&ecirc;n Samsung Galaxy Note 10 Lite</p>

<p>&nbsp;</p>

<p>B&ecirc;n cạnh đ&oacute; ch&uacute;ng ta vẫn sẽ c&oacute;&nbsp;cảm biến g&oacute;c si&ecirc;u rộng 12 MP f/2.2 tương tự như tr&ecirc;n chiếc Galaxy Note 10 cho bạn thoải m&aacute;i s&aacute;ng tạo những g&oacute;c chụp mới lạ.</p>

<p>V&agrave; nếu bạn muốn chụp xa hơn m&agrave; kh&ocirc;ng muốn di chuyển th&igrave;&nbsp;camera tele 2x 12 MP f/2.4 sẽ l&agrave; trợ thủ đắc lực d&agrave;nh cho bạn.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd-0.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Camera trước" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd-0.jpg" /></a></p>

<p>Những ai l&agrave; t&iacute;n đồ của selfie chắc hẳn sẽ rất vui với camera trước độ ph&acirc;n giải l&ecirc;n tới 32 MP lớn hơn rất nhiều con số 10 MP như tr&ecirc;n Note 10.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd1-1.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Ảnh chụp selfie" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd1-1.jpg" /></a></p>

<h3>Tất nhi&ecirc;n kh&ocirc;ng thể thiếu&nbsp;S-Pen</h3>

<p>Điểm &quot;ăn tiền&quot; nhất tr&ecirc;n Galaxy Note 10 Lite c&oacute; lẽ ch&iacute;nh l&agrave; sự xuất hiện của chiếc b&uacute;t S-Pen thần th&aacute;nh.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd5-2.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Bút S Pen" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd5-2.jpg" /></a></p>

<p>S Pen gi&uacute;p bạn rất nhiều trong c&aacute;c c&ocirc;ng việc hằng ng&agrave;y như ghi ch&uacute; nhanh ngay cả khi m&agrave;n h&igrave;nh kh&oacute;a, tạo hiệu ứng h&igrave;nh động với c&aacute;c n&eacute;t vẽ m&agrave; hiếm chiếc&nbsp;<a href="https://www.thegioididong.com/dtdd" target="_blank">smartphone</a>&nbsp;n&agrave;o c&oacute;.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd-4.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Trải nghiệm bút S Pen" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd-4.jpg" /></a></p>

<p>B&ecirc;n cạnh đ&oacute; với khả năng kết nối qua Bluetooth th&igrave; bạn cũng c&oacute; thể sử dụng S-Pen như một chiếc điều khiển từ xa để tự chụp h&igrave;nh rất hữu dụng.</p>

<h3>Hiệu năng mượt m&agrave;, thoải m&aacute;i d&ugrave;ng l&acirc;u</h3>

<p>Cung cấp sức mạnh cho chiếc&nbsp;Samsung Galaxy Note 10 Lite ch&iacute;nh l&agrave; con chip Exynos 9810&nbsp;8 nh&acirc;n 10nm giống như tr&ecirc;n&nbsp;<a href="https://www.thegioididong.com/dtdd/samsung-galaxy-note-9" target="_blank">Note 9</a>, với 8 GB RAM v&agrave; bộ nhớ trong 128 GB.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd-5.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Hiệu năng mạnh mẽ" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd-5.jpg" /></a></p>

<p>Với cấu h&igrave;nh n&agrave;y th&igrave; bạn vẫn c&oacute; thể thoải m&aacute;i sử dụng mọi game v&agrave; ứng dụng nặng nhất đang c&oacute; tr&ecirc;n Google Play m&agrave; chiếc m&aacute;y vẫn đ&aacute;p ứng một c&aacute;ch mượt m&agrave;.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd.jpg" onclick="return false;"><img alt="Điểm hiệu năng Antutu Bench trên điện thoại Samsung Galaxy Note 10 Lite" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd.jpg" /></a></p>

<p>M&aacute;y chạy tr&ecirc;n giao diện OneUI 2.0 dựa tr&ecirc;n hệ điều h&agrave;nh Android 10 khi được b&aacute;n ra. C&aacute;c thao t&aacute;c v&agrave; giao diện tr&ecirc;n hệ điều h&agrave;nh n&agrave;y được Samsung tối ưu hướng tới sự đơn giản, mượt m&agrave; v&agrave; dễ d&agrave;ng sử dụng bằng một tay.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd7-2.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Thời lượng pin lâu" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd7-2.jpg" /></a></p>

<p>Galaxy Note 10 Lite được trang bị vi&ecirc;n pin dung lượng lớn 4.500 mAh, hỗ trợ&nbsp;<a href="https://www.thegioididong.com/dtdd?f=sac-pin-nhanh" target="_blank">sạc nhanh</a>&nbsp;tối đa 25W gi&uacute;p bạn r&uacute;t ngắn đ&aacute;ng kể thời gian chờ sạc.</p>

<p><a href="https://www.thegioididong.com/images/42/214909/samsung-galaxy-note-10-lite-tgdd-6.jpg" onclick="return false;"><img alt="Điện thoại Samsung Galaxy Note 10 Lite | Bút S Pen" src="https://cdn.tgdd.vn/Products/Images/42/214909/samsung-galaxy-note-10-lite-tgdd-6.jpg" /></a></p>

<p>T&oacute;m lại, Galaxy Note 10 Lite l&agrave; chiếc smartphone đem c&aacute;c trải nghiệm cao cấp như b&uacute;t S-Pen, cấu h&igrave;nh cao cấp v&agrave; camera chất lượng xuống ph&acirc;n kh&uacute;c gi&aacute; dễ tiếp cận hơn, chắc chắn sẽ tiếp tục gi&uacute;p Samsung g&acirc;y sốt thị trường trong thời gian tới.</p>
', CAST(N'2020-07-25T12:54:46.0000000' AS DateTime2), NULL, NULL, NULL, 2218, CAST(10000000 AS Decimal(18, 0)), 1, N's', N'dien-thoai-samsung-galaxy-note-10-lite', N'a', 1)
SET IDENTITY_INSERT [dbo].[Product] OFF
SET IDENTITY_INSERT [dbo].[ProductAttribute] ON 

INSERT [dbo].[ProductAttribute] ([ID], [AttributeValueID], [ProductVersionID]) VALUES (4, 2, 20)
INSERT [dbo].[ProductAttribute] ([ID], [AttributeValueID], [ProductVersionID]) VALUES (5, 2, 22)
INSERT [dbo].[ProductAttribute] ([ID], [AttributeValueID], [ProductVersionID]) VALUES (6, 3, 23)
INSERT [dbo].[ProductAttribute] ([ID], [AttributeValueID], [ProductVersionID]) VALUES (7, 2, 25)
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
INSERT [dbo].[ProductVersions] ([ID], [ProductID], [WareHouseID], [Description], [Price], [Quantum], [RemainingAmount], [SKU], [Barcode], [PromotionPrice], [Image], [SEODescription], [SEOTitle], [SEOUrl]) VALUES (25, 51, 0, N'<p>Sau bao đồn đo&aacute;n v&agrave; tr&ocirc;ng ng&oacute;ng th&igrave; cuối c&ugrave;ng &quot;người em &uacute;t&quot; trong series Note 10 cũng đ&atilde; ch&iacute;nh thức tr&igrave;nh l&agrave;ng với t&ecirc;n gọi&nbsp;<a href="https://www.thegioididong.com/dtdd/samsung-galaxy-note-10-lite" target="_blank">Samsung Galaxy Note 10 Lite</a>&nbsp;với những thay đổi nhất định về ngoại h&igrave;nh.</p>
', CAST(15000000 AS Decimal(18, 0)), 10000, 0, N'sd', N'vs', CAST(14900000 AS Decimal(18, 0)), N'/ImageUpdate/files/samsung-galaxy-note-10-lite-chi-tiet-1-400x460.png', NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[ProductVersions] OFF
SET IDENTITY_INSERT [dbo].[Slide] ON 

INSERT [dbo].[Slide] ([ID], [Image], [Url], [IsShow], [ModifiedBy], [CreatedDate], [CreatedBy], [ModifiedDate], [Title], [Content]) VALUES (1, N'https://cdn.tgdd.vn/2020/06/banner/S20-800-300-800x300-5.png', N'san-pham/iphone11-1', 1, NULL, NULL, NULL, NULL, N'Iphone mới', N'iphone')
INSERT [dbo].[Slide] ([ID], [Image], [Url], [IsShow], [ModifiedBy], [CreatedDate], [CreatedBy], [ModifiedDate], [Title], [Content]) VALUES (2, N'https://cdn.tgdd.vn/2020/07/banner/sinh-nhat-800-300-800x300.png', N'/san-pham', 1, NULL, NULL, NULL, NULL, N'mùa hè mới ', N'mua ngay')
INSERT [dbo].[Slide] ([ID], [Image], [Url], [IsShow], [ModifiedBy], [CreatedDate], [CreatedBy], [ModifiedDate], [Title], [Content]) VALUES (4, N'/ImageUpdate/files/giphy.gif', N'e', 0, NULL, NULL, NULL, NULL, N'e', N'<p>e</p>
')
INSERT [dbo].[Slide] ([ID], [Image], [Url], [IsShow], [ModifiedBy], [CreatedDate], [CreatedBy], [ModifiedDate], [Title], [Content]) VALUES (6, N'/ImageUpdate/files/ipad-pro-11-inch-2020-xam-400x460-fix-400x460.png', N'x', 0, NULL, NULL, NULL, NULL, N'dfd', N'<p>dfdf</p>
')
SET IDENTITY_INSERT [dbo].[Slide] OFF
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([ID], [Username], [Password], [Name], [Sex], [Address], [Email], [Phone], [UserGroupID], [IsLock]) VALUES (1, N'admin', N'admin', N'admin', NULL, NULL, NULL, NULL, 1, 0)
INSERT [dbo].[User] ([ID], [Username], [Password], [Name], [Sex], [Address], [Email], [Phone], [UserGroupID], [IsLock]) VALUES (2, N'minh', N'minh', N'Minh', NULL, N'HCM', N'minh@gmail.com', N'09088508', 2, 0)
INSERT [dbo].[User] ([ID], [Username], [Password], [Name], [Sex], [Address], [Email], [Phone], [UserGroupID], [IsLock]) VALUES (3, N'nguyen', N'nguyen', N'Nguyên', NULL, N'HCM', N'nguyen@gmail.com', N'08080008', 2, 1)
INSERT [dbo].[User] ([ID], [Username], [Password], [Name], [Sex], [Address], [Email], [Phone], [UserGroupID], [IsLock]) VALUES (4, N'luan', N'luan', N'Luân', NULL, N'HCM', N'luan@gmail.com', N'08085508', 2, 1)
SET IDENTITY_INSERT [dbo].[User] OFF
SET IDENTITY_INSERT [dbo].[UserGroup] ON 

INSERT [dbo].[UserGroup] ([ID], [GroupName], [Note]) VALUES (1, N'ADMIN', N'Quyền quản trị')
INSERT [dbo].[UserGroup] ([ID], [GroupName], [Note]) VALUES (2, N'GUEST', N'Khách')
SET IDENTITY_INSERT [dbo].[UserGroup] OFF
/****** Object:  Index [IX_Photos_UserId]    Script Date: 7/27/2020 4:29:15 AM ******/
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
/****** Object:  StoredProcedure [dbo].[GetRevenueStatistic]    Script Date: 7/27/2020 4:29:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[GetRevenueStatistic]
@fromDate [nvarchar](max),
@toDate [nvarchar](max)
AS 
BEGIN
select CAST(o.CreatedDate as Date) as Date,sum(od.Price*od.Quantity) as  Revenunes,sum(od.Price*od.Quantity - od.Quantity*p.OriginalPrice) as  Benefis from "Order" o
inner join OrderDetail od
on o.ID=od.OrderID 
inner join ProductVersions ver
on od.ProductVersionID=ver.ID
join Product p 
on ver.ProductID =p.ID
where o.CreatedDate>=@fromDate and o.CreatedDate<=@toDate
group by  CAST(o.CreatedDate as Date)
END

return;



select top 20 p.Name,p.CreatedDate,p.SEOUrl,p.OriginalPrice,p.Content,p.Description
,p.Deliver,p.ApplyPromotion,c.Name as CatalogName,c.ID as CatalogId
,ver.ID as VerID,ver.Quantum as VerQuanTum,ver.Price as VerPrice
,ver.PromotionPrice as VerPromotionPrice
,ver.Image as VerImage
from ProductVersions ver
join Product p
on p.ID= ver.ProductID
join Catalog c
on c.ID=p.CatalogID
join (select ver.ID,SUM(Quantity) as numBuy from ProductVersions ver
join OrderDetail o
on ver.ID =o.ProductVersionID
group by ver.ID) as child
on ver.ID=child.ID

order by child.numBuy desc


return;
select *
from [Order] o
join OrderDetail d
on o.ID=d.OrderID






return
--GET PRODUCT FOR LIST
select ver.ID as verID,ver.Barcode as verBarcode,ver.Description as verDescription,
ver.Image as verImage,ver.Price as verPrice,ver.PromotionPrice as verPromotionPrice,
ver.Quantum as verQuantum,ver.RemainingAmount as verRemainingAmount,
p.ID as pID,p.ApplyPromotion as pAppyPromotion,p.Content as pContent,
p.CreatedBy as pCreatedBy,p.CreatedDate as pCreatedDate,p.Deliver as pDeliver,
p.Description as pDescription,p.ModifiedBy as pModifiedBy, p.ModifiedDate as pModifiedDate,
p.Name as pName,p.OriginalPrice as pOriginalPrice,p.SEODescription as pSEODescription,
p.SEOTitle as pSEOTitle,p.Url as pUrl, p.Weight as pWeight,p.SEOUrl as pSeoURL,
c.ID as cID, c.Name as cName,c.ParentID as cParentID
from ProductVersions ver
join Product p
on ver.ProductID=p.ID
left join Catalog c
on p.CatalogID =c.ID
where 1=1
order by p.CreatedDate asc
GO
USE [master]
GO
ALTER DATABASE [EShop] SET  READ_WRITE 
GO
