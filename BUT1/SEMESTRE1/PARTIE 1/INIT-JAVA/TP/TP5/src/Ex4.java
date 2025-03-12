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
