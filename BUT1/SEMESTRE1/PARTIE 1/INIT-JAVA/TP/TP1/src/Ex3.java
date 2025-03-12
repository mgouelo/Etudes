/*
 * Ce programme calcul le périmètre & l'air du cercle avec le rayon 
 * fournis par l'utilisateur
 */

class Ex3{
	void principal() {
		
		final double PI = 3.14;
		double rayon = SimpleInput.getDouble("Rayon du cercle = ");
		
		System.out.println ("Périmètre du cercle = "+ 2 * PI * rayon);
		System.out.print ("Aire du cercle = "+ PI * rayon * rayon);
		
	}
}
