package pl.mareksowa.models.managers;

import javafx.scene.image.ImageView;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.ShipPosition;

@Service
public interface ShipMovementManager {
    ShipPosition getShipPosition(Ship shipPlayer);
    void moveShipTo(Ship shipPlayer, ShipPosition destination, ImageView ivBgPlayerShip);
    void moveShipToFast(Ship shipPlayer, ShipPosition destination, ImageView ivBgPlayerShip);
    void setHardShipPosition(Ship shipPlayer, ShipPosition destination, ImageView ivBgPlayerShip);
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
    boolean isEnterCityAllowed(ShipPosition currentPosition, ShipPosition cityToEnterPosition);
    int getRemainShipMove(Ship shipPlayer);
    boolean canShipMove(Ship shipPlayer, int moveToPerform);
    void updateShipMove(Ship shipPlayer, int moveToPerform);
    void refreshShipMove(Ship shipPlayer);
}
