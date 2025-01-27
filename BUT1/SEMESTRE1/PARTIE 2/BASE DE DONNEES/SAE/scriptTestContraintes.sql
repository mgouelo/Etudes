/*
SAE SQL Tache n°2 : Tests des contraintes
Etudiant 1 : BROCARD Célian
Etudiant 2 : GOUELO Matthieu
*/


TRUNCATE TABLE Location;
TRUNCATE TABLE Vente;
TRUNCATE TABLE Client;
TRUNCATE TABLE Bien;
TRUNCATE TABLE Agent;
TRUNCATE TABLE Agence;

-- Test a) existence de la clé primaire dans la table Client
INSERT INTO Client (idClient, nomClient, email) VALUES (NULL, 'Test', 'matthieu@gouelo.com');
/*
Erreur commençant à la ligne: 9 de la commande -

Rapport d'erreur -
ORA-01400: cannot insert NULL into ("CELIAN"."CLIENT"."IDCLIENT")
*/



-- Test b) unicit´e de la cl´e candidate dans la table Bien
INSERT INTO Bien (idBien, adresse, nbPieces, valeur) VALUES (1, '123 la ici', 3, 100000);
INSERT INTO Bien (idBien, adresse, nbPieces, valeur) VALUES (2, '123 la ici', 4, 150000);

/*
Erreur commençant à la ligne: 8 de la commande -
INSERT INTO Bien (idBien, adresse, nbPieces, valeur) VALUES (1, '123 la ici', 3, 100000)
Rapport d'erreur -
ORA-00001: unique constraint (CELIAN.PK_IDBIEN) violated

Erreur commençant à la ligne: 9 de la commande -
INSERT INTO Bien (idBien, adresse, nbPieces, valeur) VALUES (2, '123 la ici', 4, 150000)
Rapport d'erreur -
ORA-00001: unique constraint (CELIAN.PK_IDBIEN) violated
*/



-- Test c) intégrité référentielle de la clé étrangère dans la table Bien
INSERT INTO Bien (idBien, adresse, nbPieces, unAgent) VALUES (6, '3 rue du Pere Noel', 2,  1);

/*
Rapport d'erreur -
ORA-00001: unique constraint (CELIAN.PK_IDBIEN) violated
*/



-- Test d) Referential integrity of the foreign key in the Agent table
INSERT INTO Agent (numAgent, nom, salaire, numAgence) VALUES (1, 'JEAN', 4000, 1000);

/*
Rapport d'erreur -
Erreur SQL : ORA-00904: "NUMAGENCE": invalid identifier
00904. 00000 -  "%s: invalid identifier"
*Cause:    
*Action:
*/



-- Test e) CHECK constraint on the salary attribute
INSERT INTO Agent (numAgent, nom, salaire, numAgence) VALUES (2, 'Baltasar', 10, 1);

/*
Rapport d'erreur -
Erreur SQL : ORA-00904: "NUMAGENCE": invalid identifier
00904. 00000 -  "%s: invalid identifier"
*Cause:    
*Action:
*/



-- Test f) CHECK constraint dateFin > dateDebut in the Location table
INSERT INTO Location (leBienL, leClientL, dateDebut, dateFin, loyer) VALUES (1, 1, NULL, 1000);

/*
Rapport d'erreur -
Erreur SQL : ORA-00947: not enough values
00947. 00000 -  "not enough values"
*Cause:    
*Action:
*/

