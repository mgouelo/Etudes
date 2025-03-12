/**
 * Demande un nombre à l'utilisateur jusqu'a l'entrée de -1
 * @author mgouelo
 */

/*
class Ex1 {
	void principal() {
	
		System.out.println("Pour arrêter le programme tapez : -1");
		int nb = SimpleInput.getInt("Donner un nombre : ");
		
		while (nb != -1) {
			System.out.println(nb);
			nb = SimpleInput.getInt("Donner un nombre : ");
		}
		
		System.out.println("-1 n'est pas une valeur");
	}
}
*/


/**
 * Version avec do while
 */
 
/* 
class Ex1 {
	void principal() {
		
		System.out.println("Pour arrêter le programme tapez : -1");
		int nb;
		
		do {
			nb = SimpleInput.getInt("Donner un nombre : ");
			if (nb == -1) {
				System.out.println("-1 n'est pas une valeur");
			} else {
				System.out.println(nb);
			}
			
		} while (nb != -1);
	}
}
*/

/**
 * Demande un nombre à l'utilisateur jusqu'a l'entrée de -1 et renvoie la moyenne des nombres rentrés -1 exclus
 * @author mgouelo
 */


class Ex1 {
	void principal() {
		
		System.out.println("Pour arrêter le programme tapez : -1");
		int nb = SimpleInput.getInt("Donner un nombre : ");
		int affichage = 0;
		int total = 0;
		double moy;
		
		while (nb != -1) {
			System.out.println(nb);
			affichage += 1;
			total += nb;
			nb = SimpleInput.getInt("Donner un nombre : ");
		}
		
		System.out.println("-1 n'est pas une valeur");
		if (affichage > 0) {
			moy = (double)total/affichage;
			System.out.println("La moyenne des nombres rentrés : "+ moy);
		}
	}
}
