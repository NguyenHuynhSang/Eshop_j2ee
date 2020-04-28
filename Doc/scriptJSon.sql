USE [master]
GO
/****** Object:  Database [TestJSon]    Script Date: 4/28/2020 7:47:58 PM ******/
CREATE DATABASE [TestJSon]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TestJSon', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\TestJSon.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'TestJSon_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\TestJSon_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [TestJSon] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TestJSon].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TestJSon] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TestJSon] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TestJSon] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TestJSon] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TestJSon] SET ARITHABORT OFF 
GO
ALTER DATABASE [TestJSon] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TestJSon] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TestJSon] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TestJSon] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TestJSon] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TestJSon] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TestJSon] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TestJSon] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TestJSon] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TestJSon] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TestJSon] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TestJSon] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TestJSon] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TestJSon] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TestJSon] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TestJSon] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TestJSon] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TestJSon] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [TestJSon] SET  MULTI_USER 
GO
ALTER DATABASE [TestJSon] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TestJSon] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TestJSon] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TestJSon] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [TestJSon] SET DELAYED_DURABILITY = DISABLED 
GO
USE [TestJSon]
GO
/****** Object:  Table [dbo].[JSon]    Script Date: 4/28/2020 7:47:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JSon](
	[ID] [int] NULL,
	[Name] [nvarchar](50) NULL
) ON [PRIMARY]

GO
USE [master]
GO
ALTER DATABASE [TestJSon] SET  READ_WRITE 
GO
