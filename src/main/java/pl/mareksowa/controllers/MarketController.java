package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class MarketController extends PlayerShipController implements Initializable {

    @FXML private Button btnBack;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScene();
        buttonsRegister();
        showTutorial();
    }

    /**
     * Method to inform new user about template possibilities. What is allowed, what not, what is here to do etc.
     */
    private void showTutorial(){
        if (getPLAYER_SHIP().getAchievement().isFirstTimeInMarket()){
            //todo show info about city dockyard
            System.out.println("show info about city market");
            getPLAYER_SHIP().getAchievement().setFirstTimeInMarket(true);
        }
    }

    private void updateScene(){

        updatePlayerShip(getPLAYER_SHIP());
    }

    private void buttonsRegister(){

        btnRegBack();
    }

    private void btnRegBack(){
        btnBack.setOnMouseClicked(click->{
            Stage dockyard = (Stage) btnBack.getScene().getWindow();
            getScene().sceneChange(dockyard, getScene().sceneNameFinderByEnum(getScene().getBackStage()));
        });
    }
    
}
