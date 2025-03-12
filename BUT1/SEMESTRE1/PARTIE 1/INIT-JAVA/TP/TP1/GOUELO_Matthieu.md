# R1.01 : TP1

**Nom :** Gouélo
**Prénom :** Matthieu
**Groupe :** 1D1

## Exercice 2

_Code :_

```java
/*
* @author matthieu gouélo
*/
class Ex2{
	void principal(){
		int val1;
		int val2;
		int val3;
		
		val1 = SimpleInput.getInt("Premier entier :");
		val2 = SimpleInput.getInt("Deuxième entier :");
		val3 = SimpleInput.getInt("Troisième entier :");
		
		if (val1 < val3 && val2 < val3) {
			System.out.println ("Le troisième entier " + val3 + " est le plus grand.");
		
		} else if (val1 < val2 && val3 < val2) {
			System.out.println ("Le deuxième entier " + val2 + " est le plus grand.");
		
		} else if (val2<val1&&val3<val1) {
			System.out.println ("Le premier entier " + val1 + " est le plus grand.");
		}	
	}
}

```

_Exemple d'exécution_
```
Premier entier :5
Deuxième entier :2
Troisième entier :4
Le premier entier 5 est le plus grand.

------------------
(program exited with code: 0)
Press return to continue
```

## Exercice 3

_Code :_

```java
/*
 * Ce programme calcul le périmètre & l'air du cercle avec le rayon 
 * fournis par l'utilisateur
 */

class Ex3{
	void principal() {
		
		final double PI = 3.14;
		double rayon = SimpleInput.getDouble("Rayon du cercle = ");
		
		System.out.println ("Périmètre du cercle = "+ 2 * PI * rayon);
		System.out.print ("Aire du cercle = "+ PI * rayon * rayon);
		
	}
}
```

_Exemples d'exécutions_
```
Rayon du cercle = 6
Périmètre du cercle = 37.68
Aire du cercle = 113.03999999999999

------------------
(program exited with code: 0)
Press return to continue
```

```
Rayon du cercle = 25
Périmètre du cercle = 157.0
Aire du cercle = 1962.5

------------------
(program exited with code: 0)
Press return to continue

```

## Exercice 4

_Code :_

```java
/**
 * Simulation du Bowling en Java
 */

class Ex4{
	void principal(){
		
		int nbQuille;
		int lance2;
		nbQuille = SimpleInput.getInt("Nombre de quille tombée au 1er lancé : ");
		
		if (nbQuille > 10 || nbQuille < 0) {
			System.out.println("Erreur, nombre incorect");
		} else {
			if (nbQuille == 10) {
					System.out.println("Strike !");
			} else {
				lance2 = SimpleInput.getInt("Nombre de quille tombée au 2e lancé : ");
				if (lance2 > 10 || lance2 < 0) {
					System.out.println("Erreur, nombre incorect");
				} else {
					nbQuille += lance2;
					if (nbQuille == 10) {
						System.out.println("Spare !");
					} else {
						System.out.print("Nombre total de quille tombée : "+ nbQuille);
					}
				}
			}
		}
	}
}
```

_Exemples d'exécutions_
```
Nombre de quille tombée au 1er lancé : 10
Strike !

------------------
(program exited with code: 0)
Press return to continue
```

```
Nombre de quille tombée au 1er lancé : 8
Nombre de quille tombée au 2e lancé : 2
Spare !

------------------
(program exited with code: 0)
Press return to continue
```

```
Nombre de quille tombée au 1er lancé : 3
Nombre de quille tombée au 2e lancé : 5
Nombre total de quille tombée : 8

------------------
(program exited with code: 0)
Press return to continue
```

```
Nombre de quille tombée au 1er lancé : 13
Erreur, nombre incorect

------------------
(program exited with code: 0)
Press return to continue

```

```
Nombre de quille tombée au 1er lancé : 9
Nombre de quille tombée au 2e lancé : -1
Erreur, nombre incorect

------------------
(program exited with code: 0)
Press return to continue
```