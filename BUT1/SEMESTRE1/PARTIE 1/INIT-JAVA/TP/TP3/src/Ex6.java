class Ex6 {
	void principal() {
		
		int nb;
		int nbEtape = 0;
		
		do {
			nb = SimpleInput.getInt("Entrez un nombre entier strictement positif : ");
		} while (nb <= 0);
		
		int nbMax = nb;
		
		while (nb != 1) {
			if (nb % 2 == 0) {
				nb = nb / 2;
				nbEtape += 1;
			} else {
				nb = nb * 3 + 1;
				nbEtape += 1;
				if (nb > nbMax) {
					nbMax = nb;
				}
			}
		}
		System.out.print("Il aura fallu "+ nbEtape 
		+" étapes pour arriver à 1. Le nombre maximum rencontré est "+ nbMax);
	}
}
