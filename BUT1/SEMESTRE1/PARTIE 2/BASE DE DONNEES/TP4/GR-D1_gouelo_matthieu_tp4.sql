/*
TP 2 R1.05 Création de tables
Nom : Gouélo
Prénom : Matthieu
*/

-- EXERCICE 1

-- Question 2 :
CREATE TABLE Vehicule(
    immat VARCHAR2(9)
        CONSTRAINT pk_Vehicule PRIMARY KEY,
    leModele NUMBER
        CONSTRAINT fk_Vehicule_Modele REFERENCES Modele(idModele),
    dateAchat DATE
);

CREATE TABLE Location(
    unClient NUMBER
        CONSTRAINT fk_Location_Client REFERENCES Client(idClient),
    unVehicule VARCHAR2
        CONSTRAINT fk_Location_Vehicule REFERENCES Vehicule(immat),
    dateLocation DATE,
    duree NUMBER,
    CONSTRAINT pk_Location PRIMARY KEY (unClient, unVehicule)
);

-- Question 3 :
ALTER TABLE Vehicule ADD CONSTRAINT nn_dateAchat NOT NULL;

-- Question 4 :
-- On insert une clé étrangère unClient qui n'est pas dans la table Client
INSERT INTO Location VALUES (5, 'ET-831-BV', '08/10/2024', 3);

-- On insert une clé étrangère unClient qui est dans la table Client
INSERT INTO Location VALUES (1, 'FH-914-XP', '08/10/2024', 3);



-- EXERCICE 2

-- Question 5 :

Concession(idConc(1), nomConc, capital)
Voiture(immat(1), modele(NN), couleur, laConcess = @Concession.idConc, leConstru = @Constructeur.idConst(NN), leClient = @Client.idClient)
Client(idClient(1), nomClient(2), prenomClient(2))
Constructeur(idConst(1), nomConst(NN))
Travail([unConstru = @Constructeur.idConst, uneConcess = @Concession.idConc](1))
Assurance([leClient = @Client.idClient, leConstructeur = @Constructeur.idConst](1), dateContrat)

Contraintes textuelles :
- Voiture[leClient] = Client[idClient] (Tout client doit avoir au moins 1 voiture)
- Un constructeur doit travaillé avec au moins 2 concessions.
- Une concession doit travailler avec au moins 1 constructeur.
- Un client doit être assuré par un au moins un constructeur.


-- Question 6 :
CREATE TABLE Concession(
    idConc VARCHAR2(50)
        CONSTRAINT pk_Concession PRIMARY KEY,
    nomConc VARCHAR2(50),
    capital NUMBER
);

CREATE TABLE Client(
    idClient VARCHAR2(50)
        CONSTRAINT pk_Client PRIMARY KEY,
    nomClient VARCHAR2(50)
        CONSTRAINT nn_nomClient NOT NULL,
    prenomClient VARCHAR2(50)
        CONSTRAINT nn_prenomClient NOT NULL,
    CONSTRAINT uq_Client UNIQUE (nomClient, prenomClient)
);

CREATE TABLE Constructeur(
    idConst VARCHAR2(50)
        CONSTRAINT pk_Constructeur PRIMARY KEY,
    nomConst VARCHAR2(50)
        CONSTRAINT nn_nomConst NOT NULL
);

CREATE TABLE Voiture(
    immat VARCHAR2(9)
        CONSTRAINT pk_Voiture PRIMARY KEY,
    modele VARCHAR2(50)
        CONSTRAINT nn_modele NOT NULL,
    couleur VARCHAR2(50),
    laConcess VARCHAR2(50)
        CONSTRAINT fk_Voiture_Concession REFERENCES Concession(idConc),
    leConstru VARCHAR2(50)
        CONSTRAINT fk_Voiture_Constructeur REFERENCES Constructeur(idConst),
    leClient VARCHAR2(50)
        CONSTRAINT fk_Voiture_Client REFERENCES Client(idClient)
);

CREATE TABLE Travail(
    unConstru VARCHAR2(50)
        CONSTRAINT fk_Travail_Constructeur REFERENCES Constructeur(idConst),
    uneConcess VARCHAR2(50)
        CONSTRAINT fk_Travail_Concession REFERENCES Concession(idConc),
    CONSTRAINT pk_Travail PRIMARY KEY (unConstru, uneConcess) 
);

CREATE TABLE Assurance(
    leClient VARCHAR2(50)
        CONSTRAINT fk_Assurance_Client REFERENCES Client(idClient),
    leConstructeur VARCHAR2(50)
        CONSTRAINT fk_Assurance_Constructeur REFERENCES Constructeur(idConst),
    CONSTRAINT pk_Assurance PRIMARY KEY (leClient, leConstructeur),
    dateContrat DATE
);

-- Question 7 :
ALTER TABLE Assurance ADD CONSTRAINT ck_dateContrat CHECK (dateContrat IS NOT NULL);

-- Question 8 :
ALTER TABLE Client ADD COLUMN email VARCHAR2(50);

-- Question 9 : 
INSERT INTO Client VALUES ('Maffieu', 'Gouélo', 'Mafioso');
INSERT INTO Client VALUES ('Brancard', 'Brocard', 'Célian');

INSERT INTO Concession VALUES ('chepa', 'chepaConcess', 50);

INSERT INTO Constructeur VALUES ('Toyota', 'Toyota Inc');
INSERT INTO Constructeur VALUES ('BMW', 'Bayerische Motoren Werke');

INSERT INTO Voiture VALUES ('FT-200-ZB', 'Yaris Hybrid', 'Blanc', 'chepa', 'Toyota', 'Brancard');
INSERT INTO Voiture VALUES ('CK-483-AA', 'série 1 2006', 'Gris', 'chepa', 'BMW', 'Maffieu');



--Question 10 :
INSERT INTO Constructeur VALUES ('Toyota', 'toto');
/*
Erreur commençant à la ligne: 13 de la commande -
INSERT INTO Constructeur VALUES ('Toyota', 'toto')
Rapport d'erreur -
ORA-00001: unique constraint (MGOUELO.PK_CONSTRUCTEUR) violated
*/

DELETE FROM Client idClient
WHERE idClient = 'Maffieu';
/*
Erreur commençant à la ligne: 15 de la commande -
DELETE FROM Client idClient
WHERE idClient = 'Maffieu'
Rapport d'erreur -
ORA-02292: integrity constraint (MGOUELO.FK_VOITURE_CLIENT) violated - child record found
*/

ALTER TABLE Client ADD budget NUMBER;

UPDATE Client
SET prenomClient = 'Matthieu'
WHERE idClient = 'Maffieu';

ALTER TABLE Voiture DROP COLUMN couleur;

UPDATE Concession 
SET capital = 500000
WHERE idConc = 'chepa';