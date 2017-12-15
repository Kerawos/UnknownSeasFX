package pl.mareksowa.models.managers.services;

/**
 * Imports section
 */
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.CurrentScene;
import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.StartingShip;
import pl.mareksowa.models.managers.ShipGeneralManager;
import pl.mareksowa.models.sails.Sail;

import java.util.ArrayList;
import java.util.List;

/**
 * Service responsible for general ship behaviours, not specified. Every updates of ship controller.
 */
@Repository
public class ShipGeneralManagerImpl implements ShipGeneralManager {

    private List<Ship> ships;
    private ShipMovementManagerImpl shipMovementImpl;

    public ShipGeneralManagerImpl() {
        ships = new ArrayList<>();
        addShip(new StartingShip().getStartingShip());
        shipMovementImpl = new ShipMovementManagerImpl();
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
    public void updateStorage(Ship shipPlayer, ImageView... storages) {
//        System.out.println("wielkosc magazynowa = " + PLAYER0.getStorageCapacity());
//        System.out.println("wielkosc storages = " + storages.length);
        for (int i = 0; i < shipPlayer.getStorageCapacity(); i++) {
            if (shipPlayer.getStorage().size()>0 &&
                    shipPlayer.getStorage().size()>i){
                switch (shipPlayer.getStorage().get(i).getName()){
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
                storages[i].setImage(new Image("img/goods/StorageEmpty.png"));
            }
        }
    }

    @Override
    public void updateCannon(Ship shipPlayer, ImageView... cannons) {
        for (int i = 1; i <= shipPlayer.getCannonCapacity(); i++) {
            if (shipPlayer.getCannonList().size() >= i && shipPlayer.getCannonList().size()>0){
                String cannonName = shipPlayer.getCannonList().get(i-1).getClass().getName();
                switch (cannonName.substring(cannonName.lastIndexOf(".")+1, cannonName.length())){
                    case "Armor":{
                        cannons[i-1].setImage(new Image("img/cannons/Armor.png"));
                        break;
                    }
                    case "CannonShort":{
                        cannons[i-1].setImage(new Image("img/cannons/CannonShort.png"));
                        break;
                    }
                    case "CannonLong":{
                        cannons[i-1].setImage(new Image("img/cannons/CannonLong.png"));
                        break;
                    }
                    case "CannonBig":{
                        cannons[i-1].setImage(new Image("img/cannons/CannonBig.png"));
                        break;
                    }
                }

            } else {
                cannons[i-1].setImage(new Image("img/cannons/CannonEmpty.png"));
            }
        }
    }


    @Override
    public void updateCrew(Ship shipPlayer, ImageView... crews) {
        //System.out.println("wielkosc zalogowego miejsca = " + PLAYER0.getStorageCapacity());
        //System.out.println("wielkosc zalogowych labeli = " + crews.length);
        for (int i = 0; i < shipPlayer.getCabinCapacity(); i++) {
            crews[i].setImage(new Image("img/crews/CrewEmpty.png"));
            //System.out.println("tutaj powienien dodac pierwszy obrazaek crew");
            if (shipPlayer.getCrewList().size()>0 ||
                    shipPlayer.getCrewList().size()>i){
                //System.out.println("z kolei tutaj jakbysmy mieli jakias zaloge");
                /// TODO: 06.11.2017 adding proper good
            }
        }
        /// TODO: 06.11.2017
    }




    @Override
    public void updateSail(Ship shipPlayer, ImageView... sails) {
        for (int i = 1; i <= shipPlayer.getSailCapacity(); i++) {
            if (shipPlayer.getSailList().size() >= i && shipPlayer.getSailList().size()>0){
                String sailName = shipPlayer.getSailList().get(i-1).getClass().getName();
                switch (sailName.substring(sailName.lastIndexOf(".")+1, sailName.length())){
                    case "SailSmall":{
                        sails[i-1].setImage(new Image("img/sails/SailSmall.png"));
                        break;
                    }
                    case "SailPirate":{
                        sails[i-1].setImage(new Image("img/sails/SailPirate.png"));
                        break;
                    }
                    case "SailSharp":{
                        sails[i-1].setImage(new Image("img/sails/SailSharp.png"));
                        break;
                    }
                    case "SailBig":{
                        sails[i-1].setImage(new Image("img/sails/SailBig.png"));
                        break;
                    }
                }

            } else {
                sails[i-1].setImage(new Image("img/sails/SailEmpty.png"));
            }
        }

    }

    @Override
    public void updateGold(Ship shipPlayer, Label lblPlayerGold) {
        lblPlayerGold.setText(shipPlayer.getGold() + "g");
    }

    @Override
    public void updateFood(Ship shipPlayer, Label lblPlayerFood) {
        lblPlayerFood.setText(String.valueOf(shipPlayer.getFood()));
    }

    @Override
    public void updateAmmo(Ship shipPlayer, Label lblPlayerAmmo) {
        lblPlayerAmmo.setText(String.valueOf(shipPlayer.getAmmo()));
    }

    @Override
    public void updateCharge(Ship shipPlayer, Label lblPlayerCharge) {
        lblPlayerCharge.setText(String.valueOf(calcShipCharge(shipPlayer)));
    }

    @Override
    public void updatePower(Ship shipPlayer, Label lblPlayerPower) {
        lblPlayerPower.setText(String.valueOf(calcShipPower(shipPlayer)));
    }

    @Override
    public void updateCrewSalary(Ship shipPlayer, Label lblCrewSalary) {
        lblCrewSalary.setText(calcCrewSalary(shipPlayer) + "g");
    }

    @Override
    public void updateCrewFoodConsumption(Ship shipPlayer, Label lblCrewConsumption) {
        lblCrewConsumption.setText(calcCrewFoodConsumption(shipPlayer)+"");
    }

    @Override
    public void updateCrewProduction(Ship shipPlayer, Label lblCrewProduction) {
        lblCrewProduction.setText(calcCrewProduction(shipPlayer)+"");
    }

    @Override
    public void updateSpeed(Ship shipPlayer, Label lblPlayerSpeed) {
        lblPlayerSpeed.setText(String.valueOf(calcShipSpeed(shipPlayer)));
    }

    @Override
    public void updateManeuver(Ship shipPlayer, Label lblPLayerManeuver) {
        lblPLayerManeuver.setText(String.valueOf(calcShipManeuver(shipPlayer)));
    }

    @Override
    public void updateHp(Ship shipPlayer, Label lblPlayerHp, ProgressBar pbShipHp) {
        int maxHp = shipPlayer.getEndurance();
        int curHp = shipPlayer.getCurrentEndurance();
        pbShipHp.setProgress((double)curHp/maxHp);
        lblPlayerHp.setText(""+(curHp*100)/maxHp);
    }

    @Override
    public void takeDmg(Ship shipPlayer, int dmgTaken) {

    }

    private int calcShipCharge(Ship shipPlayer) throws IllegalArgumentException {
        if (shipPlayer.getCrewList()==null){
            throw new IllegalArgumentException("Crew are null");
        }
        int charge = 0;
        for (Crew crew : shipPlayer.getCrewList()) {
            charge+=crew.getStrength();
        }
        return charge + 5; // 5 is Capitan charge power
    }


    private int calcShipSpeed(Ship shipPlayer){
        if (shipPlayer.getSailList()==null){
            throw new IllegalArgumentException("Sails are null");
        }
        int speed = 0;
        for (Sail sail : shipPlayer.getSailList()) {
            speed+=sail.getSpeed();
        }
        return speed > 0 ? speed : 1;
    }

    private int calcShipManeuver(Ship shipPlayer) throws IllegalArgumentException {
        if (shipPlayer.getSailList()==null){
            throw new IllegalArgumentException("Sails are null");
        }
        int manu = 0;
        for (Sail sail : shipPlayer.getSailList()) {
            manu+=sail.getManeuver();
        }
        return manu;
    }

    private int calcShipPower(Ship shipPlayer) throws IllegalArgumentException{
        if (shipPlayer.getCannonList()==null){
            throw new IllegalArgumentException("Cannons are null");
        }
        int power = 0;
        for (Cannon cannon : shipPlayer.getCannonList()) {
            power+=cannon.getStrength();
        }
        return power;
    }

    private int calcCrewSalary(Ship shipPlayer) throws IllegalArgumentException{
        if (shipPlayer.getCrewList()==null){
            return 0;
        }
        int totalCrewSalary = 0;
        for (Crew crew : shipPlayer.getCrewList()) {
            totalCrewSalary+=crew.getSalary();
        }
        return totalCrewSalary;
    }

    private int calcCrewFoodConsumption(Ship shipPlayer){
        if (shipPlayer.getCrewList()==null){
            return 1;
        }
        int totalCrewFoodConsumption = 0;
        for (Crew crew : shipPlayer.getCrewList()) {
            totalCrewFoodConsumption+=crew.getConsumption();
        }
        return totalCrewFoodConsumption +1; //one provided by capitan
    }

    private int calcCrewProduction(Ship shipPlayer){
        if (shipPlayer.getCrewList()==null){
            return 0;
        }
        int totalCrewProduction = 0;
        for (Crew crew : shipPlayer.getCrewList()) {
            totalCrewProduction+=crew.getProduction();
        }
        return 0;
    }
}
