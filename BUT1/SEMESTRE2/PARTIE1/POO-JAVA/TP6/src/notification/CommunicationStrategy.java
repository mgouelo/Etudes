package notification;

import utilitaire.ComNet;

/**
 * Abstract class defining a communication strategy.
 */
interface CommunicationStrategy {

    /**
     * Sends a message to a client.
     * @param clientName The recipient's name.
     * @param adresse The recipient's address (email or phone number).
     * @param message The message content.
     */
    public abstract void envoyer(String clientName, String adresse, String message);

    /**
     * Verify if the adress is valid
     * @param adresse adress used for the communication
     * @return true by default
     */
    public default boolean isCorrect(String adresse) {
        return true;
    }
}

/**
 * Concrete implementation of email communication.
 */
class MailCommunication implements CommunicationStrategy {
    public void envoyer(String clientName, String adresse, String message) {
        System.out.println("[MAIL (" + adresse + ") -> "+ clientName +"] "+ message);
    }
}

/**
 * Concrete implementation of SMS communication.
 */
class SmsCommunication implements CommunicationStrategy {
    public void envoyer(String clientName, String adresse, String message) {
        System.out.println("[SMS (" + adresse + ") -> "+ clientName +"] "+ message);
    }

    /**
     * Verify if the phone number is valid
     * @param adresse phone number
     * @return return true if it is valid, else false
     */
    public boolean isCorrect(String adresse) {
        return adresse.matches("^(06|07)\\d{8}$");
    }
}

/**
 * Concrete implementation of XMESS communication
 */
class XmessCommunication implements CommunicationStrategy{
    public void envoyer(String clientName, String adresse, String message) {
        System.out.println("[XMESS (" + adresse + ") -> "+ clientName +"] "+ message);
    }
}

/**
 * Concrete implementation of ComNetAdaptator
 */
class ComNetAdaptator implements CommunicationStrategy {

    /**
     * Object from ComNet
     */
    private ComNet theCom;

    /**
     * Constructor of ComNetAdaptator : create an object from ComNet and adapt it to the alert service
     */
    public ComNetAdaptator() {
        this.theCom = new ComNet();
    }

    public void envoyer(String clientName, String adresse, String message) {
        this.theCom.send(adresse, message);
        System.out.println("[CHAT (" + adresse + ") -> "+ clientName +"] "+ message);
    }
}