package pl.mareksowa.models.managers.services;

/**
 * Imports section
 */
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.sails.Sail;
import pl.mareksowa.models.ships.Ship;

import java.util.ArrayList;

/**
 * Service responsible for trading and market on the ship.
 */
@Repository
public class ShipTradeManagerImpl implements pl.mareksowa.models.managers.ShipTradeManager {


    @Override
    public boolean canBuyGood(Ship shipPlayer, Good goodToBuy) {
        if (shipPlayer.getStorageCapacity()>shipPlayer.getStorage().size() &&
                shipPlayer.getGold()>=goodToBuy.getPrice()){
            return true;
        }
        return false;
    }

    @Override
    public void buyGood(Ship shipPlayer, Good goodToBuy) {
        shipPlayer.setGold(shipPlayer.getGold() - goodToBuy.getPrice());
        shipPlayer.getStorage().add(goodToBuy);
    }

    @Override
    public boolean canSellGood(Ship shipPlayer, int storageListNo) {
        if (shipPlayer.getStorage().size()>0){
            for (int i = 0; i < shipPlayer.getStorage().size(); i++) {
                if (shipPlayer.getStorage().get(i).getName()==shipPlayer.getStorage().get(storageListNo).getName()){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void sellGood(Ship shipPlayer, Good goodToSell, int sellPrice) {
        for (int i = 0; i < shipPlayer.getStorage().size(); i++) {
            if (shipPlayer.getStorage().get(i).getName()==goodToSell.getName()){
                shipPlayer.getStorage().remove(i);
                shipPlayer.setGold(shipPlayer.getGold() + sellPrice);
                break;
            }
        }
    }

    @Override
    public boolean canBuySail(Ship shipPlayer, Sail sailToBuy, Label lblUpperText) {
        if (shipPlayer.getSailList()==null){
            shipPlayer.setSailList(new ArrayList<>());
        }
        if (shipPlayer.getGold()>= sailToBuy.getPrice()){
            if (shipPlayer.getSailCapacity() > shipPlayer.getSailList().size()){
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
    public void buySail(Ship shipPlayer, Sail sailToBuy) {
        shipPlayer.getSailList().add(sailToBuy);
        shipPlayer.setGold(shipPlayer.getGold()- sailToBuy.getPrice());
    }

    @Override
    public boolean canSellSail(Ship shipPlayer, int sailsListNo) {
        if (shipPlayer.getSailList().size()>0){
            String givenSailName = shipPlayer.getSailList().get(sailsListNo).getClass().getName();
            givenSailName = givenSailName.substring(givenSailName.lastIndexOf(".")+1, givenSailName.length());
            for (int i = 0; i < shipPlayer.getSailList().size(); i++) {
                String currentSailName = shipPlayer.getSailList().get(i).getClass().getName();
                currentSailName = currentSailName.substring(currentSailName.lastIndexOf(".")+1, currentSailName.length());
                if (currentSailName.equals(givenSailName)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void sellSail(Ship shipPlayer, Sail sailToSell) {
        for (int i = 0; i < shipPlayer.getSailList().size(); i++) {
            if (shipPlayer.getSailList().get(i).equals(sailToSell)){
                shipPlayer.setGold(shipPlayer.getGold() + sailToSell.getPrice());
                shipPlayer.getSailList().remove(i);
                break;
            }
        }
    }

    @Override
    public boolean canBuyCannon(Ship shipPlayer, Cannon cannonToAdd, Label lblUpperText) {
        if (shipPlayer.getGold()>= cannonToAdd.getPrice()){
            if (shipPlayer.getCannonCapacity() > shipPlayer.getCannonList().size()){
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
    public void buyCannon(Ship shipPlayer, Cannon cannonToAdd) {
        shipPlayer.getCannonList().add(cannonToAdd);
        shipPlayer.setGold(shipPlayer.getGold()- cannonToAdd.getPrice());
    }

    @Override
    public boolean canSellCannon(Ship shipPlayer, int cannonsListNo) {
        if (shipPlayer.getCannonList().size()>0){
            String givenCannonName = shipPlayer.getCannonList().get(cannonsListNo).getClass().getName();
            givenCannonName = givenCannonName.substring(givenCannonName.lastIndexOf(".")+1, givenCannonName.length());
            for (int i = 0; i < shipPlayer.getCannonList().size(); i++) {
                String currentCannonName = shipPlayer.getCannonList().get(i).getClass().getName();
                currentCannonName = currentCannonName.substring(currentCannonName.lastIndexOf(".")+1, currentCannonName.length());
                if (currentCannonName.equals(givenCannonName)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void sellCannon(Ship shipPlayer, Cannon cannonToSell) {
        for (int i = 0; i < shipPlayer.getCannonList().size(); i++) {
            if (shipPlayer.getCannonList().get(i).equals(cannonToSell)){
                shipPlayer.setGold(shipPlayer.getGold() + cannonToSell.getPrice());
                shipPlayer.getCannonList().remove(i);
                break;
            }
        }
    }

    @Override
    public boolean canBuyAmmo(Ship shipPlayer, int ammoQty, Label lblPlayerAmmo) {
        if (shipPlayer.getGold()>=ammoQty){
            return true;
        }
        lblPlayerAmmo.setText("you don't have enough gold..");
        return false;
    }

    @Override
    public void buyAmmo(Ship shipPlayer, int ammoQty) {
        shipPlayer.setGold(shipPlayer.getGold() - ammoQty);
        shipPlayer.setAmmo(shipPlayer.getAmmo() + ammoQty);
    }

    @Override
    public void buyAmmo6(Ship shipPlayer) {
        shipPlayer.setGold(shipPlayer.getGold() - 5);
        shipPlayer.setAmmo(shipPlayer.getAmmo() + 6);
    }
}
