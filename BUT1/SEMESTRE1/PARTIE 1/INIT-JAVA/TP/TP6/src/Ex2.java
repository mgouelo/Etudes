class Ex2 {
	void principal() {
		jouer();
	}
	
	
	/**
	* Affichage du plateau de Morpion avec les indices de lignes
	* et de colonnes
	* @param plateau le tableau a afficher
	*/
	void affichePlateau(char[][] plateau) {
		System.out.print("     ");
		for (int i = 0 ; i < plateau.length ; i++) {
			System.out.print(i + "   ");
		}
		System.out.println();
		for (int i = 0 ; i < plateau.length ; i++) {
			System.out.print(i +"  | ");
			for (int j = 0 ; j < plateau[i].length ; j++) {
				System.out.print(plateau[i][j]+" | ");
			}
			System.out.println();
		}
		
	}
	
	
	
	/**
	* Créer un plateau de jeu carré rempli de caractere espace ’ ’
	* @param lg taille du plateau (lg < 10 : pas à vérifier)
	* @return tableau de caractere en deux dimensions
	*/
	char[][] creerPlateau(int lg) {
		char[][] morpion = new char[lg][lg];
		
		for (int i = 0 ; i < morpion.length ; i++) {
			for (int j = 0 ; j < morpion[i].length ; j++) {
				morpion[i][j] = ' ';
			}
		}
		
		return morpion;
	}
	
	
	/**
	* Demande deux coordonnees à l’utilisateur. Si les coordonnees sont
	* correctes (dans le plateau et pas de pion déjà mis à cet endroit),
	* le caractere du joueur est ajouté au plateau sinon, on redemande
	* des coordonnées à l’utilisateur en expliquant l’erreur
	* @param plateau le plateau de jeu
	* @param joueur le caractere representant le joueur : X ou O
	*/
	void ajoutePion(char[][] plateau, char joueur) {
		
		int ligne;
		int colonne;
		
		do {
			ligne = SimpleInput.getInt("Sur quelle ligne vous voulez jouer : ");
			colonne = SimpleInput.getInt("Sur quelle colonne vous voulez jouer : ");
		} while ( ligne >= plateau.length || colonne >= plateau[ligne].length || plateau[ligne][colonne] != ' ' );
		
		plateau[ligne][colonne] = joueur;
	}
	
	/**
	* Verifie si toutes les cases du plateau sont remplies
	* (différentes de ’ ’)
	* @param plateau le plateau de jeu
	* @return true si tout le plateau est rempli, false sinon.
	*/
	boolean estRempli(char[][] plateau) {
		
		boolean rempli = true;
		
		for (int i = 0 ; i < plateau.length ; i++) {
			for (int j = 0 ; j < plateau[i].length ; j++) {
				if (plateau[i][j] == ' ') {
					rempli = false;
				}
			}
		}
		return rempli;
	}
	
	/**
	* Verifie s’il y a un alignement de n mêmes caracteres horizontalement
	* (n étant la longueur ou largeur du plateau)
	* @param plateau le plateau de jeu
	* @return true s’il existe un alignement horizontal sur une ligne du plateau
	*/
	boolean alignHorizontal(char[][] plateau) {
		
		boolean gagne = false;
		
		for (int i = 0 ; i < plateau.length ; i++) {
			for (int j = 0 ; j <= plateau[i].length - 3 ; j++) {
				if (plateau[i][j] != ' ' && plateau[i][j] == plateau[i][j+1] && plateau[i][j] == plateau[i][j+2]) {
					gagne = true;
				}
			}
		}
		return gagne;
	}
	
	
	/**
	* Verifie s’il y a un alignement de n mêmes caracteres verticalement
	* (n étant la longueur ou largeur du plateau)
	* @param plateau le plateau de jeu
	* @return true s’il existe un alignement horizontal sur une ligne du plateau
	*/
	boolean alignVertical(char[][] plateau) {
		
		boolean gagne = false;
		
		for (int i = 0 ; i <= plateau.length - 3 ; i++) {
			for (int j = 0 ; j < plateau[i].length ; j++) {
				if (plateau[i][j] != ' ' && plateau[i][j] == plateau[i+1][j] && plateau[i][j] == plateau[i+2][j]) {
					gagne = true;
				}
			}
		}
		return gagne;
	}
	
	/**
	* Verifie s’il y a un alignement de n mêmes caracteres diagonalement
	* (n étant la longueur ou largeur du plateau)
	* @param plateau le plateau de jeu
	* @return true s’il existe un alignement horizontal sur une ligne du plateau
	*/
	boolean alignDiagonal(char[][] plateau) {
		
		boolean gagne = false;
		
		for (int i = 0 ; i <= plateau.length - 3 ; i++) {
			for (int j = 0 ; j <= plateau[i].length - 3 ; j++) {
				if (plateau[i][j] != ' ' && plateau[i][j] == plateau[i+1][j+1] && plateau[i][j] == plateau[i+2][j+2]) {
					gagne = true;
				}
			}
		}
		return gagne;
	}
	
	
	/**
	* Change le joueur courant
	* @param joueurInitial un caractère représentant le joueur : X ou O
	* @return si le joueur ’X’ est en parametre alors renvoie ’O’
	* sinon renvoie ’X’
	*/
	char changeJoueur(char joueurInitial) {
		
		char joueur = joueurInitial;
		
		if (joueur == 'X') {
			joueur = 'O';
		} else {
			joueur = 'X';
		}	
		return joueur;
	}
	
	
	/**
	* Lance une partie de morpion
	* @param plateau le tableau a afficher
	*/
	void jouer(){
		
		//Demande une taille de plateau à l’utilisateur
		int taille = SimpleInput.getInt("Taille de plateau : ");
		
		//Création du jeu
		char[][] morpion = creerPlateau(taille);
		
		// On commence par le joueur avec les X
		char joueur = 'X';
		
		//Boucle de jeu : elle continue tant que l’une des conditions de fin n’est pas att
		while (!estRempli(morpion) && !alignHorizontal(morpion) && !alignVertical(morpion) && !alignDiagonal(morpion)) {
				
			//Affichage du tableau
			affichePlateau(morpion);
			
			//les deux joueurs jouent l’un après l’autre
			ajoutePion(morpion, joueur);
			alignHorizontal(morpion);
			alignVertical(morpion);
			alignDiagonal(morpion);
			
			//Changement de joueur
			joueur = changeJoueur(joueur);
			
		}
		// Affichage du tableau final
		affichePlateau(morpion);
		
		// Annonce de fin du jeu et déclaration du gagnant s’il existe
		if (alignHorizontal(morpion) || alignVertical(morpion) || alignDiagonal(morpion)) {
			System.out.print("GG, " + changeJoueur(joueur) + " à gagné");
		} else {
			System.out.print("Egalité !");
		}
	}
}
