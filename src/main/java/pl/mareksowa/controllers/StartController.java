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
import pl.mareksowa.models.SceneManager;
import pl.mareksowa.models.cities.CityName;

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

    /**
     * Initializator
     */
    public void initialize(URL location, ResourceBundle resources) {
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
            SceneManager.getInstance().setCURRENT_CITY(CityName.CENTEROS);
            Stage nextStage = (Stage) btnBeginNewJourney.getScene().getWindow();
            SceneManager.getInstance().sceneChange(nextStage, "scenes/city.fxml");
        });
    }

    /**
     * Responsible for exit game
     */
    private void btnRegExit(){
        btnExit.setOnMouseClicked(e-> SceneManager.getInstance().exitGame());
    }
}
