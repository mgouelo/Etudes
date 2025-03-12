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
