/*
class Ex4 {
	void principal() {
		
		int serieMax = 1;
		int serie = 1;
		int indiceSerieMax = 0;
		int[] tab = {5, 7, 0, 6, 10, 8, 4, 1};
		int[] tab = {5, 7, 0, 6, 10, 8, 4, 1, 5, 6, 10};
		int[] tab = {55, 7, 6, 5, -10, -80, -400, -1000};
		
		boolean sequence = true;
		
		System.out.print("tab = ");
		displayTab(tab);
		
		for (int i = 0 ; i < tab.length-1 ; i++) {
			if (sequence == false) {
				if (serie > serieMax) {
					serieMax = serie;
					indiceSerieMax = i - serie;	
				}
				sequence = true;
				serie = 1;
			}
			
			if (tab[i+1] >= tab[i]) {
				serie += 1;	
			} else {
				sequence = false;
			}
			
		}
		if (serie > serieMax) {
			serieMax = serie;
			indiceSerieMax = tab.length - serie;
		}
		
		System.out.print("La série la plus longue est de longueur "+serieMax+
		" et commence à l'indice "+indiceSerieMax+ " et se termine à l'indice "+ (indiceSerieMax + serieMax-1));	
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
*/





/**
 * Renvoie la longueur de la plus grande séquence avec son indice version while
 * @author
 */

class Ex4 {
	void principal() {
		
		int i = 0;
		int serieMax = 1;
		int serie = 1;
		/*int[] tab = {1, 2, 3, 4, 3, 2, 1};*/
		/*int[] tab = {5, 7, 0, 6, 10, 8, 4, 1, 5, 6, 10};*/
		int[] tab = {1};
		int indiceSerieMax = 0;
		
		System.out.print("tab = ");
		displayTab(tab);
		
		while (i < tab.length-1 && (tab.length-1 - i > serieMax - serie) ) { 
			
			if (serie > serieMax) {
				serieMax = serie;
				indiceSerieMax = i+1 - serie;
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
			indiceSerieMax = tab.length - serie;
		}
		System.out.println("La série la plus longue est de longueur "+serieMax+
		" et commence à l'indice "+indiceSerieMax+ " et se termine à l'indice "+ (indiceSerieMax + serieMax-1));
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
