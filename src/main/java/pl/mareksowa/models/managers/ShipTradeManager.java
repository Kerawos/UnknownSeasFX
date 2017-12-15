package pl.mareksowa.models.managers;

/**
 * Imports section
 */
import javafx.scene.control.Label;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.sails.Sail;
import pl.mareksowa.models.ships.Ship;

/**
 * Interface responsible for buying and selling avery good, cannons, food, ammo for ship.
 */
@Service
public interface ShipTradeManager {

    /**
     * Method checks if capitan of listed ship can buy given good
     * @param shipPlayer
     * @param goodToBuy
     * @return true if conditions have been met
     */
    boolean canBuyGood(Ship shipPlayer, Good goodToBuy);

    /**
     * Method responsible for buying given good by capitan of listed ship
     * @param shipPlayer
     * @param goodToBuy
     */
    void buyGood(Ship shipPlayer, Good goodToBuy);

    /**
     * Method checks if capitan of listed ship can sell good from their good list
     * @param shipPlayer
     * @param storageListNo
     * @return true if conditions have been met
     */
    boolean canSellGood(Ship shipPlayer, int storageListNo);

    /**
     * Method responsible for selling given good by capitan of listed ship
     * @param shipPlayer
     * @param goodToSell
     * @param sellPrice
     */
    void sellGood(Ship shipPlayer, Good goodToSell, int sellPrice);

    /**
     * Method checks if capitan of listed ship can buy given sail
     * @param shipPlayer
     * @param sailToBuy
     * @param lblUpperText
     * @return true if conditions have been met
     */
    boolean canBuySail(Ship shipPlayer, Sail sailToBuy, Label lblUpperText);

    /**
     * Method responsible for buying given sail by capitan of listed ship
     * @param shipPlayer
     * @param sailToBuy
     */
    void buySail(Ship shipPlayer, Sail sailToBuy);

    /**
     * Method checks if capitan of listed ship can sell given sail
     * @param shipPlayer
     * @param sailsListNo
     * @return true if conditions have been met
     */
    boolean canSellSail(Ship shipPlayer, int sailsListNo);

    /**
     * Method responsible for selling given sail by capitan of listed ship
     * @param shipPlayer
     * @param sailToSell
     */
    void sellSail(Ship shipPlayer, Sail sailToSell);

    /**
     * Method checks if capitan of listed ship can buy given cannon
     * @param shipPlayer
     * @param cannonToAdd
     * @param lblUpperText
     * @return true if conditions have been met
     */
    boolean canBuyCannon(Ship shipPlayer, Cannon cannonToAdd, Label lblUpperText);

    /**
     * Method responsible for buying given cannon by capitan of listed ship
     * @param shipPlayer
     * @param cannonToAdd
     */
    void buyCannon(Ship shipPlayer, Cannon cannonToAdd);

    /**
     * Method checks if capitan of listed ship can sell given cannon
     * @param shipPlayer
     * @param cannonsListNo
     */
    boolean canSellCannon(Ship shipPlayer, int cannonsListNo);

    /**
     * Method responsible for selling given cannon by capitan of listed ship
     * @param shipPlayer
     * @param cannonToSell
     */
    void sellCannon(Ship shipPlayer, Cannon cannonToSell);

    /**
     * Method checks if capitan of listed ship can buy given ammo
     * @param shipPlayer
     * @param lblPlayerAmmo
     * @return true if conditions have been met
     */
    boolean canBuyAmmo(Ship shipPlayer, int ammoCost, Label lblPlayerAmmo);

    /**
     * Method responsible for buying given amount of ammo
     * @param shipPlayer
     * @param ammoQty
     * @param ammoCost
     */
    void buyAmmo(Ship shipPlayer, int ammoQty, int ammoCost);


}
