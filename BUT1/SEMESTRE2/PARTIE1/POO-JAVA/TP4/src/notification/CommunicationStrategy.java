package notification;

abstract class CommunicationStrategy {
    public abstract void envoyer(String clientName, String adresse, String message);
}

class MailCommunication extends CommunicationStrategy {
    public void envoyer(String clientName, String adresse, String message) {
        System.out.println("[MAIL (" + adresse + ") -> "+ clientName +"] "+ message);
    }
}

class SmsCommunication extends CommunicationStrategy {
    public void envoyer(String clientName, String adresse, String message) {
        System.out.println("[SMS (" + adresse + ") -> "+ clientName +"] "+ message);
    }
}