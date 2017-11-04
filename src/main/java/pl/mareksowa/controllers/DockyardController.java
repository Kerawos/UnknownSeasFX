package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.dao.impl.ShipDaoImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class DockyardController implements Initializable{

    @FXML
    ImageView ivBackGround;

    @FXML
    private ImageView ivShip;

    @FXML
    private Label lblUpperText;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblPlayerGold;

    @FXML
    private Label lblPlayerFood;

    @FXML
    private Label lblPlayerAmmo;


    @FXML
    private Button btStorage1;

    @FXML
    private Button btStorage2;

    @FXML
    private Button btStorage3;

    @FXML
    private Button btStorage4;

    @FXML
    private Button btStorage5;

    @FXML
    private Button btStorage6;

    @FXML
    private Button btStorage7;

    @FXML
    private Button btStorage8;

    @FXML
    private Button btStorage9;

    @FXML
    private Button btStorage10;


    private Image backgroundImage;
    private ShipDaoImpl shipDao;
    private Ship playerShip;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        shipDao = ShipDaoImpl.getInstance();
        playerShip = shipDao.getAllShips().get(0);
        lblPlayerGold.setText(String.valueOf(playerShip.getGold()));
        lblPlayerFood.setText(String.valueOf(playerShip.getFood()));
        lblPlayerAmmo.setText(String.valueOf(playerShip.getAmmo()));

        btStorage1.setGraphic(new ImageView("img/StorageEmpty.png"));
        btStorage2.setGraphic(new ImageView("img/StorageEmpty.png"));
        btStorage3.setGraphic(new ImageView("img/StorageEmpty.png"));
        btStorage4.setGraphic(new ImageView("img/StorageEmpty.png"));
        btStorage5.setGraphic(new ImageView("img/StorageEmpty.png"));
        btStorage6.setGraphic(new ImageView("img/StorageEmpty.png"));
        btStorage7.setGraphic(new ImageView("img/StorageEmpty.png"));
        btStorage8.setGraphic(new ImageView("img/StorageEmpty.png"));
        btStorage9.setGraphic(new ImageView("img/StorageEmpty.png"));
        btStorage10.setGraphic(new ImageView("img/StorageEmpty.png"));


        //lblPlayerGold.setText(shipDao.getAllShips().size() + " licza statkow");
        backgroundImage = new Image("img/BackGroundLine.png");
        ivBackGround.setImage(backgroundImage);
        ivBackGround.fitWidthProperty().setValue(backgroundImage.getWidth());
        ivBackGround.fitHeightProperty().setValue(backgroundImage.getHeight());
        lblUpperText.setWrapText(true);
        lblTitle.setText("Ship Dockyard");
        lblUpperText.setText("Hello capitan, just indicate what you want to add to your ship");
    }

}
