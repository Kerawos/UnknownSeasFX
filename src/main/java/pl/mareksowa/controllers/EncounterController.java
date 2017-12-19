package pl.mareksowa.controllers;

/**
 * Imports section
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mareksowa.models.CurrentScene;
import pl.mareksowa.models.SceneNameEquivalent;
import pl.mareksowa.models.managers.services.EncounterManager;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller responsible for all movement in encounters
 */
@Component
public class EncounterController extends PlayerShipController implements Initializable {

    @FXML private Button btnBack;
    @FXML private Label lblTitle;
    //todo spring not working at this moment
    @Autowired private EncounterManager encounterManager = new EncounterManager();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getEncounter();
        updateScene();
        buttonsRegister();
    }

    private void getEncounter(){

    }

    private void updateScene(){

        updatePlayerShip(getShipPlayerCurrent());
        updateEncounterViews();
    }

    private void buttonsRegister(){
        btnRegBack();
    }

    private void updateEncounterViews(){
        lblTitle.setText(encounterManager.generateEncounterType(getShipPlayerCurrent())+ " type");

        updateBackgroundView();
        updateShipBackgroundView();

    }

    private void btnRegBack(){
        btnBack.setOnMouseClicked(click-> {
            //CurrentScene.getInstance().getShipMovementManager().refreshShipMove(getShipPlayerCurrent());
            System.out.println("player move2 : " + getShipMovementManager().getRemainShipMove(getShipPlayerCurrent()));
            Stage worldMap = (Stage) btnBack.getScene().getWindow();
            getSceneManager().sceneChangeInit(worldMap, getSceneManager().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.WORLD_MAP), getPaneScene());
        });
    }
}
