package pl.mareksowa.models.ships.dao;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.sails.Sail;
import pl.mareksowa.models.ships.Ship;

import java.util.List;

public interface ShipFunctionalities {
    List<Ship> getAllShips();
    void addShip(Ship shipToAdd);
    void removeShip(Ship shipToRemove);
    void addStorage();
    void updateStorage(ImageView... storages );
    void addCannon(Cannon cannonToAdd);
    void updateCannon(ImageView ... cannons);
    void addCrew(Crew crewToAdd);
    void updateCrew(ImageView ... crews);
    void addSail(Sail sailToAdd);
    void updateSail(ImageView ... sails);
    void addGood(Good goodToAdd);
    void updateGold(Label lblPlayerGold);
    void updateFood(Label lblPlayerFood);
    void updateAmmo(Label lblPlayerAmmo);
    void updateHp(Label lblPlayerHp, ProgressBar pbShipHp);
    void takeDmg(int dmgTaken);

}
