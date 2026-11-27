package controller;

import controller.abstractions.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Для MVC паттерна
 * переключатель экранов
 */

public class Navigator {
    private final Stage stage;
    private final AppModel model;

    public Navigator(Stage stage, AppModel model){
        this.stage = stage;
        this.model = model;
    }
    public void switchScene(String fxmlPath, String title) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(loader.load());

        BaseController controller = loader.getController();
        if(controller != null){
            controller.setModel(this.model);
            controller.setNavigator(this);
        }

        stage.setTitle(title);
        stage.setScene(scene);
    }
}
