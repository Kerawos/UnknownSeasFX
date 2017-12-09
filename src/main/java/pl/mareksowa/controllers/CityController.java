package pl.mareksowa.controllers;
/**
 * Import section
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.mareksowa.models.SceneNameEquivalent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Control specific city behaviours. Responsible for change city scenes like: go to dockyard, store etc. Also view
 * player ship statistics.
 */
public class CityController extends PlayerShipController implements Initializable {

    /**
     * Lables
     */
    @FXML private ImageView ivBackGround;
    @FXML private Label lblUpperText;
    @FXML private Label lblTitle;
    @FXML private Button btnMarket;
    @FXML private Button btnSmith;
    @FXML private Button btnTavern;
    @FXML private Button btnStore;
    @FXML private Button btnBack;

    /**
     * Initialize scene
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScene();
        buttonsRegister();
        showTutorial();
    }

    /**
     * Method to inform new user about template possibilities. What is allowed, what not, what is here to do etc.
     */
    private void showTutorial(){
        if (getPLAYER_SHIP().getAchievement().isFirstTimeInCity()){
            //todo show info about city
            System.out.println("show info about city");
            getPLAYER_SHIP().getAchievement().setFirstTimeInCity(true);
        }
    }

    /**
     * Update this scene after any changes. Started from refresh every views, disable and turn on everything to prevent
     * glitches. Enable only necessary functions to user. At the end update player ship.
     */
    private void updateScene(){
        disableAllViews();
        updateAllViews();
        updatePlayerShip(getPLAYER_SHIP());
    }

    /**
     * Logic of behaviour of all buttons in city scene
     */
    private void buttonsRegister(){
        btnRegSmith();
        btnRegStore();
        btnRegMarket();
        btnRegTavern();
        btnRegBack();
    }

    /**
     * Behaviour scene after clicking this button. It will change proper scene with saving previous scene to later
     * getting back to city view.
     */
    private void btnRegSmith(){
        btnSmith.setOnMouseClicked(click -> {
            getScene().setBackStage(SceneNameEquivalent.sceneEnumName.CITY);
            Stage dockyard = (Stage) btnSmith.getScene().getWindow();
            getScene().sceneChange(dockyard, getScene().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.DOCKYARD));
        });
    }

    /**
     * Behaviour scene after clicking this button. It will change proper scene with saving previous scene to later
     * getting back to city view.
     */
    private void btnRegStore(){
        btnStore.setOnMouseClicked(click->{
            //todo
            System.out.println("store");
        });
    }

    /**
     * Behaviour scene after clicking this button. It will change proper scene with saving previous scene to later
     * getting back to city view.
     */
    private void btnRegMarket(){
        btnMarket.setOnMouseClicked(click->{
            getScene().setBackStage(SceneNameEquivalent.sceneEnumName.CITY);
            Stage market = (Stage) btnMarket.getScene().getWindow();
            getScene().sceneChange(market, getScene().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.MARKET));
        });
    }

    /**
     * Behaviour scene after clicking this button. It will change proper scene with saving previous scene to later
     * getting back to city view.
     */
    private void btnRegTavern(){
        btnTavern.setOnMouseClicked(click->{
            //todo
        });
    }

    /**
     * Behaviour scene after clicking this button. It will change proper scene with saving previous scene to later
     * getting back to city view.
     */
    private void btnRegBack(){
        btnBack.setOnMouseClicked(click->{
            //todo
            Stage worldMap = (Stage) btnBack.getScene().getWindow();
            getScene().sceneChange(worldMap, getScene().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.WORLD_MAP));
        });
    }

    /**
     * Disable all views
     */
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

    /**
     * Method hide all FX functionality before showing results. To prevent of 'glitches' or 'duplicates' causing
     * from time to time by java FX.
     */
    private void updateAllViews(){
        btnMarket.setVisible(true);
        btnSmith.setVisible(true);
        btnStore.setVisible(true);
        btnTavern.setVisible(true);
        btnBack.setVisible(true);
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
