package pl.mareksowa.models.functionalities.services;

import javafx.scene.image.ImageView;
import pl.mareksowa.models.functionalities.ShipMovement;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.ShipPosition;

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
    public void setShipPosition(Ship PLAYER_SHIP, ShipPosition shipPosition, ImageView ivBgPlayerShip) {
        PLAYER_SHIP.setShipPosition(shipPosition);
        ivBgPlayerShip.setX(PLAYER_SHIP.getShipPosition().getLayoutX());
        ivBgPlayerShip.setY(PLAYER_SHIP.getShipPosition().getLayoutY());
    }

    @Override
    public ShipPosition getPositionField1() {
        return null;
    }

    @Override
    public ShipPosition getPositionField2() {
        return null;
    }

    @Override
    public ShipPosition getPositionField3() {
        return null;
    }

    @Override
    public ShipPosition getPositionField4() {
        return null;
    }

    @Override
    public ShipPosition getPositionField5() {
        return null;
    }

    @Override
    public ShipPosition getPositionField6() {
        return null;
    }

    @Override
    public ShipPosition getPositionField7() {
        return null;
    }

    @Override
    public ShipPosition getPositionField8() {
        return null;
    }

    @Override
    public ShipPosition getPositionField9() {
        return null;
    }

    @Override
    public ShipPosition getPositionField10() {
        return null;
    }

    @Override
    public ShipPosition getPositionField11() {
        return null;
    }

    @Override
    public ShipPosition getPositionField12() {
        return null;
    }

    @Override
    public ShipPosition getPositionField13() {
        return null;
    }

    @Override
    public ShipPosition getPositionField14() {
        return new ShipPosition(370,250);
    }

    @Override
    public ShipPosition getPositionField15() {
        return null;
    }

    @Override
    public ShipPosition getPositionField16() {
        return null;
    }

    @Override
    public ShipPosition getPositionField17() {
        return null;
    }


    public ShipPosition getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(ShipPosition currentPosition) {
        this.currentPosition = currentPosition;
    }


}
