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
        PLAYER0SHIP.setGold(PLAYER0SHIP.getGold()- PLAYER0SHIP.getStorageCapacity() * PLAYER0SHIP.getStorageCapacity()
                + PLAYER0SHIP.getStorageCapacity());
        PLAYER0SHIP.setStorageCapacity(PLAYER0SHIP.getStorageCapacity()+1);

    }

    @Override
    public boolean canBuyStorage(Ship PLAYER0SHIP,  Label lblUpperText) {
        int storagePrice = PLAYER0SHIP.getStorageCapacity() * PLAYER0SHIP.getStorageCapacity()
                + PLAYER0SHIP.getStorageCapacity();
        if (PLAYER0SHIP.getGold()>= storagePrice){
            return true;
        } else {
            lblUpperText.setText("You don't have enough gold..");
            return false;
        }
    }

    @Override
    public void updateStorage(Ship PLAYER0SHIP, ImageView... storages) {
//        System.out.println("wielkosc magazynowa = " + PLAYER0.getStorageCapacity());
//        System.out.println("wielkosc storages = " + storages.length);
        for (int i = 0; i < PLAYER0SHIP.getStorageCapacity(); i++) {
            if (PLAYER0SHIP.getStorage().size()>0 &&
                    PLAYER0SHIP.getStorage().size()>i){
                switch (PLAYER0SHIP.getStorage().get(i).getName()){
                    case WHEAT:{
                        storages[i].setImage(new Image("img/goods/Wheat.png"));
                        break;
                    }
                    case CLOTHES:{
                        storages[i].setImage(new Image("img/goods/Clothes.png"));
                        break;
                    }
                    case WINE:{
                        storages[i].setImage(new Image("img/goods/Wine.png"));
                        break;
                    }
                    case MAHOGANY:{
                        storages[i].setImage(new Image("img/goods/Mahogany.png"));
                        break;
                    }
                    case SILK:{
                        storages[i].setImage(new Image("img/goods/Silk.png"));
                        break;
                    }
                    case DECORATIONS:{
                        storages[i].setImage(new Image("img/goods/Decorations.png"));
                        break;
                    }
                    case SPICES:{
                        storages[i].setImage(new Image("img/goods/Spices.png"));
                        break;
                    }
                }
            } else {
                storages[i].setImage(new Image("img/StorageEmpty.png"));
            }
        }
    }

    @Override
    public boolean canBuyCannonSpace(Ship PLAYER0SHIP, Label lblUpperText) {
        int cannonPrice = PLAYER0SHIP.getCannonCapacity() * PLAYER0SHIP.getCannonCapacity()
                + PLAYER0SHIP.getCannonCapacity()+5;
        if (PLAYER0SHIP.getGold()>= cannonPrice){
            return true;
        } else {
            lblUpperText.setText("You don't have enough gold..");
            return false;
        }
    }

    @Override
    public void addCannonSpace(Ship PLAYER0SHIP) {
        PLAYER0SHIP.setGold(PLAYER0SHIP.getGold()- PLAYER0SHIP.getCannonCapacity() * PLAYER0SHIP.getCannonCapacity()
                + PLAYER0SHIP.getCannonCapacity()+5);
        PLAYER0SHIP.setCannonCapacity(PLAYER0SHIP.getCannonCapacity() + 1);
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
    public boolean canBuyCabin(Ship PLAYER0SHIP, Label lblUpperText) {
        int cabinPrice = PLAYER0SHIP.getCabinCapacity() * PLAYER0SHIP.getCabinCapacity()
                + PLAYER0SHIP.getCabinCapacity()+1;
        if (PLAYER0SHIP.getGold()>= cabinPrice){
           return true;
        } else {
            lblUpperText.setText("You don't have enough gold..");
            return false;
        }
    }

    @Override
    public void addCabin(Ship PLAYER0SHIP) {
        PLAYER0SHIP.setGold(PLAYER0SHIP.getGold()- PLAYER0SHIP.getCabinCapacity() * PLAYER0SHIP.getCabinCapacity()
                + PLAYER0SHIP.getCabinCapacity()+1);
        PLAYER0SHIP.setCabinCapacity(PLAYER0SHIP.getCabinCapacity()+1);
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
    public boolean canBuySailSpace(Ship PLAYER0SHIP, Label lblUpperText) {
        int sailPrice = PLAYER0SHIP.getSailCapacity()
                * PLAYER0SHIP.getSailCapacity() + PLAYER0SHIP.getSailCapacity()+10;
        if (PLAYER0SHIP.getGold()>= sailPrice){
            return true;
        } else {
            lblUpperText.setText("You don't have enough gold..");
            return false;
        }
    }

    @Override
    public void addSailSpace(Ship PLAYER0SHIP) {
        PLAYER0SHIP.setGold(PLAYER0SHIP.getGold() - PLAYER0SHIP.getSailCapacity()
                * PLAYER0SHIP.getSailCapacity() + PLAYER0SHIP.getSailCapacity()+10);
        PLAYER0SHIP.setSailCapacity(PLAYER0SHIP.getSailCapacity() + 1);
    }

    @Override
    public void buySail(Ship PLAYER0SHIP, Sail sailToBuy) {
        PLAYER0SHIP.getSailList().add(sailToBuy);
        PLAYER0SHIP.setGold(PLAYER0SHIP.getGold()- sailToBuy.getPrice());
    }

    @Override
    public boolean canBuySail(Ship PLAYER0SHIP, Sail sailToBuy, Label lblUpperText) {
        if (PLAYER0SHIP.getSailList()==null){
            PLAYER0SHIP.setSailList(new ArrayList<>());
        }
        if (PLAYER0SHIP.getGold()>= sailToBuy.getPrice()){
            if (PLAYER0SHIP.getSailCapacity() > PLAYER0SHIP.getSailList().size()){
                return true;
            }else {
                lblUpperText.setText("You don't have enough space..");
                return false;
            }
        } else {
            lblUpperText.setText("You don't have enough gold..");
            return false;
        }
    }

    @Override
    public boolean canSellSail(Ship PLAYER0SHIP, int sailsListNo) {
        if (PLAYER0SHIP.getSailList().size()>0){
            String givenSailName = PLAYER0SHIP.getSailList().get(sailsListNo).getClass().getName();
            givenSailName = givenSailName.substring(givenSailName.lastIndexOf(".")+1, givenSailName.length());
            for (int i = 0; i < PLAYER0SHIP.getSailList().size(); i++) {
                String currentSailName = PLAYER0SHIP.getSailList().get(i).getClass().getName();
                currentSailName = currentSailName.substring(currentSailName.lastIndexOf(".")+1, currentSailName.length());
                if (currentSailName.equals(givenSailName)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void sellSail(Ship PLAYER0SHIP, Sail sailToSell) {
        for (int i = 0; i < PLAYER0SHIP.getSailList().size(); i++) {
            if (PLAYER0SHIP.getSailList().get(i).equals(sailToSell)){
                PLAYER0SHIP.setGold(PLAYER0SHIP.getGold() + sailToSell.getPrice());
                PLAYER0SHIP.getSailList().remove(i);
                break;
            }
        }
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
    public boolean canRepair(Ship PLAYER0SHIP, int toRepair, Label lblUpperText) {
        if (PLAYER0SHIP.getCurrentEndurance() < PLAYER0SHIP.getEndurance()){
            if (PLAYER0SHIP.getGold() >= toRepair){
                return true;
            } else {
                lblUpperText.setText("You haven't enough gold to repair " + toRepair + " points" );
                return false;
            }
        } else {
            lblUpperText.setText("There is nothing to repair..");
            return false;
        }
    }

    @Override
    public void repair(Ship PLAYER0SHIP, int toRepair) {
        PLAYER0SHIP.setGold(PLAYER0SHIP.getGold() - toRepair);
        PLAYER0SHIP.setCurrentEndurance(PLAYER0SHIP.getCurrentEndurance() + toRepair);
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
    public boolean canBuyGood(Ship PLAYER0SHIP, Good goodToBuy) {
        if (PLAYER0SHIP.getStorageCapacity()>PLAYER0SHIP.getStorage().size() &&
                PLAYER0SHIP.getGold()>=goodToBuy.getPrice()){
            return true;
        }
        return false;
    }

    @Override
    public void buyGood(Ship PLAYER0SHIP, Good goodToBuy) {
        PLAYER0SHIP.setGold(PLAYER0SHIP.getGold() - goodToBuy.getPrice());
        PLAYER0SHIP.getStorage().add(goodToBuy);
    }

    @Override
    public boolean canSellGood(Ship PLAYER0SHIP, int storageListNo) {
        if (PLAYER0SHIP.getStorage().size()>0){
            for (int i = 0; i < PLAYER0SHIP.getStorage().size(); i++) {
                if (PLAYER0SHIP.getStorage().get(i).getName()==PLAYER0SHIP.getStorage().get(storageListNo).getName()){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void sellGood(Ship PLAYER0SHIP, Good goodToSell, int sellPrice) {
        for (int i = 0; i < PLAYER0SHIP.getStorage().size(); i++) {
            if (PLAYER0SHIP.getStorage().get(i).getName()==goodToSell.getName()){
                PLAYER0SHIP.getStorage().remove(i);
                PLAYER0SHIP.setGold(PLAYER0SHIP.getGold() + sellPrice);
                break;
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
