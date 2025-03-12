# R1.01 : TP2

**Nom :** Gouélo
**Prénom :** Matthieu
**Groupe :** 1D1

## Exercice 1

_Code :_

```java
/**
 * Demande un nombre à l'utilisateur jusqu'a l'entrée de -1
 * @author mgouelo
 */


class Ex1 {
	void principal() {
	
		System.out.println("Pour arrêter le programme tapez : -1");
		int nb = SimpleInput.getInt("Donner un nombre : ");
		
		while (nb != -1) {
			System.out.println(nb);
			nb = SimpleInput.getInt("Donner un nombre : ");
		}
		
		System.out.println("-1 n'est pas une valeur");
	}
}



/**
 * Version avec do while
 */
 

class Ex1 {
	void principal() {
		
		System.out.println("Pour arrêter le programme tapez : -1");
		int nb;
		
		do {
			nb = SimpleInput.getInt("Donner un nombre : ");
			if (nb == -1) {
				System.out.println("-1 n'est pas une valeur");
			} else {
				System.out.println(nb);
			}
			
		} while (nb != -1);
	}
}


/**
 * Demande un nombre à l'utilisateur jusqu'a l'entrée de -1 et renvoie la moyenne des nombres rentrés -1 exclus
 * @author mgouelo
 */


class Ex1 {
	void principal() {
		
		System.out.println("Pour arrêter le programme tapez : -1");
		int nb = SimpleInput.getInt("Donner un nombre : ");
		int affichage = 0;
		int total = 0;
		double moy;
		
		while (nb != -1) {
			System.out.println(nb);
			affichage += 1;
			total += nb;
			nb = SimpleInput.getInt("Donner un nombre : ");
		}
		
		System.out.println("-1 n'est pas une valeur");
		if (affichage > 0) {
			moy = (double)total/affichage;
			System.out.println("La moyenne des nombres rentrés : "+ moy);
		}
	}
}
```

_Exemple d'exécution_
- Version while :
```
Donner un nombre : 8
8
Donner un nombre : 42
42
Donner un nombre : 3
3
Donner un nombre : -8
-8
Donner un nombre : -1
-1 n'est pas une valeur


------------------
(program exited with code: 0)
Press return to continue
```

- Version do-while :
```
Donner un nombre : 66
66
Donner un nombre : -88
-88
Donner un nombre : -42
-42
Donner un nombre : 42
42
Donner un nombre : -1
-1 n'est pas une valeur


------------------
(program exited with code: 0)
Press return to continue
```

- Version while avec moyenne :
```
Pour arrêter le programme tapez : -1
Donner un nombre : -1
-1 n'est pas une valeur


------------------
(program exited with code: 0)
Press return to continue
```

```
Pour arrêter le programme tapez : -1
Donner un nombre : 10
10
Donner un nombre : 15
15
Donner un nombre : -1
-1 n'est pas une valeur
La moyenne des nombres rentrés : 12.5


------------------
(program exited with code: 0)
Press return to continue
```

```
Pour arrêter le programme tapez : -1
Donner un nombre : 10
10
Donner un nombre : 10
10
Donner un nombre : 20
20
Donner un nombre : 20
20
Donner un nombre : -1
-1 n'est pas une valeur
La moyenne des nombres rentrés : 15.0


------------------
(program exited with code: 0)
Press return to continue
```

## Exercice 2

_Code :_

```java
/**
* Le programme retourne le PGCD des 2 nombres entrés par l'utilisateur
* @author M.Adam
*/

class Ex2 {
	void principal() {
		
		int val1;
		int val2;
		
		val1 = SimpleInput.getInt ("Première valeur : ");
		val2 = SimpleInput.getInt ("Deuxième valeur : ");
		
		while (val1 != val2) {
			if (val1 > val2) {
				val1 = val1 - val2;
				
			} else {
			val2 = val2 - val1;
			}
		}
		System.out.println("Le résultat est : " + val1);
	}
}



/**
* Calcul le PGCD entre val1 et val2 version while corrigée
* @author M.Adam
*/

class Ex2 {
	void principal() {
		
		int val1;
		int val2;
		
		val1 = SimpleInput.getInt ("Première valeur : ");
		val2 = SimpleInput.getInt ("Deuxième valeur : ");
		
		while (val1 < 0 || val2 < 0) {
			System.out.println("Erreur, les nombres saisis doivent être strictement positif");
			val1 = SimpleInput.getInt ("Première valeur : ");
			val2 = SimpleInput.getInt ("Deuxième valeur : ");
		}
		
		while (val1 != val2) {
			if (val1 > val2) {
				val1 = val1 - val2;
				
			} else {
				val2 = val2 - val1;
			}
		}
		
		System.out.println("Le PGCD est " + val1);
	}
}


/**
* Calcul le PGCD entre val1 et val2 version do-while
* @author M.Adam
*/

class Ex2 {
	void principal() {
		
		int val1;
		int val2;
		
		do {
			val1 = SimpleInput.getInt ("Première valeur : ");
			val2 = SimpleInput.getInt ("Deuxième valeur : ");
			if (val1 < 0 || val2 < 0) {
				System.out.println("Erreur, les nombres saisis doivent être strictement positif");
			}
			
		} while (val1 < 0 || val2 < 0);
			
		do {
			if (val1 > val2) {
				val1 = val1 - val2;
				
			} else {
				val2 = val2 - val1;
			}
		} while (val1 != val2);
		
		
		System.out.println("Le PGCD est " + val1);
	}
}
```

_Exemples d'exécutions_
- Version while de base :
```
Première valeur : -1
Deuxième valeur : 6


```

```
Première valeur : 29 
Deuxième valeur : 3
Le résultat est : 1


------------------
(program exited with code: 0)
Press return to continue
```

```
Première valeur : -88
Deuxième valeur : -55


```

```
Première valeur : 35
Deuxième valeur : 77
Le résultat est : 7


------------------
(program exited with code: 0)
Press return to continue
```

**Rôle du programme :** Ce programme permet de calculer le PGCD entre 2 nombres entrés par l'utilisateur.

- Version while corrigée :
```
Première valeur : 56
Deuxième valeur : 25
Le PGCD est 1


------------------
(program exited with code: 0)
Press return to continue
```

```
Première valeur : -8
Deuxième valeur : 26
Erreur, les nombres saisis doivent être strictement positif
Première valeur : -8
Deuxième valeur : -26
Erreur, les nombres saisis doivent être strictement positif
Première valeur : 44
Deuxième valeur : 69
Le PGCD est 1


------------------
(program exited with code: 0)
Press return to continue
```

- Version do-while :

```
Première valeur : 104
Deuxième valeur : 28
Le PGCD est 4


------------------
(program exited with code: 0)
Press return to continue
```

```
Première valeur : -8
Deuxième valeur : 26
Erreur, les nombres saisis doivent être strictement positif
Première valeur : -8
Deuxième valeur : -26
Erreur, les nombres saisis doivent être strictement positif
Première valeur : 44
Deuxième valeur : 69
Le PGCD est 1


------------------
(program exited with code: 0)
Press return to continue
```
## Exercice 3

_Code :_

```java
/**
 * Demande un nombre à l'utilisateur tant que le nombre précédent est inferieur au nouveau
 * @author
 */

class Ex3 {
	void principal() {
		
		int oldNb = SimpleInput.getInt("Donner une valeur : ");
		int nb = SimpleInput.getInt("Donner une nouvelle valeur : ");
		
		while (oldNb < nb) {
			oldNb = nb;
			nb = SimpleInput.getInt("Donner une nouvelle valeur : ");
		}
		
		System.out.println("La valeur précédente "+ oldNb +" est superieur à la nouvelle valeur "+ nb);
	}
}
```

_Exemples d'exécutions_
```
Donner une valeur : 10
Donner une nouvelle valeur : 9
La valeur précédente 10 est superieur à la nouvelle valeur 9


------------------
(program exited with code: 0)
Press return to continue
```

```
Donner une valeur : -99
Donner une nouvelle valeur : -66
Donner une nouvelle valeur : -3
Donner une nouvelle valeur : 0
Donner une nouvelle valeur : 54
Donner une nouvelle valeur : 2
La valeur précédente 54 est superieur à la nouvelle valeur 2


------------------
(program exited with code: 0)
Press return to continue
```

## Exercice 4

_Code :_

```java
/**
 * Simule un distributeur automatique qui demande de payer un prix fixer par l'utilisateur
 * et rend la monnaie si nécessaire
 * @author
 */

class Ex4 {
    void principal() {
        
        int prix = SimpleInput.getInt("Bienvenue, entrez le prix que vous souhaitez payer : ");
        int montant = SimpleInput.getInt("Entrez le montant que vous voulez payer : ");
        
        while (montant < prix) {
            System.out.println("Vous avez payé " + montant + "€ sur les " + prix +
            "€ au total. Il vous reste donc " + (prix - montant) + "€ à régler.");
            montant += SimpleInput.getInt("Entrez le montant que vous voulez payer : ");
        }
        
        if (montant == prix) {
            System.out.println("Produit acheté. Pas de rendu de monnaie nécessaire.");
        } else {
            while (montant > prix) {
                if (montant - 50 >= prix) {
                    montant -= 50;
                    System.out.println("Rendu : 50€");
                } else if (montant - 20 >= prix) {
                    montant -= 20;
                    System.out.println("Rendu : 20€");
                } else if (montant - 10 >= prix) {
                    montant -= 10;
                    System.out.println("Rendu : 10€");
                } else if (montant - 5 >= prix) {
                    montant -= 5;
                    System.out.println("Rendu : 5€");
                } else if (montant - 2 >= prix) {
                    montant -= 2;
                    System.out.println("Rendu : 2€");
                } else {
                    montant -= 1;
                    System.out.println("Rendu : 1€");
                }
            }
            System.out.println("Produit acheté. La monnaie a été rendue.");
        }
    }
}
```

_Exemples d'exécutions_
```
Bienvenue, entrez le prix que vous souhaitez payer : 17
Entrez le montant que vous voulez payer : 62
Rendu : 20€
Rendu : 20€
Rendu : 5€
Produit acheté. La monnaie a été rendue.


------------------
(program exited with code: 0)
Press return to continue
```

```
Bienvenue, entrez le prix que vous souhaitez payer : 26
Entrez le montant que vous voulez payer : 10
Vous avez payé 10€ sur les 26€ au total. Il vous reste donc 16€ à régler.
Entrez le montant que vous voulez payer : 10
Vous avez payé 20€ sur les 26€ au total. Il vous reste donc 6€ à régler.
Entrez le montant que vous voulez payer : 5
Vous avez payé 25€ sur les 26€ au total. Il vous reste donc 1€ à régler.
Entrez le montant que vous voulez payer : 5
Rendu : 2€
Rendu : 2€
Produit acheté. La monnaie a été rendue.


------------------
(program exited with code: 0)
Press return to continue
```

```
Bienvenue, entrez le prix que vous souhaitez payer : 15
Entrez le montant que vous voulez payer : 7
Vous avez payé 7€ sur les 15€ au total. Il vous reste donc 8€ à régler.
Entrez le montant que vous voulez payer : 5
Vous avez payé 12€ sur les 15€ au total. Il vous reste donc 3€ à régler.
Entrez le montant que vous voulez payer : 3
Produit acheté. Pas de rendu de monnaie nécessaire.


------------------
(program exited with code: 0)
Press return to continue
```


## Exercice 5

_Code :_

```java
/**
 * L'utilisateur doit deviner le nombre "choisi" par l'ordinateur.
 * @author
 */

class Ex5 {
	void principal() {
		
		int nbChoisi = (int) (Math.random() * 100);
		int nbEntre;
		
		System.out.println("Je choisi un nombre entre 0 et 99... Essayez de le deviner!");
		
		do {
			nbEntre = SimpleInput.getInt("Entrez un nombre : ");
			if (nbEntre > nbChoisi) {
				System.out.println("Trop grand !");
			} else if (nbEntre < nbChoisi) {
				System.out.println("Trop petit !");
			}
		} while (nbEntre != nbChoisi);
		
		System.out.println("Bingo !");
	}
}
```

_Exemples d'exécutions_
```
Je choisi un nombre entre 0 et 99... Essayez de le deviner!
Entrez un nombre : 50
Trop petit !
Entrez un nombre : 75
Trop petit !
Entrez un nombre : 85
Trop grand !
Entrez un nombre : 80
Bingo !


------------------
(program exited with code: 0)
Press return to continue
```

```
Je choisi un nombre entre 0 et 99... Essayez de le deviner!
Entrez un nombre : 50
Trop grand !
Entrez un nombre : 25
Trop grand !
Entrez un nombre : 15
Trop grand !
Entrez un nombre : 10
Trop grand !
Entrez un nombre : 5
Trop grand !
Entrez un nombre : 1
Trop petit !
Entrez un nombre : 3
Trop petit !
Entrez un nombre : 4
Bingo !


------------------
(program exited with code: 0)
Press return to continue
```


## Exercice 6 

_Code :_

```java
/**
 * Le programme devine le nombre choisi par l'utilisateur entre 0 et 1000
 * @author
 */

class Ex6 {
	void principal() {
		
		int nbPropose = (int)(Math.random()*1001);
		char reponseUtilisateur;
		int borneD = 1000;
		int borneG = 0;
		int essais = 0;
		
		System.out.println("Pensez à un nombre entre 0 et 1000...");
		
		do {
			reponseUtilisateur = SimpleInput.getChar("Votre est nombre est-il "
			+ nbPropose +" ?");
			essais += 1;
			
			if (reponseUtilisateur == '+') {
				borneG = nbPropose;
				nbPropose = (int)(Math.random()*(borneD-borneG)) + borneG;
				
			} else if (reponseUtilisateur == '-') {
				borneD = nbPropose;
				nbPropose = (int)(Math.random()*(borneD-borneG)) + borneG;
			}
		} while (reponseUtilisateur != '=');
		
		System.out.println("Le nombre était donc "+ nbPropose +". Je l'ai trouvé en "+
		essais +" essais.");
	}
}


/**
 * Le programme devine le nombre choisi par l'utilisateur entre 0 et 1000 et déduit 
 * le nombre choisi lorsque
 * @author
 */


class Ex6 {
	void principal() {
		
		int nbPropose = (int)(Math.random()*1001);
		char reponseUtilisateur;
		int borneD = 1000;
		int borneG = 0;
		int essais = 0;
		
		System.out.println("Pensez à un nombre entre 0 et 1000...");
		
		do {
			reponseUtilisateur = SimpleInput.getChar("Votre est nombre est-il "
			+ nbPropose +" ?");
			essais += 1;
			
			if (borneD - borneG == 2) {
				nbPropose = borneD - 1;
			}
			
			else if (reponseUtilisateur == '+') {
				borneG = nbPropose;
				nbPropose = (int)(Math.random()*(borneD-borneG)) + borneG;
				
			} else if (reponseUtilisateur == '-') {
				borneD = nbPropose;
				nbPropose = (int)(Math.random()*(borneD-borneG)) + borneG;
			}

		} while (reponseUtilisateur != '=');
		
		System.out.println("Le nombre était donc "+ nbPropose +". Je l'ai trouvé en "+
		essais +" essais.");
	}
}
```

_Exemples d'exécutions_

```
Pensez à un nombre entre 0 et 1000...
Votre est nombre est-il 77 ?+
Votre est nombre est-il 970 ?-
Votre est nombre est-il 926 ?-
Votre est nombre est-il 784 ?-
Votre est nombre est-il 320 ?+
Votre est nombre est-il 704 ?+
Votre est nombre est-il 779 ?-
Votre est nombre est-il 777 ?-
Votre est nombre est-il 753 ?-
Votre est nombre est-il 708 ?+
Votre est nombre est-il 720 ?-
Votre est nombre est-il 715 ?-
Votre est nombre est-il 709 ?=
Le nombre était donc 709. Je l'ai trouvé en 13 essais.


------------------
(program exited with code: 0)
Press return to continue
```

```
Pensez à un nombre entre 0 et 1000...
Votre est nombre est-il 376 ?+
Votre est nombre est-il 452 ?+
Votre est nombre est-il 683 ?+
Votre est nombre est-il 881 ?+
Votre est nombre est-il 980 ?+
Votre est nombre est-il 994 ?+
Votre est nombre est-il 999 ?=
Le nombre était donc 999. Je l'ai trouvé en 7 essais.


------------------
(program exited with code: 0)
Press return to continue
```

```
Pensez à un nombre entre 0 et 1000...
Votre est nombre est-il 501 ?-
Votre est nombre est-il 451 ?-
Votre est nombre est-il 115 ?-
Votre est nombre est-il 110 ?-
Votre est nombre est-il 85 ?-
Votre est nombre est-il 55 ?-
Votre est nombre est-il 34 ?+
Votre est nombre est-il 44 ?-
Votre est nombre est-il 34 ?+
Votre est nombre est-il 35 ?+
Votre est nombre est-il 37 ?+
Votre est nombre est-il 38 ?+
Votre est nombre est-il 41 ?+
Votre est nombre est-il 41 ?+
Votre est nombre est-il 41 ?+
Votre est nombre est-il 41 ?+
Votre est nombre est-il 41 ?+
Votre est nombre est-il 43 ?-
Votre est nombre est-il 41 ?+
Votre est nombre est-il 41 ?+
Votre est nombre est-il 41 ?+
Votre est nombre est-il 41 ?+
Votre est nombre est-il 42 ?=
Le nombre était donc 42. Je l'ai trouvé en 23 essais.


------------------
(program exited with code: 0)
Press return to continue
```

- Avec la correction du programme (Q2 exercice 6) :
```
Pensez à un nombre entre 0 et 1000...
Votre est nombre est-il 617 ?-
Votre est nombre est-il 615 ?-
Votre est nombre est-il 293 ?-
Votre est nombre est-il 262 ?-
Votre est nombre est-il 17 ?+
Votre est nombre est-il 26 ?+
Votre est nombre est-il 242 ?-
Votre est nombre est-il 122 ?-
Votre est nombre est-il 111 ?-
Votre est nombre est-il 55 ?-
Votre est nombre est-il 38 ?+
Votre est nombre est-il 38 ?+
Votre est nombre est-il 54 ?-
Votre est nombre est-il 45 ?-
Votre est nombre est-il 39 ?+
Votre est nombre est-il 39 ?+
Votre est nombre est-il 43 ?-
Votre est nombre est-il 41 ?+
Votre est nombre est-il 42 ?=
Le nombre était donc 42. Je l'ai trouvé en 19 essais.


------------------
(program exited with code: 0)
Press return to continue
```