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

    private Image backgroundImage;

    private ShipDaoImpl shipDao;
    private Ship playerShip;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        shipDao = ShipDaoImpl.getInstance();
        playerShip = shipDao.getAllShips().get(0);
        lblPlayerGold.setText("Your Gold $" + playerShip.getGold());
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
