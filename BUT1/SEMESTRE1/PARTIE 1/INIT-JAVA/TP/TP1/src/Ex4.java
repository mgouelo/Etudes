/**
 * Simulation du Bowling en Java
 */

class Ex4{
	void principal(){
		
		int nbQuille;
		int lance2;
		nbQuille = SimpleInput.getInt("Nombre de quille tombée au 1er lancé : ");
		
		if (nbQuille > 10 || nbQuille < 0) {
			System.out.println("Erreur, nombre incorect");
		} else {
			if (nbQuille == 10) {
					System.out.println("Strike !");
			} else {
				lance2 = SimpleInput.getInt("Nombre de quille tombée au 2e lancé : ");
				if (lance2 > 10 || lance2 < 0) {
					System.out.println("Erreur, nombre incorect");
				} else {
					nbQuille += lance2;
					if (nbQuille == 10) {
						System.out.println("Spare !");
					} else {
						System.out.print("Nombre total de quille tombée : "+ nbQuille);
					}
				}
			}
		}
	}
}
