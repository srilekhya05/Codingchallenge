CREATE DATABASE IF NOT EXISTS PetPals;
USE PetPals;
CREATE TABLE IF NOT EXISTS Shelters (
    ShelterID INT,
    Name VARCHAR(60),
    Location VARCHAR(100)
);
 
   CREATE TABLE IF NOT EXISTS Pets (
    PetID INT,
    Name VARCHAR(60),
    Age INT,
    Breed VARCHAR(60),
    Type VARCHAR(60),
     ShelterID INT,
    AvailableForAdoption BIT
);

CREATE TABLE IF NOT EXISTS Donations (
    DonationID INT,
    ShelterID INT,
    DonorName VARCHAR(60),
    DonationType VARCHAR(20),
    DonationAmount DECIMAL,
    DonationItem VARCHAR(60),
    DonationDate DATETIME
);

CREATE TABLE IF NOT EXISTS AdoptionEvents (
    EventID INT,
    ShelterID INT,
    EventName VARCHAR(60),
    EventDate DATETIME,
    Location VARCHAR(70)
);

CREATE TABLE IF NOT EXISTS Participants (
    ParticipantID INT,
    ShelterID INT,
    ParticipantName VARCHAR(60),
    ParticipantType VARCHAR(60),
    EventID INT
);
ALTER TABLE Shelters ADD PRIMARY KEY (ShelterID);
ALTER TABLE Pets ADD PRIMARY KEY (PetID);
ALTER TABLE Pets ADD FOREIGN KEY (ShelterID) REFERENCES shelters(shelterid);
ALTER TABLE Donations ADD PRIMARY KEY (DonationID);
ALTER TABLE Donations ADD FOREIGN KEY (ShelterID) REFERENCES shelters(shelterid);
ALTER TABLE AdoptionEvents ADD PRIMARY KEY (EventID);
ALTER TABLE AdoptionEvents ADD FOREIGN KEY (ShelterID) REFERENCES shelters(shelterid);
ALTER TABLE Participants ADD PRIMARY KEY (ParticipantID);

INSERT INTO Shelters (ShelterID, Name, Location)
VALUES
(1, 'Eternal Love Pet Haven', 'Delhi'),
(2, 'Wagging Tails Canine Haven', 'Karnataka'),
(3, 'Safe Haven Pet Center', 'Mumbai'),
(4, 'Loving Care Shelter', '101 Maple Ave, Karnataka'),
(5, 'Precious Paws Adoption Center', 'AP'),
(6, 'Whisker Haven', 'Delhi'),
(7, 'Adoptable Companions Haven', 'Mumbai'),
(8, 'Purrfect Haven', 'Delhi');
INSERT INTO Pets (PetID, Name, Age, Breed, Type, ShelterID,AvailableForAdoption)
VALUES
(1, 'Minni', 3, 'Dachshund', 'Dog', 1,1),
(2, 'Rocky', 2, 'Siamese', 'Cat',3, 1),
(3, 'Max', 4, 'Beagle', 'Dog',4, 0),
(4, 'Pluto', 3, 'Husky', 'Dog',7, 0),
(5, 'Charlie', 2, 'Beagle', 'Dog',3, 1),
(6, 'Snoopy', 3, 'Labrador', 'Cat',1, 0),
(7, 'Max', 3, 'Bengal', 'Cat', 3,0),
(8, 'Coco', 4, 'Calico', 'Cat',5, 1);



INSERT INTO Donations (DonationID, ShelterID,DonorName, DonationType, DonationAmount, DonationItem, DonationDate)
VALUES
  (1, 2,'Keerthana', 'Item', NULL, 'Leashes', '2021-04-30'),
  (2,3, 'Tarun', 'Cash', 1000.00, NULL, '2023-04-05'),
  (3, 4, 'Virat', 'Item', NULL, 'PetFood', '2022-07-05'),
  (4, 6,'Priya', 'Cash', 6000.00, NULL, '2021-11-05'),
  (5, 5,'Divya', 'Item', NULL, 'Collars', '2020-10-20'),
  (6, 2,'Arjun', 'Cash', 4000.00, NULL, '2023-09-15'),
  (7, 4,'Vijay', 'Cash', 5000.00, NULL, '2020-06-15'),
  (8,6, 'Makram', 'Item', NULL, 'Dog Bowls', '2019-02-20');
  
INSERT INTO AdoptionEvents (EventID, ShelterID, EventName, EventDate, Location)
VALUES
  (1,3, 'Rescue Rally', '2019-11-25 12:45:00', 'Mumbai'),
  (2,1, 'Heartfelt Homes Showcase', '2020-08-30 15:30:00', 'Delhi'),
  (3,4, 'Meow Mania', '2020-06-20 13:00:00', 'Chennai'),
  (4,1, 'Cuddle Fest', '2023-03-25 10:30:00', 'AP'),
   (5,2, 'Eternal Love Fair', '2022-08-30 16:00:00', 'Mumbai'),
  (6, 8,'Joyful Jamboree', '2022-10-20 14:00:00', 'Delhi'),
  (7,3, 'Tail Waggers Showcase', '2023-01-15 11:00:00', 'Karnataka'),
  (8,7, 'Guardian Angels Showcase', '2022-06-20 14:30:00', 'Gujarat');

INSERT INTO Participants (ParticipantID, ParticipantName, ParticipantType, EventID)
VALUES
  (1, 'Caring Families Foundation', 'Adopter', 2),
  (2, 'Furry Friends Adoption Center', 'Shelter', 2),
  (3, 'Hearts United Animal Rescue', 'Shelter', 5),
 (4, 'Loyal Hearts Society', 'Adopter', 4),
  (5, 'Lifelong Furry Friends', 'Adopter', 7),
  (6, 'Kindred Spirits Adoption', 'Adopter', 8),
  (7, 'Pawsome Companions', 'Adopter', 3),
  (8, 'Loving Care Animal Shelter', 'Shelter', 8);