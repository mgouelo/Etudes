
/*
Nom : Gouélo
Prénom : Matthieu
Groupe : D1

---- TP6 ----
*/

-- EXERCICE 2
-- Question 3 :
-- En Algèbre Relationnel : Film[titre]
-- En SQL :
SELECT DISTINCT UPPER(titre)
FROM Film;
/* Résultat exécution :
95 lignes sélectionnées

UPPER(TITRE)                                                                    
--------------------------------------------------------------------------------
80 CHASSEURS
BEHIND THE HELL
TEMP?TE DANS LES BOURDONS
LADS WITH A KILT
...
*/

SELECT DISTINCT titre
FROM Film;
/* Résultat exécution :
98 lignes sélectionnées

TITRE                                                                           
--------------------------------------------------------------------------------
Marius
Les sept boules de cristal
Le moulin rouge
Temp?te dans les bourdons
...
*/


-- Question 4 :
-- En A.R : Film{anneeSortie = 2019}[titre]
-- En SQL :
SELECT DISTINCT UPPER(titre)
FROM Film
WHERE anneeSortie = 2019;
/* Résultat exécution :
UPPER(TITRE)                                                                    
--------------------------------------------------------------------------------
ALITA : BATTLE ANGEL
ONCE UPON A TIME ... IN HOLLYWOOD
AD ASTRA
*/


-- Question 5 :
-- En A.R : Film{anneeSortie >= 2017 AND anneeSortie <= 2019}[titre]
-- En SQL :
SELECT DISTINCT UPPER(titre)
FROM Film
WHERE anneeSortie >= 2017 AND anneeSortie <= 2019;
/* Résultat exécution :
6 ligne sélectionnées

UPPER(TITRE)                                                                    
--------------------------------------------------------------------------------
DUNKERQUE
PIRATES DES CARAIBES : LA VENGEANCE DE SALAZAR
ALITA : BATTLE ANGEL
MISSION IMPOSSIBLE : FALLOUT
ONCE UPON A TIME ... IN HOLLYWOOD
AD ASTRA
*/


-- QUESTION 6 :
-- En A.R : (Acteur x Personne x Film){idPersonne = leRealisateur OR idPersonne = unActeur}[nom]
-- En SQL :
SELECT DISTINCT UPPER(nom)
FROM Personne, Film, Acteur
WHERE idPersonne = leRealisateur
OR idPersonne = unActeur;


-- Question 7 :
-- En A.R : (Film[[leRealisateur = idPersonne]]Film){pays = 'Japon'}[titre]
-- En SQL :
SELECT DISTINCT UPPER(titre)
FROM Film, Personne
WHERE leRealisateur = idPersonne
AND UPPER(pays) = 'JAPON';
/* Résultat exécution :
UPPER(TITRE)                                                                    
--------------------------------------------------------------------------------
LA FORTERESSE CACHEE
LES SEPT SAMOURAIS
DERSOU OUZALA
*/


-- Question 8 :
-- En A.R : (Personne[[idPersonne = leRealisateur]]Film){pays = 'France' AND anneeSortie >= 2014 AND anneeSortie <= 2020}[nom, prenom]
-- En SQL :
SELECT DISTINCT UPPER(prenom), UPPER(nom)
FROM Personne
JOIN Film ON idPersonne = leRealisateur
WHERE UPPER(pays) = 'FRANCE' AND anneeSortie >= 2014 AND anneeSortie <= 2020;
/* Résultat exécution 

UPPER(PRENOM)        UPPER(NOM)          
-------------------- --------------------
LUC                  BESSON              
ZEM                  ROSCHDY             
*/


-- Question 9 :
-- En A.R : (Film[[leRealisateur = idPersonne]]Personne){prenom = 'Luc' AND nom = 'Besson'}[titre, anneeSortie]
-- En SQL :
SELECT DISTINCT UPPER(titre), anneeSortie
FROM Film 
JOIN Personne ON leRealisateur = idPersonne
WHERE UPPER(prenom) = 'LUC' AND UPPER(nom) = 'BESSON';
/* Résultat exécution 
UPPER(TITRE)                                                                     ANNEESORTIE
-------------------------------------------------------------------------------- -----------
LUCY                                                                                    2014
LES AVENTURES EXTRAORDINAIRES D ADELE BLANC SEC                                         2010
LE GRAND BLEU                                                                           1988
*/


-- Question 10 :
-- En A.R : Personne[nom, prenom] - (Personne[[idPersonne = leRealisateur]]Film)[nom, prenom]
-- En SQL :
SELECT DISTINCT UPPER(nom), UPPER(prenom)
FROM Personne
MINUS
SELECT DISTINCT UPPER(nom), UPPER(prenom)
FROM Film, Personne
WHERE idPersonne = leRealisateur;

/* Résultat exécution :
68 lignes sélectionnées

UPPER(NOM)           UPPER(PRENOM)       
-------------------- --------------------
BARDOT               BRIGITTE            
BARNES               BEN                 
BLANCHETT            KATE
*/


-- Question 11 :
-- En A.R : (Personne[[idPersonne = unActeur]]Acteur){cachet < 10000}[nom, prenom]
-- En SQL :
SELECT DISTINCT UPPER(nom), UPPER(prenom)
FROM Personne
JOIN Acteur ON idPersonne = unActeur
WHERE cachet < 10000;
/* Résultat exécution 
10 lignes sélectionnées

UPPER(NOM)           UPPER(PRENOM)       
-------------------- --------------------
HOWARD               TREVOR              
MORENO               GUY                 
MARCEAU              SOPHIE              
RAIMU                                   
...
*/


-- Question 12 :
SELECT DISTINCT UPPER(F1.titre), UPPER(F2.titre)
FROM Film F1, Film F2
WHERE F1.anneeSortie = F2.anneeSortie
AND UPPER(F1.titre) < UPPER(F2.titre);
/* Résultat exécution 
72 lignes sélectionnées

UPPER(F1.TITRE)                                                                  UPPER(F2.TITRE)                                                                 
-------------------------------------------------------------------------------- --------------------------------------------------------------------------------
LA ROUTE DE MAGGERSFONTEIN                                                       LE MOULIN ROUGE                                                                 
DERSOU OUZALA                                                                    LA ROUTE DE MAGGERSFONTEIN                                                      
PIRATES DES CARAIBES : JUSQU AU BOUT DU MONDE                                    THIS GLEN IS MINE                                                               
BONS BAISERS DE RUSSIE                                                           MISSION IMPOSSIBLE                                                              
BLUE JASMINE                                                                     OBLIVION                                                                        
CARTEL                                                                           TO ROME WITH LOVE                                                               
HARRY POTTER ET LES RELIQUES DE LA MORT 1 ERE PARTIE                             LES AVENTURES EXTRAORDINAIRES D ADELE BLANC SEC                                 
DIVERGENTE                                                                       LUCY                                                                            
DUST IN THE DRONES                                                               PERMIS DE TUER                                                                  
HARRY POTTER ET LA CHAMBRE DES SECRETS                                           MEURS UN AUTRE JOUR                                                             
MISSION IMPOSSIBLE 3                                                             PIRATES DES CARAIBES : LE SECRET DU COFFRE MAUDIT         
...
*/




-- Question 13 :
SELECT UPPER(nom), UPPER(prenom)
FROM Personne, Acteur, Film
WHERE idPersonne = unActeur
WHERE unFilm = code
WHERE UPPER(Film.titre) = 'HUNGER GAMES';
/* Résultat exécution 

UPPER(NOM)           UPPER(PRENOM)       
-------------------- --------------------
LAWRENCE             JENNIFER            
HUTCHERSON           JOSHUA              
HEMSWORTH            LIAM 
*/


-- Question 14 :
SELECT DISTINCT UPPER(titre)
FROM Film, Personne, Acteur
WHERE idPersonne = unActeur
AND unFilm = code
AND UPPER(nom) = 'CRUISE' AND UPPER(prenom) = 'TOM';
/* Résultat exécution 
8 lignes sélectionnées. 

UPPER(TITRE)                                                                    
--------------------------------------------------------------------------------
MISSION IMPOSSIBLE : ROGUE NATION
MISSION IMPOSSIBLE 3
LIONS ET AGNEAUX
MISSION IMPOSSIBLE 2
MISSION IMPOSSIBLE : PROTOCOLE FANTOME
MISSION IMPOSSIBLE : FALLOUT
OBLIVION
MISSION IMPOSSIBLE
*/


-- Question 15 :
SELECT DISTINCT UPPER(P1.nom), UPPER(P1.prenom)
FROM Personne P1, Personne P2, Film, Acteur
WHERE P1.idPersonne = unActeur
AND P2.idPersonne = leRealisateur
AND unFilm = code
AND UPPER(P2.nom) = 'ALLEN' AND UPPER(P2.prenom) = 'WOODY';
/* Résultat exécution 

UPPER(P1.NOM)        UPPER(P1.PRENOM)    
-------------------- --------------------
CRUZ                 PENELOPE            
ELMALEH              GAD                 
ALLEN                WOODY               
COTTILARD            MARION              
BLANCHETT            KATE 
*/


-- Question 16 :
SELECT DISTINCT UPPER(titre)
FROM Film, Acteur
WHERE leRealisateur = unActeur;
/* Résultat exécution
19 lignes sélectionnées

UPPER(TITRE)                                                                    
--------------------------------------------------------------------------------
80 CHASSEURS
LE TRACTEUR
LES SEPT BOULES DE CRISTAL
LA FORTERESSE CACHEE
LES SEPT NAINS
BUCK
...
*/
