package pl.mareksowa.models.managers;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.GameTime;
import pl.mareksowa.models.SceneNameEquivalent;

@Service
public interface SceneManager {

    /**
     * Basic method to change scene from one to another
     * @param stageName name for scene.
     * @param sceneName real name of fxml file holding scene view.
     */
    void sceneChange(Stage stageName, String sceneName);

    /**
     * Method allowed find proper scene name as string inputed predefined enum scene name. Condition: map scene names
     * must be predefined earlier.
     * @param enumName predefined enum scene name
     * @return predefined already existed scene name as a string
     */
    String sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName enumName);

    /**
     * Method allowing exit program.
     */
    void exitGame();

    SceneNameEquivalent.sceneEnumName getBackStage();

    void setBackStage(SceneNameEquivalent.sceneEnumName backStage);

    GameTime getGameTime();

    void setGameTime(int dayToAdd);

    int getLastDayInVisitedCity();

    void setLastDayInVisitedCity(int lastDayInVisitedCity);

    /**
     * Method to get some simple animation between change scene
     * @param pane
     * @param valueFrom
     * @param valueTo
     * @param durationMillis
     */
    void fadePaneAnimation(Pane pane, int valueFrom, int valueTo, int durationMillis);

    /**
     * Method generating simple out scene animation
     * @param pane
     */
    void fadeOut(Pane pane);

    /**
     * Method generating simple in scene animation
     * @param pane
     */
    void fadeIn(Pane pane);
}
