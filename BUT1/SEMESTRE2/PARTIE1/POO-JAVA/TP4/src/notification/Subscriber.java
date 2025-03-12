package notification;

class Subscriber {

    String nom;
    String mode;
    String adresse;
    CommunicationStrategy strategy;

    /**
     * Constructeur de la classe Subscriber. Ici on fait le choix de mettre par défaut le mode de communication à MAIL s'il celui fourni n'est pas valide.
     * @param n nom de l'abonné
     * @param m mode de communication choisi ; comment l'utilisateur recevra ses alertes (mail, sms...)
     * @param adr adresse de contact de l'utilisateur (ex: son adresse mail, son n° de tel...)
     * @param strat stratégie : modalité qui servira pour l'envoie des alertes
     */
    public Subscriber(String n, String m, String adr, CommunicationStrategy strat) {
        if ( (n == null) || (n.isEmpty()) ) {
            System.err.println("Erreur : le nom d'utilisateur fourni est invalide !");
            this.nom = "Nom inconnu";
        } else {
            this.nom = n;
        }

        if ( (m == null) || (m.isEmpty()) ) {
            System.err.println("Erreur : le mode de communication est invalide !");
            this.mode = "MAIL";
        } else if ( m.equals("MAIL") ) {
            this.mode = "MAIL";
        } else if ( m.equals("SMS") ) {
            this.mode = "SMS";
        }

        if ( (adr == null) || (adr.isEmpty()) ) {
            System.err.println("Erreur : l'adresse de contact utilisateur fourni est invalide !");
            this.adresse = "Adresse de contatc inconnue";
        } else {
            this.adresse = adr;
        }

        if ( strat == null ) {
            System.out.println("Erreur : la stratégie de communication est invalide !");
        } else {
            this.strategy = strat;
        }
    }

    public String getNom() {
        return this.nom;
    }

    public String getMode() {
        return this.mode;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public CommunicationStrategy getStrategy() {
        return this.strategy;
    }
}