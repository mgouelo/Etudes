import java.sql.SQLOutput;

/**
 * La classe <code>TestPolynome</code> permet de jouer (un peu) avec la classe Polynome
 *
 * @author  M.Gouélo
 * @version 2.0
 */
public class TestPolynome {


    /**
     * Méthode d’exemple pour tester rapidement la classe <code>Polynome</code>.
     * <p><strong>Cette méthode main est à titre de démonstration seulement.</strong></p>
     * @param args Arguments passés au programme (non utilisés).
     */
    public static void main(String[] args) {

		// TEST DU CONSTRUCTEUR
		testConstructeur();

		// TEST DU GETTER
		testGetCoefficient();

		// TEST DE LA METHODE ADD
		testAdd();

		// TEST DE LA METHODE ISIDENTICAL
		testIsIdentical();
	}

	/**
	 * Méthode test du constructeur de la class Polynome
	 */
	public static void testConstructeur() {
		// CAS NORMAL
		System.out.println("*** test du constructeur : ");
		System.out.println("CAS NORMAL : ");
		double[] coeffs1 = {0, 5, -3};
		Polynome poly1 = new Polynome(coeffs1);

		coeffs1[0] = 6;
		System.out.println( poly1.getCoefficient(0) );
		// On constate dans un premier temps que le tableau coeffs1 et l'objet poly1 pointe vers le même tableau
		// car la modification de coeffs1 vient impacter également l'objet poly1

		System.out.print( "poly2.getDegree() = " + poly1.getDegree() + " : ");
		if (poly1.getDegree() == 2) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}

		// CAS LIMITE
		System.out.println();
		System.out.println("CAS LIMITE : ");
		double[] coeffs2 = {0};
		Polynome poly2 = new Polynome(coeffs2);

		System.out.print( "poly2.getDegree() = " + poly2.getDegree() + " : ");
		if (poly2.getDegree() == -1) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}

		// CAS D'ERREUR :
		System.out.println();
		System.out.println("CAS D'ERREUR : ");
		double[] coeffs3 = null;
		Polynome poly3 = new Polynome(coeffs3);

		System.out.print( "poly3.getDegree() = " + poly3.getDegree() + " : ");
		if (poly3.getDegree() == -1) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
	}

	/**
	 * Méthode test de getCoefficient()
	 */
	public static void testGetCoefficient() {
		System.out.println("*** test de la méthode getCoefficient() : ");
		System.out.println("CAS d'ERREUR : ");
		double[] coeffs1 = {0, 5, -3};
		Polynome poly1 = new Polynome(coeffs1);

		System.out.println("poly1 = -3x^2 + 5x");

		double ret = poly1.getCoefficient(7);
		System.out.println("poly1.getCoefficient(7) = " + ret);
		if (ret == -1) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
		// Le getter retourne -1 lorsque qu'on l'appel avec l'indice 7 donc on pourrait croire que poly1 est un polynome du
		// 7ème degré que son coefficient est -1 alors qu'en réalité poly1 est un polynome du 3e degré et que -1 est une valeur retournée par défaut en cas d'erreur.

		// En revanche le setter gère ce cas d'erreur sans montré de limite particulière car le setter ne retourne pas de valeur
		// donc il suffit d'afficher un message d'erreur en cas de paramètre erroné sans retourné de valeur qui pourrait créer plusieurs interprétations différentes du résultat.

	}

	/**
	 * Méthode de test de add()
	 */
	public static void testAdd() {
		System.out.println("*** test de la méthode add() : ");
		double[] coeffs1 = {0, 5, -3};
		Polynome poly1 = new Polynome(coeffs1);

		double[] coeffs2 = null;
		Polynome poly2 = new Polynome(coeffs2);

		System.out.println("Soit poly1 = -3x^2 + 5x     poly2 = null");
		System.out.println("On effectue poly1 + poly2 ; poly2 + poly1 ; poly2 + poly2");
		System.out.println("et on vérifie le bon fonctionnement de la méthode add en comparant poly3 avec poly1 qui doivent être égaux car poly2 étant null est initialisé à 0");

		Polynome poly3 = poly1.add(poly2);
		System.out.println("poly1.isIdentical(poly3) = " + poly1.isIdentical(poly3));

		poly3 = poly2.add(poly1);
		System.out.println("poly1.isIdentical(poly3) = " + poly1.isIdentical(poly3));

		poly3 = poly2.add(poly2);
		System.out.println("poly3.isIdentical(poly2) = " + poly3.isIdentical(poly2));

		// Avec la modification du constructeur le cas du polynome null, le seul cas d'erreur possible pour la méthode add(),
		// est déjà pris en charge car si le tableau de coefficient est à null alors le polynome est initialisé à 0. Donc
		// poly1.add(poly2) ajoute 0 à poly1 donc retourne un nouvel objet de la même valeur que poly1. Aucune erreur est produite.
	}

	/**
	 * Méthode de test de isIdentical()
	 */
	public static void testIsIdentical() {
		System.out.println("*** test de la méthode isIdentical() : ");
		double[] coeffs1 = null;
		Polynome poly1 = new Polynome(coeffs1);

		double[] coeffs2 = null;
		Polynome poly2 = new Polynome(coeffs2);
		// Les cas où les tableaux de coefficients initialisés à null ne produise pas d'erreur.
		System.out.println("poly1.isIdentical(poly2) : " + poly1.isIdentical(poly2));

		double[] coeffs3 = {5, -2, 4, 0};
		Polynome poly3 = new Polynome(coeffs3);

		double[] coeffs4 = {5, -2, 4};
		Polynome poly4 = new Polynome(coeffs4);
		System.out.println("poly3.isIdentical(poly4) : " + poly3.isIdentical(poly4));
		// ce test renvoie faux alors que ces polynomes sont égaux !
		// car ces 2 polynomes ont un tableau de coefficients de taille différente donc la méthode part du principe qu'ils sont différend.
		// Ce qui n'est pas le cas car coeffs3 possède un coefficient de plus or ce coef est un 0 donc non significatif.

		double[] coeffs5 = {2};
		Polynome poly5 = new Polynome(coeffs5);

		double[] coeffs6 = {-2};
		Polynome poly6 = new Polynome(coeffs6);
		// Les cas où les tableaux de coefficients initialisés à null ne produise pas d'erreur.
		System.out.println("poly5.isIdentical(poly6) : " + poly5.isIdentical(poly6));
	}
}