class Ex2 {
	void principal() {
		int [] tab = {3, 10, 6, 20, 7};
		System.out.print("Avant décalage : ");
		displayTab(tab);
		System.out.println();
		System.out.print("Après décalage : ");
		decalerGauche(tab);
		displayTab(tab);
		System.out.println();
		System.out.println();
		
		
		int [] tab2 = {3, 10, 6, 20, 7};
		int [] tab21 = {3};
		System.out.print("Avant n décalage : ");
		displayTab(tab2);
		displayTab(tab21);
		System.out.println();
		System.out.print("Après n décalage : ");
		decalerGaucheN(tab2, 3);
		displayTab(tab2);
		decalerGaucheN(tab21, 3);
		displayTab(tab21);
		System.out.println();
		System.out.println();
		
		
		int [] tab3 = {3, 10, 6, 20, 7};
		int [] tab31 = {3, 10, -6, 20, 7};
		int valeur = 6;
		System.out.println("On cherche la valeur "+valeur);
		int indice = indiceTab(tab3, valeur);
		int indice2 = indiceTab(tab31, valeur);
		System.out.print("indiceTab(new int[] = ");
		displayTab(tab3);
		System.out.print(", "+valeur+") nous retourne : "+indice);
		System.out.println();
		System.out.print("indiceTab(new int[] = ");
		displayTab(tab31);
		System.out.print(", "+valeur+") nous retourne : "+indice2);
		System.out.println();
		System.out.println();
		
		
		
		int [] tab4 = {3, 10, 6, 20, 7};
		System.out.print("Avant application de decaleValeur() : tab = ");
		displayTab(tab4);
		int val = 20;
		System.out.println();
		System.out.println("On choisi la valeur "+ val +".Après application de decalValeur() : ");
		decaleValeur(tab4, val);
		System.out.print("tab = ");
		displayTab(tab4);
		System.out.println();
		System.out.println();
		
	}
	
	/**
	* décale les entiers d’un tableau d’une position vers la gauche
	* L’élément en 0 se retrouve à la fin du tableau
	* @param tab tableau d’entiers
	*/
	void decalerGauche (int[] tab) {
		int temp = tab[0];
		for (int i = 1 ; i < tab.length ; i++) {
			tab[i-1] = tab[i];
		}
		tab[tab.length-1] = temp;
	}
	
	
	/**
	* décale les entiers d’un tableau de n positions vers la gauche
	* @param tab tableau d’entiers
	* @param n entier nombre de cases à décaler
	*/
	void decalerGaucheN (int[] tab, int n) {
		for (int i = 1 ; i <= n ; i++){
			decalerGauche(tab);
		}
	}
	
	
	/**
	* cherche l’indice de la premiere occurrence d’une valeur dans un tableau
	* @param tab tableau d’entiers
	* @param v valeur à chercher
	* @return l’indice de la première valeur v dans tab si v est dans tab, -1 sinon
	*/
	int indiceTab (int[] tab, int v) {
		int indice = -1;
		for (int i = 0 ; i < tab.length ; i++){
			if (tab[i] == v && indice == -1) {
				indice = i;
			}
		}
		return indice;
	}
	
	
	/**
	* décale les valeurs d’un tableau de manière à ramener la valeur cherchée
	* à l’indice 0
	* Si la valeur n’est pas présente, le tableau n’est pas modifié
	* @param tab tableau d’entiers
	* @param v valeur à chercher
	*/
	void decaleValeur (int[] tab, int v) {
		if (indiceTab(tab, v) != -1) {
			int n = indiceTab(tab, v);
			for (int i = 1 ; i <= n ; i++) {
				decalerGaucheN(tab, n);
			}
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
