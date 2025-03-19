/*
BDD - TP6
Nom : Gouélo
Prénom : Matthieu
Groupe : D1
*/

---------- PARTIE 1 ----------
-- Question 1 :
CREATE OR REPLACE VIEW vue_PiloteEtCompagnie
AS
SELECT nomPilote, nomComp
FROM Pilote JOIN Compagnie ON compPil = idComp;

SELECT *
FROM vue_PiloteEtCompagnie;
/*
# nomPilote, nomComp
'Ridard', 'Air France'
'Naert', 'EasyJet'
'Godin', 'Ryanair'
'Fleurquin', 'Air France'
'Pham', 'American Airlines'
'Kamp', 'American Airlines'
*/


CREATE OR REPLACE VIEW vue_PiloteEtCompagnie
(
    nom_pilote,
    nom_Compagnie
)
AS 
SELECT nomPilote, nomComp
FROM Pilote
    JOIN Compagnie ON compPil = idComp;

SELECT *
FROM vue_PiloteEtCompagnie;
/*
# nom_pilote, nom_Compagnie
'Ridard', 'Air France'
'Fleurquin', 'Air France'
'Naert', 'EasyJet'
'Pham', 'American Airlines'
'Kamp', 'American Airlines'
'Godin', 'Ryanair'
*/


CREATE OR REPLACE VIEW vue_Compagnie_Sans_Avion
AS
SELECT idComp
FROM Compagnie
EXCEPT
SELECT compAv 
FROM Avion;

SELECT *
FROM vue_Compagnie_Sans_Avion;
/*
aucune ligne sélectionnée
*/


CREATE OR REPLACE VIEW vue_Pilote_Sans_Qualification
AS
SELECT idPilote
FROM Pilote
EXCEPT
SELECT unPilote
FROM Qualification ;

SELECT *
FROM vue_Pilote_Sans_Qualification;
/*
# idPilote
'6'
*/


CREATE OR REPLACE VIEW vue_Pilote_Illegitime
AS
SELECT idPilote
FROM Pilote
WHERE compPil IS NOT NULL
EXCEPT
SELECT unPilote
FROM Qualification
    JOIN Pilote ON unPilote = idPilote
        JOIN Avion ON compPil = compAv
WHERE unTypeAvion = leTypeAvion;

SELECT *
FROM vue_Pilote_Illegitime;
/*
aucune ligne sélectionnées
*/


---------- PARTIE 3 ----------
-- Question 4 :
CREATE OR REPLACE VIEW vue_CompteSansClient
AS
SELECT numCompte
FROM Compte
EXCEPT
SELECT unCompte
FROM Appartient;

SELECT *
FROM vue_CompteSansClient;
/*
# numCompte
'2'
*/


CREATE OR REPLACE VIEW vue_AgenceIllegal
AS
SELECT sonAgence
FROM Agent
GROUP BY sonAgence
HAVING SUM(directeur) != 1;

SELECT *
FROM vue_AgenceIllegal;
/*
# sonAgence
'1'
'2'
*/


CREATE OR REPLACE VIEW vue_DirecteurMalPaye
AS
SELECT A1.numAgent
FROM Agent A1, Agent A2
WHERE A1.numAgent != A2.numAgent
AND A1.directeur = 1 AND A2.directeur = 0
AND A1.salaire < A2.salaire
AND A1.sonAgence = A2.sonAgence;

SELECT *
FROM vue_DirecteurMalPaye;
/*
# numAgent
'5'
*/


CREATE OR REPLACE VIEW vue_ClientInformations
AS
SELECT numClient, FLOOR(DATEDIFF(CURRENT_DATE, dateNaissanceClient) / 365), sonAgence
FROM Client, Agent
WHERE sonAgent = numAgent;

SELECT *
FROM vue_ClientInformations;
/*
# numClient, FLOOR(DATEDIFF(CURRENT_DATE, dateNaissanceClient) / 365), sonAgence
'1', '22', '1'
'2', '27', '1'
'3', '31', '2'
*/