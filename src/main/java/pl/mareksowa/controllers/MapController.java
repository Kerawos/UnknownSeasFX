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
    @FXML private ImageView ivField1GothShai;
    @FXML private ImageView ivField4Masumba;
    @FXML private ImageView ivField6MilaDoce;
    @FXML private ImageView ivField10Balados;
    @FXML private ImageView ivField14Centeros;
    @FXML private ImageView ivField17Zihlu;
    @FXML private Button btnMainMenu;
    @FXML private Button btnMapInfo;


    private Image bgMapImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bgMapImage = new Image("img/map/Map.png");
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
        ivField4Masumba.setImage(new Image("img/map/MapYellow.png"));
        ivField6MilaDoce.setImage(new Image("img/map/MapYellow.png"));
        ivField1GothShai.setImage(new Image("img/map/MapYellow.png"));
    }

    /**
     * Method to managing all buttons and their actions
     */
    private void buttonsRegister(){
        ivRegField4Masumba();
        btnRegMainMenu();
        btnRegMapInfo();
    }

    /**
     * Method managing field on the map clicking
     */

    private void ivRegField1GothShai(){
        ivField1GothShai.setOnMouseClicked(click->{
            System.out.println("goth clicked");
        });
    }

    private void ivRegField4Masumba(){
        ivField4Masumba.setOnMouseClicked(click->{
            System.out.println("masumba clicked");
        });
    }

    private void ivRegField6MilaDoce(){
        ivField6MilaDoce.setOnMouseClicked(click->{
            System.out.println("mila clicked");
        });
    }


    private void btnRegMapInfo(){
        btnMapInfo.setOnMouseClicked(click-> System.out.println("map info clicked"));
    }

    private void btnRegMainMenu(){
        btnMainMenu.setOnMouseClicked(click-> System.out.println("main menu clicked"));
    }

}
