class Ex1 {
	void principal() {
		System.out.println(combinaison(11, 12));
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
