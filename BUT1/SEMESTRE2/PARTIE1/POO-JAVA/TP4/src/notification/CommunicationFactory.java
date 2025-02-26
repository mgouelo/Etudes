package notification;

class CommunicationFactory {
    public static CommunicationStrategy create(String mode) {
        CommunicationStrategy ret = null;
        if ( mode == null || mode.isEmpty() ) {
            System.err.println("Erreur : le mode de communication fourni n'est pas valide !");
            ret = null;
        } else if ( mode.equals("SMS") ) {
            ret = new SmsCommunication();
        } else if ( mode.equals("MAIL") ) {
            ret = new MailCommunication();
        }
        return ret;
    }
}