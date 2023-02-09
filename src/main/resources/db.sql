USE Hospital;
GO

CREATE TABLE Addresses(
                          Id varchar(36) PRIMARY KEY,
                          Country nvarchar(100) NOT NULL,
                          City nvarchar(100) NOT NULL,
                          Street nvarchar(100) NOT NULL,
                          Number int NOT NULL
)
CREATE TABLE Hospitals(
                          Id varchar(36) PRIMARY KEY,
    [Name] nvarchar(150) NOT NULL,
    AddressId varchar(36) UNIQUE,
    FOREIGN KEY(AddressId) REFERENCES Addresses(Id)
    )
CREATE TABLE Users(
                      Id varchar(36) PRIMARY KEY,
                      Username nvarchar(150) UNIQUE NOT NULL,
    [Password] varbinary(MAX) NOT NULL,
    FirstName nvarchar(100) NOT NULL,
    LastName nvarchar(100) NOT NULL,
    IsAdmin bit NOT NULL,
    HospitalId varchar(36) NOT NULL,
    FOREIGN KEY(HospitalId) REFERENCES Hospitals(Id)
    )

CREATE TABLE Relatives(
                          UserId varchar(36),
                          AddressId varchar(36),
                          PRIMARY KEY(UserId),
                          FOREIGN KEY(UserId) REFERENCES Users(Id),
                          FOREIGN KEY(AddressId) REFERENCES Addresses(Id)
)



CREATE TABLE Doctors(
                        Id varchar(36) PRIMARY KEY,
                        Specialization nvarchar(70) NOT NULL,
                        UserId varchar(36) UNIQUE,
                        FOREIGN KEY (UserId) REFERENCES Users(Id),
)

CREATE TABLE Patients(
                         Id varchar(36) PRIMARY KEY,
                         DateOfBirth date NOT NULL,
                         Condition nvarchar(255) NOT NULL,
                         SurgeryRequired bit NOT NULL,
                         UserId varchar(36) UNIQUE,
                         FOREIGN KEY (UserId) REFERENCES Users(Id),
)
CREATE TABLE Medicines(
                          Id varchar(36) PRIMARY KEY,
    [Name] NVARCHAR(70) NOT NULL,
    Quantity int NOT NULL,
    [Description] nvarchar(MAX) NOT NULL
)
CREATE TABLE PatientsMedicines(
                                  PatientId varchar(36),
                                  MedicineId varchar(36),
                                  PRIMARY KEY(PatientId,MedicineId),
                                  FOREIGN KEY(PatientId) REFERENCES Patients(Id),
                                  FOREIGN KEy(MedicineId) REFERENCES Medicines(Id)
)

CREATE TABLE Receptionists(
                              Id varchar(36) PRIMARY KEY,
                              UserId varchar(36) UNIQUE,
                              FOREIGN KEY (UserId) REFERENCES Users(Id)
)
CREATE TABLE Treatments(
                           Id varchar(36) PRIMARY KEY,
    [Name] nvarchar(255) NOT NULL,
    [Time] datetime2(0) NOT NULL,
    [Description] nvarchar(MAX) NOT NULL,
    PatientId varchar(36),
    FOREIGN KEY (PatientId) REFERENCES Patients(Id)
    )
CREATE TABLE ReceptionistsTreatments(
                                        ReceptionistsId varchar(36),
                                        TreatmentId varchar(36),
                                        PRIMARY KEY(ReceptionistsId,TreatmentId),
                                        FOREIGN KEY(ReceptionistsId) REFERENCES Receptionists(Id),
                                        FOREIGN KEY(TreatmentId) REFERENCES Treatments(Id)
)

CREATE TABLE DischargeSummaries(
                                   Id varchar(36) PRIMARY KEY,
    [File] varbinary(MAX) NOT NULL,
    DoctorId varchar(36),
    PatientId varchar(36),
    FOREIGN KEY(DoctorId) REFERENCES Doctors(Id),
    FOREIGN KEY(PatientId) REFERENCES Patients(Id),
    )
CREATE TABLE Visits(
                       PatientId varchar(36),
                       RelativeId varchar(36),
                       VisitTime datetime2(0) NOT NULL,
                       PRIMARY KEY(PatientId,RelativeId),
                       FOREIGN KEY(PatientID) REFERENCES Patients(Id),
                       FOREIGN KEY(RelativeId) REFERENCES Relatives(UserId)
)
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
