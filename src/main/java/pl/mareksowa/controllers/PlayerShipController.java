package pl.mareksowa.controllers;
/**
 * Imports section.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import pl.mareksowa.models.CurrentScene;
import pl.mareksowa.models.managers.*;
import pl.mareksowa.models.managers.services.SceneManagerImpl;
import pl.mareksowa.models.ships.Ship;

/**
 * Lot of Controllers will using player ship functionality. Class is shortcut between implementations tons of repeat
 *stuff. Every controller using player ship need extend this controller.
 */
public abstract class PlayerShipController {

    /**
     * some variables have default unchangeable initialization as 'scene'. Only getters for already initiate variables.
     */
    private Image backgroundImage;
    private Image bgShipImage = new Image("img/BackgroundShip.png");
    private Ship shipPlayerCurrent = CurrentScene.getInstance().getShipPlayerCurrent();

    /**
     * Services initialization mainly for children class
     */
    @Autowired private CityManager cityManager;
    @Autowired private SceneManager sceneManager;
    @Autowired private ShipBuilderManager shipBuilderManager;
    @Autowired private ShipCrewManager shipCrewManager;
    @Autowired private ShipGeneralManager shipGeneralManager;
    @Autowired private ShipMovementManager shipMovementManager;
    @Autowired private ShipTradeManager shipTradeManager;

    /**
     * FX declarations
     */
    @FXML private Label lblPlayerGold;
    @FXML private Label lblPlayerFood;
    @FXML private Label lblPlayerAmmo;
    @FXML private Label lblPlayerHp;
    @FXML private Label lblPlayerSpeed;
    @FXML private Label lblPlayerManeuver;
    @FXML private Label lblPlayerPower;
    @FXML private Label lblPlayerCharge;

    @FXML private ProgressBar pbShipHp;

    //todo delete this initialization of image view
    @FXML private ImageView ivBackGroundShip = new ImageView();
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

    /**
     * This method will change current scene background image
     */
    public void updateShipBackgroundView(){
        ivBackGroundShip.setImage(getBgShipImage());
    }

    /**
     * Method will update every changeable variables connected with player ship
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    public void updatePlayerShip(Ship shipPlayer){
        updateGold(shipPlayer);
        updateFood(shipPlayer);
        updateAmmo(shipPlayer);
        updateHp(shipPlayer);
        updateCharge(shipPlayer);
        updatePower(shipPlayer);
        updateSpeed(shipPlayer);
        updateManeuver(shipPlayer);
        updateStorage(shipPlayer);
        updateCrew(shipPlayer);
        updateSail(shipPlayer);
        updateCannon(shipPlayer);
    }

    /**
     * Method will update gold displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updateGold(Ship shipPlayer){
        getShipGeneralManager().updateGold(shipPlayer, getLblPlayerGold());
    }

    /**
     * Method will update food displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updateFood(Ship shipPlayer){
        getShipGeneralManager().updateFood(shipPlayer, getLblPlayerFood());
    }

    /**
     * Method will update ammo displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updateAmmo(Ship shipPlayer){
        getShipGeneralManager().updateAmmo(shipPlayer, getLblPlayerAmmo());
    }

    /**
     * Method will update hit points displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updateHp(Ship shipPlayer){
        getShipGeneralManager().updateHp(shipPlayer, getLblPlayerHp(), getPbShipHp());
    }

    /**
     * Method will update ship power displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updatePower(Ship shipPlayer) {
        getShipGeneralManager().updatePower(shipPlayer, lblPlayerPower);
    }

    /**
     * Method will update crew charge potential displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updateCharge(Ship shipPlayer) {
        getShipGeneralManager().updateCharge(shipPlayer, lblPlayerCharge);
    }

    /**
     * Method will update ship speed displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updateSpeed(Ship shipPlayer){
        getShipGeneralManager().updateSpeed(shipPlayer, lblPlayerSpeed);
    }

    /**
     * Method will update ship speed displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updateManeuver(Ship shipPlayer) {
        getShipGeneralManager().updateManeuver(shipPlayer, lblPlayerManeuver);
    }

    /**
     * Method will update storage of ship displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updateStorage(Ship shipPlayer){
        getShipGeneralManager().updateStorage(shipPlayer, getIvStorage1(), getIvStorage2(), getIvStorage3(), getIvStorage4(),
                getIvStorage5(), getIvStorage6(), getIvStorage7(), getIvStorage8(), getIvStorage9(), getIvStorage10());
    }

    /**
     * Method will update crew of ship displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updateCrew(Ship shipPlayer){
        getShipGeneralManager().updateCrew(shipPlayer, getIvCrew1(), getIvCrew2(), getIvCrew3(), getIvCrew4(), getIvCrew5(),
                getIvCrew6(), getIvCrew7(), getIvCrew8(),getIvCrew9(), getIvCrew10());
    }

    /**
     * Method will update sails of ship displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updateSail(Ship shipPlayer){
        getShipGeneralManager().updateSail(shipPlayer, getIvSail1(), getIvSail2(), getIvSail3(), getIvSail4(), getIvSail5(),
                getIvSail6(), getIvSail7(), getIvSail8(), getIvSail9(), getIvSail10());
    }

    /**
     * Method will update cannons of ship displayed to user.
     * @param shipPlayer indicate which player will be updating. *for later possibility of multiplayer.
     */
    private void updateCannon(Ship shipPlayer){
        getShipGeneralManager().updateCannon(shipPlayer, getIvCannon1(),getIvCannon2(), getIvCannon3(), getIvCannon4(),
                getIvCannon5(), getIvCannon6(), getIvCannon7(), getIvCannon8(), getIvCannon9(), getIvCannon10());
    }

    /**
     * Getters section
     */
    public Label getLblPlayerGold() {
        return lblPlayerGold;
    }

    public Label getLblPlayerFood() {
        return lblPlayerFood;
    }

    public Label getLblPlayerSpeed() {
        return lblPlayerSpeed;
    }

    public Label getLblPlayerPower() {
        return lblPlayerPower;
    }

    public Label getLblPlayerCharge() {
        return lblPlayerCharge;
    }

    public Label getLblPlayerManeuver() {
        return lblPlayerManeuver;
    }

    public Image getBgShipImage() {
        return bgShipImage;
    }

    public ImageView getIvBackGroundShip() {
        return ivBackGroundShip;
    }

    public Label getLblPlayerAmmo() {
        return lblPlayerAmmo;
    }

    public ImageView getIvStorage1() {
        return ivStorage1;
    }

    public ImageView getIvStorage2() {
        return ivStorage2;
    }

    public ImageView getIvStorage3() {
        return ivStorage3;
    }

    public ImageView getIvStorage4() {
        return ivStorage4;
    }

    public ImageView getIvStorage5() {
        return ivStorage5;
    }

    public ImageView getIvStorage6() {
        return ivStorage6;
    }

    public ImageView getIvStorage7() {
        return ivStorage7;
    }

    public ImageView getIvStorage8() {
        return ivStorage8;
    }

    public ImageView getIvStorage9() {
        return ivStorage9;
    }

    public ImageView getIvStorage10() {
        return ivStorage10;
    }

    public ImageView getIvCrew1() {
        return ivCrew1;
    }

    public ImageView getIvCrew2() {
        return ivCrew2;
    }

    public ImageView getIvCrew3() {
        return ivCrew3;
    }

    public ImageView getIvCrew4() {
        return ivCrew4;
    }

    public ImageView getIvCrew5() {
        return ivCrew5;
    }

    public ImageView getIvCrew6() {
        return ivCrew6;
    }

    public ImageView getIvCrew7() {
        return ivCrew7;
    }

    public ImageView getIvCrew8() {
        return ivCrew8;
    }

    public ImageView getIvCrew9() {
        return ivCrew9;
    }

    public ImageView getIvCrew10() {
        return ivCrew10;
    }

    public ImageView getIvCannon1() {
        return ivCannon1;
    }

    public ImageView getIvCannon2() {
        return ivCannon2;
    }

    public ImageView getIvCannon3() {
        return ivCannon3;
    }

    public ImageView getIvCannon4() {
        return ivCannon4;
    }

    public ImageView getIvCannon5() {
        return ivCannon5;
    }

    public ImageView getIvCannon6() {
        return ivCannon6;
    }

    public ImageView getIvCannon7() {
        return ivCannon7;
    }

    public ImageView getIvCannon8() {
        return ivCannon8;
    }

    public ImageView getIvCannon9() {
        return ivCannon9;
    }

    public ImageView getIvCannon10() {
        return ivCannon10;
    }

    public ImageView getIvSail1() {
        return ivSail1;
    }

    public ImageView getIvSail2() {
        return ivSail2;
    }

    public ImageView getIvSail3() {
        return ivSail3;
    }

    public ImageView getIvSail4() {
        return ivSail4;
    }

    public ImageView getIvSail5() {
        return ivSail5;
    }

    public ImageView getIvSail6() {
        return ivSail6;
    }

    public ImageView getIvSail7() {
        return ivSail7;
    }

    public ImageView getIvSail8() {
        return ivSail8;
    }

    public ImageView getIvSail9() {
        return ivSail9;
    }

    public ImageView getIvSail10() {
        return ivSail10;
    }

    public Label getLblPlayerHp() {
        return lblPlayerHp;
    }

    public ProgressBar getPbShipHp() {
        return pbShipHp;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Ship getShipPlayerCurrent() {
        return shipPlayerCurrent;
    }

    /**
     * Services getters for children class
     */
    public CityManager getCityManager() {
        return cityManager;
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public ShipBuilderManager getShipBuilderManager() {
        return shipBuilderManager;
    }

    public ShipCrewManager getShipCrewManager() {
        return shipCrewManager;
    }

    public ShipGeneralManager getShipGeneralManager() {
        return shipGeneralManager;
    }

    public ShipMovementManager getShipMovementManager() {
        return shipMovementManager;
    }

    public ShipTradeManager getShipTradeManager() {
        return shipTradeManager;
    }
}
