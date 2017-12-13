package pl.mareksowa.models.managers.services;

/**
 * Imports section
 */
import javafx.scene.control.Label;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.sails.Sail;
import pl.mareksowa.models.ships.Ship;

import java.util.ArrayList;

/**
 * Service responsible for trading and market on the ship.
 */
@Service
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
        return false;
    }

    @Override
    public void buyCannon(Ship shipPlayer, Cannon cannonToAdd) {

    }

    @Override
    public boolean canBuyArmor(Ship shipPlayer, Label lblUpperText) {
        return false;
    }

    @Override
    public void buyArmor(Ship shipPlayer) {

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
