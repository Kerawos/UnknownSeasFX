package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class startController implements Initializable{

    @FXML
    ImageView ivStartPage;

    @FXML
    Button btnBeginNewJourney;

    @FXML
    Button btnExit;

    Image backgroundImage;

    public void initialize(URL location, ResourceBundle resources) {
        backgroundImage = new Image("img/StartPage.png");
        ivStartPage.setImage(backgroundImage);
    }


}
