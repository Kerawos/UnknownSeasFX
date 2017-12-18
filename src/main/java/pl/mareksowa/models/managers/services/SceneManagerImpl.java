package pl.mareksowa.models.managers.services;
/**
 * Imports section
 */
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.GameTime;
import pl.mareksowa.models.SceneNameEquivalent;
import pl.mareksowa.models.managers.SceneManager;

import java.io.IOException;
import java.util.Map;

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
    public void fadeOut(Pane pane) {
        fadePaneAnimation(pane, 1, 0, 500);
    }

    @Override
    public void fadeIn(Pane pane) {
        fadePaneAnimation(pane, 0, 1, 500);
    }
}
