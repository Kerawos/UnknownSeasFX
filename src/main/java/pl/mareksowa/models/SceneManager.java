package pl.mareksowa.models;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private static SceneManager ourInstance = null;
    public String backStage = null;

    private SceneManager(){
    }

    public static SceneManager getInstance(){
        if (ourInstance==null){
            ourInstance = new SceneManager();
        }
        return ourInstance;
    }

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


    public String getBackStage() {
        return backStage;
    }

    public void setBackStage(String backStage) {
        this.backStage = backStage;
    }

    public static void exitGame(){
        Platform.exit();
        System.exit(1);
    }
}
