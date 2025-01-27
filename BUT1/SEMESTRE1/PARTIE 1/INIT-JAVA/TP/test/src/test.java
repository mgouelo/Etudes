class test {
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
        


        // Initialisation des variables pour le tour par tour
		int nbTour = 1;
		String joueurAjouer = premierJoueur; // Commence avec le joueur tiré au sort



		// Boucle de jeu principale
		while (!jeuTermine(allumettes)) {
			System.out.println("\nTour numero : " + nbTour);
			affiche(allumettes);
			
			jouer(joueurAjouer, allumettes);
			
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
	void jouer(String joueur, int[] allumettes) {
		System.out.println("Au tour de : " + joueur);
		
		if (joueur.equals("Ordinateur")) {
			stratgagnante(allumettes);
		} else {
			modification(allumettes);
		}
	}	
		
	void stratgagnante(int[] allumettes) {
		int[] copie_allumettes = new int[allumettes.length];
		String[] bin_allumettes = new String[allumettes.length];
		
		for (int i = 0 ; i < allumettes.length ; i++) {
			copie_allumettes[i] = allumettes[i];
			bin_allumettes[i] = dec_to_bin(copie_allumettes[i]);
		}
		
		int[] somme_binaire = new int[bin_allumettes[0].length()];
		int bit;
		int somme = 0;
		
		for (int i = bin_allumettes[0].length()-1 ; i >= 0 ; i--) {
			for (int j = 0 ; j < bin_allumettes.length ; j++) {
				
				// Ici on convertit le caractère extrait de type char vers le type int. Sauf que lors de cette conversion le caractère '1' devient 49 et '0' devient '48'
				// En réalité cette conversion nous renvoie le code ASCII associé à 1 ou 0. Donc si on souhaite obtenir la valeur int 1 ou 0 dans notre variable, on doit 
				// soustraire à la conversion '0' qui vaut 48. Ansi pour 1 on a 49 - 48 = 1 et pour 0 on a 48 - 48 = 0
				bit = (int) bin_allumettes[j].charAt(i) - '0';
				somme_binaire[i] += bit;
			}
		}
		
		displayTab(somme_binaire);
		
		// On parcours la liste somme_binaire et on vérifie si les sommes sont paires 
		
		int j = 0;
		int nbAllumettes;
		int ligne;
		for (int i = 0 ; i < somme_binaire.length ; i++) {
			
			// Si on tombe sur une comme impaire...
			if (somme_binaire[i] % 2  == 1) {
				
				// On parcours la liste copie_allumettes qui contient les suites binaire en cherchant dans chaque string à l'indice  i un 1
				while (j < bin_allumettes.length) {
					
					// Si un 1 est trouvé on le met à 0
					if (bin_allumettes[j].charAt(i) == 1) {
						
						String chaine = "";
						// Pour modifier le 1 trouvé en 0 on est obligé de remplacer toute la chaine de caractère précédente par une nouvelle car elles sont immuables
						for (int n = 0 ; n < bin_allumettes[j].length() ; n++) {
							if (n == i) {
								chaine = chaine + '0';
							} else {
								chaine = chaine + bin_allumettes[j].charAt(n);
							}
						}
						nbAllumettes = bin_to_dec(bin_allumettes[j]) - bin_to_dec(chaine);
						j = copie_allumettes.length;
						ligne = i;
						allumettes[ligne] -= nbAllumettes;
						break;
					} else {
						j += 1;
					}
				}
			}
		}
	}
		
	void displayTab(int[] t){
		if (t.length == 0) {
			System.out.print("{}");
		} else {
			int i = 0;
			System.out.print("{");
			
			while(i<t.length-1){
				System.out.print(t[i] + ",");
				i=i+1;
			}
			System.out.print(t[i]+"}");
		}
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
		displayTab(tab1);
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
		displayTab(tab);
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
