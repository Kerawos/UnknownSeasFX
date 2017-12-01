package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.sails.SailBig;
import pl.mareksowa.models.sails.SailPirate;
import pl.mareksowa.models.sails.SailSharp;
import pl.mareksowa.models.sails.SailSmall;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.dao.impl.ShipManager;

import java.net.URL;
import java.util.ResourceBundle;

public class DockyardController implements Initializable{

    @FXML ImageView ivBackGround;

    @FXML private Label lblUpperText;
    @FXML private Label lblTitle;

    @FXML private Label lblPlayerGold;
    @FXML private Label lblPlayerFood;
    @FXML private Label lblPlayerAmmo;
    @FXML private Label lblUpgrdeRepair;
    @FXML private Label lblUpgrdeSail;
    @FXML private Label lblUpgrdeShip;

    @FXML private ImageView ivStorage1;
    @FXML private ImageView ivStorage2;
    @FXML private ImageView ivStorage3;
    @FXML private ImageView ivStorage4;
    @FXML private ImageView ivStorage5;
    @FXML private ImageView ivStorage6;
    @FXML private ImageView ivStorage7;
    @FXML private ImageView ivStorage8;
    @FXML private ImageView ivStorage9;
    @FXML private ImageView ivStorage10;

    @FXML private ImageView ivCrew1;
    @FXML private ImageView ivCrew2;
    @FXML private ImageView ivCrew3;
    @FXML private ImageView ivCrew4;
    @FXML private ImageView ivCrew5;
    @FXML private ImageView ivCrew6;
    @FXML private ImageView ivCrew7;
    @FXML private ImageView ivCrew8;
    @FXML private ImageView ivCrew9;
    @FXML private ImageView ivCrew10;

    @FXML private ImageView ivCannon1;
    @FXML private ImageView ivCannon2;
    @FXML private ImageView ivCannon3;
    @FXML private ImageView ivCannon4;
    @FXML private ImageView ivCannon5;
    @FXML private ImageView ivCannon6;
    @FXML private ImageView ivCannon7;
    @FXML private ImageView ivCannon8;
    @FXML private ImageView ivCannon9;
    @FXML private ImageView ivCannon10;

    @FXML private ImageView ivSail1;
    @FXML private ImageView ivSail2;
    @FXML private ImageView ivSail3;
    @FXML private ImageView ivSail4;
    @FXML private ImageView ivSail5;
    @FXML private ImageView ivSail6;
    @FXML private ImageView ivSail7;
    @FXML private ImageView ivSail8;
    @FXML private ImageView ivSail9;
    @FXML private ImageView ivSail10;

    @FXML private Button btnAddStorageSpace;
    @FXML private Button btnAddCabin;
    @FXML private Button btnAddSailSpace;
    @FXML private Button btnAddCannonSpace;

    @FXML private Button btnAddSail1;
    @FXML private Button btnAddSail2;
    @FXML private Button btnAddSail3;
    @FXML private Button btnAddSail4;


    @FXML private Button btnRepair1;
    @FXML private Button btnRepair2;
    @FXML private Button btnRepair3;



    @FXML private Button btnBack;


    @FXML private Label lblPlayerHp;
    @FXML private ProgressBar pbShipHp;


    private Image backgroundImage;
    private ShipManager shipDao;
    private Ship playerShip;

    private String cityState;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //updatePlayerShip();
        shipDao = ShipManager.getInstance();
        playerShip = shipDao.getAllShips().get(0);
        backgroundImage = new Image("img/BackGroundLine.png");
        ivBackGround.setImage(backgroundImage);
        ivBackGround.fitWidthProperty().setValue(backgroundImage.getWidth());
        ivBackGround.fitHeightProperty().setValue(backgroundImage.getHeight());
        lblUpperText.setWrapText(true);
        lblTitle.setText("Ship Dockyard");
        lblUpperText.setText("Hello capitan, just indicate what you want to add to your ship");

        btnAddStorageSpace.setOnMouseClicked(e->{
            int storagePrice = playerShip.getStorageCapacity() * playerShip.getStorageCapacity()
                    +playerShip.getStorageCapacity();
            if (playerShip.getGold()> storagePrice){
                playerShip.setGold(playerShip.getGold()- storagePrice);
                playerShip.setStorageCapacity(playerShip.getStorageCapacity()+1);
                updatePlayerShip();
                updateCity(getCityState());
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }

        });

        btnAddCabin.setOnMouseClicked(e->{
            int cabinPrice = playerShip.getCabinCapacity() * playerShip.getCabinCapacity()
                    + playerShip.getCabinCapacity()+1;
            if (playerShip.getGold()> cabinPrice){
                playerShip.setGold(playerShip.getGold()- cabinPrice);
                playerShip.setCabinCapacity(playerShip.getCabinCapacity()+1);
                updatePlayerShip();
                updateCity(getCityState());
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }
        });

        btnAddSailSpace.setOnMouseClicked(e->{
            int sailPrice = playerShip.getSailCapacity()
                    *playerShip.getSailCapacity()
                    +playerShip.getSailCapacity()+10;

            if (playerShip.getGold()> sailPrice){
                playerShip.setGold(ShipManager.getInstance().getAllShips().get(0)
                        .getGold()- sailPrice);
                playerShip.setSailCapacity(playerShip.getSailCapacity()+1);
                updatePlayerShip();
                updateCity(getCityState());
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }
        });

        btnAddCannonSpace.setOnMouseClicked(e->{
            int cannonPrice = playerShip.getCannonCapacity() * playerShip.getCannonCapacity()
                    +playerShip.getCannonCapacity()+5;

            if (playerShip.getGold()> cannonPrice){
                playerShip.setGold(playerShip.getGold()- cannonPrice);
                playerShip.setCannonCapacity(playerShip.getCannonCapacity()+1);
                updatePlayerShip();
                updateCity(getCityState());
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }
        });

        btnRepair1.setOnMouseClicked(e->{
            if (playerShip.getCurrentEndurance() < playerShip.getEndurance()){
                if (playerShip.getGold() > 1){
                    playerShip.setGold(playerShip.getGold()-1);
                    playerShip.setCurrentEndurance(playerShip.getCurrentEndurance() + 1);
                    updatePlayerShip();
                    updateCityStateSmith();
                } else {
                    lblUpperText.setText("You haven't enough gold to repair..");
                }
            } else {

                lblUpperText.setText("There is nothing to repair..");
            }
        });

        btnRepair2.setOnMouseClicked(e->{
            if (playerShip.getCurrentEndurance() < playerShip.getEndurance() - 5){
                if (playerShip.getGold() > 5){
                    playerShip.setGold(playerShip.getGold()-5);
                    playerShip.setCurrentEndurance(playerShip.getCurrentEndurance() + 5);
                    updatePlayerShip();
                    updateCityStateSmith();
                } else {
                    lblUpperText.setText("You haven't enough gold to repair 5 points ..");
                }
            } else {
                lblUpperText.setText("You cannot repair so much..");
            }
        });

        btnRepair3.setOnMouseClicked(e->{
            int toRepair = playerShip.getEndurance() - playerShip.getCurrentEndurance();
            if (playerShip.getCurrentEndurance() < playerShip.getEndurance()){
                if (playerShip.getGold() > toRepair){
                    playerShip.setGold(playerShip.getGold()-toRepair);
                    playerShip.setCurrentEndurance(playerShip.getCurrentEndurance() + toRepair);
                    updatePlayerShip();
                    updateCityStateSmith();
                } else {
                    lblUpperText.setText("You haven't enough gold to repair " + toRepair + " points" );
                }
            } else {
                lblUpperText.setText("There is nothing to repair..");
            }
        });


        btnBack.setOnMouseClicked(e-> {
            setCityState("main");
            updateCity(getCityState());
        });

    }

    private void updateCity(String currentCityState){
        disableAllViews();
        switch (currentCityState){
            case "main":{
                updateCityStateMain();
                break;
            }
            case "smith":{
                updateCityStateSmith();
                break;
            }

            case "market":{

                break;
            }

            case "store":{

                break;
            }

        }
        ivBackGround.setImage(backgroundImage);

    }

    private void disableAllViews(){
        backgroundImage = null;
        btnBack.setVisible(false);
        btnMarket.setVisible(false);
        btnSmith.setVisible(false);
        btnStore.setVisible(false);
        btnTavern.setVisible(false);
        lblTitle.setText("");
        lblUpperText.setText("");

        btnAddStorageSpace.setVisible(false);
        btnAddCabin.setVisible(false);
        btnAddSailSpace.setVisible(false);
        btnAddCannonSpace.setVisible(false);
        btnAddSail1.setVisible(false);
        btnAddSail2.setVisible(false);
        btnAddSail3.setVisible(false);
        btnAddSail4.setVisible(false);
        btnRepair1.setVisible(false);
        btnRepair2.setVisible(false);
        btnRepair3.setVisible(false);

    }

    private void updateCityStateMain(){
        btnMarket.setVisible(true);
        btnSmith.setVisible(true);
        btnStore.setVisible(true);
        btnTavern.setVisible(true);
        lblTitle.setText(cities.get(0).getCityName());
        btnMarket.setGraphic(new ImageView(new Image("img/Market.png")));
        btnSmith.setGraphic(new ImageView(new Image("img/Smith.png")));
        btnStore.setGraphic(new ImageView(new Image("img/Store.png")));
        btnTavern.setGraphic(new ImageView(new Image("img/Tavern.png")));
        backgroundImage = new Image("img/CityRoyal.png");
        lblUpperText.setText("Hello capitan, just indicate what you want to do by clicking");
    }

    private void updateCityStateSmith(){
        lblTitle.setText("Smith");
        backgroundImage = new Image("img/BackgroundLine.png");
        lblUpperText.setText("click to add improvement");


        btnAddStorageSpace.setVisible(true);
        btnAddStorageSpace.setGraphic(new ImageView(new Image("img/StorageEmpty.png")));
        btnAddStorageSpace.setText("$" + (ShipManager.getInstance().getAllShips().get(0).getStorageCapacity()
                * ShipManager.getInstance().getAllShips().get(0).getStorageCapacity()
                + ShipManager.getInstance().getAllShips().get(0).getStorageCapacity()));

        btnAddCabin.setVisible(true);
        btnAddCabin.setGraphic(new ImageView(new Image("img/CrewEmpty.png")));
        btnAddCabin.setText("$" + (ShipManager.getInstance().getAllShips().get(0).getCabinCapacity()
                * ShipManager.getInstance().getAllShips().get(0).getCabinCapacity()
                + ShipManager.getInstance().getAllShips().get(0).getCabinCapacity()+1));

        btnAddSailSpace.setVisible(true);
        btnAddSailSpace.setGraphic(new ImageView(new Image("img/SailEmpty.png")));
        btnAddSailSpace.setText("$" + (ShipManager.getInstance().getAllShips().get(0).getSailCapacity()
                * ShipManager.getInstance().getAllShips().get(0).getSailCapacity()
                + ShipManager.getInstance().getAllShips().get(0).getSailCapacity()+10));

        btnAddCannonSpace.setVisible(true);
        btnAddCannonSpace.setGraphic(new ImageView(new Image("img/CannonEmpty.png")));
        btnAddCannonSpace.setText("$" + (ShipManager.getInstance().getAllShips().get(0).getCannonCapacity()
                * ShipManager.getInstance().getAllShips().get(0).getCannonCapacity()
                + ShipManager.getInstance().getAllShips().get(0).getCannonCapacity()+5));

        btnAddSail1.setVisible(true);
        btnAddSail1.setText("$" + new SailSmall().getPrice());
        btnAddSail1.setGraphic(new ImageView(new Image("img/SailNormal.png")));
        btnAddSail2.setVisible(true);
        btnAddSail2.setText("$" + new SailPirate().getPrice());
        btnAddSail2.setGraphic(new ImageView(new Image("img/SailPirate.png")));
        btnAddSail3.setVisible(true);
        btnAddSail3.setText("$" + new SailBig().getPrice());
        btnAddSail4.setVisible(true);
        btnAddSail4.setText("$" + new SailSharp().getPrice());

        btnRepair1.setVisible(true);
        btnRepair1.setGraphic(new ImageView(new Image("img/Anvil.png")));
        btnRepair1.setText("$1");
        btnRepair2.setVisible(true);
        btnRepair2.setGraphic(new ImageView(new Image("img/Anvil.png")));
        btnRepair2.setText("$5");
        btnRepair3.setVisible(true);
        btnRepair3.setGraphic(new ImageView(new Image("img/Anvil.png")));
        btnRepair3.setText("$" + (ShipManager.getInstance().getAllShips().get(0).getEndurance()
                - ShipManager.getInstance().getAllShips().get(0).getCurrentEndurance()));

        btnBack.setVisible(true);
    }



    private void updateScene(){
        /// TODO: 06.11.2017
    }

    private void updatePlayerShip(){
        updateGold();
        updateFood();
        updateAmmo();
        updateHp();
        updateStorage();
        updateCrew();
        updateSail();
        updateCannon();
    }

    private void updateGold(){
        lblPlayerGold.setText(String.valueOf(playerShip.getGold()));
    }

    private void updateFood(){
        lblPlayerFood.setText(String.valueOf(playerShip.getFood()));
    }

    private void updateAmmo(){
        lblPlayerAmmo.setText(String.valueOf(playerShip.getAmmo()));
    }

    private void updateHp(){
        /// TODO: 06.11.2017
    }



    public String getCityState() {
        return cityState;
    }

    private void updateStorage(){
        /// TODO: 06.11.2017
        ivStorage1.setImage(new Image("img/StorageEmpty.png"));
    }

    private void updateCrew(){
        /// TODO: 06.11.2017
    }

    private void updateSail(){
        /// TODO: 06.11.2017
    }

    private void updateCannon(){
        /// TODO: 06.11.2017
    }

}
