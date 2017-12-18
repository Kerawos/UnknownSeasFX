package pl.mareksowa.models.managers;

import javafx.scene.image.ImageView;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.maps.MapPosition;

@Service
public interface ShipMovementManager {
    MapPosition getShipPosition(Ship shipPlayer);
    void moveShipTo(Ship shipPlayer, MapPosition destination, ImageView ivBgPlayerShip);
    void moveShipToFast(Ship shipPlayer, MapPosition destination, ImageView ivBgPlayerShip);
    void setHardShipPosition(Ship shipPlayer, MapPosition destination, ImageView ivBgPlayerShip);
    MapPosition getPositionField1();
    MapPosition getPositionField2();
    MapPosition getPositionField3();
    MapPosition getPositionField4();
    MapPosition getPositionField5();
    MapPosition getPositionField6();
    MapPosition getPositionField7();
    MapPosition getPositionField8();
    MapPosition getPositionField9();
    MapPosition getPositionField10();
    MapPosition getPositionField11();
    MapPosition getPositionField12();
    MapPosition getPositionField13();
    MapPosition getPositionField14();
    MapPosition getPositionField15();
    MapPosition getPositionField16();
    MapPosition getPositionField17();
    boolean isMoveAllowed(MapPosition currentPosition, MapPosition destination);
    boolean isEnterCityAllowed(MapPosition currentPosition, MapPosition cityToEnterPosition);
    int getRemainShipMove(Ship shipPlayer);
    boolean canShipMove(Ship shipPlayer, int moveToPerform);
    void updateShipMove(Ship shipPlayer, int moveToPerform);
    void refreshShipMove(Ship shipPlayer);
}
