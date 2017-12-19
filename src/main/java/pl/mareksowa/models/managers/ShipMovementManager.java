package pl.mareksowa.models.managers;

/**
 * Import section
 */
import javafx.scene.image.ImageView;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.maps.MapPosition;

/**
 * Service responsible for general movement on the map, not specified.
 */
@Service
public interface ShipMovementManager {
    /**
     * Method determines position of given ship
     * @param shipPlayer
     * @return current ship location on the map
     */
    MapPosition getShipPosition(Ship shipPlayer);

    /**
     * Method changing current position of the ship to given position. It updates ship movement animation
     * @param shipPlayer
     * @param destination
     * @param ivBgPlayerShip
     */
    void moveShipTo(Ship shipPlayer, MapPosition destination, ImageView ivBgPlayerShip);

    /**
     * Method changing current position of the ship to given position. It updates very fast ship movement animation
     * @param shipPlayer
     * @param destination
     * @param ivBgPlayerShip
     */
    void moveShipToFast(Ship shipPlayer, MapPosition destination, ImageView ivBgPlayerShip);

    /**
     * Method determining ship position without animation
     * @param shipPlayer
     * @param destination
     * @param ivBgPlayerShip
     */
    void setHardShipPosition(Ship shipPlayer, MapPosition destination, ImageView ivBgPlayerShip);

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField1();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField2();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField3();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField4();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField5();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField6();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField7();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField8();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField9();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField10();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField11();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField12();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField13();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField14();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField15();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField16();

    /**
     * Method find already defined map position of world map
     * @return required position
     */
    MapPosition getPositionField17();

    /**
     * Method checks if move on the map can be make, checks if given map field are adjacent
     * @param currentPosition
     * @param destination
     * @return true if conditions are fit
     */
    boolean isMoveAllowed(MapPosition currentPosition, MapPosition destination);

    /**
     * Method checks if player is in the same position as given city is located
     * @param currentPosition
     * @param cityToEnterPosition
     * @return true if conditions are fit
     */
    boolean isEnterCityAllowed(MapPosition currentPosition, MapPosition cityToEnterPosition);

    /**
     * @param shipPlayer
     * @return remaning move points
     */
    int getRemainShipMove(Ship shipPlayer);

    /**
     * Method checks if given ship can perform move, check if ship have some move left
     * @param shipPlayer
     * @param moveToPerform
     * @return true if conditions are fit
     */
    boolean canShipMove(Ship shipPlayer, int moveToPerform);

    /**
     * Method assigned remaning move points after move is performed
     * @param shipPlayer
     * @param moveToPerform
     */
    void updateShipMove(Ship shipPlayer, int moveToPerform);

    /**
     * Method reset all move points that ship have
     * @param shipPlayer
     */
    void refreshShipMove(Ship shipPlayer);
}
