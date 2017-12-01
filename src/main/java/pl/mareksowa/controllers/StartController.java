package pl.mareksowa.controllers;

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


public class StartController implements Initializable{

    @FXML private ImageView ivStartPage;

    @FXML private Button btnBeginNewJourney;

    @FXML private Button btnExit;

    private Image backgroundImage;

    public void initialize(URL location, ResourceBundle resources) {
        updateView();
        buttonsRegister();
    }

    private void updateView(){
        backgroundImage = new Image("img/StartPage.png");
        ivStartPage.setImage(backgroundImage);
        ivStartPage.fitWidthProperty().setValue(backgroundImage.getWidth());
        ivStartPage.fitHeightProperty().setValue(backgroundImage.getHeight());
    }

    private void buttonsRegister(){
        btnRegBeginNewJourney();
        btnRegExit();
    }

    private void btnRegBeginNewJourney(){
        btnBeginNewJourney.setOnMouseClicked(e-> {
            SceneManager.getInstance().setCURRENT_CITY(CityName.CENTEROS);
            Stage nextStage = (Stage) btnBeginNewJourney.getScene().getWindow();
            SceneManager.getInstance().sceneChange(nextStage, "scenes/city.fxml");
        });
    }

    private void btnRegExit(){
        btnExit.setOnMouseClicked(e-> SceneManager.getInstance().exitGame());
    }
}
