class Ex5 {
	void principal() {
		
		int[] tab = new int[10];
		int nbAleatoire;
		
		for (int i = 1 ; i <= 1000 ; i++) {
			nbAleatoire = (int) (Math.random() * 10);
			tab[nbAleatoire] += 1;
		}
		
		System.out.print("Après éxécution : tab = ");
		displayTab(tab);
		
	}
	
	
	void displayTab(int[] t){
		int i = 0;
		System.out.print("{");
		
		while(i<t.length-1){
			System.out.print(t[i] + ",");
			i=i+1;
		}
		
		System.out.println(t[i]+"}");
	}
}
