/**
* Le programme retourne le PGCD des 2 nombres entrés par l'utilisateur
* @author M.Adam
*/


class Ex2 {
	void principal() {
		
		int val1;
		int val2;
		
		val1 = SimpleInput.getInt ("Première valeur : ");
		val2 = SimpleInput.getInt ("Deuxième valeur : ");
		
		while (val1 != val2) {
			if (val1 > val2) {
				val1 = val1 - val2;
				
			} else {
			val2 = val2 - val1;
			}
		}
		System.out.println("Le résultat est : " + val1);
	}
}



/**
* Calcul le PGCD entre val1 et val2 version while corrigé
* @author M.Adam
*/

/*
class Ex2 {
	void principal() {
		
		int val1;
		int val2;
		
		val1 = SimpleInput.getInt ("Première valeur : ");
		val2 = SimpleInput.getInt ("Deuxième valeur : ");
		
		while (val1 < 0 || val2 < 0) {
			System.out.println("Erreur, les nombres saisis doivent être strictement positif");
			val1 = SimpleInput.getInt ("Première valeur : ");
			val2 = SimpleInput.getInt ("Deuxième valeur : ");
		}
		
		while (val1 != val2) {
			if (val1 > val2) {
				val1 = val1 - val2;
				
			} else {
				val2 = val2 - val1;
			}
		}
		
		System.out.println("Le PGCD est " + val1);
	}
}
*/

/**
* Calcul le PGCD entre val1 et val2 version do-while
* @author M.Adam
*/

/*
class Ex2 {
	void principal() {
		
		int val1;
		int val2;
		
		do {
			val1 = SimpleInput.getInt ("Première valeur : ");
			val2 = SimpleInput.getInt ("Deuxième valeur : ");
			if (val1 < 0 || val2 < 0) {
				System.out.println("Erreur, les nombres saisis doivent être strictement positif");
			}
			
		} while (val1 < 0 || val2 < 0);
			
		do {
			if (val1 > val2) {
				val1 = val1 - val2;
				
			} else {
				val2 = val2 - val1;
			}
		} while (val1 != val2);
		
		
		System.out.println("Le PGCD est " + val1);
	}
}
*/
