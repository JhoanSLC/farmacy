DROP DATABASE IF EXISTS farmacy;
CREATE DATABASE farmacy;
USE farmacy;

CREATE TABLE modeAdministration(
	id INT AUTO_INCREMENT PRIMARY KEY,
    descriptionMode VARCHAR(60) NOT NULL
);

CREATE TABLE unitMeasurement(
	idUm INT AUTO_INCREMENT PRIMARY KEY,
    nameUm VARCHAR(50) NOT NULL
);

CREATE TABLE activePrinciple(
	idAp INT AUTO_INCREMENT PRIMARY KEY,
    nameAp VARCHAR(60) NOT NULL
);

CREATE TABLE country(
	codeCountry VARCHAR(5) PRIMARY KEY UNIQUE,
    nameCountry VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE region(
	codeReg VARCHAR(5) PRIMARY KEY UNIQUE,
    nameReg VARCHAR(50) UNIQUE NOT NULL,
    codeCountry VARCHAR(5) NOT NULL,
    CONSTRAINT FkRegionCountry FOREIGN KEY (codeCountry) REFERENCES country(codeCountry)
);

CREATE TABLE city(
	codeCty VARCHAR(5) PRIMARY KEY UNIQUE,
    nameCity VARCHAR(50) NOT NULL,
    codeReg VARCHAR(5) NOT NULL,
    CONSTRAINT FkCityRegion FOREIGN KEY (codeReg) REFERENCES region(codeReg),
    CONSTRAINT UkNameCityRegion UNIQUE (nameCity,codeReg)
);

CREATE TABLE customer(
	idCustomer VARCHAR(20) PRIMARY KEY UNIQUE,
    nameCustomer VARCHAR(50) NOT NULL,
    lastNameCustomer VARCHAR(50),
    codeCityCustomer VARCHAR(5) NOT NULL,
    emailCustomer VARCHAR(100),
    birthDate DATE,
    lon DOUBLE,
    latitud DOUBLE,
    CONSTRAINT FkCityCustomer FOREIGN KEY (codeCityCustomer) REFERENCES city(codeCity)
);

CREATE TABLE labatory(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nameLab VARCHAR(50) NOT NULL,
    codeCityReg VARCHAR(5) NOT NULL,
    CONSTRAINT FkLabCity FOREIGN KEY (codeCityReg) REFERENCES city(codeCity),
    CONSTRAINT UkLabNameCity UNIQUE (nameLab,codeCityReg)
);

CREATE TABLE medicine(
	id INT AUTO_INCREMENT PRIMARY KEY,
    proceedings VARCHAR(10),
    nameMedicine VARCHAR(100) NOT NULL,
    healthRegister VARCHAR(50),
    descriptionLong TEXT,
    descriptionShort VARCHAR(60),
    codeModeAdmin INT NOT NULL,
    codeAp INT NOT NULL,
    codeUm INT NOT NULL,
    nameRol VARCHAR(100),
    codeLab INT NOT NULL,
    CONSTRAINT FkMedicineModeAd FOREIGN KEY (codeModeAdmin) REFERENCES modeAdministration(id),
    CONSTRAINT FkMedicineAp FOREIGN KEY (codeAp) REFERENCES activePrinciple(idAp),
    CONSTRAINT FkMedicineUm FOREIGN KEY (codeUm) REFERENCES unitMeasurement(idUm),
    CONSTRAINT FkMedicineLab FOREIGN KEY (codeLab) REFERENCES labatory(id)
);

CREATE TABLE farmacy(
	idFarmacy INT AUTO_INCREMENT PRIMARY KEY,
    nameFarmacy VARCHAR(60) NOT NULL,
    addressFarmacy VARCHAR(100),
    lonFarmacy DOUBLE,
    latFarmacy DOUBLE,
    codeCityFarm VARCHAR(5) NOT NULL,
    logoFarmacy VARCHAR(50),
    CONSTRAINT FkFarmacyCity FOREIGN KEY (codeCityFarm) REFERENCES city(codeCity)
);

CREATE TABLE farmacyMedicine(
	idFarmacyMedicine INT AUTO_INCREMENT PRIMARY KEY,
    idFarmacy INT NOT NULL,
    idMedicineFatrm INT NOT NULL,
    price DOUBLE NOT NULL,
    CONSTRAINT FkFMMedicine FOREIGN KEY (idMedicineFatrm) REFERENCES medicine(id),
    CONSTRAINT FkFmFarmacy FOREIGN KEY (idFarmacy) REFERENCES farmacy(idFarmacy)
);

