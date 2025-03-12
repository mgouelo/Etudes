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
