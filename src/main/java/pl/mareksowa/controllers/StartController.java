package pl.mareksowa.controllers;

/**
 * Import section
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.mareksowa.models.managers.services.SceneManagerImpl;
import pl.mareksowa.models.SceneNameEquivalent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Control Game start view panel. Main menu panel
 */
public class StartController implements Initializable{

    /**
     * Labels
     */
    @FXML private ImageView ivStartPage;
    @FXML private Button btnBeginNewJourney;
    @FXML private Button btnExit;

    private Image backgroundImage;
    private SceneManagerImpl scene;

    /**
     * Initializator
     */
    public void initialize(URL location, ResourceBundle resources) {
        scene = SceneManagerImpl.getInstance();
        updateView();
        buttonsRegister();
    }

    /**
     * Updates views
     */
    private void updateView(){
        backgroundImage = new Image("img/StartPage.png");
        ivStartPage.setImage(backgroundImage);
        ivStartPage.fitWidthProperty().setValue(backgroundImage.getWidth());
        ivStartPage.fitHeightProperty().setValue(backgroundImage.getHeight());
    }

    /**
     * Logic of behaviour of all buttons in city scene
     */
    private void buttonsRegister(){
        btnRegBeginNewJourney();
        btnRegExit();
    }

    /**
     * Responsible for start new adventure
     */
    private void btnRegBeginNewJourney(){
        btnBeginNewJourney.setOnMouseClicked(e-> {
            //scene.setCURRENT_CITY(CityName.CENTEROS);
            scene.getShipMovement().refreshShipMove(scene.getPLAYER_SHIP());
            Stage worldMap = (Stage) btnBeginNewJourney.getScene().getWindow();
            scene.sceneChange(worldMap, scene.sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.WORLD_MAP));
        });
    }

    /**
     * Responsible for exit game
     */
    private void btnRegExit(){
        btnExit.setOnMouseClicked(e-> SceneManagerImpl.getInstance().exitGame());
    }
}
