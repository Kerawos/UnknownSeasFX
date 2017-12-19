package pl.mareksowa.models.managers.services;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.springframework.stereotype.Repository;
import pl.mareksowa.models.maps.FieldColor;
import pl.mareksowa.models.managers.ShipMovementManager;
import pl.mareksowa.models.sails.Sail;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.maps.MapPosition;

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
    private MapPosition currentPosition;


    @Override
    public MapPosition getShipPosition(Ship shipPlayer) {
        return shipPlayer.getMapPosition();
    }

    @Override
    public void moveShipTo(Ship shipPlayer, MapPosition destination, ImageView ivBgPlayerShip) {
        if (shipPlayer==null || destination==null || ivBgPlayerShip==null){
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        shipPlayer.setMapPosition(destination);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(500));
        translateTransition.setNode(ivBgPlayerShip);
        translateTransition.setToX(destination.getLayoutX());
        translateTransition.setToY(destination.getLayoutY());
        translateTransition.play();
    }

    @Override
    public void moveShipToFast(Ship shipPlayer, MapPosition destination, ImageView ivBgPlayerShip) {
        if (shipPlayer==null || destination==null || ivBgPlayerShip==null){
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        shipPlayer.setMapPosition(destination);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.01));
        translateTransition.setNode(ivBgPlayerShip);
        translateTransition.setToX(destination.getLayoutX());
        translateTransition.setToY(destination.getLayoutY());
        translateTransition.play();
    }


    @Override
    public void setHardShipPosition(Ship shipPlayer, MapPosition destination, ImageView ivBgPlayerShip) {
        if (shipPlayer==null || destination==null || ivBgPlayerShip==null){
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        shipPlayer.setMapPosition(destination);
        ivBgPlayerShip.setX(shipPlayer.getMapPosition().getLayoutX());
        ivBgPlayerShip.setY(shipPlayer.getMapPosition().getLayoutY());
    }

    @Override
    public MapPosition getPositionField1() {
        return new MapPosition(160,290, FieldColor.RED);
    }

    @Override
    public MapPosition getPositionField2() {
        return new MapPosition(50,245, FieldColor.RED);
    }

    @Override
    public MapPosition getPositionField3() {
        return new MapPosition(55,155, FieldColor.RED);
    }

    @Override
    public MapPosition getPositionField4() {
        return new MapPosition(70,75, FieldColor.YELLOW);
    }

    @Override
    public MapPosition getPositionField5() {
        return new MapPosition(200,60, FieldColor.YELLOW);
    }

    @Override
    public MapPosition getPositionField6() {
        return new MapPosition(295,60, FieldColor.GREEN);
    }

    @Override
    public MapPosition getPositionField7() {
        return new MapPosition(380,75, FieldColor.YELLOW);
    }

    @Override
    public MapPosition getPositionField8() {
        return new MapPosition(470,65, FieldColor.YELLOW);
    }

    @Override
    public MapPosition getPositionField9() {
        return new MapPosition(550,60, FieldColor.YELLOW);
    }

    @Override
    public MapPosition getPositionField10() {
        return new MapPosition(640,5, FieldColor.YELLOW);
    }

    @Override
    public MapPosition getPositionField11() {
        return new MapPosition(690,100, FieldColor.RED);
    }

    @Override
    public MapPosition getPositionField12() {
        return new MapPosition(605,150, FieldColor.RED);
    }

    @Override
    public MapPosition getPositionField13() {
        return new MapPosition(535,215, FieldColor.GREEN);
    }

    @Override
    public MapPosition getPositionField14() {
        return new MapPosition(380,255, FieldColor.GREEN);
    }

    @Override
    public MapPosition getPositionField15() {
        return new MapPosition(375,155, FieldColor.GREEN);
    }

    @Override
    public MapPosition getPositionField16() {
        return new MapPosition(550,320, FieldColor.GREEN);
    }

    @Override
    public MapPosition getPositionField17() {
        return new MapPosition(640,335, FieldColor.GREEN);
    }

    @Override
    public boolean isMoveAllowed(MapPosition currentPosition, MapPosition destination) {
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
    public boolean isEnterCityAllowed(MapPosition currentPosition, MapPosition cityToEnterPosition) {
        if (currentPosition.equals(cityToEnterPosition)){
            return true;
        }
        return false;
    }

    private List<MapPosition> getFields(){
        List<MapPosition> fields = new ArrayList<>();
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
        if (shipPlayer==null){
            throw new IllegalArgumentException("Ship cannot be null");
        }
        if (getRemainShipMove(shipPlayer)>=moveToPerform && moveToPerform>0){
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


    public MapPosition getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(MapPosition currentPosition) {
        this.currentPosition = currentPosition;
    }



}
