package pl.mareksowa.models.functionalities.services;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.ShipPosition;
import pl.mareksowa.models.ships.StartingShip;
import pl.mareksowa.models.functionalities.ShipFunctionality;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.sails.Sail;

import java.util.ArrayList;
import java.util.List;

public class ShipManager implements ShipFunctionality {

    private List<Ship> ships;
    private ShipMovementImpl shipMovementImpl;

    public ShipManager() {
        ships = new ArrayList<>();
        addShip(new StartingShip().getStartingShip());
        shipMovementImpl = new ShipMovementImpl();
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
        List<Sail> sailList = new ArrayList<>();
        if (PLAYER0SHIP.getSailList()==null){
            PLAYER0SHIP.setSailList(sailList);
        }
        PLAYER0SHIP.getSailList().add(sailToAdd);
    }

    @Override
    public void updateSail(Ship PLAYER0SHIP, ImageView... sails) {
        for (int i = 1; i <= PLAYER0SHIP.getSailCapacity(); i++) {
            if (PLAYER0SHIP.getSailList().size() >= i && PLAYER0SHIP.getSailList().size()>0){
                String shipName = PLAYER0SHIP.getSailList().get(i-1).getClass().getName();
                switch (shipName.substring(shipName.lastIndexOf(".")+1, shipName.length())){
                    case "SailSmall":{
                        sails[i-1].setImage(new Image("img/SailSmall.png"));
                        break;
                    }
                    case "SailPirate":{
                        sails[i-1].setImage(new Image("img/SailPirate.png"));
                        break;
                    }
                    case "SailSharp":{
                        sails[i-1].setImage(new Image("img/SailSharp.png"));
                        break;
                    }
                    case "SailBig":{
                        sails[i-1].setImage(new Image("img/SailBig.png"));
                        break;
                    }
                }

            } else {
                sails[i-1].setImage(new Image("img/SailEmpty.png"));
            }
        }

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
    public void updateCharge(Ship PLAYER0SHIP, Label lblPlayerCharge) {
        lblPlayerCharge.setText(String.valueOf(calcShipCharge(PLAYER0SHIP)));
    }

    @Override
    public void updatePower(Ship PLAYER0SHIP, Label lblPlayerPower) {
        lblPlayerPower.setText(String.valueOf(calcShipPower(PLAYER0SHIP)));
    }

    @Override
    public void updateSpeed(Ship PLAYER0SHIP, Label lblPlayerSpeed) {
        lblPlayerSpeed.setText(String.valueOf(calcShipSpeed(PLAYER0SHIP)));
    }

    @Override
    public void updateManeuver(Ship PLAYER0SHIP, Label lblPLayerManeuver) {
        lblPLayerManeuver.setText(String.valueOf(calcShipManeuver(PLAYER0SHIP)));
    }

    @Override
    public void updateHp(Ship PLAYER0SHIP, Label lblPlayerHp, ProgressBar pbShipHp) {
        int maxHp = PLAYER0SHIP.getEndurance();
        int curHp = PLAYER0SHIP.getCurrentEndurance();
        pbShipHp.setProgress((double)curHp/maxHp);
        lblPlayerHp.setText(""+(curHp*100)/maxHp);
    }

    @Override
    public void takeDmg(Ship PLAYER0SHIP, int dmgTaken) {

    }

    @Override
    public void buyGood(Ship PLAYER0SHIP, Good goodToBuy) {
        if (PLAYER0SHIP.getStorageCapacity()>PLAYER0SHIP.getStorage().size()){
            PLAYER0SHIP.getStorage().add(goodToBuy);
        }
    }

    @Override
    public void sellGood(Ship PLAYER0SHIP, Good goodToSell) {
        if (PLAYER0SHIP.getStorage().size()>0){
            for (int i = 0; i < PLAYER0SHIP.getStorage().size(); i++) {
                if (PLAYER0SHIP.getStorage().get(i).getName()==goodToSell.getName()){
                    PLAYER0SHIP.getStorage().remove(i);
                    break;
                }
            }
        }
    }


    private int calcShipCharge(Ship PLAYER0SHIP) throws IllegalArgumentException {
        if (PLAYER0SHIP.getCrewList()==null){
            throw new IllegalArgumentException("Crew are null");
        }
        int charge = 0;
        for (Crew crew : PLAYER0SHIP.getCrewList()) {
            charge+=crew.getStrength();
        }
        return charge + 5; // 5 is Capitan charge power
    }


    private int calcShipSpeed(Ship PLAYER0SHIP) throws IllegalArgumentException{
        if (PLAYER0SHIP.getSailList()==null){
            throw new IllegalArgumentException("Sails are null");
        }
        int speed = 0;
        for (Sail sail : PLAYER0SHIP.getSailList()) {
            speed+=sail.getSpeed();
        }
        return speed > 0 ? speed : 1;
    }

    private int calcShipManeuver(Ship PLAYER0SHIP) throws IllegalArgumentException {
        if (PLAYER0SHIP.getSailList()==null){
            throw new IllegalArgumentException("Sails are null");
        }
        int manu = 0;
        for (Sail sail : PLAYER0SHIP.getSailList()) {
            manu+=sail.getManeuver();
        }
        return manu;
    }

    private int calcShipPower(Ship PLAYER0SHIP) throws IllegalArgumentException{
        if (PLAYER0SHIP.getCannonList()==null){
            throw new IllegalArgumentException("Cannons are null");
        }
        int power = 0;
        for (Cannon cannon : PLAYER0SHIP.getCannonList()) {
            power+=cannon.getStrength();
        }
        return power;
    }

    public ShipMovementImpl getShipMovementImpl() {
        return shipMovementImpl;
    }
}
