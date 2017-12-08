package pl.mareksowa.models.functionalities;

import javafx.scene.image.ImageView;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.ShipPosition;

public interface ShipMovement {
    ShipPosition getShipPosition(Ship PLAYER_SHIP);
    void setShipPosition(Ship PLAYER_SHIP, ShipPosition shipPosition, ImageView ivBgPlayerShip);
}
