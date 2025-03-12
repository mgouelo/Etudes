package notification;

/**
 * Represents a subscriber to the alert service.
 */
class Subscriber {

    /**
     * name of the subscriber
     */
    String nom;

    /**
     * mode of communication that the user choosen
     */
    String mode;

    /**
     * adress of the subscriber (email / phone number)
     */
    String adresse;

    /**
     * an object from CommunicationStrategy
     */
    CommunicationStrategy strategy;

    /**
     * Constructs a new Subscriber instance.
     * @param n Subscriber's name.
     * @param m Communication mode (MAIL, SMS, XMESS, CHAT) -> mode is put to MAIL by default.
     * @param adr Contact address.
     * @param strat Communication strategy.
     */
    public Subscriber(String n, String m, String adr, CommunicationStrategy strat) {
        if ( (n == null) || (n.isEmpty()) ) {
            System.err.println("Erreur : le nom d'utilisateur fourni est invalide !");
            this.nom = "Nom inconnu";
        } else {
            this.nom = n;
        }


        switch (m) {
            case "SMS":
                this.mode = "SMS";
                break;
            case "MAIL":
                this.mode = "MAIL";
                break;
            case "XMESS":
                this.mode = "XMESS";
                break;
            case "CHAT":
                this.mode = "CHAT";
                break;
            default:
                System.err.println("Erreur : le mode de communication fourni n'est pas valide !");
                this.mode = "MAIL";
        }

        if ( (adr == null) || (adr.isEmpty()) ) {
            System.err.println("Erreur : l'adresse de contact utilisateur fourni est invalide !");
            this.adresse = "Adresse de contact inconnue";
        } else {
            this.adresse = adr;
        }

        if ( strat == null ) {
            System.out.println("Erreur : la stratégie de communication est invalide !");
        } else {
            this.strategy = strat;
        }
    }

    /**
     * Gets the subscriber's name.
     * @return The subscriber's name.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Gets the subscriber's communication mode.
     * @return The communication mode (MAIL, SMS).
     */
    public String getMode() {
        return this.mode;
    }

    /**
     * Gets the subscriber's contact address.
     * @return The contact address.
     */
    public String getAdresse() {
        return this.adresse;
    }

    /**
     * Gets the subscriber's communication strategy.
     * @return The communication strategy.
     */
    public CommunicationStrategy getStrategy() {
        return this.strategy;
    }
}