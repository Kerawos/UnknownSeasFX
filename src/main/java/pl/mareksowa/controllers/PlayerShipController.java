package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.mareksowa.models.SceneManager;
import pl.mareksowa.models.functionalities.ShipFunctionality;
import pl.mareksowa.models.ships.Ship;

public abstract class PlayerShipController {

    private Image backgroundImage;
    private ShipFunctionality shipFun = SceneManager.getInstance().getShipFunctionality();
    private SceneManager scene = SceneManager.getInstance();
    private Ship PLAYER_SHIP = scene.getPLAYER_SHIP();

    @FXML private Label lblPlayerGold;
    @FXML private Label lblPlayerFood;
    @FXML private Label lblPlayerAmmo;

    @FXML private ImageView ivBackGroundShip = new ImageView();
    private Image bgShipImage = new Image("img/BackgroundShip.png");
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

    public void updateShipBackgroundView(){
        ivBackGroundShip.setImage(getBgShipImage());
    }

    public void updatePlayerShip(Ship PLAYER_SHIP){
        updateGold(PLAYER_SHIP);
        updateFood(PLAYER_SHIP);
        updateAmmo(PLAYER_SHIP);
        updateHp(PLAYER_SHIP);
        updateStorage(PLAYER_SHIP);
        updateCrew(PLAYER_SHIP);
        updateSail(PLAYER_SHIP);
        updateCannon(PLAYER_SHIP);
    }

    private void updateGold(Ship PLAYER_SHIP){
        shipFun.updateGold(PLAYER_SHIP, getLblPlayerGold());
    }

    private void updateFood(Ship PLAYER_SHIP){
        shipFun.updateFood(PLAYER_SHIP, getLblPlayerFood());
    }

    private void updateAmmo(Ship PLAYER_SHIP){
        shipFun.updateAmmo(PLAYER_SHIP, getLblPlayerAmmo());
    }

    private void updateHp(Ship PLAYER_SHIP){
        shipFun.updateHp(PLAYER_SHIP, getLblPlayerHp(), getPbShipHp());
    }

    private void updateStorage(Ship PLAYER_SHIP){
        shipFun.updateStorage(PLAYER_SHIP, getIvStorage1(), getIvStorage2(), getIvStorage3(), getIvStorage4(), getIvStorage5(),
                getIvStorage6(), getIvStorage7(), getIvStorage8(), getIvStorage9(), getIvStorage10());
    }

    private void updateCrew(Ship PLAYER_SHIP){
        shipFun.updateCrew(PLAYER_SHIP, getIvCrew1(), getIvCrew2(), getIvCrew3(), getIvCrew4(), getIvCrew5(), getIvCrew6(),
                getIvCrew7(), getIvCrew8(),getIvCrew9(), getIvCrew10());
    }

    private void updateSail(Ship PLAYER_SHIP){
        shipFun.updateSail(PLAYER_SHIP, getIvSail1(), getIvSail2(), getIvSail3(), getIvSail4(), getIvSail5(),
                getIvSail6(), getIvSail7(), getIvSail8(), getIvSail9(), getIvSail10());
    }

    private void updateCannon(Ship PLAYER_SHIP){
        shipFun.updateCannon(PLAYER_SHIP, getIvCannon1(),getIvCannon2(), getIvCannon3(), getIvCannon4(), getIvCannon5(),
                getIvCannon6(), getIvCannon7(), getIvCannon8(), getIvCannon9(), getIvCannon10());
    }

    public Label getLblPlayerGold() {
        return lblPlayerGold;
    }

    public Label getLblPlayerFood() {
        return lblPlayerFood;
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

    public ShipFunctionality getShipFun() {
        return shipFun;
    }

    public SceneManager getScene() {
        return scene;
    }

    public Ship getPLAYER_SHIP() {
        return PLAYER_SHIP;
    }
}
