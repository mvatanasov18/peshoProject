USE [master]
GO
/****** Object:  Database [Hospital]    Script Date: 2/8/2023 9:32:00 AM ******/
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
/****** Object:  Table [dbo].[Addresses]    Script Date: 2/8/2023 9:32:00 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Addresses](
    [Id] [varchar](36) NOT NULL,
    [Country] [nvarchar](100) NOT NULL,
    [City] [nvarchar](100) NOT NULL,
    [Street] [nvarchar](100) NOT NULL,
    [Number] [int] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[DischargeSummaries]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[DischargeSummaries](
    [Id] [varchar](36) NOT NULL,
    [File] [varbinary](max) NOT NULL,
    [DoctorId] [varchar](36) NOT NULL,
    [PatientId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Doctors]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Doctors](
    [Id] [varchar](36) NOT NULL,
    [Specialization] [nvarchar](70) NOT NULL,
    [UserId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Hospitals]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Hospitals](
    [Id] [varchar](36) NOT NULL,
    [Name] [varchar](36) NOT NULL,
    [AddressId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[AddressId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Medicines]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Medicines](
    [Id] [varchar](36) NOT NULL,
    [Name] [nvarchar](70) NOT NULL,
    [Quantity] [int] NOT NULL,
    [Description] [nvarchar](max) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Patients]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Patients](
    [Id] [varchar](36) NOT NULL,
    [DateOfBirth] [date] NOT NULL,
    [Condition] [nvarchar](255) NOT NULL,
    [SurgeryRequired] [bit] NOT NULL,
    [UserId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[PatientsMedicines]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[PatientsMedicines](
    [PatientId] [varchar](36) NOT NULL,
    [MedicineId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
    [PatientId] ASC,
[MedicineId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Receptionists]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Receptionists](
    [Id] [varchar](36) NOT NULL,
    [UserId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[ReceptionistsTreatments]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[ReceptionistsTreatments](
    [ReceptionistId] [varchar](36) NOT NULL,
    [TreatmentId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
    [ReceptionistId] ASC,
[TreatmentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Relatives]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Relatives](
    [UserId] [varchar](36) NOT NULL,
    [AddressId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Treatments]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Treatments](
    [Id] [varchar](36) NOT NULL,
    [Name] [nvarchar](255) NOT NULL,
    [Time] [datetime2](0) NOT NULL,
    [Description] [nvarchar](max) NOT NULL,
    [PatientId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Users]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Users](
    [Id] [varchar](36) NOT NULL,
    [Username] [varchar](100) NOT NULL,
    [Password] [varbinary](max) NOT NULL,
    [FirstName] [nvarchar](100) NOT NULL,
    [LastName] [nvarchar](100) NOT NULL,
    [IsAdmin] [bit] NOT NULL,
    [HospitalId] [varchar](36) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
(
[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Visits]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Visits](
    [PatientId] [varchar](36) NOT NULL,
    [RelativeId] [varchar](36) NOT NULL,
    [VisitTime] [datetime2](0) NOT NULL,
    PRIMARY KEY CLUSTERED
(
    [PatientId] ASC,
[RelativeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
ALTER TABLE [dbo].[DischargeSummaries]  WITH CHECK ADD FOREIGN KEY([DoctorId])
    REFERENCES [dbo].[Doctors] ([Id])
    GO
ALTER TABLE [dbo].[DischargeSummaries]  WITH CHECK ADD FOREIGN KEY([PatientId])
    REFERENCES [dbo].[Patients] ([Id])
    GO
ALTER TABLE [dbo].[Doctors]  WITH CHECK ADD FOREIGN KEY([UserId])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[Hospitals]  WITH CHECK ADD FOREIGN KEY([AddressId])
    REFERENCES [dbo].[Addresses] ([Id])
    GO
ALTER TABLE [dbo].[Patients]  WITH CHECK ADD FOREIGN KEY([UserId])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[PatientsMedicines]  WITH CHECK ADD FOREIGN KEY([MedicineId])
    REFERENCES [dbo].[Medicines] ([Id])
    GO
ALTER TABLE [dbo].[PatientsMedicines]  WITH CHECK ADD FOREIGN KEY([PatientId])
    REFERENCES [dbo].[Patients] ([Id])
    GO
ALTER TABLE [dbo].[Receptionists]  WITH CHECK ADD FOREIGN KEY([UserId])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[ReceptionistsTreatments]  WITH CHECK ADD FOREIGN KEY([ReceptionistId])
    REFERENCES [dbo].[Receptionists] ([Id])
    GO
ALTER TABLE [dbo].[ReceptionistsTreatments]  WITH CHECK ADD FOREIGN KEY([TreatmentId])
    REFERENCES [dbo].[Treatments] ([Id])
    GO
ALTER TABLE [dbo].[Relatives]  WITH CHECK ADD FOREIGN KEY([AddressId])
    REFERENCES [dbo].[Addresses] ([Id])
    GO
ALTER TABLE [dbo].[Relatives]  WITH CHECK ADD FOREIGN KEY([UserId])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[Treatments]  WITH CHECK ADD FOREIGN KEY([PatientId])
    REFERENCES [dbo].[Patients] ([Id])
    GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD FOREIGN KEY([Id])
    REFERENCES [dbo].[Hospitals] ([Id])
    GO
ALTER TABLE [dbo].[Visits]  WITH CHECK ADD FOREIGN KEY([PatientId])
    REFERENCES [dbo].[Patients] ([Id])
    GO
ALTER TABLE [dbo].[Visits]  WITH CHECK ADD FOREIGN KEY([RelativeId])
    REFERENCES [dbo].[Relatives] ([UserId])
    GO
ALTER TABLE [dbo].[Medicines]  WITH CHECK ADD CHECK  (([Quantity]>(0)))
    GO
/****** Object:  StoredProcedure [dbo].[CheckPass]    Script Date: 2/8/2023 9:32:00 AM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO

CREATE   PROCEDURE [dbo].[CheckPass]
@Username varchar(100),
@Password varchar(MAX)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
SELECT IIF(HASHBYTES('SHA2_512', CONVERT(varbinary(MAX),  @Password))= [Password],1,0) FROM Users
WHERE Username=@Username;
END
GO
/****** Object:  StoredProcedure [dbo].[InsertUser]    Script Date: 2/8/2023 9:32:00 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================

CREATE PROCEDURE [dbo].[InsertUser]
	@Username varchar(100),
	@Password varchar(MAX),
	@FirstName nvarchar(100),
	@LastName nvarchar(100),
	@IsAdmin bit,
	@HospitalId varchar(36)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

INSERT INTO Users(Username,[Password],FirstName,LastName,
                  IsAdmin,HospitalId)
VALUES (@Username,CONVERT(varbinary(MAX),@Password),
        @FirstName,@LastName,@IsAdmin,@HospitalId)
END
GO
USE [master]
GO
ALTER DATABASE [Hospital] SET  READ_WRITE
GO


USE Hospital;

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE OR ALTER TRIGGER HashPassword ON Users
   INSTEAD OF INSERT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

INSERT INTO Users(Username,[Password],FirstName,LastName,
                  IsAdmin,HospitalId)
SELECT i.Username,HASHBYTES('SHA2_512',i.[Password]),
       i.FirstName,i.LastName,i.IsAdmin,i.HospitalId
FROM inserted as i

END
GO
