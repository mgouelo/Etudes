package notification;
import java.util.*;

/**
 * Stock all of the strategy of communication used
 */
class CommunicationAccess {

    /**
     * Initializes a Hashmap of communication strategy
     */
    private static Map<String, CommunicationStrategy> medias = new HashMap<>();

    /**
     * Constructor of CommunicationAccess -> not implemented in order to avoid
     * a creation of a CommunicationAccess object
     */
    private CommunicationAccess() {

    }

    /**
     * Set in the hashmap a mode associated with comObj
     * @param mode mode used for communication
     * @param comObj strategy of communication used
     */
    public static void setCom(String mode, CommunicationStrategy comObj) {
        if (mode == null || mode.isEmpty()) {
            System.err.println("Erreur, le mode est invalide");
        } else if (comObj == null) {
            System.err.println("Erreur, la stratégie de communication est invalide !");
        } else {
            medias.put(mode, comObj);
        }
    }

    /**
     * Get the communication strategy
     * @param mode mode of communication used
     * @return CommunicationStrategy object
     */
    public static CommunicationStrategy getCom(String mode) {
        if (mode == null || mode.isEmpty()) {
            System.err.println("Erreur, le mode est invalide");
        }
        return medias.get(mode);
    }
}