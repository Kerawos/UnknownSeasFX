package pl.mareksowa.models.managers.services;
/**
 * Imports section
 */
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.CurrentScene;
import pl.mareksowa.models.GameTime;
import pl.mareksowa.models.SceneNameEquivalent;
import pl.mareksowa.models.managers.SceneManager;

import javax.swing.*;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Singleton class which contain all managers. Holding current scene info, current state of player ship. Calling Scene
 * manager we can change directly scene also manage player ship.
 */

@Repository
public class SceneManagerImpl implements SceneManager {
    /**
     * Variables declarations
     */
    public SceneNameEquivalent.sceneEnumName backStage;
    private SceneNameEquivalent sceneNameEquivalent;
    private GameTime gameTime;
    private int lastDayInVisitedCity;

    public SceneManagerImpl(){
        //todo check if @service will work with private constructor here
        sceneNameEquivalent = new SceneNameEquivalent();
        gameTime = new GameTime();
    }

    @Override
    public void sceneChangeInit(Stage stageName, String sceneName, Pane pane){
        fadePaneAnimationOut(pane, stageName, sceneName);
    }

    @Override
    public void sceneChange(Stage stageName, String sceneName){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(sceneName));
            stageName.setScene(new Scene(root, 800, 640));
            stageName.setOnCloseRequest(stage-> exitGame());
            stageName.setResizable(false);
            stageName.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName enumName){
        for (Map.Entry<Enum, String> element : sceneNameEquivalent.getSceneNameMap().entrySet()){
            if (element.getKey()==enumName){
                return element.getValue();
            }
        }
        throw new IllegalArgumentException("Map does not contain proper enum name yet..");
    }

    @Override
    public void exitGame(){
        Platform.exit();
        System.exit(1);
    }

    @Override
    public SceneNameEquivalent.sceneEnumName getBackStage() {
        return backStage;
    }

    @Override
    public void setBackStage(SceneNameEquivalent.sceneEnumName backStage) {
        this.backStage = backStage;
    }

    @Override
    public GameTime getGameTime() {
        return gameTime;
    }

    @Override
    public void setGameTime(int dayToAdd) {
        this.gameTime.setDay(this.gameTime.getDay() + dayToAdd);
    }

    @Override
    public int getLastDayInVisitedCity() {
        return lastDayInVisitedCity;
    }

    @Override
    public void setLastDayInVisitedCity(int lastDayInVisitedCity) {
        this.lastDayInVisitedCity = lastDayInVisitedCity;
    }

    @Override
    public void fadePaneAnimation(Pane pane, int valueFrom, int valueTo, int durationMillis){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(pane);
        fadeTransition.setFromValue(valueFrom);
        fadeTransition.setToValue(valueTo);
        fadeTransition.setDuration(Duration.millis(durationMillis));
        fadeTransition.play();
    }

    @Override
    public void fadePaneAnimationOut(Pane pane, Stage stageName, String sceneName) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(pane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.3);
        fadeTransition.setDuration(Duration.millis(200));
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneChange(stageName, sceneName);
            }
        });
        fadeTransition.play();
    }

    @Override
    public void fadePaneAnimationIn(Pane pane) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(pane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setDuration(Duration.millis(800));
        fadeTransition.play();
    }

    @Override
    public void updateDay(Pane pane) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(400), pane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        fadeTransition.setOnFinished(event -> {
            System.out.println("dupa");
            FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(100), pane);
            fadeTransition2.setFromValue(1);
            fadeTransition2.setToValue(0.3);
            fadeTransition2.setCycleCount(2);
            fadeTransition2.setAutoReverse(true);
            fadeTransition2.play();
        });
    }

}
