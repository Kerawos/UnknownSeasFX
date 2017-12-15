package pl.mareksowa.controllers;

/**
 * Imports section
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller responsible for all crew movement. Hire, fire crew members, buy food for the crew.
 */
@Component
public class TavernController extends PlayerShipController implements Initializable{

    @FXML private Label lblTitle;
    @FXML private Label lblUpperText;

    @FXML private Label lblCrew1Str;
    @FXML private Label lblCrew1Sal;
    @FXML private Label lblCrew1Con;
    @FXML private Label lblCrew1Pro;

    @FXML private Label lblCrew2Str;
    @FXML private Label lblCrew2Sal;
    @FXML private Label lblCrew2Con;
    @FXML private Label lblCrew2Pro;

    @FXML private Label lblCrew3Str;
    @FXML private Label lblCrew3Sal;
    @FXML private Label lblCrew3Con;
    @FXML private Label lblCrew3Pro;

    @FXML private Label lblCrew4Str;
    @FXML private Label lblCrew4Sal;
    @FXML private Label lblCrew4Con;
    @FXML private Label lblCrew4Pro;

    @FXML private Button btnHireCrew1;
    @FXML private Button btnHireCrew2;
    @FXML private Button btnHireCrew3;
    @FXML private Button btnHireCrew4;
    @FXML private Button btnBack;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScene();
        buttonsRegister();
    }

    private void updateScene(){
        updateTavernView();
        updatePlayerShip(getShipPlayerCurrent());
    }

    private void updateTavernView(){



        updateShipBackgroundView();
    }

    private void buttonsRegister(){

    }
}
