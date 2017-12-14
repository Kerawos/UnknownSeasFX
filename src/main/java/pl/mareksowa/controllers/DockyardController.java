package pl.mareksowa.controllers;

/**
 * Import section
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import pl.mareksowa.models.sails.*;
import pl.mareksowa.models.ships.Ship;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Control dockyard behaviour. Response for upgrades of player ship, repairs.
 */
@Component
public class DockyardController extends PlayerShipController implements Initializable{

    /**
     * Label declaration
     */
    @FXML ImageView ivBackGround;

    @FXML private Label lblUpperText;
    @FXML private Label lblTitle;

    @FXML private Label lblUpgradeRepair;
    @FXML private Label lblUpgradeSail;
    @FXML private Label lblUpgradeShip;

    @FXML private Button btnAddStorageSpace;
    @FXML private Button btnAddCabin;
    @FXML private Button btnAddSailSpace;
    @FXML private Button btnAddCannonSpace;

    @FXML private Button btnAddSail1;
    @FXML private Label lblUpgradeSail1Speed;
    @FXML private Label lblUpgradeSail1Manu;
    @FXML private Button btnAddSail2;
    @FXML private Label lblUpgradeSail2Speed;
    @FXML private Label lblUpgradeSail2Manu;
    @FXML private Button btnAddSail3;
    @FXML private Label lblUpgradeSail3Speed;
    @FXML private Label lblUpgradeSail3Manu;
    @FXML private Button btnAddSail4;
    @FXML private Label lblUpgradeSail4Speed;
    @FXML private Label lblUpgradeSail4Manu;

    @FXML private Button btnRepair1;
    @FXML private Button btnRepair2;
    @FXML private Button btnRepair3;

    @FXML private Button btnBack;

    /**
     * Initializator
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScene();
        buttonsRegister();
        showTutorial();
    }

    /**
     * Method to inform new user about template possibilities. What is allowed, what not, what is here to do etc.
     */
    private void showTutorial(){
        if (getShipPlayerCurrent().getAchievement().isFirstTimeInDockyard()){
            //todo show info about city dockyard
            System.out.println("show info about city dockyard");
            getShipPlayerCurrent().getAchievement().setFirstTimeInDockyard(true);
        }
    }

    /**
     * Update this scene after any changes. Started from refresh every views, disable and turn on everything to prevent
     * glitches. Enable only necessary functions to user. At the end update player ship.
     */
    private void updateScene(){
        disableAllViews();
        updateSmithDockyardView();
        updatePlayerShip(getShipPlayerCurrent());
    }

    /**
     * Method hide all FX functionality before showing results. To prevent of 'glitches' or 'duplicates' causing
     * from time to time by java FX.
     */
    private void disableAllViews(){
        setBackgroundImage(null);
        btnBack.setVisible(false);
        lblTitle.setText("");
        lblUpperText.setText("");

        btnAddStorageSpace.setVisible(false);
        btnAddCabin.setVisible(false);
        btnAddSailSpace.setVisible(false);
        btnAddCannonSpace.setVisible(false);
        btnAddSail1.setVisible(false);
        lblUpgradeSail1Speed.setText("");
        lblUpgradeSail1Manu.setText("");
        btnAddSail2.setVisible(false);
        lblUpgradeSail2Speed.setText("");
        lblUpgradeSail2Manu.setText("");
        btnAddSail3.setVisible(false);
        lblUpgradeSail3Speed.setText("");
        lblUpgradeSail3Manu.setText("");
        btnAddSail4.setVisible(false);
        lblUpgradeSail4Speed.setText("");
        lblUpgradeSail4Manu.setText("");
        btnRepair1.setVisible(false);
        btnRepair2.setVisible(false);
        btnRepair3.setVisible(false);
        lblUpgradeShip.setText("");
        lblUpgradeSail.setText("");
        lblUpgradeRepair.setText("");
    }

    /**
     * Method hide all FX functionality before showing results. To prevent of 'glitches' or 'duplicates' causing
     * from time to time by java FX.
     */
    private void updateSmithDockyardView(){
        setBackgroundImage(new Image("img/scenes/BackGround.png"));
        ivBackGround.setImage(getBackgroundImage());
        ivBackGround.fitWidthProperty().setValue(getBackgroundImage().getWidth());
        ivBackGround.fitHeightProperty().setValue(getBackgroundImage().getHeight());
        lblUpperText.setWrapText(true);
        lblTitle.setText("Ship Dockyard");
        lblUpperText.setText("Hello capitan, just indicate what you want to add to your ship");
        lblUpperText.setText("click image to add item to ship");
        lblUpgradeShip.setText("Click to upgrade");
        lblUpgradeSail.setText("Click to buy");
        lblUpgradeRepair.setText("Click to repair");

        btnAddStorageSpace.setVisible(true);
        btnAddStorageSpace.setGraphic(new ImageView(new Image("img/goods/StorageEmpty.png")));
        btnAddStorageSpace.setText("$" + (getShipPlayerCurrent().getStorageCapacity()
                * getShipPlayerCurrent().getStorageCapacity() + getShipPlayerCurrent().getStorageCapacity()));

        btnAddCabin.setVisible(true);
        btnAddCabin.setGraphic(new ImageView(new Image("img/crews/CrewEmpty.png")));
        btnAddCabin.setText("$" + (getShipPlayerCurrent().getCabinCapacity()
                * getShipPlayerCurrent().getCabinCapacity() + getShipPlayerCurrent().getCabinCapacity()+1));

        btnAddSailSpace.setVisible(true);
        btnAddSailSpace.setGraphic(new ImageView(new Image("img/sails/SailEmpty.png")));
        btnAddSailSpace.setText("$" + (getShipPlayerCurrent().getSailCapacity()
                * getShipPlayerCurrent().getSailCapacity()+ getShipPlayerCurrent().getSailCapacity()+10));

        btnAddCannonSpace.setVisible(true);
        btnAddCannonSpace.setGraphic(new ImageView(new Image("img/cannons/CannonEmpty.png")));
        btnAddCannonSpace.setText("$" + (getShipPlayerCurrent().getCannonCapacity()
                * getShipPlayerCurrent().getCannonCapacity() + getShipPlayerCurrent().getCannonCapacity()+5));

        btnAddSail1.setVisible(true);
        btnAddSail1.setText("$" + new SailSmall().getPrice());
        btnAddSail1.setGraphic(new ImageView(new Image("img/sails/SailSmall.png")));
        lblUpgradeSail1Speed.setText("speed: " + new SailSmall().getSpeed());
        lblUpgradeSail1Manu.setText("maneuver: " + new SailSmall().getManeuver());
        btnAddSail2.setVisible(true);
        btnAddSail2.setText("$" + new SailPirate().getPrice());
        btnAddSail2.setGraphic(new ImageView(new Image("img/sails/SailPirate.png")));
        lblUpgradeSail2Speed.setText("speed: " + new SailPirate().getSpeed());
        lblUpgradeSail2Manu.setText("maneuver: " + new SailPirate().getManeuver());
        btnAddSail3.setVisible(true);
        btnAddSail3.setText("$" + new SailSharp().getPrice());
        btnAddSail3.setGraphic(new ImageView(new Image("img/sails/SailSharp.png")));
        lblUpgradeSail3Speed.setText("speed: " + new SailSharp().getSpeed());
        lblUpgradeSail3Manu.setText("maneuver: " + new SailSharp().getManeuver());
        btnAddSail4.setVisible(true);
        btnAddSail4.setText("$" + new SailBig().getPrice());
        btnAddSail4.setGraphic(new ImageView(new Image("img/sails/SailBig.png")));
        lblUpgradeSail4Speed.setText("speed: " + new SailBig().getSpeed());
        lblUpgradeSail4Manu.setText("maneuver: " + new SailBig().getManeuver());

        btnRepair1.setVisible(true);
        btnRepair1.setGraphic(new ImageView(new Image("img/cities/Anvil.png")));
        btnRepair1.setText("$1");
        btnRepair2.setVisible(true);
        btnRepair2.setGraphic(new ImageView(new Image("img/cities/Anvil.png")));
        btnRepair2.setText("$5");
        btnRepair3.setVisible(true);
        btnRepair3.setGraphic(new ImageView(new Image("img/cities/Anvil.png")));
        btnRepair3.setText("$" + (getShipPlayerCurrent().getEndurance()
                - getShipPlayerCurrent().getCurrentEndurance()));

        btnBack.setVisible(true);
        updateShipBackgroundView();
    }

    /**
     * Logic of behaviour of all buttons in city scene
     */
    private void buttonsRegister(){
        btnRegAddStorageSpace();
        btnRegAddCabin();
        btnRegAddSailSpace();
        btnRegAddCannonSpace();
        btnRegRepair1();
        btnRegRepair2();
        btnRegRepair3();
        btnRegBack();
        btnRegAddSailSmall();
        btnRegAddSailPirate();
        btnRegAddSailSharp();
        btnRegAddSailBig();
        btnRegSail1();
        btnRegSail2();
        btnRegSail3();
        btnRegSail4();
        btnRegSail5();
        btnRegSail6();
        btnRegSail7();
        btnRegSail8();
        btnRegSail9();
        btnRegSail10();
    }

    /**
     * Responsible for getting back to city view
     */
    private void btnRegBack(){
        btnBack.setOnMouseClicked(e-> {
            Stage dockyard = (Stage) btnBack.getScene().getWindow();
            getSceneManager().sceneChange(dockyard, getSceneManager().sceneNameFinderByEnum(getSceneManager().getBackStage()));
        });
    }

    /**
     * Responsible for add new empty storage space to player ship instead of gold
     */
    private void btnRegAddStorageSpace(){
        btnAddStorageSpace.setOnMouseClicked(click->{
            if (getShipBuilderManager().canBuyStorage(getShipPlayerCurrent(), lblUpperText)){
                getShipBuilderManager().addStorage(getShipPlayerCurrent());
                updateScene();
            }
        });
    }


    /**
     * Responsible for add new empty cabin space to player ship instead of gold
     */
    private void btnRegAddCabin(){
        btnAddCabin.setOnMouseClicked(e->{
            if (getShipBuilderManager().canBuyCabin(getShipPlayerCurrent(), lblUpperText)){
                getShipBuilderManager().addCabin(getShipPlayerCurrent());
                updateScene();
            }
        });
    }


    /**
     * Responsible for add new empty sail place to player ship instead of gold
     */
    private void btnRegAddSailSpace(){
        btnAddSailSpace.setOnMouseClicked(e->{
            if (getShipBuilderManager().canBuySailSpace(getShipPlayerCurrent(), lblUpperText)){
                getShipBuilderManager().addSailSpace(getShipPlayerCurrent());
                updateScene();
            }
        });
    }

    /**
     * Responsible for add new empty cannon space to player ship instead of gold
     */
    private void btnRegAddCannonSpace(){
        btnAddCannonSpace.setOnMouseClicked(e->{
            if (getShipBuilderManager().canBuyCannonSpace(getShipPlayerCurrent(), lblUpperText)){
                getShipBuilderManager().addCannonSpace(getShipPlayerCurrent());
                updateScene();
            }
        });
    }

    /**
     * Responsible for ship repair instead of gold
     */
    private void btnRegRepair1(){
        btnRepair1.setOnMouseClicked(e->repairShip(getShipPlayerCurrent(), 1));
    }

    /**
     * Responsible for ship repair instead of gold
     */
    private void btnRegRepair2(){
        btnRepair2.setOnMouseClicked(e->repairShip(getShipPlayerCurrent(), 5));
    }

    /**
     * Responsible for ship total repair instead of gold
     */
    private void btnRegRepair3(){
        btnRepair3.setOnMouseClicked(e->repairShip(getShipPlayerCurrent(),
                getShipPlayerCurrent().getEndurance() - getShipPlayerCurrent().getCurrentEndurance()));
    }

    private void repairShip(Ship playerShip, int toRepair){
        if (getShipBuilderManager().canRepair(playerShip, toRepair, lblUpperText)){
            getShipBuilderManager().repair(playerShip, toRepair);
            updateScene();
        }
    }


    private void addNewSail(Sail sailToAdd){
       if (getShipTradeManager().canBuySail(getShipPlayerCurrent(), sailToAdd, lblUpperText)){
           getShipTradeManager().buySail(getShipPlayerCurrent(), sailToAdd);
           updateScene();
       }
    }

    private void sellSail(int sailListNo){
        if (getShipTradeManager().canSellSail(getShipPlayerCurrent(), sailListNo)){
            getShipTradeManager().sellSail(getShipPlayerCurrent(), getShipPlayerCurrent().getSailList().get(sailListNo));
            updateScene();
        }
    }

    private void btnRegSail1(){
        getIvSail1().setOnMouseClicked(click->sellSail( 0));
    }

    private void btnRegSail2(){
        getIvSail2().setOnMouseClicked(click->sellSail( 1));
    }

    private void btnRegSail3(){
        getIvSail3().setOnMouseClicked(click->sellSail( 2));
    }

    private void btnRegSail4(){
        getIvSail4().setOnMouseClicked(click->sellSail( 3));
    }

    private void btnRegSail5(){
        getIvSail5().setOnMouseClicked(click->sellSail(4));
    }

    private void btnRegSail6(){
        getIvSail6().setOnMouseClicked(click->sellSail(5));
    }

    private void btnRegSail7(){
        getIvSail7().setOnMouseClicked(click->sellSail(6));
    }

    private void btnRegSail8(){
        getIvSail8().setOnMouseClicked(click->sellSail(7));
    }

    private void btnRegSail9(){
        getIvSail9().setOnMouseClicked(click->sellSail(8));
    }

    private void btnRegSail10(){
        getIvSail10().setOnMouseClicked(click->sellSail(9));
    }

    private void btnRegAddSailSmall(){
        btnAddSail1.setOnMouseClicked(click-> addNewSail(new SailSmall()));
    }

    private void btnRegAddSailPirate(){
        btnAddSail2.setOnMouseClicked(click-> addNewSail(new SailPirate()));
    }

    private void btnRegAddSailSharp(){
        btnAddSail3.setOnMouseClicked(click-> addNewSail(new SailSharp()));
    }

    private void btnRegAddSailBig(){
        btnAddSail4.setOnMouseClicked(click-> addNewSail(new SailBig()));
    }

}
