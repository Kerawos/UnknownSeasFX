package pl.mareksowa.models;
/**
 * Imports section
 */
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.cities.CityName;
import pl.mareksowa.models.functionalities.CityFunctionality;
import pl.mareksowa.models.functionalities.ShipFunctionality;
import pl.mareksowa.models.functionalities.services.CityManager;
import pl.mareksowa.models.functionalities.services.ShipManager;
import pl.mareksowa.models.ships.Ship;

import java.io.IOException;

/**
 * Singleton class which contain all managers. Holding current scene info, current state of player ship. Calling Scene
 * manager we can change directly scene also manage player ship.
 */
public class SceneManager {
    /**
     * Variables declarations
     */
    private static SceneManager ourInstance = null;
    public String backStage = null;
    private Ship PLAYER_SHIP;
    private City CURRENT_CITY;
    private ShipFunctionality shipFunctionality;
    private CityFunctionality cityFunctionality;

    /**
     * Managers already set
     */
    private SceneManager(){
        setShipFunctionality(new ShipManager());
        setCityFunctionality(new CityManager());
    }

    /**
     * singleton construction
     */
    public static SceneManager getInstance(){
        if (ourInstance==null){
            ourInstance = new SceneManager();
        }
        return ourInstance;
    }

    /**
     * Basic method to change scene from one to another
     * @param stageName name for scene.
     * @param sceneName real name of fxml file holding scene view.
     */
    public void sceneChange(Stage stageName, String sceneName){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(sceneName));
            stageName.setScene(new Scene(root, 800, 640));
            stageName.setOnCloseRequest(stage-> exitGame());
            stageName.setResizable(false);
            stageName.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method allowing exit program.
     */
    public static void exitGame(){
        Platform.exit();
        System.exit(1);
    }

    /**
     * Getters and Setters section
     */
    public String getBackStage() {
        return backStage;
    }

    public void setBackStage(String backStage) {
        this.backStage = backStage;
    }

    public Ship getPLAYER_SHIP() {
        return shipFunctionality.getAllShips().get(0);
    }

    public void setPLAYER_SHIP(Ship PLAYER_SHIP) {
        this.PLAYER_SHIP = PLAYER_SHIP;
    }

    public City getCURRENT_CITY() {
        return CURRENT_CITY;
    }

    public void setCURRENT_CITY(CityName cityName) throws IllegalArgumentException{
        if (isCityExist(cityName)){
            cityFunctionality.getAllCities().forEach(city -> {
                if (cityName==city.getCityName()){
                    CURRENT_CITY = city;
                }
            });
        } else {
            throw new IllegalArgumentException("City no exist");
        }
    }

    public boolean isCityExist(CityName cityName){
        for (City city : cityFunctionality.getAllCities()) {
            if (city.getCityName()==cityName){
                return true;
            }
        }
        return false;
    }

    public ShipFunctionality getShipFunctionality() {
        return shipFunctionality;
    }

    public void setShipFunctionality(ShipFunctionality shipFunctionality) {
        this.shipFunctionality = shipFunctionality;
    }

    public CityFunctionality getCityFunctionality() {
        return cityFunctionality;
    }

    public void setCityFunctionality(CityFunctionality cityFunctionality) {
        this.cityFunctionality = cityFunctionality;
    }
}
