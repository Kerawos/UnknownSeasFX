package pl.mareksowa.models.ships.dao;

import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.sails.Sail;
import pl.mareksowa.models.ships.Ship;

import java.util.List;

public interface ShipDao {
    List<Ship> getAllShips();
    void addShip(Ship shipToAdd);
    void removeShip(Ship shipToRemove);
    void addStorage();
    void addCannon(Cannon cannonToAdd);
    void addCrew(Crew crewToAdd);
    void addSail(Sail sailToAdd);
    void addGood(Good goodToAdd);
    void takeDmg(int dmgTaken);

}
