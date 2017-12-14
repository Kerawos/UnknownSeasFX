package pl.mareksowa.models;

/**
 * Imports section
 */
import org.springframework.beans.factory.annotation.Autowired;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.managers.*;
import pl.mareksowa.models.ships.Ship;

/**
 * This class will be treated as state. Available to and from all scenes in game. Holder for all services and states.
 */
public class CurrentScene
{
    /**
     * Singleton constructor
     */
    private static CurrentScene ourInstance = null;

    public static CurrentScene getInstance() {
        if (ourInstance==null){
            ourInstance = new CurrentScene();
        }
        return ourInstance;
    }

    private CurrentScene() {
    }

    /**
     * Variables declarations, from this class indicated from capital letter
     */
    private Ship shipPlayer1;
    private Ship shipPlayerCurrent;

    private City currentCity;

    /**
     * Services declarations;
     */
    @Autowired private CityManager cityManager;
    @Autowired private SceneManager sceneManager;
    @Autowired private ShipBuilderManager shipBuilderManager;
    @Autowired private ShipCrewManager shipCrewManager;
    @Autowired private ShipGeneralManager shipGeneralManager;
    @Autowired private ShipMovementManager shipMovementManager;
    @Autowired private ShipTradeManager shipTradeManager;

    /**
     * Getters and setters section
     * @return
     */
    public Ship getShipPlayer1() {
        return getShipGeneralManager().getAllShips().get(0);
    }

    public void setShipPlayer1(Ship shipPlayer1) {
        this.shipPlayer1 = shipPlayer1;
    }

    public Ship getShipPlayerCurrent() {
        //todo players change
        return getShipPlayer1();
    }

    public void setShipPlayerCurrent(Ship shipPlayerCurrent) {
        this.shipPlayerCurrent = shipPlayerCurrent;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    /**
     * Services getter section
     * @return
     */
    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public ShipGeneralManager getShipGeneralManager() {
        return shipGeneralManager;
    }

    public ShipMovementManager getShipMovementManager() {
        return shipMovementManager;
    }

    public CityManager getCityManager() {
        return cityManager;
    }

    public ShipBuilderManager getShipBuilderManager() {
        return shipBuilderManager;
    }

    public ShipCrewManager getShipCrewManager() {
        return shipCrewManager;
    }

    public ShipTradeManager getShipTradeManager() {
        return shipTradeManager;
    }

}
