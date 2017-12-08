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
    @FXML private ImageView ivPlayerCurrentPosition;
    @FXML private ImageView ivBackGround;
    @FXML private ImageView ivField1GothShai;
    @FXML private ImageView ivField2;
    @FXML private ImageView ivField3;
    @FXML private ImageView ivField4Masumba;
    @FXML private ImageView ivField5;
    @FXML private ImageView ivField6MilaDoce;
    @FXML private ImageView ivField7;
    @FXML private ImageView ivField8;
    @FXML private ImageView ivField9;
    @FXML private ImageView ivField10Balados;
    @FXML private ImageView ivField11;
    @FXML private ImageView ivField12;
    @FXML private ImageView ivField13;
    @FXML private ImageView ivField14Centeros;
    @FXML private ImageView ivField15;
    @FXML private ImageView ivField16;
    @FXML private ImageView ivField17Zihlu;
    @FXML private Button btnMainMenu;
    @FXML private Button btnMapInfo;


    private Image bgPlayerShipOnMap;
    private Image bgMapImage;
    private Image indicatorGreen;
    private Image indicatorYellow;
    private Image indicatorRed;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bgPlayerShipOnMap = new Image("img/PlayerShipOnMap.png");
        bgMapImage = new Image("img/map/Map.png");
        indicatorGreen = new Image("img/map/MapGreen.png");
        indicatorYellow = new Image("img/map/MapYellow.png");
        indicatorRed = new Image("img/map/MapRed.png");
        updateScene();
        buttonsRegister();
    }

    /**
     * Method to refresh scene after each action
     */
    private void updateScene(){
        updateAllViews();
        updatePlayerShip(getPLAYER_SHIP());
        updatePlayerShipPosition();

    }

    private void disableAllViews(){

    }

    /**
     * Method updating every label, image, button etc after each action
     */
    private void updateAllViews(){
        ivBackGround.setImage(bgMapImage);
        updateFieldIndicatorView();
        updateShipBackgroundView();

    }

    /**
     * Method managing displaying proper field indicators, their colors and possible moves
     */
    private void updateFieldIndicatorView(){
        ivField1GothShai.setImage(indicatorRed);
        ivField2.setImage(indicatorRed);
        ivField3.setImage(indicatorRed);
        ivField4Masumba.setImage(indicatorYellow);
        ivField5.setImage(indicatorYellow);
        ivField6MilaDoce.setImage(indicatorGreen);
        ivField7.setImage(indicatorYellow);
        ivField8.setImage(indicatorYellow);
        ivField9.setImage(indicatorYellow);
        ivField10Balados.setImage(indicatorYellow);
        ivField11.setImage(indicatorRed);
        ivField12.setImage(indicatorRed);
        ivField13.setImage(indicatorGreen);
        ivField14Centeros.setImage(indicatorGreen);
        ivField15.setImage(indicatorGreen);
        ivField16.setImage(indicatorGreen);
        ivField17Zihlu.setImage(indicatorGreen);
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

    private void updatePlayerShipPosition(){
        ivPlayerCurrentPosition.setImage(bgPlayerShipOnMap);
        if (!getPLAYER_SHIP().getAchievement().isFirstTimeInWorldMap()){
            ivPlayerCurrentPosition.setX(380);
            ivPlayerCurrentPosition.setY(245);
            getPLAYER_SHIP().getAchievement().setFirstTimeInWorldMap(true);
        }
    }

}
