package pl.mareksowa.controllers;
/**
 * Imports section
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Control world map in this game. Managing player moving and entering to locations.
 */
public class MapController extends PlayerShipController implements Initializable {

    /**
     * Variables declarations
     */
    @FXML private ImageView ivBackGround;
    @FXML private ImageView ivMasumba;
    @FXML private Button btnMainMenu;
    @FXML private Button btnMapInfo;


    private Image bgMapImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bgMapImage = new Image("img/Map.png");
        updateScene();
        buttonsRegister();
    }

    /**
     * Method to refresh scene after each action
     */
    private void updateScene(){
        updateAllViews();
        updatePlayerShip(getPLAYER_SHIP());
    }

    private void disableAllViews(){

    }

    /**
     * Method updating every label, image, button etc after each action
     */
    private void updateAllViews(){
        ivBackGround.setImage(bgMapImage);

        updateShipBackgroundView();
    }

    /**
     * Method to managing all buttons and their actions
     */
    private void buttonsRegister(){
        ivRegMasumba();
        btnRegMainMenu();
        btnRegMapInfo();
    }

    /**
     * Method managing button clicking
     */
    private void ivRegMasumba(){
        ivMasumba.setOnMouseClicked(click->{
            System.out.println("masumba clicked");
        });
    }

    private void btnRegMapInfo(){
        btnMapInfo.setOnMouseClicked(click-> System.out.println("map info clicked"));
    }

    private void btnRegMainMenu(){
        btnMainMenu.setOnMouseClicked(click-> System.out.println("main menu clicked"));
    }

}
