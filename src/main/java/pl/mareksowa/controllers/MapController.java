package pl.mareksowa.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController extends PlayerShipController implements Initializable {

    @FXML private ImageView ivMasumba;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        updateScene();
        buttonsRegister();
    }

    private void updateScene(){

    }

    private void buttonsRegister(){
        ivRegMasumba();
    }

    private void ivRegMasumba(){
        ivMasumba.setOnMouseClicked(click->{
            System.out.println("masumba clicked");
        });
    }
}
