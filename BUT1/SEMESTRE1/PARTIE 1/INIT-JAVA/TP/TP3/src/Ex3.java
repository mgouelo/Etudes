/**
 * Renvoie la longueur de la plus grande séquence avec son indice version while
 * @author
 */

class Ex3 {
	void principal() {
		
		int i = 0;
		int serieMax = 1;
		int serie = 1;
		int[] tab = {1, 2, 3, 4, 3, 2, 1};
		
		System.out.print("tab = ");
		displayTab(tab);
		
		while (i < tab.length-1 && (tab.length-1 - i > serieMax - serie) ) { 
			/* Dans cette condition de continuation on vérifie si le nombre de valeur
			 * restante (tab.length-1 - i) est suffisant pour dépasser la sérieMax 
			 * en prenant en compte la valeur de la serie en cours */
			
			if (serie > serieMax) {
				serieMax = serie;
			}
			
			if (tab[i+1] >= tab[i]) {
				serie += 1;	
			} else {
				serie = 1;
			}
			
			i += 1;
		}
		
		if (serie > serieMax) {
			serieMax = serie;
		}
		System.out.println("La série la plus longue est de longueur : "+serieMax);
		System.out.print("i = "+i);	
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
