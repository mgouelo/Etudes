/*
R1.05 SQL
TP3
Nom : Gouélo
Prénom : Matthieu
*/

/* Schéma relationnel :

Enseignant(nomEns(1), prenomEns, adresse, statut)
Cycle(num(1), enseignantResponsable = @Enseignant.nomEns(UQ)(NN) )
Cours(nomCours(1), volumeH, lEnseignant=@Enseignant.nomEns(NN), leCycle=@Cycle.num(NN) )
Requiert([cours=@Cours.nomCours, coursRequis=@Cours.nomCours](1) )
*/

-- Question 2 :
INSERT INTO Enseignant VALUES ('PHAM', 'Minthan', 'adressePHAM', 'EC');
INSERT INTO Enseignant VALUES ('GODIN', NULL, 'adresseGODIN', 'E');
INSERT INTO Enseignant VALUES ('ELGOAT', 'Baltasar', 'adresseGOAT', 'EC');
INSERT INTO Enseignant VALUES ('ZOUZOUA', NULL, 'adresseZOUZOUA', 'E');
INSERT INTO Enseignant VALUES ('KERBELEC', 'Wordpress', 'adresseKERBELEC', 'E');

INSERT INTO Cycle VALUES (1, 'ZOUZOUA');
INSERT INTO Cycle VALUES (2, 'PHAM');
INSERT INTO Cycle VALUES (2, 'GODIN');

INSERT INTO Cours VALUES ('BDD', 3, 'PHAM', 2);
INSERT INTO Cours VALUES ('Economie', 3, 'ZOUZOUA', 1);
INSERT INTO Cours VALUES ('Maths', 6, 'GODIN', 2);
INSERT INTO Cours VALUES ('Démographie', 1, 'ELGOAT', 1);
INSERT INTO Cours VALUES ('Init Dev Web', 2, 'KERBELEC', 2);

INSERT INTO Requiert VALUES ('BDD', 'Maths');
INSERT INTO Requiert VALUES ('Economie', 'Maths');

-- Question 3 :
/* Avant de re-exécuter il faut supprimer les tuples déjà inséré sinon oracle retournera
une erreur.
*/

-- Question 4 : 
/*
Pour tester l'existence on fait une commande insertion avec la valeur NULL
pour l'attribut qu'on veut tester. Si on obtient une erreur cela signifie
que l'attribut doit être unique.
*/
INSERT INTO Enseignant VALUES (NULL, 'test', 'test', 'test');
/*
Rapport d'erreur -
ORA-01400: cannot insert NULL into ("MGOUELO"."ENSEIGNANT"."NOMENS")
*/

INSERT INTO Enseignant VALUES ('PHAM', 'test', 'test', 'test'); --PHAM existe déjà dans la base
/*
Rapport d'erreur -
ORA-00001: unique constraint (MGOUELO.PK_ENSEIGNANT) violated
*/

INSERT INTO Cycle VALUES (5, NULL);
/*
Rapport d'erreur -
ORA-01400: cannot insert NULL into ("MGOUELO"."CYCLE"."ENSEIGNANTRESPONSABLE")
*/

INSERT INTO Cycle VALUES (5, 'PHAM'); -- PHAM est déjà réferencé dans Cycle
/*
Rapport d'erreur -
ORA-00001: unique constraint (MGOUELO.UQ_ENSEIGNANTRESPONSABLE) violated
*/

-- Question 5 : 
-- a)
ALTER TABLE Cours ADD CONSTRAINT ck_volumeH CHECK (volumeH > 0);
/*
L'avantage d'ajouter via cette commande au lieu de changer le script de 
création est qu'on a pas besoins de supprimer les tables pour re-exécuter
mais on peut les modifiers directement
*/

-- b)
INSERT INTO Cours VALUES ('test', 3, 'PHAM', -2);
/*
Rapport d'erreur -
ORA-02290: check constraint (MGOUELO.CK_VOLUMEH) violated
*/

-- c)
ALTER TABLE Cours DROP CONSTRAINT ck_volumeH;


-- Question 6 :
ALTER TABLE Enseignant ADD salaire NUMBER;
ALTER TABLE Enseignant DROP COLUMN salaire;

-- Question 7 :
UPDATE Enseignant SET prenomEns = 'Maria' WHERE nomEns = 'ZOUZOUA';
DELETE FROM Cours WHERE nomCours = 'Init Dev Web';