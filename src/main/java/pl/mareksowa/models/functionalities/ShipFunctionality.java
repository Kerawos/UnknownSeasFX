package pl.mareksowa.models.functionalities;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.sails.Sail;
import pl.mareksowa.models.ships.Ship;

import java.util.List;

public interface ShipFunctionality {
    List<Ship> getAllShips();
    void addShip(Ship shipToAdd);
    void removeShip(Ship shipToRemove);
    void addStorage(Ship PLAYER0SHIP);
    void updateStorage(Ship PLAYER0SHIP, ImageView... storages );
    void addCannon(Ship PLAYER0SHIP, Cannon cannonToAdd);
    void updateCannon(Ship PLAYER0SHIP, ImageView ... cannons);
    void addCrew(Ship PLAYER0SHIP, Crew crewToAdd);
    void updateCrew(Ship PLAYER0SHIP, ImageView ... crews);
    void addSail(Ship PLAYER0SHIP, Sail sailToAdd);
    void updateSail(Ship PLAYER0SHIP, ImageView ... sails);
    void addGood(Ship PLAYER0SHIP, Good goodToAdd);
    void updateGold(Ship PLAYER0SHIP, Label lblPlayerGold);
    void updateFood(Ship PLAYER0SHIP, Label lblPlayerFood);
    void updateAmmo(Ship PLAYER0SHIP, Label lblPlayerAmmo);
    void updateCharge(Ship PLAYER0SHIP, Label lblPlayerCharge);
    void updatePower(Ship PLAYER0SHIP, Label lblPlayerPower);
    void updateSpeed(Ship PLAYER0SHIP, Label lblPlayerSpeed);
    void updateHp(Ship PLAYER0SHIP, Label lblPlayerHp, ProgressBar pbShipHp);
    void takeDmg(Ship PLAYER0SHIP, int dmgTaken);


}
