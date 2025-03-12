package notification;
import java.util.*;

/**
 * Central alert service handling client subscriptions and notifications.
 */
public class Server {
    /**
     * Initializes a Hashmap of subscribers
     */
    private Map<String, Subscriber> abonnement;

    /**
     * Creation of a list of client who subscribe at the server alert
     */
    private Collection<Subscriber> listeClient;

    /**
     * Initializes a new Server instance.
     */
    public Server(){
        this.abonnement = new HashMap<>();
    }

    /**
     * Registers a new subscriber with a communication mode.
     * @param clientName The subscriber's name.
     * @param mode The communication mode (MAIL, SMS, XMESS, CHAT) communication mode is MAIL by default.
     * @param adr The contact address.
     */
    public void adherer(String clientName, String mode, String adr) {
        if ( (clientName == null) || (clientName.isEmpty()) ) {
            System.err.println("Erreur : le nom d'utilisateur fourni est invalide !");
            clientName = "Nom inconnu";
        }
        switch (mode) {
            case "SMS":
                break;
            case "MAIL":
                break;
            case "XMESS":
                break;
            case "CHAT":
                break;
            default:
                System.err.println("Erreur : le mode de communication fourni n'est pas valide !");
                mode = "MAIL";
        }
        if (adr == null || adr.isEmpty()) {
            System.err.println("Erreur : l'adresse de contact est invalide.");
            adr = "Adresse inconnue";
        } else {
            CommunicationStrategy strategy = CommunicationFactory.create(mode);
            if (!strategy.isCorrect(adr)) {
                System.err.println("Erreur, l'adresse de communication renseignée est invalide");
            } else {
                CommunicationAccess.setCom(mode, strategy);
                Subscriber client = new Subscriber(clientName, mode, adr);
                this.abonnement.put(clientName, client);
            }
        }
    }

    /**
     * Unsubscribes a client.
     * @param clientName The name of the subscriber to remove.
     */
    public void retirer(String clientName) {
        this.abonnement.remove(clientName);
    }

    /**
     * Sends an alert message to all subscribers.
     * @param message The alert message to be sent.
     */
    public void alerter(String message) {
        listeClient = this.abonnement.values();
        CommunicationStrategy strategy;
        for (Subscriber sub: listeClient) {
            strategy = CommunicationAccess.getCom(sub.getMode());
            strategy.envoyer(sub.getNom(), sub.getAdresse(), message);
        }
    }

    /**
     * Retrieves the list of registered subscribers.
     * @return An array of subscriber details.
     */
    public String[] getListeInscrits() {
        listeClient = this.abonnement.values();
        String[] ret = new String[this.abonnement.size()];
        String chaine;
        int i = 0;
        for (Subscriber sub: listeClient) {
            chaine = sub.getNom() + " " + sub.getAdresse() + " (" + sub.getMode() + ")";
            ret[i] = chaine;
            i++;
        }
        return ret;
    }
}