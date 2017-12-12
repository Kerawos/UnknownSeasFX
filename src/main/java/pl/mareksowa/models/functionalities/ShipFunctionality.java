package pl.mareksowa.models.functionalities;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.sails.Sail;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.ShipPosition;

import java.util.List;

public interface ShipFunctionality {
    List<Ship> getAllShips();
    void addShip(Ship shipToAdd);
    void removeShip(Ship shipToRemove);
    boolean canBuyStorage(Ship PLAYER0SHIP, Label lblUpperText);
    void addStorage(Ship PLAYER0SHIP);
    void updateStorage(Ship PLAYER0SHIP, ImageView... storages );
    boolean canBuyCannonSpace(Ship PLAYER0SHIP, Label lblUpperText);
    void addCannonSpace(Ship PLAYER0SHIP);
    void addCannon(Ship PLAYER0SHIP, Cannon cannonToAdd);
    void updateCannon(Ship PLAYER0SHIP, ImageView ... cannons);
    boolean canBuyCabin(Ship PLAYER0SHIP, Label lblUpperText);
    void addCabin(Ship PLAYER0SHIP);
    void addCrew(Ship PLAYER0SHIP, Crew crewToAdd);
    void updateCrew(Ship PLAYER0SHIP, ImageView ... crews);
    boolean canBuySailSpace(Ship PLAYER0SHIP, Label lblUpperText);
    void addSailSpace(Ship PLAYER0SHIP);
    boolean canBuySail(Ship PLAYER0SHIP, Sail sailToBuy, Label lblUpperText);
    void buySail(Ship PLAYER0SHIP, Sail sailToBuy);
    boolean canSellSail(Ship PLAYER0SHIP, int sailsListNo);
    void sellSail(Ship PLAYER0SHIP, Sail sailToSell);
    void updateSail(Ship PLAYER0SHIP, ImageView ... sails);
    void updateGold(Ship PLAYER0SHIP, Label lblPlayerGold);
    void updateFood(Ship PLAYER0SHIP, Label lblPlayerFood);
    void updateAmmo(Ship PLAYER0SHIP, Label lblPlayerAmmo);
    void updateCharge(Ship PLAYER0SHIP, Label lblPlayerCharge);
    void updatePower(Ship PLAYER0SHIP, Label lblPlayerPower);
    void updateSpeed(Ship PLAYER0SHIP, Label lblPlayerSpeed);
    void updateManeuver(Ship PLYER0SHIP, Label lblPLayerManeuver);
    void updateHp(Ship PLAYER0SHIP, Label lblPlayerHp, ProgressBar pbShipHp);
    void takeDmg(Ship PLAYER0SHIP, int dmgTaken);
    boolean canBuyGood(Ship PLAYER0SHIP, Good goodToBuy);
    void buyGood(Ship PLAYER0SHIP, Good goodToBuy);
    boolean canSellGood(Ship PLAYER0SHIP, int storageListNo);
    void sellGood(Ship PLAYER0SHIP, Good goodToSell, int sellPrice);
    boolean canRepair(Ship PLAYER0SHIP, int toRepair, Label lblUpperText);
    void repair(Ship PLAYER0SHIP, int toRepair);

}
