package notification;

/**
 * Factory class to create instances of CommunicationStrategy.
 */
class CommunicationFactory {

    /**
     * Creates a communication strategy based on the given mode.
     * @param mode The communication mode (SMS, MAIL).
     * @return An instance of CommunicationStrategy or null if mode is invalid.
     */
    public static CommunicationStrategy create(String mode) {
        CommunicationStrategy ret = null;

        switch (mode) {
            case "SMS":
                ret = new SmsCommunication();
                break;
            case "MAIL":
                ret = new MailCommunication();
                break;
            case "XMESS":
                ret = new XmessCommunication();
                break;
            case "CHAT":
                ret = new ComNetAdaptator();
                break;
            default:
                System.err.println("Erreur : le mode de communication fourni n'est pas valide !");
                ret = new MailCommunication();
        }

        return ret;
    }
}