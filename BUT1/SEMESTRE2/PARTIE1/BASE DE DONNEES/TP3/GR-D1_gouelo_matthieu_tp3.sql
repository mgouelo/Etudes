/*
BDD - TP3
Nom : Gouélo
Prénom : Matthieu
Groupe : D1
*/

-- Question 2 :
SELECT nomPilote, nomComp
FROM Pilote, Compagnie
WHERE compPil = idComp;
-- Fonctionne avec MySQL

SELECT nomPilote, nomComp
FROM Pilote JOIN Compagnie ON compPil = idComp;
-- Fonctionne avec MySQL


-- 3/ a) 
SELECT *
FROM Compagnie
WHERE estLowCost = 1;
/* 2 rows
# idComp, nomComp, pays, estLowCost
'3', 'EasyJet', 'Angleterre', '1'
'5', 'Ryanair', 'Irelande', '1'
*/

-- b)
SELECT nomPilote
FROM Pilote
WHERE idPilote NOT IN (SELECT unPilote
                       FROM Qualification
);
/* 1 row
# nomPilote
'Kerbellec'
*/

-- c)
SELECT nomPilote
FROM Pilote
ORDER BY nomPilote DESC
LIMIT 5;
/* 5 rows
# nomPilote
'Ridard'
'Pham'
'Naert'
'Kerbellec'
'Kamp'
*/

-- PARTIE 2
-- Question 4 :
-- Avec jointure : 
SELECT DISTINCT UPPER(nomEns), UPPER(prenomEns)
FROM Enseignant JOIN GroupeInfo1 ON idEns = tuteurGroupe;

-- Avec Sous-requête
SELECT DISTINCT UPPER(nomEns), UPPER(prenomEns)
FROM Enseignant
WHERE idEns IN (SELECT tuteurGroupe
                FROM GroupeInfo1);
/* 4 rows
# UPPER(nomEns), UPPER(prenomEns)
'TUFFIGO', 'HELENE'
'NAERT', 'LUCIE'
'TONIN', 'PHILIPPE'
'GODIN', 'THIBAULT'
*/


-- Question 5 :
-- Avec jointure :
SELECT DISTINCT UPPER(nomEns)
FROM Enseignant, GroupeInfo1, Apprenti
WHERE idEns = tuteurGroupe
AND tuteurGroupe = tuteurApp;

-- Avec sous-requête :
SELECT DISTINCT UPPER(nomEns)
FROM Enseignant
WHERE idEns IN (SELECT tuteurGroupe
                FROM GroupeInfo1
                WHERE tuteurGroupe IN (SELECT DISTINCT UPPER(tuteurApp)
                                       FROM Apprenti));
/* 2 rows
# UPPER(nomEns)
'TUFFIGO'
'TONIN'
*/


-- Question 6 :
-- Avec jointure :
SELECT DISTINCT UPPER(nomEntreprise)
FROM Entreprise, Apprenti
WHERE idEntreprise = entrepriseApp
AND tuteurApp = 'MM';

-- Avec sous-requête :
SELECT DISTINCT UPPER(nomEntreprise)
FROM Entreprise
WHERE idEntreprise IN (SELECT DISTINCT UPPER(entrepriseApp)
                       FROM Apprenti
                       WHERE tuteurApp = 'MM');
/* 6 rows
# UPPER(nomEntreprise)
'MENBAT'
'YOGOKO'
'SMARTMOOV'
'MAIRIE DE SÉNÉ'
...
*/


-- Question 7 :
-- Avec jointure :
SELECT DISTINCT UPPER(nomEtud), UPPER(prenomEtud)
FROM Etudiant, Apprenti, Enseignant
WHERE idEtud = etudApp
AND tuteurApp = idEns
AND UPPER(nomEns) = 'BAUDONT' AND UPPER(prenomEns) = 'PASCAL';

-- Avec sous-requête :
SELECT DISTINCT UPPER(nomEtud), UPPER(prenomEtud)
FROM Etudiant
WHERE idEtud IN (SELECT DISTINCT etudApp
                 FROM Apprenti
                 WHERE tuteurApp IN (SELECT DISTINCT idEns
                                     FROM Enseignant
                                     WHERE UPPER(nomEns) = 'BAUDONT'
                                     AND UPPER(prenomEns) = 'PASCAL'));
/* 6 rows
# UPPER(nomEtud), UPPER(prenomEtud)
'SUARD', 'MAEL'
'DUFILS', 'ROMAIN'
'LICKINDORF', 'BORIS'
'BREIT HOARAU', 'EMELINE'
...
*/


-- Question 8 :
-- Avec jointure : 
SELECT DISTINCT UPPER(nomEns)
FROM Enseignant, Apprenti, Entreprise
WHERE idEns = tuteurApp
AND entrepriseApp = idEntreprise
AND depEntreprise NOT IN ('35', '56', '29', '22');

-- Avec sous-requête
SELECT DISTINCT UPPER(nomEns)
FROM Enseignant
WHERE idEns IN (SELECT DISTINCT UPPER(tuteurApp)
                FROM Apprenti
                WHERE entrepriseApp IN (SELECT DISTINCT idEntreprise
                                        FROM Entreprise
                                        WHERE depEntreprise NOT IN ('35', '56', '22', '29')));
/* 2 rows
# UPPER(nomEns)
'BAUDONT'
'MANNEVY'
*/


-- Question 9 :
SELECT DISTINCT etudStagiaire, nomEntreprise, depEntreprise
FROM Stagiaire JOIN Entreprise ON entrepriseStage = idEntreprise;
/* 58 rows
# etudStagiaire, nomEntreprise, depEntreprise
'21900078', 'ACCENTURE', '75'
'21903040', 'ACCENTURE', '75'
'21902500', 'ADAPEI56', '56'
'21900834', 'ADM', '56'
'21902446', 'APRAS', '35'
...
*/

-- Question 10 :
SELECT DISTINCT nomEtud, prenomEtud, nomEntreprise, depEntreprise
FROM Etudiant, Entreprise, Stagiaire
WHERE idEtud = etudStagiaire
AND entrepriseStage = idEntreprise;
/* 58 rows
# nomEtud, prenomEtud, nomEntreprise, depEntreprise
'RECOLIN', 'ANGELE', 'ACCENTURE', '75'
'LAGUE', 'PIERRE', 'ACCENTURE', '75'
'BERNIER', 'ALLAN', 'ADAPEI56', '56'
'LENOBLE', 'ALEXANDRE', 'ADM', '56'
*/

-- Question 11 :
SELECT DISTINCT UPPER(nomEtud), UPPER(prenomEtud)
FROM Etudiant, Stagiaire, Entreprise
WHERE idEtud = etudStagiaire
AND entrepriseStage = idEntreprise
AND depEntreprise != depLycee;
/* 31 rows
# UPPER(nomEtud), UPPER(prenomEtud)
'RECOLIN', 'ANGELE'
'LAGUE', 'PIERRE'
'BERNIER', 'ALLAN'
'GODET', 'LOUIS-XAVIER'
'GONTARD', 'ALICE'
*/

-- Question 12 :
SELECT nomEns, nomEtud, prenomEtud
FROM Enseignant
LEFT JOIN Apprenti ON tuteurApp = idEns
LEFT JOIN Etudiant ON idEtud = etudApp;
/* 38 rows 
# nomEns, nomEtud, prenomEtud
'Lemaitre', NULL, NULL
'Lesueur', NULL, NULL
'Merciol', NULL, NULL
'Kerbellec', NULL, NULL
'Tuffigo', 'ADAM', 'ANTOINE'
*/

-- Question 13 : 
SELECT DISTINCT nomEtud, nomEntreprise
FROM Etudiant
LEFT JOIN Stagiaire ON etudStagiaire = idEtud
LEFT JOIN Apprenti ON etudApp = idEtud
LEFT JOIN Entreprise ON entrepriseStage = idEntreprise OR entrepriseApp = idEntreprise;
/* 107 rows
# nomEtud, nomEntreprise
'VIAUD', 'SCM VIAUD-FORMAGNE'
'JOSSE', 'CGI'
'LEBORGNE', 'ANVERGUR'
'RECOLIN', 'ACCENTURE'
*/


-- Question 14 : 
SELECT DISTINCT nomEns, nomEtud, prenomEtud, nomEntreprise
FROM Enseignant
LEFT JOIN Apprenti ON idEns = tuteurApp
LEFT JOIN Etudiant ON etudApp = idEtud
LEFT JOIN Entreprise ON entrepriseApp = idEntreprise;
/* 38 rows 
# nomEns, nomEtud, prenomEtud, nomEntreprise
'Lemaitre', NULL, NULL, NULL
'Lesueur', NULL, NULL, NULL
'Merciol', NULL, NULL, NULL
'Kerbellec', NULL, NULL, NULL
'Tuffigo', 'ADAM', 'ANTOINE', 'PORT DE PÊCHE KEROMAN'
*/

-- Question 15 :
SELECT nomEns, nomEtud, prenomEtud, depEntreprise
FROM Enseignant
LEFT JOIN Apprenti ON idEns = tuteurApp
LEFT JOIN Etudiant ON etudApp = idEtud
LEFT JOIN Entreprise ON entrepriseApp = idEntreprise
WHERE depEntreprise IN ('22', '29', '35', '56') ON depEntreprise IS NULL
ORDER BY depEntreprise DESC;
/* 36 rows 
# nomEns, nomEtud, prenomEtud, depEntreprise
'Mannevy', 'MADELAINE', 'DYLAN', '56'
'Mannevy', 'LE PORS', 'YANIS', '56'
'Tuffigo', 'ADAM', 'ANTOINE', '56'
'Kamp', 'LAMBERT', 'TANGUY', '56'
'Kamp', 'GREGOIRE', 'EWAN', '56'
*/