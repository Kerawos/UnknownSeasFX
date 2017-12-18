package pl.mareksowa.models.managers.services;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.managers.ShipMovementManager;
import pl.mareksowa.models.sails.Sail;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.ShipPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Service responsible for ship movement, possible moves, current position, allowed moves.
 */
@Repository
public class ShipMovementManagerImpl implements ShipMovementManager {

    /**
     * Variable declaration
     */
    private ShipPosition currentPosition;


    @Override
    public ShipPosition getShipPosition(Ship shipPlayer) {
        return shipPlayer.getShipPosition();
    }

    @Override
    public void moveShipTo(Ship shipPlayer, ShipPosition destination, ImageView ivBgPlayerShip) {
        shipPlayer.setShipPosition(destination);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.setNode(ivBgPlayerShip);
        translateTransition.setToX(destination.getLayoutX());
        translateTransition.setToY(destination.getLayoutY());
        translateTransition.play();
    }

    @Override
    public void moveShipToFast(Ship shipPlayer, ShipPosition destination, ImageView ivBgPlayerShip) {
        shipPlayer.setShipPosition(destination);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.01));
        translateTransition.setNode(ivBgPlayerShip);
        translateTransition.setToX(destination.getLayoutX());
        translateTransition.setToY(destination.getLayoutY());
        translateTransition.play();
    }


    @Override
    public void setHardShipPosition(Ship shipPlayer, ShipPosition destination, ImageView ivBgPlayerShip) {
        shipPlayer.setShipPosition(destination);
        ivBgPlayerShip.setX(shipPlayer.getShipPosition().getLayoutX());
        ivBgPlayerShip.setY(shipPlayer.getShipPosition().getLayoutY());
    }

    @Override
    public ShipPosition getPositionField1() {
        return new ShipPosition(160,290);
    }

    @Override
    public ShipPosition getPositionField2() {
        return new ShipPosition(50,245);
    }

    @Override
    public ShipPosition getPositionField3() {
        return new ShipPosition(55,155);
    }

    @Override
    public ShipPosition getPositionField4() {
        return new ShipPosition(70,75);
    }

    @Override
    public ShipPosition getPositionField5() {
        return new ShipPosition(200,60);
    }

    @Override
    public ShipPosition getPositionField6() {
        return new ShipPosition(295,60);
    }

    @Override
    public ShipPosition getPositionField7() {
        return new ShipPosition(380,75);
    }

    @Override
    public ShipPosition getPositionField8() {
        return new ShipPosition(470,65);
    }

    @Override
    public ShipPosition getPositionField9() {
        return new ShipPosition(550,60);
    }

    @Override
    public ShipPosition getPositionField10() {
        return new ShipPosition(640,5);
    }

    @Override
    public ShipPosition getPositionField11() {
        return new ShipPosition(690,100);
    }

    @Override
    public ShipPosition getPositionField12() {
        return new ShipPosition(605,150);
    }

    @Override
    public ShipPosition getPositionField13() {
        return new ShipPosition(535,215);
    }

    @Override
    public ShipPosition getPositionField14() {
        return new ShipPosition(380,255);
    }

    @Override
    public ShipPosition getPositionField15() {
        return new ShipPosition(375,155);
    }

    @Override
    public ShipPosition getPositionField16() {
        return new ShipPosition(550,320);
    }

    @Override
    public ShipPosition getPositionField17() {
        return new ShipPosition(640,335);
    }

    @Override
    public boolean isMoveAllowed(ShipPosition currentPosition, ShipPosition destination) {
        for (int i = 0; i < getFields().size(); i++) {
            if (getFields().get(i).equals(currentPosition)){
                if (i==0){
                    if (destination.equals(getFields().get(i+1))){
                        return true;
                    }
                    break;
                }
                if (i==16){
                    if (destination.equals(getFields().get(i-1))){
                        return true;
                    }
                    break;
                }
                if (destination.equals(getFields().get(i-1)) || destination.equals(getFields().get(i+1))){
                    return true;
                }
                //exc
                if (i==6){
                    if (destination.equals(getFields().get(14))){
                        return true;
                    }
                    break;
                }
                if (i==14){
                    if (destination.equals(getFields().get(6))){
                        return true;
                    }
                    break;
                }
                if (i==12){
                    if (destination.equals(getFields().get(15))){
                        return true;
                    }
                    break;
                }
                if (i==15){
                    if (destination.equals(getFields().get(12))){
                        return true;
                    }
                    break;
                }

            }
        }
        return false;
    }

    @Override
    public boolean isEnterCityAllowed(ShipPosition currentPosition, ShipPosition cityToEnterPosition) {
        if (currentPosition.equals(cityToEnterPosition)){
            return true;
        }
        return false;
    }

    private List<ShipPosition> getFields(){
        List<ShipPosition> fields = new ArrayList<>();
        fields.add(getPositionField1());
        fields.add(getPositionField2());
        fields.add(getPositionField3());
        fields.add(getPositionField4());
        fields.add(getPositionField5());
        fields.add(getPositionField6());
        fields.add(getPositionField7());
        fields.add(getPositionField8());
        fields.add(getPositionField9());
        fields.add(getPositionField10());
        fields.add(getPositionField11());
        fields.add(getPositionField12());
        fields.add(getPositionField13());
        fields.add(getPositionField14());
        fields.add(getPositionField15());
        fields.add(getPositionField16());
        fields.add(getPositionField17());
        return fields;
    }

    @Override
    public int getRemainShipMove(Ship shipPlayer) {
        //return shipPlayer.getMovePossibility()>0?shipPlayer.getMovePossibility():1;
        return shipPlayer.getMovePossibility();
    }

    @Override
    public boolean canShipMove(Ship shipPlayer, int moveToPerform) {
        if (getRemainShipMove(shipPlayer)>=moveToPerform){
            return true;
        }
        return false;
    }

    @Override
    public void updateShipMove(Ship shipPlayer, int moveToPerform) {
        shipPlayer.setMovePossibility(shipPlayer.getMovePossibility() - moveToPerform);
    }

    @Override
    public void refreshShipMove(Ship shipPlayer) {
        int move = 0;
        for (Sail sail : shipPlayer.getSailList()) {
            move+=sail.getSpeed();
        }
        shipPlayer.setMovePossibility((move/10)>0?(move/10):1);
    }


    public ShipPosition getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(ShipPosition currentPosition) {
        this.currentPosition = currentPosition;
    }



}
