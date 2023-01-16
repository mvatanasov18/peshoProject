USE [master]
GO
/****** Object:  Database [Hospital]    Script Date: 1/16/2023 9:27:36 PM ******/
CREATE DATABASE [Hospital]
    CONTAINMENT = NONE
    ON  PRIMARY
    ( NAME = N'Hospital', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Hospital.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
    LOG ON
    ( NAME = N'Hospital_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Hospital_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Hospital] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
    begin
        EXEC [Hospital].[dbo].[sp_fulltext_database] @action = 'enable'
    end
GO
ALTER DATABASE [Hospital] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [Hospital] SET ANSI_NULLS OFF
GO
ALTER DATABASE [Hospital] SET ANSI_PADDING OFF
GO
ALTER DATABASE [Hospital] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [Hospital] SET ARITHABORT OFF
GO
ALTER DATABASE [Hospital] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [Hospital] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [Hospital] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [Hospital] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [Hospital] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [Hospital] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [Hospital] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [Hospital] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [Hospital] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [Hospital] SET  DISABLE_BROKER
GO
ALTER DATABASE [Hospital] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [Hospital] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [Hospital] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [Hospital] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [Hospital] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [Hospital] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [Hospital] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [Hospital] SET RECOVERY SIMPLE
GO
ALTER DATABASE [Hospital] SET  MULTI_USER
GO
ALTER DATABASE [Hospital] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [Hospital] SET DB_CHAINING OFF
GO
ALTER DATABASE [Hospital] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF )
GO
ALTER DATABASE [Hospital] SET TARGET_RECOVERY_TIME = 60 SECONDS
GO
ALTER DATABASE [Hospital] SET DELAYED_DURABILITY = DISABLED
GO
ALTER DATABASE [Hospital] SET ACCELERATED_DATABASE_RECOVERY = OFF
GO
ALTER DATABASE [Hospital] SET QUERY_STORE = OFF
GO
USE [Hospital]
GO
/****** Object:  User [asdasd]    Script Date: 1/16/2023 9:27:36 PM ******/
CREATE USER [asdasd] FOR LOGIN [hui] WITH DEFAULT_SCHEMA=[db_owner]
GO
ALTER ROLE [db_owner] ADD MEMBER [asdasd]
GO
ALTER ROLE [db_accessadmin] ADD MEMBER [asdasd]
GO
ALTER ROLE [db_securityadmin] ADD MEMBER [asdasd]
GO
ALTER ROLE [db_ddladmin] ADD MEMBER [asdasd]
GO
ALTER ROLE [db_backupoperator] ADD MEMBER [asdasd]
GO
ALTER ROLE [db_datareader] ADD MEMBER [asdasd]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [asdasd]
GO
ALTER ROLE [db_denydatareader] ADD MEMBER [asdasd]
GO
ALTER ROLE [db_denydatawriter] ADD MEMBER [asdasd]
GO
/****** Object:  Table [dbo].[Addresses]    Script Date: 1/16/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Addresses](
                                  [ID] [int] IDENTITY(1,1) NOT NULL,
                                  [City] [nvarchar](100) NOT NULL,
                                  [Country] [nvarchar](50) NOT NULL,
                                  [Street] [nvarchar](100) NOT NULL,
                                  [HouseNumber] [int] NOT NULL,
                                  PRIMARY KEY CLUSTERED
                                      (
                                       [ID] ASC
                                          )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Doctors]    Script Date: 1/16/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Doctors](
                                [ID] [int] IDENTITY(1,1) NOT NULL,
                                [Specialization] [nvarchar](100) NOT NULL,
                                [Email] [varchar](100) NOT NULL,
                                [UserID] [int] NOT NULL,
                                PRIMARY KEY CLUSTERED
                                    (
                                     [ID] ASC
                                        )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
                                UNIQUE NONCLUSTERED
                                    (
                                     [Email] ASC
                                        )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Patients]    Script Date: 1/16/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Patients](
                                 [ID] [int] IDENTITY(1,1) NOT NULL,
                                 [DateOfBirth] [date] NOT NULL,
                                 [Condition] [nvarchar](255) NOT NULL,
                                 [Medicaments] [nvarchar](500) NULL,
                                 [SurgeryRequired] [bit] NOT NULL,
                                 [UserID] [int] NOT NULL,
                                 PRIMARY KEY CLUSTERED
                                     (
                                      [ID] ASC
                                         )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Receptionists]    Script Date: 1/16/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Receptionists](
                                      [ID] [int] IDENTITY(1,1) NOT NULL,
                                      [Email] [varchar](100) NOT NULL,
                                      [UserID] [int] NOT NULL,
                                      PRIMARY KEY CLUSTERED
                                          (
                                           [ID] ASC
                                              )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
                                      UNIQUE NONCLUSTERED
                                          (
                                           [Email] ASC
                                              )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Relatives]    Script Date: 1/16/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Relatives](
                                  [ID] [int] IDENTITY(1,1) NOT NULL,
                                  [FirstName] [nvarchar](100) NOT NULL,
                                  [LastName] [nvarchar](100) NOT NULL,
                                  [Phone] [char](12) NOT NULL,
                                  [AddressID] [int] NOT NULL,
                                  PRIMARY KEY CLUSTERED
                                      (
                                       [ID] ASC
                                          )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 1/16/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
                              [ID] [int] IDENTITY(1,1) NOT NULL,
                              [Username] [varchar](100) NOT NULL,
                              [Password] [varbinary](max) NOT NULL,
                              [FirstName] [nvarchar](50) NOT NULL,
                              [LastName] [nvarchar](50) NOT NULL,
                              [Phone] [char](12) NOT NULL,
                              [AddressID] [int] NOT NULL,
                              CONSTRAINT [PK__Users__3214EC27CD6C6A2A] PRIMARY KEY CLUSTERED
                                  (
                                   [ID] ASC
                                      )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
                              CONSTRAINT [UQ__Users__536C85E4B2A2FD9B] UNIQUE NONCLUSTERED
                                  (
                                   [Username] ASC
                                      )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Visits]    Script Date: 1/16/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Visits](
                               [PatientID] [int] NOT NULL,
                               [RelativeID] [int] NOT NULL,
                               [VisitTime] [datetime2](0) NOT NULL,
                               PRIMARY KEY CLUSTERED
                                   (
                                    [PatientID] ASC,
                                    [RelativeID] ASC
                                       )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Patients] ADD  DEFAULT ((0)) FOR [SurgeryRequired]
GO
ALTER TABLE [dbo].[Doctors]  WITH CHECK ADD  CONSTRAINT [FK__Doctors__UserID__34C8D9D1] FOREIGN KEY([UserID])
    REFERENCES [dbo].[Users] ([ID])
GO
ALTER TABLE [dbo].[Doctors] CHECK CONSTRAINT [FK__Doctors__UserID__34C8D9D1]
GO
ALTER TABLE [dbo].[Patients]  WITH CHECK ADD  CONSTRAINT [FK__Patients__UserID__2C3393D0] FOREIGN KEY([UserID])
    REFERENCES [dbo].[Users] ([ID])
GO
ALTER TABLE [dbo].[Patients] CHECK CONSTRAINT [FK__Patients__UserID__2C3393D0]
GO
ALTER TABLE [dbo].[Receptionists]  WITH CHECK ADD  CONSTRAINT [FK__Reception__UserI__300424B4] FOREIGN KEY([UserID])
    REFERENCES [dbo].[Users] ([ID])
GO
ALTER TABLE [dbo].[Receptionists] CHECK CONSTRAINT [FK__Reception__UserI__300424B4]
GO
ALTER TABLE [dbo].[Relatives]  WITH CHECK ADD FOREIGN KEY([AddressID])
    REFERENCES [dbo].[Addresses] ([ID])
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK__Users__AddressID__286302EC] FOREIGN KEY([AddressID])
    REFERENCES [dbo].[Addresses] ([ID])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK__Users__AddressID__286302EC]
GO
ALTER TABLE [dbo].[Visits]  WITH CHECK ADD FOREIGN KEY([PatientID])
    REFERENCES [dbo].[Patients] ([ID])
GO
ALTER TABLE [dbo].[Visits]  WITH CHECK ADD FOREIGN KEY([RelativeID])
    REFERENCES [dbo].[Relatives] ([ID])
GO
ALTER TABLE [dbo].[Addresses]  WITH CHECK ADD CHECK  (([HouseNumber]>(0)))
GO
/****** Object:  StoredProcedure [dbo].[CheckPassword]    Script Date: 1/16/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CheckPassword]
    @username varchar(100),
    @password varchar(MAX)
AS
BEGIN

    SET NOCOUNT ON;

    SELECT IIF (HASHBYTES('SHA2_512',@password)= [Password],1,0)
    FROM Users
    WHERE Username=@username
END
GO
/****** Object:  StoredProcedure [dbo].[CreateUser]    Script Date: 1/16/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[CreateUser]

    @Username varchar(100),
    @Password varchar(MAX),
    @FirstName nvarchar(100),
    @LastName nvarchar(100),
    @Phone char(12),
    @AddressID int

AS
BEGIN

    SET NOCOUNT ON;
    INSERT INTO Users(Username,[Password],FirstName,LastName,Phone,AddressID)
    VALUES(
              @Username,
              CONVERT(varbinary(MAX),@Password),
              @FirstName,
              @LastName,
              @Phone,
              @AddressID)

END
GO
USE [master]
GO
ALTER DATABASE [Hospital] SET  READ_WRITE
GO



SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   TRIGGER [dbo].[HashPassword]
    ON  [dbo].[Users]
    INSTEAD OF INSERT
    AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO Users(Username,[Password],FirstName,LastName,Phone,AddressID)
    SELECT
        i.Username,
        HASHBYTES('SHA2_512',i.[Password]),
        i.FirstName,
        i.LastName,
        i.Phone,
        i.AddressID
    FROM inserted AS i

END