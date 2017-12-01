package pl.mareksowa.models.functionalities.services;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.StartingShip;
import pl.mareksowa.models.functionalities.ShipFunctionality;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.sails.Sail;

import java.util.ArrayList;
import java.util.List;

public class ShipManager implements ShipFunctionality {

    private List<Ship> ships;
    //private Ship PLAYER0SHIP;

    public ShipManager() {
        ships = new ArrayList<>();
        ships.add(new StartingShip().getStartingShip());
        //PLAYER0SHIP = ships.get(0);
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
    public void addStorage(Ship PLAYER0SHIP) {

    }

    @Override
    public void updateStorage(Ship PLAYER0SHIP, ImageView... storages) {
//        System.out.println("wielkosc magazynowa = " + PLAYER0.getStorageCapacity());
//        System.out.println("wielkosc storages = " + storages.length);
        for (int i = 0; i < PLAYER0SHIP.getStorageCapacity(); i++) {
            storages[i].setImage(new Image("img/StorageEmpty.png"));
            //System.out.println("tutaj powienien dodac pierwszy obrazaek");
            if (PLAYER0SHIP.getStorage().size()>0 ||
                    PLAYER0SHIP.getStorage().size()>i){
                //System.out.println("z kolei tutaj jakbysmy mieli jakies dobra");
                /// TODO: 06.11.2017 adding proper good
            }
        }
    }

    @Override
    public void addCannon(Ship PLAYER0SHIP, Cannon cannonToAdd) {

    }

    @Override
    public void updateCannon(Ship PLAYER0SHIP, ImageView... cannons) {
        //System.out.println("wielkosc armatniego miejsca = " + PLAYER0.getCannonCapacity());
        //System.out.println("wielkosc armatnich labeli = " + cannons.length);
        for (int i = 0; i < PLAYER0SHIP.getCannonCapacity(); i++) {
            cannons[i].setImage(new Image("img/CannonEmpty.png"));
            //System.out.println("tutaj powienien dodac pierwszy obrazaek cannon");
            if (PLAYER0SHIP.getCannonList().size()>0 ||
                    PLAYER0SHIP.getCannonList().size()>i){
                //System.out.println("z kolei tutaj jakbysmy mieli jakias cannon");
                /// TODO: 06.11.2017 adding proper good
            }
        }
        /// TODO: 06.11.2017
    }

    @Override
    public void addCrew(Ship PLAYER0SHIP, Crew crewToAdd) {

    }

    @Override
    public void updateCrew(Ship PLAYER0SHIP, ImageView... crews) {
        //System.out.println("wielkosc zalogowego miejsca = " + PLAYER0.getStorageCapacity());
        //System.out.println("wielkosc zalogowych labeli = " + crews.length);
        for (int i = 0; i < PLAYER0SHIP.getCabinCapacity(); i++) {
            crews[i].setImage(new Image("img/CrewEmpty.png"));
            //System.out.println("tutaj powienien dodac pierwszy obrazaek crew");
            if (PLAYER0SHIP.getCrewList().size()>0 ||
                    PLAYER0SHIP.getCrewList().size()>i){
                //System.out.println("z kolei tutaj jakbysmy mieli jakias zaloge");
                /// TODO: 06.11.2017 adding proper good
            }
        }
        /// TODO: 06.11.2017
    }

    @Override
    public void addSail(Ship PLAYER0SHIP, Sail sailToAdd) {

    }

    @Override
    public void updateSail(Ship PLAYER0SHIP, ImageView... sails) {
        //System.out.println("wielkosc miejsca na zagle = " + PLAYER0.getSailCapacity());
        //System.out.println("wielkosc zaglowych labeli = " + sails.length);
        for (int i = 0; i < PLAYER0SHIP.getSailCapacity(); i++) {
            sails[i].setImage(new Image("img/SailEmpty.png"));
            //System.out.println("tutaj powienien dodac pierwszy obrazaek sail");
            if (PLAYER0SHIP.getSailList().size()>0 ||
                    PLAYER0SHIP.getSailList().size()>i){
                //System.out.println("z kolei tutaj jakbysmy mieli jakias zagiel");
                /// TODO: 06.11.2017 adding proper good
            }
        }
        /// TODO: 06.11.2017
    }

    @Override
    public void addGood(Ship PLAYER0SHIP, Good goodToAdd) {

    }

    @Override
    public void updateGold(Ship PLAYER0SHIP, Label lblPlayerGold) {
        lblPlayerGold.setText(String.valueOf(PLAYER0SHIP.getGold()));
    }

    @Override
    public void updateFood(Ship PLAYER0SHIP, Label lblPlayerFood) {
        lblPlayerFood.setText(String.valueOf(PLAYER0SHIP.getFood()));
    }

    @Override
    public void updateAmmo(Ship PLAYER0SHIP, Label lblPlayerAmmo) {
        lblPlayerAmmo.setText(String.valueOf(PLAYER0SHIP.getAmmo()));
    }

    @Override
    public void updateHp(Ship PLAYER0SHIP, Label lblPlayerHp, ProgressBar pbShipHp) {
        int maxHp = PLAYER0SHIP.getEndurance();
        int curHp = PLAYER0SHIP.getCurrentEndurance();
        pbShipHp.setProgress((curHp*100)/maxHp);
        lblPlayerHp.setText(""+(curHp*100)/maxHp);
    }

    @Override
    public void takeDmg(Ship PLAYER0SHIP, int dmgTaken) {

    }
}
