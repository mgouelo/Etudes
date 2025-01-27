/**
 * La classe SimpleTableau fournit un ensemble de méthodes pour manipuler et 
 * effectuer diverses opérations sur des tableaux en Java.
 * <p>
 * Les méthodes incluent des opérations telles que l'initialisation de tableaux,
 * le remplissage aléatoire, le tri, la recherche d'éléments spécifiques, 
 * et d'autres manipulations courantes. Cette classe est conçue pour simplifier 
 * l'utilisation des tableaux et offrir un support pour des manipulations plus avancées.
 * </p>
 */
class SimpleTableau {
	
	/**
	 * Méthode appel des fonctions tests
	 */
	void principal() {
		// testVerifTab();
		// testAfficherTab();
		// testTirerAleatoire();
		// testRemplirAleatoire();
		// testEgalite();
		// testCopier();
		// testLeMax();
		// testInverse();
		// testEchange();
		// testMelange();
		// testDecalerGche();
		// testSupprimerUneValeur();
		// testInclusion();
		// testRemplirToutesDiff();
	}
	
	/**
	 * Vérifie si la tableau fournis en paramètre est valide : il ne doit pas être inexistant
	 * le nombre d'élément doit être être compatible avec la taille du tableau
	 * @param leTab le tableau dont on doit vérifier l'existence (leTab différent de null)
	 * @param nbElem le nombre d'éléments que contiendra le tableau, doit être compris entre 0 exclus et tab.length inclu
	 * @return vrai ssi la tableau est valide sinon faux
	 */
	boolean verifTab(int[] leTab, int nbElem) {
		
		boolean valide = true;
		
		if (leTab == null) {
			valide = false;
			System.err.println("Erreur verifTab() : le tableau est inexistant.");
			
		} else if (nbElem <= 0 || nbElem > leTab.length) {
			valide = false;
			System.err.println("Erreur verifTab() : la valeur nbElem est invalide.");
		}
		
		return valide;
	}
	
	/**
	 * JavaDoc : test de la méthode verifTab()
	 * @param leTab tableau a vérifier
	 * @param nbElem nombre d'éléments du tableau
	 * @param resultat résultat attendu
	 */
	void testCasVerifTab(int[] leTab, int nbElem, boolean resultat) {
		
		boolean resExec = verifTab(leTab, nbElem);
		System.out.print("Test verifTab(");
		afficherTab(leTab, nbElem);
		System.out.print(", " + nbElem + ") : ");
		
		if (resExec == resultat) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
		
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasVerifTab()
	 */
	void testVerifTab() {
	
		
		System.out.println("*** résultats des tests de verifTab() :");
		System.out.println("Cas normaux :");
		testCasVerifTab(new int[] {1}, 1, true);
		testCasVerifTab(new int[] {1, 2, 3, 5, -1}, 5, true);
		
		
		System.out.println("Cas d'erreurs :");
		testCasVerifTab(new int[] {1, 2, -1}, 5, false);
		int[] tab = null;
		testCasVerifTab(tab, 5, false);
	}
	
	//------------------------------------AFFICHER TAB------------------------------------
	/**
	 * Affiche le contenu des nbElem cases d'un tableau une par une
	 * @param leTab tableau à afficher
	 * @param nbElem nombre d'éléments du tableau a prendre en consideration
	 */
	void afficherTab(int[] leTab, int nbElem) {
		if (verifTab(leTab, nbElem)) {
			
			System.out.print('{');
			if (nbElem >= 2) {
				
				for (int i = 0 ; i < nbElem - 1 ; i++) {
					System.out.print(leTab[i] + ", ");
				}
				
				System.out.print(leTab[nbElem-1] + "}");
				
			} else {
				System.out.print(leTab[0] + "}");
			}
			
		}
	}
	
	/**
	 * JavaDoc : test de la méthode afficherTab()
	 * @param leTab tableau a afficher
	 * @param nbElem nombre d'éléments du tableau
	 */
	void testCasAfficherTab(int[] leTab, int nbElem) {
		
		// Affichage
		System.out.print("leTab = ");
		afficherTab(leTab, leTab.length);
		System.out.println();
		
		System.out.println("nbElem = " + nbElem);
		
		System.out.print("afficherTab(leTab, nbElem) \t= ");
		afficherTab(leTab, nbElem);
		System.out.println();
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasAfficherTab()
	 */
	void testAfficherTab() {
	
		
		System.out.println("*** résultats des tests de afficherTab() :");
		
		System.out.println("Cas normaux :");
		testCasAfficherTab(new int[] {1, 2, 3, 5, -1}, 3);
		testCasAfficherTab(new int[] {1, 2, -1}, 1);
		
		System.out.println("Cas limites :");
		testCasAfficherTab(new int[] {1}, 1);
		
		System.out.println("Cas d'erreur:");
		testCasAfficherTab(new int[] {1, 2, -1}, 5);
		testCasAfficherTab(new int[] {}, 5);
		
	}
	
	//------------------------------------TIRER ALEATOIRE------------------------------------
	/**
	 * Renvoie un entier aléatoire compris entre min et max (inclus)
	 * @param min minimum de l'intervalle
	 * @param max maximum de l'intervalle
	 * @return un entier aléatoire
	 */
	int tirerAleatoire(int min, int max) {
		
		int random = -1;
		
		if (min >= 0 && min <= max) {
			// On ajoute un dans la multiplication pour inclure le maximum de l'intervalle
			random = (int) (Math.random() * (max - min + 1) + min);
		} else {
			System.err.println("Erreur tirerAleatoire() : l'intervalle donner en paramètre est invalide");
		}
		
		return random;
	}
	
	/**
	 * JavaDoc : test de la méthode tirerAleatoire()
	 * @param min minimum de l'intervalle
	 * @param max maximum de l'intervalle
	 */
	void testCasTirerAleatoire(int min, int max) {
		
		// Affichage
		System.out.print("min = " + min + "\t max = " + max);
		System.out.println();
		
		int resultat = tirerAleatoire(min, max);
		System.out.print("tirerAleatoire(min, max) \t= " + resultat + "\t: ");
		
		// test si l'intervalle donné est valide ET si la valeur est bien comprise dans l'intervalle
		if ( (min >= 0 && min <= max) && (min <= resultat && resultat <= max) ) {
			System.out.println("OK");
		} else {
			System.err.println("ERREUR");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasTirerAleatoire()
	 */
	void testTirerAleatoire() {
	
		
		System.out.println("*** résultats des tests de tirerAleatoire() :");
		
		System.out.println("Cas normaux :");
		testCasTirerAleatoire(0, 1);
		testCasTirerAleatoire(50, 100);
		
		System.out.println("Cas limites :");
		testCasTirerAleatoire(1, 1);
		
		System.out.println("Cas d'erreurs :");
		testCasTirerAleatoire(-10, 2);
		testCasTirerAleatoire(-1000, -33);
	}
	
	//------------------------------------REMPLIR ALEATOIRE------------------------------------
	/**
	 * A partir d'un tableau créé, remplir aléatoirement ce tableau de nbElem valeurs comprises
	 * entre min et max.
	 * @param leTab tableau à remplir
	 * @param nbElem nombre délément à insérer
	 * @param min minimum de l'intervalle
	 * @param max maximum de l'intervalle
	 */
	void remplirAleatoire(int[] leTab, int nbElem, int min, int max) {
		
		// On vérifie que la tableau est valide
		if (verifTab(leTab, nbElem)) {
			
			// On vérifie que l'intervalle est lui aussi valide
			if (min >= 0 && min <= max) {
				int random;
				
				for (int i = 0 ; i < nbElem ; i++) {
					
					random = tirerAleatoire(min, max);
					leTab[i] = random;
				}
			} else {
				System.err.println("Erreur remplirAleatoire() : l'intervalle en paramètre est invalide");
			}
		}
	}
	
	/**
	 * JavaDoc : test de la méthode remplirAleatoire()
	 * @param leTab tableau à remplir aléatoirement
	 * @param nbElem nombre d'élément du tableau
	 * @param min minimum de l'intervalle
	 * @param max maximum de l'intervalle
	 */
	void testCasRemplirAleatoire(int[] leTab, int nbElem, int min, int max) {
		
		// Affichage
		System.out.print("leTab = ");
		afficherTab(leTab, leTab.length);
		System.out.println("\t nbElem = " + nbElem + "\t min = " + min + "\t max = " + max);
		
		System.out.print("remplirAleatoire(leTab, nbElem, min, max) \t= ");
		remplirAleatoire(leTab, nbElem, min, max);
		afficherTab(leTab, leTab.length);
		System.out.print("\t: ");
		
		// test si les valeurs sont bien comprises dans l'intervalle
		boolean error = false;
		
		for (int i = 0 ; i < nbElem ; i++) {
			if (leTab[i] < min || leTab[i] > max) {
				error = true;
			}
		}
		
		if (error) {
			System.out.println("ERREUR");
		} else {
			System.out.println("OK");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasRemplirAleatoire()
	 */
	void testRemplirAleatoire() {
	
		
		System.out.println("*** résultats des tests de remplirAleatoire() :");
		
		System.out.println("Cas normaux :");
		testCasRemplirAleatoire(new int[5], 5, 0, 1);
		testCasRemplirAleatoire(new int[1], 1, 0, 5);
		
		System.out.println("Cas limites :");
		testCasRemplirAleatoire(new int[6], 6, 5, 5);
		
		System.out.println("Cas d'erreurs :");
		testCasRemplirAleatoire(new int[7], 0, 0, 100);
		testCasRemplirAleatoire(new int[1], 0, 0, 10);
		testCasRemplirAleatoire(new int[6], 6, -1, 5);
		testCasRemplirAleatoire(new int[6], 6, 6, 5);
	}
	
	//------------------------------------EGALITE------------------------------------
	/**
	 * Renvoie vrai si les 2 tableaux passés en paramètre sont exactement les mêmes en nombre
	 * d'éléments et en contenu (case par case)
	 * @param tab1 premier tableau à comparer
	 * @param tab2 second tableau à comparer
	 * @param nbElem1 nombre d'élément de tab1
	 * @param nbElem2 nombre d'élément de tab2
	 * @return vrai si les 2 tableaux sont identiques faux sinon
	 */
	boolean egalite(int[] tab1, int[] tab2, int nbElem1, int nbElem2) {
		
		boolean identique;
		
		if (verifTab(tab1, nbElem1) && verifTab(tab2, nbElem2)) {
			identique = true;
			if (nbElem1 != nbElem2) {
				identique = false;
			} else {
				for (int i = 0 ; i < nbElem1 ; i++) {
					if (tab1[i] != tab2[i]) {
						identique = false;
					}
				}
			}
		} else {
			identique = false;
		}
		
		return identique;
	}
	
	/**
	 * JavaDoc : test de la méthode egalite()
	 * @param tab1 premier tableau à comparer
	 * @param tab2 deuxième tableau à comparer
	 * @param nbElem1 nombre d'élément du tableau 1
	 * @param nbElem2 nombre d'éléments du tableau 2
	 * @param resultat résultat attendu
	 */
	void testCasEgalite(int[] tab1, int[] tab2, int nbElem1, int nbElem2, boolean resultat) {
		
		// Affichage
		System.out.print("nbElem1 = " + nbElem1 + "\t tab1 = ");
		afficherTab(tab1, tab1.length);
		System.out.println();
		
		System.out.print("nbElem2 = " + nbElem2 + "\t tab2 = ");
		afficherTab(tab2, tab2.length);
		System.out.println();
		
		boolean resExec;
		resExec = egalite(tab1, tab2, nbElem1, nbElem2);
		System.out.print("egalite(tab1, tab2, nbElem1, nbElem2) \t= " + resExec);
		System.out.print("\t: ");
		
		if (resExec != resultat) {
			System.out.println("ERREUR");
		} else {
			System.out.println("OK");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasEgalite()
	 */
	void testEgalite() {
	
		
		System.out.println("*** résultats des tests de egalite() :");
		
		System.out.println("Cas normaux :");
		testCasEgalite(new int[5], new int[6], 5, 5, true);
		testCasEgalite(new int[5], new int[6], 3, 4, false);
		testCasEgalite(new int[1], new int[1], 1, 1, true);
		testCasEgalite(new int[] {1, 2, 3, 4, 7}, new int[] {1, 2, 3, 4, -7}, 5, 5, false);
		testCasEgalite(new int[] {1, 2, 3, 4, -7}, new int[] {1, 2, 3, 4, -7}, 3, 4, false);
		
		System.out.println("Cas d'erreurs :");
		testCasEgalite(new int[1], new int[0], 1, 1, false);
		
		
	}
	
	//------------------------------------COPIER------------------------------------
	/**
	 * Renvoie la copie exact du tableau passé en paramètre
	 * @param tabToCopy tableau à copier
	 * @param nbElem nombre d'élément à copier
	 * @return une copie du tableau
	 */
	int[] copier(int[] tabToCopy, int nbElem) {
		
		int[] copie = new int[nbElem];
		
		if (verifTab(tabToCopy, nbElem)) {
			for (int i = 0 ; i < nbElem ; i++) {
				copie[i] = tabToCopy[i];
			}
		}
		
		return copie;
	}
	
	/**
	 * JavaDoc : test de la méthode copier()
	 * @param tabToCopy tableau à copier
	 * @param nbElem nombre d'élément du tableau
	 * @param resultat résultat attendu
	 */
	void testCasCopier(int[] tabToCopy, int nbElem, int[] resultat) {
		
		// Affichage
		System.out.print("nbElem = " + nbElem + "\t tab1 = ");
		afficherTab(tabToCopy, tabToCopy.length);
		System.out.println();
		
		int[] resExec;
		resExec = copier(tabToCopy, nbElem);
		System.out.print("copier(tabToCopy, nbElem) \t= ");
		afficherTab(resExec, resExec.length);
		System.out.print("\t: ");
		
		if (egalite(resExec, resultat, resExec.length, nbElem)) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasCopier()
	 */
	void testCopier() {
	
		
		System.out.println("*** résultats des tests de copier() :");
		
		System.out.println("Cas normaux :");
		testCasCopier(new int[5], 5, new int[] {0, 0, 0, 0, 0});
		testCasCopier(new int[] {0, 1, 2, -3, 6, 1}, 4, new int[] {0, 1, 2, -3});
		testCasCopier(new int[1], 1, new int[] {0});
		
		System.out.println("Cas d'erreurs :");
		int[] tab = null;
		testCasCopier(tab, 1, new int[] {});
	}
	
	//------------------------------------LE MAX------------------------------------
	/**
	 * Renvoie le maximum parmis les éléments du tableau
	 * @param leTab tableau d'entier
	 * @param nbElem nombre d'entier du tableau
	 * @return le plus grand entier du tableau
	 */
	int leMax(int[] leTab, int nbElem) {
		
		// Le programme return l'équivalent de - l'infini dans le type entier lorsqu'il n'y pas de maximum trouvé c-a-d lorsque verifTab renvoie false (tableau invalide)
		int max = Integer.MIN_VALUE;
		
		if (verifTab(leTab, nbElem)) {
			max = leTab[0];
			for (int i = 1 ; i < nbElem ; i++) {
				if (leTab[i] > max) {
					max = leTab[i];
				}
			}
		}
		return max;
	}
	
	/**
	 * JavaDoc : test de la méthode leMax()
	 * @param leTab tableau d'entier
	 * @param nbElem nombre d'entier du tableau
	 * @param resultat résultat attendu
	 */
	void testCasLeMax(int[] leTab, int nbElem, int resultat) {
		
		// Affichage
		System.out.print("nbElem = " + nbElem + "\t leTab = ");
		afficherTab(leTab, leTab.length);
		System.out.println();
		
		int resExec;
		resExec = leMax(leTab, nbElem);
		System.out.print("leMax(leTab, nbElem) \t= " + resExec + "\t: ");
		
		if (resExec == resultat) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasLeMax()
	 */
	void testLeMax() {
	
		
		System.out.println("*** résultats des tests de leMax() :");
		
		System.out.println("Cas normaux :");
		testCasLeMax(new int[] {0, 1, 2, -3, 6, 1}, 4, 2);
		
		System.out.println("Cas limites :");
		testCasLeMax(new int[5], 5, 0);
		testCasLeMax(new int[] {8}, 1, 8);
		
		System.out.println("Cas d'erreurs :");
		testCasLeMax(new int[1], 0, Integer.MIN_VALUE);
	}
	
	//------------------------------------INVERSE------------------------------------
	/**
	 * Renvoie un nouveau tableau qui correspond au tableau passé en paramètre inversé
	 * @param leTab tableau d'entier à inverser
	 * @param nbElem nombre d'élément du tableau
	 * @return tableau inverse de leTab
	 */
	int[] inverse(int[] leTab, int nbElem) {
		
		int[] tab = new int[nbElem];
		if (verifTab(leTab, nbElem)) {
			for (int i = nbElem - 1 ; i >= 0 ; i--) {
				tab[nbElem - 1 - i] = leTab[i];
			}
		}
		
		return tab;
	}
	
	/**
	 * JavaDoc : test de la méthode inverse()
	 * @param leTab tableau d'entier à inverser
	 * @param nbElem nombre d'élément du tableau
	 * @param resultat résultat attendu
	 */
	void testCasInverse(int[] leTab, int nbElem, int[] resultat) {
		
		// Affichage
		System.out.print("nbElem = " + nbElem + "\t leTab = ");
		afficherTab(leTab, leTab.length);
		System.out.println();
		
		int[] resExec;
		resExec = inverse(leTab, nbElem);
		System.out.print("inverse(leTab, nbElem) \t= ");
		afficherTab(resExec, nbElem);
		System.out.print("\t: ");
		
		if (egalite(resExec, resultat, nbElem, nbElem)) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasInverse()
	 */
	void testInverse() {
	
		
		System.out.println("*** résultats des tests de inverse() :");
		
		System.out.println("Cas normaux :");
		testCasInverse(new int[] {7, 25, 64, 1, 8}, 5, new int[] {8, 1, 64, 25, 7});
		testCasInverse(new int[] {7, 25, 64, 1, 8}, 3, new int[] {64, 25, 7});
		
		System.out.println("Cas limites :");
		testCasInverse(new int[5], 5, new int[] {0, 0, 0, 0, 0});
		testCasInverse(new int[] {7}, 1, new int[] {7});
		
		System.out.println("Cas d'erreurs :");
		testCasInverse(new int[] {}, 0, new int[] {});
		
	}
	
	//------------------------------------ECHANGE------------------------------------
	/**
	 * Echange le contenu des 2 cases du tableau passé en paramètre identifiées par leur indice.
	 * @param leTab tableau d'entier
	 * @param nbElem nombre d'élément du tableau
	 * @param ind1 indice de la première case du tableau à échanger
	 * @param ind2 indice de la deuxième case du tableau à échanger
	 */
	void echange(int[] leTab, int nbElem, int ind1, int ind2) {
		
		if ( verifTab(leTab, nbElem) ) {
			if ( (ind1 >= 0 && ind1 < nbElem) && (ind2 >= 0 && ind2 < nbElem) ) {
			
				int temp = leTab[ind1];
				leTab[ind1] = leTab[ind2];
				leTab[ind2] = temp;
			} else {
				System.err.println("Erreur echange() : le ou les indices fournis en paramètre ne sont pas compris dans l'intervalle [0;nbElem-1]");
			}
		}
	}
	
	/**
	 * JavaDoc : test de la méthode echange()
	 * @param leTab tableau d'entier
	 * @param nbElem nombre d'élément du tableau
	 * @param ind1 indice de la première case du tableau à échanger
	 * @param ind2 indice de la deuxième case du tableau à échanger
	 */
	void testCasEchange(int[] leTab, int nbElem, int ind1, int ind2) {
		
		// Affichage
		System.out.print("nbElem = " + nbElem + "\t leTab = ");
		afficherTab(leTab, nbElem);
		System.out.println("\t indice1 = " + ind1 + "\t indice2 = " + ind2);
		
		echange(leTab, nbElem, ind1, ind2);
		
		System.out.print("echange(leTab, nbElem, ind1, ind2) \t= ");
		afficherTab(leTab, nbElem);
		System.out.println();
		System.out.println();

	}
	
	/**
	 * Méthode appel des tests de la fonction testCasEchange()
	 */
	void testEchange() {
	
		
		System.out.println("*** résultats des tests de echange() :");
		
		System.out.println("Cas normaux :");
		testCasEchange(new int[] {4, 6, 16, 10, 12, 14, 8}, 7, 2, 6);
		testCasEchange(new int[] {4, 6, 16, 10, 12, 14, 8}, 4, 2, 0);
		testCasEchange(new int[] {4, 6, 16, 10, 12, 14, 8}, 7, 2, 7);
		
		System.out.println("Cas limites :");
		testCasEchange(new int[] {4}, 1, 0, 0);
	}
	
	//------------------------------------MELANGE------------------------------------
	/**
	 * Retourne un nouveau tableau qui a la même taille et les mêmes occurrences d'élements
	 * mais répartie de facon aléatoire
	 * @param leTab tableau à mélanger
	 * @param nbElem nombre d'élément du tableau
	 * @return le tableau mélangé
	 */
	int[] melange(int[] leTab, int nbElem) {
		
		int[] melanger = null;
		
		if ( verifTab(leTab, nbElem) ) {
			melanger = new int[nbElem];
			int indAlea;
			
			// tableau qui stock les indices utilisé déjà utilisé dans 
			int[] tab_indice = new int[nbElem];
			int nbIndice = 0;
			boolean indiceValide;
			
			for (int i = 0 ; i < nbElem ; i++) {
				
				do {
					indiceValide = true;
					indAlea = tirerAleatoire(0, nbElem - 1);
					for (int j = 0 ; j < nbIndice ; j++) {
						if ( tab_indice[j] == indAlea ) {
							indiceValide = false;
						}
					}
				} while (!indiceValide);
				
				// On met à jour le tableau qui stock les indices avec le nombre d'indice utilisé qu'on incrémente
				tab_indice[nbIndice] = indAlea;
				nbIndice += 1;
				
				melanger[indAlea] = leTab[i];
			}
		
		
		}
		return melanger;
	}
	
	/**
	 * JavaDoc : test la méthode melange()
	 * @param leTab tableau à mélanger
	 * @param nbElem nombre d'élément du tableau
	 */
	void testCasMelange(int[] leTab, int nbElem) {
		
		// Affichage
		System.out.print("nbElem = " + nbElem + "\t leTab = ");
		afficherTab(leTab, nbElem);
		System.out.println();
		
		int[] resultat = melange(leTab, nbElem);
		
		System.out.print("melange(leTab, nbElem) \t= ");
		afficherTab(resultat, nbElem);
		System.out.println();
		System.out.println();

	}
	
	/**
	 * Méthode appel des tests de la fonction testCasMelange()
	 */
	void testMelange() {
	
		
		System.out.println("*** résultats des tests de melange() :");
		
		System.out.println("Cas normaux :");
		testCasMelange(new int[] {4, 6, 16, 10, 12, 14, 8}, 7);
		testCasMelange(new int[] {4, 6, 16, 10, 12, 14, 8}, 4);
		testCasMelange(new int[] {8, 6, 16, 8, 12, 14, 8}, 7);
		
		System.out.println("Cas limites :");
		testCasMelange(new int[] {4}, 1);
		
		System.out.println("Cas d'erreurs :");
		testCasMelange(new int[] {4, 6, 16, 10, 12, 14, 8}, 8);
		testCasMelange(null, 8);
	}
	
	//------------------------------------DECALER GAUCHE------------------------------------
	/**
	 * Décale, à partir d'un certain indice, tous les éléments d'un indice vers la gauche
	 * @param leTab tableau à décaler
	 * @param nbElem nombre d'élément du tableau
	 * @param ind indice à partir duquel il faut procéder au décalage (superieur ou egal à 0 et inferieur ou egal à nbElem-2)
	 */
	void decalerGche(int[] leTab, int nbElem, int ind) {
		
		if ( verifTab(leTab, nbElem) ) {
			if ( ind >= 0 && ind <= nbElem - 2) {
				for (int i = ind ; i < nbElem-1 ; i++) {
					leTab[i] = leTab[i+1];
				}
				
				// On considère que -1 représente la valeur du tableau qui a été écrasée
				leTab[nbElem-1] = -1; 
				nbElem -= 1;
				
			} else {
				System.err.println("Erreur decalerGche() : l'indice fournis est invalide");
			}
		}
	}
	
	/**
	 * JavaDoc : test la méthode decalerGche()
	 * @param leTab tableau d'entier
	 * @param nbElem nombre d'élément du tableau
	 * @param ind indice a partir duquel on procède au décalage
	 */
	void testCasDecalerGche(int[] leTab, int nbElem, int ind) {
		
		// Affichage
		System.out.print("nbElem = " + nbElem + "\t ind = "+ ind +"\t leTab = ");
		afficherTab(leTab, leTab.length);
		System.out.println();
		
		decalerGche(leTab, nbElem, ind);
		
		System.out.print("decalerGche(leTab, nbElem, ind) \t= ");
		afficherTab(leTab, leTab.length);
		System.out.print("\t nbElem = " + nbElem);
		System.out.println();
		System.out.println();

	}
	
	/**
	 * Méthode appel des tests de la fonction testCasDecalerGche()
	 */
	void testDecalerGche() {
	
		
		System.out.println("*** résultats des tests de decalerGche() :");
		
		System.out.println("Cas normaux :");
		testCasDecalerGche(new int[] {4, 8, 3, 12, 7, 9}, 6, 2);
		testCasDecalerGche(new int[] {4, 8, 3, 12, 7, 9, 5, 5, 13}, 7, 0);
		
		System.out.println("Cas limites :");
		testCasDecalerGche(new int[] {4, 8}, 2, 0);
		testCasDecalerGche(new int[] {4, 8, 3, 12, 7, 9}, 6, 4);
		
		System.out.println("Cas d'erreurs :");
		testCasDecalerGche(new int[] {4}, 1, 0);
		testCasDecalerGche(new int[] {4, 8, 3, 12, 7, 9}, 6, 5);
		testCasDecalerGche(new int[] {4, 8, 3, 12, 7, 9, 5, 5, 13}, 10, 0);
	}
	
	//------------------------------------SUPPRIMER UNE VALEUR------------------------------------
	/**
	 * Supprime une valeur choisie et décale les autres valeur du tableau en conséquence. Retourne
	 * le nombre d'élément du tableau.
	 * @param leTab tableau d'entier
	 * @param nbElem nombre d'élément du tableau
	 * @param valeur valeur à supprimer du tableau ssi celle si est présente
	 * @return le nombre d'élément du tableau après exécution
	 */
	int supprimerUneValeur(int[] leTab, int nbElem, int valeur) {
		
		int retour = -1; // valeur par défaut retoiurner si verifTab est à Faux
		
		if ( verifTab(leTab, nbElem) ) {
			
			int i = 0;
			boolean suppr = false;
			
			while ( !suppr && i < nbElem-1 ) {
				
				if (leTab[i] == valeur) {
					decalerGche(leTab, nbElem, i);
					
					// Etant donné que le paramètre nbElem est de type primitif, ce dernier est
					// donc passer en paramètre par valeur. C'est la raison pour laquelle on doit
					// décrémenter nbElem même si cela est sensé être déjà fait dans la méthode decalerGche()
					nbElem -= 1;
					suppr = true;
				}
				
				i += 1;
			}
			
			if (!suppr && (leTab[i] == valeur) ) {
				nbElem -= 1;
			}
			
			retour = nbElem;
		}
		
		return retour;
	}
	
	/**
	 * JavaDoc : test la méthode supprimerUneValeur()
	 * @param leTab tableau d'entier
	 * @param nbElem nombre d'élément du tableau
	 * @param valeur valeur à supprimer du tableau ssi celle si est présente
	 * @param resultat résultat attendu
	 */
	void testCasSupprimerUneValeur(int[] leTab, int nbElem, int valeur, int resultat) {
		
		// Affichage
		System.out.print("nbElem = " + nbElem + "\t valeur = "+ valeur +"\t leTab = ");
		afficherTab(leTab, leTab.length);
		System.out.println();
		
		int resExec = supprimerUneValeur(leTab, nbElem, valeur);
		
		System.out.print("supprimerUneValeur(leTab, nbElem, valeur) \t= " + resExec + "\t: ");
		if (resExec == resultat) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
		System.out.print("leTab après exécution : ");
		afficherTab(leTab, leTab.length);
		System.out.println();
		System.out.println();
		
		
	}
	
	/**
	 * Méthode appel des tests de la fonction supprimerUneValeur()
	 */
	void testSupprimerUneValeur() {
	
		
		System.out.println("*** résultats des tests de supprimerUneValeur() :");
		
		System.out.println("Cas normaux :");
		testCasSupprimerUneValeur(new int[] {4, 8, 3, 12, 7, 9}, 6, 2, 6);
		testCasSupprimerUneValeur(new int[] {4, 8, 3, 12, 7, 9, 5, 5, 13}, 9, 5, 8);
		testCasSupprimerUneValeur(new int[] {4, 8, 3, 12, 7, 9}, 4, 7, 4);
		
		System.out.println("Cas limites :");
		testCasSupprimerUneValeur(new int[] {4}, 1, 4, 0);
		testCasSupprimerUneValeur(new int[] {4, 8, 3, 12, 7, 9}, 6, 9, 5);
		
		System.out.println("Cas d'erreurs :");
		testCasSupprimerUneValeur(new int[] {}, 1, 7, -1);
		testCasSupprimerUneValeur(new int[] {4, 8, 3, 12, 7, 9}, 7, 5, -1);
	}
	
	//------------------------------------INCLUSION------------------------------------
	/**
	 * Renvoie vrai si tous les éléments de tab1 sont inclu dans tab2 peut importe leur 
	 * ordre d'apparition en preant compte des occurences faux sinon
	 * @param tab1 premier tableau
	 * @param tab2 second tableau
	 * @param nbElem1 nombre d'élément du premier tableau
	 * @param nbElem2 nombre d'élément du second tableau
	 * @return vrai ss tab1 est inclus dans tab2
	 */
	boolean inclusion(int[] tab1, int[] tab2, int nbElem1, int nbElem2) {
		
		boolean inclu = false;
		
		if ( verifTab(tab1, nbElem1) && verifTab(tab2, nbElem2) && nbElem1 <= nbElem2 ){
			
			//On créer une copie de tab2 pour ne pas modifier le tableau d'origine
			int[] tab2copy = new int[nbElem2];
			for (int i = 0 ; i < nbElem2 ; i++) {
				tab2copy[i] = tab2[i];
			}
			
			int i = 0;
			inclu = true; // On met à true pour rentré dans la boucle while
			
			while (inclu && i < nbElem1) {
				inclu = false; 
				
				for (int j = 0 ; j < nbElem2 ; j++) {
					if (tab1[i] == tab2copy[j]) {
						inclu = true;
						tab2copy[j] = Integer.MIN_VALUE; // On décide de mettre une valeur qui possède sa paire dans tab1 à - l'infini pour s'assurer de prendre en compte les éventuelles multiples occurences de valeurs
						
					}
				}
				i += 1;
			}
		}
		return inclu;
	}
	
	/**
	 * JavaDoc : test de la méthode inclusion()
	 * @param tab1 premier tableau à comparer
	 * @param tab2 deuxième tableau à comparer
	 * @param nbElem1 nombre d'élément du tableau 1
	 * @param nbElem2 nombre d'éléments du tableau 2
	 * @param resultat résultat attendu
	 */
	void testCasInclusion(int[] tab1, int[] tab2, int nbElem1, int nbElem2, boolean resultat) {
		
		// Affichage
		System.out.print("nbElem1 = " + nbElem1 + "\t tab1 = ");
		afficherTab(tab1, tab1.length);
		System.out.println();
		
		System.out.print("nbElem2 = " + nbElem2 + "\t tab2 = ");
		afficherTab(tab2, tab2.length);
		System.out.println();
		
		boolean resExec;
		resExec = inclusion(tab1, tab2, nbElem1, nbElem2);
		System.out.print("inclusion(tab1, tab2, nbElem1, nbElem2) \t= " + resExec);
		System.out.print("\t: ");
		
		if (resExec != resultat) {
			System.out.println("ERREUR");
		} else {
			System.out.println("OK");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasInclusion()
	 */
	void testInclusion() {
	
		
		System.out.println("*** résultats des tests de inclusion() :");
		
		System.out.println("Cas normaux :");
		testCasInclusion(new int[] {0, 2, 4}, new int[] {0, 1, 2, 3, 4, 5, 6}, 3, 7, true);
		testCasInclusion(new int[] {0, 1, 2, 3, 4, 5, 6}, new int[] {0, 1, 2, 3, 4, 5, 6}, 7, 7, true);
		
		
		System.out.println("Cas limites :");
		testCasInclusion(new int[] {0, 1, 2, 3, 4, 5, 6}, new int[] {0, 1, 2, 3, 4}, 7, 5, false);
		
		System.out.println("Cas d'erreurs :");
		testCasInclusion(new int[] {}, new int[] {0, 1, 2, 3, 4, 5, 6}, 1, 7, false);
		
	}
	
	//------------------------------------REMPLIR TOUTES DIFF------------------------------------
	/**
	 * A partir d'un tableau déjà créer, demande à l'utilisateur d'insérer des valeur au choix
	 * @param leTab tableau à compléter
	 * @param nbElem nombre de valeur à insérer
	 */
	void remplirToutesDiff(int[] leTab, int nbElem) {
		if (verifTab(leTab, nbElem)) {
			for (int i = 0 ; i < nbElem ; i++) {
				System.out.println("Nombre d'élément restant à entrer : " + (nbElem - i));
				leTab[i] = SimpleInput.getInt("Entrez un entier quelconque : ");
				System.out.print("leTab = ");
				afficherTab(leTab, i+1);
				System.out.println();
				System.out.println();
			}
		}
	}
	
	/**
	 * Méthode appel des tests de la fonction remplirToutesDiff()
	 */
	void testRemplirToutesDiff() {
		remplirToutesDiff(new int[4], 4);
	}
}	
