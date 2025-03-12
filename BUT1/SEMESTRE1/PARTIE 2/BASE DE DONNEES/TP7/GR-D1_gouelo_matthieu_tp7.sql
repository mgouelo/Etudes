
/*
Nom : Gouélo
Prénom : Matthieu
Groupe : D1

---- TP7 ----
*/

-- EXERCICE 2
-- Question 10 :
-- En Algèbre Relationnel : (EtudiantInfo[[EtudiantInfo.nomEtu = EnseignantInfo.nomEns]]EnseigantInfo){groupe = 'A'}[nomEtu]
-- En SQL :
SELECT DISTINCT UPPER(nomEtu)
FROM EtudiantInfo, EnseignantInfo
WHERE UPPER(prenom) = UPPER(prenomEns)
AND UPPER(groupe) = 'A';
/* Résultat exécution 
UPPER(NOMETU)                           
----------------------------------------
PATINEC
*/


-- Question 11 :
-- En A.R : (EtudiantInfo[[prenom = prenomEns]]EnseignantInfo){noEns = 3 OR noEns = 4}[prenom, nomEtu]
-- En SQL :
SELECT DISTINCT UPPER(nomEtu), UPPER(prenom)
FROM EtudiantInfo, EnseignantInfo
WHERE UPPER(prenom) = UPPER(prenomEns)
AND ( noEns = 3 OR noEns = 4 );
/* Résultat exécution :
UPPER(NOMETU)                            UPPER(PRENOM)                 
---------------------------------------- ------------------------------
PONDAVEN                                 THIBAULT                      
*/


-- Question 12 :
-- En A.R : (EnseignantInfo E1[[E1.prenomEns = E2.prenomEns]]EnseignantInfo E2){E1.noEns != E2.noEns}[E2.nomEns]
-- En SQL :
SELECT DISTINCT UPPER(E2.nomEns)
FROM EnseignantInfo E1, EnseignantInfo E2
WHERE UPPER(E1.prenomEns) = UPPER(E2.prenomEns)
AND E1.noEns = 5
AND E2.noEns != 5;
/* Résultat exécution :
UPPER(E2.NOMENS)    
--------------------
JOUCLA
*/


-- Question 13 :
-- En A.R : (EtudiantInfo E1 [[E1.prenom = E2.prenom]]EtudiantInfo E2){E1.noEtu != E2.noEtu}[E2.nomEtu, E2.prenom]
-- En SQL :
SELECT DISTINCT UPPER(E2.nomEtu), UPPER(E2.prenom)
FROM EtudiantInfo E1, EtudiantInfo E2
WHERE UPPER(E1.prenom) = UPPER(E2.prenom)
AND UPPER(E1.noEtu) != UPPER(E2.noEtu);
/* Résultat exécution 
20 lignes sélectionnées

UPPER(E2.NOMETU)                         UPPER(E2.PRENOM)              
---------------------------------------- ------------------------------
ROUSSEL                                  PAUL                          
COIGNARD                                 MAËL                          
PICARD                                   BENJAMIN                      
SAUNDERS                                 BENJAMIN                      
VRIGNAUD                                 PAUL                          
...
*/


-- Question 14 :
-- En A.R : EtudiantInfo E1[[E1.prenom = E2.prenom]]EtudiantInfo E2{E1.groupe != E2.groupe}[E1.prenom]
-- En SQL :
SELECT DISTINCT UPPER(E2.prenom)
FROM EtudiantInfo E1, EtudiantInfo E2
WHERE UPPER(E1.prenom) = UPPER(E2.prenom)
AND E1.groupe != E2.groupe;
/* Résultat exécution :
8 lignes selctionnées

UPPER(E2.PRENOM)              
------------------------------
WILLIAM
BENJAMIN
SAMUEL
LOUIS
PAUL
*/


-- Question 15 :
-- En SQL :
SELECT *
FROM (
    SELECT DISTINCT UPPER(prenom)
    FROM EtudiantInfo
    ORDER BY UPPER(prenom)
    )
WHERE ROWNUM <= 5;
/* Résultat exécution :
UPPER(PRENOM)                 
------------------------------
ABDUL-MALIK
ALEXANDRE
ALEXIA
ALEXIS
ALIAUME
*/


-- QUestion 16 :
-- En SQL :
SELECT *
FROM (
    SELECT DISTINCT UPPER(prenom)
    FROM EtudiantInfo
    ORDER BY UPPER(prenom) DESC
    )
WHERE ROWNUM <= 5;
/* Résultat exécutions :

UPPER(PRENOM)                 
------------------------------
YANIS
WILLIAM
VICTOR
TITOUAN
THOMAS
*/


-- Question 17 :
-- En SQL :
SELECT *
FROM (
    SELECT prenom
    FROM (
        SELECT DISTINCT UPPER(prenom) AS prenom
        FROM EtudiantInfo
        WHERE UPPER(prenom) LIKE 'S%'
        UNION
        SELECT DISTINCT UPPER(prenomEns) AS prenom
        FROM EnseignantInfo
        WHERE UPPER(prenomEns) LIKE 'S%'
    )
    ORDER BY prenom DESC
)
WHERE ROWNUM <= 5;
/* Résultat exécution :

PRENOM                        
------------------------------
SOPHIE
SERGE
SEBASTIEN
SARAH
SAMUEL
*/


-- Question 18 :
-- En SQL :
SELECT noEns, UPPER(nomEtu), UPPER(prenom)
FROM EnseignantInfo, EtudiantInfo
WHERE UPPER(prenomEns) = UPPER(prenom);
/* Résultat exécution :
     NOENS UPPER(NOMETU)                            UPPER(PRENOM)                 
---------- ---------------------------------------- ------------------------------
         8 PATINEC                                  FRANCOIS                      
         3 PONDAVEN                                 THIBAULT                      
*/


-- Question 19 :
-- En SQL :
SELECT noEns, UPPER(nomEtu), UPPER(prenom)
FROM EnseignantInfo, EtudiantInfo
WHERE UPPER(prenomEns) = UPPER(prenom(+));
/* Résultat exécution :
20 lignes sélectionnées

     NOENS UPPER(NOMETU)                            UPPER(PRENOM)                 
---------- ---------------------------------------- ------------------------------
         8 PATINEC                                  FRANCOIS                      
         3 PONDAVEN                                 THIBAULT                      
         6                                                                        
        20                                                                       
...
*/