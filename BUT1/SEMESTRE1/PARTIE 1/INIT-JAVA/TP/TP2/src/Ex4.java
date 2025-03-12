/**
 * Simule un distributeur automatique qui demande de payer un prix fixer par l'utilisateur
 * et rend la monnaie si nécessaire
 * @author
 */

class Ex4 {
    void principal() {
        
        int prix = SimpleInput.getInt("Bienvenue, entrez le prix que vous souhaitez payer : ");
        int montant = SimpleInput.getInt("Entrez le montant que vous voulez payer : ");
        
        while (montant < prix) {
            System.out.println("Vous avez payé " + montant + "€ sur les " + prix +
            "€ au total. Il vous reste donc " + (prix - montant) + "€ à régler.");
            montant += SimpleInput.getInt("Entrez le montant que vous voulez payer : ");
        }
        
        if (montant == prix) {
            System.out.println("Produit acheté. Pas de rendu de monnaie nécessaire.");
        } else {
            while (montant > prix) {
                if (montant - 50 >= prix) {
                    montant -= 50;
                    System.out.println("Rendu : 50€");
                } else if (montant - 20 >= prix) {
                    montant -= 20;
                    System.out.println("Rendu : 20€");
                } else if (montant - 10 >= prix) {
                    montant -= 10;
                    System.out.println("Rendu : 10€");
                } else if (montant - 5 >= prix) {
                    montant -= 5;
                    System.out.println("Rendu : 5€");
                } else if (montant - 2 >= prix) {
                    montant -= 2;
                    System.out.println("Rendu : 2€");
                } else {
                    montant -= 1;
                    System.out.println("Rendu : 1€");
                }
            }
            System.out.println("Produit acheté. La monnaie a été rendue.");
        }
    }
}
