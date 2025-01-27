/**
 * Cette classe effectue des opérations plus complexes sur un tableaux d'entiers : recherche dichotomique, tris, etc. La taille d'un tableau est
 * par définition le nombre TOTAL de cases = tab.length. Un tableau d'entiers créé possède nbElem élements qui ne correspond pas
 * forcément à la taille du tableau. Il faut donc toujours considéré que nbElem est inferieur ou égal à tab.length (= taille).
 * @author Matthieu Gouélo
 * @version 1.1.0
 */
class TrisTableau {
	/**
	 * Importation des méthodes de la class SimpleTableau 
	 */
	SimpleTableau monSpleTab = new SimpleTableau();
	
	/**
	 * varaible pour compter le nombre d'opération réalisée
	 */
	long cpt = 0;
	
	/**
	 * La méthode principal appel les méthodes de tri et de recherches implémentés dans la 
	 * classe TrisTableau
	 */
	void principal() {
		// rechercheSeq FAIT
		// testRechercheSeq();
		testRechercheSeqEfficacite();
		
		// verifTri FAIT
		testRechercheVerifTri();
		
		// rechercheDicho FAIT
		// testRechercheDicho();
		testRechercheDichoEfficacite();
		
		// triSimple FAIT
		testTriSimple();
		testTriSimpleEfficacite();
		
		// separer FAIT
		testRechercheSeparer();
		
		// triRapideRec FAIT
		testRechercheTriRapideRec();
		// triRapide
		testTriRapideEfficacite();
		
		// creerTabFreq FAIT
		// triParComptageFreq
		testRechercheTriParComptageFreq();
		testTriParComptageFreqEfficacite();
		
		// triABulles FAIT
		testTriABulles();
		testTriABullesEfficacite();
		
	}
	
	//------------------------------------RECHERCHE SEQUENTIELLE------------------------------------
	/**
	 * Effectue une recherche séquentielle d'une valeur dans un tableau. S'arrête dès que la
	 * valeur est trouvée
	 * @param leTab tableau d'entier à parcourir
	 * @param nbElem nombre d'élément du tableau
	 * @param aRech entier à rechercher dans le tableau
	 * @return l'indice de la valeur recherchée si elle est trouvée ; -1 sinon
	 */
	int rechercheSeq(int[] leTab, int nbElem, int aRech) {
		
		int indiceValeur = -1;
		int i = 0;
		boolean trouve = false;
		
		while (i < nbElem && !trouve) {
			cpt += 1;
			if (leTab[i] == aRech) {
				indiceValeur = i;
				trouve = true;
				
			} else {
				i++;
			}
		}
		return indiceValeur;
	}
	
	/**
	 * JavaDoc : test de la méthode rechercheSeq()
	 * @param leTab tableau d'entier à parcourir
	 * @param nbElem nombre d'élément du tableau
	 * @param aRech entier à rechercher dans le tableau
	 * @param resultatAttendu résultat attendu
	 */
	void testCasRechercheSeq(int[] leTab, int nbElem, int aRech, int resultatAttendu) {
		
		// Affichage
		System.out.print("leTab = ");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.println("\t nbElem = " + nbElem + "\t aRech = " + aRech);
		
		int resExec = rechercheSeq(leTab, nbElem, aRech);
		System.out.print("rechercheSeq(leTab, nbElem, aRech) \t= " + resExec + "\t: ");
		
		// test si le résultat de l'exécution (resExec) est bien égal au résultat attendu (resultatAttendu)
		
		if (resExec == resultatAttendu) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasRechercheSeq()
	 */
	void testRechercheSeq() {
	
		
		System.out.println("*** résultats des tests de rechercheSeq() :");
		testCasRechercheSeq(new int[] {56, 102, -3, 47, 28, 67, 0}, 7, 47, 3);
		testCasRechercheSeq(new int[] {56, 102, -3, 47, 28, 67, 0}, 5, -3, 2);
		testCasRechercheSeq(new int[] {56, 102, -3, 47, 28, 67, 0}, 5, 67, -1);
	}
	
	/**
	 * Méthode testant l'efficacité de rechercheSeq()
	 */
	void testRechercheSeqEfficacite() {
		
		System.out.println("*** résultats des tests de l'efficacité de rechercheSeq() :");
		
		// paramètres de rechercheSeq()
		int[] tab;
		int n, aRech, indice;
		
		// Variables pour mesurer le temps d'exécution
		long t1, t2, diffT;
		
		// Initialisation
		n = 150000;
		
		
		for (int i = 1 ; i <= 6 ; i++) {
			cpt = 0;
			
			// Initialisation
			tab = new int[n];
			monSpleTab.remplirAleatoire(tab, n, 1, n);
			aRech = Integer.MAX_VALUE;
			
			t1 = System.nanoTime();
			indice = rechercheSeq(tab, n, aRech);
			t2 = System.nanoTime();
			
			diffT = t2 - t1;
			System.out.println("n = " + n);
			System.out.println("Temps = " + diffT + " ns");
			System.out.println("cpt / n = " + (double) cpt/n);
			
			n = n * 2;
		}
	}
	
	//------------------------------------VERIF TRI------------------------------------
	/**
	 * Vérifie si un tableau d'entiers est trié dans l'ordre croissant.
	 * On suppose que le tableau passé en paramètre contient au moins une valeur (nbElem > 0).
	 * Cette condition n'est pas vérifiée dans cette méthode.
	 *
	 * @param leTab le tableau d'entiers à vérifier (trié en ordre croissant)
	 * @param nbElem le nombre d'éléments présents dans le tableau
	 * @return true si le tableau est trié en ordre croissant ; false sinon
	 */
	boolean verifTri(int[] leTab, int nbElem) {
		
		boolean trie = true;
		int i = 1;
			
		while (i < nbElem && trie) {
			if (leTab[i-1] > leTab[i]) {
				trie = false;
			}
			i += 1;
		}
		
		return trie;
	}
	
	/**
	 * JavaDoc : test de la méthode verifTri()
	 * @param leTab tableau d'entier à parcourir
	 * @param nbElem nombre d'élément du tableau
	 * @param resultatAttendu résultat attendu
	 */
	void testCasVerifTri(int[] leTab, int nbElem, boolean resultatAttendu) {
		
		// Affichage
		System.out.print("leTab = ");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.println("\t nbElem = " + nbElem);
		
		boolean resExec = verifTri(leTab, nbElem);
		System.out.print("verifTri(leTab, nbElem) \t= " + resExec + "\t: ");
		
		// test si le résultat de l'exécution (resExec) est bien égal au résultat attendu (resultatAttendu)
		
		if (resExec == resultatAttendu) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasVerifTri()
	 */
	void testRechercheVerifTri() {
	
		
		System.out.println("*** résultats des tests de verifTri() :");
		testCasVerifTri(new int[] {56, 102, -3, 47, 28, 67, 0}, 7, false);
		testCasVerifTri(new int[] {56, 102, -3, 47, 28, 67, 0}, 2, true);
		testCasVerifTri(new int[] {56}, 1, true);
	}
	
	//------------------------------------RECHERCHE DICHO------------------------------------
	/**
	 * Effectue une recherche dichotomique d'une valeur dans un tableau trié en ordre croissant.
	 * La valeur recherchée peut apparaître plusieurs fois dans le tableau. Dans ce cas, 
	 * l'indice de la première occurrence sera retourné.
	 * On suppose que le tableau passé en paramètre est créé, contient au moins une valeur (nbElem > 0),
	 * et est trié par ordre croissant. Ces conditions ne sont pas vérifiées dans cette méthode.
	 *
	 * @param leTab le tableau trié par ordre croissant dans lequel effectuer la recherche
	 * @param nbElem le nombre d'éléments présents dans le tableau
	 * @param aRech l'entier à rechercher dans le tableau
	 * @return l'indice (>= 0) de la première occurrence de l'entier dans le tableau, ou -1 si l'entier n'est pas présent
	 */
	int rechercheDicho(int[] leTab, int nbElem, int aRech) {
		int indL, indR, indM, iRech;
		iRech = -1;
		indL = 0;
		indR = nbElem - 1;
		while(indL != indR) {
			cpt++;
			indM = (indR + indL) / 2;
			if (leTab[indM] > aRech) {
				indR = indM - 1;
			} else if (leTab[indM] < aRech) {
				indL = indM + 1;
			} else {
				indL = indM;
				indR = indM;
			}	
		}
		if (leTab[indL] == aRech) {
			iRech = indL;
		}
		return iRech;	
	}
	
	/**
	 * JavaDoc : test de la méthode rechercheDicho()
	 * @param leTab tableau d'entier à parcourir
	 * @param nbElem nombre d'élément du tableau
	 * @param aRech valeur à rechercher dans le tableau
	 * @param resultatAttendu résultat attendu
	 */
	void testCasRechercheDicho(int[] leTab, int nbElem, int aRech, int resultatAttendu) {
		
		// Affichage
		System.out.print("leTab = ");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.println("\t nbElem = " + nbElem + "\t aRech = " + aRech);
		
		int resExec = rechercheDicho(leTab, nbElem, aRech);
		System.out.print("rechercheDicho(leTab, nbElem, aRech) \t= " + resExec + "\t: ");
		
		// test si le résultat de l'exécution (resExec) est bien égal au résultat attendu (resultatAttendu)
		
		if (resExec == resultatAttendu) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasRechercheDicho()
	 */
	void testRechercheDicho() {
	
		
		System.out.println("*** résultats des tests de rechercheDicho() :");
		testCasRechercheDicho(new int[] {56, 102, 305, 306, 501, 677, 1000}, 7, 677, 5);
		testCasRechercheDicho(new int[] {56, 102, 305, 306, 501, 677, 1000}, 7, 56, 0);
		testCasRechercheDicho(new int[] {56, 102, 305, 306, 501, 677, 1000}, 4, 1000, -1);
	}
	
	/**
	 * Méthode testant l'efficacité de rechercheDicho()
	 */
	void testRechercheDichoEfficacite() {
		
		System.out.println("*** résultats des tests de l'efficacité de rechercheDicho() :");
		
		// paramètres de rechercheDicho()
		int[] tab;
		int aRech;
		
		// Variables pour mesurer le temps d'exécution
		long t1, t2, diffT;
		
		// Initialisation
		int n = 10000;
		
		for (int i = 1 ; i <= 6 ; i++) {
			cpt = 0;
			
			// Initialisation
			tab = new int[n];
			monSpleTab.remplirAleatoire(tab, n, 0, n);
			aRech = Integer.MAX_VALUE;
			
			t1 = System.nanoTime();
			rechercheDicho(tab, n, aRech);
			t2 = System.nanoTime();
			
			diffT = t2 - t1;
			System.out.println("n = " + n);
			System.out.println("Temps = " + diffT + " ns");
			
			
			double log2n = Math.log10(n) / Math.log10(2);
			System.out.println("cpt / log2(n) = " + (double) cpt / log2n);
			
			n = (int) (n * Math.pow(2, i));
		}
	}
	
	//------------------------------------TRI SIMPLE------------------------------------
	/**
	 * Trie un tableau d'entiers en ordre croissant à l'aide de la méthode simple.
	 * On suppose que le tableau passé en paramètre est créé, contient au moins une valeur (nbElem > 0),
	 * et ne vérifie pas cette condition.
	 *
	 * @param leTab le tableau d'entiers à trier par ordre croissant
	 * @param nbElem le nombre d'éléments présents dans le tableau
	 */
	void triSimple(int[] leTab, int nbElem) {
		int temp;
		int min;
		int posMin;
		for (int i = 0 ; i < nbElem ; i++) {
			min = leTab[i];
			posMin = i;
			for (int j = i+1 ; j < nbElem ; j++) {
				cpt++;
				if (min > leTab[j]) {
					min = leTab[j];
					posMin = j;
				}
			}
			monSpleTab.echange(leTab, nbElem, i, posMin);
		}
	}
	
	/**
	 * JavaDoc : test de la méthode triSimple()
	 * @param leTab tableau d'entier à parcourir
	 * @param nbElem nombre d'élément du tableau
	 */
	void testCasTriSimple(int[] leTab, int nbElem) {
		
		// Affichage
		System.out.print("leTab = ");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.println("\t nbElem = " + nbElem);
		
		triSimple(leTab, nbElem);
		System.out.print("triSimple(leTab, nbElem) \t= ");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasTriSimple()
	 */
	void testTriSimple() {
	
		
		System.out.println("*** résultats des tests de triSimple() :");
		testCasTriSimple(new int[] {56, 102, -3, 47, 28, 67, 0}, 7);
		testCasTriSimple(new int[] {56, 102, -3, 47, 28, 67, 0}, 5);
	}
	
	/**
	 * Méthode testant l'efficacité de triSimple()
	 */
	void testTriSimpleEfficacite() {
		
		System.out.println("*** résultats des tests de l'efficacité de triSimple() :");
		
		// paramètres de triSimple()
		int[] tab;
		int n; // n <=> nbElem
		
		// Variables pour mesurer le temps d'exécution
		long t1, t2, diffT;
		
		// Initialisation
		n = 1500;
		
		
		for (int i = 1 ; i <= 6 ; i++) {
			cpt = 0;
			
			// Initialisation
			tab = new int[n];
			monSpleTab.remplirAleatoire(tab, n, 1, n);
			
			t1 = System.nanoTime();
			triSimple(tab, n);
			t2 = System.nanoTime();
			
			diffT = t2 - t1;
			System.out.println("n = " + n);
			System.out.println("Temps = " + diffT + " ns");
			System.out.println("cpt / n = " + (double) cpt / Math.pow(n, 2) );
			
			n = n * 2;
		}
	}

	
	//------------------------------------SEPARER------------------------------------
	/**
	 * Réorganise un tableau autour d'un pivot et renvoie l'indice de séparation.
	 * Cette méthode divise le tableau en deux parties autour d'un pivot sélectionné : 
	 * les éléments inférieurs ou égaux au pivot se trouvent à gauche, 
	 * tandis que les éléments supérieurs se trouvent à droite. Le pivot est placé
	 * à sa position finale correcte dans le tableau.
	 *
	 * @param tab le tableau contenant les valeurs à réorganiser
	 * @param indL l'indice de début de la portion du tableau (Left)
	 * @param indR l'indice de fin de la portion du tableau (Right)
	 * @return l'indice de séparation où le pivot est placé
	 */
	int separer(int[] tab, int indL, int indR) {
		int pivot = tab[indL];
		int i = indR + 1;
		for (int j = indR ; j > indL ; j--) {
			cpt++;
			if (tab[j] > pivot) {
				i--;
				if (i != j) {
					monSpleTab.echange(tab, indR + 1, i, j);
				}
			}
		}
		monSpleTab.echange(tab, indR + 1, i-1, indL);
		return i-1;
	}
	
	/**
	 * JavaDoc : test de la méthode separer()
	 * @param leTab tableau d'entier à séparer
	 * @param indL indice le plus à gauche du tableau
	 * @param indR indice le plus à droite du tableau
	 * @param resultatAttendu résultat attendu
	 */
	void testCasSeparer(int[] leTab, int indL, int indR, int resultatAttendu) {
		
		// Affichage
		System.out.print("leTab = ");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.println("\t indL = " + indL + "\t indR = "+ indR);
		
		int resExec = separer(leTab, indL, indR);
		System.out.print("separer(leTab, indL, indR) \t= " + resExec + "\t: ");
		
		// test si le résultat de l'exécution (resExec) est bien égal au résultat attendu (resultatAttendu)
		
		if (resExec == resultatAttendu) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasSeparer()
	 */
	void testRechercheSeparer() {
	
		
		System.out.println("*** résultats des tests de separer() :");
		testCasSeparer(new int[] {3, 25, 21, 0, 18}, 0, 4, 1);
		testCasSeparer(new int[] {56, 102, -3, 47, 28, 67, 0}, 0, 4, 3);
		testCasSeparer(new int[] {56, 102, -3, 47, 28, 67, 0}, 0, 6, 4);
	}
	
	//------------------------------------TRI RAPIDE RECURSIF------------------------------------
	/**
	 * Trie un tableau d'entiers en ordre croissant de manière récursive selon le principe de séparation.
	 * Cette méthode implémente l'algorithme de tri rapide (QuickSort) en divisant le tableau en deux 
	 * sous-parties autour d'un pivot, puis en appelant récursivement la méthode sur les parties gauche 
	 * et droite.
	 *
	 * @param tab le tableau d'entiers à trier
	 * @param indL l'indice gauche de début de la portion du tableau à trier
	 * @param indR l'indice droite de fin de la portion du tableau à trier
	 */
	void triRapideRec(int[] tab, int indL, int indR) {
		int iPivot;
		if (indL < indR) {
			iPivot = separer(tab, indL, indR);
			triRapideRec(tab, indL, iPivot-1);
			triRapideRec(tab, iPivot+1, indR);
		}
	}
	
	/**
	 * JavaDoc : test de la méthode triRapideRec()
	 * @param leTab tableau d'entier à séparer
	 * @param indL indice le plus à gauche du tableau
	 * @param indR indice le plus à droite du tableau
	 */
	void testCasTriRapideRec(int[] leTab, int indL, int indR) {
		
		// Affichage
		System.out.print("leTab = ");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.println("\t indL = " + indL + "\t indR = "+ indR);
		
		triRapideRec(leTab, indL, indR);
		System.out.print("triRapideRec(leTab, indL, indR) \t= ");
		monSpleTab.afficherTab(leTab, indR + 1);
		System.out.println();
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasTriRapideRec()
	 */
	void testRechercheTriRapideRec() {
	
		
		System.out.println("*** résultats des tests de triRapideRec() :");
		testCasTriRapideRec(new int[] {3, 25, 21, 0, 18}, 0, 4);
		testCasTriRapideRec(new int[] {56, 102, -3, 47, 28, 67, 0}, 0, 4);
		testCasTriRapideRec(new int[] {56, 102, -3, 47, 28, 67, 0}, 0, 6);
	}
	
	//------------------------------------TRI RAPIDE------------------------------------
	/**
	 * Trie un tableau d'entiers en ordre croissant en utilisant l'algorithme du tri rapide (QuickSort).
	 * Cette méthode sert de point d'entrée pour le tri rapide, en initialisant les paramètres nécessaires 
	 * et en appelant la méthode récursive triRapideRec(...) qui effectue réellement le tri selon le principe 
	 * de séparation récursive.
	 * On suppose que le tableau passé en paramètre est créé et contient au moins une valeur (nbElem > 0). 
	 * Cette condition n'est pas vérifiée dans cette méthode.
	 *
	 * @param leTab le tableau d'entiers à trier par ordre croissant
	 * @param nbElem le nombre d'éléments présents dans le tableau
	 */
	void triRapide(int[] leTab, int nbElem) {
		triRapideRec(leTab, 0, nbElem-1);
	}
	
	/**
	 * Méthode testant l'efficacité de triRapide()
	 */
	void testTriRapideEfficacite() {
		
		System.out.println("*** résultats des tests de l'efficacité de triRapide() :");
		
		// paramètres de triRapide()
		int[] tab;
		int indL, indR;
		
		// Variables pour mesurer le temps d'exécution
		long t1, t2, diffT;
		
		// Initialisation
		indL = 0;
		indR = 10000;
		int n = indR + 1;
		
		for (int i = 1 ; i <= 6 ; i++) {
			cpt = 0;
			
			// Initialisation
			tab = new int[n];
			monSpleTab.remplirAleatoire(tab, n, 1, n);
			
			t1 = System.nanoTime();
			triRapide(tab, n);
			t2 = System.nanoTime();
			
			diffT = t2 - t1;
			System.out.println("n = " + n);
			System.out.println("Temps = " + diffT + " ns");
			
			
			double log2n = Math.log10(n) / Math.log10(2);
			System.out.println("cpt / n * log2(n) = " + (double) cpt / (n * log2n) );
			
			n = (int) (n * Math.pow(2, i));
		}
	}

	
	//------------------------------------CREER TAB FREQ------------------------------------
	/**
	 * Crée un tableau de fréquences à partir d'un tableau initial.
	 * Cette méthode génère un nouveau tableau "tabFreq" où chaque case représente la fréquence 
	 * d'apparition des entiers du tableau initial "leTab". Chaque case "i" (0 ≤ i ≤ max) du tableau 
	 * de fréquences contient le nombre de fois que la valeur "i" apparaît dans le tableau initial. 
	 * 
	 * Pour simplifier, on suppose que le tableau initial contient uniquement des entiers compris 
	 * entre 0 et un maximum "max" (> 0). Le tableau "tabFreq" aura une taille de (max + 1). 
	 * Si le tableau initial contient une valeur négative, la méthode renvoie null.
	 * 
	 * On suppose que le tableau initial est créé et contient au moins une valeur (nbElem > 0), 
	 * cette condition n'est pas vérifiée par la méthode.
	 * 
	 * @param leTab le tableau initial contenant les entiers
	 * @param nbElem le nombre d'éléments présents dans le tableau
	 * @return le tableau des fréquences de taille (max + 1) ou null si une valeur négative est détectée
	 */
	int[] creerTabFreq(int[] leTab, int nbElem) {
		int max = monSpleTab.leMax(leTab, nbElem);
		int nb;
		int[] tabFreq = new int[max+1];
		for(int i = 0 ; i < nbElem ; i++) {
			cpt++;
			nb = leTab[i];
			tabFreq[nb] += 1;
		}
		return tabFreq;
	}
	
	
	//------------------------------------TRI PAR COMPTAGE FREQ------------------------------------
	/**
	 * Trie un tableau d'entiers en ordre croissant en utilisant la méthode du tri par comptage de fréquences.
	 * Cette méthode repose sur la construction d'un tableau de fréquences pour déterminer l'ordre des éléments
	 * dans le tableau trié. Elle est particulièrement efficace pour les tableaux contenant des entiers dans une 
	 * plage de valeurs limitée.
	 * 
	 * On suppose que le tableau passé en paramètre est créé et contient au moins une valeur (nbElem > 0). 
	 * Cette condition n'est pas vérifiée dans cette méthode.
	 * 
	 * @param leTab le tableau d'entiers à trier par ordre croissant
	 * @param nbElem le nombre d'éléments présents dans le tableau
	 */
	void triParComptageFreq(int[] leTab, int nbElem) {
		int[] tabFreq = creerTabFreq(leTab, nbElem);
		int indice = 0;
		for (int i = 0 ; i < tabFreq.length ; i++) {
			cpt++;
			for (int j = 0 ; j < tabFreq[i] ; j++) {
				leTab[indice] = i;
				indice += 1;
			}
		}
	}
	
	/**
	 * JavaDoc : test de la méthode triParComptageFreq()
	 * @param leTab tableau d'entier à trier
	 * @param nbElem nombre d'élément du tableau
	 */
	void testCasTriParComptageFreq(int[] leTab, int nbElem) {
		
		// Affichage
		System.out.print("leTab = ");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.println("\t nbElem = " + nbElem);
		
		triParComptageFreq(leTab, nbElem);
		System.out.print("triParComptageFreq(leTab, nbElem) \t= ");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.println();
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasTriParComptageFreq()
	 */
	void testRechercheTriParComptageFreq() {
	
		
		System.out.println("*** résultats des tests de triParComptageFreq() :");
		testCasTriParComptageFreq(new int[] {3, 25, 21, 0, 18}, 5);
		testCasTriParComptageFreq(new int[] {56, 102, 3, 47, 28, 67, 0}, 7);
		testCasTriParComptageFreq(new int[] {56, 102, 3, 47, 28, 67, 0}, 5);
	}
	
	/**
	 * Méthode testant l'efficacité de triParComptageFreq()
	 */
	void testTriParComptageFreqEfficacite() {
		
		System.out.println("*** résultats des tests de l'efficacité de triParComptageFreq() :");
		
		// paramètres de triRapide()
		int[] tab;
		int max;
		
		// Variables pour mesurer le temps d'exécution
		long t1, t2, diffT;
		
		// Initialisation
		int n = 1500;
		
		for (int i = 1 ; i <= 6 ; i++) {
			cpt = 0;
			
			// Initialisation
			tab = new int[n];
			monSpleTab.remplirAleatoire(tab, n, 1, n);
			max = monSpleTab.leMax(tab, n);
			
			t1 = System.nanoTime();
			triParComptageFreq(tab, n);
			t2 = System.nanoTime();
			
			diffT = t2 - t1;
			System.out.println("n = " + n);
			System.out.println("Temps = " + diffT + " ns");
			
			
			double log2n = Math.log10(n) / Math.log10(2);
			System.out.println("cpt / n = " + (double) cpt / (n + max + 1) );
			
			n = (int) (n * Math.pow(2, i));
		}
	}
	
	//------------------------------------TRI A BULLES------------------------------------
	/**
	 * Trie un tableau d'entiers en ordre croissant en utilisant la méthode du tri à bulles.
	 * Cette méthode consiste à comparer deux cases successives du tableau et à permuter leurs
	 * contenus si l'élément de gauche est supérieur à celui de droite. Le processus est répété
	 * tant qu'il reste au moins deux cases non triées.
	 * 
	 * On suppose que le tableau passé en paramètre est créé et contient au moins une valeur 
	 * (nbElem > 0). Cette condition n'est pas vérifiée dans cette méthode.
	 * 
	 * @param leTab le tableau d'entiers à trier par ordre croissant
	 * @param nbElem le nombre d'éléments présents dans le tableau
	 */
	void triABulles(int[] leTab, int nbElem) {
		int temp;
		for (int i = nbElem - 1 ; i >= 0 ; i--) {
			for (int j = 0 ; j < i ; j++) {
				cpt++;
				if (leTab[j+1] < leTab[j]) {
					temp = leTab[j+1];
					leTab[j+1] = leTab[j];
					leTab[j] = temp;
				}
			}
		}
	}
	
	/**
	 * JavaDoc : test de la méthode triABulles()
	 * @param leTab tableau d'entier à parcourir
	 * @param nbElem nombre d'élément du tableau
	 */
	void testCasTriABulles(int[] leTab, int nbElem) {
		
		// Affichage
		System.out.print("leTab = ");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.println("\t nbElem = " + nbElem);
		
		triABulles(leTab, nbElem);
		System.out.print("triABulles(leTab, nbElem) \t= ");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.println();
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasTriABulles()
	 */
	void testTriABulles() {
	
		
		System.out.println("*** résultats des tests de triABulles() :");
		testCasTriABulles(new int[] {56, 102, -3, 47, 28, 67, 0}, 7);
		testCasTriABulles(new int[] {56, 102, -3, 47, 28, 67, 0}, 5);
	}
	
	/**
	 * Méthode testant l'efficacité de triABulles()
	 */
	void testTriABullesEfficacite() {
		
		System.out.println("*** résultats des tests de l'efficacité de triABulles() :");
		
		// paramètres de triABulles()
		int[] tab;
		int n; // n <=> nbElem
		
		// Variables pour mesurer le temps d'exécution
		long t1, t2, diffT;
		
		// Initialisation
		n = 1500;
		
		
		for (int i = 1 ; i <= 6 ; i++) {
			cpt = 0;
			
			// Initialisation
			tab = new int[n];
			monSpleTab.remplirAleatoire(tab, n, 1, n);
			
			t1 = System.nanoTime();
			triABulles(tab, n);
			t2 = System.nanoTime();
			
			diffT = t2 - t1;
			System.out.println("n = " + n);
			System.out.println("Temps = " + diffT + " ns");
			System.out.println("cpt / n = " + (double) cpt / Math.pow(n, 2) );
			
			n = n * 2;
		}
	}
}
