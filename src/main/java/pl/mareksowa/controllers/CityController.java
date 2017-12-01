package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        updateScene();
        buttonsRegister();
    }

    private void buttonsRegister(){
        btnRegSmith();
        btnRegStore();
        btnRegMarket();
        btnRegTavern();
        btnRegBack();
    }

    private void btnRegSmith(){
        btnSmith.setOnMouseClicked(click -> {
            Stage dockyard = (Stage) btnSmith.getScene().getWindow();
            getScene().sceneChange(dockyard, "scenes/dockyard.fxml");
        });
    }

    private void btnRegStore(){
        btnStore.setOnMouseClicked(click->{
            //todo
            System.out.println("store");
//            Stage store = (Stage) btnStore.getScene().getWindow();
//            scene.sceneChange(store, "scenes/xxx.fxml");
        });
    }

    private void btnRegMarket(){
        btnMarket.setOnMouseClicked(click->{
            //todo
        });
    }
    private void btnRegTavern(){
        btnTavern.setOnMouseClicked(click->{
            //todo
        });
    }

    private void btnRegBack(){
        btnBack.setOnMouseClicked(click->{
            //todo
        });
    }

    private void updateScene(){
        disableAllViews();
        updateAllViews();
        updatePlayerShip(getPLAYER_SHIP());
    }

    private void disableAllViews(){
        setBackgroundImage(null);
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
        lblUpperText.setWrapText(true);
        lblTitle.setText(getScene().getCityFunctionality().convertCityNameToString(getScene().getCURRENT_CITY().getCityName()));
        btnMarket.setGraphic(new ImageView(new Image("img/Market.png")));
        btnSmith.setGraphic(new ImageView(new Image("img/Smith.png")));
        btnStore.setGraphic(new ImageView(new Image("img/Store.png")));
        btnTavern.setGraphic(new ImageView(new Image("img/Tavern.png")));
        setBackgroundImage(new Image("img/CityRoyal.png"));
        ivBackGround.setImage(getBackgroundImage());
        ivBackGround.fitWidthProperty().setValue(getBackgroundImage().getWidth());
        ivBackGround.fitHeightProperty().setValue(getBackgroundImage().getHeight());
        updateShipBackgroundView();
        lblUpperText.setText("Hello capitan, just indicate what you want to do by clicking");
    }
}
