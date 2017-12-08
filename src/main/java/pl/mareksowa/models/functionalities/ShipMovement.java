package pl.mareksowa.models.functionalities;

import javafx.scene.image.ImageView;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.ShipPosition;

public interface ShipMovement {
    ShipPosition getShipPosition(Ship PLAYER_SHIP);
    void setShipPosition(Ship PLAYER_SHIP, ShipPosition destination, ImageView ivBgPlayerShip);
    ShipPosition getPositionField1();
    ShipPosition getPositionField2();
    ShipPosition getPositionField3();
    ShipPosition getPositionField4();
    ShipPosition getPositionField5();
    ShipPosition getPositionField6();
    ShipPosition getPositionField7();
    ShipPosition getPositionField8();
    ShipPosition getPositionField9();
    ShipPosition getPositionField10();
    ShipPosition getPositionField11();
    ShipPosition getPositionField12();
    ShipPosition getPositionField13();
    ShipPosition getPositionField14();
    ShipPosition getPositionField15();
    ShipPosition getPositionField16();
    ShipPosition getPositionField17();
    boolean isMoveAllowed(ShipPosition currentPosition, ShipPosition destination);

}
