package pl.mareksowa.models.managers.services;
/**
 * Imports section
 */
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
@Service
public class SceneManagerImpl implements SceneManager {
    /**
     * Variables declarations
     */
    public SceneNameEquivalent.sceneEnumName backStage;
    private SceneNameEquivalent sceneNameEquivalent;
    private GameTime gameTime;
    private int lastDayInVisitedCity;

    private SceneManagerImpl(){
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
}
