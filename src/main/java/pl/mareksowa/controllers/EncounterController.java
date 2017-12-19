package pl.mareksowa.controllers;

/**
 * Imports section
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML private TextArea txtInfo;
    //todo spring not working at this moment
    @Autowired private EncounterManager encounterManager = new EncounterManager();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getEncounter();
        updateScene();
        buttonsRegister();
    }

    private void getEncounter(){
        switch (encounterManager.generateEncounterType(getShipPlayerCurrent())){
//            case ADVENTURE:{
//
//                break;
//            }

            default:{ //works as Empty also
                scenarioEmpty();
                break;
            }
        }
    }

    private void scenarioEmpty(){
        setBackgroundImage(new Image("img/encounters/EncounterEmpty.png"));
        lblTitle.setText("Capitan! There is nothing to report..");
        txtInfo.setText("You encounter endless typical ocean. Another day is gone. Crew is going to eat and sleep.");
    }

    private void updateScene(){

        updatePlayerShip(getShipPlayerCurrent());
        updateEncounterViews();
    }

    private void buttonsRegister(){
        btnRegBack();
    }

    private void updateEncounterViews(){
        txtInfo.setWrapText(true);
        updateBackgroundView();
        updateShipBackgroundView();

    }

    private void btnRegBack(){
        btnBack.setOnMouseClicked(click-> {
            //CurrentScene.getInstance().getShipMovementManager().refreshShipMove(getShipPlayerCurrent());
            Stage worldMap = (Stage) btnBack.getScene().getWindow();
            getSceneManager().sceneChangeInit(worldMap, getSceneManager().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.WORLD_MAP), getPaneScene());
        });
    }
}
