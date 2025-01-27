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
