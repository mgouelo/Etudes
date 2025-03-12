/**
 * Test of the Etudiant's class
 */
public class TestEtudiant {
    public static void main(String[] args) {
        Etudiant e1;
        String[] matiere = {"Maths", "Prog", "Eco"};
        double[] coeffs = {1.0, 2.0, 1.0};
        e1 = new Etudiant("Matthieu", matiere, coeffs, 3);
        System.out.println(e1);
        System.out.println("Moyenne en Prog : " + e1.moyenneMatiere(1));
        e1.setNom("Matth");
        System.out.println(e1);
        System.out.println(e1.getUneNote(2, 0));
    }
}