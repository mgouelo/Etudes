/*
SAE SQL Tache n°1 : Création des tables
Etudiant 1 : BROCARD Célian
Etudiant 2 : GOUELO Matthieu
*/


DROP TABLE Location;
DROP TABLE Vente;
DROP TABLE Client;
DROP TABLE Bien;
DROP TABLE Agent;
DROP TABLE Agence;

CREATE TABLE Agence (
    numAgence NUMBER 
        CONSTRAINT pk_numAgence PRIMARY KEY,
    adresseAgence VARCHAR2(50),
    horaires VARCHAR2(50)
);

CREATE TABLE Agent (
    numAgent NUMBER
        CONSTRAINT pk_numAgent PRIMARY KEY,
    nom VARCHAR2(50) 
        CONSTRAINT nn_nom NOT NULL,
    prenom VARCHAR2(50),
    salaire NUMBER(6, 2)
        CONSTRAINT ck_salaire CHECK (salaire > 2 * 1767),
    estResponsable CHAR(1)
        CONSTRAINT ck_estResponsable CHECK (estResponsable IN ('V', 'F')),
    sonAgence NUMBER 
        CONSTRAINT fk_numAgence REFERENCES Agence(numAgence)
);

CREATE TABLE Bien (
    idBien NUMBER 
        CONSTRAINT pk_idBien PRIMARY KEY,
    adresse VARCHAR2(50) 
        CONSTRAINT nn_adresse NOT NULL
        CONSTRAINT uq_adresse UNIQUE,
    nbPieces NUMBER
        CONSTRAINT nn_nbPieces NOT NULL,
    valeur NUMBER(8, 2)
        CONSTRAINT ck_valeur CHECK (valeur > 0),
    anneeConst NUMBER,
    cave CHAR(1)
        CONSTRAINT ck_cave CHECK (cave IN ('V', 'F')),
    parking CHAR(1)
        CONSTRAINT ck_parking CHECK (parking IN ('V', 'F')),
    enTravaux CHAR(1)
        CONSTRAINT ck_enTravaux CHECK (enTravaux IN ('V', 'F')),
    unAgent NUMBER
        CONSTRAINT fk_unAgent REFERENCES Agent(numAgent)
);

CREATE TABLE Client (
    idClient NUMBER 
        CONSTRAINT pk_Client PRIMARY KEY,
    nomClient VARCHAR2(50) 
        CONSTRAINT nn_nomClient NOT NULL,
    prenomClient VARCHAR2(50),
    email VARCHAR2(50) 
        CONSTRAINT nn_email NOT NULL,
    adresseClient VARCHAR2(50),
    tel VARCHAR2(15)
);

CREATE TABLE Vente (
    leBienV NUMBER 
        CONSTRAINT fk_leBienV REFERENCES Bien(idBien),
    leClientV NUMBER 
        CONSTRAINT fk_leClientV REFERENCES Client(idClient),
    dateVente DATE,
    prix NUMBER(8, 2)
        CONSTRAINT ck_prix CHECK (prix > 0),
    CONSTRAINT pk_idBienV_leClientV PRIMARY KEY (leBienV, leClientV)
);

CREATE TABLE Location (
    leBienL NUMBER  
        CONSTRAINT fk_leBienL REFERENCES Bien(idBien),
    leClientL NUMBER 
        CONSTRAINT fk_leClientL REFERENCES Client(idClient),
    dateDebut DATE,
    dateFin DATE,
    loyer NUMBER(8, 2)
        CONSTRAINT ck_loyer CHECK (loyer > 0),
    CONSTRAINT ck_dateFin_sup_dateDebut CHECK (dateFin >= dateDebut),
    CONSTRAINT pk_idBienL_leClientL PRIMARY KEY (leBienL, leClientL)
);