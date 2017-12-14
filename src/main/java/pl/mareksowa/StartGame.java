package pl.mareksowa;

/**
 * Imports section
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.mareksowa.models.CurrentScene;
import pl.mareksowa.models.SceneNameEquivalent;

/**
 * Game initializator
 */
public class StartGame extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(
        CurrentScene.getInstance().getSceneManager().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.START_PAGE)));
        //primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Unknown Seas v0.4a");
        primaryStage.setScene(new Scene(root, 800, 640));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
