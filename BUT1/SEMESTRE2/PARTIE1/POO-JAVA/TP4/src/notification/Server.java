package notification;
import java.util.*;

public class Server {
    private Map<String, Subscriber> abonnement;
    private Collection<Subscriber> listeClient;

    public Server(){
        this.abonnement = new HashMap<>();
    }

    public void adherer(String clientName, String mode, String adr) {
        if ( (clientName == null) || (clientName.isEmpty()) ) {
            System.err.println("Erreur : le nom d'utilisateur fourni est invalide !");
            clientName = "Nom inconnu";
        }
        if (mode == null || mode.isEmpty() || ( !mode.equals("SMS") && !mode.equals("MAIL")) ) {
            System.err.println("Le mode de communication est invalide. Il a été instancié à MAIL par défaut.");
            mode = "MAIL";
        }
        if (adr == null || adr.isEmpty()) {
            System.err.println("Erreur : l'adresse de contact est invalide.");
            adr = "Adresse inconnue";
        } else {
            CommunicationStrategy strategy = CommunicationFactory.create(mode);
            Subscriber client = new Subscriber(clientName, mode, adr, strategy);
            this.abonnement.put(clientName, client);
        }
    }

    public void retirer(String clientName) {
        this.abonnement.remove(clientName);
    }

    public void alerter(String message) {
        listeClient = this.abonnement.values();
        for (Subscriber sub: listeClient) {
            sub.strategy.envoyer(sub.nom, sub.adresse, message);
        }
    }

    public String[] getListeInscrits() {
        listeClient = this.abonnement.values();
        String[] ret = new String[this.abonnement.size()];
        String chaine;
        int i = 0;
        for (Subscriber sub: listeClient) {
            chaine = sub.nom + " " + sub.adresse + " (" + sub.mode + ")";
            ret[i] = chaine;
            i++;
        }
        return ret;
    }
}