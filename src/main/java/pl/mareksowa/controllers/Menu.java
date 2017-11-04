package pl.mareksowa.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    @FXML
    private ImageView ivStorage1;

    @FXML
    private ImageView ivStorage2;

    @FXML
    private ImageView ivStorage3;

    @FXML
    private ImageView ivStorage4;

    @FXML
    private ImageView ivStorage5;

    @FXML
    private ImageView ivStorage6;

    @FXML
    private ImageView ivStorage7;

    @FXML
    private ImageView ivStorage8;

    @FXML
    private ImageView ivStorage9;

    @FXML
    private ImageView ivStorage10;

    public void loadStorage(){

    }

}
