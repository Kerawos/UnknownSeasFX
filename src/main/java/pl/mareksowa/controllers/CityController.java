package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.dao.impl.ShipDaoImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class CityController implements Initializable {
    @FXML ImageView ivBackGround;

    @FXML private ImageView ivShip;
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




    @FXML private Label lblPlayerHp;
    @FXML private ProgressBar pbShipHp;


    private Image backgroundImage;
    private ShipDaoImpl shipDao;
    private Ship playerShip;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        shipDao = ShipDaoImpl.getInstance();
        playerShip = shipDao.getAllShips().get(0);
        updatePlayerShip();
        backgroundImage = new Image("img/BackGroundLine.png");
        ivBackGround.setImage(backgroundImage);
        ivBackGround.fitWidthProperty().setValue(backgroundImage.getWidth());
        ivBackGround.fitHeightProperty().setValue(backgroundImage.getHeight());
        lblUpperText.setWrapText(true);
        lblTitle.setText("City panel");
        lblUpperText.setText("Hello capitan, just indicate what you want to do");
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
        Menu.getInstance().updateSail(ivSail1, ivSail2, ivSail3, ivSail4, ivSail5, ivSail6, ivSail6, ivSail8,
                ivSail9, ivSail10);
        Menu.getInstance().updateCannon(ivCannon1, ivCannon2, ivCannon3, ivCannon4, ivCannon5, ivCannon6,
                ivCannon7, ivCannon8, ivCannon9, ivCannon10);
    }


}
