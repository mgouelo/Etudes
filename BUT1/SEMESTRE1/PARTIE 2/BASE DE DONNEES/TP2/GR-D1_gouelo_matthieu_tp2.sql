/*
TP 2 R1.05 Création de tables
Nom : Gouélo
Prénom : Matthieu
*/




-- EXERCICE 1 

/*
Q1/ 
Pour l'ordre de création des tables on commence d'abord par créer les tables
qui n'ont pas de clé étrangère puis les tables qui possède une clé étrangère 
qui réfère vers une table déjà créer. Ainsi de suite jusqu'à la cration de 
toutes les tables.

Pour l'ordre de suppression des tables on supprime en premier les tables qui
possède une clé étrangère et qui ne sont pas réferencé dans d'autre table existente.
*/

CREATE TABLE Enseignant(
    nomEns VARCHAR2(50)
        CONSTRAINT pk_Enseignant PRIMARY KEY,

    prenomEns VARCHAR2(50),

    adresse VARCHAR2(50),

    statut VARCHAR2(50)
);

CREATE TABLE Cycle(
    num NUMBER
        CONSTRAINT pk_num PRIMARY KEY,

    enseigantResponsable VARCHAR2(50)
        CONSTRAINT fk_enseignantResponsable REFERENCES Enseignant(nomEns)
        CONSTRAINT uq_enseignantResponsable UNIQUE
        CONSTRAINT nn_enseignantResponsable NOT NULL
);

CREATE TABLE Cours(
    nomCours VARCHAR2(50)
        CONSTRAINT pk_nomCours PRIMARY KEY,

    volumeH NUMBER,

    lEnseignant VARCHAR2(50)
        CONSTRAINT fk_lEnseignant REFERENCES Enseignant(nomEns)
        CONSTRAINT nn_lEnseignant NOT NULL,

    leCycle NUMBER
        CONSTRAINT fk_leCycle REFERENCES Cycle(num)
        CONSTRAINT nn_leCycle NOT NULL,
);

CREATE TABLE Requiert(
    cours VARCHAR2(50)
        CONSTRAINT fk_cours REFERENCES Cours(nomCours),

    coursRequis VARCHAR2(50)
        CONSTRAINT fk_coursRequis REFERENCES Cours(nomCours),
    CONSTRAINT pk_Requiert PRIMARY KEY (cours, coursRequis)
);

DROP TABLE Requiert ;
DROP TABLE Cours ;
DROP TABLE Cycle ;
DROP TABLE Enseignant ;

--Question 3 :
/*
Il faut supprimer les tables avec "DROP TABLE" pour pouvoir réxécuter
car si l'on réxécute le code sans supprimer les tables le SGBD renvera 
une erreur car il ne pourra pas créer les tables comme elles sont déjà 
présentes.
*/


--EXERCICE 2 :

--Question 4 :

CREATE TABLE Proprietaire(
    idProprietaire NUMBER
        CONSTRAINT pk_Proprietaire PRIMARY KEY,    
    nomProprietaire VARCHAR2(50)
        CONSTRAINT nn_nomProprietaire NOT NULL,
    prenomProprietaire VARCHAR2(50)
        CONSTRAINT nn_prenomProprietaire NOT NULL,
    emailProprietaire VARCHAR2(50)
        CONSTRAINT nn_emailProprietaire NOT NULL
        CONSTRAINT uq_emailProprietaire UNIQUE
);

CREATE TABLE Emplacement(
    idEmplacement NUMBER
        CONSTRAINT pk_idEmplacement PRIMARY KEY,
    longueurEmplacement NUMBER
        CONSTRAINT nn_longueurEnplacement NOT NULL,
    coutJournalier NUMBER
        CONSTRAINT nn_coutJournalier NOT NULL
);

CREATE TABLE Bateau(
    idBateau NUMBER
        CONSTRAINT pk_Bateau PRIMARY KEY,
    nomBateau VARCHAR2(50),
    longueurBateau NUMBER
        CONSTRAINT nn_longueurBateau NOT NULL,
    leProprietaire NUMBER
        CONSTRAINT fk_leProprietaire REFERENCES Proprietaire(idProprietaire)
        CONSTRAINT nn_leProprietaire NOT NULL,
    leStationnement NUMBER
        CONSTRAINT fk_leStationnement REFERENCES Emplacement(idEmplacement)
        CONSTRAINT uq_leStationnement UNIQUE
);

CREATE TABLE Reservation(
    idReservation NUMBER
        CONSTRAINT pk_Reservation PRIMARY KEY,
    dateDebut DATE
        CONSTRAINT nn_dateDebut NOT NULL,
    dateFin DATE
        CONSTRAINT nn_dateFin NOT NULL,
    leBateau NUMBER
        CONSTRAINT fk_leBateau REFERENCES Bateau(idBateau)
        CONSTRAINT nn_leBateau NOT NULL,
    lEmplacement NUMBER
        CONSTRAINT fk_lEmplacement REFERENCES Emplacement(idEmplacement)
        CONSTRAINT nn_lEmplacement NOT NULL
);

-- Question 5 :
-- a)
CREATE TABLE Bateau(
    idBateau NUMBER
        CONSTRAINT pk_Bateau PRIMARY KEY,
    nomBateau VARCHAR2(50),
    longueurBateau NUMBER
        CONSTRAINT nn_longueurBateau NOT NULL
        CONSTRAINT ck_longueurBateau CHECK (longueurBateau <= 20),
    leProprietaire NUMBER
        CONSTRAINT fk_leProprietaire REFERENCES Proprietaire(idProprietaire)
        CONSTRAINT nn_leProprietaire NOT NULL,
    leStationnement NUMBER
        CONSTRAINT fk_leStationnement REFERENCES Emplacement(idEmplacement)
        CONSTRAINT uq_leStationnement UNIQUE
);

-- b)
CREATE TABLE Reservation(
    idReservation NUMBER
        CONSTRAINT pk_Reservation PRIMARY KEY,
    dateDebut VARCHAR2(50)
        CONSTRAINT nn_dateDebut NOT NULL,
    dateFin VARCHAR2(50)
        CONSTRAINT nn_dateFin NOT NULL
        CONSTRAINT ck_dateFin CHECK (dateFin > dateDebut),
    leBateau NUMBER
        CONSTRAINT fk_leBateau REFERENCES Bateau(idBateau)
        CONSTRAINT nn_leBateau NOT NULL,
    lEmplacement NUMBER
        CONSTRAINT fk_lEmplacement REFERENCES Emplacement(idEmplacement)
        CONSTRAINT nn_lEmplacement NOT NULL
);

-- c)
CREATE TABLE Proprietaire(
    idProprietaire NUMBER
        CONSTRAINT pk_Proprietaire PRIMARY KEY,    
    nomProprietaire VARCHAR2(50)
        CONSTRAINT nn_nomProprietaire NOT NULL,
    prenomProprietaire VARCHAR2(50)
        CONSTRAINT nn_prenomProprietaire NOT NULL,
    emailProprietaire VARCHAR2(50)
        CONSTRAINT nn_emailProprietaire NOT NULL
        CONSTRAINT uq_emailProprietaire UNIQUE
        CONSTRAINT ck_emailProprietaire CHECK (emailProprietaire LIKE '_%@_%._%')
);