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
import pl.mareksowa.models.sails.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Control dockyard behaviour. Response for upgrades of player ship, repairs.
 */
public class DockyardController extends PlayerShipController implements Initializable{

    /**
     * Labels
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
    }

    /**
     * Update this scene after any changes. Started from refresh every views, disable and turn on everything to prevent
     * glitches. Enable only necessary functions to user. At the end update player ship.
     */
    private void updateScene(){
        disableAllViews();
        updateSmithDockyardView();
        updatePlayerShip(getPLAYER_SHIP());
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
        setBackgroundImage(new Image("img/BackGround.png"));
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
        btnAddStorageSpace.setGraphic(new ImageView(new Image("img/StorageEmpty.png")));
        btnAddStorageSpace.setText("$" + (getPLAYER_SHIP().getStorageCapacity()
                * getPLAYER_SHIP().getStorageCapacity() + getPLAYER_SHIP().getStorageCapacity()));

        btnAddCabin.setVisible(true);
        btnAddCabin.setGraphic(new ImageView(new Image("img/CrewEmpty.png")));
        btnAddCabin.setText("$" + (getPLAYER_SHIP().getCabinCapacity()
                * getPLAYER_SHIP().getCabinCapacity() + getPLAYER_SHIP().getCabinCapacity()+1));

        btnAddSailSpace.setVisible(true);
        btnAddSailSpace.setGraphic(new ImageView(new Image("img/SailEmpty.png")));
        btnAddSailSpace.setText("$" + (getPLAYER_SHIP().getSailCapacity()
                * getPLAYER_SHIP().getSailCapacity()+ getPLAYER_SHIP().getSailCapacity()+10));

        btnAddCannonSpace.setVisible(true);
        btnAddCannonSpace.setGraphic(new ImageView(new Image("img/CannonEmpty.png")));
        btnAddCannonSpace.setText("$" + (getPLAYER_SHIP().getCannonCapacity()
                * getPLAYER_SHIP().getCannonCapacity() + getPLAYER_SHIP().getCannonCapacity()+5));

        btnAddSail1.setVisible(true);
        btnAddSail1.setText("$" + new SailSmall().getPrice());
        btnAddSail1.setGraphic(new ImageView(new Image("img/SailSmall.png")));
        lblUpgradeSail1Speed.setText("speed: " + new SailSmall().getSpeed());
        lblUpgradeSail1Manu.setText("maneuver: " + new SailSmall().getManeuver());
        btnAddSail2.setVisible(true);
        btnAddSail2.setText("$" + new SailPirate().getPrice());
        btnAddSail2.setGraphic(new ImageView(new Image("img/SailPirate.png")));
        lblUpgradeSail2Speed.setText("speed: " + new SailPirate().getSpeed());
        lblUpgradeSail2Manu.setText("maneuver: " + new SailPirate().getManeuver());
        btnAddSail3.setVisible(true);
        btnAddSail3.setText("$" + new SailSharp().getPrice());
        btnAddSail3.setGraphic(new ImageView(new Image("img/SailSharp.png")));
        lblUpgradeSail3Speed.setText("speed: " + new SailSharp().getSpeed());
        lblUpgradeSail3Manu.setText("maneuver: " + new SailSharp().getManeuver());
        btnAddSail4.setVisible(true);
        btnAddSail4.setText("$" + new SailBig().getPrice());
        btnAddSail4.setGraphic(new ImageView(new Image("img/SailBig.png")));
        lblUpgradeSail4Speed.setText("speed: " + new SailBig().getSpeed());
        lblUpgradeSail4Manu.setText("maneuver: " + new SailBig().getManeuver());

        btnRepair1.setVisible(true);
        btnRepair1.setGraphic(new ImageView(new Image("img/Anvil.png")));
        btnRepair1.setText("$1");
        btnRepair2.setVisible(true);
        btnRepair2.setGraphic(new ImageView(new Image("img/Anvil.png")));
        btnRepair2.setText("$5");
        btnRepair3.setVisible(true);
        btnRepair3.setGraphic(new ImageView(new Image("img/Anvil.png")));
        btnRepair3.setText("$" + (getPLAYER_SHIP().getEndurance()
                - getPLAYER_SHIP().getCurrentEndurance()));

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
    }

    /**
     * Responsible for getting back to city view
     */
    private void btnRegBack(){
        btnBack.setOnMouseClicked(e-> {
            Stage dockyard = (Stage) btnBack.getScene().getWindow();
            getScene().sceneChange(dockyard, getScene().sceneNameFinderByEnum(getScene().getBackStage()));
        });
    }

    /**
     * Responsible for add new empty storage space to player ship instead of gold
     */
    private void btnRegAddStorageSpace(){
        btnAddStorageSpace.setOnMouseClicked(e->{
            int storagePrice = getPLAYER_SHIP().getStorageCapacity() * getPLAYER_SHIP().getStorageCapacity()
                    + getPLAYER_SHIP().getStorageCapacity();
            if (getPLAYER_SHIP().getGold()>= storagePrice){
                getPLAYER_SHIP().setGold(getPLAYER_SHIP().getGold()- storagePrice);
                getPLAYER_SHIP().setStorageCapacity(getPLAYER_SHIP().getStorageCapacity()+1);
                updateScene();
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }

        });
    }

    /**
     * Responsible for add new empty cabin space to player ship instead of gold
     */
    private void btnRegAddCabin(){
        btnAddCabin.setOnMouseClicked(e->{
            int cabinPrice = getPLAYER_SHIP().getCabinCapacity() * getPLAYER_SHIP().getCabinCapacity()
                    + getPLAYER_SHIP().getCabinCapacity()+1;
            if (getPLAYER_SHIP().getGold()>= cabinPrice){
                getPLAYER_SHIP().setGold(getPLAYER_SHIP().getGold()- cabinPrice);
                getPLAYER_SHIP().setCabinCapacity(getPLAYER_SHIP().getCabinCapacity()+1);
                updateScene();
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }
        });
    }

    /**
     * Responsible for add new empty sail place to player ship instead of gold
     */
    private void btnRegAddSailSpace(){
        btnAddSailSpace.setOnMouseClicked(e->{
            int sailPrice = getPLAYER_SHIP().getSailCapacity()
                    * getPLAYER_SHIP().getSailCapacity() + getPLAYER_SHIP().getSailCapacity()+10;

            if (getPLAYER_SHIP().getGold()>= sailPrice){
                getPLAYER_SHIP().setGold(getPLAYER_SHIP().getGold()- sailPrice);
                getPLAYER_SHIP().setSailCapacity(getPLAYER_SHIP().getSailCapacity() + 1);
                updateScene();
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }
        });
    }

    /**
     * Responsible for add new empty cannon space to player ship instead of gold
     */
    private void btnRegAddCannonSpace(){
        btnAddCannonSpace.setOnMouseClicked(e->{
            int cannonPrice = getPLAYER_SHIP().getCannonCapacity() * getPLAYER_SHIP().getCannonCapacity()
                    + getPLAYER_SHIP().getCannonCapacity()+5;

            if (getPLAYER_SHIP().getGold()>= cannonPrice){
                getPLAYER_SHIP().setGold(getPLAYER_SHIP().getGold()- cannonPrice);
                getPLAYER_SHIP().setCannonCapacity(getPLAYER_SHIP().getCannonCapacity() + 1);
                updateScene();
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }
        });
    }

    /**
     * Responsible for ship repair instead of gold
     */
    private void btnRegRepair1(){
        btnRepair1.setOnMouseClicked(e->{
            if (getPLAYER_SHIP().getCurrentEndurance() < getPLAYER_SHIP().getEndurance()){
                if (getPLAYER_SHIP().getGold() >= 1){
                    getPLAYER_SHIP().setGold(getPLAYER_SHIP().getGold()-1);
                    getPLAYER_SHIP().setCurrentEndurance(getPLAYER_SHIP().getCurrentEndurance() + 1);
                    updatePlayerShip(getPLAYER_SHIP());
                    updateScene();
                } else {
                    lblUpperText.setText("You haven't enough gold to repair..");
                }
            } else {

                lblUpperText.setText("There is nothing to repair..");
            }
        });
    }

    /**
     * Responsible for ship repair instead of gold
     */
    private void btnRegRepair2(){
        btnRepair2.setOnMouseClicked(e->{
            if (getPLAYER_SHIP().getCurrentEndurance() < getPLAYER_SHIP().getEndurance() - 5){
                if (getPLAYER_SHIP().getGold() >= 5){
                    getPLAYER_SHIP().setGold(getPLAYER_SHIP().getGold()-5);
                    getPLAYER_SHIP().setCurrentEndurance(getPLAYER_SHIP().getCurrentEndurance() + 5);
                    updatePlayerShip(getPLAYER_SHIP());
                    updateScene();
                } else {
                    lblUpperText.setText("You haven't enough gold to repair 5 points ..");
                }
            } else {
                lblUpperText.setText("You cannot repair so much..");
            }
        });
    }

    /**
     * Responsible for ship total repair instead of gold
     */
    private void btnRegRepair3(){
        btnRepair3.setOnMouseClicked(e->{
            int toRepair = getPLAYER_SHIP().getEndurance() - getPLAYER_SHIP().getCurrentEndurance();
            if (getPLAYER_SHIP().getCurrentEndurance() < getPLAYER_SHIP().getEndurance()){
                if (getPLAYER_SHIP().getGold() >= toRepair){
                    getPLAYER_SHIP().setGold(getPLAYER_SHIP().getGold()-toRepair);
                    getPLAYER_SHIP().setCurrentEndurance(getPLAYER_SHIP().getCurrentEndurance() + toRepair);
                    updatePlayerShip(getPLAYER_SHIP());
                    updateScene();
                } else {
                    lblUpperText.setText("You haven't enough gold to repair " + toRepair + " points" );
                }
            } else {
                lblUpperText.setText("There is nothing to repair..");
            }
        });
    }

    private void addNewSail(Sail sailToAdd){
        int sailPrice = sailToAdd.getPrice();

        if (getPLAYER_SHIP().getGold()>= sailPrice){
            if (getPLAYER_SHIP().getSailCapacity() > getPLAYER_SHIP().getSailList().size()){
                getPLAYER_SHIP().setGold(getPLAYER_SHIP().getGold()- sailPrice);
                getShipFun().addSail(getPLAYER_SHIP(), sailToAdd);
                updateScene();
            }else {
                lblUpperText.setText("You don't have enough space..");
            }
        } else {
            lblUpperText.setText("You don't have enough gold..");
        }
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
