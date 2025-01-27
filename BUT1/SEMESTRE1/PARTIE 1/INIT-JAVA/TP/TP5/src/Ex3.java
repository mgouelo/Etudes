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
