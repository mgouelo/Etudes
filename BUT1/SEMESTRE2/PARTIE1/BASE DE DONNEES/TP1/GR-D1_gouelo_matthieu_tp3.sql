/*
Nom : Gouélo
Prénom : Matthieu
Groupe : 1D1

TP1
*/

-- Question 1 :
Enseignant(idEns (1), nomEns, prenomEns)
GroupeInfo1(idGroupe (1), tuteurGroupe = @Enseignant.idEns)
Etudiant(idEtud, nomEtud, prenomEtud, sexe, bac, nomLycee, depLycee, 
    leGroupeInfo1 = @GroupeInfo1.idGroupe, parcoursInfo2, formationInfo2,
    poursuiteEtudes)

Entreprise(idEntreprise (1), nomEntreprise, depEntreprise)
Stagiaire(etudStagiaire = @Etudiant.idEtud (1), entrepriseStage = @Entreprise.idEntreprise)
Apprenti(etudApp = @Etudiant.idEtud (1), entrepriseApp = @Entreprise.idEntreprise, tuteurApp = @Enseignant.idEns)


-- Question 3 :
CREATE TABLE Enseignant(
    idEns VARCHAR2(50)
        CONSTRAINT pk_Enseignant PRIMARY KEY,
    nomEns VARCHAR2(50),
    prenomEns VARCHAR2(50)
);

CREATE TABLE GroupeInfo1(
    idGroupe CHAR
        CONSTRAINT pk_GroupeInfo1 PRIMARY KEY,
    tuteurGroupe VARCHAR2(50)
        CONSTRAINT fk_GroupeInfo1_Enseignant REFERENCES Enseignant(idEns)
);

CREATE TABLE Etudiant(
    idEtud NUMBER
        CONSTRAINT pk_Etudiant PRIMARY KEY,
    nomEtud VARCHAR2(50),
    prenomEtud VARCHAR2(50),
    sexe CHAR,
    bac VARCHAR2(50),
    nomLycee VARCHAR2(50),
    depLycee VARCHAR2(50),
    leGroupeInfo1 CHAR
        CONSTRAINT fk_Etudiant_GroupeInfo1 REFERENCES GroupeInfo1(idGroupe),
    parcoursInfo2 VARCHAR2(50),
    formationInfo2 VARCHAR2(50),
    poursuiteEtudes VARCHAR2(50)
);

CREATE TABLE Entreprise(
    idEntreprise NUMBER
        CONSTRAINT pk_Entreprise PRIMARY KEY,
    nomEntreprise VARCHAR2(50),
    depEntreprise NUMBER
);

CREATE TABLE Stagiaire(
    etudStagiaire NUMBER
        CONSTRAINT pk_Stagiaire PRIMARY KEY
        CONSTRAINT fk_Stagiaire_Etudiant REFERENCES Etudiant(idEtud),
    entrepriseStage NUMBER
        CONSTRAINT fk_Stagiaire_Entreprise REFERENCES Entreprise(idEntreprise)
);

CREATE TABLE Apprenti(
    etudApp NUMBER
        CONSTRAINT pk_Apprenti PRIMARY KEY
        CONSTRAINT fk_Apprenti_Etudiant REFERENCES Etudiant(idEtud),
    entrepriseApp NUMBER
        CONSTRAINT fk_Apprenti_Entreprise REFERENCES Entreprise(idEntreprise),
    tuteurApp VARCHAR2(50)
        CONSTRAINT fk_Apprenti_Enseignant REFERENCES Enseignant(idEns)
);


-- Question 5 :
SELECT * FROM Enseignant;
SELECT * FROM GroupeInfo1;
SELECT * FROM Etudiant;
SELECT * FROM Entreprise;
SELECT * FROM Stagiaire;
SELECT * FROM Apprenti;


-- Question 6 :
-- Les noms d'entreprise bretonnes triés dans l'order alphabéthique
SELECT DISTINCT UPPER(nomEntreprise)
FROM Entreprise
WHERE depEntreprise IN (22, 29, 35, 56);


-- Les ids des enseignants qui ne sont pas tuteur d'apprentis 
SELECT DISTINCT UPPER(idEns)
FROM Enseignant
MINUS
SELECT DISTINCT UPPER(tuteurApp)
FROM Apprenti;

-- Les entreprises dans le Morbhian qui proposent des stages ?
SELECT DISTINCT UPPER(nomEntreprise)
FROM Entreprise, Stagiaire
WHERE entrepriseStage=idEntreprise
AND depEntreprise = 56;