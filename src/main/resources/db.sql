CREATE TABLE Addresses(
                          ID int NOT NULL IDENTITY(1,1) PRIMARY KEY,
                          City nvarchar(100) NOT NULL,
                          Country nvarchar(50) NOT NULL,
                          Street nvarchar(100) NOT NULL ,
                          HouseNumber int NOT NULL CHECK(HouseNumber>0),
);

CREATE TABLE Users(
                      ID int NOT NULL IDENTITY(1,1) PRIMARY KEY,
                      Username varchar(100) NOT NULL UNIQUE,
    [Password] varbinary(MAX) NOT NULL,
    FirstName nvarchar(50) NOT NULL,
    LastName nvarchar(50) NOT NULL,
    [Phone] char(10) NULL,
    AddressID int NOT NULL,
    FOREIGN KEY (AddressID) REFERENCES Addresses(ID)
    );

CREATE TABLE Patients(
                         ID int NOT NULL PRIMARY KEY IDENTITY(1,1),
                         DateOfBirth date NOT NULL,
                         Condition nvarchar(255) NOT NULL,
                         Medicaments nvarchar(500) NULL,
                         SurgeryRequired bit NOT NULL DEFAULT 0,
                         UserID int NOT NULL,
                         FOREIGN KEY (UserID) REFERENCES Users(ID)
);
CREATE TABLE Receptionists(
                              ID int NOT NULL PRIMARY KEY IDENTITY(1,1),
                              Email varchar(100) NOT NULL UNIQUE,
                              UserID int NOT NULL,
                              AddressID int NOT NULL,
                              FOREIGN KEY (UserID) REFERENCES Users(ID),
                              FOREIGN KEY (AddressID) REFERENCES Addresses
);
CREATE TABLE Doctors(
                        ID int NOT NULL PRIMARY KEY IDENTITY(1,1),
                        Specialization nvarchar(100) NOT NULL,
                        Email varchar(100) NOT NULL UNIQUE,
                        UserID int NOT NULL,
                        AddressID int NOT NULL,
                        FOREIGN KEY (UserID) REFERENCES Users(ID),
                        FOREIGN KEY (AddressID) REFERENCES Addresses(ID)
);
CREATE TABLE Relatives(
                          ID int NOT NULL PRIMARY KEY IDENTITY(1,1),
                          FirstName nvarchar(100) NOT NULL,
                          LastName nvarchar(100) NOT NULL,
                          Phone char(10) NOT NULL,
                          AddressID int NOT NULL,
                          FOREIGN KEY (AddressID) REFERENCES Addresses(ID)
);
CREATE TABLE Visits(
                       ID int NOT NULL IDENTITY(1,1) PRIMARY KEY,
                       PatientID int NOT NULL,
                       RelativeID int NOT NULL,
                       VisitTime datetime2(0) NOT NULL,
                       FOREIGN KEY (PatientID) REFERENCES Patients(ID),
                       FOREIGN KEY (RelativeID) REFERENCES Relatives(ID)
)CREATE TABLE Addresses(
ID int NOT NULL IDENTITY(1,1) PRIMARY KEY,
City nvarchar(100) NOT NULL,
Country nvarchar(50) NOT NULL,
Street nvarchar(100) NOT NULL ,
HouseNumber int NOT NULL CHECK(HouseNumber>0),
);

CREATE TABLE Users(
                      ID int NOT NULL IDENTITY(1,1) PRIMARY KEY,
                      Username varchar(100) NOT NULL UNIQUE,
    [Password] varbinary(MAX) NOT NULL,
    FirstName nvarchar(50) NOT NULL,
    LastName nvarchar(50) NOT NULL,
    [Phone] char(10) NULL,
    AddressID int NOT NULL,
    FOREIGN KEY (AddressID) REFERENCES Addresses(ID)
    );

CREATE TABLE Patients(
                         ID int NOT NULL PRIMARY KEY IDENTITY(1,1),
                         DateOfBirth date NOT NULL,
                         Condition nvarchar(255) NOT NULL,
                         Medicaments nvarchar(500) NULL,
                         SurgeryRequired bit NOT NULL DEFAULT 0,
                         UserID int NOT NULL,
                         FOREIGN KEY (UserID) REFERENCES Users(ID)
);
CREATE TABLE Receptionists(
                              ID int NOT NULL PRIMARY KEY IDENTITY(1,1),
                              Email varchar(100) NOT NULL UNIQUE,
                              UserID int NOT NULL,
                              AddressID int NOT NULL,
                              FOREIGN KEY (UserID) REFERENCES Users(ID),
                              FOREIGN KEY (AddressID) REFERENCES Addresses
);
CREATE TABLE Doctors(
                        ID int NOT NULL PRIMARY KEY IDENTITY(1,1),
                        Specialization nvarchar(100) NOT NULL,
                        Email varchar(100) NOT NULL UNIQUE,
                        UserID int NOT NULL,
                        AddressID int NOT NULL,
                        FOREIGN KEY (UserID) REFERENCES Users(ID),
                        FOREIGN KEY (AddressID) REFERENCES Addresses(ID)
);
CREATE TABLE Relatives(
                          ID int NOT NULL PRIMARY KEY IDENTITY(1,1),
                          FirstName nvarchar(100) NOT NULL,
                          LastName nvarchar(100) NOT NULL,
                          Phone char(10) NOT NULL,
                          AddressID int NOT NULL,
                          FOREIGN KEY (AddressID) REFERENCES Addresses(ID)
);
CREATE TABLE Visits(
                       ID int NOT NULL IDENTITY(1,1) PRIMARY KEY,
                       PatientID int NOT NULL,
                       RelativeID int NOT NULL,
                       VisitTime datetime2(0) NOT NULL,
                       FOREIGN KEY (PatientID) REFERENCES Patients(ID),
                       FOREIGN KEY (RelativeID) REFERENCES Relatives(ID)
)