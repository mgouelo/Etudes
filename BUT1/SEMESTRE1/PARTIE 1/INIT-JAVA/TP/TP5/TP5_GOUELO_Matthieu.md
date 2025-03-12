# R1.01 : TP5

**Nom :** Gouélo
**Prénom :** Matthieu
**Groupe :** D1

## Exercice 1

_Code :_

```java
class Ex1 {
	void principal() {
		testSontTousDiff();
	}
	
	/**
	* vérifie si deux tableaux n’ont aucune valeur commune
	* @param tab1 premier tableau
	* @param tab2 deuxième tableau
	* @return vrai si les tableaux tab1 et tab2 n’ont aucune valeur commune, faux sinon
	*/
	boolean sontTousDiff (int[] tab1, int[] tab2) {
		boolean different = true;
		for (int i = 0 ; i < tab1.length ; i++) {
			for (int j = 0 ; j < tab2.length ; j++) {
				if (tab1[i] == tab2[j]) {
					different = false;
				}
			}
		}
		return different;
	}
	
	
	/**
	* Teste la méthode sontTousDiff()
	*/
	void testSontTousDiff () {
		System.out.println ();
		System.out.println ("*** testSontTousDiff()");
		testCasSontTousDiff  (new int[] {0, 1, 2, 5, 3, 3}, new int[] {-1, 6, 8}, true);
		testCasSontTousDiff  (new int[] {0, 1, 2, 5, 3, 3}, new int[] {3}, false);
		testCasSontTousDiff  (new int[] {3}, new int[] {-1}, true);
		testCasSontTousDiff  (new int[] {}, new int[] {}, true);
		testCasSontTousDiff  (new int[] {0, 1, 2, 5, 3, 3}, new int[] {-1, 6, 8}, true);
	}
	
	/**
	* teste un appel de sontTousDiff
	* @param tab1 premier tableau à comparer 
	* @param tab2 deuxième tableau à comparer
	* @param result resultat attendu
	*/
	void testCasSontTousDiff (int[] tab1, int[] tab2, boolean result) {
		
		// Affichage
		System.out.print ("sontTousDiff (" );
		displayTab(tab1);
		System.out.print(", ");
		displayTab(tab2);
		System.out.print(") \t= " + result + "\t : ");
		
		// Appel
		boolean resExec = sontTousDiff(tab1, tab2);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
			
		} else {
			System.err.println ("ERREUR");
		}
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
			System.out.print(t[i]+"}");
		}
	}
}
```

_Exemple d'exécution_
```
*** testSontTousDiff()
sontTousDiff ({0,1,2,5,3,3}, {-1,6,8}) 	= true	 : OK
sontTousDiff ({0,1,2,5,3,3}, {3}) 	= false	 : OK
sontTousDiff ({3}, {-1}) 	= true	 : OK
sontTousDiff ({}, {}) 	= true	 : OK
sontTousDiff ({0,1,2,5,3,3}, {-1,6,8}) 	= true	 : OK
```


## Exercice 2

_Code :_

```java
class Ex2 {
	void principal() {
		int [] tab = {3, 10, 6, 20, 7};
		System.out.print("Avant décalage : ");
		displayTab(tab);
		System.out.println();
		System.out.print("Après décalage : ");
		decalerGauche(tab);
		displayTab(tab);
		System.out.println();
		System.out.println();
		
		
		int [] tab2 = {3, 10, 6, 20, 7};
		int [] tab21 = {3};
		System.out.print("Avant n décalage : ");
		displayTab(tab2);
		displayTab(tab21);
		System.out.println();
		System.out.print("Après n décalage : ");
		decalerGaucheN(tab2, 3);
		displayTab(tab2);
		decalerGaucheN(tab21, 3);
		displayTab(tab21);
		System.out.println();
		System.out.println();
		
		
		int [] tab3 = {3, 10, 6, 20, 7};
		int [] tab31 = {3, 10, -6, 20, 7};
		int valeur = 6;
		System.out.println("On cherche la valeur "+valeur);
		int indice = indiceTab(tab3, valeur);
		int indice2 = indiceTab(tab31, valeur);
		System.out.print("indiceTab(new int[] = ");
		displayTab(tab3);
		System.out.print(", "+valeur+") nous retourne : "+indice);
		System.out.println();
		System.out.print("indiceTab(new int[] = ");
		displayTab(tab31);
		System.out.print(", "+valeur+") nous retourne : "+indice2);
		System.out.println();
		System.out.println();
		
		
		
		int [] tab4 = {3, 10, 6, 20, 7};
		System.out.print("Avant application de decaleValeur() : tab = ");
		displayTab(tab4);
		int val = 20;
		System.out.println();
		System.out.println("On choisi la valeur "+ val +".Après application de decalValeur() : ");
		decaleValeur(tab4, val);
		System.out.print("tab = ");
		displayTab(tab4);
		System.out.println();
		System.out.println();
		
	}
	
	/**
	* décale les entiers d’un tableau d’une position vers la gauche
	* L’élément en 0 se retrouve à la fin du tableau
	* @param tab tableau d’entiers
	*/
	void decalerGauche (int[] tab) {
		int temp = tab[0];
		for (int i = 1 ; i < tab.length ; i++) {
			tab[i-1] = tab[i];
		}
		tab[tab.length-1] = temp;
	}
	
	
	/**
	* décale les entiers d’un tableau de n positions vers la gauche
	* @param tab tableau d’entiers
	* @param n entier nombre de cases à décaler
	*/
	void decalerGaucheN (int[] tab, int n) {
		for (int i = 1 ; i <= n ; i++){
			decalerGauche(tab);
		}
	}
	
	
	/**
	* cherche l’indice de la premiere occurrence d’une valeur dans un tableau
	* @param tab tableau d’entiers
	* @param v valeur à chercher
	* @return l’indice de la première valeur v dans tab si v est dans tab, -1 sinon
	*/
	int indiceTab (int[] tab, int v) {
		int indice = -1;
		for (int i = 0 ; i < tab.length ; i++){
			if (tab[i] == v && indice == -1) {
				indice = i;
			}
		}
		return indice;
	}
	
	
	/**
	* décale les valeurs d’un tableau de manière à ramener la valeur cherchée
	* à l’indice 0
	* Si la valeur n’est pas présente, le tableau n’est pas modifié
	* @param tab tableau d’entiers
	* @param v valeur à chercher
	*/
	void decaleValeur (int[] tab, int v) {
		if (indiceTab(tab, v) != -1) {
			int n = indiceTab(tab, v);
			for (int i = 1 ; i <= n ; i++) {
				decalerGaucheN(tab, n);
			}
		}
	}
	
	
	void displayTab(int[] t) {
		
		if (t.length == 0) {
			System.out.print("{}");
		} else {
			int i = 0;
			System.out.print("{");
			
			while(i<t.length-1){
				System.out.print(t[i] + ",");
				i=i+1;
			}
			System.out.print(t[i]+"}");
		}
	}
}
```

_Exemple d'exécution_
```
Avant décalage : {3,10,6,20,7}
Après décalage : {10,6,20,7,3}

Avant n décalage : {3,10,6,20,7}{3}
Après n décalage : {20,7,3,10,6}{3}

On cherche la valeur 6
indiceTab(new int[] = {3,10,6,20,7}, 6) nous retourne : 2
indiceTab(new int[] = {3,10,-6,20,7}, 6) nous retourne : -1

Avant application de decaleValeur() : tab = {3,10,6,20,7}
On choisi la valeur 20.Après application de decalValeur() : 
tab = {7,3,10,6,20}
```

## Exercice 3

_Code :_

```java
class Ex3 {
	void principal() {
		testSontTousDiff();
	}
	
	/**
	* compte le nombre de valeurs différentes dans un tableau
	* @param tab tableau d’entiers
	* @return le nombre de valeurs différentes du tableau
	*/
	int compteDiffVal(int[] tab) {

		int temp;
		
		// On trie d'abord la liste avec l'aide de décalage pour ensuite facilité le travail
		for (int i = 1 ; i < tab.length ; i++){
			while (tab[i] < tab[i-1]) {
				temp = tab[i];
				tab[i] = tab[i-1];
				tab[i-1] = temp;
				i -=1;
			}
		}
		// Maintenant que les valeurs sont triées en ordre croissant il est facile de compter le nb de valeurs différentes
		int compteur;
		if (tab.length >= 1) {
			compteur = 1;
			for (int i = 1 ; i < tab.length ; i++) {
				if (tab[i] != tab[i-1]) {
					compteur +=1;
				}
			}	
		} else {
			compteur = 0;
		}
		
		return compteur;
	}
	
	
	/**
	* Teste la méthode compteDiffVal()
	*/
	void testSontTousDiff () {
		System.out.println ();
		System.out.println ("*** testCompteDiffVal()");
		testCasCompteDiffVal  (new int[] {0, 1, 2, 5, 3, 3}, 5);
		testCasCompteDiffVal  (new int[] {0, 3, 0, 0, 3, 3}, 2);
		testCasCompteDiffVal  (new int[] {3}, 1);
		testCasCompteDiffVal  (new int[] {}, 0);
		testCasCompteDiffVal  (new int[] {0, 0, 2, 3, 0, 2, 1, 3, 3, 0}, 4);
	}
	
	/**
	* teste un appel de compteDiffVal
	* @param tab tableau à traiter
	* @param result resultat attendu
	*/
	void testCasCompteDiffVal (int[] tab, int result) {
		
		// Affichage
		System.out.print ("compteDiffVal (" );
		displayTab(tab);
		System.out.print(") \t= " + result + "\t : ");
		
		// Appel
		int resExec = compteDiffVal(tab);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
			
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	
	void displayTab(int[] t) {
		
		if (t.length == 0) {
			System.out.print("{}");
		} else {
			int i = 0;
			System.out.print("{");
			
			while(i<t.length-1){
				System.out.print(t[i] + ",");
				i=i+1;
			}
			System.out.print(t[i]+"}");
		}
	}
}
```

_Exemple d'exécution_
```
*** testCompteDiffVal()
compteDiffVal ({0,1,2,5,3,3}) 	= 5	 : OK
compteDiffVal ({0,3,0,0,3,3}) 	= 2	 : OK
compteDiffVal ({3}) 	= 1	 : OK
compteDiffVal ({}) 	= 0	 : OK
compteDiffVal ({0,0,2,3,0,2,1,3,3,0}) 	= 4	 : OK
```

## Exercice 4

_Code :_

```java
class Ex4 {
	void principal() {
		testSontTousDiff();
	}
	
	/**
	* teste si une chaîne est une sous-chaîne d’une autre
	* @param mot chaîne de caractères
	* @param phrase chaîne de carectères
	* @return vrai ssi mot est présent dans phrase
	*/
	boolean estSousChaine (String mot, String phrase) {
		boolean souschaine = false;
		int compteur = 0;
		
		for (int i = 0 ; i < phrase.length() ; i++) {
			
			if (compteur == mot.length()) {
				souschaine = true;
			} else {
				if (phrase.charAt(i) == mot.charAt(compteur)) {
					compteur += 1;
					
				} else {
					compteur = 0;
				}
			}
		}
		return souschaine;
	}

	
	/**
	* Teste la méthode estSousChaine()
	*/
	void testSontTousDiff () {
		System.out.println ();
		System.out.println ("*** estSousChaine()");
		testCasEstSousChaine  ("ses", "abcdsesdef", true);
		testCasEstSousChaine  ("ses", "abcdef", false);
		testCasEstSousChaine  ("ses", "abcdefse", false);
		testCasEstSousChaine  ("ses", "SES", false);
		testCasEstSousChaine  ("s", "abcdsesdef", true);
	}
	
	/**
	* teste un appel de estSousChaine
	* @param tab1 premier tableau à comparer 
	* @param tab2 deuxième tableau à comparer
	* @param result resultat attendu
	*/
	void testCasEstSousChaine (String mot, String phrase, boolean result) {
		
		// Affichage
		System.out.print ("estSousChaine (" + mot + ", "+ phrase +") \t= " + result + "\t : ");
		
		// Appel
		boolean resExec = estSousChaine(mot, phrase);
		
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
*** estSousChaine()
estSousChaine (ses, abcdsesdef) 	= true	 : OK
estSousChaine (ses, abcdef) 	= false	 : OK
estSousChaine (ses, abcdefse) 	= false	 : OK
estSousChaine (ses, SES) 	= false	 : OK
estSousChaine (s, abcdsesdef) 	= true	 : OK
```

## Exercice 5

_Code :_

```java
class Ex5 {
	
	final int LG_TAB = 5;
	
	void principal() {
		int[] tab;
		tab = saisirEtTrier();
	}
	
	/**
	* Crée et saisit un tableau trié de LG_TAB entiers
	* @return tableau trié de LG-TAB entiers
	*/
	int[] saisirEtTrier () {
		int[] t = new int[LG_TAB];
		int i = 0;
		int val;
		boolean modif = false;
		
		while (i < t.length) {
			val = SimpleInput.getInt ("Entrer un entier : ");
			// insertion de la valeur en ordre croissant dans t
			for (int j = 0 ; j < t.length ; j++) {
				
				if (t[j] >=  val && t[LG_TAB-1] == 0 && modif == false) {
					modif = true;
					for (int n = t.length-1 ; n > j ; n--) {
						t[n] = t[n-1];
					}
					t[j] = val;
				} 
				
				 else if (t[j] >=  val && t[0] == 0 && modif == false) {
					modif = true;
					for (int n = 0 ; n < j ; n++) {
						t[n] = t[n+1];
					}
					t[j] = val;
				}
			}
			if (modif == false) {
				modif = true;
				t[i] = val;
			}
			
			modif = false;
			displayTab(t);
			i = i + 1;
		}
		return t;
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
			System.out.print(t[i]+"}");
		}
	}
}
```

_Exemple d'exécution_
```
Entrer un entier : 5
{5,0,0,0,0}Entrer un entier : 3
{3,5,0,0,0}Entrer un entier : 9
{3,5,9,0,0}Entrer un entier : -2
{-2,3,5,9,0}Entrer un entier : 7
{-2,3,5,7,9}
```

```
Entrer un entier : 0
{0,0,0,0,0}Entrer un entier : 0
{0,0,0,0,0}Entrer un entier : 0
{0,0,0,0,0}Entrer un entier : 0
{0,0,0,0,0}Entrer un entier : -1
{-1,0,0,0,0}
```