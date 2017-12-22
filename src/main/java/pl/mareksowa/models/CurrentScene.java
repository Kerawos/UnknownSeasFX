package pl.mareksowa.models;

/**
 * Imports section
 */
import org.springframework.beans.factory.annotation.Autowired;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.managers.*;
import pl.mareksowa.models.managers.services.*;
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

//    private CityManager cityManager;
//    private SceneManager sceneManager;
//    private ShipBuilderManager shipBuilderManager;
//    private ShipCrewManager shipCrewManager;
//    private ShipGeneralManager shipGeneralManager;
//    private ShipMovementManager shipMovementManager;
//    private ShipTradeManager shipTradeManager;
//    private EncounterManager encounterManager;
//
//    @Autowired
//    private CurrentScene(CityManager cityManager, SceneManager sceneManager, ShipBuilderManager shipBuilderManager,
//                         ShipCrewManager shipCrewManager, ShipGeneralManager shipGeneralManager, ShipMovementManager
//                                 shipMovementManager, ShipTradeManager shipTradeManager, EncounterManager encounterManager) {
//        this.cityManager = cityManager;
//        this.sceneManager = sceneManager;
//        this.shipBuilderManager = shipBuilderManager;
//        this.shipCrewManager = shipCrewManager;
//        this.shipGeneralManager = shipGeneralManager;
//        this.shipMovementManager = shipMovementManager;
//        this.shipTradeManager = shipTradeManager;
//        this.encounterManager = encounterManager;
//    }

//    @Autowired private CurrentScene(){
//        this.cityManager = cityManager;
//        this.sceneManager = sceneManager;
//        this.shipBuilderManager = shipBuilderManager;
//        this.shipCrewManager = shipCrewManager;
//        this.shipGeneralManager = shipGeneralManager;
//        this.shipMovementManager = shipMovementManager;
//        this.shipTradeManager = shipTradeManager;
//        this.encounterManager = encounterManager;
//    }

    /**
     * Variables declarations, from this class indicated from capital letter
     */
    private Ship shipPlayer1;
    private Ship shipPlayerCurrent;

    private City currentCity;

    /**
     * Services declarations;
     */
    //todo SPRING NOT WORK ('new' required at this moment ... ;(
    @Autowired private CityManager cityManager = new CityManagerImpl();
    @Autowired private SceneManager sceneManager = new SceneManagerImpl();
    @Autowired private ShipBuilderManager shipBuilderManager = new ShipBuilderManagerImpl();
    @Autowired private ShipCrewManager shipCrewManager = new ShipCrewManagerImpl();
    @Autowired private ShipGeneralManager shipGeneralManager = new ShipGeneralManagerImpl();
    @Autowired private ShipMovementManager shipMovementManager = new ShipMovementManagerImpl();
    @Autowired private ShipTradeManager shipTradeManager = new ShipTradeManagerImpl();
    @Autowired private EncounterManager encounterManager = new EncounterManager();

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

    public EncounterManager getEncounterManager() {
        return encounterManager;
    }
}
