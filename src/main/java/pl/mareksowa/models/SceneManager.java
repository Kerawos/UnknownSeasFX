package pl.mareksowa.models;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.omg.CORBA.PRIVATE_MEMBER;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.cities.CityName;
import pl.mareksowa.models.functionalities.CityFunctionality;
import pl.mareksowa.models.functionalities.ShipFunctionality;
import pl.mareksowa.models.functionalities.services.CityManager;
import pl.mareksowa.models.functionalities.services.ShipManager;
import pl.mareksowa.models.ships.Ship;

import java.io.IOException;

public class SceneManager {

    private static SceneManager ourInstance = null;
    public String backStage = null;
    private Ship PLAYER_SHIP;
    private City CURRENT_CITY;
    private ShipFunctionality shipFunctionality;
    private CityFunctionality cityFunctionality;

    private SceneManager(){
        shipFunctionality = new ShipManager();
        cityFunctionality = new CityManager();
    }

    public static SceneManager getInstance(){
        if (ourInstance==null){
            ourInstance = new SceneManager();
        }
        return ourInstance;
    }

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


    public String getBackStage() {
        return backStage;
    }

    public void setBackStage(String backStage) {
        this.backStage = backStage;
    }

    public static void exitGame(){
        Platform.exit();
        System.exit(1);
    }


    public Ship getPLAYER_SHIP() {
        return PLAYER_SHIP;
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
