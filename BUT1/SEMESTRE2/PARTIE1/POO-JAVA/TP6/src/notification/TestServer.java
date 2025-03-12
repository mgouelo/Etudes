package notification;
import notification.Server;
/**
 * Cette classe ne contient qu’un main démonstrateur du bon fonctionnement
 * du service d’alerte.
 */
public class TestServer {
    /**
     * Exécution d'exemples d’usage du service.
     * @param args list of arguments
     */
    public static void main(String[] args) {
        Server serveur = new Server();
        // Inscription
        serveur.adherer("Alice", "SMS", "0633343536");
        serveur.adherer("Bob", "MAIL", "bob@orange.fr");

        // Envoi d'une alerte
        serveur.alerter("Bonjour, voici une alerte importante!");

        // Désinscription de Bob
        serveur.retirer("Bob");

        // Ajout d'un nouveau client
        serveur.adherer("Charlie", "MAIL", "charlie@orange.fr");
        serveur.adherer("Marie", "SMS", "0723871459");
        serveur.adherer("Nolann", "SMS", "0423871459");
        serveur.adherer("Célian", "SMS", "072871459");

        // Envoi d'une autre alerte
        serveur.alerter("Deuxième alerte!");

        // Affichage des inscrits
        String[] inscrits = serveur.getListeInscrits();
        System.out.println("Liste des inscrits : Nom Adresse (mode)");
        for (String ins : inscrits) {
            System.out.println(ins);
        }

        // AJOUT D'UN NOUVEAU CLIENT
        serveur.adherer("Alix", "XMESS", "@AlixTech");
        serveur.adherer("Marc", "CHAT", "@MarcTech");

        serveur.alerter("Troisième alerte!");

    }
}