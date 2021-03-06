package pl.mareksowa.controllers;

/**
 * Imports section
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import pl.mareksowa.models.cannons.*;
import pl.mareksowa.models.ships.Ship;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ArmoryController extends PlayerShipController implements Initializable{


    @FXML ImageView ivBackGround;
    @FXML private Label lblUpperText;
    @FXML private Label lblTitle;
    @FXML private Label lblAddCannon;
    @FXML private Label lblAddArmor;
    @FXML private Label lblAddAmmo;
    @FXML private Label lblCannon1Str;
    @FXML private Label lblCannon2Str;
    @FXML private Label lblCannon3Str;
    @FXML private Label lblAmmo1;
    @FXML private Label lblAmmo2;
    @FXML private Label lblArmor;
    @FXML private Button btnAddCannon1;
    @FXML private Button btnAddCannon2;
    @FXML private Button btnAddCannon3;
    @FXML private Button btnAddArmor;
    @FXML private Button btnAddAmmo1;
    @FXML private Button btnAddAmmo2;
    @FXML private Button btnBack;

    /**
     * Initializator
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScene();
        buttonsRegister();
    }

    /**
     * Method to inform new user about template possibilities. What is allowed, what not, what is here to do etc.
     */
    private void showTutorial(){
        if (getShipPlayerCurrent().getAchievement().isFirstTimeInArmory()){
            //todo show info about city armory
            System.out.println("show info about city armory");
            getShipPlayerCurrent().getAchievement().setFirstTimeInArmory(true);
        }
    }

    /**
     * Update this scene after any changes. Started from refresh every views, disable and turn on everything to prevent
     * glitches. Enable only necessary functions to user. At the end update player ship.
     */
    private void updateScene(){
        updateArmoryView();
        updatePlayerShip(getShipPlayerCurrent());
    }

    /**
     * Method hide all FX functionality before showing results. To prevent of 'glitches' or 'duplicates' causing
     * from time to time by java FX.
     */
    private void updateArmoryView(){
        lblTitle.setText("Armory");
        lblUpperText.setText("indicate part to add it to your ship");
        lblAddCannon.setText("click to buy special cannon");
        lblCannon1Str.setText("fire power: " + new CannonShort().getStrength());
        lblCannon2Str.setText("fire power: " + new CannonLong().getStrength());
        lblCannon3Str.setText("fire power: " + new CannonBig().getStrength());
        btnAddCannon1.setText("$" + new CannonShort().getPrice());
        btnAddCannon2.setText("$" + new CannonLong().getPrice());
        btnAddCannon3.setText("$" + new CannonBig().getPrice());
        btnAddCannon1.setGraphic(new ImageView(new Image("img/cannons/CannonShort.png")));
        btnAddCannon2.setGraphic(new ImageView(new Image("img/cannons/CannonLong.png")));
        btnAddCannon3.setGraphic(new ImageView(new Image("img/cannons/CannonBig.png")));

        lblAddAmmo.setText("click to buy ammo");
        btnAddAmmo1.setText("$1");
        lblAmmo1.setText("+1 ammo");
        btnAddAmmo1.setGraphic(new ImageView(new Image("img/cannons/Ammo.png")));
        btnAddAmmo2.setText("$5");
        lblAmmo2.setText("+6 ammo");
        btnAddAmmo2.setGraphic(new ImageView(new Image("img/cannons/Ammo6.png")));

        lblAddArmor.setText("click to buy extra armor");
        lblArmor.setText("+10% resistance");
        btnAddArmor.setText("$20");
        btnAddArmor.setGraphic(new ImageView(new Image("img/cannons/Armor.png")));

        updateBackgroundView();
        updateShipBackgroundView();
    }

    /**
     * Logic of behaviour of all buttons in city scene
     */
    private void buttonsRegister(){
        btnRegAddAmmo1();
        btnRegAddAmmo2();
        btnRegAddArmor();
        btnRegAddCannon1();
        btnRegAddCannon2();
        btnRegAddCannon3();
        btnRegSellCannon1();
        btnRegSellCannon2();
        btnRegSellCannon3();
        btnRegSellCannon4();
        btnRegSellCannon5();
        btnRegSellCannon6();
        btnRegSellCannon7();
        btnRegSellCannon8();
        btnRegSellCannon9();
        btnRegSellCannon10();

        btnRegBack();
    }

    private void btnRegBack(){
        btnBack.setOnMouseClicked(e-> {
            Stage armory = (Stage) btnBack.getScene().getWindow();
            getSceneManager().sceneChangeInit(armory, getSceneManager().sceneNameFinderByEnum(getSceneManager().getBackStage()), getPaneScene());
        });
    }

    private void btnRegAddAmmo1(){
        btnAddAmmo1.setOnMouseClicked(click->buyAmmo(getShipPlayerCurrent(), 1, 1));
    }

    private void btnRegAddAmmo2(){
        btnAddAmmo2.setOnMouseClicked(click->buyAmmo(getShipPlayerCurrent(), 6, 5));
    }

    private void buyAmmo(Ship playerShip, int ammoQty, int ammoCost){
        if (getShipTradeManager().canBuyAmmo(playerShip, ammoCost, lblUpperText)){
            getShipTradeManager().buyAmmo(playerShip, ammoQty, ammoCost);
            updateScene();
        }
    }

    private void addNewCannon(Cannon cannonToAdd){
        if (getShipTradeManager().canBuyCannon(getShipPlayerCurrent(), cannonToAdd, lblUpperText)){
            getShipTradeManager().buyCannon(getShipPlayerCurrent(), cannonToAdd);
            updateScene();
        }
    }

    private void sellCannon(int cannonListNo){
        if (getShipTradeManager().canSellCannon(getShipPlayerCurrent(), cannonListNo)){
            getShipTradeManager().sellCannon(getShipPlayerCurrent(), getShipPlayerCurrent().getCannonList().get(cannonListNo));
            updateScene();
        }
    }

    private void btnRegAddCannon1(){
        btnAddCannon1.setOnMouseClicked(click->addNewCannon(new CannonShort()));
    }

    private void btnRegAddCannon2(){
        btnAddCannon2.setOnMouseClicked(click->addNewCannon(new CannonLong()));
    }

    private void btnRegAddCannon3(){
        btnAddCannon3.setOnMouseClicked(click->addNewCannon(new CannonBig()));
    }

    /**
     * Method to add new power to the ship. Armor is treated as cannon because also takes same cannon slot.
     */
    private void btnRegAddArmor(){
        btnAddArmor.setOnMouseClicked(click->addNewCannon(new Armor()));
    }

    private void btnRegSellCannon1(){
        getIvCannon1().setOnMouseClicked(click->sellCannon(0));
    }

    private void btnRegSellCannon2(){
        getIvCannon2().setOnMouseClicked(click->sellCannon(1));
    }

    private void btnRegSellCannon3(){
        getIvCannon3().setOnMouseClicked(click->sellCannon(2));
    }

    private void btnRegSellCannon4(){
        getIvCannon4().setOnMouseClicked(click->sellCannon(3));
    }

    private void btnRegSellCannon5(){
        getIvCannon5().setOnMouseClicked(click->sellCannon(4));
    }

    private void btnRegSellCannon6(){
        getIvCannon6().setOnMouseClicked(click->sellCannon(5));
    }

    private void btnRegSellCannon7(){
        getIvCannon7().setOnMouseClicked(click->sellCannon(6));
    }

    private void btnRegSellCannon8(){
        getIvCannon8().setOnMouseClicked(click->sellCannon(7));
    }

    private void btnRegSellCannon9(){
        getIvCannon9().setOnMouseClicked(click->sellCannon(8));
    }

    private void btnRegSellCannon10(){
        getIvCannon10().setOnMouseClicked(click->sellCannon(9));
    }
}
