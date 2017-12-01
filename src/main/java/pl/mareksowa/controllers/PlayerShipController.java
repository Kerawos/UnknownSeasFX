package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;

public abstract class PlayerShipController {

    @FXML private Label lblPlayerGold;
    @FXML private Label lblPlayerFood;
    @FXML private Label lblPlayerAmmo;

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

    public Label getLblPlayerGold() {
        return lblPlayerGold;
    }

    public void setLblPlayerGold(Label lblPlayerGold) {
        this.lblPlayerGold = lblPlayerGold;
    }

    public Label getLblPlayerFood() {
        return lblPlayerFood;
    }

    public void setLblPlayerFood(Label lblPlayerFood) {
        this.lblPlayerFood = lblPlayerFood;
    }

    public Label getLblPlayerAmmo() {
        return lblPlayerAmmo;
    }

    public void setLblPlayerAmmo(Label lblPlayerAmmo) {
        this.lblPlayerAmmo = lblPlayerAmmo;
    }

    public ImageView getIvStorage1() {
        return ivStorage1;
    }

    public void setIvStorage1(ImageView ivStorage1) {
        this.ivStorage1 = ivStorage1;
    }

    public ImageView getIvStorage2() {
        return ivStorage2;
    }

    public void setIvStorage2(ImageView ivStorage2) {
        this.ivStorage2 = ivStorage2;
    }

    public ImageView getIvStorage3() {
        return ivStorage3;
    }

    public void setIvStorage3(ImageView ivStorage3) {
        this.ivStorage3 = ivStorage3;
    }

    public ImageView getIvStorage4() {
        return ivStorage4;
    }

    public void setIvStorage4(ImageView ivStorage4) {
        this.ivStorage4 = ivStorage4;
    }

    public ImageView getIvStorage5() {
        return ivStorage5;
    }

    public void setIvStorage5(ImageView ivStorage5) {
        this.ivStorage5 = ivStorage5;
    }

    public ImageView getIvStorage6() {
        return ivStorage6;
    }

    public void setIvStorage6(ImageView ivStorage6) {
        this.ivStorage6 = ivStorage6;
    }

    public ImageView getIvStorage7() {
        return ivStorage7;
    }

    public void setIvStorage7(ImageView ivStorage7) {
        this.ivStorage7 = ivStorage7;
    }

    public ImageView getIvStorage8() {
        return ivStorage8;
    }

    public void setIvStorage8(ImageView ivStorage8) {
        this.ivStorage8 = ivStorage8;
    }

    public ImageView getIvStorage9() {
        return ivStorage9;
    }

    public void setIvStorage9(ImageView ivStorage9) {
        this.ivStorage9 = ivStorage9;
    }

    public ImageView getIvStorage10() {
        return ivStorage10;
    }

    public void setIvStorage10(ImageView ivStorage10) {
        this.ivStorage10 = ivStorage10;
    }

    public ImageView getIvCrew1() {
        return ivCrew1;
    }

    public void setIvCrew1(ImageView ivCrew1) {
        this.ivCrew1 = ivCrew1;
    }

    public ImageView getIvCrew2() {
        return ivCrew2;
    }

    public void setIvCrew2(ImageView ivCrew2) {
        this.ivCrew2 = ivCrew2;
    }

    public ImageView getIvCrew3() {
        return ivCrew3;
    }

    public void setIvCrew3(ImageView ivCrew3) {
        this.ivCrew3 = ivCrew3;
    }

    public ImageView getIvCrew4() {
        return ivCrew4;
    }

    public void setIvCrew4(ImageView ivCrew4) {
        this.ivCrew4 = ivCrew4;
    }

    public ImageView getIvCrew5() {
        return ivCrew5;
    }

    public void setIvCrew5(ImageView ivCrew5) {
        this.ivCrew5 = ivCrew5;
    }

    public ImageView getIvCrew6() {
        return ivCrew6;
    }

    public void setIvCrew6(ImageView ivCrew6) {
        this.ivCrew6 = ivCrew6;
    }

    public ImageView getIvCrew7() {
        return ivCrew7;
    }

    public void setIvCrew7(ImageView ivCrew7) {
        this.ivCrew7 = ivCrew7;
    }

    public ImageView getIvCrew8() {
        return ivCrew8;
    }

    public void setIvCrew8(ImageView ivCrew8) {
        this.ivCrew8 = ivCrew8;
    }

    public ImageView getIvCrew9() {
        return ivCrew9;
    }

    public void setIvCrew9(ImageView ivCrew9) {
        this.ivCrew9 = ivCrew9;
    }

    public ImageView getIvCrew10() {
        return ivCrew10;
    }

    public void setIvCrew10(ImageView ivCrew10) {
        this.ivCrew10 = ivCrew10;
    }

    public ImageView getIvCannon1() {
        return ivCannon1;
    }

    public void setIvCannon1(ImageView ivCannon1) {
        this.ivCannon1 = ivCannon1;
    }

    public ImageView getIvCannon2() {
        return ivCannon2;
    }

    public void setIvCannon2(ImageView ivCannon2) {
        this.ivCannon2 = ivCannon2;
    }

    public ImageView getIvCannon3() {
        return ivCannon3;
    }

    public void setIvCannon3(ImageView ivCannon3) {
        this.ivCannon3 = ivCannon3;
    }

    public ImageView getIvCannon4() {
        return ivCannon4;
    }

    public void setIvCannon4(ImageView ivCannon4) {
        this.ivCannon4 = ivCannon4;
    }

    public ImageView getIvCannon5() {
        return ivCannon5;
    }

    public void setIvCannon5(ImageView ivCannon5) {
        this.ivCannon5 = ivCannon5;
    }

    public ImageView getIvCannon6() {
        return ivCannon6;
    }

    public void setIvCannon6(ImageView ivCannon6) {
        this.ivCannon6 = ivCannon6;
    }

    public ImageView getIvCannon7() {
        return ivCannon7;
    }

    public void setIvCannon7(ImageView ivCannon7) {
        this.ivCannon7 = ivCannon7;
    }

    public ImageView getIvCannon8() {
        return ivCannon8;
    }

    public void setIvCannon8(ImageView ivCannon8) {
        this.ivCannon8 = ivCannon8;
    }

    public ImageView getIvCannon9() {
        return ivCannon9;
    }

    public void setIvCannon9(ImageView ivCannon9) {
        this.ivCannon9 = ivCannon9;
    }

    public ImageView getIvCannon10() {
        return ivCannon10;
    }

    public void setIvCannon10(ImageView ivCannon10) {
        this.ivCannon10 = ivCannon10;
    }

    public ImageView getIvSail1() {
        return ivSail1;
    }

    public void setIvSail1(ImageView ivSail1) {
        this.ivSail1 = ivSail1;
    }

    public ImageView getIvSail2() {
        return ivSail2;
    }

    public void setIvSail2(ImageView ivSail2) {
        this.ivSail2 = ivSail2;
    }

    public ImageView getIvSail3() {
        return ivSail3;
    }

    public void setIvSail3(ImageView ivSail3) {
        this.ivSail3 = ivSail3;
    }

    public ImageView getIvSail4() {
        return ivSail4;
    }

    public void setIvSail4(ImageView ivSail4) {
        this.ivSail4 = ivSail4;
    }

    public ImageView getIvSail5() {
        return ivSail5;
    }

    public void setIvSail5(ImageView ivSail5) {
        this.ivSail5 = ivSail5;
    }

    public ImageView getIvSail6() {
        return ivSail6;
    }

    public void setIvSail6(ImageView ivSail6) {
        this.ivSail6 = ivSail6;
    }

    public ImageView getIvSail7() {
        return ivSail7;
    }

    public void setIvSail7(ImageView ivSail7) {
        this.ivSail7 = ivSail7;
    }

    public ImageView getIvSail8() {
        return ivSail8;
    }

    public void setIvSail8(ImageView ivSail8) {
        this.ivSail8 = ivSail8;
    }

    public ImageView getIvSail9() {
        return ivSail9;
    }

    public void setIvSail9(ImageView ivSail9) {
        this.ivSail9 = ivSail9;
    }

    public ImageView getIvSail10() {
        return ivSail10;
    }

    public void setIvSail10(ImageView ivSail10) {
        this.ivSail10 = ivSail10;
    }

    public Label getLblPlayerHp() {
        return lblPlayerHp;
    }

    public void setLblPlayerHp(Label lblPlayerHp) {
        this.lblPlayerHp = lblPlayerHp;
    }

    public ProgressBar getPbShipHp() {
        return pbShipHp;
    }

    public void setPbShipHp(ProgressBar pbShipHp) {
        this.pbShipHp = pbShipHp;
    }
}
