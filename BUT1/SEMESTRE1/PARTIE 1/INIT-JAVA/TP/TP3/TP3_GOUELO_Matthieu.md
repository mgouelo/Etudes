# R1.01 : TP3

**Nom :** Gouélo
**Prénom :** Matthieu
**Groupe :** D1

## Exercice 1

_Code :_

```java
/**
 * décale d'un indice toutes les valeurs du tableau version while
 * @author
 */

class Ex1 {
	void principal() {
		
		int[] tab = {5, 7, 0, 6, 10, 8, 4, 1};
		int val = tab[tab.length-1];
		int i = tab.length-1;
		
		System.out.print("Avant décalage : tab = ");
		displayTab(tab);
		
		while (i > 0){
			tab[i] = tab[i-1];
			i -= 1;
		}
		tab[0] = val;
		System.out.print("Après décalage : tab = ");
		displayTab(tab);
	}
	
	void displayTab(int[] t){
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
 * décale d'un indice toutes les valeurs du tableau version for
 * @author
 */

class Ex1 {
	void principal() {
		
		int[] tab = {5, 7, 0, 6, 10, 8, 4, 1};
		int val = tab[tab.length-1];
		
		System.out.print("Avant décalage : tab = ");
		displayTab(tab);
		
		for (int i = tab.length-1 ; i > 0 ; i--){
			tab[i] = tab[i-1];
		}
		
		tab[0] = val;
		System.out.print("Après décalage : tab = ");
		displayTab(tab);
	}
	
	void displayTab(int[] t){
		int i = 0;
		System.out.print("{");
		
		while(i<t.length-1){
			System.out.print(t[i] + ",");
			i=i+1;
		}
		
		System.out.println(t[i]+"}");
	}
}
```

_Exemples d'exécutions_
- Version while : 
```
Avant décalage : tab = {5,7,0,6,10,8,4,1}
Après décalage : tab = {1,5,7,0,6,10,8,4}


------------------
(program exited with code: 0)
Press return to continue
```

- Version for :
```
Avant décalage : tab = {5,7,0,6,10,8,4,1}
Après décalage : tab = {1,5,7,0,6,10,8,4}


------------------
(program exited with code: 0)
Press return to continue
```

## Exercice 2

_Code :_

```java
/**
 * Renvoie le tableau avec le cumul des valeurs précédentes version while
 * @author
 */

class Ex2 {
	void principal() {
		int[] tab = {5, 7, 0, 6, 10, 8, 4, 1};
		int i = 1;
		System.out.print("Avant : tab = ");
		displayTab(tab);
		
		while (i < tab.length) {
			tab[i] += tab[i-1];
			i += 1;
		}
		
		System.out.print("Après : tab = ");
		displayTab(tab);
	}
}


/**
 * Renvoie le tableau avec le cummul des valeurs précédentes version for
 * @author
 */

class Ex2 {
	void principal() {
		int[] tab = {5, 7, 0, 6, 10, 8, 4, 1};
		System.out.print("Avant : Tab = ");
		displayTab(tab);
		
		for (int i = 1 ; i < tab.length; i++) {
			tab[i] += tab[i-1];
		}
		
		System.out.print("Après : tab = ");
		displayTab(tab);
	}
}
```

_Exemples d'exécutions_
- Version while : 
```
Avant : tab = {5,7,0,6,10,8,4,1}
Après : tab = {5,12,12,18,28,36,40,41}


------------------
(program exited with code: 0)
Press return to continue
```

```
Avant : tab = {1}
Après : tab = {1}


------------------
(program exited with code: 0)
Press return to continue
```

- Version for :
```
Avant : tab = {5,7,0,6,10,8,4,1}
Après : tab = {5,12,12,18,28,36,40,41}


------------------
(program exited with code: 0)
Press return to continue
```

```
Avant : tab = {1}
Après : tab = {1}


------------------
(program exited with code: 0)
Press return to continue
```


## Exercice 3

_Code :_

```java
/**
 * Renvoie la longueur de la plus grande séquence avec son indice version while
 * @author
 */

class Ex3 {
	void principal() {
		
		int i = 0;
		int serieMax = 1;
		int serie = 1;
		int[] tab = {1, 2, 3, 4, 3, 2, 1};
		
		System.out.print("tab = ");
		displayTab(tab);
		
		while (i < tab.length-1 && (tab.length-1 - i > serieMax - serie) ) { 
			/* Dans cette condition de continuation on vérifie si le nombre de valeur
			 * restante (tab.length-1 - i) est suffisant pour dépasser la sérieMax 
			 * en prenant en compte la valeur de la serie en cours */
			
			if (serie > serieMax) {
				serieMax = serie;
			}
			
			if (tab[i+1] >= tab[i]) {
				serie += 1;	
			} else {
				serie = 1;
			}
			
			i += 1;
		}
		
		if (serie > serieMax) {
			serieMax = serie;
		}
		System.out.println("La série la plus longue est de longueur : "+serieMax);
		System.out.print("i = "+i);	
	}
}

```

_Réponse rédigée :_
Il semble que la boucle while est plus adaptée que le for car le nombre de tour de boucle n'est pas connu à l'avance.

_Exemples d'exécutions_
- Version while : 
```
tab = {4,0,6,10,8,4}
La série la plus longue est de longueur : 3
i = 4

------------------
(program exited with code: 0)
Press return to continue
```

```
tab = {1,2,3,4,1,2,3,4,5}
La série la plus longue est de longueur : 5
i = 8

------------------
(program exited with code: 0)
Press return to continue
```

```
tab = {1}
La série la plus longue est de longueur : 1
i = 0

------------------
(program exited with code: 0)
Press return to continue
```

```
tab = {1,2,3,4,3,2,1}
La série la plus longue est de longueur : 4
i = 4

------------------
(program exited with code: 0)
Press return to continue
```


## Exercice 4

_Code :_

```java
/**
 * Renvoie la longueur de la plus grande séquence avec son indice version while
 * @author
 */

class Ex4 {
	void principal() {
		
		int i = 0;
		int serieMax = 1;
		int serie = 1;
		/*int[] tab = {1, 2, 3, 4, 3, 2, 1};*/
		int[] tab = {5, 7, 0, 6, 10, 8, 4, 1, 5, 6, 10};
		int indiceSerieMax = 0;
		
		System.out.print("tab = ");
		displayTab(tab);
		
		while (i < tab.length-1 && (tab.length-1 - i > serieMax - serie) ) { 
			
			if (serie > serieMax) {
				serieMax = serie;
				indiceSerieMax = i+1 - serie;
			}
			
			if (tab[i+1] >= tab[i]) {
				serie += 1;	
			} else {
				serie = 1;
			}
			
			i += 1;
		}
		
		if (serie > serieMax) {
			serieMax = serie;
			indiceSerieMax = tab.length - serie;
		}
		System.out.println("La série la plus longue est de longueur "+serieMax+
		" et commence à l'indice "+indiceSerieMax+ " et se termine à l'indice "+ (indiceSerieMax + serieMax-1));
		System.out.print("i = "+i);	
	}
}
```

_Exemples d'exécutions_
```
tab = {5,7,0,6,10,8,4,1,5,6,10}
La série la plus longue est de longueur 4 et commence à l'indice 7 et se termine à l'indice 10
i = 10

------------------
(program exited with code: 0)
Press return to continue
```

```
tab = {1,2,3,4,3,2,1}
La série la plus longue est de longueur 4 et commence à l'indice 0 et se termine à l'indice 3
i = 4

------------------
(program exited with code: 0)
Press return to continue
```

```
tab = {1}
La série la plus longue est de longueur 1 et commence à l'indice 0 et se termine à l'indice 0
i = 0

------------------
(program exited with code: 0)
Press return to continue
```


## Exercice 5

_Code :_

```java
class Ex5 {
	void principal() {
		
		int[] tab = new int[10];
		int nbAleatoire;
		
		for (int i = 1 ; i <= 1000 ; i++) {
			nbAleatoire = (int) (Math.random() * 10);
			tab[nbAleatoire] += 1;
		}
		
		System.out.print("Après éxécution : tab = ");
		displayTab(tab);
		
	}
}
```

_Exemples d'exécutions_
```
Après exécution : tab = {93,90,101,93,108,107,101,111,101,95}


------------------
(program exited with code: 0)
Press return to continue
```

```
Après éxécution : tab = {108,96,96,101,85,105,113,91,114,91}


------------------
(program exited with code: 0)
Press return to continue
```


## Exercice 6

_Code :_

```java
class Ex6 {
	void principal() {
		
		int nb;
		int nbEtape = 0;
		
		do {
			nb = SimpleInput.getInt("Entrez un nombre entier strictement positif : ");
		} while (nb <= 0);
		
		int nbMax = nb;
		
		while (nb != 1) {
			if (nb % 2 == 0) {
				nb = nb / 2;
				nbEtape += 1;
			} else {
				nb = nb * 3 + 1;
				nbEtape += 1;
				if (nb > nbMax) {
					nbMax = nb;
				}
			}
		}
		System.out.print("Il aura fallu "+ nbEtape 
		+" étapes pour arriver à 1. Le nombre maximum rencontré est "+ nbMax);
	}
}
```

_Réponse rédigée :_
La première boucle du programme permet de demander à l'utilisateur d'enter un nombre tant que ceux fournis ne sont pas valables. Pour la première boucle il est préférable d'utiliser le "do-while" car on ne connait pas a l'avance le nombre d'erreur que fera l'utilisateur. De plus par soucis de redondance de la commande "SimpleInput" il est préferable d'utiliser le "do-while"
Pour la seconde boucle on ne connait pas non plus le nombre de tour de boucle que l'on devra faire pour arriver à 1 ; On utilise donc le "while".

_Exemples d'exécutions_
```
Entrez un nombre entier strictement positif : -7
Entrez un nombre entier strictement positif : 0
Entrez un nombre entier strictement positif : 7
Il aura fallu 16 étapes pour arriver à 1. Le nombre maximum rencontré est 52

------------------
(program exited with code: 0)
Press return to continue
```

```
Entrez un nombre entier strictement positif : 1
Il aura fallu 0 étapes pour arriver à 1. Le nombre maximum rencontré est 1

------------------
(program exited with code: 0)
Press return to continue
```