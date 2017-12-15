package pl.mareksowa.controllers;

/**
 * Imports section
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import pl.mareksowa.models.CurrentScene;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.managers.SceneManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller responsible for all crew movement. Hire, fire crew members, buy food for the crew.
 */
@Component
public class TavernController extends PlayerShipController implements Initializable{

    @FXML private Label lblTitle;
    @FXML private Label lblUpperText;

    @FXML private Label lblCrew1Name;
    @FXML private Label lblCrew1Str;
    @FXML private Label lblCrew1Sal;
    @FXML private Label lblCrew1Con;
    @FXML private Label lblCrew1Pro;

    @FXML private Label lblCrew2Name;
    @FXML private Label lblCrew2Str;
    @FXML private Label lblCrew2Sal;
    @FXML private Label lblCrew2Con;
    @FXML private Label lblCrew2Pro;

    @FXML private Label lblCrew3Name;
    @FXML private Label lblCrew3Str;
    @FXML private Label lblCrew3Sal;
    @FXML private Label lblCrew3Con;
    @FXML private Label lblCrew3Pro;

    @FXML private Label lblCrew4Name;
    @FXML private Label lblCrew4Str;
    @FXML private Label lblCrew4Sal;
    @FXML private Label lblCrew4Con;
    @FXML private Label lblCrew4Pro;

    @FXML private ImageView ivHireCrew1;
    @FXML private ImageView ivHireCrew2;
    @FXML private ImageView ivHireCrew3;
    @FXML private ImageView ivHireCrew4;
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
        List<Crew> crewCityTavernList = CurrentScene.getInstance().getCurrentCity().getCrewTavernList();
        getShipCrewManager().updateTavernAvailableCrew(crewCityTavernList.get(0), lblCrew1Name, lblCrew1Str, lblCrew1Sal, lblCrew1Con, lblCrew1Pro, ivHireCrew1);
        getShipCrewManager().updateTavernAvailableCrew(crewCityTavernList.get(1), lblCrew2Name, lblCrew2Str, lblCrew2Sal, lblCrew2Con, lblCrew2Pro, ivHireCrew2);
        getShipCrewManager().updateTavernAvailableCrew(crewCityTavernList.get(2), lblCrew3Name, lblCrew3Str, lblCrew3Sal, lblCrew3Con, lblCrew3Pro, ivHireCrew3);
        getShipCrewManager().updateTavernAvailableCrew(crewCityTavernList.get(3), lblCrew4Name, lblCrew4Str, lblCrew4Sal, lblCrew4Con, lblCrew4Pro, ivHireCrew4);
        updateBackgroundView();
        updateShipBackgroundView();
    }

    private void buttonsRegister(){

        btnRegBack();
    }

    private void btnRegBack(){
        btnBack.setOnMouseClicked(e-> {
            Stage armory = (Stage) btnBack.getScene().getWindow();
            getSceneManager().sceneChange(armory, getSceneManager().sceneNameFinderByEnum(getSceneManager().getBackStage()));
        });
    }
}
