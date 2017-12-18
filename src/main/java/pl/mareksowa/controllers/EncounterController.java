package pl.mareksowa.controllers;

/**
 * Imports section
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller responsible for all movement in encounters
 */
@Component
public class EncounterController extends PlayerShipController implements Initializable {

    @FXML private Button btnBack;
    @FXML private Label lblTitle;

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
