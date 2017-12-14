package pl.mareksowa.controllers;

/**
 * Imports section
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.goods.GoodName;
import pl.mareksowa.models.ships.Ship;


import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MarketController extends PlayerShipController implements Initializable {

    /**
     * Label declarations
     */
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
        setBackgroundImage(new Image("img/scenes/BackGround.png"));
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
        if (getShipPlayerCurrent().getAchievement().isFirstTimeInMarket()){
            //todo show info about city dockyard
            System.out.println("show info about city market");
            getShipPlayerCurrent().getAchievement().setFirstTimeInMarket(true);
        }
    }

    private void updateScene(){
        updateMarketView();
        updatePlayerShip(getShipPlayerCurrent());
    }

    private void updateMarketView(){
        imgLoader();
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
        lblPriceWheat.setText("Wheat: "+ getCityManager().priceOf(GoodName.WHEAT) + "gold");
        lblPriceClothes.setText("Clothes: "+ getCityManager().priceOf(GoodName.CLOTHES) + "gold");
        lblPriceWine.setText("Wine: "+ getCityManager().priceOf(GoodName.WINE) + "gold");
        lblPriceMahogany.setText("Mahogany: "+ getCityManager().priceOf(GoodName.MAHOGANY) + "gold");
        lblPriceDecorations.setText("Decorations: "+ getCityManager().priceOf(GoodName.DECORATIONS) + "gold");
        lblPriceSilk.setText("Silk: "+ getCityManager().priceOf(GoodName.SILK) + "gold");
        lblPriceSpices.setText("Spices: "+ getCityManager().priceOf(GoodName.SPICES) + "gold");
        lblUpperText.setText("Click good to buy it, to sell click equivalent in your ship");
    }



    private void buttonsRegister(){
        setBtnAddWheat();
        setBtnAddClothes();
        setBtnAddWine();
        setBtnAddMahogany();
        setBtnAddSilk();
        setBtnAddDecorations();
        setBtnAddSpices();
        setIvStorage1();
        setIvStorage2();
        setIvStorage3();
        setIvStorage4();
        setIvStorage5();
        setIvStorage6();
        setIvStorage7();
        setIvStorage8();
        setIvStorage9();
        setIvStorage10();
        btnRegBack();
    }

    private void buyGood(Ship playerShip, Good good){
        if (getShipTradeManager().canBuyGood(playerShip, good)){
            getShipTradeManager().buyGood(playerShip, good);
            updateScene();
        }
    }

    private void sellGood(Ship playerShip, int storageListNo){
        if (getShipTradeManager().canSellGood(playerShip, storageListNo)){
            getShipTradeManager().sellGood(playerShip, getShipPlayerCurrent().getStorage().get(storageListNo),
                    getCityManager().getCitySellPrice(getShipPlayerCurrent().getStorage().get(storageListNo)));
            updateScene();
        }
    }

    private void setBtnAddWheat(){
        btnAddWheat.setOnMouseClicked(click-> buyGood(getShipPlayerCurrent(), getCityManager().getExistedGood(GoodName.WHEAT)));
    }

    private void setBtnAddClothes(){
        btnAddClothes.setOnMouseClicked(click-> buyGood(getShipPlayerCurrent(),getCityManager().getExistedGood(GoodName.CLOTHES)));
    }

    private void setBtnAddWine(){
        btnAddWine.setOnMouseClicked(click-> buyGood(getShipPlayerCurrent(), getCityManager().getExistedGood(GoodName.WINE)));
    }

    private void setBtnAddMahogany(){
        btnAddMahogany.setOnMouseClicked(click-> buyGood(getShipPlayerCurrent(), getCityManager().getExistedGood(GoodName.MAHOGANY)));
    }

    private void setBtnAddSilk(){
        btnAddSilk.setOnMouseClicked(click-> buyGood(getShipPlayerCurrent(), getCityManager().getExistedGood(GoodName.SILK)));
    }

    private void setBtnAddDecorations(){
        btnAddDecorations.setOnMouseClicked(click-> buyGood(getShipPlayerCurrent(), getCityManager().getExistedGood(GoodName.DECORATIONS)));
    }

    private void setBtnAddSpices(){
        btnAddSpices.setOnMouseClicked(click-> buyGood(getShipPlayerCurrent(), getCityManager().getExistedGood(GoodName.SPICES)));
    }

    private void setIvStorage1(){
        getIvStorage1().setOnMouseClicked(click->sellGood(getShipPlayerCurrent(), 0));
    }

    private void setIvStorage2(){
        getIvStorage2().setOnMouseClicked(click->sellGood(getShipPlayerCurrent(), 1));
    }

    private void setIvStorage3(){
        getIvStorage3().setOnMouseClicked(click->sellGood(getShipPlayerCurrent(), 2));
    }

    private void setIvStorage4(){
        getIvStorage4().setOnMouseClicked(click->sellGood(getShipPlayerCurrent(), 3));
    }

    private void setIvStorage5(){
        getIvStorage5().setOnMouseClicked(click->sellGood(getShipPlayerCurrent(), 4));
    }

    private void setIvStorage6(){
        getIvStorage6().setOnMouseClicked(click->sellGood(getShipPlayerCurrent(), 5));
    }

    private void setIvStorage7(){
        getIvStorage7().setOnMouseClicked(click->sellGood(getShipPlayerCurrent(), 6));
    }

    private void setIvStorage8(){
        getIvStorage8().setOnMouseClicked(click->sellGood(getShipPlayerCurrent(), 7));
    }

    private void setIvStorage9(){
        getIvStorage9().setOnMouseClicked(click->sellGood(getShipPlayerCurrent(), 8));
    }

    private void setIvStorage10(){
        getIvStorage10().setOnMouseClicked(click->sellGood(getShipPlayerCurrent(), 9));
    }



    private void btnRegBack(){
        btnBack.setOnMouseClicked(click->{
            Stage dockyard = (Stage) btnBack.getScene().getWindow();
            getSceneManager().sceneChange(dockyard, getSceneManager().sceneNameFinderByEnum(getSceneManager().getBackStage()));
        });
    }

}
