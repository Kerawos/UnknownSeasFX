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

    }

    private void updateScene(){

    }

    private void buttonsRegister(){

    }

    private void btnRegBack(){
        btnBack.setOnMouseClicked(click->{
            Stage dockyard = (Stage) btnBack.getScene().getWindow();
            getScene().sceneChange(dockyard, getScene().sceneNameFinderByEnum(getScene().getBackStage()));
        });
    }

    public Button getBtnBack() {
        return btnBack;
    }
}
