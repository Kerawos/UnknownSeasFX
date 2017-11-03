package pl.mareksowa.models.ships.dao.impl;

import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.dao.ShipDao;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.sails.Sail;

import java.util.ArrayList;
import java.util.List;

public class ShipDaoImpl implements ShipDao {

    private List<Ship> ships;

    private static ShipDaoImpl ourInstance = new ShipDaoImpl();

    public static ShipDaoImpl getInstance(){
        return ourInstance;
    }

    private ShipDaoImpl() {
        ships = new ArrayList<>();
        ships.add(new Ship(5,5,1,100,100,1,100,5,0));
    }

    @Override
    public List<Ship> getAllShips() {
        return ships;
    }

    @Override
    public void addShip(Ship shipToAdd) {
        ships.add(shipToAdd);
    }

    @Override
    public void removeShip(Ship shipToRemove) {
        for (Ship ship : ships) {
            if (ship.equals(shipToRemove)){
                ships.remove(ship);
            }
        }
    }

    @Override
    public void addStorage() {

    }

    @Override
    public void addCannon(Cannon cannonToAdd) {

    }

    @Override
    public void addCrew(Crew crewToAdd) {

    }

    @Override
    public void addSail(Sail sailToAdd) {

    }

    @Override
    public void addGood(Good goodToAdd) {

    }

    @Override
    public void takeDmg(int dmgTaken) {

    }
}
