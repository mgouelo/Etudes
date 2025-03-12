/*
SAE SQL Tache n°3 : Requêtes avec Algèbre Relationnel
Etudiant 1 : BROCARD Célian
Etudiant 2 : GOUELO Matthieu

Pour les questions qui suivent, on se basera sur le script 
d'insertion de données ci-dessous
*/

INSERT INTO Agence VALUES (1, '10 rue de Paris, Paris', '09:00-18:00');
INSERT INTO Agence VALUES (2, '20 avenue des Champs, Lyon', '08:30-17:30');
INSERT INTO Agence VALUES (3, '5 place Bellecour, Marseille', '10:00-19:00');
INSERT INTO Agence VALUES (4, '12 rue des Fleurs, Nantes', '08:00-17:00');
INSERT INTO Agence VALUES (5, '45 avenue Jean Jaurès, Toulouse', '09:30-18:30');
INSERT INTO Agence VALUES (6, '99 boulevard Haussmann, Bordeaux', '10:00-19:30');
INSERT INTO Agence VALUES (7, '7 rue des Oliviers, Lille', '08:00-16:30');
INSERT INTO Agence VALUES (8, '12 avenue du Prado, Marseille', '09:00-18:00');
INSERT INTO Agence VALUES (9, '15 rue de Bretagne, Rennes', '10:00-19:00');



INSERT INTO Agent VALUES (1, 'Dupont', 'Jean', 4000, 'V', 1);
INSERT INTO Agent VALUES (2, 'Martin', 'Claire', 3800, 'F', 2);
INSERT INTO Agent VALUES (3, 'Durand', 'Paul', 5000, 'V', 3);
INSERT INTO Agent VALUES (4, 'Morel', 'Sophie', 4200, 'F', 4);
INSERT INTO Agent VALUES (5, 'Leclerc', 'Pierre', 3900, 'F', 5);
INSERT INTO Agent VALUES (6, 'Simon', 'Luc', 5500, 'V', 6);
INSERT INTO Agent VALUES (7, 'Lambert', 'Marie', 4500, 'F', 7);
INSERT INTO Agent VALUES (8, 'Dubois', 'Émile', 4500, 'V', 8);
INSERT INTO Agent VALUES (9, 'Fontaine', 'Alice', 4000, 'F', 9);



INSERT INTO Bien VALUES (1, '15 rue de la Paix, Paris', 3, 300000, 2010, 'V', 'F', 'F', 1);
INSERT INTO Bien VALUES (2, '25 avenue Lumière, Lyon', 5, 450000, 2015, 'F', 'V', 'F', 2);
INSERT INTO Bien VALUES (3, '30 boulevard de la Mer, Marseille', 4, 500000, 2020, 'V', 'V', 'V', 3);
INSERT INTO Bien VALUES (4, '10 rue de Bretagne, Nantes', 2, 200000, 2005, 'V', 'F', 'F', 4);
INSERT INTO Bien VALUES (5, '60 rue Lafayette, Toulouse', 6, 600000, 2018, 'F', 'V', 'F', 5);
INSERT INTO Bien VALUES (6, '85 rue Sainte-Catherine, Bordeaux', 4, 450000, 2021, 'V', 'V', 'V', 6);
INSERT INTO Bien VALUES (7, '12 rue de la Gare, Lille', 3, 350000, 2008, 'F', 'F', 'F', 7);
INSERT INTO Bien VALUES (8, '18 avenue du Prado, Marseille', 5, 520000, 2017, 'V', 'V', 'F', 8);
INSERT INTO Bien VALUES (9, '21 rue de Bretagne, Rennes', 2, 200000, 2012, 'F', 'F', 'F', 9);
INSERT INTO Bien VALUES (10, '15 rue de Bretagne, Rennes', 3, 220000, 2010, 'F', 'F', 'F', 9);
INSERT INTO Bien VALUES (11, '18 avenue du Prado, Marseille', 4, 500000, 2019, 'V', 'V', 'F', 8);
INSERT INTO Bien VALUES (12, '12 rue de la Gare, Lille', 2, 300000, 2020, 'F', 'F', 'F', 7);




INSERT INTO Client VALUES (1, 'Gouelo', 'Matthieu', 'matthieu.gouelo@exemple.com', '40 rue du Temple, Paris', '0601020304');
INSERT INTO Client VALUES (2, 'Brocard', 'Celian', 'celian.brocard@exemple.com', '50 avenue des Lilas, Lyon', '0705060708');
INSERT INTO Client VALUES (3, 'Pham', 'Minthan', 'minthan.pham@exemple.com', '60 place de la République, Marseille', '0807080910');
INSERT INTO Client VALUES (4, 'Bernard', 'Alice', 'alice.bernard@exemple.com', '70 boulevard de la Liberté, Nantes', '0611223344');
INSERT INTO Client VALUES (5, 'Dubois', 'Victor', 'victor.dubois@exemple.com', '80 avenue du Capitole, Toulouse', '0622334455');
INSERT INTO Client VALUES (6, 'Lemoine', 'Camille', 'camille.lemoine@exemple.com', '15 rue de Bretagne, Rennes', '0633445566');
INSERT INTO Client VALUES (7, 'Roux', 'Paul', 'paul.roux@exemple.com', 'Paris', '0612345678');
INSERT INTO Client VALUES (8, 'Blanc', 'Julie', 'julie.blanc@exemple.com', 'Lyon', '0687654321');
INSERT INTO Client VALUES (9, 'Noir', 'Clara', 'clara.noir@exemple.com', 'Marseille', '0777888999');
INSERT INTO Client VALUES (11, 'Durand', 'Lucie', 'lucie.durand@exemple.com', '18 avenue du Prado, Marseille', '0655667788');
INSERT INTO Client VALUES (12, 'Garcia', 'Antoine', 'antoine.garcia@exemple.com', '12 rue de la Gare, Lille', '0622334455');



INSERT INTO Vente VALUES (1, 1, TO_DATE('2023-01-15', 'YYYY-MM-DD'), 320000);
INSERT INTO Vente VALUES (2, 2, TO_DATE('2023-03-10', 'YYYY-MM-DD'), 460000);
INSERT INTO Vente VALUES (3, 3, TO_DATE('2023-05-25', 'YYYY-MM-DD'), 510000);
INSERT INTO Vente VALUES (4, 4, TO_DATE('2023-06-15', 'YYYY-MM-DD'), 210000);
INSERT INTO Vente VALUES (5, 5, TO_DATE('2023-08-20', 'YYYY-MM-DD'), 610000);
INSERT INTO Vente VALUES (6, 6, TO_DATE('2023-10-05', 'YYYY-MM-DD'), 470000);
INSERT INTO Vente VALUES (7, 7, TO_DATE('2023-06-01', 'YYYY-MM-DD'), 355000);
INSERT INTO Vente VALUES (8, 8, TO_DATE('2023-07-15', 'YYYY-MM-DD'), 530000);
INSERT INTO Vente VALUES (9, 9, TO_DATE('2023-09-10', 'YYYY-MM-DD'), 215000);



INSERT INTO Location VALUES (1, 2, TO_DATE('2023-06-01', 'YYYY-MM-DD'), TO_DATE('2024-05-31', 'YYYY-MM-DD'), 1200);
INSERT INTO Location VALUES (2, 3, TO_DATE('2023-07-01', 'YYYY-MM-DD'), TO_DATE('2024-06-30', 'YYYY-MM-DD'), 1500);
INSERT INTO Location VALUES (3, 1, TO_DATE('2023-08-01', 'YYYY-MM-DD'), TO_DATE('2024-07-31', 'YYYY-MM-DD'), 1800);
INSERT INTO Location VALUES (4, 5, TO_DATE('2023-09-01', 'YYYY-MM-DD'), TO_DATE('2024-08-31', 'YYYY-MM-DD'), 1400);
INSERT INTO Location VALUES (5, 6, TO_DATE('2023-10-01', 'YYYY-MM-DD'), TO_DATE('2024-09-30', 'YYYY-MM-DD'), 1600);
INSERT INTO Location VALUES (6, 4, TO_DATE('2023-11-01', 'YYYY-MM-DD'), TO_DATE('2024-10-31', 'YYYY-MM-DD'), 1900);
INSERT INTO Location VALUES (7, 8, TO_DATE('2023-10-01', 'YYYY-MM-DD'), TO_DATE('2024-09-30', 'YYYY-MM-DD'), 1350);
INSERT INTO Location VALUES (8, 9, TO_DATE('2023-11-01', 'YYYY-MM-DD'), TO_DATE('2024-10-31', 'YYYY-MM-DD'), 1500);
INSERT INTO Location VALUES (9, 7, TO_DATE('2023-12-01', 'YYYY-MM-DD'), TO_DATE('2024-11-30', 'YYYY-MM-DD'), 1200);







-- a) projection avec restriction 
-- Question 1 : Lister les noms et email des client résidant à Paris.
-- En Algèbre Relationnel : Client{adresse='Paris'}[nomClient, email]
-- En SQL :
SELECT DISTINCT nomClient, email
FROM Client
WHERE adresseClient LIKE '%Paris%';
/* Résultats d'exécution 
NOMCLIENT                                          EMAIL                                             
-------------------------------------------------- --------------------------------------------------
Gouelo                                             matthieu.gouelo@exemple.com                       
Roux                                               paul.roux@exemple.com 
*/


-- Question 2 : Lister les adresses et valeurs des biens ayant plus de 3 pièces.
-- En A.R : Bien{nbPieces>3}[adresse, valeur]
SELECT adresse, valeur 
FROM Bien 
WHERE nbPieces > 3;
/* Résultat d'exécution
ADRESSE                                                VALEUR
-------------------------------------------------- ----------
25 avenue Lumière, Lyon                                450000
30 boulevard de la Mer, Marseille                      500000
60 rue Lafayette, Toulouse                             600000
85 rue Sainte-Catherine, Bordeaux                      450000
18 avenue du Prado, Marseille                          520000
*/




-- b) Union, intersection, différence
-- Question 1 : Lister toutes les adresses uniques des tables Client et Bien.
-- En A.R : Client[adresse] ∪ Bien[adresse]
SELECT adresseClient 
FROM Client 
UNION 
SELECT adresse 
FROM Bien;
/* Résultat d'exécution
ADRESSECLIENT                                     
--------------------------------------------------
10 rue de Bretagne, Nantes
12 rue de la Gare, Lille
15 rue de la Paix, Paris
18 avenue du Prado, Marseille
....

ADRESSECLIENT                                     
--------------------------------------------------
70 boulevard de la Liberté, Nantes
80 avenue du Capitole, Toulouse
85 rue Sainte-Catherine, Bordeaux
...

18 lignes sélectionnées
*/


-- Question 2 : Lister les adresses communes entre les tables Client et Bien.
-- En A.R: Client[adresse] ∩ Bien[adresse]
SELECT adresseClient 
FROM Client 
INTERSECT 
SELECT adresse 
FROM Bien;
/* Résultat d'exécution

ADRESSECLIENT                                     
--------------------------------------------------
12 rue de la Gare, Lille
15 rue de Bretagne, Rennes
18 avenue du Prado, Marseille
*/




-- Question 3 : Lister les adresses dans la table Client qui ne sont pas dans la table Bien.
-- En A.R : Client[adresse] - Bien[adresse]
SELECT adresseClient
FROM Client 
MINUS 
SELECT adresse 
FROM Bien;
/* Résultat exécution 
ADRESSECLIENT                                     
--------------------------------------------------
40 rue du Temple, Paris
50 avenue des Lilas, Lyon
60 place de la République, Marseille
70 boulevard de la Liberté, Nantes
80 avenue du Capitole, Toulouse
Lyon
Marseille
Paris

8 lignes sélectionnées.
*/


-- c) Tri avec restriction
-- Question 1 : Lister les biens ayant plus de 2 pièces, triés par valeur.
-- En A.R : Bien{nbPieces>2}[adresse, valeur](valeur>)
SELECT adresse, valeur 
FROM Bien 
WHERE nbPieces > 2 
ORDER BY valeur;
/* Résultat exécution
ADRESSE                                                VALEUR
-------------------------------------------------- ----------
15 rue de Bretagne, Rennes                             220000
15 rue de la Paix, Paris                               300000
12 rue de la Gare, Lille                               350000
25 avenue Lumière, Lyon                                450000
...

8 lignes sélectionnées.
*/



-- d) Tri multi-attributs avec restriction
-- Question 1 : Lister les clients triés par ville puis par nom dont le numéro de téléphone commence par 06
-- En A.R : Client{nomClient = '%C%'}[nomClient, adresseClient]( (adresse, nomClient) >)
SELECT nomClient, adresseClient 
FROM Client 
WHERE tel LIKE '06%'
ORDER BY adresseClient, nomClient;
/* Résultat exécution 

NOMCLIENT                                          ADRESSECLIENT                                     
-------------------------------------------------- --------------------------------------------------
Blanc                                              Lyon                                              
Roux                                               Paris                                             
Garcia                                             12 rue de la Gare, Lille
...

8 lignes sélectionnées
*/


-- e) Tri + limitation (avec ROWNUM)
-- Question 8 : Lister les 5 biens les plus chers.
-- En A.R : Bien{ROWNUM <= 5}[adresse, valeur](valeur<)
SELECT adresse, valeur 
FROM (SELECT adresse, valeur 
    FROM Bien 
    ORDER BY valeur DESC) 
WHERE ROWNUM <= 5;
/* Résultat exécution 
ADRESSE                                                VALEUR
-------------------------------------------------- ----------
60 rue Lafayette, Toulouse                             600000
18 avenue du Prado, Marseille                          520000
30 boulevard de la Mer, Marseille                      500000
25 avenue Lumière, Lyon                                450000
85 rue Sainte-Catherine, Bordeaux                      450000
*/


-- f) Jointure de 2 tables
-- Question 2 : Lister les noms des clients et les adresses de leurs biens
-- En A.R : Agent[[numAgent = unAgent]]Bien[nom, adresse]
SELECT nom, adresse 
FROM Agent, Bien 
WHERE Agent.numAgent = Bien.unAgent;
/* Résultat exécution 
NOM                                                ADRESSE                                           
-------------------------------------------------- --------------------------------------------------
Dupont                                             15 rue de la Paix, Paris                          
Martin                                             25 avenue Lumière, Lyon                           
Durand                                             30 boulevard de la Mer, Marseille
...

10 lignes sélectionnées
*/

-- Question 2: Liste des clients en Location.
-- En A.R : Client[[idClient = leClient]]Location[nomClient, adresse]
SELECT nomClient
FROM Client, Location
WHERE Client.idClient = Location.leClientL 
/* Résultat exécution 
NOMCLIENT                                         
--------------------------------------------------
Gouelo
Brocard
Pham
...

9 lignes sélectionnées
*/


-- g) Jointure de 3 tables
-- Question 11 : Lister les noms des clients, les adresses des biens qu'ils ont loués, et les noms des agents responsables de ces biens.
-- En A.R : Client[[idClient = leClient]]Location[[leBienL = idBien]]Bien[nomClient, adresse]
SELECT nomClient, adresse
FROM Client, Location, Bien
WHERE Client.idClient = Location.leClientL 
AND Location.leBienL = Bien.idBien 
/* Résultat exécution 
NOMCLIENT                                          ADRESSE                                           
-------------------------------------------------- --------------------------------------------------
Brocard                                            15 rue de la Paix, Paris                          
Pham                                               25 avenue Lumière, Lyon                           
Gouelo                                             30 boulevard de la Mer, Marseille
...

9 ligne sélectionnées
*/


-- h) Auto-jointure
-- Question 12 : Lister les noms des agents ayant le même salaire qu'un autre agent.
-- En A.R : Agent A1[[A1.salaire != A2.salaire]]Agent A2[A1.nom]
SELECT A1.nom
FROM Agent A1, Agent A2 
WHERE A1.salaire = A2.salaire 
AND A1.numAgent != A2.numAgent;
/* Résultat exécution 
NOM                                               
--------------------------------------------------
Fontaine
Dubois
Lambert
Dupont
*/


-- i) Jointure externe (sans algèbre relationnelle)
-- Question 13 : Lister tous les clients et les biens qu'ils ont loués, y compris les clients qui n'ont loué aucun bien.
SELECT Client.nomClient, Bien.adresse 
FROM Client 
LEFT JOIN Location ON Client.idClient = Location.leClientL 
LEFT JOIN Bien ON Location.leBienL = Bien.idBien;
/* Résultat exécution
NOMCLIENT                                          ADRESSE                                           
-------------------------------------------------- --------------------------------------------------
Brocard                                            15 rue de la Paix, Paris                          
Pham                                               25 avenue Lumière, Lyon                           
Gouelo                                             30 boulevard de la Mer, Marseille
...

11 lignes sélectionnées
*/

-- Question 14 : Lister tous les biens et les clients qui les ont loués, y compris les biens qui n'ont pas été loués.
SELECT Bien.adresse, Client.nomClient 
FROM Bien 
LEFT JOIN Location ON Bien.idBien = Location.leBienL 
LEFT JOIN Client ON Location.leClientL = Client.idClient;
/* Résultat exécution 
ADRESSE                                            NOMCLIENT                                         
-------------------------------------------------- --------------------------------------------------
30 boulevard de la Mer, Marseille                  Gouelo                                            
15 rue de la Paix, Paris                           Brocard                                           
25 avenue Lumière, Lyon                            Pham
...

10 lignes sélectionnées
*/