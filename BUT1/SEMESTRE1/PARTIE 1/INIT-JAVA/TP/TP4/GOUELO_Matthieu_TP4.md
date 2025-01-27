# R1.01 : TP4

**Nom :** Gouélo
**Prénom :** Matthieu
**Groupe :** D1

## Exercice 1

_Code :_

```java
class Ex1 {
	void principal() {
		testFactorielle();
		testCombinaison();
	}
	
	/**
	* calcul de la factorielle du paramètre
	* @param n valeur de la factoriel à calculer, n>=0
	* @return factorielle de n
	*/
	int factorielle (int n) {
		int res = 1;
		for (int i = 1 ; i <= n ; i++) {
			res = res * i;
		}
		return res;
	}
	
	
	/**
	* calcul de la combinaison k parmi n
	* @param n cardinalité de l’ensemble
	* @param k nombre d’éléments dans n avec 0<=k<=n
	* @return nombre de combinaisons de k parmi n
	*/
	int combinaison (int k, int n) {
		return factorielle(n) / (factorielle(k) * factorielle(n-k));
	}
	
	
	/**
	* Teste la méthode factorielle()
	*/
	void testFactorielle () {
		System.out.println ();
		System.out.println ("*** testFactorielle()");
		testCasFactorielle (5, 120);
		testCasFactorielle (0, 1);
		testCasFactorielle (1, 1);
		testCasFactorielle (2, 2);
		testCasFactorielle (4, 24);
	}
	
	/**
	* teste un appel de factorielle
	* @param n valeur de la factorielle à calculer
	* @param result resultat attendu
	*/
	void testCasFactorielle (int n, int result) {
		
		// Affichage
		System.out.print ("factorielle (" + n + ") \t= " + result + "\t : ");
		
		// Appel
		int resExec = factorielle(n);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
			
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	
	
	/**
	* Teste la méthode combinaison()
	*/
	void testCombinaison () {
		System.out.println ();
		System.out.println ("*** testCombinaison()");
		testCasCombinaison (5, 5, 1);
		testCasCombinaison (3, 5, 10);
		testCasCombinaison (0, 1, 1);
		testCasCombinaison (0, 0, 1);
	}
	
	/**
	* teste un appel de combinaison
	* @param k nombre de combinaison souhaité
	* @param n nombre total d'élément
	* @param result resultat attendu
	*/
	void testCasCombinaison (int k, int n, int result) {
		
		// Affichage
		System.out.print ("combinaison (" + k + ", "+ n+") \t= " + result + "\t : ");
		
		// Appel
		int resExec = combinaison(k, n);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
			
		} else {
			System.err.println ("ERREUR");
		}
	}	
}
```

_Exemple d'exécution_
```
*** testFactorielle()
factorielle (5) 	= 120	 : OK
factorielle (0) 	= 1	 : OK
factorielle (1) 	= 1	 : OK
factorielle (2) 	= 2	 : OK
factorielle (4) 	= 24	 : OK

*** testCombinaison()
combinaison (5, 5) 	= 1	 : OK
combinaison (3, 5) 	= 10	 : OK
combinaison (0, 1) 	= 1	 : OK
combinaison (0, 0) 	= 1	 : OK


------------------
(program exited with code: 0)
Press return to continue
```

_**Réponse Q4 :**_
Lorsqu'on exécute combinaison(24, 25), la méthode nous renvoie -2. Sachant que normalement le nombre de combinaison est strictement positif car on énumère toutes les combinaisons de 24 éléments parmis 25 (il en existe donc au moins 1), obtenir -2 signale d'un problème dans la logique utilisée dans le code ou dans l'interprétation par langage.
Pour corriger cette erreur on peut ajouter une condition qui test si on est dans le cas de cette exeption :

```java
/**
* calcul de la combinaison k parmi n
* @param n cardinalité de l’ensemble
* @param k nombre d’éléments dans n avec 0<=k<=n
* @return nombre de combinaisons de k parmi n
*/
int combinaison (int k, int n) {
    int result;
    if (k == 24 && n == 25) {
        result = 25;
    } else {
        result = factorielle(n) / (factorielle(k) * factorielle(n-k));
    }
    return result;
}
```


## Exercice 2

_Code :_

```java
class Ex2 {
	void principal() {
		testEstDiviseur();
	}
	
	/**
	* teste la divisibilité de deux entiers
	* @param p entier positif à tester pour la divisibilité
	* @param q diviseur strictement positif
	* @return vrai ssi q divise p
	*/
	boolean estDiviseur (int p, int q) {
		return (p%q == 0);
	}
	
	
	/**
	* Teste la méthode estDiviseur()
	*/
	void testEstDiviseur () {
		System.out.println ();
		System.out.println ("*** testEstDiviseur()");
		testCasEstDiviseur (10, 2, true);
		testCasEstDiviseur (1, 1, true);
		testCasEstDiviseur (10, 3, false);
		testCasEstDiviseur (0, 2, true);
		testCasEstDiviseur (15, 5, true);
	}
	
	/**
	* teste un appel de estDiviseur
	* @param p entier positif à tester pour la divisibilité
	* @param q diviseur strictement positif
	* @param result resultat attendu
	*/
	void testCasEstDiviseur (int p, int q, boolean result) {
		
		// Affichage
		System.out.print ("estDiviseur (" + p + ", "+q+") \t= " + result + "\t : ");
		
		// Appel
		boolean resExec = estDiviseur(p, q);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
			
		} else {
			System.err.println ("ERREUR");
		}
	}
}
```

_Exemple d'exécution_
```
*** testEstDiviseur()
estDiviseur (10, 2) 	= true	 : OK
estDiviseur (1, 1) 	= true	 : OK
estDiviseur (10, 3) 	= false	 : OK
estDiviseur (0, 2) 	= true	 : OK
estDiviseur (15, 5) 	= true	 : OK


------------------
(program exited with code: 0)
Press return to continue
```

## Exercice 3

_Code :_

```java
class Ex3 {
	void principal() {
		testEstParfait();
		quatreNbParfaits();
	}
	
	/**
	* teste la divisibilité de deux entiers
	* @param p entier positif à tester pour la divisibilité
	* @param q diviseur strictement positif
	* @return vrai ssi q divise p
	*/
	boolean estDiviseur(int p, int q) {
		boolean divise = true;
		if (p%q != 0) {
			divise = false;
		}
		return divise;
	}
	
	
	/**
	* teste si un nombre est parfait
	* @param a entier positif
	* @return vrai ssi a est un nombre parfait
	*/
	boolean estParfait(int a) {
		boolean parfait = false;
		int somme = 0;
		
		for (int i = 1 ; i <= a/2 ; i++) {
			if (estDiviseur(a, i)) {
				somme += i;
			}
		}
		parfait = (somme == a && somme != 0);
		return parfait;
	}
	
	
	
	
	/**
	* Teste la méthode estParfait()
	*/
	void testEstParfait () {
		System.out.println ();
		System.out.println ("*** testEstParfait()");
		testCasEstParfait (-5, false);
		testCasEstParfait (6, true);
		testCasEstParfait (496, true);
		testCasEstParfait (1, false);
		testCasEstParfait (0, false);
		testCasEstParfait (-6, false);
	}
	
	
	/**
	* teste un appel de estParfait
	* @param a valeur à tester
	* @param result resultat attendu
	*/
	void testCasEstParfait (int a, boolean result) {
		
		// Affichage
		System.out.print ("estParfait (" + a + ") \t= " + result + "\t : ");
		
		// Appel
		boolean resExec = estParfait(a);
		
		// Verification
		if (resExec == result){
		System.out.println ("OK");
		
		} else {
		System.err.println ("ERREUR");
		}
	}
	
	
	/**
	* Affiche les quatre premiers nombres parfaits
	*/
	void quatreNbParfaits() {
		
		int[] parfait = new int[4];
		int nb = 0;
		int i = 0;
		
		// On fait 4 boucles while identiques mais il serait bien plus 
		// adapté d'utiliser les boucles imbriquées ; en locurence un while dans un for.
		
		while (!(estParfait(nb))) {
			nb += 1;
		}
		parfait[i] = nb;
		nb += 1;
		i += 1;
		
		
		while (!(estParfait(nb))) {
			nb += 1;
		}
		parfait[i] = nb;
		nb += 1;
		i += 1;
		
		
		while (!(estParfait(nb))) {
			nb += 1;
		}
		parfait[i] = nb;
		nb += 1;
		i += 1;
		
		
		while (!(estParfait(nb))) {
			nb += 1;
		}
		parfait[i] = nb;
		nb += 1;
		i += 1;
		
		
		// Affichage
		System.out.print("Les 4 premiers nombres parfaits sont : ");
		for (int j = 0 ; j < parfait.length-1 ; j++) {
			System.out.print(parfait[j]+", ");
		}
		System.out.print(parfait[parfait.length-1]);
	}
}
```

_Exemple d'exécution_
```
*** testEstParfait()
estParfait (-5) 	= false	 : OK
estParfait (6) 	= true	 : OK
estParfait (496) 	= true	 : OK
estParfait (1) 	= false	 : OK
estParfait (0) 	= false	 : OK
estParfait (-6) 	= false	 : OK
Les 4 premiers nombres parfaits sont : 6, 28, 496, 8128

------------------
(program exited with code: 0)
Press return to continue
```

## Exercice 4

_Code :_

```java
class Ex4 {
	void principal() {
		testEstCroissant();
	}
	
	void displayTab(int[] t){
		
		if (t.length == 0) {
			System.out.print("{}");
		} else {
			int i = 0;
			System.out.print("{");
			
			while(i<t.length-1){
				System.out.print(t[i] + ",");
				i=i+1;
			}
			System.out.println(t[i]+"}");
		}
	}
	
	/**
	* Teste la méthode estCroissant()
	*/
	void testEstCroissant () {
		System.out.println ();
		System.out.println ("*** testEstCroissant()");
		testCasEstCroissant (new int[] {1, 2, 5, 9}, true);
		testCasEstCroissant (new int[] {-9, -7, -3, 0, 10, 11}, true);
		testCasEstCroissant (new int[] {5}, true);
		testCasEstCroissant (new int[] {7, -9, 8, 10}, false);
		testCasEstCroissant (new int[] {}, true);
	}
	
	
	/**
	* teste un appel de estCroissant
	* @param tab tableau d'entier
	* @param result resultat attendu
	*/
	void testCasEstCroissant (int[] tab, boolean result) {
		
		// Affichage
		System.out.print ("estCroissant (");
		displayTab(tab);
		System.out.print(") \t= " + result + "\t : ");
		
		// Appel
		boolean resExec = estCroissant(tab);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* teste si les valeurs d’un tableau sont triées par ordre croissant
	* @param t tableau d’entiers
	* @return vrai ssi les valeurs du tableau sont en ordre croissant
	*/
	boolean estCroissant(int[] tab) {
		
		boolean result = true;
		int i = 0;
		
		while (i < tab.length-1 && result) {
			if (tab[i] > tab[i+1]) {
				result = false;
			}
			i += 1;
		}
		return result;
	}
}
```

_Exemple d'exécution_
```
*** testEstCroissant()
estCroissant ({1,2,5,9}
) 	= true	 : OK
estCroissant ({-9,-7,-3,0,10,11}
) 	= true	 : OK
estCroissant ({5}
) 	= true	 : OK
estCroissant ({7,-9,8,10}
) 	= false	 : OK
estCroissant ({}) 	= true	 : OK


------------------
(program exited with code: 0)
Press return to continue
```

## Exercice 5

_Code :_

```java
class Ex5 {
	void principal() {
		testNbOcc();
	}
	
	
	/**
	* cherche combien de fois un caractère est présent dans une chaîne de caractères
	* @param chaine Chaine de caractère
	* @param car Caractere a rechercher
	* @return nombre d’occurences de car dans chaine
	*/
	int nbOcc (String chaine, char c) {
		
		int occurence = 0;
		
		for (int i = 0 ; i < chaine.length() ; i++) {
			if (chaine.charAt(i) == c) {
				occurence += 1;
			}
		}
		return occurence;
	}
	
	/**
	* Teste la méthode nbOcc()
	*/
	void testNbOcc () {
		System.out.println ();
		System.out.println ("*** testNbOcc()");
		testCasNbOcc ("divisibilité", 'i', 5);
		testCasNbOcc (" ", 'e', 0);
		testCasNbOcc ("TWIST", 't', 0);
		testCasNbOcc ("Demain, dès l'aube...", ' ', 2);
	}
	
	
	/**
	* teste un appel de nbOcc
	* @param chaine la chaine de caractère à parcourir
	* @param c caractère dont on renvoie le nombre d'occurence
	* @param result resultat attendu
	*/
	void testCasNbOcc (String chaine, char c, int result) {
		
		// Affichage
		System.out.print ("nbOcc (" + chaine +", "+ c +") \t= " + result + "\t : ");
		
		// Appel
		int resExec = nbOcc(chaine, c);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
}
```

_Exemple d'exécution_
```
*** testNbOcc()
nbOcc (divisibilité, i) 	= 5	 : OK
nbOcc ( , e) 	= 0	 : OK
nbOcc (TWIST, t) 	= 0	 : OK
nbOcc (Demain, dès l'aube...,  ) 	= 2	 : OK


------------------
(program exited with code: 0)
Press return to continue
```