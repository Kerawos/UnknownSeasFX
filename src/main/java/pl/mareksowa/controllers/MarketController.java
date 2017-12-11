package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.goods.GoodName;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MarketController extends PlayerShipController implements Initializable {

    @FXML private ImageView ivBackGround;
    @FXML private Label lblTitle;
    @FXML private Label lblUpperText;
    @FXML private Label lblPriceWheat;
    @FXML private Label lblPriceClothes;
    @FXML private Label lblPriceWine;
    @FXML private Label lblPriceMahogany;
    @FXML private Label lblPriceDecorations;
    @FXML private Label lblPriceSilk;
    @FXML private Label lblPriceSpices;
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
        imgLoader();
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
        updateMarketView();
        updatePlayerShip(getPLAYER_SHIP());
    }

    private void updateMarketView(){
        lblTitle.setText("Market");
        ivBackGround.setImage(getBackgroundImage());
        btnAddWheat.setGraphic(new ImageView(imgWheat));
        btnAddClothes.setGraphic(new ImageView(imgClothes));
        btnAddWine.setGraphic(new ImageView(imgWine));
        btnAddMahogany.setGraphic(new ImageView(imgMahogany));
        btnAddDecorations.setGraphic(new ImageView(imgDecorations));
        btnAddSilk.setGraphic(new ImageView(imgSilk));
        btnAddSpices.setGraphic(new ImageView(imgSpices));
        updateLabels();
        updateShipBackgroundView();
    }

    private void updateLabels(){
        lblPriceWheat.setText("Wheat: "+ priceOf(GoodName.WHEAT) + "gold");
        lblPriceClothes.setText("Clothes: "+ priceOf(GoodName.CLOTHES) + "gold");
        lblPriceWine.setText("Wine: "+ priceOf(GoodName.WINE) + "gold");
        lblPriceMahogany.setText("Mahogany: "+ priceOf(GoodName.MAHOGANY) + "gold");
        lblPriceDecorations.setText("Decorations: "+ priceOf(GoodName.DECORATIONS) + "gold");
        lblPriceSilk.setText("Silk: "+ priceOf(GoodName.SILK) + "gold");
        lblPriceSpices.setText("Spices: "+ priceOf(GoodName.SPICES) + "gold");
        lblUpperText.setText("Click good to buy it, to sell click equivalent in your ship");
    }

    private int priceOf(GoodName goodName){
        List<Good> goodList = getScene().getCURRENT_CITY().getGoodList();
        for (int i = 0; i < goodList.size(); i++) {
            if (goodList.get(i).getName()==goodName){
                return goodList.get(i).getPrice();
            }
        }
        return 999;
    }

    private void buttonsRegister(){

        btnRegBack();
    }

    private void setBtnAddWheat(){
        btnAddWheat.setOnMouseClicked(click->{
            getScene().getShipFunctionality().buyGood(getPLAYER_SHIP(), new Good(GoodName.WHEAT));
        });
    }

    private void btnRegBack(){
        btnBack.setOnMouseClicked(click->{
            Stage dockyard = (Stage) btnBack.getScene().getWindow();
            getScene().sceneChange(dockyard, getScene().sceneNameFinderByEnum(getScene().getBackStage()));
        });
    }

}
