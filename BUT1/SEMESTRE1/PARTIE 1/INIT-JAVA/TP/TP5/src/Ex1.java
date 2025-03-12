class Ex1 {
	void principal() {
		testSontTousDiff();
	}
	
	/**
	* vérifie si deux tableaux n’ont aucune valeur commune
	* @param tab1 premier tableau
	* @param tab2 deuxième tableau
	* @return vrai si les tableaux tab1 et tab2 n’ont aucune valeur commune, faux sinon
	*/
	boolean sontTousDiff (int[] tab1, int[] tab2) {
		boolean different = true;
		for (int i = 0 ; i < tab1.length ; i++) {
			for (int j = 0 ; j < tab2.length ; j++) {
				if (tab1[i] == tab2[j]) {
					different = false;
				}
			}
		}
		return different;
	}
	
	
	/**
	* Teste la méthode sontTousDiff()
	*/
	void testSontTousDiff () {
		System.out.println ();
		System.out.println ("*** testSontTousDiff()");
		testCasSontTousDiff  (new int[] {0, 1, 2, 5, 3, 3}, new int[] {-1, 6, 8}, true);
		testCasSontTousDiff  (new int[] {0, 1, 2, 5, 3, 3}, new int[] {3}, false);
		testCasSontTousDiff  (new int[] {3}, new int[] {-1}, true);
		testCasSontTousDiff  (new int[] {}, new int[] {}, true);
		testCasSontTousDiff  (new int[] {0, 1, 2, 5, 3, 3}, new int[] {-1, 6, 8}, true);
	}
	
	/**
	* teste un appel de sontTousDiff
	* @param tab1 premier tableau à comparer 
	* @param tab2 deuxième tableau à comparer
	* @param result resultat attendu
	*/
	void testCasSontTousDiff (int[] tab1, int[] tab2, boolean result) {
		
		// Affichage
		System.out.print ("sontTousDiff (" );
		displayTab(tab1);
		System.out.print(", ");
		displayTab(tab2);
		System.out.print(") \t= " + result + "\t : ");
		
		// Appel
		boolean resExec = sontTousDiff(tab1, tab2);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
			
		} else {
			System.err.println ("ERREUR");
		}
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
			System.out.print(t[i]+"}");
		}
	}
}	

