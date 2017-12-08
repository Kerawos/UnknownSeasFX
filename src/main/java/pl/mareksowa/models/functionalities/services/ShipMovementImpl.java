package pl.mareksowa.models.functionalities.services;

import javafx.scene.image.ImageView;
import pl.mareksowa.models.functionalities.ShipMovement;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.ShipPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for ship movement, possible moves, current position, allowed moves.
 */
public class ShipMovementImpl implements ShipMovement {

    /**
     * Variable declaration
     */
    private ShipPosition currentPosition;


    @Override
    public ShipPosition getShipPosition(Ship PLAYER_SHIP) {
        return PLAYER_SHIP.getShipPosition();
    }

    @Override
    public void setShipPosition(Ship PLAYER_SHIP, ShipPosition destination, ImageView ivBgPlayerShip) {
        PLAYER_SHIP.setShipPosition(destination);
        ivBgPlayerShip.setX(PLAYER_SHIP.getShipPosition().getLayoutX());
        ivBgPlayerShip.setY(PLAYER_SHIP.getShipPosition().getLayoutY());
    }

    @Override
    public ShipPosition getPositionField1() {
        return new ShipPosition(160,290);
    }

    @Override
    public ShipPosition getPositionField2() {
        return new ShipPosition(50,260);
    }

    @Override
    public ShipPosition getPositionField3() {
        return new ShipPosition(55,155);
    }

    @Override
    public ShipPosition getPositionField4() {
        return new ShipPosition(65,70);
    }

    @Override
    public ShipPosition getPositionField5() {
        return new ShipPosition(310,65);
    }

    @Override
    public ShipPosition getPositionField6() {
        return new ShipPosition(410,100);
    }

    @Override
    public ShipPosition getPositionField7() {
        return new ShipPosition(500,85);
    }

    @Override
    public ShipPosition getPositionField8() {
        return new ShipPosition(570,80);
    }

    @Override
    public ShipPosition getPositionField9() {
        return new ShipPosition(640,35);
    }

    @Override
    public ShipPosition getPositionField10() {
        return new ShipPosition(640,35);
    }

    @Override
    public ShipPosition getPositionField11() {
        return new ShipPosition(705,120);
    }

    @Override
    public ShipPosition getPositionField12() {
        return new ShipPosition(615,170);
    }

    @Override
    public ShipPosition getPositionField13() {
        return new ShipPosition(540,230);
    }

    @Override
    public ShipPosition getPositionField14() {
        return new ShipPosition(380,230);
    }

    @Override
    public ShipPosition getPositionField15() {
        return new ShipPosition(400,31705);
    }

    @Override
    public ShipPosition getPositionField16() {
        return new ShipPosition(550,330);
    }

    @Override
    public ShipPosition getPositionField17() {
        return new ShipPosition(650,315);
    }

    @Override
    public boolean isMoveAllowed(ShipPosition currentPosition, ShipPosition destination) {
        for (int i = 1; i <= getFields().size(); i++) {
            if (getFields().get(i-1).equals(currentPosition)){
                if (i==1){
                    if (destination.equals(getFields().get(i))){
                        return true;
                    }
                }
                if (i==17){
                    if (destination.equals(getFields().get(i-2))){
                        return true;
                    }
                }
                if (destination.equals(getFields().get(i-2)) || destination.equals(getFields().get(i))){
                    return true;
                }
                //exc
                if (i==7){
                    if (destination.equals(getFields().get(13))){
                        return true;
                    }
                }
                if (i==13){
                    if (destination.equals(getFields().get(15))){
                        return true;
                    }
                }
            }
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


    public ShipPosition getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(ShipPosition currentPosition) {
        this.currentPosition = currentPosition;
    }


}
