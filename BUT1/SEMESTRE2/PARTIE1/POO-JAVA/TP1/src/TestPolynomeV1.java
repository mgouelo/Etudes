/**
 * La classe <code>TestPolynome</code> permet de jouer (un peu) avec la classe Polynome
 * Elle n'est pas un bon exemple de test unitaire!
 *
 * @author  R. Fleurquin
 * @version 1.0
 */
public class TestPolynomeV1 {

   
    /**
     * Méthode d’exemple pour tester rapidement la classe <code>Polynome</code>.
     * <p><strong>Cette méthode main est à titre de démonstration seulement.</strong></p>
     *
     * @param args Arguments passés au programme (non utilisés).
     */
    public static void main(String[] args) {
        // Exemples de coefficients
        double[] coeffs1 = {2.0, 3.0, 5.0}; // 2 + 3x + 5x^2
        double[] coeffs2 = {1.0, 4.0};      // 1 + 4x

        Polynome p1 = new Polynome(coeffs1);
        Polynome p2 = new Polynome(coeffs2);

        // Évaluation de p1 en x = 2
        System.out.println("p1(2) = " + p1.evaluate(2.0));

        // Somme des deux polynômes
        Polynome p3 = p1.add(p2);
        System.out.println("p3 est : " + p3.getCoefficient(0)
        	+"+"
        	+p3.getCoefficient(1)
        	+"x+"
        	+p3.getCoefficient(2)
        	+"x^2");
        
        double[] coeffs4 = {-3, -1, 2, 3};
        Polynome p4 = new Polynome(coeffs4);
        
        Polynome p5 = p3.add(p4);
        
        System.out.println("Degrée du nouveau polynome somme de p3 + p4 : " + p5.getDegree());
        p5.setCoefficient(2, -3);
        System.out.println(p5.getCoefficient(0) + " + " + p5.getCoefficient(1) + "x + " + p5.getCoefficient(2) + "x^2 + " + p5.getCoefficient(3) + "x^3");
        System.out.println(p5.getCoefficient(0) + p5.getCoefficient(1)*2 + p5.getCoefficient(2) * Math.pow(2, 2) + p5.getCoefficient(3) * Math.pow(2, 3));
        p5.isIdentical(p3);

        // Degré des polynômes
        System.out.println("Degré de p1 : " + p1.getDegree());
        System.out.println("Degré de p2 : " + p2.getDegree());
        System.out.println("Degré de p3 : " + p3.getDegree());

        // Test de la méthode isIdentical
        System.out.println("p1 est identique à p2 ? " + p1.isIdentical(p2));
        System.out.println("p1 est identique à p1 ? " + p1.isIdentical(p1));
    }
}
