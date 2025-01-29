/**
 * Classe étudiante recensant de multiples informations
 * @author Matthieu Gouélo
 * @version 1.1
 */
class Etudiant {
    private String nom;
    private double[][] bulletin;
    private String[] matieres;
    private double[] coeffiecients;

    public Etudiant(String nom, String[] matieres, double[] coeff, int nbNotes) {
        if ((nom == null) || nom.length() == 0) {
            System.err.println("Erreur Etudiant() : le nom en paramètre est invalide !");
            this.nom = "Nom inconnu";
        } else {
            this.nom = nom;
        }

        if ( (matieres == null) || (matieres.length != coeff.length) ) {
            System.err.println("Erreur Etudiant() : le tableau de matières est invalide !");
            this.matieres = new String[0];
        } else {
            // COPIE DU TABLEAU MATIERE
            this.matieres = new String[matieres.length];
            for (int i = 0 ; i < matieres.length ; i++) {
                this.matieres[i] = matieres[i];
            }
        }

        if ( (coeff == null) || (coeff.length == 0)) {
            System.err.println("Erreur Etudiant() : le tableau de coefficients est invalide !");
            this.coeffiecients = new double[0];
        } else {
            // COPIE DU TABLEAU COEFFICIENTS
            this.coeffiecients = new double[coeff.length];
            for (int i = 0 ; i < coeff.length ; i++) {
                this.coeffiecients[i] = coeff[i];
            }
        }

        if ( nbNotes < 1 ) {
            System.err.println("Erreur Etudiant() : le nombre de note est inférieur à 1");

        } else {
            this.bulletin = new double[this.matieres.length][nbNotes];
        }
        this.initialisation();
    }


    public void setNom(String nom) {
        if ( (nom == null) || (nom.length() == 0) ) {
            System.err.println("Erreur setNom() : le nom en paramètre doit avoir au moins 2 lettres");
            this.nom = "Nom inconnu";
        } else {
            this.nom = nom;
        }
    }

    public String getNom() {
        return this.nom;
    }

    public int getNbMatieres() {
        return this.matieres.length;
    }

    public double getUneNote(int iMatiere, int i) {
        double ret;
        if ( (iMatiere < 0) || (iMatiere >= this.bulletin.length) ) {
            System.err.println("Erreur getUneNote() : l'indice iMatiere est invalide.");
            ret = -1;
        }
        else if ( ( i < 0 ) || ( i >= this.bulletin[iMatiere].length ) ) {
            System.err.println("Erreur getUneNote() : l'indice i est invalide.");
            ret = -1;
        }
        else {
            ret = this.bulletin[iMatiere][i];
        }
        return ret;
    }


    private void initialisation() {
        for (int i = 0 ; i < this.matieres.length ; i++) {
            for (int j = 0 ; j < this.bulletin[i].length ; j++) {
                this.bulletin[i][j] = Math.random() * 20;

                // ON ARRONDIE AU DIEXIEME PRES
                this.bulletin[i][j] *= 10;
                this.bulletin[i][j] = Math.round(this.bulletin[i][j]);
                this.bulletin[i][j] /= 10;
            }
        }
    }

    public double moyenneMatiere(int iMatiere) {
        double ret;
        if ((iMatiere < 0) || (iMatiere >= this.bulletin.length)) {
            System.err.println("Erreur moyenneMatiere() : l'indice iMatiere est invalide !");
            ret = -1;
        } else {
            double somme = 0.0;
            for (int i = 0 ; i < this.bulletin[iMatiere].length ; i++) {
                somme += this.bulletin[iMatiere][i];
            }
            ret = somme / this.bulletin[iMatiere].length;
        }
        // ON ARRONDIE AU DIEXIEME PRES
        ret *= 10;
        ret = Math.round(ret);
        ret /= 10;
        return ret;
    }

    public double moyenneGenerale() {
        double somme = 0;
        double sommeCoeff = 0;
        double moyenne;
        for (int iMatiere = 0 ; iMatiere < this.bulletin.length ; iMatiere++) {
            for (int i = 0 ; i < this.bulletin[iMatiere].length ; i++) {
                somme += this.bulletin[iMatiere][i] * this.coeffiecients[iMatiere];
                sommeCoeff += this.coeffiecients[iMatiere];
            }
        }
        moyenne = somme / sommeCoeff;

        // ON ARRONDIE AU DIEXIEME PRES
        moyenne *= 10;
        moyenne = Math.round(moyenne);
        moyenne /= 10;
        return moyenne;
    }

    public String meilleureNote() {
        double max = this.bulletin[0][0];
        String laMatiere = this.matieres[0];
        String ret;
        for (int iMatiere = 0 ; iMatiere < this.bulletin.length ; iMatiere++) {
            for (int i = 0 ; i < this.bulletin[iMatiere].length ; i++) {
                if (this.bulletin[iMatiere][i] > max) {
                    max = this.bulletin[iMatiere][i];
                    laMatiere = this.matieres[iMatiere];
                }
            }
        }
        ret = "La note maximale est " + max + "/20 en " + laMatiere + ".";
        return ret;
    }

    public String toString() {
        String text = "Nom : " + this.nom + "\n----Notes----";
        for (int iMatiere = 0 ; iMatiere < this.bulletin.length ; iMatiere++) {
            text = text + "\n" + this.matieres[iMatiere] + " : ";
            for (int i = 0 ; i < this.bulletin[iMatiere].length ; i++) {
                text = text + this.bulletin[iMatiere][i] + "/20  |  ";
            }
        }
        text = text + "\nMoyenne générale : " + moyenneGenerale() + "\n" + meilleureNote();
        return text;
    }
}