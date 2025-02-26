/*
BASE DE DONNEES - TP2
Nom : Gouélo
Prénom : Matthieu
Groupe : D1
*/

DROP TABLE IF EXISTS Apprenti;
DROP TABLE IF EXISTS Stagiaire;
DROP TABLE IF EXISTS Entreprise;
DROP TABLE IF EXISTS Etudiant;
DROP TABLE IF EXISTS GroupeInfo1;
DROP TABLE IF EXISTS Enseignant;
DROP TABLE IF EXISTS Responsabilite;

CREATE TABLE Enseignant
	(
	idEns VARCHAR(5),
	nomEns VARCHAR(20),
    prenomEns VARCHAR(20),
    CONSTRAINT pk_Enseignant PRIMARY KEY (idEns)
	)
;
        
CREATE TABLE GroupeInfo1
	(
	idGroupe VARCHAR(5),
	tuteurGroupe VARCHAR(5) NOT NULL,
	CONSTRAINT pk_GroupeInfo1 PRIMARY KEY (idGroupe),
    CONSTRAINT fk_GroupeInfo1_Enseignant FOREIGN KEY (tuteurGroupe) REFERENCES Enseignant(idEns)
	)
;

CREATE TABLE Etudiant
	(
	idEtud INTEGER,
	nomEtud VARCHAR(20),
	prenomEtud VARCHAR(20),
	sexe VARCHAR(5),
	bac VARCHAR(5),
    nomLycee VARCHAR(50),
    depLycee INTEGER,
    leGroupeInfo1 VARCHAR(5) NOT NULL,
	parcoursInfo2 VARCHAR(5),
    formationInfo2 VARCHAR(5),
    poursuiteEtudes VARCHAR(50),
    CONSTRAINT pk_Etudiant PRIMARY KEY (idEtud),
    CONSTRAINT fk_Etudiant_GroupeInfo1 FOREIGN KEY (leGroupeInfo1) REFERENCES GroupeInfo1(idGroupe)
	)
;

CREATE TABLE Entreprise
	(
	idEntreprise INTEGER,
	nomEntreprise VARCHAR(50),
    depEntreprise INTEGER,
    CONSTRAINT pk_Entreprise PRIMARY KEY (idEntreprise)
	)
;

CREATE TABLE Stagiaire
	(
	etudStagiaire INTEGER,
	entrepriseStage INTEGER NOT NULL,
    CONSTRAINT fk_Stagiaire_Etudiant FOREIGN KEY (etudStagiaire) REFERENCES Etudiant(idEtud),
	CONSTRAINT pk_Stagiaire PRIMARY KEY (etudStagiaire),
	CONSTRAINT fk_Stagiaire_Entreprise FOREIGN KEY (entrepriseStage) REFERENCES Entreprise(idEntreprise)
	)
;

CREATE TABLE Apprenti
	(
	etudApp INTEGER,
	entrepriseApp INTEGER NOT NULL,
    tuteurApp VARCHAR(5) NOT NULL,
	CONSTRAINT fk_Apprenti_Etudiant FOREIGN KEY (etudApp) REFERENCES Etudiant(idEtud),
	CONSTRAINT pk_Apprenti PRIMARY KEY (etudApp),
    CONSTRAINT fk_Apprenti_Entreprise FOREIGN KEY (entrepriseApp) REFERENCES Entreprise(idEntreprise),
    CONSTRAINT fk_Apprenti_Enseignant FOREIGN KEY (tuteurApp) REFERENCES Enseignant(idEns)
	)
;


-- Question 3 :
CREATE TABLE Responsabilite
	(
	intituleResp VARCHAR(50),
	leResp VARCHAR(50),
	CONSTRAINT pk_Responsabilite PRIMARY KEY (intituleResp)
	)
;

INSERT INTO Responsabilite
VALUES ("admin", "LN"),
("stages", "JFK"),
("apprentis", "PB"),
("poursuite_etudes", "RF"),
("chef_departement", "JFK"), 
("direction_etudes", "AR")


-- Question 4 :
SELECT * FROM Enseignant; -- 21 rows
SELECT * FROM GroupeInfo1; -- 4 rows
SELECT * FROM Etudiant; -- 107 rows
SELECT * FROM Entreprise; -- 71 rows
SELECT * FROM Stagiaire; -- 58 rows
SELECT * FROM Apprenti; -- 24 rows


-- Question 5 :
SELECT DISTINCT UPPER(nomEntreprise)
FROM Entreprise
WHERE depEntreprise IN (22, 29, 35, 56);
-- Pas de modification a apporter 



SELECT DISTINCT UPPER(idEns)
FROM Enseignant
MINUS
SELECT DISTINCT UPPER(tuteurApp)
FROM Apprenti;
-- Doit être changé en ...
SELECT DISTINCT UPPER(idEns)
FROM Enseignant
EXCEPT
SELECT DISTINCT UPPER(tuteurApp)
FROM Apprenti;



SELECT DISTINCT UPPER(nomEntreprise)
FROM Entreprise, Stagiaire
WHERE entrepriseStage=idEntreprise
AND depEntreprise = 56;
-- Pas de modification à apporter

-- Question 6 :
SELECT DISTINCT UPPER(nomEns), UPPER(prenomEns)
FROM Enseignant, GroupeInfo1
WHERE idEns = tuteurGroupe;
/* 4 rows
TUFFIGO	HELENE
NAERT	LUCIE
TONIN	PHILIPPE
GODIN	THIBAULT
*/

-- Question 7 :
SELECT DISTINCT UPPER(nomEns), UPPER(prenomEns)
FROM Enseignant, GroupeInfo1, Apprenti
WHERE idEns = tuteurGroupe
AND idEns = tuteurApp;
/* 2 rows
TUFFIGO	HELENE
TONIN	PHILIPPE
*/

-- Question 8 :
SELECT DISTINCT UPPER(nomEntreprise)
FROM Entreprise, Apprenti
WHERE idEntreprise = entrepriseApp
AND UPPER(tuteurApp) = 'MM';
/*6 rows
MENBAT
YOGOKO
SMARTMOOV
MAIRIE DE SÉNÉ
...
*/

-- Question 9 : 
SELECT DISTINCT UPPER(nomEtud), UPPER(prenomEtud)
FROM Etudiant, Apprenti, Enseignant
WHERE idEtud = etudApp
AND tuteurApp = idEns
AND UPPER(nomEns) = 'BAUDONT'
AND UPPER(prenomEns) = 'PASCAL';
/* 6 rows
SUARD	MAEL
DUFILS	ROMAIN
LICKINDORF	BORIS
BREIT HOARAU	EMELINE
...
*/


-- Question 10 :
SELECT DISTINCT UPPER(nomEns)
FROM Enseignant, Apprenti, Entreprise
WHERE idEns = tuteurApp
AND entrepriseApp = idEntreprise
AND depEntreprise NOT IN (35, 29, 22, 56);
/* 2 rows 
# UPPER(nomEns)
'MANNEVY'
'BAUDONT'
*/