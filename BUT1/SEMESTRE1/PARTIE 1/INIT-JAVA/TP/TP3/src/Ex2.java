/**
 * Renvoie le tableau avec le cummul des valeurs précédentes version while
 * @author
 */

class Ex2 {
	void principal() {
		/*int[] tab = {5, 7, 0, 6, 10, 8, 4, 1};*/
		int[] tab = {1};
		int i = 1;
		System.out.print("Avant : tab = ");
		displayTab(tab);
		
		while (i < tab.length) {
			tab[i] += tab[i-1];
			i += 1;
		}
		
		System.out.print("Après : tab = ");
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



/**
 * Renvoie le tableau avec le cummul des valeurs précédentes version for
 * @author
 */
/*
class Ex2 {
	void principal() {
		int[] tab = {5, 7, 0, 6, 10, 8, 4, 1};
		System.out.print("Avant : tab = ");
		displayTab(tab);
		
		for (int i = 1 ; i < tab.length; i++) {
			tab[i] += tab[i-1];
		}
		
		System.out.print("Après : tab = ");
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
*/
