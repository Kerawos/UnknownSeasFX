package pl.mareksowa.controllers;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.dao.impl.ShipDaoImpl;

import java.io.IOException;

public class Menu {

    private static Menu ourInstance = new Menu();

    public static Menu getInstance(){
        return ourInstance;
    }

    private Menu(){

    }

    public void exitGame(){
        Platform.exit();
        System.exit(0);
    }

    public void sceneChange(Stage stageName, String sceneName){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(sceneName));
            stageName.setScene(new Scene(root, 800, 640));
            stageName.setResizable(false);
            stageName.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
