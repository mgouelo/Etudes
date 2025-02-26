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
