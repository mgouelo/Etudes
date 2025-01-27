/**
* Programme java simulant le jeu de Marienbad, joueur contre ordinateur.
* @author Matthieu Gouélo & Léa Vimart
*/

class MarienbadJvsO_Vimart_Gouelo {
	 void principal() {

        // Affichage au lancement
        System.out.println("--------------------------- Jeu de NIM ---------------------------");

        // Règles du jeu
        System.out.println("Regles du jeu :");
        System.out.println("Quatre rangees d'allumettes (ou plus) sont disposees devant les 2 joueurs.");
        System.out.println("A chaque tour, dans la ligne de son choix, le joueur retire le nombre d'allumettes qu'il souhaite, au moins une jusqu'a ce qu'il ne reste plus d'allumettes.");
        System.out.println("Le joueur qui prend la derniere allumette gagne la partie.");
        System.out.println("Bonne chance...");
        System.out.println();
        System.out.println();

		
		
		// Choix affichage méthode de test
        char methodeTest;
        
        do {
			methodeTest = SimpleInput.getChar("Avant de commencer à jouer souhaiter vous afficher les méthodes de tests ? (Y/N) : ");
		} while (methodeTest != 'Y' && methodeTest != 'N' && methodeTest != 'y' && methodeTest != 'n');
		
		if (methodeTest == 'Y' || methodeTest == 'y') {
			testTab_binaire();
			testJeuTermine();
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("Place au jeu !");
		System.out.println();
        // Saisie des pseudos des joueurs
        String joueur1;
        do {
            joueur1 = SimpleInput.getString("Pseudo Joueur 1 : ");
            
            if (joueur1 == "" || joueur1.length() < 3) {
                System.out.println("Erreur, le pseudos entre ne contient pas assez de caractere (3 min)");
            }
            
        } while (joueur1 == "" || joueur1.length() < 3);
        
        System.out.println();


        String joueur2 = "Ordinateur";


		System.out.println("Tirage au sort....");
        // Choix de qui commence
        String premierJoueur = tirageJoueurAleatoire(joueur1, joueur2);



        //Saisie du nombre de ligne
        int nbLigne;
        do {
            nbLigne = SimpleInput.getInt("Avec combien de ligne d'allumettes voulez-vous jouer  (minimum 2 et maximum 15) : ");

            if (nbLigne < 2 || nbLigne > 15) {
                System.out.println("Erreur, le nombre de ligne doit etre compris entre 2 et 15 !");
            }

        } while (nbLigne < 2 || nbLigne > 15);



        // Initialisation du tableau d'allumettes
        int[] allumettes = new int[nbLigne]; // chaque élément de allumettes correspond au nombre d'allumettes par ligne
        for (int i = 0; i < nbLigne; i++) {
            allumettes[i] = 2 * i + 1;
        }
        
        
        
        // Choix de la difficulté
        char difficulte;
        System.out.println("Voici les 2 difficultés du jeu :");
        System.out.println("\t\t Facile \t    Intermediaire");
        do {
			difficulte = SimpleInput.getChar("Souhaitez vous jouer en difficuluté intermédiaire ? (Y/N) : ");
		} while (difficulte != 'Y' && difficulte != 'N' && difficulte != 'y' && difficulte != 'n');
        


        // Initialisation des variables pour le tour par tour
		int nbTour = 1;
		String joueurAjouer = premierJoueur; // Commence avec le joueur tiré au sort



		// Boucle de jeu principale
		while (!jeuTermine(allumettes)) {
			System.out.println("\n--------------------Tour numero : " + nbTour + "--------------------");
			affiche(allumettes);
			
			jouer(joueurAjouer, allumettes, difficulte);
			
			// Alterne le joueur à chaque tour
			if (joueurAjouer.equals(joueur1)) {
				joueurAjouer = joueur2;
			} else {
				joueurAjouer = joueur1;
			}
			
			nbTour++;
		}

		// Quand le jeu est terminé, on annonce le vainqueur
		
		if (joueurAjouer.equals(joueur2)) {
			System.out.println("GG " + joueur1 + ", tu as gagné !");
		} else {
			System.out.println("L'ordinateur t'a battu, la honte !");
		}
	}
	
	
	
	/**
	 * Méthode qui permet tirer un joueur au hasard, celui qui va commencer la partie
	 * @param joueur1 Le joueur humain
	 * @param joueur2 Ordinateur																				//FAIRE METHODE TEST
	 * @return le joueur qui va commencer
	 */
	String tirageJoueurAleatoire(String joueur1, String joueur2) {
        // Génère un nombre aléatoire entre 0 et 1
        int result = (int) (Math.random() * 2);
        String joueurCommence;

        if (result == 0) {
            joueurCommence = joueur1;
        } else {
            joueurCommence = joueur2;
        }
        
        System.out.println(joueurCommence + " commence la partie !");

        return joueurCommence; 
    }



	/**
	 * Méthode qui permet au joueur ou à l'ordinateur de faire un tour
	 * @param joueur Le joueur qui joue actuellement
	 * @param allumettes Tableau représentant le nombre d'allumettes par ligne
	 */
	void jouer(String joueur, int[] allumettes, char difficulte) {
		System.out.println("Au tour de : " + joueur);
		
		if (joueur.equals("Ordinateur")) {
			if (difficulte == 'y' || difficulte == 'Y') {
				strategiePseudoAleatoire(allumettes);
			} else {
				strategieAleatoire(allumettes);
			}
		} else {
			modification(allumettes);
		}
	}


    
	/**
	 * Méthode qui convertit un nombre décimal en binaire (sous forme de chaîne)
	 * @param decimal un entier
	 * @return decimal en binaire
	 */
	String dec_to_bin(int decimal) {
		return Integer.toBinaryString(decimal); 
	}

	/**
	 * Méthode qui convertit un binaire en decimal (sous forme d'entier)
	 * @param binaire une string 
	 * @return binaire en décimal
	 */
	int bin_to_dec(String binaire) {
		return Integer.parseInt(binaire, 2);
	}
    
    
    
	// ----------------------------------- METHODE tab_binaire ET METHODE DE TEST -----------------------------------
	
    /**
     * Méthode qui permet de convertir un tableau décimal en tableau binaire
     * @param t tableau
     * @return un tableau avec la représentation binaire de chaque élément de t
     */
	String[] tab_binaire(int[] t) {
		String[] result = new String[t.length];

		// Formater chaque élément en binaire avec des zéros à gauche pour qu'ils aient la même longueur
		for (int i = 0; i < t.length; i++) {
			result[i] = String.format("%5s", dec_to_bin(t[i])).replace(' ', '0');
			
			//System.out.println("Binaire avec padding: " + result[i]);
		}

		return result;
	}
	
	
	/**
	* Teste la méthode tab_binaire()
	*/
	void testTab_binaire () {
		System.out.println ();
		System.out.println ("*** testTab_binaire()");
		testCasTab_binaire  (new int[] {1, 2, 3, 7}, new String[] {"00001", "00010", "00011", "00111"});
		testCasTab_binaire  (new int[] {0, 0, 14, 5}, new String[] {"00000", "00000", "01110", "00101"});
		testCasTab_binaire  (new int[] {}, new String[] {});
		testCasTab_binaire  (new int[] {31}, new String[] {"11111"});
	}
	
	/**
	* teste un appel de tab_binaire
	* @param tab1 tableau d'allumettes
	* @param result resultat attendu
	*/
	void testCasTab_binaire (int[] tab1, String[] result) {
		
		// Affichage
		System.out.print ("tab_binaire (");
		displayTabInt(tab1);
		System.out.print(") \t= ");
		displayTabString(result);
		System.out.print("\t : ");
		
		// Appel
		String[] resExec = tab_binaire(tab1);
		
		// Verification
		boolean identique = true;
		for (int i = 0 ; i < resExec.length ; i++) {
			for (int j = 0 ; j < resExec[i].length() ; j++) {
				if (resExec[i].charAt(j) != result[i].charAt(j)) {
					identique = false;
				}
			}
		}
		
		if (identique){
			System.out.println ("OK");
			
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	
	// --------------------------------------------------------------------------------------------------------------

	
	/**
     * Méthode qui permet de savoir qui peut gagner (quand tab_somme_binaire a au moins un élément impair)
     * @param tab_somme_binaire tableau de type int
     * @return un boolean pour savoir si oui le joueur peut gagner											//FAIRE METHODE TEST
     */
	boolean joueurPeutGagner(int[] tab_somme_binaire) {
		
		boolean res = false;
		
		for (int i = 0; i < tab_somme_binaire.length; i++) {
			if (tab_somme_binaire[i] % 2 == 1) {
				res = true;
			}
		}
		return res;
	}
	
	
	/**
     * Méthode qui permet de convertir un tableau décimal en tableau binaire
     * @param tab_source un tableau d'éléments type string (= tab représentation binaire d'allumettes)
     * @param tab_somme_binaire un tableau avec la représentation binaire de chaque élément de t
     */
	void sommeBinaire(String[] tab_source, int[] tab_somme_binaire) {
		
		for (int i = 0; i < tab_somme_binaire.length; i++) {
			for (int j = 0; j < tab_source.length; j++) {
				int bit = (int) tab_source[j].charAt(i) - '0';
				tab_somme_binaire[i] += bit;
			}
		}
	}
	
	
	/**
     * Méthode de la stratégie basée uniquement sur l'aléatoire
     * @param allumettes un tableau	représentant le nombre d'allumettes par lignes
     */
	void strategieAleatoire(int[] allumettes) {
		
		int ligne_retire;
		int nombre_retire;
		
		do {
			
			ligne_retire = (int) (Math.random() * allumettes.length);
			nombre_retire = (int) ((Math.random() * allumettes[ligne_retire]) + 1);
			
		} while(allumettes[ligne_retire] == 0 || allumettes[ligne_retire] - nombre_retire < 0);
			
		allumettes[ligne_retire] -= nombre_retire;
		
		System.out.println("L'ordinateur retire " + nombre_retire + " allumette(s) de la ligne " + ligne_retire); 
	}
	
	
	
	/**
     * Méthode qui permet de créer une stratégie gagnante
     * @param allumettes un tableau	nb bit
     */
	void strategiePseudoAleatoire(int[] allumettes) {
		// Création d'une copie de la liste d'allumettes
		
		int[] copie_allumettes = new int[allumettes.length];
		
		for (int i = 0; i < allumettes.length; i++) {
			copie_allumettes[i] = allumettes[i];
		}
		
		
		String[] copie_allumettes_string = tab_binaire(copie_allumettes);
		//displayTabString(copie_allumettes_string);
		
		// Calcul de la somme binaire
		int[] tab_somme_binaire = new int[copie_allumettes_string[0].length()];
		sommeBinaire(copie_allumettes_string, tab_somme_binaire);
		
		int ligne_retire = 0;
		int nombre_retire = 1;
		boolean arrete_jouer = false;
		
		int total = 0;
		// On compte le nombre total d'allumettes restant
		for (int i = 0 ; i < allumettes.length ; i++) {
			total += allumettes[i];
		}
		
		// si l'ordi peut gagner: on transforme la somme binaire pair
		if (joueurPeutGagner(tab_somme_binaire) && total < 10) {
            boolean bonne_somme = false;
            
            while (!bonne_somme && ligne_retire < allumettes.length) {
				
				// on copie le tableau du jeu
				int[] tab_copie_allumettes = new int[allumettes.length];
				for (int i = 0; i < allumettes.length; i++) {
					tab_copie_allumettes[i] = allumettes[i];
				}

                // Vérifiez si on peut retirer des bâtons de la ligne actuelle
                if (nombre_retire > tab_copie_allumettes[ligne_retire]) {
                    ligne_retire++;
                    nombre_retire = 1;
                    if (ligne_retire >= tab_copie_allumettes.length) {
                        break; // Plus de lignes à tester
                    }
                }

                // System.out.println("ligne_retire: " + ligne_retire);
                // System.out.println("nombre_retirer: " + nombre_retire);

                // si on tombe sur une ligne vide, on cherche à modifier la suivante
                tab_copie_allumettes[ligne_retire] -= nombre_retire;
                
                // on crée un tableau binaire de la somme des lignes du tableau de jeu
                int[] tab_bonne_somme = new int[copie_allumettes_string[0].length()];
                
                String[] tab_copie_allumettes_string = tab_binaire(tab_copie_allumettes);
				//displayTabString(tab_copie_allumettes_string);
                sommeBinaire(tab_copie_allumettes_string, tab_bonne_somme);
                
                for (int k = 0; k < tab_bonne_somme.length; k++) {
					String.format("%" + tab_bonne_somme.length + "s", tab_bonne_somme[k]).replace(' ', '0');
				}
               
                //System.out.print("tab_bonne_somme: "); displayTabInt(tab_bonne_somme);

                if (!joueurPeutGagner(tab_bonne_somme)) { // quand l'ordi a trouvé le bon coup à jouer
                    //System.out.print("Solution gagnante trouvée! "); System.out.print("tab_bonne_somme: "); displayTabInt(tab_bonne_somme); System.out.println();

                    // on met à jour le tableau de jeu avec la solution trouvée
                    for (int i = 0; i < allumettes.length; i++) {
                        allumettes[i] = tab_copie_allumettes[i];
                    }
                    
                    bonne_somme = true;
                    
                } else {
					nombre_retire++;
				}
            } 
            System.out.println("L'ordinateur retire " + nombre_retire + " allumette(s) de la ligne " + ligne_retire);
            
		} else {
			System.out.println("L'ordinateur joue au hasard");
			strategieAleatoire(allumettes);
		}
	}

	
	/**
     * Méthode qui permet de faire un affichage de tableau de type int
     * @param t tableau
     */
	void displayTabInt(int[] t){
		System.out.print("{");
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i]);
			if (i < t.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("}");
	}
	
	/**
     * Méthode qui permet de faire un affichage de tableau de type String
     * @param t tableau
     */
    void displayTabString(String[] t) {
        System.out.print("{");
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i]);
            if (i < t.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}");
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
				System.out.println("Erreur, le numero de ligne est invalide.");
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
            
            if (i >= 10) {
                System.out.print(i + " : ");
            } else {
                System.out.print(i + "  : ");
            }
            for (int j = 0; j < allumettes[i]; j++) {
                System.out.print("| ");
            }
            // Passe à la ligne suivante
            System.out.println();
        }
    }
	
	
	
	// ----------------------------------- METHODE tab_binaire ET METHODES DE TESTS -----------------------------------
	
	/**
     * Méthode qui permet de dire quand le jeu est terminé
     * @param allumettes Un tableau d'entiers représentant le nombre d'allumettes par ligne.
     */																									//FAIRE METHODE TEST
	 boolean jeuTermine(int[] allumettes) {
		boolean result = true;
		
		// Parcourt toutes les lignes
		for (int i = 0; i < allumettes.length; i++) {
			// Si une ligne contient encore des allumettes, le jeu n'est pas terminé
			if (allumettes[i] > 0) {
				result = false;
			}
		}
		// Si aucune allumette n'est trouvée, le jeu est terminé
		return result;
	}
	
	
	/**
	* Teste la méthode jeuTermine()
	*/
	void testJeuTermine () {
		System.out.println ();
		System.out.println ("*** testJeuTermine()");
		testCasJeuTermine (new int[] {0, 0, 0, 0, 0, 0, 0}, true);
		testCasJeuTermine (new int[] {0, 0, 0, 0, 3}, false);
		testCasJeuTermine (new int[] {}, true);
	}
	
	/**
	* teste un appel de jeuTermine
	* @param tab tableau d'allumettes
	* @param result resultat attendu
	*/
	void testCasJeuTermine (int[] tab, boolean result) {
		
		// Affichage
		System.out.print("jeuTermine (" );
		displayTabInt(tab);
		System.out.print(") \t= " + result + "\t : ");
		
		// Appel
		boolean resExec = jeuTermine(tab);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
			
		} else {
			System.err.println ("ERREUR");
		}
	}
}
