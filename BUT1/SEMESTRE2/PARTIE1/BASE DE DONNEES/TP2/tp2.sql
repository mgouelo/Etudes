DROP TABLE IF EXISTS Apprenti;
DROP TABLE IF EXISTS Stagiaire;
DROP TABLE IF EXISTS Entreprise;
DROP TABLE IF EXISTS Etudiant;
DROP TABLE IF EXISTS GroupeInfo1;
DROP TABLE IF EXISTS Enseignant;

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
	leResp VARCHAR(50)
	)