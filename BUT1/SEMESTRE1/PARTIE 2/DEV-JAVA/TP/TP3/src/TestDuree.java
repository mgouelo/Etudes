// Importation de bibliothèques
import java.util.*;
import java.io.*;

/**
 * Classe de test des méthodes associées à l'objet Duree
 */
class TestDuree {
	
	/**
	 * Appel des méthode de tests
	 */
	void principal() {
		testConstructeur1EtGetLeTemps();
		
		testConstructeur2EtGetLeTemps();
		
		testAjouter();
		
		testSoustraire();
		
		testCompareA();
		
		testEnTexte();
		
	}
	
	//------------------------------------TEST CONSTRUCTEUR1 + GETLETEMPS------------------------------------
	/**
	 * JavaDoc : test de la méthode getLeTemps() avec le 1er constructeur
	 * @param maDuree objet de type Duree
	 * @param resultatAttendu résultat attendu
	 */
	void testCasConstructeur1EtGetLeTemps(Duree maDuree, int resultatAttendu) {
		// Ici on test getLeTemps() uniquement avec le 1er constructeur avec le temps en millisecondes
		System.out.println("Le résultat attendu est " + resultatAttendu);
		
		int resExec = maDuree.getLeTemps();
		System.out.print("maDuree.getLeTemps() \t = "+ resExec + "\t: ");
		
		if (resExec == resultatAttendu) {
			System.out.println("OK");
		} else {
			System.err.println("ERREUR");
		}
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasConstructeur1EtGetLeTemps()
	 */
	void testConstructeur1EtGetLeTemps() {
		System.out.println();
		System.out.println();
		System.out.println("*** résultats des tests de getLeTemps() :");
		
		System.out.println("Cas normaux :");
		Duree d1 = new Duree(50);
		testCasConstructeur1EtGetLeTemps(d1, 50);
		
		System.out.println("Cas limites :");
		Duree d2 = new Duree(0);
		testCasConstructeur1EtGetLeTemps(d2, 0);
		
		System.out.println("Cas d'erreur :");
		Duree d3 = new Duree(-6);
		testCasConstructeur1EtGetLeTemps(d3, 0);
		
	}
	
	
	//------------------------------------TEST CONSTRUCTEUR2 + GETLETEMPS------------------------------------
	/**
	 * JavaDoc : test de la méthode getLeTemps() avec le second constructeur
	 * @param maDuree objet de type Duree
	 * @param resultatAttendu résultat attendu
	 */
	void testCasConstructeur2EtGetLeTemps(Duree maDuree, int resultatAttendu) {
		// Ici on test getLeTemps() uniquement avec le 2e constructeur avec le temps en heure, minute, seconde
		System.out.println("Le résultat attendu est " + resultatAttendu);
		
		int resExec = maDuree.getLeTemps();
		System.out.print("maDuree.getLeTemps() \t = "+ resExec + "\t: ");
		
		if (resExec == resultatAttendu) {
			System.out.println("OK");
		} else {
			System.err.println("ERREUR");
		}
		System.out.println();
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasConstructeur2EtGetLeTemps()
	 */
	void testConstructeur2EtGetLeTemps() {
		System.out.println();
		System.out.println();
		System.out.println("*** résultats des tests de getLeTemps() :");
		
		System.out.println();
		System.out.println("Cas normaux :");
		Duree d1 = new Duree(1, 21, 56);
		testCasConstructeur2EtGetLeTemps(d1, 4916000);
		
		System.out.println();
		System.out.println("Cas limites :");
		Duree d2 = new Duree(0, 0, 0);
		testCasConstructeur2EtGetLeTemps(d2, 0);
		d2 = new Duree(4, 89, 102);
		testCasConstructeur2EtGetLeTemps(d2, 19842000);
		
		System.out.println();
		System.out.println("Cas d'erreur :");
		Duree d3 = new Duree(4, 12, -9);
		testCasConstructeur2EtGetLeTemps(d3, 0);
		
		
	}
	
	
	//------------------------------------TEST AJOUTER------------------------------------
	/**
	 * JavaDoc : test de la méthode ajouter()
	 * @param maDuree objet de type Duree
	 * @param autreDuree seoncde duree à ajouter à la première
	 */
	void testCasAjouter(Duree maDuree, Duree autreDuree) {
		boolean erreur = false;
		
		if (autreDuree == null) {
			erreur = true;
			System.out.println("La duree initiale = " + maDuree.getLeTemps());
			System.out.println("La duree à soustaire = NULL");
			System.out.print("maDuree.ajouter(autreDuree) \t: ERREUR");
		} else {
			System.out.println("La duree initiale = " + maDuree.getLeTemps());
			System.out.println("La duree à ajouter = " + autreDuree.getLeTemps());
			int sommeTheorique = maDuree.getLeTemps() + autreDuree.getLeTemps();
			
			maDuree.ajouter(autreDuree);
			System.out.print("maDuree.ajouter(autreDuree) \t = "+ maDuree.getLeTemps() + "\t: ");
			
			if (maDuree.getLeTemps() == sommeTheorique) {
				System.out.println("OK");
			} else {
				System.err.println("ERREUR");
			}
			System.out.println();
		}
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasAjouter()
	 */
	void testAjouter() {
		System.out.println();
		System.out.println();
		System.out.println("*** résultats des tests de ajouter() :");
		
		System.out.println();
		System.out.println("Cas normaux :");
		Duree d1 = new Duree(1, 21, 56);
		Duree d2 = new Duree(4, 0, 46);
		testCasAjouter(d1, d2);
		
		System.out.println();
		System.out.println("Cas limites :");
		Duree d3 = new Duree(0, 0, 0);
		testCasAjouter(d2, d2);
		
		System.out.println();
		System.out.println("Cas d'erreur :");
		Duree d4 = new Duree(4, 12, -9);
		testCasAjouter(d4, d4);
		testCasAjouter(d1, null);
		
		
	}
	
	
	//------------------------------------TEST SOUSTRAIRE------------------------------------
	/**
	 * JavaDoc : test de la méthode soustraire()
	 * @param maDuree objet de type Duree
	 * @param autreDuree seoncde duree à soustraire à la première
	 */
	void testCasSoustraire(Duree maDuree, Duree autreDuree) {
		boolean erreur = false;
		
		if (autreDuree == null) {
			erreur = true;
			System.out.println("La duree initiale = " + maDuree.getLeTemps());
			System.out.println("La duree à soustaire = NULL");
			System.out.print("maDuree.soustraire(autreDuree) \t: ERREUR");
		} else {
			System.out.println("La duree initiale = " + maDuree.getLeTemps());
			System.out.println("La duree à soustaire = " + autreDuree.getLeTemps());
			int differenceTheorique = maDuree.getLeTemps() - autreDuree.getLeTemps();
			
			maDuree.soustraire(autreDuree);
			System.out.print("maDuree.soustraire(autreDuree) \t = "+ maDuree.getLeTemps() + "\t: ");
			
			if (maDuree.getLeTemps() == differenceTheorique) {
				System.out.println("OK");
			} else {
				System.err.println("ERREUR");
			}
			System.out.println();
		}
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasSoustraire()
	 */
	void testSoustraire() {
		System.out.println();
		System.out.println();
		System.out.println("*** résultats des tests de soustraire() :");
		
		System.out.println();
		System.out.println("Cas normaux :");
		Duree d1 = new Duree(1, 21, 56);
		Duree d2 = new Duree(0, 0, 46);
		testCasSoustraire(d1, d2);
		
		System.out.println();
		System.out.println("Cas limites :");
		Duree d3 = new Duree(0, 0, 0);
		testCasSoustraire(d2, d2);
		
		System.out.println();
		System.out.println("Cas d'erreur :");
		Duree d4 = new Duree(4, 12, -9);
		Duree d5 = new Duree(6, 12, 7);
		testCasSoustraire(d4, d4);
		testCasSoustraire(d1, d5);
		testCasSoustraire(d1, null);
		
		
	}
	
	
	//------------------------------------TEST COMPAREA------------------------------------
	/**
	 * JavaDoc : test de la méthode compareA()
	 * @param maDuree objet de type Duree
	 * @param autreDuree seoncde duree à soustraire à la première
	 */
	void testCasCompareA(Duree maDuree, Duree autreDuree) {
		boolean erreur = false;
		
		if (autreDuree == null) {
			erreur = true;
			System.out.println("La duree comparée = " + maDuree.getLeTemps());
			System.out.println("La duree comparante = NULL");
			System.out.print("maDuree.compareA(autreDuree) \t: ERREUR");
		} else {
			System.out.println("La duree initiale = " + maDuree.getLeTemps());
			System.out.println("La duree comparante = " + autreDuree.getLeTemps());
			
			int resultatAttendu = -2;
			if (maDuree.getLeTemps() < autreDuree.getLeTemps()) {
				resultatAttendu = -1;
			} else if (maDuree.getLeTemps() > autreDuree.getLeTemps()) {
				resultatAttendu = 1;
			} else if (maDuree.getLeTemps() == autreDuree.getLeTemps()) {
				resultatAttendu = 0;
			}
			
			int resExec = maDuree.compareA(autreDuree);
			System.out.print("maDuree.compareA(autreDuree) \t = "+ resExec + "\t: ");
			
			if (resExec == resultatAttendu) {
				System.out.println("OK");
			} else {
				System.err.println("ERREUR");
			}
			System.out.println();
		}
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasCompareA()
	 */
	void testCompareA() {
		System.out.println();
		System.out.println();
		System.out.println("*** résultats des tests de compareA() :");
		
		System.out.println();
		System.out.println("Cas normaux :");
		Duree d1 = new Duree(1, 21, 56);
		Duree d2 = new Duree(0, 0, 46);
		testCasCompareA(d1, d2);
		testCasCompareA(d1, d1);
		testCasCompareA(d2, d1);
		
		
		System.out.println();
		System.out.println("Cas limites :");
		Duree d3 = new Duree(0, 0, 0);
		testCasCompareA(d2, d2);
		
		System.out.println();
		System.out.println("Cas d'erreur :");
		Duree d4 = new Duree(4, 12, -9);
		testCasCompareA(d4, d4);
		testCasCompareA(d1, null);
		
		
	}
	
	
	//------------------------------------TEST ENTEXTE------------------------------------
	/**
	 * JavaDoc : test de la méthode enTexte()
	 * @param maDuree objet de type Duree
	 * @param mode format d'affichage
	 */
	void testCasEnTexte(Duree maDuree, char mode) {
		boolean erreur = false;
		if (mode == 'S' || mode == 'M' || mode == 'H' || mode == 'J') {
			System.out.println("La duree à convertir = " + maDuree.getLeTemps());
			
			String resExec = maDuree.enTexte(mode);
			System.out.print("maDuree.enTexte() \t = "+ resExec);
			System.out.println();
		} else {
			erreur = true;
			System.out.println("Le caractère n'est pas égal à 'S', 'M', 'H', ou 'J'");
		}
	}
	
	/**
	 * Méthode appel des tests de la fonction testCasEnTexte()
	 */
	void testEnTexte() {
		System.out.println();
		System.out.println();
		System.out.println("*** résultats des tests de enTexte() :");
		
		System.out.println();
		System.out.println("Cas normaux :");
		Duree d1 = new Duree(1, 21, 56);
		testCasEnTexte(d1, 'S');
		testCasEnTexte(d1, 'M');
		testCasEnTexte(d1, 'H');
		testCasEnTexte(d1, 'J');
		
		System.out.println();
		System.out.println("Cas limites :");
		Duree d2 = new Duree(0);
		testCasEnTexte(d2, 'J');
		
		System.out.println();
		System.out.println("Cas d'erreur :");
		Duree d3 = new Duree(4, 12, -9);
		testCasEnTexte(d3, 'H');
		testCasEnTexte(d1, 'K');
		
		
	}
}
