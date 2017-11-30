package pl.mareksowa.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.mareksowa.models.ships.Ship;
import pl.mareksowa.models.ships.dao.impl.ShipDaoImpl;

import java.io.IOException;
import java.util.List;

public class Menu {

    public String cityName;
    public Ship PLAYER0 = ShipDaoImpl.getInstance().getAllShips().get(0);

    private static Menu ourInstance = new Menu();

    public static Menu getInstance(){
        return ourInstance;
    }

    private Menu(){

    }


    public void exitGame(){
        Platform.exit();
        System.exit(0);
    }

    public void sceneChange(Stage stageName, String sceneName){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(sceneName));
            stageName.setScene(new Scene(root, 800, 640));
            stageName.setResizable(false);
            stageName.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    public void updateGold(Label lblPlayerGold){
        lblPlayerGold.setText(String.valueOf(PLAYER0.getGold()));
    }

    public void updateFood(Label lblPlayerFood){
        lblPlayerFood.setText(String.valueOf(PLAYER0.getFood()));
    }

    public void updateAmmo(Label lblPlayerAmmo){
        lblPlayerAmmo.setText(String.valueOf(PLAYER0.getAmmo()));
    }

    public void updateHp(Label lblPlayerHp, ProgressBar pbShipHp){
        int maxHp = PLAYER0.getEndurance();
        int curHp = PLAYER0.getCurrentEndurance();
        pbShipHp.setProgress((curHp*100)/maxHp);
        lblPlayerHp.setText(""+(curHp*100)/maxHp);
    }

    public void updateStorage(ImageView ... storages ){
//        System.out.println("wielkosc magazynowa = " + PLAYER0.getStorageCapacity());
//        System.out.println("wielkosc storages = " + storages.length);
        for (int i = 0; i < PLAYER0.getStorageCapacity(); i++) {
            storages[i].setImage(new Image("img/StorageEmpty.png"));
            //System.out.println("tutaj powienien dodac pierwszy obrazaek");
            if (PLAYER0.getStorage().size()>0 ||
                    PLAYER0.getStorage().size()>i){
                //System.out.println("z kolei tutaj jakbysmy mieli jakies dobra");
                /// TODO: 06.11.2017 adding proper good
            }
        }
    }


    public void updateCrew(ImageView ... crews){
        //System.out.println("wielkosc zalogowego miejsca = " + PLAYER0.getStorageCapacity());
        //System.out.println("wielkosc zalogowych labeli = " + crews.length);
        for (int i = 0; i < PLAYER0.getCabinCapacity(); i++) {
            crews[i].setImage(new Image("img/CrewEmpty.png"));
            //System.out.println("tutaj powienien dodac pierwszy obrazaek crew");
            if (PLAYER0.getCrewList().size()>0 ||
                    PLAYER0.getCrewList().size()>i){
                //System.out.println("z kolei tutaj jakbysmy mieli jakias zaloge");
                /// TODO: 06.11.2017 adding proper good
            }
        }
        /// TODO: 06.11.2017
    }

    public void updateSail(ImageView ... sails){
        //System.out.println("wielkosc miejsca na zagle = " + PLAYER0.getSailCapacity());
        //System.out.println("wielkosc zaglowych labeli = " + sails.length);
        for (int i = 0; i < PLAYER0.getSailCapacity(); i++) {
            sails[i].setImage(new Image("img/SailEmpty.png"));
            //System.out.println("tutaj powienien dodac pierwszy obrazaek sail");
            if (PLAYER0.getSailList().size()>0 ||
                    PLAYER0.getSailList().size()>i){
                //System.out.println("z kolei tutaj jakbysmy mieli jakias zagiel");
                /// TODO: 06.11.2017 adding proper good
            }
        }
        /// TODO: 06.11.2017
    }

    public void updateCannon(ImageView ... cannons){
        //System.out.println("wielkosc armatniego miejsca = " + PLAYER0.getCannonCapacity());
        //System.out.println("wielkosc armatnich labeli = " + cannons.length);
        for (int i = 0; i < PLAYER0.getCannonCapacity(); i++) {
            cannons[i].setImage(new Image("img/CannonEmpty.png"));
            //System.out.println("tutaj powienien dodac pierwszy obrazaek cannon");
            if (PLAYER0.getCannonList().size()>0 ||
                    PLAYER0.getCannonList().size()>i){
                //System.out.println("z kolei tutaj jakbysmy mieli jakias cannon");
                /// TODO: 06.11.2017 adding proper good
            }
        }
        /// TODO: 06.11.2017
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
