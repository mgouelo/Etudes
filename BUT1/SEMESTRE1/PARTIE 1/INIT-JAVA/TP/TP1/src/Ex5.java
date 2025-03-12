/**
 * Edition d'une fiche de salaire à partir d'un salaire brut donné
 * par l'utilisateur.
 */

class Ex5{
	void principal(){
		
		double salaireBrut;
		salaireBrut = SimpleInput.getDouble("Salaire brut : ");
		
		double assuranceMaladie = 0.9925;
		double assuranceVieillesseDeplafonnee = 0.999;
		double assuranceVieillessePlafonnee = 0.9325;
		double fraisPro = 0.9825;
		double contributionSocialeGen = 0.925;
		double CRDS = 0.995;
		double chomage = 0.976;
		
		System.out.println("Salaire brut : "+ salaireBrut);
		System.out.println("Assurance maladie : -"+ salaireBrut * assuranceMaladie +"€");
		System.out.println("Assurance vieillesse déplafonnée : -"+ salaireBrut * assuranceVieillesseDeplafonnee +"€");
		System.out.println("Assurance vieillesse plafonnée : -"+ salaireBrut * assuranceVieillessePlafonnee +"€");
		
		double fraisProDeduit = salaireBrut * fraisPro;
		System.out.println("Frais professionnels : -"+ fraisProDeduit +"€");
		System.out.println("Contribution sociale généralisée : -"+ fraisProDeduit * contributionSocialeGen +"€");
		
