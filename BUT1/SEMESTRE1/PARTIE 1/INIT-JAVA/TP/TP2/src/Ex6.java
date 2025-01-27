/**
 * Le programme devine le nombre choisi par l'utilisateur entre 0 et 1000
 * @author
 */
/*
class Ex6 {
	void principal() {
		
		int nbPropose = (int)(Math.random()*1001);
		char reponseUtilisateur;
		int borneD = 1000;
		int borneG = 0;
		int essais = 0;
		
		System.out.println("Pensez à un nombre entre 0 et 1000...");
		
		do {
			reponseUtilisateur = SimpleInput.getChar("Votre est nombre est-il "
			+ nbPropose +" ?");
			essais += 1;
			
			if (reponseUtilisateur == '+') {
				borneG = nbPropose;
				nbPropose = (int)(Math.random()*(borneD-borneG)) + borneG;
				
			} else if (reponseUtilisateur == '-') {
				borneD = nbPropose;
				nbPropose = (int)(Math.random()*(borneD-borneG)) + borneG;
			}
		} while (reponseUtilisateur != '=');
		
		System.out.println("Le nombre était donc "+ nbPropose +". Je l'ai trouvé en "+
		essais +" essais.");
	}
}
*/



/**
 * Le programme devine le nombre choisi par l'utilisateur entre 0 et 1000 et déduit 
 * le nombre choisi lorsque
 * @author
 */


class Ex6 {
	void principal() {
		
		int nbPropose = (int)(Math.random()*1001);
		char reponseUtilisateur;
		int borneD = 1000;
		int borneG = 0;
		int essais = 0;
		
		System.out.println("Pensez à un nombre entre 0 et 1000...");
		
		do {
			reponseUtilisateur = SimpleInput.getChar("Votre est nombre est-il "
			+ nbPropose +" ?");
			essais += 1;
			
			if (borneD - borneG == 2) {
				nbPropose = borneD - 1;
			}
			
			else if (reponseUtilisateur == '+') {
				borneG = nbPropose;
				nbPropose = (int)(Math.random()*(borneD-borneG)) + borneG;
				
			} else if (reponseUtilisateur == '-') {
				borneD = nbPropose;
				nbPropose = (int)(Math.random()*(borneD-borneG)) + borneG;
			}

		} while (reponseUtilisateur != '=');
		
		System.out.println("Le nombre était donc "+ nbPropose +". Je l'ai trouvé en "+
		essais +" essais.");
	}
}
