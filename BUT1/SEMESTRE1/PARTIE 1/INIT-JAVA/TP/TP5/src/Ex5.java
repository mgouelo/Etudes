class Ex5 {
	
	final int LG_TAB = 5;
	
	void principal() {
		int[] tab;
		tab = saisirEtTrier();
	}
	
	/**
	* Crée et saisit un tableau trié de LG_TAB entiers
	* @return tableau trié de LG-TAB entiers
	*/
	int[] saisirEtTrier () {
		
		int[] t = new int[LG_TAB];
		int i = 0;
		int val;
		boolean modif = false;
		
		while (i < t.length) {
			val = SimpleInput.getInt ("Entrer un entier : ");
			
			// insertion de la valeur en ordre croissant dans t
			for (int j = 0 ; j < t.length ; j++) {
				
				if (t[j] >=  val && t[LG_TAB-1] == 0 && modif == false) {
					modif = true;
					for (int n = t.length-1 ; n > j ; n--) {
						t[n] = t[n-1];
					}
					t[j] = val;
				} 
				
				 else if (t[j] >=  val && t[0] == 0 && modif == false) {
					modif = true;
					for (int n = 0 ; n < j ; n++) {
						t[n] = t[n+1];
					}
					t[j] = val;
				}
			}
			if (modif == false) {
				modif = true;
				t[i] = val;
			}
			
			modif = false;
			displayTab(t);
			i = i + 1;
		}
		return t;
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
