class Ex4 {
	void principal() {
		testEstCroissant();
	}
	
	void displayTab(int[] t){
		
		if (t.length == 0) {
			System.out.print("{}");
		} else {
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
	* Teste la méthode estCroissant()
	*/
	void testEstCroissant () {
		System.out.println ();
		System.out.println ("*** testEstCroissant()");
		testCasEstCroissant (new int[] {1, 2, 5, 9}, true);
		testCasEstCroissant (new int[] {-9, -7, -3, 0, 10, 11}, true);
		testCasEstCroissant (new int[] {5}, true);
		testCasEstCroissant (new int[] {7, -9, 8, 10}, false);
		testCasEstCroissant (new int[] {}, true);
	}
	
	
	/**
	* teste un appel de estCroissant
	* @param tab tableau d'entier
	* @param result resultat attendu
	*/
	void testCasEstCroissant (int[] tab, boolean result) {
		
		// Affichage
		System.out.print ("estCroissant (");
		displayTab(tab);
		System.out.print(") \t= " + result + "\t : ");
		
		// Appel
		boolean resExec = estCroissant(tab);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* teste si les valeurs d’un tableau sont triées par ordre croissant
	* @param t tableau d’entiers
	* @return vrai ssi les valeurs du tableau sont en ordre croissant
	*/
	boolean estCroissant(int[] tab) {
		
		boolean result = true;
		int i = 0;
		
		while (i < tab.length-1 && result) {
			if (tab[i] > tab[i+1]) {
				result = false;
			}
			i += 1;
		}
		return result;
	}
}
