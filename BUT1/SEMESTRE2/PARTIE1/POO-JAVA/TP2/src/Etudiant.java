/**
 * Represents a student with their name, subjects, coefficients, and grades.
 * @author mgouelo
 * @version 1.0
 */
class Etudiant {
    /**
     * Name of the student
     */
    private String nom;

    /**
     * table with all the grades of the student
     */
    private double[][] bulletin;

    /**
     * All the subject
     */
    private String[] matieres;

    /**
     * subject coefficients
     */
    private double[] coeffiecients;

    /**
     * Constructs a new Etudiant object with the specified name, subjects, coefficients, and number of grades.
     * @param nom The name of the student.
     * @param matieres The array of subjects.
     * @param coeff The array of coefficients corresponding to each subject.
     * @param nbNotes The number of grades per subject.
     */
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

    /**
     * Sets the name of the student.
     * @param nom The new name of the student.
     */
    public void setNom(String nom) {
        if ( (nom == null) || (nom.length() == 0) ) {
            System.err.println("Erreur setNom() : le nom en paramètre doit avoir au moins 2 lettres");
            this.nom = "Nom inconnu";
        } else {
            this.nom = nom;
        }
    }

    /**
     * Returns the name of the student.
     * @return The name of the student.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Returns the number of subjects.
     * @return The number of subjects.
     */
    public int getNbMatieres() {
        return this.matieres.length;
    }

    /**
     * Returns a specific grade for a given subject and grade index.
     * @param iMatiere The index of the subject.
     * @param i The index of the grade.
     * @return The grade at the specified indices, or -1 if indices are invalid.
     */
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

    /**
     * Initializes the grades for all subjects with random values.
     */
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

    /**
     * Calculates the average grade for a specific subject.
     * @param iMatiere The index of the subject.
     * @return The average grade for the subject, or -1 if the index is invalid.
     */
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

    /**
     * Calculates the overall average grade across all subjects, weighted by coefficients.
     * @return The overall average grade.
     */
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

    /**
     * Finds the highest grade among all subjects.
     * @return A string describing the highest grade and the corresponding subject.
     */
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

    /**
     * Returns a string representation of the student's information, including name, grades, overall average, and highest grade.
     * @return A string representation of the student's information.
     */
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