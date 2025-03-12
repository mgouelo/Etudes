/**
 * décale d'un indice toutes les valeurs du tableau version while
 * @author
 */
/*
class Ex1 {
	void principal() {
		
		int[] tab = {5, 7, 0, 6, 10, 8, 4, 1};
		int val = tab[tab.length-1];
		int i = tab.length-1;
		
		System.out.print("Avant décalage : tab = ");
		displayTab(tab);
		
		while (i > 0){
			tab[i] = tab[i-1];
			i -= 1;
		}
		tab[0] = val;
		System.out.print("Après décalage : tab = ");
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
/*
/**
 * décale d'un indice toutes les valeurs du tableau version for
 * @author
 */

class Ex1 {
	void principal() {
		
		int[] tab = {5, 7, 0, 6, 10, 8, 4, 1};
		int val = tab[tab.length-1];
		
		System.out.print("Avant décalage : tab = ");
		displayTab(tab);
		
		for (int i = tab.length-1 ; i > 0 ; i--){
			tab[i] = tab[i-1];
		}
		
		tab[0] = val;
		System.out.print("Après décalage : tab = ");
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
