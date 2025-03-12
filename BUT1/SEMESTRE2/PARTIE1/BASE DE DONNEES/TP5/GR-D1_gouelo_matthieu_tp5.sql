/*
BDD - TP5
Nom : Gouélo
Prénom : Matthieu
Groupe : D1
*/

------------ PARTIE 1 ------------
-- Question 1 :
SELECT nomPilote
FROM Pilote
WHERE NOT EXISTS
    (
    SELECT idTypeAvion
    FROM TypeAvion
    EXCEPT
    SELECT unTypeAvion
    FROM Qualification
    WHERE unPilote = idPilote
    );
/*
# nomPilote
'Fleurquin'
*/

-- Question 2 :
SELECT nomPilote
FROM Pilote
WHERE NOT EXISTS
    (
        SELECT leTypeAvion
        FROM Avion
        WHERE compAv = compPil
        EXCEPT
        SELECT unTypeAvion
        FROM Qualification
        WHERE unPilote = idPilote
    )
AND compPil IS NOT NULL;
/*
# nomPilote
'Fleurquin'
'Naert'
'Kamp'
'Godin'
*/

-- Question 3 :
SELECT nomPilote
FROM Pilote
WHERE NOT EXISTS
    (
        SELECT leTypeAvion
        FROM Avion
        WHERE compAv = compPil
        EXCEPT
        SELECT unTypeAvion
        FROM Qualification
        WHERE unPilote = idPilote
    )
AND NOT EXISTS 
    (
        SELECT unTypeAvion
        FROM Qualification
        WHERE unPilote = idPilote
        EXCEPT
        SELECT leTypeAvion
        FROM Avion
        WHERE compAv = compPil
    )
AND compPil IS NOT NULL;
/*
# nomPilote
'Fleurquin'
'Kamp'
'Godin'
*/


------------ PARTIE 2 ------------
-- Question 2 :
SELECT nomPilote
FROM Pilote
WHERE NOT EXISTS 
    (   
        SELECT idComp
        FROM Compagnie
        EXCEPT
        SELECT laComp
        FROM AtravaillePour
        WHERE lePilote = idPilote
    );
/*
# nomPilote
'Fleurquin'
*/

-- Question 3 :
SELECT nomPilote
FROM Pilote
WHERE NOT EXISTS (
    SELECT idComp
    FROM Compagnie
    WHERE estLowCost = 1
    EXCEPT
    SELECT laComp
    FROM AtravaillePour
    WHERE lePilote = idPilote
);
/*
# nomPilote
'Ridard'
'Naert'
'Fleurquin'
*/

-- Question 4 :
SELECT nomPilote
FROM Pilote
WHERE NOT EXISTS (
    SELECT idComp
    FROM Compagnie
    WHERE estLowCost = 1
    EXCEPT
    SELECT laComp
    FROM AtravaillePour
    WHERE lePilote = idPilote
)
AND NOT EXISTS ( 
	SELECT laComp
	FROM AtravaillePour
	WHERE lePilote = idPilote
	EXCEPT
	SELECT idComp
	FROM Compagnie
	WHERE estLowCost = 1
);
/*
# nomPilote
'Naert'
*/

-- Question 5 :
SELECT nomComp
FROM Compagnie 
WHERE NOT EXISTS (
    SELECT idTypeAvion
    FROM TypeAvion
    WHERE idTypeAvion LIKE '%A%'
    EXCEPT
    SELECT leTypeAvion
    FROM Avion
    WHERE idComp = compAv
);
/*
# nomComp
'Air France'
*/

-- Question 6 :
SELECT nomComp
FROM Compagnie 
WHERE NOT EXISTS (
    SELECT idTypeAvion
    FROM TypeAvion
    WHERE idTypeAvion LIKE '%A%'
    EXCEPT
    SELECT leTypeAvion
    FROM Avion
    WHERE idComp = compAv
)
AND NOT EXISTS (
    SELECT leTypeAvion
    FROM Avion
    WHERE idComp = compAv
    EXCEPT
    SELECT idTypeAvion
    FROM TypeAvion
    WHERE idTypeAvion LIKE '%A%'
);
/* 0 row selected */

-- Question 7 :
SELECT COUNT(DISTINCT idComp)
FROM Compagnie
WHERE estLowCost = 1;
/*
# COUNT(DISTINCT idComp)
'2'
*/

SELECT COUNT(estLowCost)
FROM Compagnie
WHERE estLowCost = 1
/*
# COUNT(estLowCost)
'2'
*/

-- Question 8 :
SELECT COUNT(idAvion)
FROM Avion, Compagnie
WHERE compAv = idComp
AND UPPER(nomComp) = 'AIR FRANCE';
/*
# COUNT(idAvion)
'3'
*/

-- Question 9 :
SELECT COUNT(DISTINCT leTypeAvion)
FROM Avion, Compagnie
WHERE compAv = idComp
AND UPPER(nomComp) = 'RYANAIR';
/*
# COUNT(DISTINCT leTypeAvion)
'1'
*/

-- Question 10 :
SELECT SUM(nbPassagers)
FROM TypeAvion, Avion, Compagnie
WHERE idTypeAvion = leTypeAvion
AND compAv = idComp
AND UPPER(nomComp) = 'AIR FRANCE';
/*
# SUM(nbPassagers)
'777'
*/

-- Question 11 :
SELECT idTypeAvion
FROM TypeAvion
ORDER BY nbPassagers
LIMIT 1;
/*
# idTypeAvion
'A320'
*/

-- Question 12 :
SELECT nomComp
FROM Compagnie, Avion, TypeAvion
WHERE idComp = compAv
AND leTypeAvion = idTypeAvion
AND nbPassagers = (SELECT MAX(nbPassagers)
                   FROM TypeAvion
                   );
/*
# nomComp
'Air France'
'American Airlines'
*/

-- Question 13 :
SELECT nomPilote
FROM Pilote
WHERE idPilote IN (SELECT unPilote
                   FROM Qualification
                   GROUP BY unPilote
                   HAVING COUNT(DISTINCT unTypeAvion) >= 2
                   );
/*
# nomPilote
'Ridard'
'Naert'
'Fleurquin'
'Pham'
'Kamp'
*/

-- Question 14 :
SELECT nomPilote
FROM Pilote
WHERE idPilote IN (SELECT unPilote
                   FROM Qualification
                   GROUP BY unPilote
                   HAVING COUNT(DISTINCT unTypeAvion) = (SELECT MAX(nbQualif)
                                                         FROM (
                                                                SELECT COUNT(unTypeAvion) AS nbQualif
                                                                FROM Qualification
                                                                GROUP BY unPilote
                                                              ) AS subQuerry
                                                         GROUP BY unPilote
                                                        )
                   );
/*
# nomPilote
'Fleurquin'
*/

-- Question 15 :
SELECT nomPilote, COUNT(unTypeAvion)
FROM Pilote
    LEFT JOIN Qualification ON idPilote = unPilote
GROUP BY idPilote, nomPilote
HAVING COUNT(unTypeAvion) = (
                             SELECT MIN(nbQualif)
                             FROM (
                                   SELECT COUNT(unTypeAvion) AS nbQualif
                                   FROM Qualification
                                   GROUP BY unPilote
                             ) AS subQuery
);
/*
# nomPilote, COUNT(unTypeAvion)
'Godin', '1'
*/

-- Question 16 :
SELECT nomComp, AVG(nbHVol)
FROM Pilote, Compagnie
WHERE compPil = idComp
GROUP BY nomComp
ORDER BY nomComp;
/*
# nomComp, AVG(nbHVol)
'Air France', '2250.0000'
'American Airlines', '1950.0000'
'EasyJet', '450.0000'
'Ryanair', '450.0000'
*/

-- Question 17 :
SELECT nomComp, SUM(nbPassagers)
FROM Compagnie, Avion, TypeAvion
WHERE idComp = compAv
AND leTypeAvion = idTypeAvion
GROUP BY nomComp;
/*
# nomComp, SUM(nbPassagers)
'Air France', '777'
'EasyJet', '174'
'Corsair International', '174'
'Ryanair', '348'
'American Airlines', '603'
*/