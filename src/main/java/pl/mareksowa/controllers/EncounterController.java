package pl.mareksowa.controllers;

/**
 * Imports section
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;


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
        btnRegBack();
    }

    private void updateEncounterViews(){
        lblTitle.setText("koniec dnia nic sie nie dzieje");
    }

    private void btnRegBack(){
        btnBack.setOnMouseClicked(click-> {
            Stage map = (Stage) btnBack.getScene().getWindow();
            getSceneManager().sceneChangeInit(map, getSceneManager().sceneNameFinderByEnum(getSceneManager().getBackStage()), getPaneScene());
        });
    }
}
