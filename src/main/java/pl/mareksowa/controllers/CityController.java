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
import org.springframework.stereotype.Component;
import pl.mareksowa.models.CurrentScene;
import pl.mareksowa.models.SceneNameEquivalent;
import pl.mareksowa.models.cities.City;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Control specific city behaviours. Responsible for change city scenes like: go to dockyard, store etc. Also view
 * player ship statistics.
 */
@Component
public class CityController extends PlayerShipController implements Initializable {

    /**
     * Label declaration
     */
    @FXML private ImageView ivBackGround;
    @FXML private Label lblUpperText;
    @FXML private Label lblTitle;
    @FXML private Button btnMarket;
    @FXML private Button btnSmith;
    @FXML private Button btnTavern;
    @FXML private Button btnArmory;
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
        if (!getShipPlayerCurrent().getAchievement().isFirstTimeInCity()){
            //todo show info about city
            System.out.println("show info about city");
            getShipPlayerCurrent().getAchievement().setFirstTimeInCity(true);
        }
    }

    /**
     * Update this scene after any changes. Started from refresh every views, disable and turn on everything to prevent
     * glitches. Enable only necessary functions to user. At the end update player ship.
     */
    private void updateScene(){
        getSceneManager().setLastDayInVisitedCity(getSceneManager().getGameTime().getDay());
        disableAllViews();
        updateAllViews();
        updatePlayerShip(getShipPlayerCurrent());
    }

    /**
     * Logic of behaviour of all buttons in city scene
     */
    private void buttonsRegister(){
        btnRegSmith();
        btnRegArmory();
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
            getSceneManager().setBackStage(SceneNameEquivalent.sceneEnumName.CITY);
            Stage dockyard = (Stage) btnSmith.getScene().getWindow();
            getSceneManager().sceneChangeInit(dockyard, getSceneManager().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.DOCKYARD), getPaneScene());
        });
    }

    /**
     * Behaviour scene after clicking this button. It will change proper scene with saving previous scene to later
     * getting back to city view.
     */
    private void btnRegArmory(){
        btnArmory.setOnMouseClicked(click->{
            getSceneManager().setBackStage(SceneNameEquivalent.sceneEnumName.CITY);
            Stage market = (Stage) btnArmory.getScene().getWindow();
            getSceneManager().sceneChangeInit(market, getSceneManager().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.ARMORY), getPaneScene());
        });
    }

    /**
     * Behaviour scene after clicking this button. It will change proper scene with saving previous scene to later
     * getting back to city view.
     */
    private void btnRegMarket(){
        btnMarket.setOnMouseClicked(click->{
            getSceneManager().setBackStage(SceneNameEquivalent.sceneEnumName.CITY);
            Stage market = (Stage) btnMarket.getScene().getWindow();
            getSceneManager().sceneChangeInit(market, getSceneManager().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.MARKET), getPaneScene());
        });
    }

    /**
     * Behaviour scene after clicking this button. It will change proper scene with saving previous scene to later
     * getting back to city view.
     */
    private void btnRegTavern(){
        btnTavern.setOnMouseClicked(click->{
            getSceneManager().setBackStage(SceneNameEquivalent.sceneEnumName.CITY);
            Stage tavern = (Stage) btnTavern.getScene().getWindow();
            getSceneManager().sceneChangeInit(tavern, getSceneManager().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.TAVERN), getPaneScene());
        });
    }

    /**
     * Behaviour scene after clicking this button. It will change proper scene with saving previous scene to later
     * getting back to city view.
     */
    private void btnRegBack(){
        btnBack.setOnMouseClicked(click->{
            Stage worldMap = (Stage) btnBack.getScene().getWindow();
            getSceneManager().sceneChangeInit(worldMap, getSceneManager().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.WORLD_MAP), getPaneScene());
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
        btnArmory.setVisible(false);
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
        btnArmory.setVisible(true);
        btnTavern.setVisible(true);
        btnBack.setVisible(true);
        lblUpperText.setWrapText(true);
        lblTitle.setText(CurrentScene.getInstance().getCityManager().convertCityNameToString(
                CurrentScene.getInstance().getCurrentCity().getCityName()));
        btnMarket.setGraphic(new ImageView(new Image("img/cities/Market.png")));
        btnSmith.setGraphic(new ImageView(new Image("img/cities/Smith.png")));
        btnArmory.setGraphic(new ImageView(new Image("img/cities/Armory.png")));
        btnTavern.setGraphic(new ImageView(new Image("img/cities/Tavern.png")));
        setBackgroundImage(new Image("img/cities/CityRoyal.png"));
        ivBackGround.setImage(getBackgroundImage());
        ivBackGround.fitWidthProperty().setValue(getBackgroundImage().getWidth());
        ivBackGround.fitHeightProperty().setValue(getBackgroundImage().getHeight());
        updateShipBackgroundView();
        lblUpperText.setText("Hello capitan, just indicate what you want to do by clicking");
    }
}
