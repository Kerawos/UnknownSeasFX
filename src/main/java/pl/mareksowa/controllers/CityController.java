package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.cities.RoyalCity;
import pl.mareksowa.models.sails.*;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.dao.impl.ShipDaoImpl;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CityController implements Initializable {
    @FXML ImageView ivBackGround;

    @FXML private Label lblUpperText;
    @FXML private Label lblTitle;

    @FXML private Label lblPlayerGold;
    @FXML private Label lblPlayerFood;
    @FXML private Label lblPlayerAmmo;

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

    @FXML private Button btnMarket;
    @FXML private Button btnSmith;
    @FXML private Button btnTavern;
    @FXML private Button btnStore;

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
    private ShipDaoImpl shipDao;
    private Ship playerShip;
    private List<City> cities;

    private String cityState;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCityState("main");
        cities = Arrays.asList(new RoyalCity());
        updateCity(getCityState());
        shipDao = ShipDaoImpl.getInstance();
        playerShip = shipDao.getAllShips().get(0);
        updatePlayerShip();

        ivBackGround.fitWidthProperty().setValue(backgroundImage.getWidth());
        ivBackGround.fitHeightProperty().setValue(backgroundImage.getHeight());
        lblUpperText.setWrapText(true);

        btnSmith.setOnMouseClicked(e->{
            setCityState("smith");
            updateCity(getCityState());
            updatePlayerShip();

        });

        btnAddStorageSpace.setOnMouseClicked(e->{
            int storagePrice = ShipDaoImpl.getInstance().getAllShips().get(0).getStorageCapacity()
                    *ShipDaoImpl.getInstance().getAllShips().get(0).getStorageCapacity()
                    +ShipDaoImpl.getInstance().getAllShips().get(0).getStorageCapacity();

            if (ShipDaoImpl.getInstance().getAllShips().get(0).getGold()> storagePrice){

                ShipDaoImpl.getInstance().getAllShips().get(0).setGold(ShipDaoImpl.getInstance().getAllShips().get(0)
                        .getGold()- storagePrice);

                ShipDaoImpl.getInstance().getAllShips().get(0).setStorageCapacity(ShipDaoImpl.getInstance()
                        .getAllShips().get(0).getStorageCapacity()+1);
                updatePlayerShip();
                updateCity(getCityState());
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }

        });

        btnAddCabin.setOnMouseClicked(e->{
            int cabinPrice = ShipDaoImpl.getInstance().getAllShips().get(0).getCabinCapacity()
                    *ShipDaoImpl.getInstance().getAllShips().get(0).getCabinCapacity()
                    +ShipDaoImpl.getInstance().getAllShips().get(0).getCabinCapacity()+1;

            if (ShipDaoImpl.getInstance().getAllShips().get(0).getGold()> cabinPrice){

                ShipDaoImpl.getInstance().getAllShips().get(0).setGold(ShipDaoImpl.getInstance().getAllShips().get(0)
                        .getGold()- cabinPrice);

                ShipDaoImpl.getInstance().getAllShips().get(0).setCabinCapacity(ShipDaoImpl.getInstance()
                        .getAllShips().get(0).getCabinCapacity()+1);
                updatePlayerShip();
                updateCity(getCityState());
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }
        });

        btnAddSailSpace.setOnMouseClicked(e->{
            int sailPrice = ShipDaoImpl.getInstance().getAllShips().get(0).getSailCapacity()
                    *ShipDaoImpl.getInstance().getAllShips().get(0).getSailCapacity()
                    +ShipDaoImpl.getInstance().getAllShips().get(0).getSailCapacity()+10;

            if (ShipDaoImpl.getInstance().getAllShips().get(0).getGold()> sailPrice){

                ShipDaoImpl.getInstance().getAllShips().get(0).setGold(ShipDaoImpl.getInstance().getAllShips().get(0)
                        .getGold()- sailPrice);

                ShipDaoImpl.getInstance().getAllShips().get(0).setSailCapacity(ShipDaoImpl.getInstance()
                        .getAllShips().get(0).getSailCapacity()+1);
                updatePlayerShip();
                updateCity(getCityState());
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }
        });

        btnAddCannonSpace.setOnMouseClicked(e->{
            int cannonPrice = ShipDaoImpl.getInstance().getAllShips().get(0).getCannonCapacity()
                    *ShipDaoImpl.getInstance().getAllShips().get(0).getCannonCapacity()
                    +ShipDaoImpl.getInstance().getAllShips().get(0).getCannonCapacity()+5;

            if (ShipDaoImpl.getInstance().getAllShips().get(0).getGold()> cannonPrice){

                ShipDaoImpl.getInstance().getAllShips().get(0).setGold(ShipDaoImpl.getInstance().getAllShips().get(0)
                        .getGold()- cannonPrice);

                ShipDaoImpl.getInstance().getAllShips().get(0).setCannonCapacity(ShipDaoImpl.getInstance()
                        .getAllShips().get(0).getCannonCapacity()+1);
                updatePlayerShip();
                updateCity(getCityState());
            } else {
                lblUpperText.setText("You don't have enough gold..");
            }
        });

        btnBack.setOnMouseClicked(e-> {
            setCityState("main");
            updateCity(getCityState());
        });

    }

    private void updateScene(){
        /// TODO: 06.11.2017
    }

    public void updatePlayerShip(){
        Menu.getInstance().updateGold(lblPlayerGold);
        Menu.getInstance().updateFood(lblPlayerFood);
        Menu.getInstance().updateAmmo(lblPlayerAmmo);
        Menu.getInstance().updateHp(lblPlayerHp, pbShipHp);
        Menu.getInstance().updateStorage(ivStorage1, ivStorage2, ivStorage3, ivStorage4, ivStorage5, ivStorage6,
                ivStorage7, ivStorage8, ivStorage9, ivStorage10);
        Menu.getInstance().updateCrew(ivCrew1, ivCrew2, ivCrew3, ivCrew4, ivCrew5, ivCrew6, ivCrew7, ivCrew8,
                ivCrew9, ivCrew10);
        Menu.getInstance().updateSail(ivSail1, ivSail2, ivSail3, ivSail4, ivSail5, ivSail6, ivSail7, ivSail8,
                ivSail9, ivSail10);
        Menu.getInstance().updateCannon(ivCannon1, ivCannon2, ivCannon3, ivCannon4, ivCannon5, ivCannon6,
                ivCannon7, ivCannon8, ivCannon9, ivCannon10);
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
        btnAddStorageSpace.setText("$" + (ShipDaoImpl.getInstance().getAllShips().get(0).getStorageCapacity()
                *ShipDaoImpl.getInstance().getAllShips().get(0).getStorageCapacity()
                +ShipDaoImpl.getInstance().getAllShips().get(0).getStorageCapacity()));

        btnAddCabin.setVisible(true);
        btnAddCabin.setGraphic(new ImageView(new Image("img/CrewEmpty.png")));
        btnAddCabin.setText("$" + (ShipDaoImpl.getInstance().getAllShips().get(0).getCabinCapacity()
                *ShipDaoImpl.getInstance().getAllShips().get(0).getCabinCapacity()
                +ShipDaoImpl.getInstance().getAllShips().get(0).getCabinCapacity()+1));

        btnAddSailSpace.setVisible(true);
        btnAddSailSpace.setGraphic(new ImageView(new Image("img/SailEmpty.png")));
        btnAddSailSpace.setText("$" + (ShipDaoImpl.getInstance().getAllShips().get(0).getSailCapacity()
                *ShipDaoImpl.getInstance().getAllShips().get(0).getSailCapacity()
                +ShipDaoImpl.getInstance().getAllShips().get(0).getSailCapacity()+10));

        btnAddCannonSpace.setVisible(true);
        btnAddCannonSpace.setGraphic(new ImageView(new Image("img/CannonEmpty.png")));
        btnAddCannonSpace.setText("$" + (ShipDaoImpl.getInstance().getAllShips().get(0).getCannonCapacity()
                *ShipDaoImpl.getInstance().getAllShips().get(0).getCannonCapacity()
                +ShipDaoImpl.getInstance().getAllShips().get(0).getCannonCapacity()+5));

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
        btnRepair3.setText("$" + (ShipDaoImpl.getInstance().getAllShips().get(0).getEndurance()
                - ShipDaoImpl.getInstance().getAllShips().get(0).getCurrentEndurance()));

        btnBack.setVisible(true);
    }

    public String getCityState() {
        return cityState;
    }

    public void setCityState(String cityState) {
        this.cityState = cityState;
    }
}
