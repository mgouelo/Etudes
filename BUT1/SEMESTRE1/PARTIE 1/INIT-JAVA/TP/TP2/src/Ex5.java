/**
 * L'utilisateur doit deviner le nombre "choisi" par l'ordinateur.
 * @author
 */

class Ex5 {
	void principal() {
		
		int nbChoisi = (int) (Math.random() * 100);
		int nbEntre;
		
		System.out.println("Je choisi un nombre entre 0 et 99... Essayez de le deviner!");
		
		do {
			nbEntre = SimpleInput.getInt("Entrez un nombre : ");
			if (nbEntre > nbChoisi) {
				System.out.println("Trop grand !");
			} else if (nbEntre < nbChoisi) {
				System.out.println("Trop petit !");
			}
		} while (nbEntre != nbChoisi);
		
		System.out.println("Bingo !");
	}
}
