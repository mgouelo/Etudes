/*
BASE DE DONNEES
TP5
Nom : Gouélo
Prénom : Matthieu
Groupe : D1
*/


-- EXERCICE 2 

-- Question 5 :
SELECT *
FROM EnseignantInfo;
-- 20 tuples



-- Question 6 :
-- En algèbre relationnelle : EtudiantInfo[prenom]
-- SQL :
SELECT DISTINCT prenom
FROM EtudiantInfo;
/* Résultat exécution :
95 lignes sélectionnées 
UPPER(PRENOM)                 
------------------------------
AMÉLIE
BRAYAN
MERLIN
ALVIN
MATTE
...
*/


-- ou
SELECT DISTINCT UPPER(prenom)
FROM EtudiantInfo;
/* Résultat exécution :
91 lignes sélectionnées 
UPPER(PRENOM)                 
------------------------------
AMÉLIE
BRAYAN
MERLIN
ALVIN
MATTE
...
*/

-- Question 7 :
--En A.R : EtudiantInfo{prenom = 'Louis'}
--En SQL :
SELECT *
FROM EtudiantInfo
WHERE prenom = 'Louis';
/* Résultat exécution :
     NOETU NOMETU                                   PRENOM                         GROUP
---------- ---------------------------------------- ------------------------------ -----
        10 BILLARD                                  Louis                          B    
        45 HAMON                                    Louis                          C    
*/


-- Question 8 :
--En A.R : EtudiantInfo{prenom = 'Victor' OU prenom = 'Paul'}
--En SQL :
SELECT *
FROM EtudiantInfo
WHERE UPPER(prenom) = 'VICTOR' OR UPPER(prenom) = 'PAUL';
/* Résultat exécution :
     NOETU NOMETU                                   PRENOM                         GROUP
---------- ---------------------------------------- ------------------------------ -----
        24 DESBROUSSES                              Victor                         A    
        36 GAUFFENY                                 PAuL                           A    
        89 ROUSSEL                                  Paul                           C    
       101 VRIGNAUD                                 pAul                           B    
*/


--Question 9 :
-- Je m'appel Matthieu et je suis en groupe D
SELECT *
FROM EtudiantInfo
WHERE UPPER(prenom) = 'MATTHIEU' AND groupe != 'D';
/* Résultat exécution :
aucune ligne sélectionnée
*/


-- Question 10 :
-- En A.R : EnseignantInfo(nomEns) ∪ EtudiantInfo(nomEtu)
-- En SQL :
SELECT DISTINCT UPPER(nomEns) AS leNom
FROM EnseignantInfo
UNION
SELECT DISTINCT UPPER(nomEtu) AS leNom
FROM EtudiantInfo;
/* Résultat exécution :
123 ligne sélectionnées 
LENOM                                   
----------------------------------------
ALEXANDRE
ANNEIX
ARANDEL
BARATHON
BARIOU
...
*/


-- Question 11 :
-- En A.R : EnseignantInfo(nomEns) ∩ EtudiantInfo(nomEtu)
-- En SQL : 
SELECT DISTINCT UPPER(prenomEns)
FROM EnseignantInfo
INTERSECT
SELECT DISTINCT UPPER(prenom)
FROM EtudiantInfo;


-- Question 12 :
-- En A.R : EnseignantInfo(nomEns) \ EtudiantInfo(nomEtu)
-- En SQL :
SELECT DISTINCT UPPER(prenomEns)
FROM EnseignantInfo
MINUS
SELECT DISTINCT UPPER(prenom)
FROM EtudiantInfo;

/*17 lignes sélectionnées. 
UPPER(PRENOMENS)              
------------------------------
ABDELBADIE
ELODIE
GOULVEN
HELENE
ISABELLE
...
*/


-- Question 13 :
-- En A.R : EnseignantInfo[prenomEns](prenomEns>)
-- En SQL :
SELECT DISTINCT prenomEns
FROM EnseignantInfo
ORDER BY prenomEns DESC;
/* Résultat exécution :
PRENOMENS           
--------------------
Xavier
Thibault
Sophie
Sebastien
Regis
...
*/


-- Question 14 :
-- En A.R : EtudiantInfo{prenom = 'A%A%'}[prenom]
-- En SQL :
SELECT prenom
FROM EtudiantInfo
WHERE UPPER(prenom) LIKE 'A%A%';
/* Résultat exécution :
PRENOM                        
------------------------------
Abdul-Malik
Aliaume
Alexandre
Amaury
Alexia
*/


-- Question 15 :
-- En A.R : EtudiantInfo{nomEtu = '%A'}[noEtu, prenom](nomEtu>)(prenom>)
-- En SQL :
SELECT noEtu, nomEtu 
FROM (
        SELECT *
        FROM EtudiantInfo
        ORDER BY UPPER(nomEtu), UPPER(prenom)
        )
WHERE UPPER(nomEtu) LIKE '%A';
/* Résultat exécution :
     NOETU NOMETU                                  
---------- ----------------------------------------
        35 GARCIA                                  
        48 HUYNH-BA                                
       102 ZENSEN--DA SILVA                        
*/


-- Question 16 :
-- En A.R : EtudiantInfo[nomEtu](nomEtu>)
-- En SQL :
SELECT nomEtu
FROM EtudiantInfo 
ORDER BY nomEtu;
/* Résultat exécution :
103 lignes sélectionnées
NOMETU                                  
----------------------------------------
ALEXANDRE
ANNEIX
ARANDEL
BARATHON
BARIOU
...
*/


-- Question 17 :
-- On récupère tous les noms d'enseignant commençant par la lettre K ou une lettre après la lettre K dans l'alphabet
SELECT DISTINCT nomEns
FROM EnseignantInfo
WHERE nomens >= 'K'
ORDER BY nomEns;


-- On récupère tous les numéros (etudiant et enseignant confondus)
SELECT DISTINCT noEns
FROM EnseignantInfo
UNION
SELECT DISTINCT noEtu
FROM EtudiantInfo;


-- On récupère les prenom qui sont à la fois porté par un enseignant et un étudiant.
SELECT DISTINCT prenom
FROM EtudiantInfo
INTERSECT
SELECT DISTINCT prenomEns
FROM EnseignantInfo; 


-- On récupère les noms des etudiant en groupe D
SELECT DISTINCT nomEtu
FROM EtudiantInfo
MINUS
SELECT DISTINCT nomEtu
FROM EtudiantInfo
WHERE groupe = 'A' OR groupe = 'B' OR groupe = 'C';


-- On récupère tous les noms des étudiant trier par nom de groupe dans l'ordre alphabetique decroissant
SELECT nomEtu
FROM EtudiantInfo
ORDER BY groupe DESC;