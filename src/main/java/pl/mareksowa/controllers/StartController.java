package pl.mareksowa.controllers;

/**
 * Import section
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import pl.mareksowa.models.CurrentScene;
import pl.mareksowa.models.managers.SceneManager;
import pl.mareksowa.models.managers.services.SceneManagerImpl;
import pl.mareksowa.models.SceneNameEquivalent;
import pl.mareksowa.models.ships.StartingShip;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Control Game start view panel. Main menu panel
 */
@Component
public class StartController implements Initializable{

    /**
     * Labels
     */
    @FXML private Pane paneScene;
    @FXML private ImageView ivStartPage;
    @FXML private Button btnBeginNewJourney;
    @FXML private Button btnExit;

    private Image backgroundImage;
    private CurrentScene scene;

    /**
     * Initializator
     */
    public void initialize(URL location, ResourceBundle resources) {
        scene = CurrentScene.getInstance();
        updateView();
        buttonsRegister();
    }

    /**
     * Updates views
     */
    private void updateView(){
        backgroundImage = new Image("img/scenes/StartPage.png");
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
            createPlayer1();
            scene.getShipMovementManager().refreshShipMove(scene.getShipPlayerCurrent());
            Stage worldMap = (Stage) btnBeginNewJourney.getScene().getWindow();
            scene.getSceneManager().sceneChangeInit(worldMap,
                    scene.getSceneManager().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.WORLD_MAP), paneScene);
        });
    }

    /**
     * creating ship player 1
     */
    private void createPlayer1(){
        scene.getShipGeneralManager().addShip(new StartingShip().getStartingShip());
    }
    /**
     * Responsible for exit game
     */
    private void btnRegExit(){
        btnExit.setOnMouseClicked(e-> scene.getSceneManager().exitGame());
    }
}
