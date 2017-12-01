package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.mareksowa.models.SceneManager;
import pl.mareksowa.models.functionalities.ShipFunctionality;
import pl.mareksowa.models.ships.Ship;

import java.net.URL;
import java.util.ResourceBundle;

public class CityController extends PlayerShipController implements Initializable {

    @FXML private ImageView ivBackGround;
    @FXML private Label lblUpperText;
    @FXML private Label lblTitle;
    @FXML private Button btnMarket;
    @FXML private Button btnSmith;
    @FXML private Button btnTavern;
    @FXML private Button btnStore;
    @FXML private Button btnBack;

    private Image backgroundImage;
    private Ship PLAYER_SHIP;
    private ShipFunctionality shipFun;
    private SceneManager scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        shipFun = SceneManager.getInstance().getShipFunctionality();
        scene = SceneManager.getInstance();
        PLAYER_SHIP = scene.getPLAYER_SHIP();
        lblUpperText.setWrapText(true);
        updateScene();

        btnSmith.setOnMouseClicked(click -> {
            Stage dockyard = (Stage) btnSmith.getScene().getWindow();
            scene.sceneChange(dockyard, "scenes/dockyard.fxml");
        });

        btnStore.setOnMouseClicked(click->{
            //todo
            System.out.println("store");
//            Stage store = (Stage) btnStore.getScene().getWindow();
//            scene.sceneChange(store, "scenes/xxx.fxml");
        });

        btnTavern.setOnMouseClicked(click->{
            //todo
        });

        btnMarket.setOnMouseClicked(click->{
            //todo
        });

        btnBack.setOnMouseClicked(click->{
            //todo
        });
    }

    private void updateScene(){
        disableAllViews();
        updateAllViews();
        updatePlayerShip();
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
    }

    private void updateAllViews(){
        btnMarket.setVisible(true);
        btnSmith.setVisible(true);
        btnStore.setVisible(true);
        btnTavern.setVisible(true);
        lblTitle.setText(scene.getCityFunctionality().convertCityNameToString(scene.getCURRENT_CITY().getCityName()));
        btnMarket.setGraphic(new ImageView(new Image("img/Market.png")));
        btnSmith.setGraphic(new ImageView(new Image("img/Smith.png")));
        btnStore.setGraphic(new ImageView(new Image("img/Store.png")));
        btnTavern.setGraphic(new ImageView(new Image("img/Tavern.png")));
        backgroundImage = new Image("img/CityRoyal.png");
        ivBackGround.setImage(backgroundImage);
        ivBackGround.fitWidthProperty().setValue(backgroundImage.getWidth());
        ivBackGround.fitHeightProperty().setValue(backgroundImage.getHeight());
        updateShipBacgroundView();
        lblUpperText.setText("Hello capitan, just indicate what you want to do by clicking");
    }


    public void updatePlayerShip(){
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
        shipFun.updateGold(PLAYER_SHIP, getLblPlayerGold());
    }

    private void updateFood(){
        shipFun.updateFood(PLAYER_SHIP, getLblPlayerFood());
    }

    private void updateAmmo(){
        shipFun.updateAmmo(PLAYER_SHIP, getLblPlayerAmmo());
    }

    private void updateHp(){
        shipFun.updateHp(PLAYER_SHIP, getLblPlayerHp(), getPbShipHp());
    }

    private void updateStorage(){
        shipFun.updateStorage(PLAYER_SHIP, getIvStorage1(), getIvStorage2(), getIvStorage3(), getIvStorage4(), getIvStorage5(),
                getIvStorage6(), getIvStorage7(), getIvStorage8(), getIvStorage9(), getIvStorage10());
    }

    private void updateCrew(){
        shipFun.updateCrew(PLAYER_SHIP, getIvCrew1(), getIvCrew2(), getIvCrew3(), getIvCrew4(), getIvCrew5(), getIvCrew6(),
                getIvCrew7(), getIvCrew8(),getIvCrew9(), getIvCrew10());
    }

    private void updateSail(){
        shipFun.updateSail(PLAYER_SHIP, getIvSail1(), getIvSail2(), getIvSail3(), getIvSail4(), getIvSail5(),
                getIvSail6(), getIvSail7(), getIvSail8(), getIvSail9(), getIvSail10());
    }

    private void updateCannon(){
        shipFun.updateCannon(PLAYER_SHIP, getIvCannon1(),getIvCannon2(), getIvCannon3(), getIvCannon4(), getIvCannon5(),
                getIvCannon6(), getIvCannon7(), getIvCannon8(), getIvCannon9(), getIvCannon10());
    }


}
