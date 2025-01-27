class Ex1 {
	/**
	 * Compte le nombre de jours entre deux dates
	 * @author Stagiaire LN
	 */
    void principal () {
		System.out.print(nbTotalJour(27, 10, 1818, 30, 10, 1818));
    }
    
    
    //Pas important mais ne supprimez pas ! 
    boolean bissextile (int annee){
        return (annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0);
    }
    
    //Pas important mais ne supprimez pas ! 
    int nbJourAnnee (int a){
        int nb = 0;
        
        if (bissextile(a)) {
			nb = 366;
		} else {
			nb = 365;
		}
        
        
        return nb;
    }
       
	/**
	 * Renvoie le nombre de jour par mois
	 * @param a année
	 * 
	 */
    int nbJourMois (int a, int b){
        int nbJour = 0;
        
        if (a == 2){
			if (bissextile(b)) {
				nbJour = 29;
			} else {
				nbJour = 28;
			}
			
			} else if (a <= 7) {
				nbJour = 30 + a % 2;
			} else {
			nbJour = 31 - a % 2;
        }   
        
        return nbJour;
        
    }
    
    /**
     * Méthode qui calcul le nombre de jour entre 2 dates
     * @param jourDate1 
     * @param moisDate1
     * @param anneeDate1
     * @return nombre total de jour
     */
    int nbTotalJour (int jourDate1, int moisDate1, int anneeDate1, int jourDate2, int moisDate2, int anneeDate2){
        int nbJour = 0;
        int i = anneeDate1 + 1;

        // Nombre de jour dans les années terminées entre les 2 dates
        while (i < anneeDate2) {
			nbJour += nbJourAnnee (i);
			i = i + 1;
        }
		
		// Nombre de jour dans les mois terminé suivant la première date
        i = moisDate1 + 1;
		while (i <= 12) {
			nbJour += nbJourMois (i, anneeDate1);
			i++;
		}
	
	
		// Nombre de jour dans les mois terminé qui précèdent la seconde date
		i = 1;
		while (i < moisDate2) {
			nbJour += nbJourMois (i, anneeDate2);
			i++;
		}
		
		
		// Nombre de jour entre la première date et le mois suivant
        nbJour += nbJourMois (moisDate1, anneeDate1) - jourDate1;
        
        // Nombre de jour entre la seconde date et le mois qui la précède
        nbJour += jourDate2 ;
        
        if (anneeDate1 == anneeDate2) {
			if (bissextile(anneeDate1)) {
				nbJour -= 366;
			} else {
				nbJour -= 365;
			}
		}

        return nbJour;
        
    }
}
