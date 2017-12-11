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

public class MarketController extends PlayerShipController implements Initializable {

    @FXML private ImageView ivBackGround;
    @FXML private Label lblTitle;
    @FXML private Label lblUpperText;
    @FXML private Label lblPriceFood;
    @FXML private Label lblPriceWheat;
    @FXML private Label lblPriceClothes;
    @FXML private Label lblPriceWine;
    @FXML private Label lblPriceMahogany;
    @FXML private Label lblPriceDecorations;
    @FXML private Label lblPriceSilk;
    @FXML private Label lblPriceSpices;
    @FXML private Button btnAddFood;
    @FXML private Button btnAddWheat;
    @FXML private Button btnAddClothes;
    @FXML private Button btnAddWine;
    @FXML private Button btnAddMahogany;
    @FXML private Button btnAddDecorations;
    @FXML private Button btnAddSilk;
    @FXML private Button btnAddSpices;
    @FXML private Button btnBack;

    private Image imgFood;
    private Image imgWheat;
    private Image imgClothes;
    private Image imgWine;
    private Image imgMahogany;
    private Image imgDecorations;
    private Image imgSilk;
    private Image imgSpices;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScene();
        buttonsRegister();
        showTutorial();
    }

    private void imgLoader(){
        setBackgroundImage(new Image("img/BackGround.png"));
        imgFood = new Image("img/goods/Food.png");
        imgWheat = new Image("img/goods/Wheat.png");
        imgClothes = new Image("img/goods/Clothes.png");
        imgWine = new Image("img/goods/Wine.png");
        imgMahogany = new Image("img/goods/Mahogany.png");
        imgDecorations = new Image("img/goods/Decorations.png");
        imgSilk = new Image("img/goods/Silk.png");
        imgSpices = new Image("img/goods/Spices.png");
    }

    /**
     * Method to inform new user about template possibilities. What is allowed, what not, what is here to do etc.
     */
    private void showTutorial(){
        if (getPLAYER_SHIP().getAchievement().isFirstTimeInMarket()){
            //todo show info about city dockyard
            System.out.println("show info about city market");
            getPLAYER_SHIP().getAchievement().setFirstTimeInMarket(true);
        }
    }

    private void updateScene(){

        updatePlayerShip(getPLAYER_SHIP());
    }

    private void updateMarketView(){
        lblTitle.setText("Market");
        ivBackGround.setImage(getBackgroundImage());
        btnAddFood.setGraphic(new ImageView(imgFood));
        btnAddWheat.setGraphic(new ImageView(imgWheat));
        btnAddClothes.setGraphic(new ImageView(imgClothes));
        btnAddWine.setGraphic(new ImageView(imgWine));
        btnAddMahogany.setGraphic(new ImageView(imgMahogany));
        btnAddDecorations.setGraphic(new ImageView(imgDecorations));
        btnAddSilk.setGraphic(new ImageView(imgSilk));
        btnAddSpices.setGraphic(new ImageView(imgSpices));
        updateShipBackgroundView();
    }

    private void buttonsRegister(){

        btnRegBack();
    }

    private void btnRegBack(){
        btnBack.setOnMouseClicked(click->{
            Stage dockyard = (Stage) btnBack.getScene().getWindow();
            getScene().sceneChange(dockyard, getScene().sceneNameFinderByEnum(getScene().getBackStage()));
        });
    }

}
