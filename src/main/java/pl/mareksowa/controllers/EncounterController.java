package pl.mareksowa.controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EncounterController extends PlayerShipController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScene();
        buttonsRegister();
    }

    private void updateScene(){
        updateEncounterViews();
    }

    private void buttonsRegister(){

    }

    private void updateEncounterViews(){

    }
}
