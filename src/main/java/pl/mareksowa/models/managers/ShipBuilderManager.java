package pl.mareksowa.models.managers;

/**
 * Imports section
 */
import javafx.scene.control.Label;
import pl.mareksowa.models.ships.Ship;

/**
 * Interface responsible for core ship upgrades like rebuilding ship, space, and extra places to additions.
 */
public interface ShipBuilderManager {
    /**
     * Method checks if indicated ship can be upgraded to extra storage space
     * @param shipPlayer
     * @param lblUpperText
     * @return true if yes
     */
    boolean canBuyStorage(Ship shipPlayer, Label lblUpperText);

    /**
     * Method responsible for adding listed upgrade
     * @param shipPlayer
     */
    void addStorage(Ship shipPlayer);

    /**
     * Method checks if indicated ship can be upgraded to extra cannon or armor space
     * @param shipPlayer
     * @param lblUpperText
     * @return true if yes
     */
    boolean canBuyCannonSpace(Ship shipPlayer, Label lblUpperText);

    /**
     * Method responsible for adding listed upgrade
     * @param shipPlayer
     */
    void addCannonSpace(Ship shipPlayer);

    /**
     * Method checks if indicated ship can be upgraded to extra space for crew
     * @param shipPlayer
     * @param lblUpperText
     * @return true if yes
     */
    boolean canBuyCabin(Ship shipPlayer, Label lblUpperText);

    /**
     * Method responsible for adding listed upgrade
     * @param shipPlayer
     */
    void addCabin(Ship shipPlayer);

    /**
     * Method checks if indicated ship can be upgraded to extra building space for sails
     * @param shipPlayer
     * @param lblUpperText
     * @return true if yes
     */
    boolean canBuySailSpace(Ship shipPlayer, Label lblUpperText);

    /**
     * Method responsible for adding listed upgrade
     * @param shipPlayer
     */
    void addSailSpace(Ship shipPlayer);

    /**
     * Method checks if indicated ship can be repaired for listed amount
     * @param shipPlayer
     * @param toRepair
     * @param lblUpperText
     * @return true if yes
     */
    boolean canRepair(Ship shipPlayer, int toRepair, Label lblUpperText);

    /**
     * Method responsible for repairing ship for given amount
     * @param shipPlayer
     * @param toRepair
     */
    void repair(Ship shipPlayer, int toRepair);
}
