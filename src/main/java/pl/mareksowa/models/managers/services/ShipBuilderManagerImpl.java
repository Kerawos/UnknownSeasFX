package pl.mareksowa.models.managers.services;

/**
 * Imports section
 */

import javafx.scene.control.Label;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.ships.Ship;

/**
 * Service responsible for implements listed interface - core ship upgrades like rebuilding ship, space, and extra places to additions.
 */
@Repository
public class ShipBuilderManagerImpl implements pl.mareksowa.models.managers.ShipBuilderManager {

    @Override
    public boolean canBuyStorage(Ship shipPlayer, Label lblUpperText) {
        if (shipPlayer.getStorageCapacity()>9){
            lblUpperText.setText("There is no more space in the ship");
            return false;
        }
        int storagePrice = shipPlayer.getStorageCapacity() * shipPlayer.getStorageCapacity()
                + shipPlayer.getStorageCapacity();
        if (shipPlayer.getGold()>= storagePrice){
            return true;
        } else {
            lblUpperText.setText("You don't have enough gold..");
            return false;
        }
    }

    @Override
    public void addStorage(Ship shipPlayer) {
        if (shipPlayer==null){
            throw new IllegalArgumentException("Ship cannot be null");
        }
        shipPlayer.setGold(shipPlayer.getGold() - (shipPlayer.getStorageCapacity() * shipPlayer.getStorageCapacity()
                + shipPlayer.getStorageCapacity()));
        shipPlayer.setStorageCapacity(shipPlayer.getStorageCapacity()+1);
    }

    @Override
    public boolean canBuyCannonSpace(Ship shipPlayer, Label lblUpperText) {
        if (shipPlayer.getCannonCapacity()>9){
            lblUpperText.setText("There is no more space in the ship");
            return false;
        }
        int cannonPrice = shipPlayer.getCannonCapacity() * shipPlayer.getCannonCapacity()
                + shipPlayer.getCannonCapacity()+5;
        if (shipPlayer.getGold()>= cannonPrice){
            return true;
        } else {
            lblUpperText.setText("You don't have enough gold..");
            return false;
        }
    }

    @Override
    public void addCannonSpace(Ship shipPlayer) {
        shipPlayer.setGold(shipPlayer.getGold()- (shipPlayer.getCannonCapacity() * shipPlayer.getCannonCapacity()
                + shipPlayer.getCannonCapacity()+5));
        shipPlayer.setCannonCapacity(shipPlayer.getCannonCapacity() + 1);
    }

    @Override
    public boolean canBuyCabin(Ship shipPlayer, Label lblUpperText) {
        if (shipPlayer.getCabinCapacity()>9){
            lblUpperText.setText("There is no more space in the ship");
            return false;
        }
        int cabinPrice = shipPlayer.getCabinCapacity() * shipPlayer.getCabinCapacity()
                + shipPlayer.getCabinCapacity()+1;
        if (shipPlayer.getGold()>= cabinPrice){
            return true;
        } else {
            lblUpperText.setText("You don't have enough gold..");
            return false;
        }
    }

    @Override
    public void addCabin(Ship shipPlayer) {
        shipPlayer.setGold(shipPlayer.getGold()- (shipPlayer.getCabinCapacity() * shipPlayer.getCabinCapacity()
                + shipPlayer.getCabinCapacity()+1));
        shipPlayer.setCabinCapacity(shipPlayer.getCabinCapacity()+1);
    }

    @Override
    public boolean canBuySailSpace(Ship shipPlayer, Label lblUpperText) {
        if (shipPlayer.getSailCapacity()>9){
            lblUpperText.setText("There is no more space in the ship");
            return false;
        }
        int sailPrice = shipPlayer.getSailCapacity()
                * shipPlayer.getSailCapacity() + shipPlayer.getSailCapacity()+10;
        if (shipPlayer.getGold()>= sailPrice){
            return true;
        } else {
            lblUpperText.setText("You don't have enough gold..");
            return false;
        }
    }

    @Override
    public void addSailSpace(Ship shipPlayer) {
        shipPlayer.setGold(shipPlayer.getGold() - (shipPlayer.getSailCapacity()
                * shipPlayer.getSailCapacity() + shipPlayer.getSailCapacity()+10));
        shipPlayer.setSailCapacity(shipPlayer.getSailCapacity() + 1);
    }

    @Override
    public boolean canRepair(Ship shipPlayer, int toRepair, Label lblUpperText) {
        if (shipPlayer.getCurrentEndurance() < shipPlayer.getEndurance()){
            if (shipPlayer.getGold() >= toRepair){
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
    public void repair(Ship shipPlayer, int toRepair) {
        shipPlayer.setGold(shipPlayer.getGold() - toRepair);
        shipPlayer.setCurrentEndurance(shipPlayer.getCurrentEndurance() + toRepair);
    }
}
