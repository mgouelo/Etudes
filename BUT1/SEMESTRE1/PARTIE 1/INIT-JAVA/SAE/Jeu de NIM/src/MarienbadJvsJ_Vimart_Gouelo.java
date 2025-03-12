/**
* Programme java simulant le jeu de Marienbad, joueur contre joueur.
* @author Matthieu Gouélo & Léa Vimart
*/

class MarienbadJvsJ_Vimart_Gouelo {
	void principal() {
		
		// Affichage au lancement
		System.out.println("--------------------------- Jeu de NIM ---------------------------");
		
		// Règles du jeu
		
		System.out.println("Règles du jeu :");
		System.out.println("Quatre rangées d'allumettes (ou plus) sont disposées devant les 2 joueurs.");
		System.out.println("À chaque tour, dans la ligne de son choix, le joueur retire le nombre d'allumettes qu'il souhaite, au moins une jusqu'a ce qu'il ne reste plus d'allumettes.");
		System.out.println("Le joueur qui prend la dernière allumette gagne la partie.");
		System.out.println("Bonne chance...");
		System.out.println();
		System.out.println();
		
		
		
		// Saisie des pseudos des joueurs 
		String joueur1 = SimpleInput.getString("Pseudos Joueur 1 : ");
		String joueur2 = SimpleInput.getString("Pseudos Joueur 2 : ");
		System.out.println();
		
		//Saisie du nombre de ligne
		
		int nbLigne;
		do {
			nbLigne = SimpleInput.getInt("Avec combien de ligne d'allumettes voulez-vous jouer  (minimum 4 et maximum 15) : ");
			
			if (nbLigne < 4 || nbLigne > 15){
				System.out.println("Erreur, le nombre de ligne doit être compris entre 4 et 15 !");
			}
			
		} while (nbLigne < 4 || nbLigne > 15);
		
		
		
		// Initialisation du tableau d'allumettes
        int[] allumettes = new int[nbLigne]; // chaque élément de allumettes correspond au nombre d'allumettes par ligne
        for (int i = 0; i < nbLigne; i++) {
            allumettes[i] = 2 * i + 1;
        }
        
        
		// Initialisation des variables pour le tour par tour
        int nbTour = 0;
        String joueurAjouer;
		
        // Boucle de jeu principale
        while (!jeuTermine(allumettes)) {
            nbTour += 1;  // Incrémente le nombre de tours

            // Alterne le joueur à chaque tour
            if (nbTour % 2 == 0) {
                joueurAjouer = joueur1;
            } else {
                joueurAjouer = joueur2;
            }

            System.out.println("\nTour numero : " + nbTour);
            affiche(allumettes);

            // Le joueur joue
            jouer(joueurAjouer, allumettes);
        }

        // Quand le jeu est terminé, on annonce le vainqueur
        if (nbTour % 2 == 0) {
            System.out.println("GG " + joueur1 + ", tu as gagne !");
        } else {
            System.out.println("GG " + joueur2 + ", tu as gagne !");
        }
    }
	
	/**
     * Méthode qui permet au joueur de faire un tour
     * @param joueur Le joueur qui joue actuellement
     * @param allumettes Tableau représentant le nombre d'allumettes par ligne
     */
    void jouer(String joueur, int[] allumettes) {
        System.out.println("Au tour de : " + joueur);
        // Appelle la méthode modification pour retirer les allumettes
        modification(allumettes);
    }
	
	/**
	 * modification permet de retirer un nombre choisi d'allumettes dans la ligne voulue
	 * @param allumettes tableau représentant le nombre d'allumette sur chaque ligne
	 * @return le tableau allumettes avec le nombre d'allumettes modifier
	 */
	int[] modification(int[] allumettes) {
		
		int numeroLigne;
		do {
			numeroLigne = SimpleInput.getInt("Quelle ligne souhaitez-vous modifier : ");
			
			if (numeroLigne < 0 || numeroLigne >= allumettes.length) {
				System.out.println("Erreur, le numéro de ligne est invalide.");
			} else if (allumettes[numeroLigne] == 0) {
            System.out.println("Erreur, il n'y a plus d'allumettes sur cette ligne.");
        }
			
		} while (numeroLigne < 0 || numeroLigne >= allumettes.length || allumettes[numeroLigne] == 0); // >= car sinon prend en compte ligne en trop
		
		
		int nbAllumettes;
		do {
			nbAllumettes = SimpleInput.getInt("Combien d'allumettes souhaitez vous retirer : ");
			
			if (nbAllumettes < 1 || nbAllumettes > allumettes[numeroLigne]) {
				System.out.println("Erreur, le nombre d'alumettes est invalide.");
			}
			
		} while (nbAllumettes < 1 || nbAllumettes > allumettes[numeroLigne]);
		
		allumettes[numeroLigne] -= nbAllumettes;
		return allumettes;
		
	}
	
    /**
     * Méthode qui permet d'afficher le jeu
     * @param allumettes Un tableau d'entiers représentant le nombre d'allumettes par ligne.
     */

	void affiche(int[] allumettes) {
		for (int i = 0; i < allumettes.length; i++) {
			System.out.print(i + " : ");
			for (int j = 0; j < allumettes[i]; j++) {
				System.out.print("| ");
			}
			// Passe à la ligne suivante
			System.out.println();
		}
	}
	
	boolean jeuTermine(int[] allumettes) {
    // Parcourt toutes les lignes
    for (int i = 0; i < allumettes.length; i++) {
        // Si une ligne contient encore des allumettes, le jeu n'est pas terminé
        if (allumettes[i] > 0) {
            return false;
        }
    }
    // Si aucune allumette n'est trouvée, le jeu est terminé
    return true;
	}
}
