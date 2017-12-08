package pl.mareksowa.models.functionalities.services;

import pl.mareksowa.models.ships.ShipPosition;

import java.util.List;

/**
 * Class responsible for ship movement, possible moves, current position, allowed moves.
 */
public class ShipMovement {

    /**
     * Variable declaration
     */
    private ShipPosition currentPosition;
    private ShipPosition FIELD_1;
    private ShipPosition FIELD_2;
    private ShipPosition FIELD_3;
    private ShipPosition FIELD_4;
    private ShipPosition FIELD_5;
    private ShipPosition FIELD_6;
    private ShipPosition FIELD_7;
    private ShipPosition FIELD_8;
    private ShipPosition FIELD_9;
    private ShipPosition FIELD_10;
    private ShipPosition FIELD_11;
    private ShipPosition FIELD_12;
    private ShipPosition FIELD_13;
    private ShipPosition FIELD_14;
    private ShipPosition FIELD_15;
    private ShipPosition FIELD_16;
    private ShipPosition FIELD_17;


    private List<ShipPosition> safd;

    public ShipPosition getFIELD_1() {
        return new ShipPosition(370,250);
    }

    public ShipPosition getFIELD_2() {
        return FIELD_2;
    }

    public ShipPosition getFIELD_3() {
        return FIELD_3;
    }

    public ShipPosition getFIELD_4() {
        return FIELD_4;
    }

    public ShipPosition getFIELD_5() {
        return FIELD_5;
    }

    public ShipPosition getFIELD_6() {
        return FIELD_6;
    }

    public ShipPosition getFIELD_7() {
        return FIELD_7;
    }

    public ShipPosition getFIELD_8() {
        return FIELD_8;
    }

    public ShipPosition getFIELD_9() {
        return FIELD_9;
    }

    public ShipPosition getFIELD_10() {
        return FIELD_10;
    }

    public ShipPosition getFIELD_11() {
        return FIELD_11;
    }

    public ShipPosition getFIELD_12() {
        return FIELD_12;
    }

    public ShipPosition getFIELD_13() {
        return FIELD_13;
    }

    public ShipPosition getFIELD_14() {
        return FIELD_14;
    }

    public ShipPosition getFIELD_15() {
        return FIELD_15;
    }

    public ShipPosition getFIELD_16() {
        return FIELD_16;
    }

    public ShipPosition getFIELD_17() {
        return FIELD_17;
    }

    public ShipPosition getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(ShipPosition currentPosition) {
        this.currentPosition = currentPosition;
    }
}
