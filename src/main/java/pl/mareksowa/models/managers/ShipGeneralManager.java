package pl.mareksowa.models.managers;

/**
 * Imports section
 */
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.ships.Ship;

import java.util.List;

/**
 * Interface responsible for general ship behaviours, not specified. Every updates of ship controller.
 */
public interface ShipGeneralManager {

    /**
     * Method responsible for getting list of players ship from current game
     * @return mentioned list
     */
    List<Ship> getAllShips();

    /**
     * Method responsible for add new player ship to game
     * @param shipToAdd
     */
    void addShip(Ship shipToAdd);

    /**
     * Method responsible for remove indicate player ship from game
     * @param shipToRemove
     */
    void removeShip(Ship shipToRemove);

    /**
     * Method responsible for add damage points to listed ship
     * @param playerShip
     * @param dmgTaken
     */
    void takeDmg(Ship playerShip, int dmgTaken);

    /**
     * Method responsible for update storage of given ship
     * @param shipPlayer
     * @param storages
     */
    void updateStorage(Ship shipPlayer, ImageView... storages );

    /**
     * Method responsible for update cannon and armor of given ship
     * @param shipPlayer
     * @param cannons
     */
    void updateCannon(Ship shipPlayer, ImageView ... cannons);

    /**
     * Method responsible for update crew of given ship
     * @param shipPlayer
     * @param crews
     */
    void updateCrew(Ship shipPlayer, ImageView ... crews);

    /**
     * Method responsible for update sails of given ship
     * @param shipPlayer
     * @param sails
     */
    void updateSail(Ship shipPlayer, ImageView ... sails);

    /**
     * Method responsible for update gold of given ship
     * @param shipPlayer
     * @param lblPlayerGold
     */
    void updateGold(Ship shipPlayer, Label lblPlayerGold);

    /**
     * Method responsible for update food of given ship
     * @param shipPlayer
     * @param lblPlayerFood
     */
    void updateFood(Ship shipPlayer, Label lblPlayerFood);

    /**
     * Method responsible for update ammo of given ship
     * @param shipPlayer
     * @param lblPlayerAmmo
     */
    void updateAmmo(Ship shipPlayer, Label lblPlayerAmmo);

    /**
     * Method responsible for update charge potential of given ship
     * @param shipPlayer
     * @param lblPlayerCharge
     */
    void updateCharge(Ship shipPlayer, Label lblPlayerCharge);

    /**
     * Method responsible for update power potential of given ship
     * @param shipPlayer
     * @param lblPlayerPower
     */
    void updatePower(Ship shipPlayer, Label lblPlayerPower);

    /**
     * Method responsible for update speed of given ship
     * @param shipPlayer
     * @param lblPlayerSpeed
     */
    void updateSpeed(Ship shipPlayer, Label lblPlayerSpeed);

    /**
     * Method responsible for update maneuver of given ship
     * @param shipPlayer
     * @param lblPLayerManeuver
     */
    void updateManeuver(Ship shipPlayer, Label lblPLayerManeuver);

    /**
     * Method responsible for update hit points of given ship
     * @param shipPlayer
     * @param lblPlayerHp
     * @param pbShipHp
     */
    void updateHp(Ship shipPlayer, Label lblPlayerHp, ProgressBar pbShipHp);

}
