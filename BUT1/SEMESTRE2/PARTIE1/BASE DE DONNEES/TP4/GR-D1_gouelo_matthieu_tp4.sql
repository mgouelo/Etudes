/* 
BDD - TP4
Nom : Gouélo
Prénom : Matthieu
Groupe : D1
*/

-- PARTIE 1 
-- Question 1 :
SELECT COUNT(*)
FROM Pilote;
/* Fonctionne sous MySQL
# COUNT(*)
'7'
*/

SELECT COUNT(compPil)
FROM Pilote;
/* Fonctionne sous MySQL
# COUNT(compPil)
'6'
*/

SELECT COUNT(DISTINCT compPil)
FROM Pilote;
/* Fonctionne sous MySQL
# COUNT(DISTINCT compPil)
'4'
*/

SELECT MAX(nbHVol)
FROM Pilote;
/* Fonctionne sous MySQL
# MAX(nbHVol)
'3000'
*/

SELECT AVG(nbHVol)
FROM Pilote;
/* Fonctionne sous MySQL
# AVG(nbHVol)
'1457.1429'
*/

SELECT STDDEV(nbHVol)
FROM Pilote;
/* Fonctionne sous MySQL
# STDDEV(nbHVol)
'1029.0177603036832'
*/

SELECT nomPilote
FROM Pilote
WHERE nbHVol > (SELECT AVG(nbHVol)
                FROM Pilote
                );
/* Fonctionne sous MySQL
# nomPilote
'Ridard'
'Fleurquin'
'Kamp'
*/

SELECT nomPilote, nbHVol
FROM Pilote
WHERE nbHVol > (SELECT AVG(nbHVol)
                FROM Pilote
                );
/* Fonctionne sous MySQL
# nomPilote, nbHVol
'Ridard', '1500'
'Fleurquin', '3000'
'Kamp', '3000'
*/

------------------ GROUP BY ------------------
SELECT compAv, COUNT(*)
FROM Avion
GROUP BY compAv;
/* Fonctionne sous MySQL
# compAv, COUNT(*)
'1', '3'
'2', '1'
'3', '1'
'4', '2'
'5', '2'
*/

SELECT compAv, COUNT(DISTINCT leTypeAvion)
FROM Avion
GROUP BY compAv;
/* Fonctionne sous MySQL
# compAv, COUNT(DISTINCT leTypeAvion)
'1', '3'
'2', '1'
'3', '1'
'4', '2'
'5', '1'
*/

SELECT nomComp, COUNT(DISTINCT leTypeAvion)
FROM Compagnie, Avion
WHERE idComp = compAv
GROUP BY nomComp
ORDER BY nomComp;
/* Fonctionne sous MySQL
# nomComp, COUNT(DISTINCT leTypeAvion)
'Air France', '3'
'American Airlines', '2'
'Corsair Internat', '1'
'EasyJet', '1'
'Ryanair', '1'
*/

SELECT unPilote, COUNT(unTypeAvion)
FROM Qualification
GROUP BY unPilote;
/* Fonctionne sous MySQL
# unPilote, COUNT(unTypeAvion)
'1', '2'
'2', '2'
'3', '1'
'4', '3'
'5', '2'
'7', '2'
*/

SELECT idPilote, COUNT(unTypeAvion)
FROM Pilote
    LEFT JOIN Qualification ON idPilote = unPilote
GROUP BY idPilote;
/* Fonctionne sous MySQL
# idPilote, COUNT(unTypeAvion)
'1', '2'
'2', '2'
'3', '1'
'4', '3'
'5', '2'
'6', '0'
*/

SELECT compPil, COUNT(idPilote)
FROM Pilote
GROUP BY compPil;
/* 5 rows
# compPil, COUNT(idPilote)
NULL, '1'
'1', '2'
'3', '1'
'4', '2'
'5', '1'
*/



----- PARTIE 2 -----
-- Question 2 :
SELECT COUNT(idEtud)
FROM Etudiant
WHERE depLycee IN ('22', '29', '35', '56');
/*
# COUNT(idEtud)
'81'
*/

-- Question 3 : 
SELECT COUNT(poursuiteEtudes)
FROM Etudiant;
/*
# COUNT(poursuiteEtudes)
'74'
*/

-- Question 4 : 
SELECT COUNT(DISTINCT tuteurApp)
FROM Apprenti;
/* 
# COUNT(DISTINCT tuteurApp)
'7'
*/

-- Question 5 :
SELECT COUNT(etudApp)
FROM Apprenti, Entreprise
WHERE entrepriseApp = idEntreprise
AND depEntreprise = '56'
AND UPPER(tuteurApp) = 'PB';
/*
# COUNT(etudApp)
'4'
*/

-- Question 6 : 
SELECT COUNT(parcoursInfo2) / COUNT(idEtud)
FROM Etudiant;
/* 
# COUNT(parcoursInfo2) / COUNT(idEtud)
'0.7664'
*/

-- Question 7 :
SELECT COUNT(DISTINCT tuteurApp) / COUNT(DISTINCT idEns)
FROM Apprenti, Enseignant;
/*
# COUNT(DISTINCT tuteurApp) / COUNT(DISTINCT idEns)
'0.3333'
*/

-- Question 8 :
SELECT nomEns, COUNT(etudApp)
FROM Apprenti, Enseignant
WHERE tuteurApp = idEns
GROUP BY nomEns
ORDER BY nomEns;
/* 
# nomEns, COUNT(etudApp)
'Baudont', '6'
'Fleurquin', '2'
'Kamp', '2'
'Lefevre', '2'
*/

-- Question 9 :
SELECT nomEns, COUNT(etudApp) AS nbApprenti
FROM Apprenti
LEFT JOIN Enseignant ON tuteurApp = idEns
GROUP BY nomEns
ORDER BY nbApprenti DESC;
/*
# nomEns, nbApprenti
'Mannevy', '7'
'Baudont', '6'
'Tuffigo', '3'
'Kamp', '2'
*/

-- Question 10 :
SELECT MAX(nbApprenti)
FROM (SELECT COUNT(etudApp) AS nbApprenti
      FROM Apprenti
      GROUP BY tuteurApp) AS SUBQUERRY;
/*
# MAX(nbApprenti)
'7'
*/

-- Question 11 :
SELECT nomEns
FROM Enseignant, Apprenti
WHERE idEns = tuteurApp
GROUP BY tuteurApp
HAVING COUNT(etudApp) = 
    (
    SELECT MAX(nbApprenti)
    FROM (SELECT COUNT(etudApp) AS nbApprenti
      FROM Apprenti
      GROUP BY tuteurApp) AS SUBQUERRY
    );
/*
# nomEns
'Mannevy'
*/

-- Question 12 :
SELECT AVG(nbApprenti)
FROM (
    SELECT COUNT(etudApp) AS nbApprenti
    FROM Apprenti
    GROUP BY tuteurApp
) AS subQuerry;
/*
# AVG(nbApprenti)
'3.4286'
*/

-- Question 13 :
SELECT nomEns
FROM Enseignant JOIN Apprenti ON idEns = tuteurApp
GROUP BY tuteurApp
HAVING COUNT(etudApp) > (
    SELECT AVG(nbApprenti)
    FROM (
        SELECT COUNT(etudApp) AS nbApprenti
        FROM Apprenti
        GROUP BY tuteurApp
    ) AS subQuerry
);
/*
# nomEns
'Mannevy'
'Baudont'
*/

-- Question 14 :
SELECT COUNT(idEtud) AS nbEtu
FROM Etudiant
GROUP BY depLycee
ORDER BY nbEtu DESC;
/*
# nbEtu
'34'
'25'
'19'
'7'
*/

-- Question 15 :
SELECT depLycee, COUNT(idEtud) AS nbEtudiant
FROM Etudiant
WHERE depLycee IN (29, 22, 56, 35)
GROUP BY depLycee
ORDER BY nbEtudiant
LIMIT 1;
/*
# depLycee, nbEtudiant
'22', '3'
*/

-- Question 16 :
SELECT poursuiteEtudes
FROM Etudiant
LIMIT 5;
/*
# poursuiteEtudes
'Licence Info Rennes'
NULL
'Licence info Rennes'
'Licence Pro Nantes'
'ENSIBS cyberdéfense'
*/

-- Question 17 :
SELECT poursuiteEtudes, MAX(nbApprenti)
FROM (
    SELECT poursuiteEtudes, COUNT(etudApp) AS nbApprenti
    FROM Etudiant JOIN Apprenti ON idEtud = etudApp
    GROUP BY poursuiteEtudes
) AS subQuerry1
GROUP BY poursuiteEtudes
ORDER BY nbApprenti DESC
LIMIT 1;
/*
# poursuiteEtudes, MAX(nbApprenti)
'ENSIBS cyberdéfense', '7'
*/

-- Question 18 :
SELECT poursuiteEtudes, MAX(nbEtudiant)
FROM (
    SELECT poursuiteEtudes, COUNT(idEtud) AS nbEtudiant
    FROM Etudiant
    WHERE UPPER(parcoursInfo2) = 'DA'
    GROUP BY poursuiteEtudes
) AS subQuerry1
GROUP BY poursuiteEtudes
ORDER BY nbEtudiant DESC
LIMIT 3;
/*
# poursuiteEtudes, MAX(nbEtudiant)
NULL, '5'
'Licence Pro Vannes Delice', '5'
'Licence info Vannes', '5'
*/