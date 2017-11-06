package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.dao.impl.ShipDaoImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class DockyardController implements Initializable{

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


    private Image backgroundImage;
    private ShipDaoImpl shipDao;
    private Ship playerShip;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //updatePlayerShip();
        shipDao = ShipDaoImpl.getInstance();
        playerShip = shipDao.getAllShips().get(0);
        backgroundImage = new Image("img/BackGroundLine.png");
        ivBackGround.setImage(backgroundImage);
        ivBackGround.fitWidthProperty().setValue(backgroundImage.getWidth());
        ivBackGround.fitHeightProperty().setValue(backgroundImage.getHeight());
        lblUpperText.setWrapText(true);
        lblTitle.setText("Ship Dockyard");
        lblUpperText.setText("Hello capitan, just indicate what you want to add to your ship");
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
