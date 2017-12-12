package pl.mareksowa.controllers;

/**
 * Imports
 */

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ArmoryController extends PlayerShipController implements Initializable{

    /**
     * Initializator
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScene();
        buttonsRegister();
    }

    /**
     * Method to inform new user about template possibilities. What is allowed, what not, what is here to do etc.
     */
    private void showTutorial(){
        if (getPLAYER_SHIP().getAchievement().isFirstTimeInArmory()){
            //todo show info about city armory
            System.out.println("show info about city armory");
            getPLAYER_SHIP().getAchievement().setFirstTimeInArmory(true);
        }
    }

    /**
     * Update this scene after any changes. Started from refresh every views, disable and turn on everything to prevent
     * glitches. Enable only necessary functions to user. At the end update player ship.
     */
    private void updateScene(){
        updateArmoryView();
        updatePlayerShip(getPLAYER_SHIP());
    }

    /**
     * Method hide all FX functionality before showing results. To prevent of 'glitches' or 'duplicates' causing
     * from time to time by java FX.
     */
    private void updateArmoryView(){
        updateShipBackgroundView();
    }

    /**
     * Logic of behaviour of all buttons in city scene
     */
    private void buttonsRegister(){

    }
}
