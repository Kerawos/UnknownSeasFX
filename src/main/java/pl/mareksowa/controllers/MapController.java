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
import pl.mareksowa.models.CurrentScene;
import pl.mareksowa.models.SceneNameEquivalent;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.maps.MapPosition;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Control world map in this game. Managing player moving and entering to locations.
 */
@Component
public class MapController extends PlayerShipController implements Initializable {

    /**
     * Variables declarations
     */
    @FXML private ImageView ivPlayerCurrentPosition;
    @FXML private ImageView ivBackGround;
    @FXML private ImageView ivField1GothShai;
    @FXML private ImageView ivField2;
    @FXML private ImageView ivField3;
    @FXML private ImageView ivField4Masumba;
    @FXML private ImageView ivField5;
    @FXML private ImageView ivField6MilaDoce;
    @FXML private ImageView ivField7;
    @FXML private ImageView ivField8;
    @FXML private ImageView ivField9;
    @FXML private ImageView ivField10Balados;
    @FXML private ImageView ivField11;
    @FXML private ImageView ivField12;
    @FXML private ImageView ivField13;
    @FXML private ImageView ivField14Centeros;
    @FXML private ImageView ivField15;
    @FXML private ImageView ivField16;
    @FXML private ImageView ivField17Zihlu;
    @FXML private Button btnMainMenu;
    @FXML private Button btnMapInfo;
    @FXML private Label lblGameTime;
    @FXML private Label lblMovePoints;


    private Image bgPlayerShipOnMap;
    private Image bgMapImage;
    private Image indicatorGreen;
    private Image indicatorYellow;
    private Image indicatorRed;

    private boolean sceneLoaded;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imgLoader();
        updateScene();
        buttonsRegister();
        showTutorial();
    }

    private void imgLoader(){
        bgPlayerShipOnMap = new Image("img/ships/PlayerShipOnMap.png");
        bgMapImage = new Image("img/maps/Map.png");
        indicatorGreen = new Image("img/maps/MapGreen.png");
        indicatorYellow = new Image("img/maps/MapYellow.png");
        indicatorRed = new Image("img/maps/MapRed.png");
    }

    /**
     * Method to inform new user about template possibilities. What is allowed, what not, what is here to do etc.
     */
    private void showTutorial(){
        if (!getShipPlayerCurrent().getAchievement().isFirstTimeInWorldMap()){
            //todo show info about world map
            System.out.println("show info about world map");
            getShipPlayerCurrent().getAchievement().setFirstTimeInWorldMap(true);
        }
    }

    /**
     * Method to refresh scene after each action
     */
    private void updateScene(){
        updateAllViews();
        updatePlayerShip(getShipPlayerCurrent());
        updatePlayerShipPosition();
        if (isEndOfDay()){
            checkEncounter();
            updateDayEnd();
        }
    }

    private boolean isEndOfDay(){
        return getShipMovementManager().getRemainShipMove(getShipPlayerCurrent())<1? true : false;
    }

    private void updateDayEnd(){
        int x;
        List<Crew> rebellions = getShipCrewManager().feedCrew(getShipPlayerCurrent());
        x = rebellions.size();
        if (x>0){
            List<Good> goodsLost = getShipPlayerCurrent().getStorage();
            goodsLost.sort(Good::compareTo);
            getShipCrewManager().crewRebellion(getShipPlayerCurrent(), rebellions, goodsLost);
        }

    }

    private void checkEncounter(){
        CurrentScene.getInstance().getSceneManager().setGameTime(+1);
        getShipMovementManager().refreshShipMove(getShipPlayerCurrent());
        Stage encounter = (Stage) btnMainMenu.getScene().getWindow();
        getSceneManager().sceneChangeInit(encounter, getSceneManager().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.ENCOUNTER), getPaneScene());
    }

    private void disableAllViews(){

    }

    /**
     * Method updating every label, image, button etc after each action
     */
    private void updateAllViews(){
        ivBackGround.setImage(bgMapImage);
        updateFieldIndicatorView();
        updateShipBackgroundView();
        lblGameTime.setText("Day: " + CurrentScene.getInstance().getSceneManager().getGameTime().getDay());
        lblMovePoints.setText("Move left: " + getShipMovementManager().getRemainShipMove(getShipPlayerCurrent()));
    }

    private void updateMovePoints(){
        if (getShipMovementManager().canShipMove(getShipPlayerCurrent(), 1)){
            getShipMovementManager().updateShipMove(getShipPlayerCurrent(), 1);
        }
    }

    /**
     * Method managing displaying proper field indicators, their colors and possible getShipMovementManager()s
     */
    private void updateFieldIndicatorView(){
        ivField1GothShai.setImage(indicatorRed);
        ivField2.setImage(indicatorRed);
        ivField3.setImage(indicatorRed);
        ivField4Masumba.setImage(indicatorYellow);
        ivField5.setImage(indicatorYellow);
        ivField6MilaDoce.setImage(indicatorGreen);
        ivField7.setImage(indicatorYellow);
        ivField8.setImage(indicatorYellow);
        ivField9.setImage(indicatorYellow);
        ivField10Balados.setImage(indicatorYellow);
        ivField11.setImage(indicatorRed);
        ivField12.setImage(indicatorRed);
        ivField13.setImage(indicatorGreen);
        ivField14Centeros.setImage(indicatorGreen);
        ivField15.setImage(indicatorGreen);
        ivField16.setImage(indicatorGreen);
        ivField17Zihlu.setImage(indicatorGreen);
    }

    /**
     * Method to managing all buttons and their actions
     */
    private void buttonsRegister(){
        ivRegField1GothShai();
        ivRegField2();
        ivRegField3();
        ivRegField4Masumba();
        ivRegField5();
        ivRegField6MilaDoce();
        ivRegField7();
        ivRegField8();
        ivRegField9();
        ivRegField10Balados();
        ivRegField11();
        ivRegField12();
        ivRegField13();
        ivRegField14Centeros();
        ivRegField15();
        ivRegField16();
        ivRegField17Zihlu();
        btnRegMainMenu();
        btnRegMapInfo();
    }

    /**
     * Method managing field on the map clicking
     */

    private void ivRegField1GothShai(){
        ivField1GothShai.setOnMouseClicked(click-> {
            enterCity(getCityManager().getAllCities().get(0));
            shipGetShipMovementManager(getShipMovementManager().getPositionField1());
        });
    }

    private void ivRegField2(){
        ivField2.setOnMouseClicked(click-> shipGetShipMovementManager(getShipMovementManager().getPositionField2()));
    }
    private void ivRegField3(){
        ivField3.setOnMouseClicked(click-> shipGetShipMovementManager(getShipMovementManager().getPositionField3()));
    }

    private void ivRegField4Masumba(){
        ivField4Masumba.setOnMouseClicked(click-> {
            enterCity(getCityManager().getAllCities().get(1));
            shipGetShipMovementManager(getShipMovementManager().getPositionField4());
        });
    }

    private void ivRegField5(){
        ivField5.setOnMouseClicked(click-> shipGetShipMovementManager(getShipMovementManager().getPositionField5()));
    }

    private void ivRegField6MilaDoce(){
        ivField6MilaDoce.setOnMouseClicked(click-> {
            enterCity(getCityManager().getAllCities().get(2));
            shipGetShipMovementManager(getShipMovementManager().getPositionField6());
        });
    }

    private void ivRegField7(){
        ivField7.setOnMouseClicked(click-> shipGetShipMovementManager(getShipMovementManager().getPositionField7()));
    }

    private void ivRegField8(){
        ivField8.setOnMouseClicked(click-> shipGetShipMovementManager(getShipMovementManager().getPositionField8()));
    }

    private void ivRegField9(){
        ivField9.setOnMouseClicked(click-> shipGetShipMovementManager(getShipMovementManager().getPositionField9()));
    }

    private void ivRegField10Balados(){
        ivField10Balados.setOnMouseClicked(click-> {
            enterCity(getCityManager().getAllCities().get(3));
            shipGetShipMovementManager(getShipMovementManager().getPositionField10());
        });
    }

    private void ivRegField11(){
        ivField11.setOnMouseClicked(click-> shipGetShipMovementManager(getShipMovementManager().getPositionField11()));
    }

    private void ivRegField12(){
        ivField12.setOnMouseClicked(click-> shipGetShipMovementManager(getShipMovementManager().getPositionField12()));
    }

    private void ivRegField13(){
        ivField13.setOnMouseClicked(click-> shipGetShipMovementManager(getShipMovementManager().getPositionField13()));
    }

    private void ivRegField14Centeros(){
        ivField14Centeros.setOnMouseClicked(click-> {
            enterCity(getCityManager().getAllCities().get(4));
            shipGetShipMovementManager(getShipMovementManager().getPositionField14());
                });

    }

    private void ivRegField15(){
        ivField15.setOnMouseClicked(click-> shipGetShipMovementManager(getShipMovementManager().getPositionField15()));
    }

    private void ivRegField16(){
        ivField16.setOnMouseClicked(click-> shipGetShipMovementManager(getShipMovementManager().getPositionField16()));
    }

    private void ivRegField17Zihlu(){
        ivField17Zihlu.setOnMouseClicked(click-> {
            enterCity(getCityManager().getAllCities().get(5));
            shipGetShipMovementManager(getShipMovementManager().getPositionField17());
        });
    }

    private void shipGetShipMovementManager(MapPosition destination){
        if (getShipMovementManager().isMoveAllowed(getShipMovementManager().getShipPosition(getShipPlayerCurrent()), destination)
                && getShipMovementManager().canShipMove(getShipPlayerCurrent(), 1)){
            getShipMovementManager().moveShipTo(getShipPlayerCurrent(), destination, ivPlayerCurrentPosition);
            updateMovePoints();
            updateScene();
        }
    }

    private void enterCity(City city){
        if (getShipMovementManager().isEnterCityAllowed(getShipPlayerCurrent().getMapPosition(), city.getCityPosition())){
            CurrentScene.getInstance().setCurrentCity(city);
            if (getSceneManager().getLastDayInVisitedCity()!=getSceneManager().getGameTime().getDay()){
                getCityManager().updateCityGoods(CurrentScene.getInstance().getCurrentCity());
                getCityManager().updateCityCrewTavern(CurrentScene.getInstance().getCurrentCity());
            }
            Stage cityStage = (Stage) btnMainMenu.getScene().getWindow();
            getSceneManager().sceneChangeInit(cityStage, getSceneManager().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.CITY), getPaneScene());
        }
    }

    private void btnRegMapInfo(){
        btnMapInfo.setOnMouseClicked(click-> System.out.println("map info clicked"));
    }

    private void btnRegMainMenu(){
        btnMainMenu.setOnMouseClicked(click-> System.out.println("main menu clicked"));
    }

    private void updatePlayerShipPosition(){
        if (!sceneLoaded){
            ivPlayerCurrentPosition.setImage(bgPlayerShipOnMap);
            if (!getShipPlayerCurrent().getAchievement().isFirstTimeInWorldMap()){
                getShipMovementManager().moveShipToFast(getShipPlayerCurrent(), getShipMovementManager().getPositionField14(), ivPlayerCurrentPosition);
            } else {
                getShipMovementManager().moveShipToFast(getShipPlayerCurrent(), getShipPlayerCurrent().getMapPosition(), ivPlayerCurrentPosition);
            }
            sceneLoaded = true;
        }
    }

}
