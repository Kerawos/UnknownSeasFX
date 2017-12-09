package pl.mareksowa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.mareksowa.models.SceneManager;
import pl.mareksowa.models.SceneNameEquivalent;

public class StartGame extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(
                SceneManager.getInstance().sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.START_PAGE)));
        //primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Unknown Seas 0.3a");
        primaryStage.setScene(new Scene(root, 800, 640));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
