/**
 * Demande un nombre à l'utilisateur tant que le nombre précédent est inferieur au nouveau
 * @author
 */

class Ex3 {
	void principal() {
		
		int oldNb = SimpleInput.getInt("Donner une valeur : ");
		int nb = SimpleInput.getInt("Donner une nouvelle valeur : ");
		
		while (oldNb < nb) {
			oldNb = nb;
			nb = SimpleInput.getInt("Donner une nouvelle valeur : ");
		}
		
		System.out.println("La valeur précédente "+ oldNb +" est superieur à la nouvelle valeur "+ nb);
	}
}
